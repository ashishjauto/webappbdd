package com.auto.elementalselenium.test;

import com.auto.elementalselenium.ElementalSeleniumBasePage;
import com.auto.saucelab.page.browser.BrowserObject;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import static com.auto.elementalselenium.ElementalSeleniumBasePage.extent;

public class ElementalSeleniumCheckBoxesTest {


    ElementalSeleniumBasePage basePage ;
    WebDriver driver;

    @BeforeClass
    public void setupAll(){


        BrowserObject.setUpDriver();
        driver=BrowserObject.getDriver();
        basePage = new ElementalSeleniumBasePage(driver);
        basePage.test = extent.startTest("ElementalSeleniumCheckBoxesTest");

    }

    @Test
    public void tc1_clickonCheckBoxesLink(){

        basePage.getUrl();

        basePage.clickonCheckBoxes();



        basePage.takeScreenShot("tc1_clickonCheckBoxesLink");

    }

    @Test
    public void tc2_clickCheckBoxes(){

        basePage.clickonCheckBox();


        basePage.takeScreenShot("tc2_clickCheckBoxes");


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
    @AfterClass
    public void closeAll(){

        basePage.afterClass();
        BrowserObject.tearDown();

    }
}
