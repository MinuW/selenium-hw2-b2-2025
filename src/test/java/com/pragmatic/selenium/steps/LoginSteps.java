package com.pragmatic.selenium.steps;

import com.pragmatic.selenium.pages.InventoryPage;
import com.pragmatic.selenium.pages.LoginFactoryPage;
import com.pragmatic.selenium.util.BrowserFactory;
import com.pragmatic.selenium.util.ConfigurationReader;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginSteps {
    LoginFactoryPage loginFactoryPage;
    WebDriver webDriver;

    @After
    public void after(Scenario scenario){
        if (scenario.isFailed()){
            byte[] screenshot =((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);
        }
        BrowserFactory.close();
    }

    @Given("the user is in the login page")
    public void theUserIsInTheLoginPage() {
        BrowserFactory.init(ConfigurationReader.getBrowser());
        BrowserFactory.getDriver().get(ConfigurationReader.getBaseURL());
        loginFactoryPage = new LoginFactoryPage(BrowserFactory.getDriver());
    }

    @When("the user enter credentials")
    public void theUserEnterValidCredentials() {
        loginFactoryPage.login(ConfigurationReader.get("username"),ConfigurationReader.get("password"));
    }

    @Then("the user is directed to the inventory page")
    public void theUserIsDirectedToTheInventoryPage() {
        InventoryPage inventoryPage = new InventoryPage(BrowserFactory.getDriver());
        Assert.assertEquals(inventoryPage.getTitle(), "Products", "Title is incorrect");
    }

    @When("the user enter credentials {string}, {string}")
    public void theUserEnterValidCredentials(String username, String password) {
        loginFactoryPage.login(ConfigurationReader.get("username"),ConfigurationReader.get("password"));
    }

    @Then("the user should see an error message {string}")
    public void theUserShouldSeeAnErrorMessage(String error) {

    }

    @When("the user enter credentials <username>, <password>")
    public void theUserEnterCredentialsUsernamePassword() {

    }

    @Then("the user should see an error message <expectedErrorMessage>")
    public void theUserShouldSeeAnErrorMessageExpectedErrorMessage() {

    }
}
