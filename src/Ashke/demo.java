package Ashke;
		import java.nio.file.Paths;

import org.bouncycastle.oer.its.ieee1609dot2.basetypes.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

		public class demo {
			public static void main(String[] args) throws InterruptedException {
				WebDriver driver=new ChromeDriver();

		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		        driver.get("http://103.81.157.84:8900/auth/login");
		         driver.manage().window().maximize();
		         Thread.sleep(2000);

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

		    	WebElement uploadElement= driver.findElement(By.xpath("/html/body/app-root/app-core/div[2]/app-sidenav/mat-sidenav-container/mat-sidenav-content/div[1]/ul/li[2]"));
		    	uploadElement.click();
		    	Thread.sleep(2000);

		        WebElement shortFilmOption = driver.findElement(By.id("mat-button-toggle-1-button"));
		        shortFilmOption.click();

		        WebElement fileInput = driver.findElement(By.cssSelector("input[type='file']"));
		        String filePath = Paths.get("C:\\Users\\User\\Videos\\Captures\\dummy.mp4").toAbsolutePath().toString();
		        fileInput.sendKeys(filePath);
		        Thread.sleep(2000);

		        WebElement uploadFileButton = driver.findElement(By.xpath("//span[text()=\" Upload \"]"));
		        uploadFileButton.click();
		        Thread.sleep(10000);

		        WebElement progressPercentage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.percentage.os-t3-green")));
		        wait.until(ExpectedConditions.textToBePresentInElement(progressPercentage, "100%"));

		  String percentageString = progressPercentage.getText();
		        if(percentageString.equals("100%"))
		        {
		        	System.out.println("File uploaded successfully");
		        }
		        else {
					System.out.println("Could not upload file");
				}
		     //   Assert.assertEquals(percentageText.getText().trim(), "100%", "Progress did not reach 100%");

		        WebElement confirmationSnackbar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("simple-snack-bar.mat-simple-snackbar")));
		        WebElement confirmationMessage = confirmationSnackbar.findElement(By.cssSelector("span"));
		        String confirmmessage= confirmationMessage.getText();
		        System.out.println(confirmmessage);



		    }


	}


