package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class Activity1 {
    WebDriver driver;
    @BeforeMethod
    public void beforeMethod() {
        // Set up the Driver
        WebDriverManager.firefoxdriver().setup();
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();

        //Opening the browser
        driver.get("https://v1.training-support.net");
    }

    @Test
    public void activity1TestCase() {
        // Get the title of the page
        String pageTitle = driver.getTitle();

        //Print the title of the page
        System.out.println("Page title is: " + pageTitle);

        //Asserting the page title
        Assert.assertEquals("Training Support", pageTitle);

        //Find the 'About Us' link and click it
        driver.findElement(By.id("about-link")).click();

        // Get the title of the newly opened page
        String newPageTitle = driver.getTitle();

        //Print title of new page
        System.out.println("New page title is: " + newPageTitle);

        Assert.assertEquals(newPageTitle, "About Training Support");
    }

    @AfterMethod
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }
}