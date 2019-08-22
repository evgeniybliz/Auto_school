package com.playtika.homework6;

import com.playtika.homework6.helper.DriverManager;
import com.playtika.homework6.pages.BasketPage;
import com.playtika.homework6.pages.HomePage;
import com.playtika.homework6.validators.CommonValidators;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class OnlineStoreTest {

    private static final int EXPECTED_COUNT_OF_ITEMS = 1;

    @Test()
    public static void catalogTest() {

        // Given: Open market
        HomePage homePage = new HomePage();
        homePage.openSite();

        //When: Search product
        homePage.searchProduct("Mi Band 2");

        // Then: Validate that product is found and single on the page
        CommonValidators.assertEquals(EXPECTED_COUNT_OF_ITEMS, homePage.findProductInBasket("Mi Band 2").size(), "Number of items on the page doesn't match the expected number");

        // When: Add product to basket
        homePage.addProductToBasket();

        // And: Open basket
        BasketPage basketPage = new BasketPage();
        basketPage.openBasket();

        // And: Open basket after reload page
        basketPage.basketPageAfterReload();

        // Then: Validate that product is displayed in the basket
        CommonValidators.assertBooleanEquals(basketPage.findProductInBasket("Xiaomi Mi Band 2").isDisplayed(), true, "Item is missing");
    }

    @AfterMethod
    public static void quitBrowser() {
        DriverManager.quit();
    }
}