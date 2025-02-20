package epg;
import java.io.File;
import java.util.List;
import java.util.Random;

import org.bouncycastle.oer.its.ieee1609dot2.basetypes.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class channels {
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver= new ChromeDriver();
		String downloadDir = "C:\\Users\\User\\Desktop\\down";//for download

		try {
		Thread.sleep(3000);
		driver.get("http://103.255.144.131:8600/login");
		driver.manage().window().maximize();
		WebElement email = driver.findElement(By.xpath("/html/body/app-root/app-core/app-login/div/div[2]/div[2]/form/div[1]/input"));//search mail textbox
		email.sendKeys("onnet@gmail.com");
		Thread.sleep(1000);
		WebElement password= driver.findElement(By.xpath("/html/body/app-root/app-core/app-login/div/div[2]/div[2]/form/div[2]/input"));//search password field
		password.sendKeys("onnet@1234");
		Thread.sleep(1000);
		WebElement eyebuttonElement = driver.findElement(By.xpath("//Img[@alt='Show Password']"));
		eyebuttonElement.click();
		Thread.sleep(2000);

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
                   Thread.sleep(1000);
               }
               if (checkbox.isSelected()) {
                   System.out.println("Checkbox for '" + checkboxname + "' successfully selected.");
               } else {
                   System.out.println("Failed to select checkbox for " + checkboxname + ".");
               }
               if (checkbox.isSelected()) {
                   checkbox.click();
               }
               System.out.println("Checkboxes are working fine");
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
                             Thread.sleep(1000);
                         }
                         if (radiobutton.isSelected()) {
                             System.out.println("Radio button for " + radiobuttonname + " successfully selected.");
                         } else {
                             System.out.println("Failed to select radio button for " + radiobuttonname + ".");
                         }
                         if (radiobutton.isSelected()) {
                        	 radiobutton.click();
                         }
                         System.out.println("Radio buttons are working fine");
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
		    Thread.sleep(2000);
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		    WebElement table = driver.findElement(By.xpath("/html/body/app-root/app-core/app-channel-list/div/div/div[2]/div[1]/table[1]/tbody"));
		    wait.until(ExpectedConditions.visibilityOf(table));
		    List<WebElement> rows = driver.findElements(By.xpath("/html/body/app-root/app-core/app-channel-list/div/div/div[2]/div[1]/table[1]/tbody/tr"));
		    System.out.println("Number of rows displayed: " + rows.size());
		}
// Pagination
		 WebElement rowsElement= driver.findElement(By.xpath("/html/body/app-root/app-core/app-channel-list/div/div/div[2]/div[2]/div[1]/div/select"));
         rowsElement.click();
         Thread.sleep(2000);
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
/*
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
 */
//Create channel

                 WebElement createchannel= driver.findElement(By.xpath("/html/body/app-root/app-core/app-channel-list/div/div/div[1]/div[2]/button"));
                 createchannel.click();
                 System.out.println("Channel Creation page");
                 Thread.sleep(3000);

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
                             String selectedGenreOptionText = genreOptions.get(randomGenreIndex).getText();
                             System.out.println("Genre Selected is: " + selectedGenreOptionText);

                             // Selecting random language from the language dropdown
                             WebElement languageDropdown = driver.findElement(By.xpath("/html/body/app-root/app-core/app-create-channel/div/div[1]/form/div/div[3]/div[2]/select"));
                             languageDropdown.click();
                             Thread.sleep(2000);
                             Select languageSelect = new Select(languageDropdown);
                             List<WebElement> languageOptions = languageSelect.getOptions();
                             int randomLanguageIndex = rand.nextInt(languageOptions.size() - 1) + 1;
                             languageSelect.selectByIndex(randomLanguageIndex);
                             String selectedlanguageOptionText = languageOptions.get(randomLanguageIndex).getText();
                             System.out.println("Language Selected  is: " + selectedlanguageOptionText);
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

     //Uploadlogo
                             WebElement uploadButton = driver.findElement(By.xpath("/html/body/app-root/app-core/app-create-channel/div/div[1]/form/div/div[1]/div[2]/div/label/span"));
                             if (uploadButton.isEnabled()) {
                                 // Upload a file (select a file from the local drive)
                             	//uploadButton.click();
                             	Thread.sleep(2000);
                                 WebElement fileInput = driver.findElement(By.id("fileInput"));
                                 fileInput.sendKeys("C:\\Users\\User\\Desktop\\onnet_logo.jpg");
                               //  uploadButton.click();
                             } else {
                                 System.out.println("Upload button is not enabled!");
                             }

                             Thread.sleep(5000);

                      WebElement saveButton = driver.findElement(By.xpath("/html/body/app-root/app-core/app-create-channel/div/div[1]/form/div/div[4]/div[2]/div[2]/button"));
                             saveButton.click();
                             Thread.sleep(2000);
                      WebElement channelsCreationpage= driver.findElement(By.xpath("/html/body/app-root/app-core/app-create-channel/div/div[1]/div/h3"));
                         if(channelsCreationpage.isDisplayed())
                             {
                             	System.out.println("Error!!! Channel is not created !!!");

                             }
                             else {
                 				System.out.println("Channel Created Successfully");
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

