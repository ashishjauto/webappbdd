package com.auto.saucelab.test;

import com.auto.saucelab.page.utility.SauceLoginPage;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class SauceLabLoginTest {


    private WebDriver driver  ;
    private SauceLoginPage sauceLoginPage = new SauceLoginPage();



    @Given("^When i navigate to sauce lab login page should display$")
    public void when_i_navigate_to_sauce_lab_login_page_should_display() throws Throwable {


        sauceLoginPage.navigation();


    }

    @And("^i can view username and password for the dummy app$")
    public void i_can_view_username_and_password_for_the_dummy_app() throws Throwable {
        sauceLoginPage.waitForElement();

    }

    @Then("^(.+) and (.+) field should be enabled with login button:$")
    public void username_and_password_field_should_be_enabled_with_login_button(String userName,String password) throws Throwable {
        sauceLoginPage.sendKeysToWebelement(userName,password);

        Assert.assertTrue(sauceLoginPage.logoDisplayed());

    }


}

