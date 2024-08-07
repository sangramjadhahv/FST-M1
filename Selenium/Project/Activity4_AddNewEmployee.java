package project_HRM;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Activity4_AddNewEmployee extends Activity3_LoginApp {
	
	//: Add an employee and their details to the site
   // @BeforeClass(enabled = false)
	

	@Test()
	public void AddEmp() throws InterruptedException
	{
		
	String FirstName = "Josh1";
		String lastName =  "Zen1";
	
	driver.findElement(By.id("menu_pim_viewPimModule")).click();
	driver.findElement(By.id("menu_pim_viewPimModule")).click();
	wait=new WebDriverWait(driver,Duration.ofSeconds(3000));
	wait.until(ExpectedConditions.presenceOfElementLocated(By.name("btnAdd")));
	
	driver.findElement(By.name("btnAdd")).click();
	Thread.sleep(4000);
	//add emp
	driver.findElement(By.id("firstName")).sendKeys(FirstName);
	driver.findElement(By.id("lastName")).sendKeys(lastName);
	driver.findElement(By.id("btnSave")).click();	
	Thread.sleep(4000);
	
	String empID = driver.findElement(By.id("personal_txtEmployeeId")).getAttribute("value");
	System.out.println("Emp Id is :" +empID);
	
	//search emp
	driver.findElement(By.id("menu_pim_viewPimModule")).click();
	driver.findElement(By.id("menu_pim_viewPimModule")).click();
	driver.findElement(By.id("empsearch_id")).sendKeys(empID);
	
	driver.findElement(By.id("searchBtn")).click();
	WebElement tbElement=driver.findElement(By.xpath("//tbody//tr//td[2]/a"));
	String tableValue=tbElement.getText();
	System.out.println("table value is :" + tableValue);
	Assert.assertEquals(tableValue,empID);
	Thread.sleep(2000);
	driver.close();
	
	}

}
