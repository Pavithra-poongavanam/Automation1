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

public class Broadcaster {

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
			WebElement broadcaster = driver.findElement(By.xpath("//*[@id=\"subMenu2\"]/li[1]"));
			broadcaster.click();
			Thread.sleep(2000);
		}
		@Test(priority = 2)
		public void ADDNew() throws InterruptedException
		{
			WebElement addElement= driver.findElement(By.xpath("/html/body/app-root/app-core/div/app-list-broadcaster/div/div[1]/a/button"));
			addElement.click();
			Thread.sleep(2000);

		}

		@Test(priority = 3)
		public void Details() throws InterruptedException
		{
			WebElement name = driver.findElement(By.xpath("/html/body/app-root/app-core/div/app-create-broadcaster/div/form/div/div/div[1]/input"));
			name.sendKeys("dfasdfa");
			Thread.sleep(200);
			WebElement contact = driver.findElement(By.xpath("/html/body/app-root/app-core/div/app-create-broadcaster/div/form/div/div/div[2]/input"));
			contact.sendKeys("8956471252");
			Thread.sleep(200);
			WebElement Description = driver.findElement(By.xpath("/html/body/app-root/app-core/div/app-create-broadcaster/div/form/div/div/div[3]/textarea"));
			Description.sendKeys("sdfsdf");
			Thread.sleep(200);
			WebElement landline = driver.findElement(By.xpath("/html/body/app-root/app-core/div/app-create-broadcaster/div/form/div/div/div[4]/input"));
			landline.sendKeys("8956471252");
			Thread.sleep(200);

			WebElement Mobile = driver.findElement(By.xpath("/html/body/app-root/app-core/div/app-create-broadcaster/div/form/div/div/div[5]/input"));
			Mobile.sendKeys("8956471252");
			Thread.sleep(200);

			WebElement email = driver.findElement(By.xpath("/html/body/app-root/app-core/div/app-create-broadcaster/div/form/div/div/div[6]/input"));
			email.sendKeys("b@gmail.com");
			Thread.sleep(200);

			WebElement city = driver.findElement(By.xpath("/html/body/app-root/app-core/div/app-create-broadcaster/div/form/div/div/div[7]/input"));
			city.sendKeys("Delhi");
			Thread.sleep(200);

			WebElement state = driver.findElement(By.xpath("/html/body/app-root/app-core/div/app-create-broadcaster/div/form/div/div/div[8]/input"));
			state.sendKeys("Delhi");

			Thread.sleep(200);

			WebElement pin = driver.findElement(By.xpath("/html/body/app-root/app-core/div/app-create-broadcaster/div/form/div/div/div[9]/input"));
			pin.sendKeys(Keys.CONTROL + "a");
			pin.sendKeys(Keys.DELETE);
			pin.sendKeys("110002");
			Thread.sleep(200);

			WebElement address = driver.findElement(By.xpath("/html/body/app-root/app-core/div/app-create-broadcaster/div/form/div/div/div[10]/textarea"));
			address.sendKeys("Delhi");
			Thread.sleep(200);

		}





}
