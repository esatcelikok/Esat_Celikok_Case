package pages;

import com.sun.source.tree.WhileLoopTree;

import java.util.*;
import java.util.stream.IntStream;

public class CareersPage extends PageBase {

    public List<Map<String, String>> CountryCapitalMatch() {

        List<Map<String, String>> CountyCapitalMatch = new ArrayList<>();
        int cardsize = getElementLibrary().getCareersPageElements().cards.size();
        IntStream.range(0, cardsize).forEach(i -> {
            Map<String, String> Cardcheckmap = new LinkedHashMap<>();
            Cardcheckmap.put(getElementLibrary().
                    getCareersPageElements().cardsCapital.get(i).getText(), getElementLibrary().
                    getCareersPageElements().cardsCountry.get(i).getText());

       hoverOver(getElementLibrary().getCareersPageElements().cards.get(i),
                    800);
            CountyCapitalMatch.add(Cardcheckmap);
            clickElement(getElementLibrary().
                    getCareersPageElements().nextbottun);
        });
        return CountyCapitalMatch;

    }

    public List<Boolean> SwiperAutoSlideCheck() {

        List<Boolean> result = new ArrayList<>();

        try {

            for (int i = 0; i < 4; i++) {
                String previmgurl = getImageUrl(getElementLibrary().getCareersPageElements().activeslideimage);
                System.out.println("prev:"   +previmgurl);
                Thread.sleep(5000);

                String currentimgurl = getImageUrl(getElementLibrary().getCareersPageElements().activeslideimage);
                if (!previmgurl.equals(currentimgurl)) {
                    System.out.println("current:"  +currentimgurl);
                    result.add(true);
                } else {

                    result.add(false);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
return result;
    }
}