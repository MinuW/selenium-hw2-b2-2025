package com.pragmatic.selenium.tests;

import com.pragmatic.selenium.util.BrowserFactory;
import com.pragmatic.selenium.util.ConfigurationReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginNavigateNegativeTests {
    private static final Logger log = LogManager.getLogger(LoginNavigateNegativeTests.class);
    private WebDriver driver;
    //private By byUserName =By.id("user-name");
    //private By byPassword = By.id("password");
    //private By byLoginButton = By.id("login-button");

    public LoginNavigateNegativeTests() {

    }


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

    /**
     *
     * @DataProvider provide range of user login error combinations to validate the proper error messages
     */
    @DataProvider(name = "user-credentials")
    public Object[][] userCredentials(){
        return new Object[][]{
                {"invalid-user","secret_sauce", "Epic sadface: Username and password do not match any user in this service","Scenario_01: LoginInvalidUsernameValidPassword"},
                {"standard_user","invalid-password","Epic sadface: Username and password do not match any user in this service","Scenario_02: LoginValidUsernameInvalidPassword"},
                {"invalid-user1","invalid-password1","Epic sadface: Username and password do not match any user in this service","Scenario_03: invalidUserNamePassword"},
                {"","secret_sauce","Epic sadface: Username is required","Scenario_04: BlankUsernameCorrectPassword"},
                {"standard_user","","Epic sadface: Password is required","Scenario_05: correctUserNameBlankPassword"},
                {"","","Epic sadface: Username is required", "Scenario_06: blankUserNamePassword"},
                {"locked_out_user","secret_sauce","Epic sadface: Sorry, this user has been locked out.","Scenario_07: lockedOutUserAttempt"},
                {"userM@#$1","PaSword@%$","Epic sadface: Username and password do not match any user in this service","Scenario_08: specialCharactersInUserNamePassword"},
                {"16UQLq1HZ3CNwhvgrarV6pMoA2CDjb4tyFmsls","secret_sauce","Epic sadface: Username and password do not match any user in this service","Scenario_09: veryLongUserNamePassword"}
        };
    }

    @Test(dataProvider = "user-credentials")
    public void testInvalidScenariosWithDDT(String username, String password, String expectedError, String testScenario){
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();
        //Assert.assertEquals(LoginFactoryPage.errorMessage().trim(), expectedError);

            Assert.assertEquals(driver.findElement(By.cssSelector("[data-test='error']")).getText(), expectedError);
            log.info(testScenario);



    }

}
