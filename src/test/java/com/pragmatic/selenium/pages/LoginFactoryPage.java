package com.pragmatic.selenium.pages;

import com.pragmatic.selenium.util.ActionBot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginFactoryPage {
    private final WebDriver driver;
    private ActionBot actionBot;
    //Elements Definition
    @FindBy(id = "user-name")
    WebElement eleUsername;

    @FindBy(id = "password")
    WebElement elePassword;

    private final By byLoginButton = By.id("login-button");

    @FindBy(css = "h3[data-test='error']")
    WebElement eleLoginError;

    public LoginFactoryPage(WebDriver driver) {
        this.driver = driver;
        actionBot = new ActionBot(driver);
        //init element
        PageFactory.initElements(driver,this);
    }

    public LoginFactoryPage typeUsername(String username) {
        eleUsername.sendKeys(username);
        //actionBot.clearAndType(eleUsername,username);
        return this;
    }

    public LoginFactoryPage typePassword(String password) {
        elePassword.sendKeys(password);
        //actionBot.clearAndType(elePassword,password);
        return this;
    }

    public void clickLogin() {
        //eleLoginButton.click();
        actionBot.waitAndClick(byLoginButton);
    }

    public void login(String username, String password){
        typeUsername(username);
        typePassword(password);
        clickLogin();
    }

    public String getError() {
        return eleLoginError.getText();
    }

}
