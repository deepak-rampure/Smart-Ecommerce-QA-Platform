import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FourteenthSeleniumTest {

    @Test
    public void openCheckoutWithProducts() {

        // Open Chrome
        WebDriver driver = new ChromeDriver();

        // Open Products page
        driver.get("file:///C:/Users/ADMIN/Desktop/Smart-Ecommerce-QA-Platform/frontend/products.html");

        // Maximize browser
        driver.manage().window().maximize();

        // TC-014: Add Laptop to cart
        driver.findElement(
                By.xpath("//div[contains(@class,'product-card')][.//h3[text()='Laptop']]//button[contains(text(),'Add to Cart')]")
        ).click();

        // Handle "Laptop added to cart!" alert
        driver.switchTo().alert().accept();

        // Open Cart
        driver.findElement(
                By.xpath("//a[contains(text(),'Cart')]")
        ).click();

        // Click Checkout
        driver.findElement(
                By.xpath("//button[contains(text(),'Checkout')]")
        ).click();

        // Get page text
        String pageText = driver.findElement(By.tagName("body")).getText();

        // Verify Checkout page
        Assert.assertTrue(
                pageText.contains("Checkout"),
                "Checkout page was not displayed"
        );

        // Close browser
        driver.quit();
    }
}