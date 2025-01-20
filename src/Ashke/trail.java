package Ashke;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import graphql.org.antlr.v4.runtime.tree.Tree;

public class trail {
		
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
	        highlightElement(driver, emailfield);
	        emailfield.sendKeys("skypro@gmail.com");

	        WebElement passwordField = driver.findElement(By.id("login-password"));
	        highlightElement(driver, passwordField);
	        passwordField.sendKeys("@skypro123!#");
	        Thread.sleep(1000);

	        WebElement loginButton = driver.findElement(By.xpath("/html/body/app-root/app-core/div[2]/div/app-login/div/div/div[2]/div/div/div[2]/form/div[4]/button"));
	        highlightElement(driver, loginButton);
	        loginButton.click();
	        Thread.sleep(4000);
	        String currentUrl = driver.getCurrentUrl();
	        Assert.assertEquals(currentUrl, "http://103.81.157.84:8900/content/dashboard", "User did not navigate to the homepage.");
	        Thread.sleep(2000);
	        
	    }
		     
		 @Test(priority = 2)		   		  
		    public void EditEpisode() throws Exception
		    {
		    	WebElement Episode= driver.findElement(By.xpath("/html/body/app-root/app-core/div[2]/app-sidenav/mat-sidenav-container/mat-sidenav-content/div[1]/ul/li[7]/h2"));
		        highlightElement(driver, Episode);
		    	Episode.click();
				Thread.sleep(2000);		
				
				WebElement Episode1 = driver.findElement(By.xpath("/html/body/app-root/app-core/div[2]/div/app-file-list/div/div/div/div[2]/div[2]/table/tbody/tr[1]/td[3]/a"));
		        highlightElement(driver, Episode1);
				Episode1.click();
				Thread.sleep(2000);
		    }
				
		    
		    	
	@Test(priority = 3)
    public void Publish() throws InterruptedException
    {
		 WebElement showTitle = driver.findElement(By.id("mat-input-0"));
	     highlightElement(driver, showTitle);
	     showTitle.sendKeys(Keys.CONTROL + "a");
	     showTitle.sendKeys(Keys.DELETE);	
	     Thread.sleep(2000);
    	WebElement publish = driver.findElement(By.xpath("/html/body/app-root/app-core/div[2]/div/app-file-edit/div/form/div[1]/div/div[2]/div/mat-slide-toggle"));
    	highlightElement(driver, publish);
    	publish.click();
    	Thread.sleep(2000);		    			    	

    }		    
	@Test(priority = 4)
    public void CastnCrew() throws InterruptedException
    {
    	WebElement castname = driver.findElement(By.id("mat-input-2"));
        highlightElement(driver, castname);
        castname.sendKeys(Keys.CONTROL + "a");
        castname.sendKeys(Keys.DELETE);
    	castname.sendKeys("da");
    	castname.click();
    	Thread.sleep(1000);
    	WebElement castimg = driver.findElement(By.xpath("//*[@id=\"mat-option-6\"]/span/span"));
    	castimg.click();
    	Thread.sleep(1000);
    	WebElement character1 = driver.findElement(By.xpath("/html/body/app-root/app-core/div[2]/div/app-file-edit/div/form/div[2]/div/div[2]/section[6]/div[2]/div/div/div[1]/div[2]/div[2]/div[1]/input"));
        highlightElement(driver, character1);
    	character1.sendKeys("Testing");		    			  
    	Thread.sleep(1000);

    	WebElement crewname = driver.findElement(By.id("mat-input-3"));
        highlightElement(driver, crewname);
        crewname.sendKeys(Keys.CONTROL + "a");
        crewname.sendKeys(Keys.DELETE);
    	crewname.sendKeys("ra");
    	crewname.click();
    	Thread.sleep(1000);
    	WebElement charimg = driver.findElement(By.xpath("//*[@id=\"mat-option-13\"]/span/span"));
    	charimg.click();
    	Thread.sleep(1000);

    	WebElement character2 = driver.findElement(By.xpath("/html/body/app-root/app-core/div[2]/div/app-file-edit/div/form/div[2]/div/div[2]/section[6]/div[3]/div/div/div[1]/div[2]/div[2]/div[1]/input"));
        highlightElement(driver, character2);
    	character2.sendKeys("Testing");
    	Thread.sleep(1000);
    		   
    }			   
 
    @Test(priority = 5)
    public void Save() throws InterruptedException
    {
    	WebElement savebutton = driver.findElement(By.xpath("/html/body/app-root/app-core/div[2]/div/app-file-edit/div/form/footer/div/button[2]"));
    	highlightElement(driver, savebutton);
    	Thread.sleep(1000);    	
    	savebutton.click();
    	
    			
    	WebElement confirmation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("simple-snack-bar.mat-simple-snackbar")));
        WebElement confirmationMessage = confirmation.findElement(By.cssSelector("span"));
        String confirmmessage= confirmationMessage.getText();
        System.out.println(confirmmessage);
    }
   
    private void scrollToElement(WebElement element) {
        jsExecutor.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
        
        private static WebElement previouslyHighlightedElement = null;

	    private static void highlightElement(WebDriver driver, WebElement element) {
	        JavascriptExecutor js = (JavascriptExecutor) driver;

	        try {
	            js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", element);

	            if (previouslyHighlightedElement != null && isElementPresentAndDisplayed(driver, previouslyHighlightedElement)) {
	                js.executeScript("arguments[0].style.border=''", previouslyHighlightedElement);
	            }
	        } catch (StaleElementReferenceException e) {
	            System.out.println("Previously highlighted element is stale and cannot be reset.");
	        }

	        js.executeScript("arguments[0].style.border='3px solid red'", element);
	        previouslyHighlightedElement = element; // Keep track of the currently highlighted element

	        try {
	            Thread.sleep(500); // Pause briefly for visibility
	        } catch (InterruptedException e) {
	            Thread.currentThread().interrupt();
	        }
	    }

	    private static boolean isElementPresentAndDisplayed(WebDriver driver, WebElement element) {
	        try {
	            return element.isDisplayed();
	        } catch (NoSuchElementException | StaleElementReferenceException e) {
	            return false;
	        }
	    }
	    @AfterSuite
	    public void endtime()
	    {
	    	long endtime= System.currentTimeMillis();
	    	long totalTime = endtime- starttime;
	    	System.out.println("Total Time taken to execute the suit is :"+totalTime);			
	    }

    }

    
   	
	


