package epg;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class Genre {

	public static void main(String[] args) throws InterruptedException

	{
		WebDriver driver= new ChromeDriver();


try {

		// TODO Auto-generated method stub
		driver.get("http://103.255.144.131:8600/login");
		driver.manage().window().maximize();
		WebElement email = driver.findElement(By.xpath("/html/body/app-root/app-core/app-login/div/div[2]/div[2]/form/div[1]/input"));
		email.sendKeys("onnet@gmail.com");
		Thread.sleep(1000);
		WebElement password= driver.findElement(By.xpath("/html/body/app-root/app-core/app-login/div/div[2]/div[2]/form/div[2]/input"));
		password.sendKeys("onnet@1234");
		Thread.sleep(1000);
		WebElement Login= driver.findElement(By.xpath("/html/body/app-root/app-core/app-login/div/div[2]/div[2]/form/div[3]/button"));
		Login.click();
		Thread.sleep(2000);
		WebElement genreElement = driver.findElement(By.xpath("/html/body/app-root/app-core/app-navbar/nav/div/div[2]/ul/li[4]/a"));
		genreElement.click();
		Thread.sleep(2000);
		WebElement genre= driver.findElement(By.xpath("/html/body/app-root/app-core/app-genre-list/div/div/div[1]/h3"));
if(genre.isDisplayed()) {
	System.out.println("Genre Page");
} else {
		System.out.println("Unable to open genre page");
	}
WebElement creategenreElement= driver.findElement(By.xpath("//button[@class='cta']"));
creategenreElement.click();
Thread.sleep(2000);
WebElement genrenameElement = driver.findElement(By.xpath("//input[@formcontrolname='categoryName']"));
genrenameElement.sendKeys("Dramazz");
WebElement genrelogo1= driver.findElement(By.xpath("/html/body/app-root/app-core/app-create-genre/div/div/div[2]/div[1]/div[1]/div[2]/div/label/span"));

if (genrelogo1.isEnabled()) {
    Thread.sleep(2000);
    WebElement fileInput = driver.findElement(By.id("fileInput"));
    fileInput.sendKeys("C:\\Users\\User\\Desktop\\onnet_logo.jpg");
    System.out.println("Logo Uploaded successfully");
} else {
    System.out.println("Upload button for Logo 1 is not enabled!");
}
Thread.sleep(5000);

WebElement genrelogo2= driver.findElement(By.xpath("/html/body/app-root/app-core/app-create-genre/div/div/div[2]/div[1]/div[2]/div[2]/div/label"));
if(genrelogo2.isEnabled())
{
	WebElement fileInput2= driver.findElement(By.id("fileInput2"));
	fileInput2.sendKeys("C:\\Users\\User\\Desktop\\onnet_logo.jpg");
    System.out.println("Logo Uploaded successfully");

	Thread.sleep(2000);
}
else {
	System.out.println("Upload button for logo2 is not enabled");
}
	Thread.sleep(2000);
	WebElement genresaveElement= driver.findElement(By.xpath("/html/body/app-root/app-core/app-create-genre/div/div/div[2]/div[2]/form/div[2]/div/div[2]/button"));
	genresaveElement.click();
	Thread.sleep(2000);
WebElement genre1= driver.findElement(By.xpath("/html/body/app-root/app-core/app-genre-list/div/div/div[1]/h3"));

if(genre1.isDisplayed()) {
	System.out.println("Genre successfully created");
} else {
		System.out.println("Unable to create genre");
	}
Thread.sleep(2000);

WebElement profileElement= driver.findElement(By.xpath("//img[@alt=\"profile\"]"));
profileElement.click();
Thread.sleep(2000);
WebElement logoutElement = driver.findElement(By.xpath("//button[text()='Logout']"));
logoutElement.click();
Thread.sleep(2000);
WebElement homepageElement=driver.findElement(By.xpath("/html/body/app-root/app-core/app-login/div/div[2]/div[1]/img"));
if(homepageElement.isDisplayed())
{
	System.out.println("Successfully Logged out");
}


} catch (Exception e) {
    System.out.println("An error occurred: " + e.getMessage());
} finally {
//    driver.quit();
}
}
}



