package com.auto.saucelab.page.utility;


import com.auto.saucelab.page.browser.BrowserObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SauceLoginPage {

    private String sauceLabUrl="https://www.saucedemo.com/";
    WebDriver driver;
    public SauceLoginPage(){
    driver= BrowserObject.getDriver();
    }

    public String userCredentials(WebDriver dd){

        return driver.findElement(By.id("login_credentials")).getText();
    }


    public void navigation(){

        driver.get(sauceLabUrl);
    }
    public void waitForElement(){
        WebDriverWait waitforElement = new WebDriverWait(driver, Duration.ofSeconds(5));
        waitforElement.until(wait->driver.findElement(By.id("user-name")).isDisplayed());

    }

    public void sendKeysToWebelement( String userName,String password){
        driver.findElement(By.id("user-name")).sendKeys(userName);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();
        WebDriverWait waitforElement = new WebDriverWait(driver, Duration.ofSeconds(15));
        waitforElement.until(wait->driver.findElement(By.className("app_logo")).isDisplayed());

    }

    public boolean logoDisplayed(){

        WebDriverWait waitforElement = new WebDriverWait(driver, Duration.ofSeconds(15));
        waitforElement.until(wait->driver.findElement(By.className("app_logo")).isDisplayed());

        return driver.findElement(By.className("app_logo")).isDisplayed();


    }
}
