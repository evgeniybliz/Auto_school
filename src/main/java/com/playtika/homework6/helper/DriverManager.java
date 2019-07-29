package com.playtika.homework6.helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.remote.BrowserType.CHROME;
import static org.openqa.selenium.remote.BrowserType.FIREFOX;

public class DriverManager {

    private static WebDriver driver = null;

    public static void initDriver(String browserType) {
        if (driver == null) {
            switch (browserType) {
                case CHROME:
                    System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
                    driver = new ChromeDriver();
                    break;
                case FIREFOX:
                    System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
                    driver = new FirefoxDriver();
                    break;
                default:
                    throw new IllegalArgumentException("Cannot initialize webdriver.");
            }
        }
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    public static void quit() {
        driver.quit();
        driver = null;
    }

    public static void openUrl(String URL) {
        driver.get(URL);
    }

    public static WebDriver getDriver() {
        return driver;
    }
}