package epg;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.time.Duration;

public class All {
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver= new ChromeDriver();
		String downloadDir = "C:\\Users\\User\\Desktop\\down";//for download
        Scanner scanner = new Scanner(System.in);
		try {
		Thread.sleep(3000);
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
		Thread.sleep(5000);		
		WebElement dashboardElement1 = driver.findElement(By.xpath("/html/body/app-root/app-core/app-channel-list/div/div/div[1]/div[1]/div[1]/h3"));		
		if (dashboardElement1.isDisplayed()) {
			System.out.println("Login successful!");
		} else {
			System.out.println("Login failed.");		
				}
		WebElement refresh= driver.findElement(By.xpath("/html/body/app-root/app-core/app-channel-list/div/div/div[1]/div[1]/div[1]/img"));
		refresh.click();
		Thread.sleep(2000);	
//Search
	String[] searchTerms = {"HBO", "&", "7", "Zee"};
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
            Thread.sleep(2000);            
    }       
        driver.navigate().refresh();
        Thread.sleep(2000);        
//    Filter 
WebElement channel= driver.findElement(By.xpath("/html/body/app-root/app-core/app-navbar/nav/div/div[2]/ul/li[1]/a"));
 channel.click();
 Thread.sleep(2000);   		
   	WebElement filter = driver.findElement(By.xpath("/html/body/app-root/app-core/app-channel-list/div/div/div[1]/div[2]/div[2]/div/div[1]/button")); // Replace with the actual ID
   		filter.click();	   		
   		List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[type='checkbox']"));
          List<WebElement> checkboxnames = driver.findElements(By.cssSelector("span.optionstyle"));
           for (int i = 0; i < checkboxes.size(); i++) {
             WebElement checkbox = checkboxes.get(i);
             WebElement checkboxesElement = checkboxnames.get(i);
             String checkboxname = checkboxesElement.getText();
             System.out.println("Check box: " + checkboxname);
               if (!checkbox.isSelected()) {
                   checkbox.click();
                  // Thread.sleep(1000);                
               }
               if (checkbox.isSelected()) {
                   System.out.println("Checkbox for '" + checkboxname + "' successfully selected.");
               } else {
                   System.out.println("Failed to select checkbox for " + checkboxname + ".");
               }               
               if (checkbox.isSelected()) {
                   checkbox.click();
               								}
           }                  
//sort function
Thread.sleep(2000);   		
             	WebElement sort = driver.findElement(By.xpath("/html/body/app-root/app-core/app-channel-list/div/div/div[1]/div[2]/div[3]/div/div/button"));
             		sort.click();	             		
             		List<WebElement> radiobuttons = driver.findElements(By.cssSelector("input[type='radio']"));
                    List<WebElement> radiobuttonnames = driver.findElements(By.cssSelector("span.optionstyle"));
                     for (int i = 0; i < radiobuttons.size(); i++) {
                       WebElement radiobutton = radiobuttons.get(i);
                       WebElement radiobuttonElement = radiobuttonnames.get(i);
                       String radiobuttonname = radiobuttonElement.getText();
                       System.out.println("Radio Button : " + radiobuttonname);
                         if (!radiobutton.isSelected()) {
                        	 radiobutton.click();
                            // Thread.sleep(1000);                          
                         }
                         if (radiobutton.isSelected()) {
                             System.out.println("Radio button for " + radiobuttonname + " successfully selected.");
                         } else {
                             System.out.println("Failed to select radio button for " + radiobuttonname + ".");
                         }                         
                         if (radiobutton.isSelected()) {
                        	 radiobutton.click();
                         }
                     }
//Download Button
		WebElement downloadButton = driver.findElement(By.xpath("/html/body/app-root/app-core/app-channel-list/div/div/div[1]/div[2]/div[4]/a/button")); // Adjust selector
		downloadButton.click();
		Thread.sleep(2000);
		WebElement excelButton = driver.findElement(By.xpath("/html/body/app-root/app-core/app-channel-list/div/div/div[1]/div[2]/div[4]/div/ul/li[1]")); 
		excelButton.click();
		Thread.sleep(3000);
				if (verifyDownload("xlsx", 10)) {
				    System.out.println("Excel file downloaded successfully.");
				} else {
				    System.out.println("Excel file download failed.");
				}
				Thread.sleep(2000);
				downloadButton.click();
				downloadButton.click(); 
				downloadButton.click(); 
				Thread.sleep(3000);
				WebElement pdfButton = driver.findElement(By.xpath("/html/body/app-root/app-core/app-channel-list/div/div/div[1]/div[2]/div[4]/div/ul/li[2]"));
				pdfButton.click();
				Thread.sleep(3000);
				if (verifyDownload("pdf", 10)) {
				    System.out.println("PDF file downloaded successfully.");
				} else {
				    System.out.println("PDF file download failed.");
				}
				
//Rows per page
				WebElement outerElement= driver.findElement(By.xpath("/html/body/app-root/app-core/app-channel-list/div/div/div[1]"));
				outerElement.click();
				Thread.sleep(1000);
				
