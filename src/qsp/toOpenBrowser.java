package qsp;

import org.openqa.selenium.chrome.ChromeDriver;

public class toOpenBrowser {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.google.com");
		String title = driver.getTitle();
		System.out.println(title);
		driver.quit();

	}

}
