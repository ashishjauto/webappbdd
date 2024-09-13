package com.auto.saucelab.test;


import com.auto.saucelab.page.browser.BrowserObject;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class SauceLabHooks {

    @Before
    public static void setUp() {

        BrowserObject.setUpDriver();
    }


    @After
    public static void tearDown(Scenario scenario) {

        //validate if scenario has failed
        if(scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) BrowserObject.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }

        BrowserObject.tearDown();
    }
}
