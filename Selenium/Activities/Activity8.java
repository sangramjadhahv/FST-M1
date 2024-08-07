package activities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity8 {

	public static void main(String[] args) {

		//Download GeckoDriver
		WebDriverManager.firefoxdriver().setup();

		//initialize firefox driver
		WebDriver driver =new FirefoxDriver();

		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5000));

		//Open a new browser and print title
		driver.get("https://v1.training-support.net/selenium/dynamic-controls");
		System.out.println("The Title of the Page is : "+driver.getTitle());
		
		//click on Remove Checkbox button
		driver.findElement(By.id("toggleCheckbox")).click();
		
		// get the handle of checkbox field and check wheather field is visible or not
		WebElement checkboxfield=driver.findElement(By.id("dynamicCheckbox"));
		wait.until(ExpectedConditions.invisibilityOf(checkboxfield));
		System.out.println("Is checkbox field displayed? :"+checkboxfield.isDisplayed());
		
		//click the Add checkbox button
		driver.findElement(By.id("toggleCheckbox")).click();
		
		//wait for checkboxfield to be visible
		wait.until(ExpectedConditions.visibilityOf(checkboxfield));
		System.out.println("Is checkbox field displayed after Addcheckbox ? :"+checkboxfield.isDisplayed());
		
	}

}
