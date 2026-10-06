import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NinthSeleniumTest {

    @Test
    public void verifyTotalItemCount() {

        // Open Chrome
        WebDriver driver = new ChromeDriver();

        // Open Products page
        driver.get("file:///C:/Users/ADMIN/Desktop/Smart-Ecommerce-QA-Platform/frontend/products.html");

        // Maximize browser
        driver.manage().window().maximize();

        // Find Laptop
        WebElement laptop = driver.findElement(
                By.xpath("//div[contains(@class,'product-card') and .//h3[text()='Laptop']]")
        );

        // Add Laptop
        laptop.findElement(
                By.xpath(".//button[contains(text(),'Add to Cart')]")
        ).click();

        // Close alert
        driver.switchTo().alert().accept();

        // Find Smartphone
        WebElement smartphone = driver.findElement(
                By.xpath("//div[contains(@class,'product-card') and .//h3[text()='Smartphone']]")
        );

        // Add Smartphone
        smartphone.findElement(
                By.xpath(".//button[contains(text(),'Add to Cart')]")
        ).click();

        // Close alert
        driver.switchTo().alert().accept();

        // Open Cart
        driver.findElement(
                By.xpath("//a[contains(text(),'Cart')]")
        ).click();

        // Get cart page text
        String cartText = driver.findElement(By.tagName("body")).getText();

        // Verify both products are present
        Assert.assertTrue(
                cartText.contains("Laptop"),
                "Laptop was not found in cart"
        );

        Assert.assertTrue(
                cartText.contains("Smartphone"),
                "Smartphone was not found in cart"
        );

        // Verify total item count is 2
        Assert.assertTrue(
                cartText.contains("2"),
                "Total item count 2 was not displayed"
        );

        // Close browser
        driver.quit();
    }
}