package Random;

import org.bouncycastle.oer.its.ieee1609dot2.basetypes.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Channel {
	WebDriver driver= new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	long starttime;

	@BeforeSuite

	public void starttime()
	{
		 starttime = System.currentTimeMillis();
	}

    @Test(priority = 0)
    public void SetUp() throws InterruptedException {

    	driver.get("https://admin.skypro.co.in/");
		driver.manage().window().maximize();
		WebElement email = driver.findElement(By.xpath("/html/body/app-root/app-core/div/app-login/div/div/div[2]/form/div/div[1]/input"));
		email.sendKeys("onnet@gmail.com");
		Thread.sleep(1000);
		WebElement password= driver.findElement(By.xpath("/html/body/app-root/app-core/div/app-login/div/div/div[2]/form/div/div[2]/div/input"));
		password.sendKeys("Onnet@123");
		Thread.sleep(1000);
		WebElement Login= driver.findElement(By.xpath("/html/body/app-root/app-core/div/app-login/div/div/div[2]/form/div/div[3]/button"));
		Login.click();
		Thread.sleep(3000);
     }

	@Test(priority = 1)
	public void content () throws InterruptedException

	{
		WebElement contentElement = driver.findElement(By.xpath("//*[@id=\"main-menu-id2\"]/span"));
		contentElement.click();
		Thread.sleep(2000);
		WebElement Channel = driver.findElement(By.xpath("//*[@id=\"subMenu2\"]/li[2]"));
		Channel.click();
		Thread.sleep(2000);
	}
	@Test(priority = 2)
	public void ADDNew() throws InterruptedException
	{
		WebElement addElement= driver.findElement(By.xpath("/html/body/app-root/app-core/div/app-list-channel/div/div[1]/a/button"));
		addElement.click();
		Thread.sleep(2000);

	}

	@Test(priority = 3)
	public void Details() throws InterruptedException
	{
		WebElement name = driver.findElement(By.xpath("/html/body/app-root/app-core/div/app-create-channel/div/form/div/div/div[1]/input"));
		name.sendKeys("PEAR TV");
		Thread.sleep(200);

		WebElement number = driver.findElement(By.xpath("/html/body/app-root/app-core/div/app-create-channel/div/form/div/div/div[2]/input"));
		number.sendKeys(Keys.CONTROL + "a");
		number.sendKeys(Keys.DELETE);
		number.sendKeys("1245");
		Thread.sleep(200);

		WebElement Description = driver.findElement(By.xpath("/html/body/app-root/app-core/div/app-create-channel/div/form/div/div/div[3]/textarea"));
		Description.sendKeys("PEAR TV");
		Thread.sleep(200);
	/*
		WebElement unicastHSL = driver.findElement(By.xpath("/html/body/app-root/app-core/div/app-create-channel/div/form/div/div/div[4]/input"));
		unicastHSL.sendKeys("http://");
		Thread.sleep(200);

		WebElement unicastDash = driver.findElement(By.xpath("/html/body/app-root/app-core/div/app-create-channel/div/form/div/div/div[5]/input"));
		unicastDash.sendKeys("http://");
		Thread.sleep(200);
	*/
		WebElement multicast = driver.findElement(By.xpath("/html/body/app-root/app-core/div/app-create-channel/div/form/div/div/div[6]/input"));
		multicast.sendKeys("udp://");
		Thread.sleep(200);


		WebElement quality = driver.findElement(By.xpath("/html/body/app-root/app-core/div/app-create-channel/div/form/div/div/div[8]/select"));
		quality.click();
		Thread.sleep(200);

		WebElement SD = driver.findElement(By.xpath("/html/body/app-root/app-core/div/app-create-channel/div/form/div/div/div[8]/select/option[2]"));
		SD.click();
		Thread.sleep(200);

		WebElement type = driver.findElement(By.xpath("/html/body/app-root/app-core/div/app-create-channel/div/form/div/div/div[9]/select"));
		type.click();
		Thread.sleep(200);


		WebElement Free = driver.findElement(By.xpath("/html/body/app-root/app-core/div/app-create-channel/div/form/div/div/div[9]/select/option[2]"));
		Free.click();
		Thread.sleep(200);

		WebElement protocol = driver.findElement(By.xpath("/html/body/app-root/app-core/div/app-create-channel/div/form/div/div/div[13]/input"));
		protocol.sendKeys("udp");
		Thread.sleep(200);





	}





}



