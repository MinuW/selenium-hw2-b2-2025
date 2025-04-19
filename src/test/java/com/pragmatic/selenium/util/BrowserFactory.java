package com.pragmatic.selenium.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserFactory {
    public static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {

        return driver.get();
    }

    public static void init(String browser) {
        WebDriver webDriver = null;
        ChromeOptions chromeOptions;

        switch (browser.toLowerCase()) {
            case "chrome":
                chromeOptions = new ChromeOptions();
                //chromeOptions.setExperimentalOption("excludeSwitches", List.of("disable-popup-blocking"));
                chromeOptions.addArguments("--disable-save-password-bubble");
                webDriver = new ChromeDriver(chromeOptions);
                break;
            case "chrome-headless":
                chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("disable-save-password-bubble");
                chromeOptions.addArguments("--headless");
                webDriver = new ChromeDriver(chromeOptions);
                break;
            case "firefox":
                webDriver = new FirefoxDriver();
                break;
            case "edge":
                webDriver = new EdgeDriver();
                break;
            case "safari":
                webDriver = new SafariDriver();
                break;
        }
        driver.set(webDriver);
        driver.get().manage().window().maximize();
    }

    public
    static void close() {

    }
}
