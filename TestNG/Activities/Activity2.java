package activities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity2 {

	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		driver.get("https://v1.training-support.net/selenium/target-practice");
	}
	@Test
	public void test1()
	{
		String Expected_Title="Target Practice";
		String Act_Title=driver.getTitle();
		System.out.println(Act_Title);
		Assert.assertEquals(Act_Title,Expected_Title);	
	}

	@Test
	public void test2()
	{
		// This Test is intended to be failed
		WebElement blckButton=driver.findElement(By.cssSelector("button.black"));
		Assert.assertTrue(blckButton.isDisplayed());
		Assert.assertEquals(blckButton.getText(),"black");
	}

	@Test(enabled=false)
	public void test3()
	{
		System.out.println("This test method should be skipped");	
	}

	@Test
	public void test4()
	{
		throw new SkipException("This test method should be skipped by SkipException ");
	}

	@AfterClass
	public void tearDown()
	{
		driver.close();
	}


}