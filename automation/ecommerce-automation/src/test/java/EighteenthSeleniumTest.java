import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EighteenthSeleniumTest {

    @Test
    public void cartClearedAfterSuccessfulOrder() {

        // Open Chrome
        WebDriver driver = new ChromeDriver();

        // Open Products page
        driver.get(
            "file:///C:/Users/ADMIN/Desktop/Smart-Ecommerce-QA-Platform/frontend/products.html"
        );

        // Maximize browser
        driver.manage().window().maximize();

        // =========================================================
        // TC-018: Add Laptop to Cart
        // =========================================================

        driver.findElement(
            By.xpath(
                "//div[contains(@class,'product-card')]" +
                "[.//h3[text()='Laptop']]" +
                "//button[contains(text(),'Add to Cart')]"
            )
        ).click();

        // Accept "Laptop added to cart!" alert
        driver.switchTo().alert().accept();

        // =========================================================
        // Open Cart
        // =========================================================

        driver.findElement(
            By.xpath("//a[contains(text(),'Cart')]")
        ).click();

        // =========================================================
        // Open Checkout
        // =========================================================

        driver.findElement(
            By.xpath("//button[contains(text(),'Checkout')]")
        ).click();

        // =========================================================
        // Enter Customer Details
        // =========================================================

        driver.findElement(
            By.id("fullName")
        ).sendKeys("Test User");

        driver.findElement(
            By.id("checkoutEmail")
        ).sendKeys("test@example.com");

        driver.findElement(
            By.id("phone")
        ).sendKeys("9876543210");

        driver.findElement(
            By.id("address")
        ).sendKeys("Test Address");

        driver.findElement(
            By.id("city")
        ).sendKeys("Bengaluru");

        driver.findElement(
            By.id("pincode")
        ).sendKeys("560001");

        // =========================================================
        // Select Cash on Delivery
        // =========================================================

        driver.findElement(
            By.cssSelector("input[name='payment'][value='cod']")
        ).click();

        // =========================================================
        // Place Order
        // =========================================================

        driver.findElement(
            By.cssSelector("button.place-order-btn")
        ).click();

        // =========================================================
        // Verify Order Was Placed Successfully
        // =========================================================

        String message = driver.findElement(
            By.id("checkoutMessage")
        ).getText();

        Assert.assertTrue(
            message.contains("Order placed successfully"),
            "Order was not placed successfully"
        );

        // =========================================================
        // TC-018: Verify Cart Is Cleared After Successful Order
        // =========================================================

        // Open Cart again
        driver.findElement(
            By.xpath("//a[contains(text(),'Cart')]")
        ).click();

        // Read complete Cart page text
        String cartText = driver.findElement(
            By.tagName("body")
        ).getText();

        // Verify cart is empty/reset
        Assert.assertTrue(
            cartText.contains("0"),
            "Cart was not cleared after successful order"
        );

        // Close browser
        driver.quit();
    }
}