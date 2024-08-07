package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity12 {

	public static void main(String[] args) throws Exception {

		WebDriverManager.firefoxdriver().setup();
		WebDriver driver =new FirefoxDriver();

		driver.get("https://v1.training-support.net/selenium/dynamic-controls");
		System.out.println("Page Title is:"+ driver.getTitle());
		
		WebElement inputTxtField =driver.findElement(By.id("input-text"));

		System.out.println("Is input field enabled ? "+inputTxtField.isEnabled());

		Thread.sleep(5000);

		driver.findElement(By.id("toggleInput")).click();

		System.out.println("Is input field enabled after enable button click ? "+inputTxtField.isEnabled());

        driver.close();

	}

}
