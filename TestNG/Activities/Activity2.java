package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity2 {
    WebDriver driver;
    @BeforeMethod
    public void beforeMethod() {
        // Set up the Driver
        WebDriverManager.firefoxdriver().setup();
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();

        //Opening the browser
        driver.get(" https://v1.training-support.net/selenium/target-practice");
    }

    @Test
    public void activity2TestCase1() {
        // Get the title of the page
        String pageTitle = driver.getTitle();

        //Print the title of the page
        System.out.println("Page title is: " + pageTitle);

        //Asserting the page title
        Assert.assertEquals("Target Practice", pageTitle);
    }

    @Test
    public void activity2TestCase2() {
        WebElement blackBtn = driver.findElement(By.xpath("//button[text()='Black']"));
        String className = blackBtn.getAttribute("class");
        boolean flag = className.contains("grey");
        Assert.assertTrue(flag);
    }

    @Test(enabled = false)
    public void activity2TestCase3() {
        System.out.println("Test for Skipping using 'Enabled'");
        Assert.assertTrue(true);
    }

    @Test
    public void activity2TestCase4() {
        //Testing skipping of test
        throw new SkipException("Skipping test case");
    }
    @AfterMethod
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }
}