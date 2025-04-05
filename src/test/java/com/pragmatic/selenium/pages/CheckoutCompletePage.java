package com.pragmatic.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutCompletePage {
    private final WebDriver driver;
    //Elements Definition
    @FindBy(className = "title")
    private WebElement eleTitle;
    @FindBy(className = "complete-text")
    private WebElement eleCompleteMessage;

    public CheckoutCompletePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getTitle() {
        return eleTitle.getText();
    }

    public WebElement getEleCompleteMessage() {
        return eleCompleteMessage;
    }

    public void setEleCompleteMessage(WebElement eleCompleteMessage) {
        this.eleCompleteMessage = eleCompleteMessage;
    }

    public void setEleTitle(WebElement eleTitle) {
        this.eleTitle = eleTitle;
    }
}
