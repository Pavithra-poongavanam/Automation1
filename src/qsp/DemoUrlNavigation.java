package qsp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoUrlNavigation {

	public static void main(String[] args) {


		WebDriver driver= new ChromeDriver();
		driver.get("https://www.selenium.org/");
		String url = driver.getCurrentUrl();
		if(url.equals("https://www.selenium.dev/"))
		{
			System.out.println("Pass");
		}
		else
		{
			System.out.println("Fail");
		}
		driver.quit();

	}


}








