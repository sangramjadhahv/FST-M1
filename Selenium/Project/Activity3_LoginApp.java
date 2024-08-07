package project_HRM;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Activity3_LoginApp extends BaseClass {
	
//	Open the site and login with the credentials provided
	
	@Test
	public void Login() throws InterruptedException
	{
	driver.findElement(By.id("txtUsername")).sendKeys("orange");
	driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
	driver.findElement(By.id("btnLogin")).click();
	
	wait=new WebDriverWait(driver,Duration.ofSeconds(3000));
	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("menu_dashboard_index")));
	System.out.println("Login Successfully done");
	
	System.out.println("Page Title after login: "+ driver.getTitle());
	//verify login successfully done and laneded into Dashboard page
	
	
	}
}
