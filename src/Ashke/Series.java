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



	public class Series {
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
	    }

		@Test(priority = 2)
		public void SeriesNavigation() throws InterruptedException
		{
			WebElement Series= driver.findElement(By.xpath("/html/body/app-root/app-core/div[2]/app-sidenav/mat-sidenav-container/mat-sidenav-content/div[1]/ul/li[6]/h2"));
            highlightElement(driver, Series);

			Series.click();
			Thread.sleep(2000);		
		}
	

		@Test(priority = 3)
		public void SearchSeries() throws InterruptedException
		{
			String[] searchTerms = {"Stranger things", "Game of Thrones"};
	        for (String searchTerm : searchTerms) 
	        {
	            System.out.println("Performing search for: " + searchTerm);            
	            WebElement searchInput = driver.findElement(By.xpath("/html/body/app-root/app-core/div[2]/div/app-series-list/div/div/div/div[1]/app-onnet-search-bar/div/input"));
	            highlightElement(driver, searchInput);

	            searchInput.click();
	            searchInput.clear();  
	            searchInput.sendKeys(searchTerm + Keys.RETURN);  
	            Thread.sleep(3000);
	            searchInput.clear();    
	        }                 
	       driver.navigate().refresh();	
		}
		
	
		@Test(priority = 4)
		public void CreateSeries() throws InterruptedException
		{
			WebElement createseries = driver.findElement(By.xpath("/html/body/app-root/app-core/div[2]/div/app-series-list/div/mat-toolbar/div/button/span[1]"));
            highlightElement(driver, createseries);
			createseries.click();
		    String currentUrl = driver.getCurrentUrl();
		  System.out.println(currentUrl);
		    if(currentUrl.equals("http://103.81.157.84:8900/content/series/add-edit"))
		    {
		    	System.out.println("Navigated to upload page");
		    }
		    else {
				System.out.println("Couldn't navigate to upload page");
			}
		    Thread.sleep(1000);
		}
		
	
		@Test(priority = 5)
		public void TitleInfo() throws InterruptedException
		{
			WebElement mainTitle = driver.findElement(By.id("maintitle"));
            highlightElement(driver, mainTitle);

			mainTitle.sendKeys("Series Testing");
			
			WebElement langugedropdown = driver.findElement(By.xpath("//*[@id=\"TitleInfo\"]/div[2]/div[2]/div/div/select"));
            highlightElement(driver, langugedropdown);
			langugedropdown.click();
			Thread.sleep(500);
		      Select languageSelect = new Select(langugedropdown);  
		      List<WebElement> languageoption = languageSelect.getOptions();
		      Random rand = new Random();
		      int randomlanguageIndex = rand.nextInt(languageoption.size() - 1) + 1; 
		      languageSelect.selectByIndex(randomlanguageIndex);
		      String selectedlanguageOptionText = languageoption.get(randomlanguageIndex).getText();
		      System.out.println("Language Selected is: " + selectedlanguageOptionText);
									
			WebElement title = driver.findElement(By.id("title"));
            highlightElement(driver, title);

			title.sendKeys("Testing");
			
			WebElement sublanguage = driver.findElement(By.xpath("//*[@id=\"TitleInfo\"]/div[2]/div[3]/div/div[2]/div/select"));
            highlightElement(driver, sublanguage);

			sublanguage.click();
			Thread.sleep(500);
		      Select sublanguageSelect = new Select(sublanguage);  
		      List<WebElement> sublanguageoption = sublanguageSelect.getOptions();
		    //  Random rand = new Random();
		      int randomsublanguageIndex = rand.nextInt(sublanguageoption.size() - 1) + 1; 
		      sublanguageSelect.selectByIndex(randomsublanguageIndex);
		      String selectedsublanguageOptionText = sublanguageoption.get(randomsublanguageIndex).getText();
		      System.out.println("Language Selected is: " + selectedsublanguageOptionText);
			
		      String languageValue = langugedropdown.getAttribute("value").trim();
	            String titleValue = mainTitle.getAttribute("value").trim();

	            if (languageValue.isEmpty()) {
	                System.out.println("Error: Language field is empty!");
	                //throw new Exception("Language field must not be empty.");
	            }

	            if (titleValue.isEmpty()) {
	                System.out.println("Error: Title field is empty!");
	               // throw new Exception("Title field must not be empty.");
	            }

	            if(languageValue.isEmpty() || titleValue.isEmpty()) {	            		            	
	            System.out.println("Enter the details in required field");
	            }
	            else {
					System.out.println("Validation Passed");
				}
			
			
		}
		
		@Test(priority = 6)
		public void Backdrop() throws InterruptedException
			    {
			    	WebElement backdrop = driver.findElement(By.xpath("//*[@id=\"Assets\"]/div[2]/div/div[1]/app-onnet-image-upload/div/div/input"));
		            highlightElement(driver, backdrop);

			    	if (backdrop.isEnabled()) {
			    		Thread.sleep(1000);
			    	    WebElement fileInput = driver.findElement(By.xpath("//*[@id=\"Assets\"]/div[2]/div/div[1]/app-onnet-image-upload/div/div/input")); 
			    	    fileInput.sendKeys("C:\\Users\\User\\Desktop\\onnet_logo.jpg");
			    	    System.out.println("Backdrop Uploaded Successfully");
			    	} else {
			    	    System.out.println("Upload button is not enabled!");
			    	}
			    	WebElement nocropElement= driver.findElement(By.xpath("//*[@id=\"mat-dialog-0\"]/app-image-cropper-dialog/div/div[2]/button[2]"));
			    	nocropElement.click();
			    	Thread.sleep(2000);
			    }	
			    
			    @Test(priority = 7)
			    public void Poster() throws InterruptedException
			    {
			    	 WebElement poster= driver.findElement(By.xpath("//*[@id=\"Assets\"]/div[3]/div/div[1]/div[1]/app-onnet-image-upload/div/div/input"));
			            highlightElement(driver, poster);

			    	 if (poster.isEnabled()) {
				    		Thread.sleep(1000);
				    	    WebElement fileInput = driver.findElement(By.xpath("//*[@id=\"Assets\"]/div[3]/div/div[1]/div[1]/app-onnet-image-upload/div/div/input")); 
				    	    fileInput.sendKeys("C:\\Users\\User\\Desktop\\onnet_logo.jpg");
				    	    System.out.println("Poster Uploaded Successfully");
				    	} else {
				    	    System.out.println("Upload button is not enabled!");
				    	}
				    	WebElement nocropElement= driver.findElement(By.xpath("//*[@id=\"mat-dialog-1\"]/app-image-cropper-dialog/div/div[2]/button[2]"));
				    	nocropElement.click();
				    	
				    	WebElement posterlanguagedropdown = driver.findElement(By.xpath("//*[@id=\"Assets\"]/div[3]/div/div[1]/div[2]/select"));
				    	highlightElement(driver, posterlanguagedropdown);
				    	posterlanguagedropdown.click();
				    	
				    	Select posterlanguageSelect = new Select(posterlanguagedropdown);  
					      List<WebElement> posterlanguageoption = posterlanguageSelect.getOptions();
					     Random rand = new Random();
					      int randomposterlanguageIndex = rand.nextInt(posterlanguageoption.size() - 1) + 1; 
					      posterlanguageSelect.selectByIndex(randomposterlanguageIndex);
					      String selectedposterlanguageOptionText = posterlanguageoption.get(randomposterlanguageIndex).getText();
					      System.out.println("Language Selected is: " + selectedposterlanguageOptionText);
				    }	
			    	 
			    @Test(priority = 8)
			    
			    public void Logo() throws InterruptedException
			    {
			    	WebElement logo = driver.findElement(By.xpath("//*[@id=\"Assets\"]/div[4]/div/div[1]/div[1]/app-onnet-image-upload/div/div/input"));
			    	highlightElement(driver, logo);

			    	if (logo.isEnabled()) {
			    		Thread.sleep(1000);
			    	    WebElement fileInput = driver.findElement(By.xpath("//*[@id=\"Assets\"]/div[4]/div/div[1]/div[1]/app-onnet-image-upload/div/div/input")); 
			    	    fileInput.sendKeys("C:\\Users\\User\\Desktop\\onnet_logo.jpg");
			    	    System.out.println("Logo Uploaded Successfully");
			    	} else {
			    	    System.out.println("Upload button is not enabled!");
			    	}
			    	WebElement nocropElement= driver.findElement(By.xpath("//*[@id=\"mat-dialog-2\"]/app-image-cropper-dialog/div/div[2]/button[2]"));
			    	highlightElement(driver, nocropElement);

			    	nocropElement.click();
			    	
			    	WebElement logolanguagedropdown = driver.findElement(By.xpath("//*[@id=\"Assets\"]/div[4]/div/div[1]/div[2]/select"));
			    	highlightElement(driver, logolanguagedropdown);
			    	logolanguagedropdown.click();
			    	
			    	Select logolanguageSelect = new Select(logolanguagedropdown);  
				      List<WebElement> logolanguageoption = logolanguageSelect.getOptions();
				     Random rand = new Random();
				      int randomlogolanguageIndex = rand.nextInt(logolanguageoption.size() - 1) + 1; 
				      logolanguageSelect.selectByIndex(randomlogolanguageIndex);
				      String selectedlogolanguageOptionText = logolanguageoption.get(randomlogolanguageIndex).getText();
				      System.out.println("Language Selected is: " + selectedlogolanguageOptionText);
			    }
			    
			    @Test(priority = 9)
			    
			    public void Banner()throws InterruptedException
			    {
			    	WebElement Banner = driver.findElement(By.xpath("//*[@id=\"Assets\"]/div[5]/div/div[1]/div[1]/app-onnet-image-upload/div/div/input"));
			    	highlightElement(driver, Banner);

			    	if (Banner.isEnabled()) {
			    		Thread.sleep(1000);
			    	    WebElement fileInput = driver.findElement(By.xpath("//*[@id=\"Assets\"]/div[5]/div/div[1]/div[1]/app-onnet-image-upload/div/div/input")); 
			    	    fileInput.sendKeys("C:\\Users\\User\\Desktop\\onnet_logo.jpg");
			    	    Thread.sleep(1000);
			    	    System.out.println("Banner Uploaded Successfully");
			    	} else {
			    	    System.out.println("Upload button is not enabled!");
			    	}
			    	WebElement nocropElement= driver.findElement(By.xpath("//*[@id=\"mat-dialog-3\"]/app-image-cropper-dialog/div/div[2]/button[2]"));

			    	highlightElement(driver, nocropElement);

			    	nocropElement.click();
			    	Thread.sleep(2000);
			    	
			    	WebElement Bannerlanguagedropdown = driver.findElement(By.xpath("//*[@id=\"Assets\"]/div[5]/div/div[1]/div[2]/select"));
			    	highlightElement(driver, Bannerlanguagedropdown);
			    	Bannerlanguagedropdown.click();
			    	
			    	Select BannerlanguageSelect = new Select(Bannerlanguagedropdown);  
				      List<WebElement> Bannerlanguageoption = BannerlanguageSelect.getOptions();
				     Random rand = new Random();
				      int randomBannerlanguageIndex = rand.nextInt(Bannerlanguageoption.size() - 1) + 1; 
				      BannerlanguageSelect.selectByIndex(randomBannerlanguageIndex);
				      String selectedBannerlanguageOptionText = Bannerlanguageoption.get(randomBannerlanguageIndex).getText();
				      System.out.println("Language Selected is: " + selectedBannerlanguageOptionText);
				      Thread.sleep(2000);
			    }
			    
			    @Test(priority = 10)
			    
			    public void Trailer() throws InterruptedException
			    {
			    	WebElement trailer = driver.findElement(By.xpath("//*[@id=\"Assets\"]/div[6]/div/div[1]/label"));
			    	highlightElement(driver, trailer);

			    	if (trailer.isEnabled()) {
			    		Thread.sleep(2000);
			    	    WebElement fileInput = driver.findElement(By.xpath("//*[@id=\"fileInput\"]")); 
			    	    fileInput.sendKeys("C:\\Users\\User\\Videos\\Captures\\trailer.mp4");
			    	    Thread.sleep(1000);
			    	    System.out.println("Trailer Uploaded Successfully");
			    	} else {
			    	    System.out.println("Upload button is not enabled!");
			    	}
			    	Thread.sleep(2000);
			    	
			    		WebElement successmessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("simple-snack-bar.mat-simple-snackbar")));
				        WebElement confirmationMessage = successmessage.findElement(By.cssSelector("span"));
				        String confirmmessage= confirmationMessage.getText();
				        System.out.println(confirmmessage +":File Uploaded Successfully");
				        Thread.sleep(2000);
			        	
			    	WebElement trailerlanguagedropdown = driver.findElement(By.xpath("//*[@id=\"Assets\"]/div[6]/div/div[1]/div/div/div/select"));
			    	highlightElement(driver, trailerlanguagedropdown);

			    	trailerlanguagedropdown.click();
			    	
			    	Select trailerlanguageSelect = new Select(trailerlanguagedropdown);  
				      List<WebElement> trailerlanguageoption = trailerlanguageSelect.getOptions();
				     Random rand = new Random();
				      int randomtrailerlanguageIndex = rand.nextInt(trailerlanguageoption.size() - 1) + 1; 
				      trailerlanguageSelect.selectByIndex(randomtrailerlanguageIndex);
				      String selectedtrailerlanguageOptionText = trailerlanguageoption.get(randomtrailerlanguageIndex).getText();
				      System.out.println("Language Selected is: " + selectedtrailerlanguageOptionText);
			    }
			    
			    
			    @Test(priority = 11)
			    public void metadata() throws InterruptedException
			    {
			    	WebElement age = driver.findElement(By.id("age"));
			    	highlightElement(driver, age);
			    	age.sendKeys("18");
			    	Thread.sleep(1000);
			    	
			    	WebElement genredropdown = driver.findElement(By.xpath("//*[@id=\"Metadata\"]/div[2]/div[1]/div[2]/ng-multiselect-dropdown/div/div[1]/span/span[1]"));
			    	highlightElement(driver, genredropdown);
			    	genredropdown.click();
			    	Thread.sleep(1000);
			    	WebElement randomgenre = driver.findElement(By.xpath("//*[@id=\"Metadata\"]/div[2]/div[1]/div[2]/ng-multiselect-dropdown/div/div[2]/ul[2]/li[3]/div"));
			    	highlightElement(driver, randomgenre);
			    	randomgenre.click();     
			        WebElement releaseDate = driver.findElement(By.xpath("//*[@id=\"mat-input-0\"]"));
			    	highlightElement(driver, releaseDate);
				    releaseDate.sendKeys(Keys.CONTROL + "a"); 
				    releaseDate.sendKeys(Keys.DELETE);	    
				    releaseDate.sendKeys("12/06/2022");	    	
				    Thread.sleep(2000);  					    	
			    }
			    
			    @Test(priority = 12)
			    public void VideoQuality() throws InterruptedException
			    {
			    	WebElement videoQualitydropdown = driver.findElement(By.xpath("//*[@id=\"Metadata\"]/div[2]/div[3]/div[1]/ng-multiselect-dropdown/div/div[1]/span"));
			    	highlightElement(driver, videoQualitydropdown);

			    	videoQualitydropdown.click();
			    	Thread.sleep(2000);
			    	WebElement vq = driver.findElement(By.xpath("//*[@id=\"Metadata\"]/div[2]/div[3]/div[1]/ng-multiselect-dropdown/div/div[2]/ul[2]/li[1]/div"));
			    	String videotext = vq.getText();
			    	vq.click();
			    	WebElement dropdownclose = driver.findElement(By.xpath("//*[@id=\"Metadata\"]/div[2]/div[3]/div[1]/ng-multiselect-dropdown/div/div[1]/span/span[2]/span"));
			    	dropdownclose.click();
			    	System.out.println("Selected Video Quality is: " +videotext);
			    	Thread.sleep(1000);	    		    
			    }
			    
			    @Test(priority = 13)
			    public void AudioQuality() throws InterruptedException
			    {
			    	WebElement audioqualityDropdown = driver.findElement(By.xpath("//*[@id=\"Metadata\"]/div[2]/div[3]/div[2]/ng-multiselect-dropdown/div/div[1]/span"));
			    	highlightElement(driver, audioqualityDropdown);
			    	audioqualityDropdown.click();
			    	Thread.sleep(2000);
			    	WebElement aq = driver.findElement(By.xpath("//*[@id=\"Metadata\"]/div[2]/div[3]/div[2]/ng-multiselect-dropdown/div/div[2]/ul[2]/li/div"));
			    	highlightElement(driver, aq);

			    	String audiotext = aq.getText();
			    	aq.click();
			    	Thread.sleep(1000);
			    	WebElement dropdownclose = driver.findElement(By.xpath("//*[@id=\"Metadata\"]/div[2]/div[3]/div[2]/ng-multiselect-dropdown/div/div[1]/span/span[2]/span"));
			    	dropdownclose.click();
			    	System.out.println("Selected Audio Quality is: "+audiotext);
			    }
			    
			    @Test(priority = 14)
			    public void country() throws InterruptedException
			    {
			    	WebElement country = driver.findElement(By.xpath("//*[@id=\"Metadata\"]/div[2]/div[4]/div[3]/div[2]/ng-multiselect-dropdown/div/div[1]/span/span[1]"));
			    	highlightElement(driver, country);
			    	country.click();
			    	Thread.sleep(1000);
			    	
			    	
			    	WebElement selectedcountry = driver.findElement(By.xpath("//*[@id=\"Metadata\"]/div[2]/div[4]/div[3]/div[2]/ng-multiselect-dropdown/div/div[2]/ul[2]/li[27]/div"));
			    	highlightElement(driver, selectedcountry);
			    	selectedcountry.click();
			    	
			    	WebElement closedropdown = driver.findElement(By.xpath("//*[@id=\"Metadata\"]/div[2]/div[4]/div[3]/div[2]/ng-multiselect-dropdown/div/div[1]/span"));
			    	closedropdown.click();
			    	Thread.sleep(1000);
			    }
			    
			   @Test(priority = 15)
			   public void Tag() throws InterruptedException
			   {
				   WebElement language = driver.findElement(By.xpath("//*[@id=\"Metadata\"]/div[2]/div[5]/div[1]/div/div[1]/div[2]/div/div[1]/div/select"));
			    	highlightElement(driver, language);

				   language.click();
				   
				   Select languageSelect = new Select(language);  
				      List<WebElement> languageoption = languageSelect.getOptions();
				      Random rand = new Random();
				      int randomlanguageIndex = rand.nextInt(languageoption.size() - 1) + 1; 
				      languageSelect.selectByIndex(randomlanguageIndex);
				      String selectedlanguageOptionText = languageoption.get(randomlanguageIndex).getText();
				      System.out.println("Language Selected is: " + selectedlanguageOptionText);
				   
				     WebElement searchTagElement = driver.findElement(By.xpath("//*[@id=\"mat-chip-list-input-0\"]"));
				     highlightElement(driver, searchTagElement);
					    Thread.sleep(1000);

					    searchTagElement.sendKeys("Adult");
					    	      
					      WebElement advisorytag = driver.findElement(By.xpath("//*[@id=\"Metadata\"]/div[2]/div[5]/div[3]/div/ng-multiselect-dropdown/div/div[1]/span"));
					      highlightElement(driver, advisorytag);
					      advisorytag.click();
					      Thread.sleep(1000);		      
					      WebElement selectedAdvisoryTag = driver.findElement(By.xpath("//*[@id=\"Metadata\"]/div[2]/div[5]/div[3]/div/ng-multiselect-dropdown/div/div[2]/ul[2]/li[2]/div"));
					      highlightElement(driver, selectedAdvisoryTag);
					      selectedAdvisoryTag.click();		      
					      WebElement atcloseDropdown = driver.findElement(By.xpath("//*[@id=\"Metadata\"]/div[2]/div[5]/div[3]/div/ng-multiselect-dropdown/div/div[1]/span/span[2]/span"));
					      atcloseDropdown.click();	
					      Thread.sleep(1000);	      
				      
			   }
			    @Test(priority = 16)
			    public void URL()
			    {
			    	WebElement subtitle = driver.findElement(By.id("subtitle0"));
			    	highlightElement(driver, subtitle);
			    	subtitle.sendKeys("Testing");
			    	
			    	WebElement language = driver.findElement(By.xpath("//*[@id=\"URLs\"]/div[2]/div/div[1]/div/div/div[2]/select"));
			    	highlightElement(driver, language);

			    	language.click();
			    	Select languageSelect = new Select(language);
			    	List<WebElement> languageoption = languageSelect.getOptions();
			    	Random rand = new Random();
			    	int randomlanguageIndex = rand.nextInt(languageoption.size() -1) +1;
			    	languageSelect.selectByIndex(randomlanguageIndex);
			    	String selecetdlanguageOptionText = languageoption.get(randomlanguageIndex).getText();
			    	System.out.println("Language Selected is :"+ selecetdlanguageOptionText);			    	    				  		   			    
			    }
			   
			    @Test(priority = 17)
			    public void CastnCrew() throws InterruptedException
			    {
			    	WebElement castname = driver.findElement(By.id("mat-input-1"));
			    	highlightElement(driver, castname);
			    	castname.sendKeys("Dummy");
			    	Thread.sleep(1000);
			    	WebElement character1 = driver.findElement(By.xpath("/html/body/app-root/app-core/div[2]/div/app-series-add-edit/div/form/div[2]/div/div[2]/section[5]/div[2]/div/div/div[1]/div[2]/div[2]/div[1]/input"));
			    	highlightElement(driver, character1);

			    	character1.sendKeys("Dummy");
			    	Thread.sleep(1000);

			    	WebElement crewname = driver.findElement(By.id("mat-input-2"));
			    	highlightElement(driver, crewname);

			    	crewname.sendKeys("Dummy");
			    	Thread.sleep(1000);

			    	WebElement character2 = driver.findElement(By.xpath("/html/body/app-root/app-core/div[2]/div/app-series-add-edit/div/form/div[2]/div/div[2]/section[5]/div[3]/div/div/div[1]/div[2]/div[2]/div[1]/input"));
			    	highlightElement(driver, character2);
			    	character2.sendKeys("Dummy");
			    	Thread.sleep(1000);
			    	
			    	WebElement directorName = driver.findElement(By.id("mat-input-3"));
			    	highlightElement(driver, directorName);
			    	directorName.sendKeys("Dummy");
			    	Thread.sleep(1000);

			    	
			    	WebElement studio = driver.findElement(By.id("mat-input-4"));
			    	highlightElement(driver, studio);
			    	studio.sendKeys("Dummy");
			    	Thread.sleep(2000);
			    	
			    	
			    }
			    
		    
			    @Test(priority = 18)
			    public void Seasons() throws InterruptedException
			    {
			    	WebElement addSeason = driver.findElement(By.xpath("//*[@id=\"Seasons\"]/div[2]/div[1]/div[2]/button/span[1]"));
			    	addSeason.click();
		            highlightElement(driver, addSeason);

			    	Thread.sleep(3000);
			    	String url = driver.getCurrentUrl();
			    	System.out.println(url);
			    	
			    	if(url.contains("http://103.81.157.84:8900/content/series/6784a986a4ddd975a187cd31/season"))
			    	{
			    		System.out.println("Create New Season");
			    	}
			    	else {
						System.out.println("Couldn't navigate to season creation page");
					}
			    }
			    	@Test(priority = 19)
			    	public void SeasonTitle() throws InterruptedException		    	
			    	{
			    		WebElement seasonTitle = driver.findElement(By.id("maintitle"));
				    	highlightElement(driver, seasonTitle);
			    		seasonTitle.sendKeys("Testing");
			    		Thread.sleep(1000);
			    		WebElement seasonno = driver.findElement(By.xpath("//*[@id=\"Metadata\"]/div[2]/div[1]/div[2]/input"));
				    	highlightElement(driver, seasonno);
			    		seasonno.sendKeys("1");
			    		
			    		WebElement languagedropdown = driver.findElement(By.xpath("//*[@id=\"Metadata\"]/div[2]/div[2]/div[1]/div/div[1]/div[2]/div/div[1]/div/select"));
				    	highlightElement(driver, languagedropdown);
			    		languagedropdown.click();
			    		Select  languageSelect = new Select (languagedropdown);
			    		List<WebElement> languageoption = languageSelect.getOptions();
			    		Random rand = new Random();
			    		int randomLanguageIndex = rand.nextInt(languageoption.size() -1) +1;
			    		languageSelect.selectByIndex(randomLanguageIndex);
			    		String selectedlanguageOptionText = languageoption.get(randomLanguageIndex).getText();
			    		System.out.println("Selected language is : " + selectedlanguageOptionText);
			    		Thread.sleep(1000);
			    		
			    		WebElement description = driver.findElement(By.id("description"));
				    	highlightElement(driver, description);
			    		description.sendKeys("Testing");	
			    		Thread.sleep(1000);
			    		
			    	}
			    	

			    	@Test(priority = 20)
			    	 public void Backdrop1() throws InterruptedException
				    {

				    	WebElement backdrop = driver.findElement(By.xpath("//*[@id=\"Assets\"]/div[2]/div/div[1]/app-onnet-image-upload/div/div/input"));
				    	highlightElement(driver, backdrop);
				    	if (backdrop.isEnabled()) {
				    		Thread.sleep(2000);
				    	    WebElement fileInput = driver.findElement(By.xpath("//*[@id=\"Assets\"]/div[2]/div/div[1]/app-onnet-image-upload/div/div/input")); 
				    	    fileInput.sendKeys("C:\\Users\\User\\Desktop\\onnet_logo.jpg");
				    	    System.out.println("Backdrop Uploaded Successfully");
				    	} else {
				    	    System.out.println("Upload button is not enabled!");
				    	}
				    	WebElement nocropElement= driver.findElement(By.xpath("//*[@id=\"mat-dialog-4\"]/app-image-cropper-dialog/div/div[2]/button[2]/span[1]"));
				    	highlightElement(driver, nocropElement);
				    	nocropElement.click();
				    	Thread.sleep(2000);
				    }	

				    @Test(priority = 21 )
				    public void Poster1() throws InterruptedException
				    {
				    	 WebElement poster= driver.findElement(By.xpath("//*[@id=\"Assets\"]/div[3]/div/div[1]/div[1]/app-onnet-image-upload/div/div/input"));
					    	highlightElement(driver, poster);
				    	 if (poster.isEnabled()) {
					    		Thread.sleep(2000);
					    	    WebElement fileInput = driver.findElement(By.xpath("//*[@id=\"Assets\"]/div[3]/div/div[1]/div[1]/app-onnet-image-upload/div/div/input")); 
					    	    fileInput.sendKeys("C:\\Users\\User\\Desktop\\onnet_logo.jpg");
					    	    System.out.println("Poster Uploaded Successfully");
					    	} else {
					    	    System.out.println("Upload button is not enabled!");
					    	}
					    	WebElement nocropElement= driver.findElement(By.xpath("//*[@id=\"mat-dialog-5\"]/app-image-cropper-dialog/div/div[2]/button[2]/span[1]"));
					    	highlightElement(driver, nocropElement);
					    	nocropElement.click();
					    	
					    	WebElement posterlanguagedropdown = driver.findElement(By.xpath("//*[@id=\"Assets\"]/div[3]/div/div[1]/div[2]/select"));
					    	highlightElement(driver, posterlanguagedropdown);
					    	posterlanguagedropdown.click();
					    	
					    	Select posterlanguageSelect = new Select(posterlanguagedropdown);  
						      List<WebElement> posterlanguageoption = posterlanguageSelect.getOptions();
						     Random rand = new Random();
						      int randomposterlanguageIndex = rand.nextInt(posterlanguageoption.size() - 1) + 1; 
						      posterlanguageSelect.selectByIndex(randomposterlanguageIndex);
						      String selectedposterlanguageOptionText = posterlanguageoption.get(randomposterlanguageIndex).getText();
						      System.out.println("Language Selected is: " + selectedposterlanguageOptionText);
					    }	
				    	 
				    @Test(priority = 22)
				    
				    public void Logo1() throws InterruptedException
				    {
				    	WebElement logo = driver.findElement(By.xpath("//*[@id=\"Assets\"]/div[4]/div/div[1]/div[1]/app-onnet-image-upload/div/div/input"));
				    	highlightElement(driver, logo);
				    	if (logo.isEnabled()) {
				    		Thread.sleep(2000);
				    	    WebElement fileInput = driver.findElement(By.xpath("//*[@id=\"Assets\"]/div[4]/div/div[1]/div[1]/app-onnet-image-upload/div/div/input")); 
				    	    fileInput.sendKeys("C:\\Users\\User\\Desktop\\onnet_logo.jpg");
				    	    System.out.println("Logo Uploaded Successfully");
				    	} else {
				    	    System.out.println("Upload button is not enabled!");
				    	}
				    	WebElement nocropElement= driver.findElement(By.xpath("//*[@id=\"mat-dialog-6\"]/app-image-cropper-dialog/div/div[2]/button[2]/span[1]"));
				    	highlightElement(driver, nocropElement);
				    	nocropElement.click();
				    	
				    	WebElement logolanguagedropdown = driver.findElement(By.xpath("//*[@id=\"Assets\"]/div[4]/div/div[1]/div[2]/select"));
				    	highlightElement(driver, logolanguagedropdown);
				    	logolanguagedropdown.click();
				    	
				    	Select logolanguageSelect = new Select(logolanguagedropdown);  
					      List<WebElement> logolanguageoption = logolanguageSelect.getOptions();
					     Random rand = new Random();
					      int randomlogolanguageIndex = rand.nextInt(logolanguageoption.size() - 1) + 1; 
					      logolanguageSelect.selectByIndex(randomlogolanguageIndex);
					      String selectedlogolanguageOptionText = logolanguageoption.get(randomlogolanguageIndex).getText();
					      System.out.println("Language Selected is: " + selectedlogolanguageOptionText);
				    }
				    
				    @Test(priority = 23)
				    
				    public void Banner1()throws InterruptedException
				    {
				    	WebElement Banner = driver.findElement(By.xpath("//*[@id=\"Assets\"]/div[5]/div/div[1]/div[1]/app-onnet-image-upload/div/div/input"));
				    	highlightElement(driver, Banner);

				    	if (Banner.isEnabled()) {
				    		Thread.sleep(2000);
				    	    WebElement fileInput = driver.findElement(By.xpath("//*[@id=\"Assets\"]/div[5]/div/div[1]/div[1]/app-onnet-image-upload/div/div/input")); 
				    	    fileInput.sendKeys("C:\\Users\\User\\Desktop\\onnet_logo.jpg");
				    	    Thread.sleep(1000);
				    	    System.out.println("Banner Uploaded Successfully");
				    	} else {
				    	    System.out.println("Upload button is not enabled!");
				    	}
				    	WebElement nocropElement= driver.findElement(By.xpath("//*[@id=\"mat-dialog-7\"]/app-image-cropper-dialog/div/div[2]/button[2]/span[1]"));
				    	highlightElement(driver, nocropElement);

				    	nocropElement.click();
				    	Thread.sleep(2000);
				    	
				    	WebElement Bannerlanguagedropdown = driver.findElement(By.xpath("//*[@id=\"Assets\"]/div[5]/div/div[1]/div[2]/select"));
				    	highlightElement(driver, Bannerlanguagedropdown);

				    	Bannerlanguagedropdown.click();
				    	
				    	Select BannerlanguageSelect = new Select(Bannerlanguagedropdown);  
					      List<WebElement> Bannerlanguageoption = BannerlanguageSelect.getOptions();
					     Random rand = new Random();
					      int randomBannerlanguageIndex = rand.nextInt(Bannerlanguageoption.size() - 1) + 1; 
					      BannerlanguageSelect.selectByIndex(randomBannerlanguageIndex);
					      String selectedBannerlanguageOptionText = Bannerlanguageoption.get(randomBannerlanguageIndex).getText();
					      System.out.println("Language Selected is: " + selectedBannerlanguageOptionText);
					      Thread.sleep(2000);
				    }
				    
				    @Test(priority = 24)
				    
				    public void Trailer1() throws InterruptedException
				    {
				    	WebElement trailer = driver.findElement(By.xpath("//*[@id=\"Assets\"]/div[6]/div/div[1]/label"));
				    	highlightElement(driver, trailer);

				    	if (trailer.isEnabled()) {
				    		Thread.sleep(2000);
				    	    WebElement fileInput = driver.findElement(By.xpath("//*[@id=\"fileInput\"]")); 
				    	    fileInput.sendKeys("C:\\Users\\User\\Videos\\Captures\\trailer.mp4");
				    	    
				    	} 
				    	WebElement trailerLangDropDown = driver.findElement(By.xpath("//*[@id=\"Assets\"]/div[6]/div/div[1]/div/div/div/select"));
				    	highlightElement(driver, trailerLangDropDown);

				    	trailerLangDropDown.click();
				    	Thread.sleep(1000);
				    	
				    	Select trailerlanguageSelect = new Select(trailerLangDropDown);  
					      List<WebElement> trailerlanguageoption = trailerlanguageSelect.getOptions();
					     Random rand = new Random();
					      int randomtrailerlanguageIndex = rand.nextInt(trailerlanguageoption.size() - 1) + 1; 
					      trailerlanguageSelect.selectByIndex(randomtrailerlanguageIndex);
					      String selectedtrailerlanguageOptionText = trailerlanguageoption.get(randomtrailerlanguageIndex).getText();
					      System.out.println("Language Selected is: " + selectedtrailerlanguageOptionText);
				    	
				    }
				    
				    @Test(priority = 25)
				    public void SeasonCastnCrew()
				    {
				    	WebElement cast = driver.findElement(By.id("mat-input-5"));
				    	highlightElement(driver, cast);
				    	cast.sendKeys("Testing");
				    	WebElement character = driver.findElement(By.xpath("/html/body/app-root/app-core/div[2]/div/app-seasons-add-edit/div/form/div[2]/div/div[2]/section[4]/div[2]/div/div/div[1]/div[2]/div[2]/div[1]/input"));
				    	highlightElement(driver, character);
				    	character.sendKeys("Testing");
				    	
				    	WebElement crew = driver.findElement(By.id("mat-input-6"));
				    	highlightElement(driver, crew);
				    	crew.sendKeys("Testing");
				    	WebElement character2 = driver.findElement(By.xpath("/html/body/app-root/app-core/div[2]/div/app-seasons-add-edit/div/form/div[2]/div/div[2]/section[4]/div[3]/div/div/div[1]/div[2]/div[2]/div[1]/input"));
				    	highlightElement(driver, character2);
				    	character2.sendKeys("Testing");
				    			
				    }
			    /*
				    @Test(priority = 26)
				    public void Save() throws InterruptedException
				    {
				    	WebElement saveSeason = driver.findElement(By.xpath("//*[@id=\"Episodes\"]/div[2]/div[1]/div[2]/button/span[1]"));
				    	highlightElement(driver, saveSeason);
				    	saveSeason.click();
				    	WebElement successmessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("simple-snack-bar.mat-simple-snackbar")));
				        WebElement confirmationMessage = successmessage.findElement(By.cssSelector("span"));
				        String confirmmessage= confirmationMessage.getText();
				        System.out.println(confirmmessage);
				        Thread.sleep(2000);
				    }
			*/
				    @Test(priority = 27)
				    public void AddEpisodes() throws InterruptedException
				    {
				    	WebElement addEpisode = driver.findElement(By.xpath("//*[@id=\"Episodes\"]/div[2]/div[1]/div[2]/button"));
				    	highlightElement(driver, addEpisode);
				    	addEpisode.click();
				    	Thread.sleep(3000);
				    	WebElement selectEpisode = driver.findElement(By.xpath("//*[@id=\"mat-dialog-8\"]/app-add-content-in-series-episodes-dialog/div/div[1]/div/div[1]/div/div[2]/div/div[3]"));
				    	highlightElement(driver, selectEpisode);
				    	selectEpisode.click();				    
				    	Thread.sleep(500);
				    	WebElement Done = driver.findElement(By.xpath("//*[@id=\"mat-dialog-8\"]/app-add-content-in-series-episodes-dialog/div/div[2]/button"));
				    	highlightElement(driver, Done);
				    	Done.click();				    					    
				    	WebElement confirmation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("simple-snack-bar.mat-simple-snackbar")));
				        WebElement confirmationMessage = confirmation.findElement(By.cssSelector("span"));
				        String confirmmessage= confirmationMessage.getText();
				        System.out.println(confirmmessage);
				    	Thread.sleep(1000);
				    	
				    	
				    }
			//	    r2urur1u1r1u1r1ur1
				    @Test(priority = 28)
				    public void Save() throws InterruptedException
				    {
				    	WebElement Save = driver.findElement(By.xpath("/html/body/app-root/app-core/div[2]/div/app-seasons-add-edit/div/form/footer/div/button[2]"));
				    	Save .click();
				    	Thread.sleep(2000);
				    } 
				    
				    @Test(priority = 29)
				    public void Update() throws InterruptedException
				    {
				    	WebElement Update = driver.findElement(By.xpath("/html/body/app-root/app-core/div[2]/div/app-series-add-edit/div/form/footer/div/button[2]"));
				    	Update.click();
				    	Thread.sleep(2000);
				    	
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
			    
			    	
			    
	
		
	
		  