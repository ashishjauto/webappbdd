package com.auto.saucelab.page.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SauceProuctPage {


    //WebDriver sauceProductPageDriver;

    By swagLogo=By.xpath("//*[contains(text(),'Swag Labs')]");
    By swagInventoryList=  By.xpath("//*[contains(@class,'inventory_item') and contains(@class,'inventory_item_description')]");



    public boolean swagLogoDisplayed(WebDriver driver){
       return driver.findElement(swagLogo).isDisplayed();

    }


    public List<WebElement> getInventoryList(WebDriver driver){
       return driver.findElements(swagInventoryList);

    }


    public void clickonFinish(WebDriver driver) {
        driver.findElement(By.id("finish")).click();
    }

    public void getCartText(WebDriver driver) {

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(driver.findElement(By.id("finish")))) ;


        List<WebElement> elements = driver.findElements( By.xpath("//*[contains(@class,'cart_item') and contains(@data-test,'inventory-item')]"));

      /*  elements.forEach(webElement -> System.out.println(webElement.
                                                        findElement(By.xpath("//*[contains(@class,'inventory_item_price') and contains(@data-test,'inventory-item-price')]"))
                                                        .getText()+" -->>  "+ webElement.
                findElement(By.xpath("//*[contains(@class,'inventory_item_desc') and contains(@data-test,'inventory-item-desc')]"))+ " -->> "+
                webElement.
                        findElement(By.xpath("//*[contains(@class,'inventory_item_name') and contains(@data-test,'inventory_item_name')]"))

        ));
*/      elements.forEach(webElement -> System.out.println(webElement.getText()));
    }

    public void fillFormDetails(WebDriver driver) {

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(driver.findElement(By.id("first-name")))) ;

        driver.findElement(By.id("first-name")).sendKeys("John");
        driver.findElement(By.id("last-name")).sendKeys("Doe");
        driver.findElement(By.id("postal-code")).sendKeys("90210");
        driver.findElement(By.id("continue")).click();


    }

    public void clickOnCheckout(WebDriver driver) {



        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[contains(@id,'checkout') and contains(text(),'Checkout')]")))) ;

        driver.findElement(By.xpath("//button[contains(@id,'checkout') and contains(text(),'Checkout')]")).click();

    }
}
