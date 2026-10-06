import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EleventhSeleniumTest {

    @Test
    public void validLogin() {

        // Open Chrome
        WebDriver driver = new ChromeDriver();

        // Open Login page
        driver.get("file:///C:/Users/ADMIN/Desktop/Smart-Ecommerce-QA-Platform/frontend/login.html");

        // Maximize browser
        driver.manage().window().maximize();

        // TC-011: Enter valid email
        driver.findElement(By.id("email"))
                .sendKeys("test@example.com");

        // Enter valid password
        driver.findElement(By.id("password"))
                .sendKeys("Test@123");

        // Click Login button
        driver.findElement(
                By.xpath("//button[contains(text(),'Login')]")
        ).click();

        // Get page text
        String pageText = driver.findElement(By.tagName("body")).getText();

        // Verify successful login
        Assert.assertTrue(
                pageText.contains("Login successful"),
                "Login successful message was not displayed"
        );

        // Close browser
        driver.quit();
    }
}