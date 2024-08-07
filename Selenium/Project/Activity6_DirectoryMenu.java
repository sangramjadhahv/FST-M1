package project_HRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Activity6_DirectoryMenu extends Activity3_LoginApp {
	
	@Test
	public void DirectoryMenuCheck()
	{
		//Directory menu
		WebElement directoryElement= driver.findElement(By.id("menu_directory_viewDirectory"));
		boolean flag =directoryElement.isDisplayed();
		System.out.println("Is Directory Menu Visible: " +flag);
		
		directoryElement.click();
		directoryElement.click();
		
		//Search Directory Header
		WebElement Header= driver.findElement(By.xpath("//div[@class='head']/h1"));
		String headerString =  Header.getText();
		System.out.println("Header Value is :"+ headerString);
		Assert.assertEquals(headerString, "Search Directory");
		driver.close();
		
	}

}
