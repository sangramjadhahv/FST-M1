package project_HRM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Activity9_EmergencyContact extends Activity3_LoginApp{
	
	@Test
	public void RetrieveEmergencyContact()
	{	
		
		//Myinfo item
		driver.findElement(By.id("menu_pim_viewMyDetails")).click();
		driver.findElement(By.id("menu_pim_viewMyDetails")).click();
		
		//Emergency Contact side menu
		driver.findElement(By.xpath("//ul[@id='sidenav']/li[3]")).click();
		
	List<WebElement> rows=driver.findElements(By.xpath("//table[@id='emgcontact_list']/tbody/tr"));
	System.out.println("Row Size is :"+rows.size()); 
	
	//print all the row values in console
	for(WebElement row :rows)
	{
		System.out.println("Row Values are :"+ row.getText());
	}
	
	driver.close();	

		
	}
}
