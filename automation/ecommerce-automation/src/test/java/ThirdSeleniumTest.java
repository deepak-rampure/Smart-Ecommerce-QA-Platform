import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ThirdSeleniumTest {

    @Test
    public void searchNonExistingProduct() {

        // Open Chrome
        WebDriver driver = new ChromeDriver();

        // Open Products page
        driver.get("file:///C:/Users/ADMIN/Desktop/Smart-Ecommerce-QA-Platform/frontend/products.html");

        // Maximize browser
        driver.manage().window().maximize();

        // TC-003: Search for a non-existing product
        driver.findElement(By.id("searchInput"))
                .sendKeys("XYZ");

        // Get page text
        String pageText = driver.findElement(By.tagName("body"))
                .getText();

        // Verify XYZ is NOT displayed
        Assert.assertFalse(
                pageText.contains("XYZ"),
                "Non-existing product XYZ was displayed"
        );

        // Close browser
        driver.quit();
    }
}