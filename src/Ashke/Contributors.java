package Ashke;


import java.util.List;
import java.util.Random;

import org.bouncycastle.oer.its.ieee1609dot2.basetypes.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Contributors {

	WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	long starttime;
    JavascriptExecutor jsExecutor;


@BeforeSuite

	public void starttime()
	{
		 starttime= System.currentTimeMillis();
	}

    @Test(priority = 0)
    public void SetUp() throws InterruptedException {

        driver.get("http://103.81.157.84:8900/auth/login");
         driver.manage().window().maximize();
         Thread.sleep(2000);
     }

    @Test(priority = 1)
    public void TestValidLogin() throws InterruptedException {
        WebElement emailfield = driver.findElement(By.id("login-email"));
        WebElement passwordField = driver.findElement(By.id("login-password"));
        WebElement loginButton = driver.findElement(By.xpath("/html/body/app-root/app-core/div[2]/div/app-login/div/div/div[2]/div/div/div[2]/form/div[4]/button"));
        emailfield.sendKeys("skypro@gmail.com");
        passwordField.sendKeys("@skypro123!#");
        Thread.sleep(2000);

        loginButton.click();
        Thread.sleep(4000);
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "http://103.81.157.84:8900/content/dashboard", "User did not navigate to the homepage.");
    }

	@Test(priority = 2)
	public void ContributorsNavigation() throws InterruptedException
	{
		WebElement contributors = driver.findElement(By.xpath("/html/body/app-root/app-core/div[2]/app-sidenav/mat-sidenav-container/mat-sidenav-content/div[1]/ul/li[9]/h2"));
		contributors.click();
		Thread.sleep(2000);


	}

	@Test(priority = 3)
	public void Search() throws InterruptedException
	{
		String[] searchTerms = {"Kriti", "Rajinikanth"};
	        for (String searchTerm : searchTerms) {
	            System.out.println("Performing search for: " + searchTerm);
	                        WebElement searchInput = driver.findElement(By.xpath("/html/body/app-root/app-core/div[2]/div/app-contributer-list/div/div/div[1]/app-onnet-search-bar/div/input"));
	                        searchInput.click();
	            searchInput.clear();
	            searchInput.sendKeys(searchTerm + Keys.RETURN);
	    }
	        driver.navigate().refresh();
	        Thread.sleep(2000);
}
	@Test(priority = 4)
	public void Filter() throws InterruptedException
	{
 	WebElement filter = driver.findElement(By.xpath("/html/body/app-root/app-core/div[2]/div/app-contributer-list/div/div/div[1]/div/div/div/div/button/span[1]"));
 		filter.click();
         WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mat-select-0-panel")));
         List<WebElement> options = dropdown.findElements(By.cssSelector("mat-option"));
         for (WebElement option : options) {
             option.click();
             String isSelected = option.getAttribute("aria-selected");

             if ("true".equals(isSelected)) {
                 System.out.println(option.getText() + " is selected.");
             } else {
                 System.out.println("Error: " + option.getText() + " is deselected.");
             }

             option.click();
             isSelected = option.getAttribute("aria-selected");

             if ("false".equals(isSelected)) {
                 System.out.println(option.getText() + " is deselected correctly.");
             } else {
                 System.out.println("Error: " + option.getText() + " is not deselected correctly.");
             }

         }
         WebElement outside = driver.findElement(By.xpath("/html/body/div[2]/div[1]"));
         outside.click();
                    }


	@Test(priority = 5)
	public void AddContributors() throws InterruptedException
	{
		WebElement addcontributors = driver.findElement(By.xpath("/html/body/app-root/app-core/div[2]/div/app-contributer-list/div/mat-toolbar/div/button/span[1]"));
		addcontributors.click();
		Thread.sleep(2000);
		WebElement name = driver.findElement(By.id("maintitle"));
		name.sendKeys("Testing");
		WebElement typedropdown = driver.findElement(By.xpath("/html/body/app-root/app-core/div[2]/div/app-contributer-add-edit/div/form/div/div/div/div[2]/div/div/select"));
		typedropdown.click();
		Thread.sleep(2000);
	      Select typeSelect = new Select(typedropdown);
	      List<WebElement> typeoption = typeSelect.getOptions();
	      Random rand = new Random();
	      int randomtypeIndex = rand.nextInt(typeoption.size() - 1) + 1;
	      typeSelect.selectByIndex(randomtypeIndex);
	      String selectedtypeOptionText = typeoption.get(randomtypeIndex).getText();
	      System.out.println("Type Selected is: " + selectedtypeOptionText);

	      WebElement outside = driver.findElement(By.xpath("/html/body/app-root/app-core/div[2]/div/app-contributer-add-edit/div/form/div/div/div/div[2]"));
	      outside.click();

	      WebElement image = driver.findElement(By.xpath("/html/body/app-root/app-core/div[2]/div/app-contributer-add-edit/div/form/div/div/div/div[3]/div/app-onnet-image-upload/div/div/input"));
	    	if (image.isEnabled()) {
	    		Thread.sleep(2000);
	      WebElement fileInput = driver.findElement(By.cssSelector("input[type='file']"));
  	    fileInput.sendKeys("C:\\Users\\User\\Desktop\\onnet_logo.jpg");
  	    System.out.println("Image uploaded successfully");
	    	}
	    	else {
				System.out.println("Image is not uploaded");
			}
	    	WebElement nocrop = driver.findElement(By.xpath("//*[@id=\"mat-dialog-0\"]/app-image-cropper-dialog/div/div[2]/button[2]/span[1]"));
	    	nocrop.click();
	    	Thread.sleep(2000);


	    	String nameValue = name.getAttribute("value").trim();
            String typeValue = typedropdown.getAttribute("value").trim();
	    	 if (nameValue.isEmpty()) {
	                System.out.println("Error: Name field is empty!");
	            }



	            if (typeValue.isEmpty()) {
	                System.out.println("Error: Type field is empty!");
	            }

	            System.out.println("Validation passed: Name and Type fields are filled.");

	    	WebElement save = driver.findElement(By.xpath("/html/body/app-root/app-core/div[2]/div/app-contributer-add-edit/div/form/footer/div/button[2]/span[1]"));
	    	save.click();
	    	WebElement successmessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("simple-snack-bar.mat-simple-snackbar")));
			        WebElement confirmationMessage = successmessage.findElement(By.cssSelector("span"));
			        String confirmmessage= confirmationMessage.getText();
			        System.out.println(confirmmessage);
			        Thread.sleep(2000);


	}


}

