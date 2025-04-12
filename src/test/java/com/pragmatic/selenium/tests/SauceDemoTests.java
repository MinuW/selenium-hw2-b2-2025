package com.pragmatic.selenium.tests;

import com.pragmatic.selenium.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SauceDemoTests {
    WebDriver driver;
    LoginFactoryPage loginFactoryPage;
    InventoryPage inventoryPage;
    CartPage cartPage;
    CheckoutOverviewPage checkoutOverviewPage;
    CheckoutInformationPage checkoutInformationPage;
    CheckoutCompletePage checkoutCompletePage;

    @BeforeMethod
    public void setUp() {
        driver = new FirefoxDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();//Open the Sauce Demo website
        loginFactoryPage = new LoginFactoryPage(driver);
        inventoryPage = new InventoryPage(driver);
        cartPage = new CartPage(driver);
        checkoutOverviewPage = new CheckoutOverviewPage(driver);
        checkoutInformationPage = new CheckoutInformationPage(driver);
        checkoutCompletePage = new CheckoutCompletePage(driver);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testLoginWithValidCredentials() {
        loginFactoryPage.login("standard_user","secret_sauce");
        //loginFactoryPage.typeUsername("standard_user").typePassword("secret_sauce").clickLogin();//User Login
        //Validation
        Assert.assertEquals(inventoryPage.getTitle(), "Products", "Inventory Page Title Test Failed");
    }

    @Test
    public void testAddProductsToCart() {
        loginFactoryPage.typeUsername("standard_user").typePassword("secret_sauce").clickLogin();//User Login
        inventoryPage.addItems();//Add items to Cart
        //Assert.assertTrue((inventoryPage.itemCountConverted) == (3), "Item Count is wrong in the Cart Badge");//Verify added item count shows at cart badge
        inventoryPage.goToCart();//Navigate to Cart Page
        //Validation
        Assert.assertEquals(cartPage.getTitle(), "Your Cart", "Navigation Failed - Go to Your Cart Page ");//Verify Navigation to Cart
    }

    @Test
    public void testProductsInTheCart() {
        loginFactoryPage.typeUsername("standard_user").typePassword("secret_sauce").clickLogin();//User Login
        inventoryPage.addItems();//Add items to Cart
        inventoryPage.goToCart();//Navigate to Cart Page
        validateCartItems();
        validateItemPrice();
        cartPage.clickCheckOut();//Navigate to CheckoutInformation Page

    }

    private void validateItemPrice() {
        //Validation
        Assert.assertEquals(cartPage.getElemItemOnePrice().getText(), "$29.99", "Item Price is Wrong! ");
        Assert.assertEquals(cartPage.getElemItemTwoPrice().getText(), "$49.99", "Item Price is Wrong! ");
        Assert.assertEquals(cartPage.getElemItemThreePrice().getText(), "$9.99", "Item Price is Wrong! ");
    }

    public void validateCartItems() {
        //Validation
        Assert.assertEquals(cartPage.getElemInventoryItemOne().getText(), "Sauce Labs Backpack", "Wrong Product added to the Cart, Remove or Replace");
        Assert.assertEquals(cartPage.getElemInventoryItemTwo().getText(), "Sauce Labs Fleece Jacket", "Wrong Product added to the Cart, Remove or Replace");
        Assert.assertEquals(cartPage.getElemInventoryItemThree().getText(), "Sauce Labs Bike Light", "Wrong Product added to the Cart, Remove or Replace");
    }

    @Test
    public void testUserDetails() {
        loginFactoryPage.typeUsername("standard_user").typePassword("secret_sauce").clickLogin();//Navigate to Cart Page
        inventoryPage.addItems();//Add items to Cart
        inventoryPage.goToCart();//Navigate to Cart Page
        cartPage.clickCheckOut();//Navigate to CheckoutInformation Page
        //Validation
        Assert.assertEquals(checkoutInformationPage.getTitle(), "Checkout: Your Information", "Navigation Failed - Go to Checkout: Your Information Page ");
        CheckoutInformationPage.clearAndTypePersonalDetails();
        checkoutInformationPage.eleContinueButton.click();//Navigate to CheckoutOverview Page
    }

    @Test
    public void testOrderCheckOutDetails() {
        loginFactoryPage.typeUsername("standard_user").typePassword("secret_sauce").clickLogin();//Navigate to Cart Page
        inventoryPage.addItems();//Add items to Cart
        inventoryPage.goToCart();//Navigate to Cart Page
        cartPage.clickCheckOut();//Navigate to CheckoutInformation Page
        CheckoutInformationPage.clearAndTypePersonalDetails();//Fill out user details
        checkoutInformationPage.eleContinueButton.click();//Navigate to CheckoutOverview Page
        //Validation
        Assert.assertEquals(checkoutOverviewPage.getTitle(), "Checkout: Overview", "Navigation Failed - Go to Checkout: Overview Page ");
        Assert.assertEquals(checkoutOverviewPage.getEleItemTotal().getText(), "Item total: $89.97", "Item Total is Wrong ");
        Assert.assertEquals(checkoutOverviewPage.getEleTotal().getText(), "Total: $97.17", "Bill Total is Wrong! ");
        checkoutOverviewPage.clickFinish();//Navigate to CheckoutComplete Page
    }

    @Test
    public void testOrderCompletionPage() {
        loginFactoryPage.typeUsername("standard_user").typePassword("secret_sauce").clickLogin();//Navigate to Cart Page
        inventoryPage.addItems();//Add items to Cart
        inventoryPage.goToCart();//Navigate to Cart Page
        cartPage.clickCheckOut();//Navigate to CheckoutInformation Page
        CheckoutInformationPage.clearAndTypePersonalDetails();//Fill out user details
        checkoutInformationPage.eleContinueButton.click();//Navigate to CheckoutOverview Page
        checkoutOverviewPage.clickFinish();//Navigate to CheckoutComplete Page
        //Validation
        Assert.assertEquals(checkoutCompletePage.getTitle(), "Checkout: Complete!", "Error - Checkout process incomplete");
        Assert.assertEquals(checkoutCompletePage.getEleCompleteMessage().getText(), "Your order has been dispatched, and will arrive just as fast as the pony can get there!", "Error in checkout completion");
    }
}
