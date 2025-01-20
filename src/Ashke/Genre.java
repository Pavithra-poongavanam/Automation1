package Ashke;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

	public class Genre {		
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
	    public void GenreNavigation() throws InterruptedException
	    {
	    	WebElement advisorytag = driver.findElement(By.xpath("/html/body/app-root/app-core/div[2]/app-sidenav/mat-sidenav-container/mat-sidenav-content/div[1]/ul/li[11]/h2"));
	    	advisorytag.click();
	    	Thread.sleep(2000);	    	
	    	}
	    
	    @Test(priority = 3)
		public void Search() throws InterruptedException
		{	
			String[] searchTerms = {"Thriller","Horror"};
		        for (String searchTerm : searchTerms) {
		            System.out.println("Performing search for: " + searchTerm);
		                        WebElement searchInput = driver.findElement(By.xpath("/html/body/app-root/app-core/div[2]/div/app-genre-list/div/div/div/div[1]/app-onnet-search-bar/div/input"));
		                        searchInput.click();
		            searchInput.clear();  
		            searchInput.sendKeys(searchTerm + Keys.RETURN);}		           
		        driver.navigate().refresh();
		        Thread.sleep(2000);  
		 }      
					
	    @Test(priority = 4)
	    public void CreateGenre() throws InterruptedException
	    {
			WebElement CreateGenre = driver.findElement(By.xpath("/html/body/app-root/app-core/div[2]/div/app-genre-list/div/mat-toolbar/div/button/span[1]"));
			CreateGenre.click();
			Thread.sleep(2000);
			WebElement tagname = driver.findElement(By.id("genre"));
			tagname.sendKeys("Testing");					    	
		    	String tagValue = tagname.getAttribute("value").trim();
		    	 if (tagValue.isEmpty()) {
		                System.out.println("Error: Genre field is empty!");
		            }		    	 
		            System.out.println("Validation passed: Genre field is filled.");		           
		    	WebElement save = driver.findElement(By.xpath("//*[@id=\"mat-dialog-0\"]/app-genre-edit/div/div[2]/button[2]"));
		    	save.click();	    		    	
		    	WebElement successmessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("simple-snack-bar.mat-simple-snackbar")));
				        WebElement confirmationMessage = successmessage.findElement(By.cssSelector("span"));
				        String confirmmessage= confirmationMessage.getText();
				      //  System.out.println(confirmmessage);
				        Thread.sleep(2000);				        
				        if(confirmmessage.contains("Saved")) {
					        System.out.println(confirmmessage);
				        	System.out.println("Genre Created Successfully");}				 
				        else {
					        System.out.println(confirmmessage);
							System.out.println("Genre is not created");
						}
		}
}




