package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity3 {

	public static void main(String[] args) {
	
		//Download GeckoDriver
	 WebDriverManager.firefoxdriver().setup();
       //initialize firefox driver
	 WebDriver driver =new FirefoxDriver();
	 
		//*******************Activity-1 using xpath*******************
			 //open the browser
	 driver.get("https://v1.training-support.net");
		 //Get the title of the page and print it to the console.
	 System.out.println("Page title is :" + driver.getTitle());
	 
		//Find the "About Us" button on the page using it's id.
	 driver.findElement(By.xpath("//a[@id='about-link']")).click();
		
		//Get the title of the new page and print it to the console.
	 System.out.println("New Page Title is :" + driver.getTitle());
	 
	//*******************Activity-2 using xpath*******************
	 //open the browser
	 driver.get("https://v1.training-support.net/selenium/login-form");
	 
	 //Verify the page title
	 System.out.println("Page Title is :"+driver.getTitle());
	 
	 driver.findElement(By.xpath("//input[@id='username']")).sendKeys("admin");
	 
	 driver.findElement(By.xpath("//input[@id='password']")).sendKeys("password");
	 
	//Print new page title
	 System.out.println("New Page Title is :"+driver.getTitle());
	 //Find the "Log in" button using any locator and click it.
	 driver.findElement(By.xpath("//button[@onclick='signIn()']")).click();
	 //Close the browser
     // driver.close();
	 
	}	
}


