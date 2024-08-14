package Activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Activity1 {

    //driver declaration
    AndroidDriver driver;

    //set up the method
    @BeforeClass
    public void setUp() throws MalformedURLException {
        //set the capabilities
        UiAutomator2Options caps = new UiAutomator2Options()
                .setPlatformName("android")
                .setAutomationName("UiAutomator2")
                .setAppPackage("com.google.android.calculator")
                .setAppActivity("com.android.calculator2.Calculator")
                .noReset();
        //set the server URL
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        //Initialize the Android driver
        driver = new AndroidDriver(serverURL, caps);
    }

    @Test
    public void multiplyTest() {

        //Find the number 7 and tap it
        driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_7")).click();
        //Find the multiply buttn and tap it
        driver.findElement(AppiumBy.accessibilityId("multiply")).click();
        //find the number 6 and tap it
        driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_6")).click();
        //Find the equal button and tap it
        driver.findElement(AppiumBy.accessibilityId("equals")).click();
        //Assertions
        String result = driver.findElement(AppiumBy.id("com.google.android.calculator:id/result_final")).getText();
        Assert.assertEquals(result, "42");
    }

    @AfterClass
    public void tearDown() {
        //close the app
        driver.quit();

    }
}
