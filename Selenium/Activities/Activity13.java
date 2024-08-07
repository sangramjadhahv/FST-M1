package activities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity13 {

	public static void main(String[] args) {

		WebDriverManager.firefoxdriver().setup();
		WebDriver driver =new FirefoxDriver();

		driver.get("https://v1.training-support.net/selenium/tables");
		System.out.println("Page Title is:"+ driver.getTitle());
		
		//Find the number of rows
		List<WebElement> tableDataRow =driver.findElements(By.xpath("//table[@class='ui celled striped table']/tbody/tr"));
		System.out.println("No of rows in the table are :"+tableDataRow.size());
		
		//find the number of columns
		List<WebElement> tableDataCol =driver.findElements(By.xpath("//table[@class='ui celled striped table']/tbody/tr[1]/td"));
		System.out.println("No of rows in the table are :"+tableDataCol.size());
		
		//Find and print all the cell values in the third row of the table.
		List<WebElement> thridRowData=driver.findElements(By.xpath("//table[@class='ui celled striped table']/tbody/tr[3]"));
		System.out.println("Third Row values are :");
		for(WebElement data : thridRowData)
		{
			System.out.println(data.getText());
		}
		//Find and print the cell value at the second row second column.
		WebElement SecondCell=driver.findElement(By.xpath("//table[@class='ui celled striped table']/tbody/tr[2]/td[2]"));
		System.out.println("2nd Cell Value is :"+SecondCell.getText());
		//Close the browser.
         driver.close();
	}

}
