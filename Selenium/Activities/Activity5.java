package activities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity5 {

	public static void main(String[] args) {
		/*Open a new browser to 
		Get the title of the page and print it to the console.
		On the page, perform:
		Left click and print the value of the side in the front.
		Double click to show a random side and print the number.
		Right click and print the value shown on the front of the cube.
		Close the browser.*/
		
		//Download GeckoDriver
		 WebDriverManager.firefoxdriver().setup();
	       //initialize firefox driver
		 WebDriver driver =new FirefoxDriver();
		 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		 Actions builder = new Actions(driver);
		
		 //Open a new browser and print title
		 driver.get("https://v1.training-support.net/selenium/input-events");
		 System.out.println("The Title of the Page is : "+driver.getTitle());
		 
		 builder.click().pause(1000).build().perform();
		 //print front side value
		
		 


	}

}
