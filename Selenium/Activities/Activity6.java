package activities;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity6 {
	
	
	public static void main(String[] args)
	{
      //Download GeckoDriver
	 WebDriverManager.firefoxdriver().setup();
      //initialize firefox driver
	 WebDriver driver =new FirefoxDriver();
	 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	 driver.get("https://v1.training-support.net/selenium/input-events");
	 System.out.println("Title of the Page :" + driver.getTitle());
	
	 Actions builder=new Actions(driver);
	 
	 builder.sendKeys("A").build().perform();
	
	 builder.keyDown(Keys.CONTROL).sendKeys("a").sendKeys("c").keyUp(Keys.CONTROL).build().perform();
	

}
}
