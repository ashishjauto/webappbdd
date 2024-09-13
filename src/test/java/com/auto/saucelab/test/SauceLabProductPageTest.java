package com.auto.saucelab.test;

import com.auto.saucelab.page.utility.SauceLoginPage;
import com.auto.saucelab.page.utility.SauceProuctPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class SauceLabProductPageTest {


    private  WebDriver driver  ;
    private SauceLoginPage sauceLoginPage=new SauceLoginPage();
    private SauceProuctPage sauceProuctPagePage =new SauceProuctPage();



    @Given("^When i navigate to sauce lab Product page$")
    public void when_i_navigate_to_sauce_lab_product_page() {
        sauceLoginPage.navigation();
        sauceLoginPage.sendKeysToWebelement("standard_user","secret_sauce");

    }

    @And("^i can view list of product displayed for purchase$")
    public void i_can_view_list_of_product_displayed_for_purchase()   {


        List<WebElement>inventoryList= sauceProuctPagePage.getInventoryList();


        sauceProuctPagePage.clickOnAddToCart();






        sauceProuctPagePage.clickOnCheckout();
        sauceProuctPagePage.fillFormDetails();
        sauceProuctPagePage.getCartText();


        sauceProuctPagePage.clickonFinish();





    }



}