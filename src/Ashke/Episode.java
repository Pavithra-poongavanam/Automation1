package Ashke;

	import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

import org.bouncycastle.oer.its.ieee1609dot2.basetypes.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
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


	public class Episode {
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
		public void EpisodeNavigation() throws InterruptedException
		{
			WebElement Episode= driver.findElement(By.xpath("/html/body/app-root/app-core/div[2]/app-sidenav/mat-sidenav-container/mat-sidenav-content/div[1]/ul/li[7]/h2"));
	        highlightElement(driver, Episode);
			Episode.click();
			Thread.sleep(2000);
		}


		@Test(priority = 3)
		public void SearchEpisode() throws InterruptedException
		{
			String[] searchTerms = {"Stranger things", "Game of Thrones"};
	        for (String searchTerm : searchTerms)
	        {
	            System.out.println("Performing search for: " + searchTerm);
	            WebElement searchInput = driver.findElement(By.xpath("/html/body/app-root/app-core/div[2]/div/app-file-list/div/div/div/div[1]/app-onnet-search-bar/div/input"));
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
			WebElement createEpisode = driver.findElement(By.xpath("/html/body/app-root/app-core/div[2]/div/app-file-list/div/mat-toolbar/div/button/span[1]"));
	        highlightElement(driver, createEpisode);
			createEpisode.click();
		    String currentUrl = driver.getCurrentUrl();
		  System.out.println(currentUrl);
		    if(currentUrl.equals("http://103.81.157.84:8900/content/files/list"))
		    {
		    	System.out.println("Navigated to upload page");
		    }
		    else {
				System.out.println("Couldn't navigate to upload page");
			}
		    Thread.sleep(3000);
		}

		    @Test(priority = 5)
		    public void UploadSeries() throws InterruptedException
		    {
		    	WebElement Episode = driver.findElement(By.xpath("//*[@id=\"mat-button-toggle-3-button\"]"));
		        highlightElement(driver, Episode);
		    	Episode.click();
		    	Thread.sleep(2000);
		    	WebElement fileInput = driver.findElement(By.cssSelector("input[type='file']"));
		        highlightElement(driver, fileInput);
		        String filePath = Paths.get("C:\\Users\\User\\Videos\\Captures\\episode.mp4").toAbsolutePath().toString();
		        fileInput.sendKeys(filePath);
		        Thread.sleep(2000);
		        WebElement uploadFileButton = driver.findElement(By.xpath("/html/body/app-root/app-core/div[2]/div/app-upload-content/div/div/div/div/div[2]/div[3]/button/span[1]"));
		        highlightElement(driver, uploadFileButton);
		        uploadFileButton.click();

		        WebElement progressPercentage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.percentage.os-t3-green")));
		        wait.until(ExpectedConditions.textToBePresentInElement(progressPercentage, "100%"));

		        WebElement confirmationprogressbar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("simple-snack-bar.mat-simple-snackbar")));
		        WebElement confirmationMessage = confirmationprogressbar.findElement(By.cssSelector("span"));
		        String confirmmessage= confirmationMessage.getText();
		        System.out.println(confirmmessage);
		    }

		    @Test(priority = 6)
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


				WebElement mainTitleElement = driver.findElement(By.id("maintitle"));
		        highlightElement(driver, mainTitleElement);
				mainTitleElement.clear();
		    	Thread.sleep(2000);
				mainTitleElement.sendKeys("Episode Testing");

				WebElement langugedropdown= driver.findElement(By.xpath("//*[@id=\"TitleInfo\"]/div[2]/div[2]/div/div/select"));
		        highlightElement(driver, langugedropdown);
				langugedropdown.click();
				Thread.sleep(1000);
			      Select languageSelect = new Select(langugedropdown);
			      List<WebElement> languageoption = languageSelect.getOptions();
			      Random rand = new Random();
			      int randomlanguageIndex = rand.nextInt(languageoption.size() - 1) + 1;
			      languageSelect.selectByIndex(randomlanguageIndex);
			      String selectedlanguageOptionText = languageoption.get(randomlanguageIndex).getText();
			      System.out.println("Language Selected is: " + selectedlanguageOptionText);

			      String languageValue = langugedropdown.getAttribute("value").trim();
		            String titleValue = mainTitleElement.getAttribute("value").trim();

		            if (languageValue.isEmpty()) {
		                System.out.println("Error: Language field is empty!");
		                //throw new Exception("Language field must not be empty.");
		            }

		            if (titleValue.isEmpty()) {
		                System.out.println("Error: Title field is empty!");
		               // throw new Exception("Title field must not be empty.");
		            }

		            System.out.println("Validation passed: Language and Title fields are filled.");

		    }
				@Test(priority = 7)

				public void MetaData() throws InterruptedException
				{
					Thread.sleep(1000);
					// WebElement showTitle = driver.findElement(By.id("mat-input-0"));
				     //highlightElement(driver, showTitle);
					 //showTitle.sendKeys("Testing");

					 WebElement episodeno = driver.findElement(By.id("episodeno"));
				     highlightElement(driver, episodeno);
					 episodeno.clear();
					 episodeno.sendKeys("1");

					 WebElement releaseDate = driver.findElement(By.xpath("//*[@id=\"mat-input-1\"]"));
				     highlightElement(driver, releaseDate);
				    	releaseDate.sendKeys(Keys.CONTROL + "a");
				    	releaseDate.sendKeys(Keys.DELETE);
				    	releaseDate.sendKeys("12/06/2022");
				    	Thread.sleep(2000);

				}
				 @Test(priority = 8)
				    public void VideoQuality() throws InterruptedException
				    {
				    	WebElement videoQualitydropdown = driver.findElement(By.xpath("//*[@id=\"Metadata\"]/div[2]/div[3]/div[1]/ng-multiselect-dropdown/div/div[1]/span/span[1]"));
				        highlightElement(driver, videoQualitydropdown);
				    	videoQualitydropdown.click();
				    	Thread.sleep(2000);
				    	WebElement vq = driver.findElement(By.xpath("//*[@id=\"Metadata\"]/div[2]/div[3]/div[1]/ng-multiselect-dropdown/div/div[2]/ul[2]/li[2]/div"));
				        highlightElement(driver, vq);
				    	String videotext = vq.getText();
				    	vq.click();
				    	WebElement dropdownclose = driver.findElement(By.xpath("//*[@id=\"Metadata\"]/div[2]/div[3]/div[1]/ng-multiselect-dropdown/div/div[1]/span/span[2]/span"));
				        highlightElement(driver, dropdownclose);
				    	dropdownclose.click();
				    	System.out.println("Selected Video Quality is: " +videotext);
				    	Thread.sleep(1000);
				    }

				    @Test(priority = 9)
				    public void AudioQuality() throws InterruptedException
				    {
				    	WebElement AudioQualitydropdown = driver.findElement(By.xpath("//*[@id=\"Metadata\"]/div[2]/div[3]/div[2]/ng-multiselect-dropdown/div/div[1]/span"));
				        highlightElement(driver, AudioQualitydropdown);
				    	AudioQualitydropdown.click();
				    	Thread.sleep(2000);
				    	WebElement audioquality = driver.findElement(By.xpath("//*[@id=\"Metadata\"]/div[2]/div[3]/div[2]/ng-multiselect-dropdown/div/div[2]/ul[2]/li/div"));
				        highlightElement(driver, audioquality);
				    	String audiotext = audioquality.getText();
				    	audioquality.click();
				    	Thread.sleep(1000);
				    	WebElement dropdownclose = driver.findElement(By.xpath("//*[@id=\"Metadata\"]/div[2]/div[3]/div[2]/ng-multiselect-dropdown/div/div[1]/span/span[2]/span"));
				    	dropdownclose.click();
				    	System.out.println("Selected Audio Quality is: " +audiotext );

			      WebElement sublangugedropdown= driver.findElement(By.xpath("//*[@id=\"Metadata\"]/div[2]/div[4]/div[1]/div[1]/div/div[1]/div[2]/div/div[1]/div/select"));
			      highlightElement(driver, sublangugedropdown);
			      sublangugedropdown.click();
					Thread.sleep(1000);
				      Select sublanguageSelect = new Select(sublangugedropdown);
				      List<WebElement> sublanguageoption = sublanguageSelect.getOptions();
				    Random rand = new Random();
				      int randomsublanguageIndex = rand.nextInt(sublanguageoption.size() - 1) + 1;
				      sublanguageSelect.selectByIndex(randomsublanguageIndex);
				      String selectedsublanguageOptionText = sublanguageoption.get(randomsublanguageIndex).getText();
				      System.out.println("Language Selected is: " + selectedsublanguageOptionText);

				      WebElement shortDescription = driver.findElement(By.id("shortdescription"));
				      highlightElement(driver, shortDescription);
				      shortDescription.sendKeys("Testingggg");
				      Thread.sleep(2000);

				      WebElement sublangugedropdown1 = driver.findElement(By.xpath("//*[@id=\"Metadata\"]/div[2]/div[4]/div[2]/div[1]/div/div[1]/div[2]/div/div[1]/div/select"));
				      highlightElement(driver, sublangugedropdown1);
				      sublangugedropdown1.click();
						Thread.sleep(1000);
					      Select sublanguageSelect1 = new Select(sublangugedropdown1);
					      List<WebElement> sublanguageoption1 = sublanguageSelect1.getOptions();
					//    Random rand = new Random();
					      int randomsublanguageIndex1 = rand.nextInt(sublanguageoption1.size() - 1) + 1;
					      sublanguageSelect1.selectByIndex(randomsublanguageIndex1);
					      String selectedsublanguageOptionText1 = sublanguageoption1.get(randomsublanguageIndex1).getText();
					      System.out.println("Language Selected is: " + selectedsublanguageOptionText1);

					      WebElement longdescription = driver.findElement(By.id("longdescription"));
					      longdescription.sendKeys("Testingggggg");


		    }


		    @Test(priority = 10)

		    public void Backdrop() throws InterruptedException
		    {

		    	WebElement backdrop = driver.findElement(By.xpath("//*[@id=\"Assets\"]/div[2]/div/div[1]/app-onnet-image-upload/div/div/input"));
		        highlightElement(driver, backdrop);
		    	if (backdrop.isEnabled()) {
		    		Thread.sleep(2000);
		    	    WebElement fileInput = driver.findElement(By.xpath("//*[@id=\"Assets\"]/div[2]/div/div[1]/app-onnet-image-upload/div/div/input"));
		    	    fileInput.sendKeys("C:\\Users\\User\\Desktop\\onnet_logo.jpg");
		    	    Thread.sleep(1000);
		    	    WebElement nocropElement= driver.findElement(By.xpath("//*[@id=\"mat-dialog-0\"]/app-image-cropper-dialog/div/div[2]/button[2]"));
			        highlightElement(driver, nocropElement);
			    	nocropElement.click();
		    	    System.out.println("Backdrop Uploaded Successfully");
		    	} else {
		    	    System.out.println("Upload button is not enabled!");
		    	}

		    	Thread.sleep(2000);
		    }

		    @Test(priority = 11)
		    public void Poster() throws InterruptedException
		    {
		    	 WebElement poster= driver.findElement(By.xpath("//*[@id=\"Assets\"]/div[3]/div/div[1]/div[1]/app-onnet-image-upload/div/div/input"));
		    	 if (poster.isEnabled()) {
			    		Thread.sleep(2000);
			    	    WebElement fileInput = driver.findElement(By.xpath("//*[@id=\"Assets\"]/div[3]/div/div[1]/div[1]/app-onnet-image-upload/div/div/input"));
			    	    fileInput.sendKeys("C:\\Users\\User\\Desktop\\onnet_logo.jpg");
			    	    Thread.sleep(1000);
			    	    WebElement nocropElement= driver.findElement(By.xpath("//*[@id=\"mat-dialog-1\"]/app-image-cropper-dialog/div/div[2]/button[2]"));
				        highlightElement(driver, nocropElement);
				    	nocropElement.click();
			    	    System.out.println("Poster Uploaded Successfully");
			    	}
			    	Thread.sleep(1000);

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

		    @Test(priority = 12)

		    public void Logo() throws InterruptedException
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
		    	Thread.sleep(2000);
		    	WebElement nocropElement= driver.findElement(By.xpath("//*[@id=\"mat-dialog-2\"]/app-image-cropper-dialog/div/div[2]/button[2]/span[1]"));
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

		    @Test(priority = 13)

		    public void Banner()throws InterruptedException
		    {
		    	WebElement Banner = driver.findElement(By.xpath("//*[@id=\"Assets\"]/div[5]/div/div[1]/div[1]/app-onnet-image-upload/div/div/input"));
		        highlightElement(driver, Banner);
		    	if (Banner.isEnabled()) {
		    		Thread.sleep(2000);
		    	    WebElement fileInput = driver.findElement(By.xpath("//*[@id=\"Assets\"]/div[5]/div/div[1]/div[1]/app-onnet-image-upload/div/div/input"));
		    	    fileInput.sendKeys("C:\\Users\\User\\Desktop\\onnet_logo.jpg");
		    	    Thread.sleep(1000);
		    	    WebElement nocropElement= driver.findElement(By.xpath("//*[@id=\"mat-dialog-3\"]/app-image-cropper-dialog/div/div[2]/button[2]/span[1]"));
			    	nocropElement.click();
			    	Thread.sleep(1000);
		    	    System.out.println("Banner Uploaded Successfully");
		    	} else {
		    	    System.out.println("Upload button is not enabled!");
		    	}

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

		    @Test(priority = 14)

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
			        System.out.println(confirmmessage +" File Uploaded Successfully");
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

		    @Test(priority = 15)

		    public void Urls() throws InterruptedException
		    {
		    	WebElement subtitle = driver.findElement(By.id("subtitle0"));
		        highlightElement(driver, subtitle);
		    	subtitle.sendKeys("Testing");
		    	Thread.sleep(1000);

		    	WebElement language = driver.findElement(By.xpath("//*[@id=\"URLs\"]/div[2]/div/div[1]/div/div/div[2]/select"));
		        highlightElement(driver, language);
		    	language.click();
		    	Thread.sleep(2000);
		    	 Select languageSelect = new Select(language);
			      List<WebElement> languageoption = languageSelect.getOptions();
			     Random rand = new Random();
			      int randomlanguageIndex = rand.nextInt(languageoption.size() - 1) + 1;
			      languageSelect.selectByIndex(randomlanguageIndex);
			      String selectedlanguageOptionText = languageoption.get(randomlanguageIndex).getText();
			      System.out.println("Language Selected is: " + selectedlanguageOptionText);

			      WebElement deepUrl = driver.findElement(By.id("deeplinkurl"));
			      highlightElement(driver, deepUrl);
			      deepUrl.sendKeys("www.testing.com");

		    }

		    @Test(priority = 16)
		    public void CastnCrew() throws InterruptedException
		    {
		    	WebElement castname = driver.findElement(By.id("mat-input-2"));
		        highlightElement(driver, castname);
		        castname.sendKeys(Keys.CONTROL + "a");
		        castname.sendKeys(Keys.DELETE);
		    	castname.sendKeys("da");
		    	castname.click();
		    	Thread.sleep(1000);
		    	WebElement castimg = driver.findElement(By.xpath("//*[@id=\"mat-option-12\"]/span/span"));
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
		    	WebElement crewimg = driver.findElement(By.xpath("//*[@id=\"mat-option-18\"]/span/span"));
		    	crewimg.click();
		    	Thread.sleep(1000);

		    	WebElement character2 = driver.findElement(By.xpath("/html/body/app-root/app-core/div[2]/div/app-file-edit/div/form/div[2]/div/div[2]/section[6]/div[3]/div/div/div[1]/div[2]/div[2]/div[1]/input"));
		        highlightElement(driver, character2);
		    	character2.sendKeys("Testing");
		    	Thread.sleep(1000);

		    }
		    @Test(priority = 17)
		    public void Publish() throws InterruptedException
		    {
		    	WebElement publish = driver.findElement(By.xpath("/html/body/app-root/app-core/div[2]/div/app-file-edit/div/form/div[1]/div/div[2]/div/mat-slide-toggle"));
		    	highlightElement(driver, publish);
		    	publish.click();
		    	Thread.sleep(2000);
		    }

		    @Test(priority = 18)
		    public void Save()
		    {
		    	WebElement savebutton = driver.findElement(By.xpath("/html/body/app-root/app-core/div[2]/div/app-file-edit/div/form/footer/div/button[2]"));
		        highlightElement(driver, savebutton);
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
			            Thread.sleep(500);
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









































