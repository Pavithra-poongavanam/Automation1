package epg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
public class Language {

	public static void main(String[] args) throws InterruptedException 
	
	{
	WebDriver driver= new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("http://103.255.144.131:8600/login");	
	driver.manage().window().maximize();
	WebElement emailElement = driver.findElement(By.xpath("/html/body/app-root/app-core/app-login/div/div[2]/div[2]/form/div[1]/input"));
	emailElement.sendKeys("onnet@gmail.com");
	WebElement passwordElement = driver.findElement(By.xpath("/html/body/app-root/app-core/app-login/div/div[2]/div[2]/form/div[2]/input"));
	passwordElement.sendKeys("onnet@1234");
	WebElement loginbuttonElement = driver.findElement(By.xpath("/html/body/app-root/app-core/app-login/div/div[2]/div[2]/form/div[3]/button"));
	loginbuttonElement.click();
	Thread.sleep(2000);
	
	WebElement language = driver.findElement(By.xpath("/html/body/app-root/app-core/app-navbar/nav/div/div[2]/ul/li[3]/a"));
	language.click();
	Thread.sleep(2000);
	WebElement languageCreate= driver.findElement(By.cssSelector("button[class=\"cta\"]"));
	languageCreate.click();
	
	WebElement languageName= driver.findElement(By.cssSelector("input[formcontrolname=\"languageName\"]"));
	languageName.sendKeys("Korea");
	Thread.sleep(2000);
	WebElement languagecode= driver.findElement(By.cssSelector("input[formcontrolname=\"languageCode\"]"));
	languagecode.sendKeys("KO");
	Thread.sleep(2000);
	WebElement languageReset = driver.findElement(By.xpath("/html/body/app-root/app-core/app-create-language/div/div/div[2]/div[2]/form/div[2]/div/div[1]/button"));
	languageReset.click();
	Thread.sleep(2000);
	languageName.sendKeys("Thai");
	languagecode.sendKeys("Th");
	Thread.sleep(2000);
	
	WebElement logo1= driver.findElement(By.xpath("/html/body/app-root/app-core/app-create-language/div/div/div[2]/div[1]/div[1]/div[2]/div/label/span"));
	if (logo1.isEnabled()) {
		Thread.sleep(2000);
	    WebElement fileInput = driver.findElement(By.id("fileInput")); 
	    fileInput.sendKeys("C:\\Users\\User\\Desktop\\onnet_logo.jpg");
	} else {
	    System.out.println("Upload button is not enabled!");
	}
Thread.sleep(5000);
WebElement logo2 = driver.findElement(By.xpath("/html/body/app-root/app-core/app-create-language/div/div/div[2]/div[1]/div[2]/div[2]/div/label/span")); // Update the XPath accordingly for the second logo
if (logo2.isEnabled()) {
    Thread.sleep(2000);
    WebElement fileInput2 = driver.findElement(By.id("fileInput2")); 
    fileInput2.sendKeys("C:\\Users\\User\\Desktop\\onnet_logo.jpg"); 
} else {
    System.out.println("Upload button for Logo 2 is not enabled!");
}
Thread.sleep(5000);	

    WebElement languageSave = driver.findElement(By.xpath("/html/body/app-root/app-core/app-create-language/div/div/div[2]/div[2]/form/div[2]/div/div[2]/button"))	;
    languageSave.click();
    WebElement confirmationmessage= driver.findElement(By.xpath("/html/body/app-root/app-core/app-language-list/div/div/div[1]/h3"));
    if(confirmationmessage.isDisplayed()) {
    	System.out.println("Language has been successfully created.");
    }
    else {
		System.out.println("Language is not created. Error!!!");
	}
	}
}

	
    

	
	
	
	
	
	
	
	
	
	
	