		WebElement rowsPerPageDropdown = driver.findElement(By.cssSelector(".item__selection .select__option select"));
		Select select = new Select(rowsPerPageDropdown);
		List<WebElement> options = select.getOptions();
		for (WebElement option : options) {
		    String optionText = option.getText().trim();  
		    System.out.println("Selecting option: " + optionText);
		    select.selectByVisibleText(optionText);
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));  
		    WebElement table = driver.findElement(By.xpath("/html/body/app-root/app-core/app-channel-list/div/div/div[2]/div[1]/table[1]/tbody"));
		    wait.until(ExpectedConditions.visibilityOf(table));
		    List<WebElement> rows = driver.findElements(By.xpath("/html/body/app-root/app-core/app-channel-list/div/div/div[2]/div[1]/table[1]/tbody/tr"));               
		    System.out.println("Number of rows displayed: " + rows.size());
		}
// Pagination
		 WebElement rowsElement= driver.findElement(By.xpath("/html/body/app-root/app-core/app-channel-list/div/div/div[2]/div[2]/div[1]/div/select"));//for 500
         rowsElement.click();
		WebElement fivehunderd= driver.findElement(By.xpath("/html/body/app-root/app-core/app-channel-list/div/div/div[2]/div[2]/div[1]/div/select/option[6]"));
		fivehunderd.click();
		Thread.sleep(2000);
            By nextButtonLocator = By.xpath("//button[img[@alt='Next']]");
            By previousButtonLocator = By.xpath("//button[img[@alt='Previous']]");
            By pageSummaryLocator = By.xpath("//span[contains(text(), 'of')]");
            boolean hasNextPage = true;
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            while (hasNextPage) {
                wait.until(ExpectedConditions.presenceOfElementLocated(pageSummaryLocator));
                WebElement pageSummary = driver.findElement(pageSummaryLocator);
                System.out.println("Current Page: " + pageSummary.getText());
                WebElement nextButton = driver.findElement(nextButtonLocator);
                if (nextButton.isEnabled()) {
                    nextButton.click();
                    Thread.sleep(2000);
                } else {
                    hasNextPage = false;
                    System.out.println("Reached the last page.");
                }
            }
            boolean hasPreviousPage = true;
            while (hasPreviousPage) {
                WebElement previousButton = driver.findElement(previousButtonLocator);
                if (previousButton.isEnabled()) {
                    previousButton.click();
                    Thread.sleep(2000);
                    WebElement pageSummary = driver.findElement(pageSummaryLocator);
                    System.out.println("Current Page Summary: " + pageSummary.getText());
                } else {
                    hasPreviousPage = false;
                    System.out.println("Reached the first page.");
                }
            }
            
