package com.playtika.homework6;

import com.playtika.homework6.helper.DriverManager;
import com.playtika.homework6.validators.CommonValidators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import java.util.List;

public class OnlineStoreTest {

    private static final int EXPECTED_COUNT_OF_ITEMS = 1;
    private static final String URL = "https://www.elmarket.by";

    @DataProvider(name = "listOfBrowsers")
    public Object[][] listOfBrowsers() {
        return new Object[][]{
                {"chrome"},
                {"firefox"},
        };
    }

    @Test(dataProvider = "listOfBrowsers", threadPoolSize = 2, singleThreaded = false)
    public static void catalogTest(String browserType) {

        // Given: Open market
        DriverManager.initDriver(browserType);
        DriverManager.openUrl(URL);
        WebDriver driver = DriverManager.getDriver();

        //When: Search product
        WebElement element = driver.findElement(By.id("search-field"));
        element.sendKeys("Mi band 2");
        element.submit();

        // Then: Validate that product is found and single on the page
        List<WebElement> foundItem = driver.findElements(By.xpath("//a[text()='Xiaomi Mi Band 2']"));
        CommonValidators.assertEquals(EXPECTED_COUNT_OF_ITEMS, foundItem.size(), "Number of items on the page doesn't match the expected number");

        // When: Add product to basket
        WebElement addToBasket = driver.findElement(By.xpath("//a[text()='В корзину']"));
        addToBasket.click();

        // And: Open basket
        WebElement basket = driver.findElement(By.id("bbtn"));
        basket.click();
        driver.navigate().to(URL);
        WebElement basketAfterReloadPage = driver.findElement(By.id("bbtn"));
        basketAfterReloadPage.click();

        // Then: Validate that product is displayed in the basket
        WebElement itemInBasket = driver.findElement(By.xpath("//a[text()='Фитнес-браслет  Xiaomi Mi Band 2']"));
        CommonValidators.assertBooleanEquals(itemInBasket.isDisplayed(), true, "Item is missing");
    }

    @AfterMethod
    public static void quitBrowser() {
        DriverManager.quit();
    }
}