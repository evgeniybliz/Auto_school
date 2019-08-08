package com.playtika.homework6.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasicPage {

    private static final String URL = "https://www.elmarket.by";
    private final String productNameTemplate = "//a[contains(.,'%s')]";

    @FindBy(id = "search-field")
    private WebElement searchField;

    @FindBy(xpath = "//a[text()='В корзину']")
    private WebElement addToBasketButton;

    public void openSite(){
        open(URL);
    }

    public void searchProduct(String productName) {
        searchField.sendKeys(productName);
        searchField.submit();
    }

    public List<WebElement> findProductInBasket(String productName) {
        String locator = String.format(productNameTemplate, productName);
        List<WebElement> foundItems = driver.findElements(By.xpath(locator));
        return foundItems;
    }

    public void addProductToBasket() {
        addToBasketButton.click();
    }
}