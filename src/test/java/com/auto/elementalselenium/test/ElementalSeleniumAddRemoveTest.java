package com.auto.elementalselenium.test;

import com.auto.elementalselenium.ElementalSeleniumBasePage;
import com.auto.saucelab.page.browser.BrowserObject;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Random;

import static com.auto.elementalselenium.ElementalSeleniumBasePage.extent;

public class ElementalSeleniumAddRemoveTest {


  ElementalSeleniumBasePage basePage ;
  WebDriver driver;

  @BeforeTest
  public void setupAll(){


         BrowserObject.setUpDriver();
         driver=BrowserObject.getDriver();
         basePage = new ElementalSeleniumBasePage(driver);
     basePage.test = extent.startTest("ElementalSeleniumAddRemoveTest");

  }

  @Test
  public void tc1_addRemoveTest(){

    basePage.getUrl();

    basePage.clickOnElementAddRemoveElements();


      for (int i = 0; i < new Random().nextInt(0,10); i++) {
        basePage.clickonAddElementButton();
      }
    basePage.takeScreenShot("tc1_addRemoveTest");

  }

    @Test
    public void tc2_addRemoveTest(){



        basePage.clickonDeleteButton();
       basePage.takeScreenShot("tc2_addRemoveTest");

    }




  @AfterMethod
  private void saveExecutionResults(ITestResult result){

      if (result.getStatus() == ITestResult.FAILURE) {
        basePage.test.log(LogStatus.FAIL, result.getThrowable());
      } else if (result.getStatus() == ITestResult.SKIP) {
        basePage.test.log(LogStatus.SKIP, result.getName() + " Skipped " + result.getThrowable());
      } else {
        basePage.test.log(LogStatus.PASS, result.getName() + " Passed");
      }
      extent.endTest(basePage.test);

  }
  @AfterTest
  public void closeAll(){

    basePage.afterClass();

  }


}
