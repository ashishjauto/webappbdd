package com.auto.saucelab.page.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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





}
