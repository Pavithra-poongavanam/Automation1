package qsp;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
	public static void main(String[] args) throws InterruptedException {
		// System.setProperty("webdriver.chrome.driver",
		
		WebDriver driver = new ChromeDriver();
		Thread.sleep(2000);
		driver.get("http://103.255.144.131:8600/login");
        driver.manage().window().maximize();
        
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter email and password
        System.out.print("Enter your email: ");
        String email1 = scanner.nextLine();

        System.out.print("Enter your password: ");
        String password1 = scanner.nextLine();
        

		WebElement email = driver.findElement(By.xpath("/html/body/app-root/app-core/app-login/div/div[2]/div[2]/form/div[1]/input"));
		email.sendKeys(email1);
		Thread.sleep(2000);
		WebElement password = driver.findElement(By.xpath("/html/body/app-root/app-core/app-login/div/div[2]/div[2]/form/div[2]/input"));
		password.sendKeys(password1);
		
		Thread.sleep(2000);
	      WebElement viewPasswordButton = driver.findElement(By.xpath("/html/body/app-root/app-core/app-login/div/div[2]/div[2]/form/div[2]/img"));
          viewPasswordButton.click();
  		//Thread.sleep(2000);

		WebElement button = driver
				.findElement(By.xpath("/html/body/app-root/app-core/app-login/div/div[2]/div[2]/form/div[3]/button"));
		button.click();
		Thread.sleep(3000);
WebElement dashboardElement = driver.findElement(By.xpath("/html/body/app-root/app-core/app-channel-list/div/div/div[1]/div[1]/div[1]/h3"));
	
		if (dashboardElement.isDisplayed())
		{
			System.out.println("Login successful!");
		} 
		else
		{
			System.out.println("Login failed.");
		}		
		//Thread.sleep(2000);

		
		/*driver.navigate().back();
		
		WebElement email1 = driver.findElement(By.xpath("/html/body/app-root/app-core/app-login/div/div[2]/div[2]/form/div[1]/input"));
		email1.sendKeys("onnet@gmail.com");
		Thread.sleep(2000);
		WebElement password1 = driver.findElement(By.xpath("/html/body/app-root/app-core/app-login/div/div[2]/div[2]/form/div[2]/input"));
		password1.sendKeys("onnet@123");
		Thread.sleep(2000);
		WebElement viewPasswordButton1 = driver.findElement(By.xpath("/html/body/app-root/app-core/app-login/div/div[2]/div[2]/form/div[2]/img"));
        viewPasswordButton1.click();
		Thread.sleep(2000);
		WebElement button1 = driver.findElement(By.xpath("/html/body/app-root/app-core/app-login/div/div[2]/div[2]/form/div[3]/button"));
		button1.click();
		//Thread.sleep(3000);
		
		WebElement dashboardElement1 = driver.findElement(By.xpath("/html/body/app-root/app-core/app-channel-list/div/div/div[1]/div[1]/div[1]/h3"));
		
		if (dashboardElement1.isDisplayed()) {
			System.out.println("Login successful!");
		} else {
			System.out.println("Login failed.");
		
		}*/
		
		WebElement group = driver.findElement(By.xpath("/html/body/app-root/app-core/app-navbar/nav/div/div[2]/ul/li[2]/a"));
		group.click();
		Thread.sleep(2000);
		WebElement languages= driver.findElement(By.xpath("/html/body/app-root/app-core/app-navbar/nav/div/div[2]/ul/li[3]/a"));
		languages.click();
		Thread.sleep(2000);
		WebElement genres= driver.findElement(By.xpath("/html/body/app-root/app-core/app-navbar/nav/div/div[2]/ul/li[4]/a"));
		genres.click();
		Thread.sleep(2000);
		WebElement LiveEPG= driver.findElement(By.xpath("/html/body/app-root/app-core/app-navbar/nav/div/div[2]/ul/li[5]/a"));
		LiveEPG.click();
		Thread.sleep(2000);
		WebElement settings= driver.findElement(By.xpath("/html/body/app-root/app-core/app-navbar/nav/div/div[2]/ul/li[6]/a"));
		settings.click();
		Thread.sleep(2000);
		
		WebElement profile= driver.findElement(By.xpath("/html/body/app-root/app-core/app-navbar/nav/div/div[2]/img"));
		profile.click();
		
		Thread.sleep(2000);
		WebElement logout= driver.findElement(By.xpath("/html/body/app-root/app-core/app-profile/div/div/div/button"));
		logout.click();
		
		
		
	//	driver.quit();
		
		
		
		
	}
	}
