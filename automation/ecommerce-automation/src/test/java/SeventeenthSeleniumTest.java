import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SeventeenthSeleniumTest {

    @Test
    public void placeOrderSuccessfully() {

        // Open Chrome
        WebDriver driver = new ChromeDriver();

        // Open Products page
        driver.get("file:///C:/Users/ADMIN/Desktop/Smart-Ecommerce-QA-Platform/frontend/products.html");

        // Maximize browser
        driver.manage().window().maximize();

        // TC-017: Add Laptop to cart
        driver.findElement(
                By.xpath("//div[contains(@class,'product-card')][.//h3[text()='Laptop']]//button[contains(text(),'Add to Cart')]")
        ).click();

        // Accept "Laptop added to cart!" alert
        driver.switchTo().alert().accept();

        // Open Cart
        driver.findElement(
                By.xpath("//a[contains(text(),'Cart')]")
        ).click();

        // Open Checkout
        driver.findElement(
                By.xpath("//button[contains(text(),'Checkout')]")
        ).click();

        // Enter customer details
        driver.findElement(By.id("fullName"))
                .sendKeys("Test User");

        driver.findElement(By.id("checkoutEmail"))
                .sendKeys("test@example.com");

        driver.findElement(By.id("phone"))
                .sendKeys("9876543210");

        driver.findElement(By.id("address"))
                .sendKeys("Test Address");

        driver.findElement(By.id("city"))
                .sendKeys("Bengaluru");

        driver.findElement(By.id("pincode"))
                .sendKeys("560001");

        // Select Cash on Delivery
        driver.findElement(
                By.cssSelector("input[name='payment'][value='cod']")
        ).click();

        // Click Place Order
        driver.findElement(
                By.cssSelector("button.place-order-btn")
        ).click();

        // Get checkout message
        String message = driver.findElement(
                By.id("checkoutMessage")
        ).getText();

        // Verify successful order
        Assert.assertTrue(
                message.contains("Order placed successfully"),
                "Order was not placed successfully"
        );

        // Close browser
        driver.quit();
    }
}