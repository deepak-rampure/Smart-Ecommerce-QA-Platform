import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TwelfthSeleniumTest {

    @Test
    public void invalidLogin() {

        // Open Chrome
        WebDriver driver = new ChromeDriver();

        // Open Login page
        driver.get("file:///C:/Users/ADMIN/Desktop/Smart-Ecommerce-QA-Platform/frontend/login.html");

        // Maximize browser
        driver.manage().window().maximize();

        // TC-012: Enter invalid email
        driver.findElement(By.id("email"))
                .sendKeys("wrong@example.com");

        // Enter invalid password
        driver.findElement(By.id("password"))
                .sendKeys("wrong123");

        // Click Login button
        driver.findElement(
                By.xpath("//button[contains(text(),'Login')]")
        ).click();

        // Get page text
        String pageText = driver.findElement(By.tagName("body")).getText();

        // Verify invalid login message
        Assert.assertTrue(
                pageText.contains("Invalid email or password"),
                "Invalid login message was not displayed"
        );

        // Close browser
        driver.quit();
    }
}