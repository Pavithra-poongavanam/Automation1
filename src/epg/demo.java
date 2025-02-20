package epg;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class demo {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
try{
            // Login to the application
            Thread.sleep(3000);
            driver.get("http://103.255.144.131:8600/login");
            Thread.sleep(2000);
            driver.manage().window().maximize();
            Thread.sleep(2000);
            WebElement email = driver.findElement(By.xpath("/html/body/app-root/app-core/app-login/div/div[2]/div[2]/form/div[1]/input"));
            email.sendKeys("onnet@gmail.com");
            Thread.sleep(1000);
            WebElement password = driver.findElement(By.xpath("/html/body/app-root/app-core/app-login/div/div[2]/div[2]/form/div[2]/input"));
            password.sendKeys("onnet@1234");
            Thread.sleep(1000);
            WebElement eyebuttonElement = driver.findElement(By.xpath("//Img[@alt='Show Password']"));
    		eyebuttonElement.click();
    		Thread.sleep(2000);
            WebElement login = driver.findElement(By.xpath("/html/body/app-root/app-core/app-login/div/div[2]/div[2]/form/div[3]/button"));
            login.click();
            Thread.sleep(3000);


            WebElement genreElement = driver.findElement(By.xpath("/html/body/app-root/app-core/app-navbar/nav/div/div[2]/ul/li[4]/a"));
    		genreElement.click();
    		Thread.sleep(2000);
    		WebElement genre= driver.findElement(By.xpath("/html/body/app-root/app-core/app-genre-list/div/div/div[1]/h3"));
    		if(genre.isDisplayed()) {
				System.out.println("Genre Page");
			} else {
    				System.out.println("Unable to open genre page");
    			}
    		Thread.sleep(5000);
    		WebElement actionElement= driver.findElement(By.xpath("/html/body/app-root/app-core/app-genre-list/div/div/div[2]/div[2]/div[3]/span/svg"));

    		actionElement.click();
    		Thread.sleep(1000);
    		WebElement editgenreElement=driver.findElement(By.xpath("/html/body/app-root/app-core/app-genre-list/div/div/div[2]/div[24]/div[3]/span/div/ul/li"));
    	editgenreElement.click();


}catch (Exception e) {
    e.printStackTrace();
} finally {
  //  driver.quit();
}
}
}