package epg;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.Keys;


import java.util.List;
import java.util.Random;
public class All_demo {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
try{
        
            // Login to the application
            Thread.sleep(2000);
            driver.get("http://103.255.144.131:8600/login");
            Thread.sleep(2000);
            driver.manage().window().maximize();
            Thread.sleep(3000);
            WebElement email = driver.findElement(By.xpath("/html/body/app-root/app-core/app-login/div/div[2]/div[2]/form/div[1]/input"));
            email.sendKeys("onnet@gmail.com");
           // Thread.sleep(1000);
            WebElement password = driver.findElement(By.xpath("/html/body/app-root/app-core/app-login/div/div[2]/div[2]/form/div[2]/input"));
            password.sendKeys("onnet@1234");
         //   Thread.sleep(1000);
            WebElement eyebuttonElement = driver.findElement(By.xpath("//Img[@alt='Show Password']"));
    		eyebuttonElement.click();
    	//	Thread.sleep(2000);
            WebElement login = driver.findElement(By.xpath("/html/body/app-root/app-core/app-login/div/div[2]/div[2]/form/div[3]/button"));
            login.click();
           Thread.sleep(5000); 
            
            WebElement dashboardElement1 = driver.findElement(By.xpath("/html/body/app-root/app-core/app-channel-list/div/div/div[1]/div[1]/div[1]/h3"));
    		
    		if (dashboardElement1.isDisplayed()) {
    			System.out.println("Login successful!");
    		} else {
    			System.out.println("Login failed.");   		
    		}
    		//Search
    		String[] searchTerms = {"HBO", "Zee"};
            for (String searchTerm : searchTerms) {
                System.out.println("Performing search for: " + searchTerm);
                            WebElement searchInput = driver.findElement(By.xpath("/html/body/app-root/app-core/app-channel-list/div/div/div[1]/div[2]/div[1]/input"));
                            searchInput.click();
                searchInput.clear();  
                searchInput.sendKeys(searchTerm + Keys.RETURN);  
                List<WebElement> results = driver.findElements(By.className("resultstyle"));
                if (!results.isEmpty()) {
                    for (WebElement result : results) {
                        if (result.isDisplayed()) {
                            System.out.println("Result: " + result.getText());                         
                        }
                    }
                } else {
                    System.out.println("No results found for: " + searchTerm);
                }
               Thread.sleep(500);            
        }       
            driver.navigate().refresh();
            Thread.sleep(2000);
            
            //Filter
            WebElement filter = driver.findElement(By.xpath("/html/body/app-root/app-core/app-channel-list/div/div/div[1]/div[2]/div[2]/div/div[1]/button")); // Replace with the actual ID
       		filter.click();	 
       		Thread.sleep(500);
       		WebElement comedycheckbox= driver.findElement(By.xpath(" //span[text()='Comedy']/preceding-sibling::input[@type='checkbox']\r\n"));
       		comedycheckbox.click();
       		WebElement outerElement = driver.findElement(By.xpath("/html/body/app-root/app-core/app-navbar/nav/div"));
       		outerElement.click();
       		Thread.sleep(500);
            driver.navigate().refresh();
            Thread.sleep(500);
//sort
WebElement sort = driver.findElement(By.xpath("/html/body/app-root/app-core/app-channel-list/div/div/div[1]/div[2]/div[3]/div/div/button"));
sort.click();	
Thread.sleep(500);
WebElement radiobutton= driver.findElement(By.xpath("//span[text()=\"A_Z\"]/preceding-sibling::input[@type='radio']\r\n"));
radiobutton.click();
Thread.sleep(500);
driver.navigate().refresh();
Thread.sleep(200);

//channel creation
WebElement createchannel= driver.findElement(By.xpath("/html/body/app-root/app-core/app-channel-list/div/div/div[1]/div[2]/button"));
createchannel.click(); 
System.out.println("Channel Creation page");
Thread.sleep(100);

            WebElement channelNameInput = driver.findElement(By.cssSelector("body > app-root > app-core > app-create-channel > div > div.content__box > form > div > div.input_with_icon > input"));
            channelNameInput.sendKeys("AutomationTesting1");
            Thread.sleep(100);
            
            WebElement uploadButton = driver.findElement(By.xpath("/html/body/app-root/app-core/app-create-channel/div/div[1]/form/div/div[1]/div[2]/div/label/span"));
            if (uploadButton.isEnabled()) {
                // Upload a file (select a file from the local drive)
            	//uploadButton.click();
            	Thread.sleep(200);
                WebElement fileInput = driver.findElement(By.id("fileInput")); // Replace with the actual ID of the file input element
                fileInput.sendKeys("C:\\Users\\User\\Desktop\\onnet_logo.jpg"); // Replace with the file's actual path
              //  uploadButton.click();
            } else {
                System.out.println("Upload button is not enabled!");
            }
            
            Thread.sleep(200);
            
            // Selecting random genre from the genre dropdown
            WebElement genreDropdown = driver.findElement(By.xpath("/html/body/app-root/app-core/app-create-channel/div/div[1]/form/div/div[3]/div[1]/select"));
            genreDropdown.click();
            Thread.sleep(200);
            Select genreSelect = new Select(genreDropdown);  
            List<WebElement> genreOptions = genreSelect.getOptions();
            Random rand = new Random();
            int randomGenreIndex = rand.nextInt(genreOptions.size() - 1) + 1; 
            genreSelect.selectByIndex(randomGenreIndex);
            String selectedGenreOptionText = genreOptions.get(randomGenreIndex).getText();
            System.out.println("Genre Selected is: " + selectedGenreOptionText);
                        
            // Selecting random language from the language dropdown
            WebElement languageDropdown = driver.findElement(By.xpath("/html/body/app-root/app-core/app-create-channel/div/div[1]/form/div/div[3]/div[2]/select"));
            languageDropdown.click();
            Thread.sleep(200);
            Select languageSelect = new Select(languageDropdown);
            List<WebElement> languageOptions = languageSelect.getOptions();
            int randomLanguageIndex = rand.nextInt(languageOptions.size() - 1) + 1; 
            languageSelect.selectByIndex(randomLanguageIndex);
            
            String selectedlanguageOptionText = languageOptions.get(randomLanguageIndex).getText();
            System.out.println("Language Selected  is: " + selectedlanguageOptionText);
            
            Thread.sleep(2000);
                       
            
     WebElement saveButton = driver.findElement(By.xpath("/html/body/app-root/app-core/app-create-channel/div/div[1]/form/div/div[4]/div[2]/div[2]/button"));
            saveButton.click();
            Thread.sleep(4000);
            WebElement channelsCreationpage= driver.findElement(By.xpath("/html/body/app-root/app-core/app-channel-list/div/div/div[1]/div[1]/div[1]/h3"));
            if(channelsCreationpage.isDisplayed())
            {
            	System.out.println("Channel Created Successfully");;
            	
            }
            else {
				System.out.println("Error!!! Channel is not created !!!");
				
			}
            Thread.sleep(5000);
//Group Page
            
            WebElement groups= driver.findElement(By.xpath("/html/body/app-root/app-core/app-navbar/nav/div/div[2]/ul/li[2]/a"));
      		 groups.click();
      		 Thread.sleep(2000);
      		 //Search function
      		WebElement search= driver.findElement(By.xpath("/html/body/app-root/app-core/app-client-list/div/div/div[1]/div/div/input"));
      		 search.sendKeys("testing");
      		 Thread.sleep(2000);
      		 search.clear();
      		 Thread.sleep(1000);
      	//Create group
   		 WebElement create = driver.findElement(By.xpath("/html/body/app-root/app-core/app-client-list/div/div/div[1]/div/button"));
   		 create.click();
   		 Thread.sleep(2000);
   		 WebElement groupNameField = driver.findElement(By.xpath("/html/body/app-root/app-core/app-create-edit-client/div/div/form/div[1]/input"));
   		 groupNameField.sendKeys("AutomationTesting1");
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
           Thread.sleep(5000);           
           
//Language Creation           
           WebElement language = driver.findElement(By.xpath("/html/body/app-root/app-core/app-navbar/nav/div/div[2]/ul/li[3]/a"));
       	language.click();
       	Thread.sleep(2000);
       	WebElement languageCreate= driver.findElement(By.cssSelector("button[class=\"cta\"]"));
       	languageCreate.click();
       	
       	WebElement languageName= driver.findElement(By.cssSelector("input[formcontrolname=\"languageName\"]"));
       	languageName.sendKeys("AutomationTesting1");
       	Thread.sleep(2000);
       	WebElement languagecode= driver.findElement(By.cssSelector("input[formcontrolname=\"languageCode\"]"));
       	languagecode.sendKeys("ATTS1");
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
           Thread.sleep(3000);
           
           WebElement languagecreated= driver.findElement(By.xpath("/html/body/app-root/app-core/app-language-list/div/div/div[1]/h3"));
           if(languagecreated.isDisplayed()) {
           	System.out.println("Language has been successfully created.");
           }
           else {
       		System.out.println("Language is not created. Error!!!");
       	}
           
          Thread.sleep(4000);
//Genre Creation          
           WebElement genreElement = driver.findElement(By.xpath("/html/body/app-root/app-core/app-navbar/nav/div/div[2]/ul/li[4]/a"));
   		genreElement.click();
   		Thread.sleep(2000);
   		WebElement genre= driver.findElement(By.xpath("/html/body/app-root/app-core/app-genre-list/div/div/div[1]/h3"));
   if(genre.isDisplayed())
   	System.out.println("Genre Page");
   	else {
   		System.out.println("Unable to open genre page");		
   	}
   WebElement creategenreElement= driver.findElement(By.xpath("//button[@class='cta']"));
   creategenreElement.click();
   Thread.sleep(2000);
   WebElement genrenameElement = driver.findElement(By.xpath("//input[@formcontrolname='categoryName']"));
   genrenameElement.sendKeys("AutomationTesting1");
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
   	Thread.sleep(3000);
   WebElement genre1= driver.findElement(By.xpath("/html/body/app-root/app-core/app-genre-list/div/div/div[1]/h3"));

   if(genre1.isDisplayed())
   	System.out.println("Genre successfully created");
   	else {
   		System.out.println("Unable to create genre");		
   	}
   Thread.sleep(4000);
   
//Logout

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
       	Thread.sleep(3000);
        
}
        catch (Exception e) {
	e.printStackTrace();
	} finally {
		driver.quit();
	}
    }
}
    



       		
       		
  
       
    		
