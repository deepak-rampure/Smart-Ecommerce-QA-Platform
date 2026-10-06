import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SixthSeleniumTest {

    @Test
    public void addSingleProductToCart() {

        // Open Chrome
        WebDriver driver = new ChromeDriver();

        // Open Products page
        driver.get("file:///C:/Users/ADMIN/Desktop/Smart-Ecommerce-QA-Platform/frontend/products.html");

        // Maximize browser
        driver.manage().window().maximize();

        // TC-006: Find Laptop product
        WebElement laptop = driver.findElement(
                By.xpath("//div[contains(@class,'product-card') and .//h3[text()='Laptop']]")
        );

        // Click Laptop's Add to Cart button
        laptop.findElement(
                By.xpath(".//button[contains(text(),'Add to Cart')]")
        ).click();
        driver.switchTo().alert().accept();

        // Open Cart page
        driver.findElement(
                By.xpath("//a[contains(text(),'Cart')]")
        ).click();

        // Get cart page text
        String cartText = driver.findElement(By.tagName("body")).getText();

        // Verify Laptop is present
        Assert.assertTrue(
                cartText.contains("Laptop"),
                "Laptop was not added to cart"
        );

        // Verify quantity/count
        Assert.assertTrue(
                cartText.contains("1"),
                "Cart item count was not 1"
        );

        // Verify amount
      Assert.assertTrue(
                cartText.contains("59999") || cartText.contains("59,999"),
                "Laptop price 59999 was not displayed"
        );

        // Close browser
        driver.quit();
    }
}