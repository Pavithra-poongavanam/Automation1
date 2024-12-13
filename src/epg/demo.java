package epg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.List;
import java.util.Random;



public class demo {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        try
        {
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
            WebElement login = driver.findElement(By.xpath("/html/body/app-root/app-core/app-login/div/div[2]/div[2]/form/div[3]/button"));
            login.click();
            Thread.sleep(5000); 
            
            WebElement dashboardElement1 = driver.findElement(By.xpath("/html/body/app-root/app-core/app-channel-list/div/div/div[1]/div[1]/div[1]/h3"));
    		
    		if (dashboardElement1.isDisplayed()) {
    			System.out.println("Login successful!");
    		} else {
    			System.out.println("Login failed.");   		
    		}
       
            WebElement createchannel= driver.findElement(By.xpath("/html/body/app-root/app-core/app-channel-list/div/div/div[1]/div[2]/button"));
            createchannel.click();  
            Thread.sleep(5000);
            
                        WebElement channelNameInput = driver.findElement(By.cssSelector("body > app-root > app-core > app-create-channel > div > div.content__box > form > div > div.input_with_icon > input"));
                        channelNameInput.sendKeys("Testing");
                        Thread.sleep(2000);
                        
                        // Selecting random genre from the genre dropdown
                        WebElement genreDropdown = driver.findElement(By.xpath("/html/body/app-root/app-core/app-create-channel/div/div[1]/form/div/div[3]/div[1]/select"));
                        genreDropdown.click();
                        Thread.sleep(2000);
                        Select genreSelect = new Select(genreDropdown);
                        List<WebElement> genreOptions = genreSelect.getOptions();
                        Random rand = new Random();
                        int randomGenreIndex = rand.nextInt(genreOptions.size() - 1) + 1; 
                        genreSelect.selectByIndex(randomGenreIndex);

                        // Selecting random language from the language dropdown
                        WebElement languageDropdown = driver.findElement(By.xpath("/html/body/app-root/app-core/app-create-channel/div/div[1]/form/div/div[3]/div[2]/select"));
                        languageDropdown.click();
                        Thread.sleep(2000);
                        Select languageSelect = new Select(languageDropdown);
                        List<WebElement> languageOptions = languageSelect.getOptions();
                        int randomLanguageIndex = rand.nextInt(languageOptions.size() - 1) + 1; 
                        languageSelect.selectByIndex(randomLanguageIndex);
                        Thread.sleep(4000);
                        
                        WebElement resetButton = driver.findElement(By.xpath("/html/body/app-root/app-core/app-create-channel/div/div[1]/form/div/div[4]/div[2]/div[1]/button"));
                        resetButton.click();
                        Thread.sleep(2000);

                        // After resetting, fill out the form again and click Save
                        channelNameInput.click(); 
                        Thread.sleep(2000);
                        channelNameInput.sendKeys("Testing1");
                        Thread.sleep(2000);

                        // Randomly select a genre again
                        genreDropdown.click();
                        Thread.sleep(2000);
                        genreOptions = genreSelect.getOptions();
                        randomGenreIndex = rand.nextInt(genreOptions.size() - 1) + 1; // Skip the default "Select"
                        genreSelect.selectByIndex(randomGenreIndex);
                        Thread.sleep(2000);

                        languageDropdown.click();
                        Thread.sleep(2000);                       
                        languageOptions = languageSelect.getOptions();
                        randomLanguageIndex = rand.nextInt(languageOptions.size() - 1) + 1; // Skip the default "Select"
                        languageSelect.selectByIndex(randomLanguageIndex);
                        Thread.sleep(2000);
                        
//Uploadlogo                         
                        WebElement uploadButton = driver.findElement(By.xpath("/html/body/app-root/app-core/app-create-channel/div/div[1]/form/div/div[1]/div[2]/div/label/span"));
                        if (uploadButton.isEnabled()) {
                            // Upload a file (select a file from the local drive)
                        	//uploadButton.click();
                        	Thread.sleep(2000);
                            WebElement fileInput = driver.findElement(By.id("fileInput")); // Replace with the actual ID of the file input element
                            fileInput.sendKeys("C:\\Users\\User\\Desktop\\onnet_logo.jpg"); // Replace with the file's actual path
                          //  uploadButton.click();
                        } else {
                            System.out.println("Upload button is not enabled!");
                        }
                        
                        Thread.sleep(5000);
                        
                        
                        
                        WebElement saveButton = driver.findElement(By.xpath("/html/body/app-root/app-core/app-create-channel/div/div[1]/form/div/div[4]/div[2]/div[2]/button"));
                        saveButton.click();
                        Thread.sleep(2000);

                        WebElement confirmationMessage = driver.findElement(By.id("confirmationMessage"));
                        if (confirmationMessage.isDisplayed()) {
                            System.out.println("Channel created successfully: " + confirmationMessage.getText());
                        } else {
                            System.out.println("Failed to create channel.");
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                     //   driver.quit();
                    }
                }
            }

            
        