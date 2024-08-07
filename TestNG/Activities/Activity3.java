package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity3 {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		driver.get("https://v1.training-support.net/selenium/login-form");	
	}
	@Test
	public void loginTest()
	{
		System.out.println("Page Title is :"+driver.getTitle());
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("password");
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
		String Header=driver.findElement(By.id("action-confirmation")).getText();
		Assert.assertEquals(Header,"Welcome Back, admin");
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.close();
	}
}
