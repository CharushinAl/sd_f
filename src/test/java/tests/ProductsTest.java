package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ProductsTest extends BaseTest {
    @Test
    public void checkGoodsAdd() {
        loginPage.open();

        loginPage.login("standard_user", "secret_sauce");
        assertEquals(productsPage.getTitle(), "Products", "Заголовок не соответствует");

        productsPage.addGoodsToCart("Sauce Labs Bike Light");
        productsPage.addGoodsToCart(0);
        assertEquals(productsPage.checkCounterValue(), "2");
        assertEquals(productsPage.checkCounterValue("color"), "rgba(255, 255, 255, 1)");
        assertEquals(productsPage.checkCounterValue("background-color"), "rgba(226, 35, 26, 1)");
    }
}
