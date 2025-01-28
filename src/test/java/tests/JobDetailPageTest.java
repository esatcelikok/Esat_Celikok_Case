package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import utility.ConfigReader;

public class JobDetailPageTest  extends TestBase {


    @Test
 public void test(){

      getPageLibrary().getJobDetailPage().gotoDetailPage();

      Assert.assertEquals(getElementLibrary().getJobDetailPageElements().PositionTitle.getText(),
              "Senior Software Quality Assurance Engineer");

      Assert.assertTrue(isClickable(getElementLibrary().getJobDetailPageElements().ApplyjobBtn));


    }
}
