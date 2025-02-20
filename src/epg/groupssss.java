package epg;
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
import org.yaml.snakeyaml.scanner.Scanner;


public class groupssss {

	public static void main(String[] args) throws InterruptedException {
		 WebDriver driver = new ChromeDriver();
         Scanner scanner = new Scanner(System.in);

		try {
		// TODO Auto-generated method stub
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

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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

       Select select = new Select(billingstatusElement);
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
                   	WebElement pricElement= driver.findElement(By.xpath("/html/body/app-root/app-core/app-create-mapping/div/div/div/div[2]/form/div[2]/div[8]/input"));

                       System.out.println("Please enter the price(numeric value only):");
                       pricElement.sendKeys(priceInput);
                       priceInput = scanner.nextLine().trim();

                       if (priceInput.matches("\\d+(\\.\\d{1,2})?")) { // Check for a valid numeric input with up to 2 decimal places
                           System.out.println("Price entered: " + priceInput);
                           break;
                       } else {
                           System.out.println("Invalid price. Please enter a valid numeric value.");
                       }
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
      //  driver.quit();
    }
}
}