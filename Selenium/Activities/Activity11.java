package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity11 {
	public static void main(String[] args) throws InterruptedException 
	{

		WebDriverManager.firefoxdriver().setup();
		WebDriver driver =new FirefoxDriver();

		driver.get("https://v1.training-support.net/selenium/dynamic-controls");
		System.out.println("Page Title is:"+ driver.getTitle());

		WebElement checkboxField =driver.findElement(By.xpath("//input[@class='willDisappear']"));
		System.out.println("Is CheckBox selected ? "+checkboxField.isSelected());

		driver.findElement(By.xpath("//input[@class='willDisappear']")).click();

		System.out.println("Is CheckBox selected after field checked ? "+checkboxField.isSelected());

		driver.close();
	}
}
