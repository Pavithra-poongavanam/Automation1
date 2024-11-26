package qsp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoLocator {

	public static void main(String[] args) {
WebDriver driver= new ChromeDriver();
driver.get("file:///C:/Users/User/Desktop/demo.html");
driver.findElement(By.tagName("a")).click();
driver.navigate().back();
driver.findElement(By.id("d1")).click();
driver.navigate().back();
driver.findElement(By.name("n1")).click();
driver.navigate().back();
driver.findElement(By.className("c1")).click();
driver.navigate().back();
	}

}
