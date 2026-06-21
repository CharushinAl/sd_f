import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {

    @Test
    public void checkLogin() {
        driver.findElement(By.cssSelector("#user-name")).sendKeys("standard_user");
        driver.findElement(By.cssSelector("#password")).sendKeys("secret_sauce");
        driver.findElement(By.cssSelector("#login-button")).click();

        assertEquals(driver.findElement(By.cssSelector(".title")).getText(), "Products");
    }

    @Test
    public void checkIncorrectLogin() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.cssSelector("#user-name")).sendKeys("");
        driver.findElement(By.cssSelector("#password")).sendKeys("secret_sauce");
        driver.findElement(By.cssSelector("#login-button")).click();

        assertTrue(driver.findElement(By.cssSelector("h3")).isDisplayed());
        assertEquals(driver.findElement(By.cssSelector("h3")).getText(), "Epic sadface: Username is required");
    }
}
