import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EighthSeleniumTest {

    @Test
    public void removeProductFromCart() {

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

        // Find Laptop in cart
        WebElement laptopInCart = driver.findElement(
                By.xpath("//*[contains(text(),'Laptop')]")
        );

        // Find the Remove button associated with Laptop
        WebElement laptopCartItem = laptopInCart.findElement(
                By.xpath("./ancestor::*[contains(@class,'cart-item')][1]")
        );

        laptopCartItem.findElement(
                By.xpath(".//button[contains(text(),'Remove')]")
        ).click();

        // Get updated cart text
        String cartText = driver.findElement(By.tagName("body")).getText();

        // Verify Laptop is removed
        Assert.assertFalse(
                cartText.contains("Laptop"),
                "Laptop was not removed from cart"
        );

        // Verify Smartphone remains
        Assert.assertTrue(
                cartText.contains("Smartphone"),
                "Smartphone was removed from cart"
        );

        // Close browser
        driver.quit();
    }
}