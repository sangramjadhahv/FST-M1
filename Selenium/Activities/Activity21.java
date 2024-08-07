package activities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity21 {

	public static void main(String[] args) {
		
		
		// TODO Auto-generated method stub
		//Download GeckoDriver
		 WebDriverManager.firefoxdriver().setup();
	       //initialize firefox driver
		 WebDriver driver =new FirefoxDriver();
		//Open a new browser and print title
		 
		 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		 driver.get("https://v1.training-support.net/selenium/tab-opener");
		 System.out.println("The Title of the Page is : "+driver.getTitle());
		 
		/* 
			 Find the button to open a new tab and click it.
			 Wait for the new tab to open.
			 Print all the handles.
			 Switch to the newly opened tab, print it's title and heading.
			 Repeat the steps by clicking the button in the new tab page.
			 Close the browser.*/
		 
		 driver.findElement(By.id("launcher")).click();
		 wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		 System.out.println("1st Window title is :"+driver.getTitle());
	     System.out.println("1st Current tab: " + driver.getWindowHandle());
		 
		 // focus switch
		 for(String handle:driver.getWindowHandles())
		 {
			 driver.switchTo().window(handle);
		 }
		 //
		 wait.until(ExpectedConditions.elementToBeClickable(By.id("actionButton")));
		 driver.findElement(By.id("actionButton")).click();
		 System.out.println("2nd Window title is :"+driver.getTitle());
		 
		   // Print the handle of the current tab
	        System.out.println("2nd Current tab: " + driver.getWindowHandle());
	        
	        String pageHeading = driver.findElement(By.className("content")).getText();
	        System.out.println("Page Heading: " + pageHeading);
	        // Find and click the button on page to open another tab
	        driver.findElement(By.id("actionButton")).click();

	        // Wait for new tab to open
	        wait.until(ExpectedConditions.numberOfWindowsToBe(3));
	        // Switch focus
	        for(String handle : driver.getWindowHandles()) {
	            driver.switchTo().window(handle);
	        }
	}

}
