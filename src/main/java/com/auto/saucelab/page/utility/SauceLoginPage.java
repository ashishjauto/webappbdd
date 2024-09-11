package com.auto.saucelab.page.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SauceLoginPage {

    private String sauceLabUrl="https://www.saucedemo.com/";

    public SauceLoginPage(){

    }

    public String userCredentials(WebDriver driver){

        return driver.findElement(By.id("login_credentials")).getText();
    }


    public void navigation(WebDriver driver){

        driver.navigate().to(sauceLabUrl);
        driver.manage().window().maximize();






    }
    public void waitForElement(WebDriver driver){
        WebDriverWait waitforElement = new WebDriverWait(driver, Duration.ofSeconds(5));
        waitforElement.until(wait->driver.findElement(By.id("user-name")).isDisplayed());

    }

    public void sendKeysToWebelement(WebDriver driver, String userName,String password){
        driver.findElement(By.id("user-name")).sendKeys(userName);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();

    }


}
