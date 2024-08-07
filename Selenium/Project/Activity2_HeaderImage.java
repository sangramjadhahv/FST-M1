package project_HRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Activity2_HeaderImage extends BaseClass{
	
	//Print the url of the header image to the console
	@Test
	public void urlImageLink()
	{
		WebElement URL = driver.findElement(By.xpath("//div[@id='divLogo']/img"));
		String imageURL= URL.getAttribute("src");
		System.out.println("URL of the header image is: "+ imageURL);
		
		driver.close();
	}
	


}
