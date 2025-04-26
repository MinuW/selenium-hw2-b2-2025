package com.pragmatic.selenium.tests;

import com.pragmatic.selenium.util.BrowserFactory;
import com.pragmatic.selenium.util.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class CrossBrowserBrowserFactoryTest {
    private WebDriver driver;

    /**
     * Set up the browser before each test.
     * Launches the Chrome browser, maximizes the window, and navigates to the login page.
     */
    @Parameters({"browser"})
    @BeforeMethod
    public void setUp(@Optional("chrome")String browser) {
        BrowserFactory.init(browser);
        driver= BrowserFactory.getDriver();
        driver.get(ConfigurationReader.getBaseURL());//Reading from Configuration file
    }

    /**
     * Tear down the browser after each test.
     * Ensures that the browser is closed even if the test fails.
     */
    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testLoginWithChrome()throws InterruptedException{
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");     //Type Valid Password
        driver.findElement(By.id("login-button")).click();//Click Login Button
        String actualTitle = driver.findElement(By.cssSelector(".title")).getText();
        Assert.assertEquals(actualTitle,"Products","Login failed - Page title mismatch.");

    }

    @Test
    public void testLoginWithFirefox(){
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");     //Type Valid Password
        driver.findElement(By.id("login-button")).click();//Click Login Button
        String actualTitle = driver.findElement(By.cssSelector(".title")).getText();
        Assert.assertEquals(actualTitle,"Products","Login failed - Page title mismatch.");

    }

    @Test
    public void testLoginWithEdge(){
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");     //Type Valid Password
        driver.findElement(By.id("login-button")).click();//Click Login Button
        String actualTitle = driver.findElement(By.cssSelector(".title")).getText();
        Assert.assertEquals(actualTitle,"Products","Login failed - Page title mismatch.");

    }
}
