import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FourthSeleniumTest {

    @Test
    public void filterElectronicsProducts() {

        // Open Chrome
        WebDriver driver = new ChromeDriver();

        // Open Products page
        driver.get("file:///C:/Users/ADMIN/Desktop/Smart-Ecommerce-QA-Platform/frontend/products.html");

        // Maximize browser
        driver.manage().window().maximize();

        // TC-004: Click Electronics filter
        driver.findElement(
                By.xpath("//button[contains(text(),'Electronics')]")
        ).click();

        // Find product cards
        WebElement smartphone = driver.findElement(
                By.xpath("//div[contains(@class,'product-card') and .//h3[text()='Smartphone']]")
        );

        WebElement laptop = driver.findElement(
                By.xpath("//div[contains(@class,'product-card') and .//h3[text()='Laptop']]")
        );

        WebElement tshirt = driver.findElement(
                By.xpath("//div[contains(@class,'product-card') and .//h3[text()='Casual T-Shirt']]")
        );

        WebElement shoes = driver.findElement(
                By.xpath("//div[contains(@class,'product-card') and .//h3[text()='Running Shoes']]")
        );

        // Verify Electronics products are displayed
        Assert.assertTrue(
                smartphone.isDisplayed(),
                "Smartphone was not displayed"
        );

        Assert.assertTrue(
                laptop.isDisplayed(),
                "Laptop was not displayed"
        );

        // Verify Fashion products are hidden
        Assert.assertFalse(
                tshirt.isDisplayed(),
                "Casual T-Shirt was still displayed"
        );

        Assert.assertFalse(
                shoes.isDisplayed(),
                "Running Shoes was still displayed"
        );

        // Close browser
        driver.quit();
    }
}