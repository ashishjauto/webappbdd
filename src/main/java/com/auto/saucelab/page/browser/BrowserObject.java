package com.auto.saucelab.page.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BrowserObject {

    private static BrowserObject BrowserObject;
    private static WebDriver driver;
    public final static int TIMEOUT = 10;

    private BrowserObject() {


        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
        driver.manage().window().maximize();

    }


    public static void openPage(String url) {
        driver.get(url);
    }


    public static WebDriver getDriver() {
        return driver;
    }

    public static void setUpDriver() {

        if (BrowserObject==null) {

            BrowserObject = new BrowserObject();
        }
    }

    public static void tearDown() {

        if(driver!=null) {
            driver.close();
            driver.quit();
        }

        BrowserObject = null;
    }
}
