package Ashke;

import org.bouncycastle.oer.its.ieee1609dot2.basetypes.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Login {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
       // System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("http://103.81.157.84:8900/auth/login");
    }

    @Test
    public void testValidLogin() throws InterruptedException {
        WebElement usernameField = driver.findElement(By.id("login-email"));
        WebElement passwordField = driver.findElement(By.id("login-password"));
        WebElement loginButton = driver.findElement(By.xpath("/html/body/app-root/app-core/div[2]/div/app-login/div/div/div[2]/div/div/div[2]/form/div[4]/button"));
        usernameField.sendKeys("skypro@gmail.com");
        passwordField.sendKeys("@skypro123!#");
        Thread.sleep(2000);

        loginButton.click();
        Thread.sleep(4000);
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "http://103.81.157.84:8900/content/dashboard", "User did not navigate to the homepage.");
    }

    @Test
    public void testInvalidLogin() throws InterruptedException {
    	WebElement usernameField = driver.findElement(By.id("login-email"));
        WebElement passwordField = driver.findElement(By.id("login-password"));
        WebElement loginButton = driver.findElement(By.xpath("/html/body/app-root/app-core/div[2]/div/app-login/div/div/div[2]/div/div/div[2]/form/div[4]/button"));

        usernameField.sendKeys("skyproo@gmail.com");
        passwordField.sendKeys("@skypro1234!#");
        Thread.sleep(2000);
        loginButton.click();

        WebElement errorMessage = driver.findElement(By.xpath("//span[text()='Invalid credentials. Please check your username and password and try again.']"));
        Assert.assertEquals(errorMessage.getText(), "Invalid credentials. Please check your username and password and try again.", "Error message did not match.");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
