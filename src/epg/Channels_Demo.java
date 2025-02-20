package epg;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
public class Channels_Demo {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
try{

        {
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

    		//Refresh
    		WebElement refresh= driver.findElement(By.xpath("/html/body/app-root/app-core/app-channel-list/div/div/div[1]/div[1]/div[1]/img"));
    		refresh.click();
    	//	Thread.sleep(1000);
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
            channelNameInput.sendKeys("Automation Testing Demo3");
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

            Thread.sleep(200);

        /*    WebElement resetButton = driver.findElement(By.xpath("/html/body/app-root/app-core/app-create-channel/div/div[1]/form/div/div[4]/div[2]/div[1]/button"));
            resetButton.click();
            Thread.sleep(2000);

            // After resetting, fill out the form again and click Save
            channelNameInput.click();
            Thread.sleep(2000);
            channelNameInput.sendKeys("Automation Testing");
            Thread.sleep(2000);

            // Randomly select a genre again
            genreDropdown.click();
            Thread.sleep(2000);
            genreOptions = genreSelect.getOptions();
            randomGenreIndex = rand.nextInt(genreOptions.size() - 1) + 1; // Skip the default "Select"
            genreSelect.selectByIndex(randomGenreIndex);
            String selectedGenreOption1Text = genreOptions.get(randomGenreIndex).getText();
            System.out.println("Genre Selected is: " + selectedGenreOption1Text);

            Thread.sleep(2000);

            languageDropdown.click();
            Thread.sleep(2000);
            languageOptions = languageSelect.getOptions();
            randomLanguageIndex = rand.nextInt(languageOptions.size() - 1) + 1; // Skip the default "Select"
            languageSelect.selectByIndex(randomLanguageIndex);
            String selectedlanguage1OptionText = languageOptions.get(randomLanguageIndex).getText();
            System.out.println("Language Selected is: " + selectedlanguage1OptionText);
            Thread.sleep(2000);
     */
//Uploadlogo


     WebElement saveButton = driver.findElement(By.xpath("/html/body/app-root/app-core/app-create-channel/div/div[1]/form/div/div[4]/div[2]/div[2]/button"));
            saveButton.click();
            Thread.sleep(200);
            WebElement channelsCreationpage= driver.findElement(By.xpath("/html/body/app-root/app-core/app-create-channel/div/div[1]/div/h3"));
            if(channelsCreationpage.isDisplayed())
            {
            	System.out.println("Error!!! Channel is not created !!!");

            }
            else {
				System.out.println("Channel Created Successfully");

			}
            System.out.println(driver.switchTo().alert().getText());
	}
}
        catch (Exception e) {
	e.printStackTrace();
	} finally {
	//driver.quit();
	}
    }
}









