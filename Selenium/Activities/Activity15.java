package activities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity15 {

	public static void main(String[] args) {
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver =new FirefoxDriver();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(2000));
		
        //navigate to URL and print Title
		driver.get("https://v1.training-support.net/selenium/dynamic-attributes");
		System.out.println("Page Title is:"+ driver.getTitle());
		
		//Enter User name and password for signin
		
		driver.findElement(By.xpath("//input[starts-with(@class,\"username-\")]")).sendKeys("admin");
		driver.findElement(By.xpath("//input[starts-with(@class,\"password-\")]")).sendKeys("password");
		driver.findElement(By.xpath("//button[@class=\"ui button\"][@onclick=\"signIn()\"]")).click();
		System.out.println("logged in");
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("action-confirmation"), "Welcome Back, admin"));
		
		String confimationMsg=driver.findElement(By.id("action-confirmation")).getText();
		System.out.println("Confimation msg is :"+confimationMsg);
		Assert.assertEquals(confimationMsg, "Welcome Back, admin");
		driver.close();
		
	}

}
