package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity10 {
	
	public static void main(String[] args) throws InterruptedException 
	{
		
		WebDriverManager.firefoxdriver().setup();
        WebDriver driver =new FirefoxDriver();
        
        driver.get("https://v1.training-support.net/selenium/dynamic-controls");
		 System.out.println("Page Title is : "+ driver.getTitle());
		 //CHeck if checkbox is displaying or not
		 boolean checkbox1 =driver.findElement(By.xpath("//input[@class='willDisappear']")).isDisplayed();
		 System.out.println("Is CheckBox enabled before click on  Remove button 1st time ? "+checkbox1);
		 
		 driver.findElement(By.xpath("//input[@class='willDisappear']")).click();
		 
		 //click on remove checkbox button
		 driver.findElement(By.id("toggleCheckbox")).click();
		 ///CHeck if checkbox is displaying or not
		 boolean checkbox2 =driver.findElement(By.xpath("//input[@class='willDisappear']")).isDisplayed();
		 System.out.println("Is CheckBox enabled before click on  After button 2nd time? "+checkbox2);
		 //
		 //click on button again
		 driver.findElement(By.id("toggleCheckbox")).click();
		 //
		 boolean checkbox3=driver.findElement(By.xpath("//input[@class='willDisappear']")).isDisplayed();
		 System.out.println("Is CheckBox enabled before click on  After button 3rd time ? "+checkbox3);
		 
		boolean checkboxselected= driver.findElement(By.xpath("//input[@class='willDisappear']")).isSelected();
		System.out.println("is checkbox selected?"+checkboxselected);
		 
		Thread.sleep(10000);
		 driver.close();
	}
	

}
