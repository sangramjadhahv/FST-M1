package activities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity20 {

	public static void main(String[] args) throws InterruptedException {
		//Download GeckoDriver
		 WebDriverManager.firefoxdriver().setup();
	       //initialize firefox driver
		 WebDriver driver =new FirefoxDriver();
		//Open a new browser and print title
		 driver.get("https://v1.training-support.net/selenium/javascript-alerts");
		 System.out.println("The Title of the Page is : "+driver.getTitle());
		 driver.findElement(By.id("prompt")).click();
		    Alert promtAlert = driver.switchTo().alert();
		 Thread.sleep(5000);
		 promtAlert.sendKeys("Prompt Alert check");
		 Thread.sleep(5000);
		 promtAlert.accept();
	}

}
