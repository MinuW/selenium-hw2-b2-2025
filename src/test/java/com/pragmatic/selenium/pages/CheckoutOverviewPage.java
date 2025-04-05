package com.pragmatic.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutOverviewPage {
    private final WebDriver driver;

    //Elements Definition
    @FindBy(xpath = "//div[@class='summary_subtotal_label']")
    private WebElement eleItemTotal;
    @FindBy(xpath = "//div[@class='summary_total_label']")
    private WebElement eleTotal;
    @FindBy(xpath = "//button[@id='finish']")
    private WebElement elemFinishButton;

    public CheckoutOverviewPage(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    public WebElement getEleTitle() {
        return eleTitle;
    }

    public void setEleTitle(WebElement eleTitle) {
        this.eleTitle = eleTitle;
    }

    @FindBy(className = "title")
    private WebElement eleTitle;

    public String getTitle() {
        return eleTitle.getText();
    }

    public void clickFinish() {
        elemFinishButton.click();
    }

    public WebElement getEleItemTotal() {
        return eleItemTotal;
    }

    public void setEleItemTotal(WebElement eleItemTotal) {
        this.eleItemTotal = eleItemTotal;
    }

    public WebElement getEleTotal() {
        return eleTotal;
    }

    public void setEleTotal(WebElement eleTotal) {
        this.eleTotal = eleTotal;
    }

}
