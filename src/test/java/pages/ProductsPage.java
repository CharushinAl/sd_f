package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {
    private static final String ADD_TO_CART =
            "//*[text()='%s']//ancestor::div[@class='inventory_item']//child::button[text()='Add to cart']";
    private final By title = By.cssSelector(".title");
    private final By counter = By.xpath(DATA_TEST_PATTERN.formatted("shopping-cart-badge"));

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return driver.findElement(title).getText();
    }

    public void addGoodsToCart(String goodName) {
        By addToCard = By.xpath(ADD_TO_CART.formatted(goodName));
        driver.findElement(addToCard).click();
    }

    public void addGoodsToCart(int goodIndex) {
        driver.findElements(By.xpath("//*[text()='Add to cart']")).get(goodIndex).click();
    }

    public String checkCounterValue(String param) {
        return driver.findElement(counter).getCssValue(param);
    }

    public String checkCounterValue() {
        return driver.findElement(counter).getText();
    }
}
