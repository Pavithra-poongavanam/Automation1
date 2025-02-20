package epg;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class Groups_Demo {
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
            Thread.sleep(5000);

            WebElement dashboardElement1 = driver.findElement(By.xpath("/html/body/app-root/app-core/app-channel-list/div/div/div[1]/div[1]/div[1]/h3"));

    		if (dashboardElement1.isDisplayed()) {
    			System.out.println("Login successful!");
    		} else {
    			System.out.println("Login failed.");
    		}
    		WebElement groups= driver.findElement(By.xpath("/html/body/app-root/app-core/app-navbar/nav/div/div[2]/ul/li[2]/a"));
   		 groups.click();
   		 Thread.sleep(2000);
   		 //Search function
   		WebElement search= driver.findElement(By.xpath("/html/body/app-root/app-core/app-client-list/div/div/div[1]/div/div/input"));
   		 search.sendKeys("Testing");
   		 Thread.sleep(2000);
   		 search.clear();
   		 Thread.sleep(1000);
   	//Create group
		 WebElement create = driver.findElement(By.xpath("/html/body/app-root/app-core/app-client-list/div/div/div[1]/div/button"));
		 create.click();
		 Thread.sleep(2000);
		 WebElement groupNameField = driver.findElement(By.xpath("/html/body/app-root/app-core/app-create-edit-client/div/div/form/div[1]/input"));
		 groupNameField.sendKeys("Demo");
		 // Randomly select a radio button for services
 		List<WebElement> serviceRadioButtons = driver.findElements(By.cssSelector("input[type='radio']"));
 		int randomIndex = new Random().nextInt(serviceRadioButtons.size());
 		serviceRadioButtons.get(randomIndex).click();
 		WebElement grouptagElement= driver.findElement(By.xpath("/html/body/app-root/app-core/app-create-edit-client/div/div/form/div[3]/div/div/div[6]"));
 		grouptagElement.click();
 		 WebElement nextButton = driver.findElement(By.xpath("/html/body/app-root/app-core/app-create-edit-client/div/div/div[2]/div[2]/button"));
         nextButton.click();
         Thread.sleep(5000);

         WebElement channelMappingElement = driver.findElement(By.xpath("/html/body/app-root/app-core/app-mapping-client/div/div/div[2]/div[1]/div[1]/p[1]"));
         if (channelMappingElement.isDisplayed()) {
             System.out.println("Navigated to channel mapping page");
         } else {
             System.out.println("Couldn't map channels");
         }
         WebElement mappingchannel= driver.findElement(By.xpath("/html/body/app-root/app-core/app-mapping-client/div/div/div[2]/div[2]/div[16]/label/img"));
         mappingchannel.click();

         WebElement nextbuttonElement = driver.findElement(By.xpath("/html/body/app-root/app-core/app-mapping-client/div/div/div[2]/div[3]/div[2]/div[2]/button"));
         nextbuttonElement.click();
         Thread.sleep(2000);
        WebElement UnicastHLSURL = driver.findElement(By.xpath("/html/body/app-root/app-core/app-create-mapping/div/div/div/div[2]/form/div[2]/div[1]/input"));
        UnicastHLSURL.sendKeys("www.demo");

        WebElement UnicastDashURL = driver.findElement(By.xpath("/html/body/app-root/app-core/app-create-mapping/div/div/div/div[2]/form/div[2]/div[2]/input"));
        UnicastDashURL.sendKeys("www.demo");

        WebElement multicastElement= driver.findElement(By.xpath("/html/body/app-root/app-core/app-create-mapping/div/div/div/div[2]/form/div[2]/div[3]/input"));
        multicastElement.sendKeys("6");

        WebElement channelIdElement = driver.findElement(By.xpath("/html/body/app-root/app-core/app-create-mapping/div/div/div/div[2]/form/div[2]/div[4]/input"));
        channelIdElement.sendKeys("2");

        WebElement lCNElement = driver.findElement(By.xpath("/html/body/app-root/app-core/app-create-mapping/div/div/div/div[2]/form/div[2]/div[5]/input"));
        lCNElement.sendKeys("2");

        WebElement billingstatusElement= driver.findElement(By.xpath("/html/body/app-root/app-core/app-create-mapping/div/div/div/div[2]/form/div[2]/div[7]/select"));
        billingstatusElement.click();
        WebElement freeElement= driver.findElement(By.xpath("/html/body/app-root/app-core/app-create-mapping/div/div/div/div[2]/form/div[2]/div[7]/select/option[1]"));
        freeElement.click();

        WebElement saveElement= driver.findElement(By.xpath("/html/body/app-root/app-core/app-create-mapping/div/div/div/div[3]/div/div[3]/button"));
        saveElement.click();
        Thread.sleep(5000);
        WebElement mappedchannelpage = driver.findElement(By.xpath("/html/body/app-root/app-core/app-client-details/div/div[2]/div/div/div/div[1]/div[1]/div[1]/h3"));
        if (mappedchannelpage.isDisplayed()) {
 			System.out.println("Channels are mapped successfully");
 		} else {
 			System.out.println("Couldn't map");

        }
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
          //  driver.quit();
        }
    }
    }