//scroll horizontally and vertically                  
            rowsElement.click();
            WebElement twenty= driver.findElement(By.xpath("/html/body/app-root/app-core/app-channel-list/div/div/div[2]/div[2]/div[1]/div/select/option[3]"));
    		twenty.click(); 
    		outerElement.click();
        	JavascriptExecutor js = (JavascriptExecutor) driver;
            //    js.executeScript("document.body.style.zoom='200%'");        	
        		 WebElement scroller = driver.findElement(By.cssSelector(".table__scroller"));
                 System.out.println("Scrolling down...");
                 for (int i = 0; i <= 10; i++) 
                 { 
                     js.executeScript("arguments[0].scrollTop += arguments[0].scrollHeight / 10;", scroller);
                     Thread.sleep(500); 
                 }
                 Thread.sleep(2000);
                 System.out.println("Scrolling up...");
                 for (int i = 0; i <= 10; i++) { 
                     js.executeScript("arguments[0].scrollTop -= arguments[0].scrollHeight / 10;", scroller);
                     Thread.sleep(500); 
                 }
                 Thread.sleep(2000);
                 System.out.println("Scrolling right...");
                 for (int i = 0; i <= 10; i++) { // Adjust steps for smoother scrolling
                     js.executeScript("arguments[0].scrollLeft += arguments[0].scrollWidth / 10;", scroller);
                     Thread.sleep(500); // Pause to make the scroll visible
                 }
                 Thread.sleep(2000);
                 System.out.println("Scrolling left...");
                 for (int i = 0; i <= 10; i++) { 
                     js.executeScript("arguments[0].scrollLeft -= arguments[0].scrollWidth / 10;", scroller);
                     Thread.sleep(3000); // Pause to make the scroll visible
                 }
                 
//Create channel                 
                 WebElement createchannel= driver.findElement(By.xpath("/html/body/app-root/app-core/app-channel-list/div/div/div[1]/div[2]/button"));
                 createchannel.click();  
                 Thread.sleep(3000);                 
                             WebElement channelNameInput = driver.findElement(By.cssSelector("body > app-root > app-core > app-create-channel > div > div.content__box > form > div > div.input_with_icon > input"));
                             channelNameInput.sendKeys("Testing2");
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
                             channelNameInput.sendKeys("Testing");
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
                      
