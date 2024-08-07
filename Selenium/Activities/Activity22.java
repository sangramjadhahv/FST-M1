package activities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity22 {

	public static void main(String[] args) throws InterruptedException {

		//Download GeckoDriver
		WebDriverManager.firefoxdriver().setup();

		//initialize firefox driver
		WebDriver driver =new FirefoxDriver();

		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5000));

		//Open a new browser and print title
		driver.get("https://v1.training-support.net/selenium/popups");
		System.out.println("The Title of the Page is : "+driver.getTitle());

		// Find the Sign in button 
		WebElement button = driver.findElement(By.className("orange"));

		// Create the Actions object
		Actions builder = new Actions(driver);
		builder.moveToElement(button).build().perform();
		//print tooltip msg
		String tooltipMsg = button.getAttribute("data-tooltip");
		System.out.println("TooltipMsg is :"+tooltipMsg);

		// Click the button and wait for the modal to appear
		button.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));

		//enter user id and password
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("password");
		driver.findElement(By.xpath("//button[@onclick='signIn()']")).click();

		Thread.sleep(5000);
		String confirmationMsg = driver.findElement(By.id("action-confirmation")).getText();
		System.out.println("Confirmation Msg is :"+confirmationMsg);


	}

}
