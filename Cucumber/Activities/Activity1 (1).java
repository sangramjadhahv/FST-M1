package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Keys;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Activity1 extends Base {

    @Given("user is on Google Home Page")
    public void navigateToGoogle() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.manage().window().maximize();
        //Open the browser
        driver.get("https://www.google.co.in");
    }

    @When("user types in Cheese and hits ENTER")
    public void searchCheese() {
        driver.findElement(By.name("q")).sendKeys("Cheese", Keys.RETURN);
    }

    @Then("show how many search results were shown")
    public void searchResultCount() {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("result-stats")));
        String resultStats = driver.findElement(By.xpath("//div[@id = 'result-stats']")).getText();
        System.out.println("Number of results found: " + resultStats);
    }

    @And("close the browser")
    public void closeBrowser(){
        driver.close();
    }
}
