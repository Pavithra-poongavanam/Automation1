package Ashke;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
public class UploadHistory {
	
			WebDriver driver = new ChromeDriver();
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30)); 
			long starttime;
		    JavascriptExecutor jsExecutor;
			
		@BeforeSuite		
			public void starttime()
			{
				 starttime= System.currentTimeMillis();
			}

		    @Test(priority = 0)
		    public void SetUp() throws InterruptedException {	    	
		        driver.get("http://103.81.157.84:8900/auth/login");
		         driver.manage().window().maximize();
		         Thread.sleep(2000);
		     }
		    
		    @Test(priority = 1)
		    public void TestValidLogin() throws InterruptedException {
		        WebElement emailfield = driver.findElement(By.id("login-email"));
		        WebElement passwordField = driver.findElement(By.id("login-password"));
		        WebElement loginButton = driver.findElement(By.xpath("/html/body/app-root/app-core/div[2]/div/app-login/div/div/div[2]/div/div/div[2]/form/div[4]/button"));
		        emailfield.sendKeys("skypro@gmail.com");
		        passwordField.sendKeys("@skypro123!#");
		        Thread.sleep(2000);

		        loginButton.click();
		        Thread.sleep(4000);
		        String currentUrl = driver.getCurrentUrl();
		        Assert.assertEquals(currentUrl, "http://103.81.157.84:8900/content/dashboard", "User did not navigate to the homepage.");
		    }
		    
		    @Test(priority = 2)
		    public void UploadHistoryNavigation() throws InterruptedException
		    {
		    	WebElement uploadHistory = driver.findElement(By.xpath("/html/body/app-root/app-core/div[2]/app-sidenav/mat-sidenav-container/mat-sidenav-content/div[1]/ul/li[12]/h2"));
		    	uploadHistory.click();
		    	Thread.sleep(2000);	    	
		    	}
		    
		    @Test(priority = 3)
		    public void Filter()
		    {
		    	WebElement filter = driver.findElement(By.xpath("/html/body/app-root/app-core/div[2]/div/app-upload-history/div/div/div[1]/div/div/div/div/button"));
		    	filter.click();
		    	
		    	 WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mat-select-0-panel")));
		         List<WebElement> options = dropdown.findElements(By.cssSelector("mat-option"));
		         for (WebElement option : options) {
		             option.click();
		             String isSelected = option.getAttribute("aria-selected");

		             if ("true".equals(isSelected)) {
		                 System.out.println(option.getText() + " is selected.");
		             } else {
		                 System.out.println("Error: " + option.getText() + " is deselected.");
		             }

		             option.click();
		             isSelected = option.getAttribute("aria-selected");

		             if ("false".equals(isSelected)) {
		                 System.out.println(option.getText() + " is deselected correctly.");
		             } else {
		                 System.out.println("Error: " + option.getText() + " is not deselected correctly.");
		             }
		             
		         }
		         WebElement outside = driver.findElement(By.xpath("/html/body/div[2]"));
		         outside.click();         
		                    }
		    
		    }


