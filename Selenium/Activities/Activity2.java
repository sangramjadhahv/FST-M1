package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity2 {
	
	public static void main(String[] args) {
		//Download GeckoDriver
	WebDriverManager.firefoxdriver().setup();

		//initialize firefox driver
		 WebDriver driver =new FirefoxDriver();
		 
		 //open the browser
		 driver.get("https://v1.training-support.net/selenium/login-form");
		 
		 //Verify the page title
		 System.out.println("Page Title is :"+driver.getTitle());
		 
		 //Find the username field using any locator and enter "admin" into it.
		 //Find the password field using any locator and enter "password" into it.
		 driver.findElement(By.id("username")).sendKeys("admin");
		 driver.findElement(By.id("password")).sendKeys("password");
		 
		//Print new page title
		 System.out.println("New Page Title is :"+driver.getTitle());
		 //Find the "Log in" button using any locator and click it.
		 driver.findElement(By.cssSelector("button[onclick='signIn()']")).click();
		 //Close the browser
	     // driver.close();


	
		
	}
}
