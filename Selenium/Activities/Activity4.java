package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity4 {

	public static void main(String[] args) {

		//Download GeckoDriver
	 WebDriverManager.firefoxdriver().setup();
       //initialize firefox driver
	 WebDriver driver =new FirefoxDriver();
	 
	 //************Activity-4
	 
	 driver.get("https://v1.training-support.net/selenium/target-practice");
	 System.out.println("The Title of the Page is : "+driver.getTitle());
	 
	 //Find the 3rd header on the page and print it's text to the console.
	String tDElementText= driver.findElement(By.xpath("//h3[@id='third-header']")).getText();
	System.out.println("The text of Third Elemnet is :"+tDElementText);
	
	//Find the 5th header on the page and print it's color.
	String fTElementcolor= driver.findElement(By.xpath("//h5[@class='ui green header']")).getCssValue("color");
	System.out.println("Color of 5th Element is :" +fTElementcolor);
	
	//Find the violet button and print all it's classes.
	String violetbuttonclass=driver.findElement(By.xpath("//button[text()='Violet']")).getText();
	System.out.println("The Violet Button class is :"+violetbuttonclass);
	
	//Find the grey button and print it's text.
	
 String GreytbuttonText=driver.findElement(By.xpath("//button[text()='Grey']")).getText();
 	System.out.println("The text of Grey button is  :"+ GreytbuttonText);
 	
 	driver.close();
	}

}
