package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity1 {

	public static void main(String[] args) {
		//Download GeckoDriver
	WebDriverManager.firefoxdriver().setup();

		//initialize firefox driver
		 WebDriver driver =new FirefoxDriver();
		 
		 //open the browser
		 driver.get("https://v1.training-support.net");
		 
		 //Verify the page title
		 System.out.println("Page Title is :"+driver.getTitle());
		 
		 //Find the "About Us" button on the page using it's id and click
		driver.findElement(By.id("about-link")).click();
		
		//Print new page title
		 System.out.println("New Page Title is :"+driver.getTitle());
		 
		 //Close the browser
	      driver.close();


	}

}
