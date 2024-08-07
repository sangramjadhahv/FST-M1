package project_HRM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Activity5_EditUserInfo extends Activity3_LoginApp {
	
	@Test
	public void EditInfo() throws InterruptedException
	{
		driver.findElement(By.id("menu_pim_viewMyDetails")).click();
		driver.findElement(By.id("menu_pim_viewMyDetails")).click();
		//click edit button 
		driver.findElement(By.id("btnSave")).click();
		
		// ****************enter details***************
		
		//fname_lname
		driver.findElement(By.id("personal_txtEmpFirstName")).clear();
		driver.findElement(By.id("personal_txtEmpFirstName")).sendKeys("Rachel");
		driver.findElement(By.id("personal_txtEmpLastName")).clear();
		driver.findElement(By.id("personal_txtEmpLastName")).sendKeys("Zane");
		
		//Gender Radio button
		WebElement genderElement= driver.findElement(By.id("personal_optGender_2"));
		genderElement.click();
		
		Thread.sleep(1000);
		
		// dropdown select
		WebElement NationalityDropDown=driver.findElement(By.id("personal_cmbNation"));
		Select select = new Select(NationalityDropDown);
		List<WebElement> options = select.getOptions();
		select.selectByVisibleText("German");
		
		//dob
		driver.findElement(By.id("personal_DOB")).clear();
		driver.findElement(By.id("personal_DOB")).sendKeys("2000-10-04");
		
		//save button
		driver.findElement(By.id("btnSave")).click();
		Thread.sleep(1000);
		
		driver.close();
	
		
	}
	

}
