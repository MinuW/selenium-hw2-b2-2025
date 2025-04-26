package com.pragmatic.selenium.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BrowserFactory {
    public static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public static WebDriver getDriver() {
        return driver.get();
    }
    public static void init(String browser) {
        WebDriver webDriver = null;
        ChromeOptions chromeOptions = new ChromeOptions();;
        webDriver = switch (browser.toLowerCase()) {
            case "chrome" -> new ChromeDriver(getChromeOptions(false));
            case "chrome-headless" -> new ChromeDriver(getChromeOptions(true));
            case "firefox" -> new FirefoxDriver(getFirefoxOptions(false));
            case "firefox-headless" -> new FirefoxDriver(getFirefoxOptions(true));
            case "edge" -> new EdgeDriver(getEdgeOptions(false));
            case "edge-headless" -> new EdgeDriver(getEdgeOptions(true));
            default -> webDriver;
        };
        driver.set(webDriver);
        driver.get().manage().window().maximize();
    }
    private static EdgeOptions getEdgeOptions(boolean isHeadless) {
        EdgeOptions edgeOptions = new EdgeOptions();
        if (isHeadless){
            edgeOptions.addArguments("--headless");
        }
        return edgeOptions;
    }
    private static FirefoxOptions getFirefoxOptions(boolean isHeadless) {
        FirefoxOptions firefoxOptions =  new FirefoxOptions();
        if (isHeadless){
            firefoxOptions.addArguments("--headless");
        }
        return firefoxOptions;
    }
    private static ChromeOptions getChromeOptions(boolean isHeadless) {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");
        chromeOptions.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        chromeOptions.setExperimentalOption("useAutomationExtension", false);
        if (isHeadless){
            chromeOptions.addArguments("--headless");
        }
        return chromeOptions;
    }
    public
    static void close() {

    }
}
