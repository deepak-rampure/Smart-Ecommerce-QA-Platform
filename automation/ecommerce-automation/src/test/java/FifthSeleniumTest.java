import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FifthSeleniumTest {

    @Test
    public void filterFashionProducts() {

        // Open Chrome
        WebDriver driver = new ChromeDriver();

        // Open Products page
        driver.get("file:///C:/Users/ADMIN/Desktop/Smart-Ecommerce-QA-Platform/frontend/products.html");

        // Maximize browser
        driver.manage().window().maximize();

        // TC-005: Click Fashion filter
        driver.findElement(
                By.xpath("//button[contains(text(),'Fashion')]")
        ).click();

        // Find product cards
        WebElement tshirt = driver.findElement(
                By.xpath("//div[contains(@class,'product-card') and .//h3[text()='Casual T-Shirt']]")
        );

        WebElement shoes = driver.findElement(
                By.xpath("//div[contains(@class,'product-card') and .//h3[text()='Running Shoes']]")
        );

        WebElement smartphone = driver.findElement(
                By.xpath("//div[contains(@class,'product-card') and .//h3[text()='Smartphone']]")
        );

        WebElement laptop = driver.findElement(
                By.xpath("//div[contains(@class,'product-card') and .//h3[text()='Laptop']]")
        );

        // Verify Fashion products are displayed
        Assert.assertTrue(
                tshirt.isDisplayed(),
                "Casual T-Shirt was not displayed"
        );

        Assert.assertTrue(
                shoes.isDisplayed(),
                "Running Shoes was not displayed"
        );

        // Verify Electronics products are hidden
        Assert.assertFalse(
                smartphone.isDisplayed(),
                "Smartphone was still displayed"
        );

        Assert.assertFalse(
                laptop.isDisplayed(),
                "Laptop was still displayed"
        );

        // Close browser
        driver.quit();
    }
}