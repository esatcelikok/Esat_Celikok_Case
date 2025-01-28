package utility;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConfigReader {
    private static Properties configFile = new Properties();
    // Lock for thread safety
    private static final Lock lock = new ReentrantLock();
    // Default config path
    private static final String DEFAULT_CONFIG_PATH = "configuration.properties";

    static {
        loadDefaultProperties(DEFAULT_CONFIG_PATH);
        overrideWithEnvironmentSpecificProperties();
    }

    private static void loadDefaultProperties(String filePath) {
        lock.lock();
        try {
            if (Files.exists(Paths.get(filePath))) {
                try (InputStream input = new FileInputStream(filePath)) {
                    configFile.load(input);
                }
            } else {
                throw new RuntimeException("Unable to find default configuration file: " + filePath);
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to load default configuration file: " + filePath, e);
        } finally {
            lock.unlock();
        }
    }

    private static void loadPropertiesFromClasspath(String resourcePath) {
        lock.lock();
        try (InputStream input = ConfigReader.class.getClassLoader().getResourceAsStream(resourcePath)) {
            if (input == null) {
                System.out.println("Environment-specific configuration file not found: " + resourcePath);
                return; // Don't throw an exception to allow the application to work with default configs
            }
            configFile.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load configuration from classpath: " + resourcePath, e);
        } finally {
            lock.unlock();
        }
    }

    private static void overrideWithEnvironmentSpecificProperties() {
        String environment = System.getProperty("env"); // No default value here

        if (environment != null && !environment.trim().isEmpty()) {
            String envPath = environment + ".properties";
            loadPropertiesFromClasspath(envPath);
        }
    }

    public static String getProperty(String key) {
        lock.lock();
        try {
            return configFile.getProperty(key);
        } finally {
            lock.unlock();
        }
    }
}
