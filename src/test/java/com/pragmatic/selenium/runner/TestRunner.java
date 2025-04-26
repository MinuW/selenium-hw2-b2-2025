package com.pragmatic.selenium.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"com.pragmatic.selenium.steps"},
        plugin = {"pretty",
                "html:target/cucumber-report.html",
                "json:target/cucumber-report.json"},
        publish = true,
        dryRun = false,
        monochrome = false,
        tags = "@Regression"
)
public class TestRunner extends AbstractTestNGCucumberTests {


}
