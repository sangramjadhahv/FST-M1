package project_HRM;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Activity1_TitleofTheWebsite extends BaseClass {
	
	
	@Test(dependsOnMethods = "launchBrowser")
	public void loginsetup()
	{
		
	    String TitleofthePage =driver.getTitle();	
	    System.out.println("Page Title is :"+TitleofthePage);
	    Assert.assertEquals("OrangeHRM",TitleofthePage );
	    
	    driver.close();
	    
		
	}
	
}
