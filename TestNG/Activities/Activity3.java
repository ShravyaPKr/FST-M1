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

public class Activity3 {
    WebDriver driver;
    @BeforeMethod
    public void beforeMethod() {
        // Set up the Driver
        WebDriverManager.firefoxdriver().setup();
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();

        //Opening the browser
        driver.get(" https://v1.training-support.net/selenium/login-form");
    }

    @Test
    public void activity3TestCase1() throws InterruptedException {
        Thread.sleep(1000);
        //Getting Home page Title
        String loginPageTitle = driver.getTitle();
        System.out.println("Title of the Page is : " + " " +loginPageTitle);

        //Finding the login fields and entering details to login
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("admin");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("password");
        driver.findElement(By.xpath("//button[text()='Log in']")).click();
        Thread.sleep(1000);

        WebElement confirmationText = driver.findElement(By.xpath("//div[contains(text(),'Welcome') and @id ='action-confirmation']"));
        String confirmationMsg = confirmationText.getText();
        Assert.assertTrue(confirmationText.isDisplayed());
        Assert.assertEquals("Welcome Back, admin",confirmationMsg);
    }

    @AfterMethod
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }
}