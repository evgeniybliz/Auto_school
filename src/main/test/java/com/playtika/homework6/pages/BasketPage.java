package com.playtika.homework6.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasketPage extends BasicPage {

    private static final String URL = "https://www.elmarket.by";
    private final String productNameTemplate = "//a[contains(.,'%s')]";

    @FindBy(id = "bbtn")
    private WebElement basket;

    public void openBasket() {
        basket.click();
    }

    public void basketPageAfterReload(){
        driver.navigate().to(URL);
        basket.click();
    }

    public WebElement findProductInBasket(String productName){
        String locator = String.format(productNameTemplate, productName);
        WebElement itemInBasket = driver.findElement(By.xpath(locator));
        return itemInBasket;
    }
}