package activities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity18 {

	public static void main(String[] args) {
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
		
		driver.get("https://v1.training-support.net/selenium/selects");
		System.out.println("The title of the page is :"+driver.getTitle());
		
		WebElement dropdownSelect=driver.findElement(By.id("multi-select"));
		Select multiSelect=new Select(dropdownSelect);
		//Select the "JavaScript" option using the visible text.
		multiSelect.selectByVisibleText("Javascript");
		System.out.println("Value selected by text is :"+multiSelect.getFirstSelectedOption().getText());
		
		//Select the 4th, 5th and 6th options using the index.
		for(int i=4 ;i<=6;i++)
		{
			multiSelect.selectByIndex(i);
			System.out.println("Value selected by index is :"+multiSelect.getFirstSelectedOption().getText());
		}
		
		//Select the "NodeJS" option using the value.
		multiSelect.selectByValue("node");
	
		//print all selected options
		System.out.println("******All selected options are*******");
		List<WebElement> allOptions=multiSelect.getAllSelectedOptions();
		for(WebElement allSelectedOption: allOptions)
		{
			System.out.println(allSelectedOption.getText());
		}	
		
		//Deselect the 5th option using index.
		multiSelect.deselectByIndex(5);
		
		System.out.println("********Final List after Deselect******");
		// print all values after deselect
		List<WebElement> finalSelectedOptions=multiSelect.getAllSelectedOptions();
		for(WebElement finalList:finalSelectedOptions)
		{
			System.out.println(finalList.getText());
		}

	}

}
