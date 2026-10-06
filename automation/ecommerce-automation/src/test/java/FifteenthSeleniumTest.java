import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FifteenthSeleniumTest {

    @Test
    public void emptyCheckoutFields() {

        // Open Chrome
        WebDriver driver = new ChromeDriver();

        // Open Products page
        driver.get("file:///C:/Users/ADMIN/Desktop/Smart-Ecommerce-QA-Platform/frontend/products.html");

        // Maximize browser
        driver.manage().window().maximize();

        // TC-015: Add Laptop to cart
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

        // Click Place Order without entering any customer details
        driver.findElement(
                By.xpath("//button[contains(text(),'Place Order')]")
        ).click();

        // Find required customer field
        String validationMessage = driver.findElement(
                By.cssSelector("input[required]")
        ).getAttribute("validationMessage");

        // Verify HTML5 required-field validation
        Assert.assertFalse(
                validationMessage.isEmpty(),
                "Required field validation was not triggered"
        );

        // Close browser
        driver.quit();
    }
}