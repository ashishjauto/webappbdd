package com.auto.elementalselenium.test;

import com.auto.elementalselenium.ElementalSeleniumBasePage;
import com.auto.saucelab.page.browser.BrowserObject;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

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
  public void addRemoveTest(){

    basePage.getUrl();
    basePage.clickOnElementAddRemoveElements();
    basePage.takeScreenShot("removettest");

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
