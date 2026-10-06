import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SeventhSeleniumTest {

    @Test
    public void addMultipleProductsToCart() {

        // Open Chrome
        WebDriver driver = new ChromeDriver();

        // Open Products page
        driver.get("file:///C:/Users/ADMIN/Desktop/Smart-Ecommerce-QA-Platform/frontend/products.html");

        // Maximize browser
        driver.manage().window().maximize();

        // TC-007: Find Laptop
        WebElement laptop = driver.findElement(
                By.xpath("//div[contains(@class,'product-card') and .//h3[text()='Laptop']]")
        );

        // Add Laptop to cart
        laptop.findElement(
                By.xpath(".//button[contains(text(),'Add to Cart')]")
        ).click();

        // Close alert
        driver.switchTo().alert().accept();

        // TC-007: Find Smartphone
        WebElement smartphone = driver.findElement(
                By.xpath("//div[contains(@class,'product-card') and .//h3[text()='Smartphone']]")
        );

        // Add Smartphone to cart
        smartphone.findElement(
                By.xpath(".//button[contains(text(),'Add to Cart')]")
        ).click();

        // Close alert
        driver.switchTo().alert().accept();

        // Open Cart
        driver.findElement(
                By.xpath("//a[contains(text(),'Cart')]")
        ).click();

        // Get cart text
        String cartText = driver.findElement(By.tagName("body")).getText();

        // Verify Laptop is present
        Assert.assertTrue(
                cartText.contains("Laptop"),
                "Laptop was not added to cart"
        );

        // Verify Smartphone is present
        Assert.assertTrue(
                cartText.contains("Smartphone"),
                "Smartphone was not added to cart"
        );

        // Verify total amount
        Assert.assertTrue(
                cartText.contains("84998") || cartText.contains("84,998"),
                "Total amount 84998 was not displayed"
        );

        // Close browser
        driver.quit();
    }
}