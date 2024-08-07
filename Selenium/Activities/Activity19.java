package activities;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity19 {
	public static void main(String[] args) {
		//Download GeckoDriver
	 WebDriverManager.firefoxdriver().setup();
       //initialize firefox driver
	 WebDriver driver =new FirefoxDriver();
	//Open a new browser and print title
	 driver.get("https://v1.training-support.net/selenium/javascript-alerts");
	 System.out.println("The Title of the Page is : "+driver.getTitle());
	 
	 //Find the button to open a CONFIRM alert and click it.
	 driver.findElement(By.id("confirm")).click();
	 
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10000));
	// Switch focus to the alert
     Alert confirmAlert = driver.switchTo().alert();
     String textAlert = confirmAlert.getText();
     System.out.println("Alert Text is :" +textAlert);
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10000));
   
	 
     //Close the alert by clicking OK
     confirmAlert.accept();
     //confirmAlert.dismiss();

     driver.close();
}
}