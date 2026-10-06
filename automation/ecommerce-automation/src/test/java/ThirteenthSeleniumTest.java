import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ThirteenthSeleniumTest {

    @Test
    public void emptyLoginFields() {

        // Open Chrome
        WebDriver driver = new ChromeDriver();

        // Open Login page
        driver.get("file:///C:/Users/ADMIN/Desktop/Smart-Ecommerce-QA-Platform/frontend/login.html");

        // Maximize browser
        driver.manage().window().maximize();

        // TC-013: Leave email and password empty
        // Click Login button
        driver.findElement(
                By.xpath("//button[contains(text(),'Login')]")
        ).click();

        // Get page text
        String pageText = driver.findElement(By.tagName("body")).getText();

        // Verify required field validation
        Assert.assertTrue(
                pageText.contains("required")
                        || pageText.contains("Please fill")
                        || pageText.contains("Email"),
                "Required field validation was not displayed"
        );

        // Close browser
        driver.quit();
    }
}