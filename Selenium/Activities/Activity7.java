package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity7 {
	public static void main(String[] args) throws InterruptedException {

		//Download GeckoDriver
	 WebDriverManager.firefoxdriver().setup();
       //initialize firefox driver
	 WebDriver driver =new FirefoxDriver();
	 
	 //****************-Activity-7--Drag and Drop
	 
	 Actions builder = new Actions(driver);
	 
	 //Open a new browser and print title
	 driver.get("https://v1.training-support.net/selenium/drag-drop");
	 System.out.println("The Title of the Page is : "+driver.getTitle());
	 
	 //Find the ball and simulate a click and drag to move it into "Dropzone 1".
	 WebElement football=driver.findElement(By.id("draggable"));
	 //find the dropzone1
	 WebElement dropzone1 = driver.findElement(By.id("droppable"));
	 //find the dropzone2
	 WebElement dropzone2 = driver.findElement(By.id("dropzone2"));
	 
	 builder.clickAndHold(football).moveToElement(dropzone1).pause(2000).release().build().perform();
	 
	 // Verify that the ball was dropped in dropzone 1
     String dropzone1Verify = dropzone1.findElement(By.tagName("p")).getText();
     if(dropzone1Verify.equals("Dropped!")) {
         System.out.println("Ball was dropped in dropzone 1");
         
     // Perform drag and drop to dropzone 2
     builder.dragAndDrop(dropzone1, dropzone2).build().perform();
         
     // Verify that the ball was dropped in dropzone 2
     String dropzone2Verify = dropzone2.findElement(By.tagName("p")).getText();
       if(dropzone2Verify.equals("Dropped!")) {
             System.out.println("Ball was dropped in dropzone 2");
             
      Thread.sleep(3000);
             
      driver.quit();
         }
     }
	 
	}

}
