package com.pragmatic.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage {
    private final WebDriver driver;
    private final By byTitle = By.cssSelector(".title");
    private final By byItemNameOne;
    private final By byItemNameTwo;
    private final By byItemNameThree;
    private final By byCartCountBadge;
    public int itemCountConverted;
    private final By byCartIcon;


    public InventoryPage(WebDriver driver) {
        this.driver = driver;
        byItemNameOne = By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']");
        byItemNameTwo = By.xpath("//button[@id='add-to-cart-sauce-labs-fleece-jacket']");
        byItemNameThree = By.xpath("//button[@id='add-to-cart-sauce-labs-bike-light']");
        byCartCountBadge = By.xpath("//span[@class = 'shopping_cart_badge']");
        byCartIcon = By.xpath("//a[@class='shopping_cart_link']");
    }

    public String getTitle() {
        return driver.findElement(byTitle).getText();
    }

    public int getCartNumbers(int itemCountConverted) {
        String itemCount = driver.findElement(byCartCountBadge).getText();
        try {
            this.itemCountConverted = Integer.parseInt(itemCount);
        } catch (NumberFormatException e) {
            throw new NumberFormatException();
        }
        return itemCountConverted;
    }

    public void addItems() {
        driver.findElement(this.byItemNameOne).click();
        driver.findElement(this.byItemNameTwo).click();
        driver.findElement(this.byItemNameThree).click();
    }

    public void goToCart() {
        driver.findElement(this.byCartIcon).click();//Cart Navigation
    }
}
