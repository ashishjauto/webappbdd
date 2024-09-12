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

    @Before
    public void testInitiate(){
        driver = new ChromeDriver();

    }

    @Given("^When i navigate to sauce lab Product page$")
    public void when_i_navigate_to_sauce_lab_product_page() {
        sauceLoginPage.navigation(driver);
        sauceLoginPage.sendKeysToWebelement(driver,"standard_user","secret_sauce");
        WebDriverWait waitforElement = new WebDriverWait(driver, Duration.ofSeconds(15));
        waitforElement.until(wait->driver.findElement(By.className("app_logo")).isDisplayed());
    }

    @And("^i can view list of product displayed for purchase$")
    public void i_can_view_list_of_product_displayed_for_purchase()   {


        List<WebElement>inventoryList= sauceProuctPagePage.getInventoryList(driver);

        inventoryList.forEach(webElement -> webElement.findElement(By.xpath("//button[contains(text(),'Add to cart')]")).click());

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.textToBe(By.xpath("//*[contains(@class,'shopping_cart_badge')]"),
                        String.valueOf(inventoryList.size())));


        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(@class,'shopping_cart_badge')]")).
                getText().equals(String.valueOf(inventoryList.size())));


        driver.findElement(By.xpath("//*[contains(@class,'shopping_cart_badge')]")).click();


        sauceProuctPagePage.clickOnCheckout(driver);
        sauceProuctPagePage.fillFormDetails(driver);
        sauceProuctPagePage.getCartText(driver);


        sauceProuctPagePage.clickonFinish(driver);


        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(driver.findElement(By.id("back-to-products")))) ;





    }
    @After
    public void quit(){
        driver.quit();
    }


}

