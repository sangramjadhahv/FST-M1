package activities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity14 {

	public static void main(String[] args) {
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver =new FirefoxDriver();
		
        //navigate to URL and print Title
		driver.get("https://v1.training-support.net/selenium/tables");
		System.out.println("Page Title is:"+ driver.getTitle());
		
		//Find the number of rows
		List<WebElement> sortableDataRow=driver.findElements(By.xpath("//table[@id='sortableTable']/tbody/tr"));
		System.out.println("No of rows in Table:"+sortableDataRow.size());
		
		//Find the number of columns
		List<WebElement> sortableDataCol=driver.findElements(By.xpath("//table[@id='sortableTable']/tbody/tr[1]/td"));
		System.out.println("No of rows in Table:"+sortableDataCol.size());
		
		//Find and print the cell value at the second row second column.
		WebElement secondcellData=driver.findElement(By.xpath("//table[@id='sortableTable']/tbody/tr[2]/td[2]"));
		System.out.println("2nd cell value before Sorting:"+secondcellData.getText());	
		
		//Click the header of the first column to sort by name.
		driver.findElement(By.xpath("//table[@id='sortableTable']/thead/tr/th")).click();
		WebElement secondcellData2=driver.findElement(By.xpath("//table[@id='sortableTable']/tbody/tr[2]/td[2]"));
		System.out.println("2nd cell value After Sorting:"+secondcellData2.getText());
		
		//Print the cell values of the table footer.
		List<WebElement> footerValues=driver.findElements(By.xpath("//table[@id='sortableTable']/tfoot/tr"));
		System.out.println("FooterValues are :");
		for(WebElement footervalue:footerValues)
		{
			System.out.println(footervalue.getText());
		}
		
		driver.close();

	}

}
