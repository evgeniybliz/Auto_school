package com.playtika.homework6.pages;

import com.playtika.homework6.helper.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasicPage {

    public static WebDriver driver;

    public BasicPage(){
        DriverManager.initDriver();
        WebDriver driver = DriverManager.getDriver();
        PageFactory.initElements(driver, this);
    }

    public void open(String url) {
        driver.get(url);
    }
}
