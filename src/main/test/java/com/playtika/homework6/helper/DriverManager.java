package com.playtika.homework6.helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class DriverManager {

    private static WebDriver driver = null;

    public static void initDriver() {
        if (driver == null) {
            switch (System.getProperty("browser")) {
                case "chrome":
                    System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
                    driver = new ChromeDriver();
                    break;
                case "firefox":
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

    public static WebDriver getDriver() {
        return driver;
    }
}