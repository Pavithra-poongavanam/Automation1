package CDN;

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
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

	public class All {
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

	        driver.get("http://192.168.1.232:7099/auth/login");
	         driver.manage().window().maximize();
	         Thread.sleep(2000);
	     }

	    @Test(priority = 1)
	    public void TestValidLogin() throws InterruptedException {
	    	WebElement username = driver.findElement(By.xpath("/html/body/app-root/app-auth/div/div[2]/app-login/div/div[2]/form/div[1]/input"));
	        highlightElement(driver, username);
	        username.sendKeys("test@gmail.com");

	        WebElement passwordField = driver.findElement(By.xpath("/html/body/app-root/app-auth/div/div[2]/app-login/div/div[2]/form/div[2]/input"));
	        highlightElement(driver, passwordField);
	        passwordField.sendKeys("123");
	        Thread.sleep(1000);

	        WebElement loginButton = driver.findElement(By.xpath("/html/body/app-root/app-auth/div/div[2]/app-login/div/div[2]/form/div[3]/button"));
	        highlightElement(driver, loginButton);
	        loginButton.click();
	        Thread.sleep(4000);
	        String currentUrl = driver.getCurrentUrl();

	        Assert.assertEquals(currentUrl, "http://192.168.1.232:7099/core/dashboard", "User did not navigate to the homepage.");
	    }

	    @Test(priority = 2)
	    public void DashboardPage()
	    {
	    	String url  = driver.getCurrentUrl();
	    	System.out.println(url);

	    	//WebElement cdnImage = driver.findElement(By.xpath("/html/body/app-root/app-core/app-dashboard/div/div[1]/div[3]"));
	    	WebElement dashboard = driver.findElement(By.xpath("/html/body/app-root/app-core/app-dashboard/div"));
	    	WebElement statscontainer = driver.findElement(By.xpath("/html/body/app-root/app-core/app-dashboard/div/div[1]/div[1]"));
	    	WebElement node = driver.findElement(By.xpath("/html/body/app-root/app-core/app-dashboard/div/div[2]"));

	        if (statscontainer.isDisplayed()&& node.isDisplayed()&& dashboard.isDisplayed())
	        {
	            System.out.println("CDN content loaded successfully.");
	        } else {
	            System.out.println("CDN content not loaded.");
	        }


	    }
	    @Test(priority = 3)
	    public void TrafficToggle() throws InterruptedException
	    {
	    	WebElement Traffictoggle = driver.findElement(By.xpath("/html/body/app-root/app-core/app-dashboard/div/div[1]/div[2]/button[2]"));
	    	highlightElement(driver, Traffictoggle);
	    	Traffictoggle.click();
	    	Thread.sleep(2000);
	    }

	    	@Test(priority = 4)
	    	public void MapToggle() throws InterruptedException
	    	{

	    	WebElement mapToggle = driver.findElement(By.xpath("/html/body/app-root/app-core/app-dashboard/div/div[1]/div[2]/button[1]"));
	    	highlightElement(driver, mapToggle);
	    	mapToggle.click();
	    	Thread.sleep(2000);
	    	WebElement map = driver.findElement(By.xpath("/html/body/app-root/app-core/app-dashboard/div/div[1]/div[3]"));
	    	if(map.isDisplayed())
	    	{
	    		System.out.println("Map is Displayed");

	    	}else {
	    		System.out.println("Map is not displayed");
	    	}
	    	}


	    @Test(priority = 5)
	    public void Zoom() throws InterruptedException
	    {
	    	Random rand = new Random();
	    	 int zoomInTimes = rand.nextInt(5) + 1;
	         int zoomOutTimes = rand.nextInt(5) + 1;

	         System.out.println("Zooming in " + zoomInTimes + " times and zooming out " + zoomOutTimes + " times.");

	         for (int i = 0; i < zoomInTimes; i++) {
	             WebElement zoomInButton = driver.findElement(By.xpath("/html/body/app-root/app-core/app-dashboard/div/div[1]/div[3]/div[1]/div[2]/div[1]/div/a[1]"));
	             zoomInButton.click();
	             System.out.println("Zooming In...");
	             try {
	                 Thread.sleep(500);
	             } catch (InterruptedException e) {
	                 e.printStackTrace();
	             }
	         }
	         for (int i = 0; i < zoomOutTimes; i++) {
	             WebElement zoomOutButton = driver.findElement(By.xpath("/html/body/app-root/app-core/app-dashboard/div/div[1]/div[3]/div[1]/div[2]/div[1]/div/a[2]"));
	             zoomOutButton.click();
	             System.out.println("Zooming Out...");
	             try {
	            	 Thread.sleep(500);
	             }catch (InterruptedException  e) {
	            	 e.printStackTrace();
	    		}
	             }

	    }

	    	@Test(priority = 6)
	    	public void ERDToggle() throws InterruptedException
	    	{

	    	WebElement ERDToggle = driver.findElement(By.xpath("/html/body/app-root/app-core/app-dashboard/div/div[1]/div[2]/button[3]"));
	    	highlightElement(driver, ERDToggle);
	    	ERDToggle.click();
	    	Thread.sleep(3000);
	    	WebElement erdContent = driver.findElement(By.xpath("/html/body/app-root/app-core/app-dashboard/div/div[1]/div[3]"));
	    	if(erdContent.isDisplayed()) {
	    		System.out.println("ERD Content Displayed");
	    	}
	    	else {
	    		System.out.println("ERD Content is not Displayed");
	    	}
	    	}

	    	@Test(priority = 7)
	    	public void OriginsToggle() throws InterruptedException
	    	{
	    		WebElement origins = driver.findElement(By.xpath("/html/body/app-root/app-core/app-dashboard/div/div[2]/div[2]/button[1]"));
	    		highlightElement(driver, origins);
	    		origins.click();
	    		origins.click();
	    		Thread.sleep(2000);

	    		WebElement OTCchart = driver.findElement(By.xpath("/html/body/app-root/app-core/app-dashboard/div/div[2]/div[3]"));
	    		if (OTCchart.isDisplayed()) {
	    			System.out.println("Origins data is displayed");
	    		}else {
	    			System.out.println("Origins data is not displayed");
	    		}

	    	}
	    	@Test(priority = 8)

	    	public void EdgeCDN() throws InterruptedException
	    	{
	    		WebElement edgecdn = driver.findElement(By.xpath("/html/body/app-root/app-core/app-dashboard/div/div[2]/div[2]/button[2]"));
	    		highlightElement(driver, edgecdn);
	    		edgecdn.click();
	    		Thread.sleep(2000);
	    	}

	    	@Test(priority = 9)
	    	public void Origins() throws InterruptedException
	    	{
	    		WebElement OriginNavigation = driver.findElement(By.xpath("/html/body/app-root/app-core/app-navbar/nav/div[2]/ul/li[2]"));
	    		OriginNavigation.click();
	    		Thread.sleep(2000);
	    		String url = driver.getCurrentUrl();
	    		//System.out.println(url);
	    		if(url.contains("http://192.168.1.232:7099/core/origins"))
	    		{System.out.println("Navigated to Origins");
	    		}
	    		else {
	    			System.out.println("Unable to navigate Originals");
	    		}
	    	}
	    	//101680968423
	    	@Test(priority = 10)
	    	public void OrginisSearch() throws InterruptedException
	    	{
	    		String[] searchTerms = {"Test", "Secondary"};
	    	    for (String searchTerm : searchTerms)
	    	    {
	    	        System.out.println("Performing search for: " + searchTerm);
	    	        WebElement searchInput = driver.findElement(By.xpath("/html/body/app-root/app-core/app-origin-list/div/div[1]/div[2]/div/input"));
	    			highlightElement(driver, searchInput);
	    	        searchInput.click();
	    	        searchInput.clear();
	    	        searchInput.sendKeys(searchTerm + Keys.RETURN);
	    	        Thread.sleep(2000);
	    	        searchInput.clear();
	    	    }
	    	   driver.navigate().refresh();
	    	}
	    	@Test(priority = 11)
	    	public void OriginsFilter() throws InterruptedException
	    	{
	    		WebElement filter = driver.findElement(By.xpath("/html/body/app-root/app-core/app-origin-list/div/div[1]/div[2]/button"));
	    		highlightElement(driver, filter);
	    		filter.click();
	    		Thread.sleep(1000);

	    		WebElement All =  driver.findElement(By.xpath("/html/body/app-root/app-core/app-origin-list/div/div[1]/div[3]/div[2]/div/label[1]/span"));
	    		highlightElement(driver, All);
	    		All.click();
	    		Thread.sleep(2000);

	    		filter.click();
	    		Thread.sleep(1000);


	    		WebElement Active = driver.findElement(By.xpath("/html/body/app-root/app-core/app-origin-list/div/div[1]/div[3]/div[2]/div/label[2]/span"));
	    		highlightElement(driver, Active);
	    		Active.click();
	    		Thread.sleep(2000);

	    		filter.click();
	    		Thread.sleep(1000);


	    		WebElement Inactive = driver.findElement(By.xpath("/html/body/app-root/app-core/app-origin-list/div/div[1]/div[3]/div[2]/div/label[3]/span"));
	    		highlightElement(driver, Inactive);
	    		Inactive.click();
	    		Thread.sleep(2000);

	    	}

	    	@Test(priority = 12)
	    	public void OriginsServer() throws InterruptedException
	    	{
	    		WebElement server = driver.findElement(By.xpath("/html/body/app-root/app-core/app-origin-list/div/div[4]/div/div/div[1]/img"));
	    		highlightElement(driver, server);
	    		server.click();
	    		Thread.sleep(1000);

	    		WebElement oneWeek = driver.findElement(By.xpath("/html/body/app-root/app-core/app-origin-list/div/div[4]/div/div[3]/div[1]/div/button[2]"));
	    		highlightElement(driver, oneWeek);
	    		oneWeek.click();
	    		Thread.sleep(1000);

	    		WebElement oneMonth = driver.findElement(By.xpath("/html/body/app-root/app-core/app-origin-list/div/div[4]/div/div[3]/div[1]/div/button[3]"));
	    		highlightElement(driver, oneMonth);
	    		oneMonth.click();
	    		Thread.sleep(1000);

	    		WebElement ThreeMonth = driver.findElement(By.xpath("/html/body/app-root/app-core/app-origin-list/div/div[4]/div/div[3]/div[1]/div/button[4]"));
	    		highlightElement(driver, ThreeMonth);
	    		ThreeMonth.click();
	    		Thread.sleep(1000);

	    		WebElement oneYear = driver.findElement(By.xpath("/html/body/app-root/app-core/app-origin-list/div/div[4]/div/div[3]/div[1]/div/button[5]"));
	    		highlightElement(driver, oneYear);
	    		oneYear.click();
	    		Thread.sleep(1000);


	    	}


	    	@Test(priority = 13)
	    	public void EdgeCDNs() throws InterruptedException
	    	{
	    		WebElement EdgeCDN = driver.findElement(By.xpath("/html/body/app-root/app-core/app-navbar/nav/div[2]/ul/li[3]"));
	    		EdgeCDN.click();
	    		Thread.sleep(2000);
	    	}

	    	@Test(priority = 14)
	    	public void EdgeCDNsSearch() throws InterruptedException
	    	{
	    		String[] searchTerms = {"Edge", "Secondary"};
	    	    for (String searchTerm : searchTerms)
	    	    {
	    	        System.out.println("Performing search for: " + searchTerm);
	    	        WebElement searchInput = driver.findElement(By.xpath("/html/body/app-root/app-core/app-edge-cdn-list/div/div[1]/div[2]/div/input"));
	    			highlightElement(driver, searchInput);
	    	        searchInput.click();
	    	        searchInput.clear();
	    	        searchInput.sendKeys(searchTerm + Keys.RETURN);
	    	        Thread.sleep(2000);
	    	        searchInput.clear();
	    	    }
	    	   driver.navigate().refresh();
	    	}
	    	@Test(priority = 15)
	    	public void EdgeCDNsFilter() throws InterruptedException
	    	{
	    		WebElement filter = driver.findElement(By.xpath("/html/body/app-root/app-core/app-edge-cdn-list/div/div[1]/div[2]/button"));
	    		highlightElement(driver, filter);
	    		filter.click();
	    		Thread.sleep(1000);

	    		WebElement All =  driver.findElement(By.xpath("/html/body/app-root/app-core/app-edge-cdn-list/div/div[1]/div[3]/div[2]/div/label[1]/span"));
	    		highlightElement(driver, All);
	    		All.click();
	    		Thread.sleep(2000);

	    		filter.click();
	    		Thread.sleep(1000);


	    		WebElement Active = driver.findElement(By.xpath("/html/body/app-root/app-core/app-edge-cdn-list/div/div[1]/div[3]/div[2]/div/label[2]/span"));
	    		highlightElement(driver, Active);
	    		Active.click();
	    		Thread.sleep(2000);

	    		filter.click();
	    		Thread.sleep(1000);


	    		WebElement Inactive = driver.findElement(By.xpath("/html/body/app-root/app-core/app-edge-cdn-list/div/div[1]/div[3]/div[2]/div/label[3]/span"));
	    		highlightElement(driver, Inactive);
	    		Inactive.click();
	    		Thread.sleep(2000);

	    	}

	    	@Test(priority = 16)
	    	public void EdgeCDNsServer() throws InterruptedException
	    	{
	    		WebElement server = driver.findElement(By.xpath("/html/body/app-root/app-core/app-edge-cdn-list/div/div[4]/div/div/div[1]/img"));
	    		highlightElement(driver, server);
	    		server.click();
	    		Thread.sleep(1000);

	    		WebElement oneWeek = driver.findElement(By.xpath("/html/body/app-root/app-core/app-edge-cdn-list/div/div[4]/div/div[3]/div[1]/div/button[2]"));
	    		highlightElement(driver, oneWeek);
	    		oneWeek.click();
	    		Thread.sleep(1000);

	    		WebElement oneMonth = driver.findElement(By.xpath("/html/body/app-root/app-core/app-edge-cdn-list/div/div[4]/div/div[3]/div[1]/div/button[3]"));
	    		highlightElement(driver, oneMonth);
	    		oneMonth.click();
	    		Thread.sleep(1000);

	    		WebElement ThreeMonth = driver.findElement(By.xpath("/html/body/app-root/app-core/app-edge-cdn-list/div/div[4]/div/div[3]/div[1]/div/button[4]"));
	    		highlightElement(driver, ThreeMonth);
	    		ThreeMonth.click();
	    		Thread.sleep(1000);

	    		WebElement oneYear = driver.findElement(By.xpath("/html/body/app-root/app-core/app-edge-cdn-list/div/div[4]/div/div[3]/div[1]/div/button[5]"));
	    		highlightElement(driver, oneYear);
	    		oneYear.click();
	    		Thread.sleep(1000);

	    	}
	   /*
	    	@Test(priority = 17)
	    	public void EdgeStreamer() throws InterruptedException
	    	{
	    		WebElement streamer = driver.findElement(By.xpath("/html/body/app-root/app-core/app-edge-cdn-list/div/div[4]/div/div[3]/div[3]/div/div/div[1]/div"));
	    		if (streamer.isDisplayed())
	     		{
	    		streamer.click();
	    		Thread.sleep(3000);

	    		WebElement oneWeek = driver.findElement(By.xpath("/html/body/app-root/app-core/app-edge-cdn-list/div[2]/div/div[4]/div[1]/div/button[2]"));
	    		highlightElement(driver, oneWeek);
	    		oneWeek.click();
	    		Thread.sleep(1000);

	    		WebElement oneMonth = driver.findElement(By.xpath("/html/body/app-root/app-core/app-edge-cdn-list/div[2]/div/div[4]/div[1]/div/button[3]"));
	    		highlightElement(driver, oneMonth);
	    		oneMonth.click();
	    		Thread.sleep(1000);

	    		WebElement ThreeMonth = driver.findElement(By.xpath("/html/body/app-root/app-core/app-edge-cdn-list/div[2]/div/div[4]/div[1]/div/button[4]"));
	    		highlightElement(driver, ThreeMonth);
	    		ThreeMonth.click();
	    		Thread.sleep(1000);

	    		WebElement oneYear = driver.findElement(By.xpath("/html/body/app-root/app-core/app-edge-cdn-list/div[2]/div/div[4]/div[1]/div/button[5]"));
	    		highlightElement(driver, oneYear);
	    		oneYear.click();
	    		Thread.sleep(1000);

	    		WebElement back = driver.findElement(By.xpath("/html/body/app-root/app-core/app-edge-cdn-list/div[2]/div/div[1]/img"));
	    		back.click();
	    		Thread.sleep(2000);
	    		}
	    		else {
					System.out.println("No Streaming Server");
				}

	    	}
	   */

	    	@Test(priority = 18)
	        public void profile() throws InterruptedException
	        {
	        	WebElement profile = driver.findElement(By.xpath("/html/body/app-root/app-core/app-navbar/nav/div[2]/ul/li[4]"));
	        	profile.click();
	        	Thread.sleep(2000);

	        }

	        @Test(priority = 19)
	        public void MyAccount() throws InterruptedException
	        {
	        	WebElement Myaccount = driver.findElement(By.xpath("/html/body/app-root/app-core/app-navbar/nav/div[2]/ul/li[4]/ul/a[1]/li"));
	        	highlightElement(driver, Myaccount);
	        	Myaccount.click();
	        	Thread.sleep(2000);

	        }

	        @Test(priority = 20)
	        public void Logout() throws InterruptedException
	        {
	        	WebElement profile = driver.findElement(By.xpath("/html/body/app-root/app-core/app-navbar/nav/div[2]/ul/li[4]/img"));
	        	profile.click();
	        	Thread.sleep(2000);
	        	WebElement Logout = driver.findElement(By.xpath("/html/body/app-root/app-core/app-navbar/nav/div[2]/ul/li[4]/ul/a[2]"));
	        	highlightElement(driver, Logout);
	        	Logout.click();
	        	Thread.sleep(2000);

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
	        previouslyHighlightedElement = element;

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



