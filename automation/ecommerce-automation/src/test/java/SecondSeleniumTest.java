import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SecondSeleniumTest {

    @Test
    public void searchExistingProduct() {

        // Open Chrome
        WebDriver driver = new ChromeDriver();

        // Open Products page
        driver.get("file:///C:/Users/ADMIN/Desktop/Smart-Ecommerce-QA-Platform/frontend/products.html");

        // Maximize browser
        driver.manage().window().maximize();

        // TC-002: Search for an existing product
        driver.findElement(By.id("searchInput"))
              .sendKeys("Laptop");

        // Get all visible text from the page
        String pageText = driver.findElement(By.tagName("body"))
                                .getText();

        // Verify Laptop is displayed
        Assert.assertTrue(
                pageText.contains("Laptop"),
                "Laptop product was not displayed"
        );

        // Close browser
        driver.quit();
    }
}