//*************************************************************
                             
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
                    		 System.out.println("Enter the group name: ");		 	
                    		 String groupString = scanner.nextLine();
                    		 groupNameField.sendKeys(groupString);
                    		 
                           //  groupNameField.sendKeys("New Group");
                             // Randomly select a radio button for services
                        		List<WebElement> serviceRadioButtons = driver.findElements(By.cssSelector("input[type='radio']"));
                        		int randomIndex = new Random().nextInt(serviceRadioButtons.size());
                        		serviceRadioButtons.get(randomIndex).click();

                             // Ask user for the group tag option
                             System.out.println("Do you want to use an existing tag or create a new one? (Enter 'Existing' or 'new'):");
                             String tagChoice = scanner.nextLine();

                            if (tagChoice.equalsIgnoreCase("Existing")) {
                                List<WebElement> existingTags = driver.findElements(By.xpath("//div[contains(@class, 'tag-item')]"));
                                System.out.println("Available tags:");
                                for (int i = 0; i < existingTags.size(); i++) {
                                    System.out.println((i + 1) + ". " + existingTags.get(i).getText());
                                }

                                System.out.println("Enter the number corresponding to the tag you want to select:");
                                int tagIndex = -1;

                                try {
                                    tagIndex = scanner.nextInt() - 1;
                                    scanner.nextLine(); // Consume newline character
                                } catch (Exception e) {
                                    System.out.println("Invalid input. Please enter a valid number.");
                                    return;
                                }

                                if (tagIndex >= 0 && tagIndex < existingTags.size()) {
                                    existingTags.get(tagIndex).click();
                                    System.out.println("Selected tag: " + existingTags.get(tagIndex).getText());
                                } else {
                                    System.out.println("Invalid selection. Please restart and choose a valid tag.");
                                    return;
                                }

                            } else if (tagChoice.equalsIgnoreCase("new")) {
                                // **New Tag Creation**
                                WebElement newTagInput = driver.findElement(By.xpath("//div[contains(@class, 'tag-item-create')]"))
                                                               .findElement(By.cssSelector("input[placeholder='create tag']"));

                                System.out.println("Enter the name for the new tag:");
                                String newTagName = scanner.nextLine();
                                newTagInput.sendKeys(newTagName);
                                Thread.sleep(2000);
                                newTagInput.sendKeys(Keys.RETURN);
                                Thread.sleep(2000);

                                System.out.println("New tag created: " + newTagName);

                          //    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
                                List<WebElement> tagList = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='tag-item']")));
                                boolean tagSelected = false;

                                for (WebElement tag : tagList) {
                                    if (tag.getText().equals(newTagName)) {
                                        tag.click();
                                        tagSelected = true;
                                        break;
                                    }
                                }

                                if (!tagSelected) {
                                    System.out.println("Tag not found.");
                                    return;
                                }

                            } else {
                                System.out.println("Invalid choice. Exiting script.");
                                return;
                            }

                            Thread.sleep(2000);

                            // Navigate to Channel Mapping Page
                            WebElement nextButton = driver.findElement(By.xpath("/html/body/app-root/app-core/app-create-edit-client/div/div/div[2]/div[2]/button"));
                            nextButton.click();
                            Thread.sleep(5000);
                    //Channel mapping
                            WebElement channelMappingElement = driver.findElement(By.xpath("/html/body/app-root/app-core/app-mapping-client/div/div/div[2]/div[1]/div[1]/p[1]"));
                            if (channelMappingElement.isDisplayed()) {
                                System.out.println("Navigated to channel mapping page");
                            } else {
                                System.out.println("Couldn't map channels");
                            }
                            // Channel Selection
                            List<WebElement> channelElements = driver.findElements(By.cssSelector(".logoflex .image-checkbox-container img"));
                            List<WebElement> checkBoxElements = driver.findElements(By.cssSelector(".logoflex .image-checkbox-container input[type='checkbox']"));

                            if (channelElements.isEmpty()) {
                                System.out.println("No channels found on the page.");
                                return;
                            }
                            System.out.println("Available Channels:");
                            for (int i = 0; i < channelElements.size(); i++) {
                                String channelName = channelElements.get(i).getAttribute("alt");
                                System.out.println((i + 1) + ". " + channelName);
                            }
                            System.out.println("Enter the numbers of the channels you want to select, separated by commas (e.g., 1,3,5):");
                            String input = scanner.nextLine();
                            String[] indices = input.split(",");
                            for (String indexStr : indices) {
                                try {
                                    int index = Integer.parseInt(indexStr.trim()) - 1;
                                    if (index >= 0 && index < checkBoxElements.size()) {
                                        WebElement checkBoxElement = checkBoxElements.get(index);
                                        if (!checkBoxElement.isSelected()) {
                                            checkBoxElement.click();
                                        }
                                        System.out.println("Selected channel: " + channelElements.get(index).getAttribute("alt"));
                                    } else {
                                        System.out.println("Invalid index: " + (index + 1));
                                    }
                                } catch (NumberFormatException e) {
                                    System.out.println("Invalid input: " + indexStr);
                                }
                            }

                            WebElement nextbuttonElement = driver.findElement(By.xpath("/html/body/app-root/app-core/app-mapping-client/div/div/div[2]/div[3]/div[2]/div[2]/button"));
                            nextbuttonElement.click();
                            Thread.sleep(2000);
                           WebElement UnicastHLSURL = driver.findElement(By.xpath("/html/body/app-root/app-core/app-create-mapping/div/div/div/div[2]/form/div[2]/div[1]/input"));
                           System.out.println("Enter the Unicast HLS URL");
                           String unicastHls = scanner.nextLine();
                           UnicastHLSURL.sendKeys(unicastHls);
                                   
                           WebElement UnicastDashURL = driver.findElement(By.xpath("/html/body/app-root/app-core/app-create-mapping/div/div/div/div[2]/form/div[2]/div[2]/input"));
                           System.out.println("Enter the Unicast Dash URL");
                           String unicastDash = scanner.nextLine();
                           UnicastDashURL.sendKeys(unicastDash);
                           
                           WebElement multicastElement= driver.findElement(By.xpath("/html/body/app-root/app-core/app-create-mapping/div/div/div/div[2]/form/div[2]/div[3]/input"));
                           System.out.println("Enter the Multicast URL");
                           String multicast = scanner.nextLine();
                           multicastElement.sendKeys(multicast);
                                   
                           WebElement channelIdElement = driver.findElement(By.xpath("/html/body/app-root/app-core/app-create-mapping/div/div/div/div[2]/form/div[2]/div[4]/input"));
                           System.out.println("Enter the Channel Id");
                           String channelId = scanner.nextLine();
                           channelIdElement.sendKeys(channelId);
                           
                           WebElement lCNElement = driver.findElement(By.xpath("/html/body/app-root/app-core/app-create-mapping/div/div/div/div[2]/form/div[2]/div[5]/input"));
                           System.out.println("Enter LCN");
                           String lcn = scanner.nextLine();
                           lCNElement.sendKeys(lcn);
                           
                           WebElement billingstatusElement= driver.findElement(By.xpath("/html/body/app-root/app-core/app-create-mapping/div/div/div/div[2]/form/div[2]/div[7]/select"));
                           billingstatusElement.click();
                           
                     select = new Select(billingstatusElement);
                           String userInput = "";
                           
                           while (true) {
                               System.out.println("Please enter the billing status you want to select (FTA/Pay):");
                               userInput = scanner.nextLine().trim().toUpperCase();

                               if (userInput.equals("FTA") || userInput.equals("PAY")) {
                                   select.selectByVisibleText(userInput);
                                   System.out.println("Selected the option: " + userInput);
                                       if (userInput.equals("PAY")) {
                                       	
                                       String priceInput = "";
                                       while (true) {
                                       //	WebElement pricElement= driver.findElement(By.xpath("/html/body/app-root/app-core/app-create-mapping/div/div/div/div[2]/form/div[2]/div[8]/input"));
                                       	
                                           System.out.println("Please enter the price(numeric value only):");
                                           priceInput = scanner.nextLine().trim();
                                           
                                           if (priceInput.matches("\\d+(\\.\\d{1,2})?")) { // Check for a valid numeric input with up to 2 decimal places
                                               System.out.println("Price entered: " + priceInput);
                                               Thread.sleep(2000);
                                               break;
                                           } else {
                                               System.out.println("Invalid price. Please enter a valid numeric value.");
                                           }
                                           WebElement pricElement= driver.findElement(By.xpath("/html/body/app-root/app-core/app-create-mapping/div/div/div/div[2]/form/div[2]/div[8]/input"));
                                           pricElement.sendKeys(priceInput);
                                       }
                                   }
                                   break;
                                   
                               } else {
                                   System.out.println("Invalid input. Please enter either 'FTA' or 'Pay'.");
                               }
                           }
                          	

                           WebElement saveElement= driver.findElement(By.xpath("/html/body/app-root/app-core/app-create-mapping/div/div/div/div[3]/div/div[3]/button"));
                           saveElement.click();   
                           Thread.sleep(5000);
                           WebElement mappedchannelpage = driver.findElement(By.xpath("/html/body/app-root/app-core/app-client-details/div/div[2]/div/div/div/div[1]/div[1]/div[1]/h3"));
                           if (mappedchannelpage.isDisplayed()) {
                    			System.out.println("Channels are mapped successfully");
                    		} else {
                    			System.out.println("Couldn't map");			
                    		}                             
		} catch (Exception e) {
			e.printStackTrace();
			} finally {
			//driver.quit();
			}
}

public static boolean verifyDownload(String extension, int timeout) {
String home = System.getProperty("user.home");
String downloadDir = home + "/Downloads"; // Default downloads directory

File folder = new File(downloadDir);
long endTime = System.currentTimeMillis() + (timeout * 1000);

while (System.currentTimeMillis() < endTime) {
File[] files = folder.listFiles((dir, name) -> name.toLowerCase().endsWith("." + extension));
if (files != null && files.length > 0) {
    return true; 
}
try {
Thread.sleep(500); 
} catch (InterruptedException e) {
Thread.currentThread().interrupt();
}
}
return false; // Timeout reached file not found
}
}


					