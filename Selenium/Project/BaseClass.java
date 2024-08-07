package project_HRM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	static WebDriver driver;
	static WebDriverWait wait;
	

@BeforeTest
public void launchBrowser() throws InterruptedException
{
	WebDriverManager.firefoxdriver().setup();
	driver = new FirefoxDriver();
	driver.get("http://alchemy.hguy.co/orangehrm");
	Thread.sleep(3000);
}


}