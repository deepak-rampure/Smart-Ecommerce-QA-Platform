import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstSeleniumTest {

    @Test
    public void verifyLoginSuccessful() {

        // Open Chrome
        WebDriver driver = new ChromeDriver();

        // Open Login page
        driver.get(
            "file:///C:/Users/ADMIN/Desktop/Smart-Ecommerce-QA-Platform/frontend/login.html"
        );

        // Maximize browser
        driver.manage().window().maximize();

        // =========================================================
        // TC-001: Verify successful login
        // =========================================================

        // Enter email
        driver.findElement(
            By.id("email")
        ).sendKeys("test@example.com");

        // Enter password
        driver.findElement(
            By.id("password")
        ).sendKeys("Test@123");

        // Click Login button
        driver.findElement(
            By.cssSelector("button[type='submit']")
        ).click();

        // =========================================================
        // Verify successful login message
        // =========================================================

        String pageText = driver.findElement(
            By.tagName("body")
        ).getText();

        Assert.assertTrue(
            pageText.contains("Login successful!"),
            "Login was not successful"
        );

        // Close browser
        driver.quit();
    }
}