package activities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity17 {
	
	public static void main(String[] args) {
			//Download GeckoDriver
		 WebDriverManager.firefoxdriver().setup();
	       //initialize firefox driver
		 WebDriver driver =new FirefoxDriver();
		//Open a new browser and print title
		 driver.get("https://v1.training-support.net/selenium/selects");
		 System.out.println("The Title of the Page is : "+driver.getTitle());
		 
	
		 // Find the dropdown
		 WebElement dropdownfield =driver.findElement(By.id("single-select"));
		 
	//** Select the second option using the visible text.
		 // Pass the WebElement to the Select object
		 Select singleSelect = new Select(dropdownfield);
		 
		 singleSelect.selectByVisibleText("Option 2");
		 System.out.println("Selected 2nd value from dropdown is:"+ singleSelect.getFirstSelectedOption().getText());
		 
	//***Select the third option using the index.
		 singleSelect.selectByIndex(3);
		 System.out.println("Selected 3rd value from dropdown is:"+ singleSelect.getFirstSelectedOption().getText());
		 
	//***Select the fourth option using the value.
		 singleSelect.selectByValue("4");
		 System.out.println("Selected 4th value from dropdown is:"+ singleSelect.getFirstSelectedOption().getText());
		 
	//***	Get all the options and print them to the console.
		 System.out.println("List of dropdown values are : ");
		 List<WebElement> listEl=singleSelect.getOptions();
		 for(WebElement options : listEl)
		 {
			 System.out.println(options.getText());
		 }
		 
		 
	}
}
