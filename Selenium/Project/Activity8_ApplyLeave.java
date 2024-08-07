package project_HRM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Activity8_ApplyLeave extends Activity3_LoginApp{
	
	@Test
	public void ApplyLeave() throws InterruptedException
	{
		String FromDate ="2024-07-05";
		String ToDate ="2024-07-07";
		driver.findElement(By.id("menu_dashboard_index")).click();
		driver.findElement(By.id("menu_dashboard_index")).click();
		
		//*************Apply Leave
		driver.findElement(By.xpath("//tbody/tr/td[4]")).click();
		Thread.sleep(2000);
		
		// dropdown select
		WebElement LeaveType =driver.findElement(By.id("applyleave_txtLeaveType"));
		Select select = new Select(LeaveType);
		List<WebElement> options = select.getOptions();
		select.selectByVisibleText("DayOff");
		
		WebElement applyFromDate= driver.findElement(By.id("applyleave_txtFromDate"));
		applyFromDate.clear();
		applyFromDate.sendKeys(FromDate);
		WebElement applyToDate= driver.findElement(By.id("applyleave_txtToDate"));
		applyToDate.clear();
		applyToDate.sendKeys(ToDate);
		
		//applybutton
		driver.findElement(By.id("applyBtn")).click();
		
		//**************My Leave List
		
		driver.findElement(By.id("menu_leave_viewMyLeaveList")).click();
		Thread.sleep(2000);
		WebElement searchFromDate= driver.findElement(By.id("calFromDate"));
		searchFromDate.clear();
		searchFromDate.sendKeys(FromDate);
		WebElement searchToDate= driver.findElement(By.id("calToDate"));
		searchToDate.clear();
		searchToDate.sendKeys(ToDate);
		//searchbutton
		driver.findElement(By.id("btnSearch")).click();
		Thread.sleep(3000);
		
		driver.close();
		
		
}
}
