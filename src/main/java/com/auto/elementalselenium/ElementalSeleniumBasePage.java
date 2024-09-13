package com.auto.elementalselenium;

import com.auto.report.ExtentReportManager;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class ElementalSeleniumBasePage {

    public static ExtentReports extent;
    public static ExtentTest test;


    WebDriver driver;
    private String  elementalSeleniumURL="https://the-internet.herokuapp.com/";
    @FindBy(xpath = "//*[contains(text(),'Add/Remove Elements')]")
    WebElement addRemoveElements;
    @FindBy(xpath = "//button[contains(text(),'Add Element')]")
    WebElement addRemoveEelementButton;
    @FindBy(xpath = "//button[contains(text(),'Delete')]")
    WebElement deleteEelementButton;


    public ElementalSeleniumBasePage(WebDriver driver) {


        this.driver = driver;

        extent = ExtentReportManager.initReporter("TestAutomationReport", "env", "elementalSelenium", driver.getClass().toString());

        PageFactory.initElements(driver, this);
    }

    public void clickOnElementAddRemoveElements(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(driver1 -> ExpectedConditions.visibilityOf(addRemoveElements));

        addRemoveElements.click();

    }


    public void getUrl() {
        driver.get(elementalSeleniumURL);
    }



    public void quitReporter() {

        extent.flush();


    }
    public void quitDriver() {

        driver.quit();


    }



    public void afterClass() {
        quitReporter();
        quitDriver();
    }


    public void takeScreenShot(String fileName) {
        try {
            File srcFile = ((TakesScreenshot) (driver)).getScreenshotAs(OutputType.FILE);

            File dest = new File(System.getProperty("user.dir") + "/test-output/" + fileName + ".jpg");

            FileHandler.copy(srcFile, dest);

            test.log(LogStatus.INFO, test.addScreenCapture("./"+fileName+".jpg"));

            } catch (IOException e) {
                e.printStackTrace();
            }

    }


    public void clickonAddElementButton() {
        addRemoveEelementButton.click();
    }

    public void clickonDeleteButton() {



        List<WebElement> elementList=driver.findElements(By.xpath("//button[contains(text(),'Delete')]"));



          elementList.forEach(webElement -> webElement.click()  );

    }
}
