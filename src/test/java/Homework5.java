import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework5 {
    WebDriver driver;

    public Homework5() {
    }

    @BeforeMethod
    public void setup() {
        this.driver = new FirefoxDriver();
        this.driver.manage().window().maximize();
        this.driver.get("https://shop.pragmatic.bg/index.php?route=product/product&product_id=43");
    }

    @AfterMethod
    public void tearDown() {
        this.driver.quit();
    }

    @Test
    public void waitTest() {
        WebDriverWait waitTenSec = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement addToCartBtn = driver.findElement(By.id("button-cart"));
        addToCartBtn.click();
        WebElement cartTotalBtn = driver.findElement(By.id("cart-total"));
        cartTotalBtn.click();
        waitTenSec.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".text-right a[href*='checkout/checkout']")));
        WebElement checkoutBtn = driver.findElement(By.cssSelector(".text-right i.fa-share"));
        checkoutBtn.click();
        String textCheckout = driver.findElement(By.cssSelector("#content h1")).getText();
        Assert.assertEquals(textCheckout, ("Checkout"));

    }

}
