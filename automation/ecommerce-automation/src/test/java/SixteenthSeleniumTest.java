import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SixteenthSeleniumTest {

    @Test
    public void checkoutWithoutPaymentMethod() {

        // Open Chrome
        WebDriver driver = new ChromeDriver();

        // Open Products page
        driver.get("file:///C:/Users/ADMIN/Desktop/Smart-Ecommerce-QA-Platform/frontend/products.html");

        // Maximize browser
        driver.manage().window().maximize();

        // TC-016: Add Laptop to cart
        driver.findElement(
                By.xpath("//div[contains(@class,'product-card')][.//h3[text()='Laptop']]//button[contains(text(),'Add to Cart')]")
        ).click();

        // Accept alert
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

        // Do NOT select any payment method

        // Click Place Order
        driver.findElement(
                By.cssSelector("button.place-order-btn")
        ).click();

        // Check whether any payment option is selected
      boolean paymentSelected = !driver.findElements(
        By.cssSelector("input[name='payment']:checked")
        ).isEmpty();

        // Payment method should NOT be selected
        Assert.assertFalse(
                paymentSelected,
                "Payment method was selected unexpectedly"
        );

        // Verify order was not successfully placed
        String message = driver.findElement(
                By.id("checkoutMessage")
        ).getText();

        Assert.assertFalse(
                message.contains("Order placed successfully"),
                "Order was placed without selecting payment method"
        );

        // Close browser
        driver.quit();
    }
}