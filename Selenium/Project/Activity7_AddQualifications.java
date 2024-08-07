package project_HRM;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Activity7_AddQualifications extends Activity3_LoginApp{
	
	@Test
	public void AddQualification() throws InterruptedException
	{
		//Myinfo item
		driver.findElement(By.id("menu_pim_viewMyDetails")).click();
		driver.findElement(By.id("menu_pim_viewMyDetails")).click();
		
		//Qualification nav menu
		driver.findElement(By.xpath("//ul[@id='sidenav']/li[9]")).click();
		Thread.sleep(1000);
		
		//WorkExp- Add button
		driver.findElement(By.id("addWorkExperience")).click();
		
		//Enter Details
		driver.findElement(By.id("experience_employer")).sendKeys("Artistic");
		driver.findElement(By.id("experience_jobtitle")).sendKeys("Artist");
		driver.findElement(By.id("btnWorkExpSave")).click();
		
		
	}

}
