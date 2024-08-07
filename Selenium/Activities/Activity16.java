package activities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity16 {

	public static void main(String[] args) {
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver =new FirefoxDriver();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(2000));
		
        //navigate to URL and print Title
		driver.get("https://v1.training-support.net/selenium/dynamic-attributes");
		System.out.println("Page Title is:"+ driver.getTitle());
		
		//Enter User name and password for signin
		
		driver.findElement(By.xpath("//input[contains(@class,\"-username\")]")).sendKeys("admin2");
		driver.findElement(By.xpath("//input[contains(@class,\"-password\")]")).sendKeys("password");
		driver.findElement(By.xpath("//label[text()='Confirm Password']/following-sibling::input")).sendKeys("password");
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("qwerty@abs");
		driver.findElement(By.xpath("//button[@onclick='signUp()']")).click();
		System.out.println("sign up done");
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("action-confirmation")));
		
		String confimationMsg=driver.findElement(By.id("action-confirmation")).getText();
		System.out.println("Confimation msg is :"+confimationMsg);
		
		driver.close();

	}

}
