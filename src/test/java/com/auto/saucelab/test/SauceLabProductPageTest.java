package com.auto.saucelab.test;

import com.auto.saucelab.page.utility.SauceLoginPage;
import com.auto.saucelab.page.utility.SauceProuctPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
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

        System.out.println("test");




        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.textToBe(By.xpath("//*[contains(@class,'shopping_cart_badge')]"),
                        String.valueOf(inventoryList.size())));



        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(@class,'shopping_cart_badge')]")).
                getText().equals(String.valueOf(inventoryList.size())));


        driver.findElement(By.xpath("//*[contains(@class,'shopping_cart_badge')]")).click();


        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[contains(@id,'checkout') and contains(text(),'Checkout')]")))) ;

        driver.findElement(By.xpath("//button[contains(@id,'checkout') and contains(text(),'Checkout')]")).click();

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(driver.findElement(By.id("first-name")))) ;

         driver.findElement(By.id("first-name")).sendKeys("John");
        driver.findElement(By.id("last-name")).sendKeys("Doe");

        driver.findElement(By.id("postal-code")).sendKeys("90210");


        driver.findElement(By.id("continue")).click();

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


        driver.findElement(By.id("finish")).click();

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(driver.findElement(By.id("back-to-products")))) ;




      //  driver.quit();
    }


}

