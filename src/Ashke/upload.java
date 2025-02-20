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
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class upload
{
	WebDriver driver=new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
	long starttime;

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
    public void TestUploadForShortFilm() throws InterruptedException {

    	WebElement uploadelElement= driver.findElement(By.xpath("/html/body/app-root/app-core/div[2]/app-sidenav/mat-sidenav-container/mat-sidenav-content/div[1]/ul/li[2]"));
    	uploadelElement.click();
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
        	System.out.println("Short Film uploaded successfully");
        }
        else {
			System.out.println("Could not upload file");
		}
        WebElement confirmationSnackbar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("simple-snack-bar.mat-simple-snackbar")));
        WebElement confirmationMessage = confirmationSnackbar.findElement(By.cssSelector("span"));
        String confirmmessage= confirmationMessage.getText();
        System.out.println(confirmmessage);
        Thread.sleep(2000);

    }


    /*


    @Test(priority = 3)
    public void TestUploadForMovies() throws InterruptedException {

    	WebElement uploadElement= driver.findElement(By.xpath("/html/body/app-root/app-core/div[2]/app-sidenav/mat-sidenav-container/mat-sidenav-content/div[1]/ul/li[2]"));
    	uploadElement.click();
    	Thread.sleep(2000);

        WebElement moviesOption = driver.findElement(By.id("mat-button-toggle-2-button"));
        moviesOption.click();

        WebElement fileInput = driver.findElement(By.xpath("/html/body/app-root/app-core/div[2]/div/app-upload-content/div/div/div/div/div[1]/div/label/input"));
        String filePath = Paths.get("C:\\Users\\User\\Videos\\Captures\\movie.mp4").toAbsolutePath().toString();
        fileInput.sendKeys(filePath);
        Thread.sleep(2000);
    }

        WebElement uploadFileButton = driver.findElement(By.xpath("//span[text()=\" Upload \"]"));
        uploadFileButton.click();

        WebElement progressPercentage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.percentage.os-t3-green")));
        wait.until(ExpectedConditions.textToBePresentInElement(progressPercentage, "100%"));

  String percentageString = progressPercentage.getText();
        if(percentageString.equals("100%"))
        {
        	System.out.println("Short Film uploaded successfully");
        }
        else {
			System.out.println("Could not upload file");
		}
        WebElement confirmationSnackbar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("simple-snack-bar.mat-simple-snackbar")));
        WebElement confirmationMessage = confirmationSnackbar.findElement(By.cssSelector("span"));
        String confirmmessage= confirmationMessage.getText();
        System.out.println(confirmmessage);
        Thread.sleep(2000);
    }

   @Test(priority = 3)
    public void testUploadForEpisodes() {



        WebElement episodesOption = driver.findElement(By.id("mat-button-toggle-3-button"));
        episodesOption.click();

        WebElement addFilesButton = driver.findElement(By.id("addFilesButton"));
        Assert.assertTrue(addFilesButton.isEnabled(), "Add Files button is not enabled for episodes option");

        addFilesButton.click();

        WebElement fileInput = driver.findElement(By.id("fileInput"));
        String filePath = Paths.get("path/to/your/file.txt").toAbsolutePath().toString();  // Replace with your file path
        fileInput.sendKeys(filePath);

        WebElement uploadFileButton = driver.findElement(By.xpath("//span[text()=\" Upload \"]"));
        uploadFileButton.click();

        // Step 6: Verify confirmation message
        WebElement confirmationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("confirmationMessage")));
        Assert.assertEquals(confirmationMessage.getText(), "File uploaded successfully!", "File upload failed for episodes option");
    }

    @Test(priority = 4)
    public void testUploadForSongs() {

    	WebElement uploadelElement= driver.findElement(By.xpath("/html/body/app-root/app-core/div[2]/app-sidenav/mat-sidenav-container/mat-sidenav-content/div[1]/ul/li[2]"));
    	uploadelElement.click();
    	Thread.sleep(2000);

        WebElement songsOption = driver.findElement(By.id("mat-button-toggle-4-button"));
        songsOption.click();

        WebElement addFilesButton = driver.findElement(By.id("addFilesButton"));
        Assert.assertTrue(addFilesButton.isEnabled(), "Add Files button is not enabled for songs option");

        addFilesButton.click();

        WebElement fileInput = driver.findElement(By.id("fileInput"));
        String filePath = Paths.get("path/to/your/file.txt").toAbsolutePath().toString();  // Replace with your file path
        fileInput.sendKeys(filePath);

        // Step 5: Click "Upload" button
        WebElement uploadFileButton = driver.findElement(By.xpath("//span[text()=\" Upload \"]"));
        uploadFileButton.click();

        // Step 6: Verify confirmation message
        WebElement confirmationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("confirmationMessage")));
        Assert.assertEquals(confirmationMessage.getText(), "File uploaded successfully!", "File upload failed for songs option");
    }

    @AfterMethod
    public void tearDown() {
        // Close the browser after tests
        if (driver != null) {
            driver.quit();
        }
    }
    */
    @AfterSuite
    public void endtime()
    {
    	long endtime= System.currentTimeMillis();
    	long totalTime = endtime- starttime;
    	System.out.println("Total Time taken to execute the suit is :"+totalTime);
    }
}
