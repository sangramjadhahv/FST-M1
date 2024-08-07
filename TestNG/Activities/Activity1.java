package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity1 {

	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		driver.get("https://v1.training-support.net");

	}

	@Test
	public void pagedetails()
	{
		String PageTitle=driver.getTitle();
		System.out.println("Page Title is :" +PageTitle );
		Assert.assertEquals(PageTitle, "Training Support");

		driver.findElement(By.id("about-link")).click();
		String pageTitleAbout=driver.getTitle();
		System.out.println("New Page Title is :" + pageTitleAbout );
		Assert.assertEquals(pageTitleAbout , "About Training Support");

	}
	@AfterClass
	public void tearDown()
	{
		driver.close();
	}

}
