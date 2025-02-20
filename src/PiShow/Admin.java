package PiShow;

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
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Admin {
	WebDriver driver = new ChromeDriver();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	long starttime;
	JavascriptExecutor  jsExecutor;

@BeforeSuite
	public void StartTime()
	{
		starttime= System.currentTimeMillis();
	}
	@Test(priority = 0)
	public void Setup() throws InterruptedException
	{
		driver.get("https://app-acms.pishow.tv/login");
		driver.manage().window().maximize();
		Thread.sleep(2000);
	}
	@Test (priority = 1)
	public void LoginPage() throws InterruptedException
	{
		WebElement email = driver.findElement(By.xpath("/html/body/app-root/app-core/app-login/div/div[2]/div/div/form/input"));
		highlightElement(driver, email);
		email.sendKeys("onnet@gmail.com");

		WebElement password = driver.findElement(By.xpath("/html/body/app-root/app-core/app-login/div/div[2]/div/div/form/div[1]/input"));
		highlightElement(driver, password);
		password.sendKeys("Onnet@1234");

		WebElement signin = driver.findElement(By.xpath("/html/body/app-root/app-core/app-login/div/div[2]/div/div/form/div[2]/button[2]"));
		highlightElement(driver, signin);
		signin.click();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toastMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(@class, 'toast__content')]") ));
        String messageText = toastMessage.getText();
        System.out.println(messageText);


		String url = driver.getCurrentUrl();
		System.out.println(url);
		if (url.contains("https://app-acms.pishow.tv/dashboard")) {
		System.out.println("Navigated to Dashboard");
		}
		else {
			System.out.println("Unable to Navigate Dashboard");
		}
		Thread.sleep(5000);


}

@Test(priority = 2)
public void manage() throws InterruptedException
{
	WebElement manage = driver.findElement(By.xpath("/html/body/app-root/app-core/app-navbar/nav/div/div[2]/ul/li[2]"));
	highlightElement(driver, manage);
	manage.click();
	Thread.sleep(2000);
}
@Test(priority = 3)
public void AdminNavigation() throws InterruptedException
{
	WebElement admin = driver.findElement(By.xpath("/html/body/app-root/app-core/app-navbar/nav/div/div[2]/ul/li[2]/ul/a[1]/li"));
	highlightElement(driver, admin);
	admin.click();
	Thread.sleep(2000);
	String url = driver.getCurrentUrl();
	System.out.println(url);
	if(url.contains("https://app-acms.pishow.tv/admin")) {
		System.out.println("Navigated to Admin Page");
	}
	else {
		System.out.println("Not able to navigate admin page");
	}
}
@Test(priority = 4)
public void Filters() throws InterruptedException
{
	WebElement filter = driver.findElement(By.xpath("//img[@alt=\"filter\"]"));
	filter.click();
	WebElement option = driver.findElement(By.xpath("/html/body/app-root/app-core/app-admin-list/div/div/div[2]/div/div/div/select"));
	option.click();

	WebElement active = driver.findElement(By.xpath("/html/body/app-root/app-core/app-admin-list/div/div/div[2]/div/div/div/select/option[2]"));
	active.click();

	WebElement apply = driver.findElement(By.xpath("/html/body/app-root/app-core/app-admin-list/div/div/div[2]/div/div/div/div/button[2]"));
	apply.click();

	Thread.sleep(2000);
	WebElement clearFilter = driver.findElement(By.xpath("//span[text()='clear filter']"));
	clearFilter.click();
	Thread.sleep(2000);
}

@Test (priority = 5)
public void Search() throws InterruptedException
{
	String[] searchterm = { "Testing", "testing123"};
	for(String searchterms : searchterm)
	{
	WebElement search = driver.findElement(By.xpath("/html/body/app-root/app-core/app-admin-list/div/div/div[3]/div[2]/input"));
	highlightElement(driver, search);
	search.click();
	search.clear();
	search.sendKeys(searchterms + Keys.RETURN);
	Thread.sleep(2000);
	search.clear();
	}
	driver.navigate().refresh();


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

	        js.executeScript("arguments[0].style.border='3px solid blue'", element);
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
		public void EndTime()
		{
			long endtime = System.currentTimeMillis();
			long totaltime = endtime - starttime;
			System.out.println("Total time taken to execute the suit:" + totaltime);

		}

		}






