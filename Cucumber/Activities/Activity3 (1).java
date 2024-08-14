package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity3 extends Base {

    Alert alert;

    @Given("user is on the page")
    public void navigateToPage(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        //Optional: Maximize the browser window
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.get("https://v1.training-support.net/selenium/javascript-alerts");
    }

    @When("user clicks the Simple Alert button")
    public void clickSimpleAlertButton(){
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("simple")));
        driver.findElement(By.id("simple")).click();
    }

    @When("user clicks the Confirm Alert button")
    public void clickConfirmAlertButton(){
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("confirm")));
        driver.findElement(By.id("confirm")).click();
    }

    @When("user clicks the Prompt Alert button")
    public void clickPromptAlertButton(){
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("prompt")));
        driver.findElement(By.id("prompt")).click();
    }

    @Then("alert opens")
    public void switchToAlert(){
        alert = driver.switchTo().alert();
    }

    @And("read the text from it and print it")
    public void readAlertText(){
        System.out.println(alert.getText());
    }

    @And("^write a custom message in it$")
    public void writeToPrompt() {
        alert.sendKeys("Custom Message");
    }

    @And("close the alert")
    public void closeAlert(){
        alert.accept();
    }

    @And("close the alert with Cancel")
    public void CloseAlertCancel(){
        alert.dismiss();
    }

    @And("close Browser")
    public void closeBrowser(){
        driver.quit();
    }
}
