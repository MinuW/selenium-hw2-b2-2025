package com.pragmatic.selenium.pages;

import com.pragmatic.selenium.util.ActionBot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginFactoryPage {
    private final ActionBot actionBot;
    //Elements Definition
    private static @FindBy(id = "user-name")
    WebElement eleUsername;
    private static @FindBy(id = "password")
    WebElement elePassword;
    private final By byLoginButton = By.id("login-button");
    private static @FindBy(css = "h3[data-test='error']")
    WebElement eleLoginError;
//    public final By byLoginError = By.cssSelector("[data-test='error']");


    public LoginFactoryPage(WebDriver driver) {
        actionBot = new ActionBot(driver);
        //init element
        PageFactory.initElements(driver, this);
    }


    public LoginFactoryPage typeUsername(String username) {
        eleUsername.sendKeys(username);
        //actionBot.clearAndType((By) eleUsername,username);
        return this;
    }

    public LoginFactoryPage typePassword(String password) {
        elePassword.sendKeys(password);
        //actionBot.clearAndType((By) elePassword,password);
        return this;
    }

    public void clickLogin() {
        //eleLoginButton.click();
        actionBot.waitAndClick(byLoginButton);
    }

    public void login(String username, String password) {
        typeUsername(username);
        typePassword(password);
        clickLogin();
    }

//    public static WebElement getEleLoginError() {
//        return eleLoginError;
//    }
//
//    public static void setEleLoginError(WebElement eleLoginError) {
//        LoginFactoryPage.eleLoginError = eleLoginError;
//    }

    public static String errorMessage() {
        return eleLoginError.getText();
    }
}
