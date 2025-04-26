package com.pragmatic.selenium.pages;

import com.pragmatic.selenium.util.Products;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class InventoryPage {
    private final WebDriver driver;
    private final By byTitle = By.cssSelector(".title");
    private final By byItemName;
    private final By byCartCountBadge;
    public int itemCountConverted;
    private final By byCartIcon;


    public InventoryPage(WebDriver driver) {
        this.driver = driver;

        byItemName = By.xpath("//div[@class='inventory_item_name ']");
        byCartCountBadge = By.xpath("//span[@class = 'shopping_cart_badge']");
        byCartIcon = By.xpath("//a[@class='shopping_cart_link']");
    }

    public void addItemsToCart() {
        String [] productName = {"Sauce Labs Backpack","Sauce Labs Fleece Jacket","Sauce Labs Bike Light"};
        List<WebElement> products = driver.findElements(byItemName);
        String xpathButton = ("//div[text()='%s']/ancestor::div[@data-test='inventory-item']/descendant::button");

        for (String s : productName) {
            String xpathProduct = String.format(xpathButton,s);
            driver.findElement(By.xpath(xpathProduct)).click();
        }
    }

    public Products getProducts(String productName){
        String xpathProductName = String.format("//div[text()='%s']", productName);
        WebElement eleProductName = driver.findElement(By.xpath(xpathProductName));
        WebElement eleItem = eleProductName.findElement(By.xpath(".//ancestor::div[@data-test='inventory-item']"));
        Products products = new Products();
        products.setName(productName);
        products.setPrice(eleItem.findElement(By.cssSelector("[data-test='inventory-item-price']")).getText());
        return products;
    }

    public void addProduct(String productName){
        String xpathProductName = String.format("//div[text()='%s']", productName);
        WebElement eleProductName = driver.findElement(By.xpath(xpathProductName));
        WebElement eleItem = eleProductName.findElement(By.xpath(".//ancestor::div[@data-test='inventory-item']"));

        WebElement eleAddToCartButton = eleItem.findElement(By.xpath(".//button"));
        eleAddToCartButton.click();

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


    public void goToCart() {
        driver.findElement(this.byCartIcon).click();//Cart Navigation
    }
}
