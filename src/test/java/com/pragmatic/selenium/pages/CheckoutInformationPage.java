package com.pragmatic.selenium.pages;

import com.pragmatic.selenium.data.PersonalInfo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutInformationPage {
    private final WebDriver driver;
    PersonalInfo personalInfo;

    //Elements Definition
    @FindBy(className = "title")
    WebElement eleTitle;
    @FindBy(id = "first-name")
    static WebElement eleFname;
    @FindBy(id= "last-name")
    static WebElement eleLname;
    @FindBy(id = "postal-code")
    static WebElement elePostalCode;
    @FindBy(id ="continue")
    public WebElement eleContinueButton;

    public CheckoutInformationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        personalInfo = new PersonalInfo();
    }

    public static void clearAndTypePersonalDetails() {
        eleFname.clear();
        eleFname.sendKeys(PersonalInfo.getFirstName());
        eleLname.clear();
        eleLname.sendKeys(PersonalInfo.getLastName());
        elePostalCode.clear();
        elePostalCode.sendKeys(PersonalInfo.getPostalCode());

    }

    //Get Page Title
    public String getTitle() {
        return eleTitle.getText();
    }
}
