import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TenthSeleniumTest {

    @Test
    public void verifyTotalAmount() {

        // Open Chrome
        WebDriver driver = new ChromeDriver();

        // Open Products page
        driver.get("file:///C:/Users/ADMIN/Desktop/Smart-Ecommerce-QA-Platform/frontend/products.html");

        // Maximize browser
        driver.manage().window().maximize();

        // Add Smartphone
        WebElement smartphone = driver.findElement(
                By.xpath("//div[contains(@class,'product-card') and .//h3[text()='Smartphone']]")
        );

        smartphone.findElement(
                By.xpath(".//button[contains(text(),'Add to Cart')]")
        ).click();

        driver.switchTo().alert().accept();

        // Add Casual T-Shirt
        WebElement tshirt = driver.findElement(
                By.xpath("//div[contains(@class,'product-card') and .//h3[text()='Casual T-Shirt']]")
        );

        tshirt.findElement(
                By.xpath(".//button[contains(text(),'Add to Cart')]")
        ).click();

        driver.switchTo().alert().accept();

        // Add Running Shoes
        WebElement shoes = driver.findElement(
                By.xpath("//div[contains(@class,'product-card') and .//h3[text()='Running Shoes']]")
        );

        shoes.findElement(
                By.xpath(".//button[contains(text(),'Add to Cart')]")
        ).click();

        driver.switchTo().alert().accept();

        // Open Cart
        driver.findElement(
                By.xpath("//a[contains(text(),'Cart')]")
        ).click();

        // Get cart page text
        String cartText = driver.findElement(By.tagName("body")).getText();

        // Verify products
        Assert.assertTrue(
                cartText.contains("Smartphone"),
                "Smartphone was not found in cart"
        );

        Assert.assertTrue(
                cartText.contains("Casual T-Shirt"),
                "Casual T-Shirt was not found in cart"
        );

        Assert.assertTrue(
                cartText.contains("Running Shoes"),
                "Running Shoes was not found in cart"
        );

        // Verify total amount
        Assert.assertTrue(
                cartText.contains("28297") || cartText.contains("28,297"),
                "Total amount 28297 was not displayed"
        );

        // Close browser
        driver.quit();
    }
}