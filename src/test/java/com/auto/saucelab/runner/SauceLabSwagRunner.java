package com.auto.saucelab.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features ="src/test/resources/saucelab",
        glue = "com.auto.saucelab.test")
public class SauceLabSwagRunner {
}
