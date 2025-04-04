package com.pragmatic.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    private final WebDriver driver;
    //Elements Definition
    @FindBy(xpath = "//div[text()='Sauce Labs Backpack']")
    private WebElement elemInventoryItemOne;
    @FindBy(xpath = "//a[@id ='item_4_title_link' ]//following-sibling::div[2]//child::div")
    private WebElement elemItemOnePrice;
    @FindBy(xpath = "//div[text()='Sauce Labs Fleece Jacket']")
    private WebElement elemInventoryItemTwo;
    @FindBy(xpath = "//a[@id ='item_5_title_link' ]//following-sibling::div[2]//child::div")
    private WebElement elemItemTwoPrice;
    @FindBy(xpath = "//div[text()='Sauce Labs Bike Light']")
    private WebElement elemInventoryItemThree;
    @FindBy(xpath = "//a[@id ='item_0_title_link' ]//following-sibling::div[2]//child::div")
    private WebElement elemItemThreePrice;
    @FindBy(xpath = "//button[@id='checkout']")
    WebElement elemCheckoutButton;

    private final By byTitle = By.className("title");

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Get Page Title
    public String getTitle() {
        return driver.findElement(byTitle).getText();
    }

    //Click Checkout button
    public void clickCheckOut() {
        elemCheckoutButton.click();
    }


    public WebElement getElemInventoryItemOne() {
        return elemInventoryItemOne;
    }

    public void setElemInventoryItemOne(WebElement elemInventoryItemOne) {
        this.elemInventoryItemOne = elemInventoryItemOne;
    }

    public WebElement getElemInventoryItemTwo() {
        return elemInventoryItemTwo;
    }

    public void setElemInventoryItemTwo(WebElement elemInventoryItemTwo) {
        this.elemInventoryItemTwo = elemInventoryItemTwo;
    }

    public WebElement getElemInventoryItemThree() {
        return elemInventoryItemThree;
    }

    public void setElemInventoryItemThree(WebElement elemInventoryItemThree) {
        this.elemInventoryItemThree = elemInventoryItemThree;
    }

    public WebElement getElemItemOnePrice() {
        return elemItemOnePrice;
    }

    public void setElemItemOnePrice(WebElement elemItemOnePrice) {
        this.elemItemOnePrice = elemItemOnePrice;
    }

    public WebElement getElemItemTwoPrice() {
        return elemItemTwoPrice;
    }

    public void setElemItemTwoPrice(WebElement elemItemTwoPrice) {
        this.elemItemTwoPrice = elemItemTwoPrice;
    }

    public WebElement getElemItemThreePrice() {
        return elemItemThreePrice;
    }

    public void setElemItemThreePrice(WebElement elemItemThreePrice) {
        this.elemItemThreePrice = elemItemThreePrice;
    }
}
