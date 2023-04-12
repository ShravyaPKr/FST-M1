import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

//7. Adding qualifications
//Goal: Add employee qualifications

public class Activity7_OrangeHrm {
    public static void main(String[] args) throws InterruptedException {
        String appUrl = "http://alchemy.hguy.co/orangehrm";

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        //Launching URL
        driver.navigate().to(appUrl);

        //Locating Username and Password fields - Logging in
        String userName = "orange";
        driver.findElement(By.id("txtUsername")).sendKeys(userName);

        String password = "orangepassword123";
        driver.findElement(By.id("txtPassword")).sendKeys(password);
        driver.findElement(By.id("btnLogin")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@id='welcome']")));

        //Validating if Homepage opened or not
        Assert.assertTrue(driver.findElement(By.xpath("//a[@id='welcome']")).isDisplayed(), "Landed on Homepage");
        Thread.sleep(2000);
        //Clicking on 'My Info' button
        Actions act = new Actions(driver);
        WebElement pimButton = driver.findElement(By.xpath("//b[text()='My Info']/parent::a"));
        act.moveToElement(pimButton).pause(1000).click().build().perform();

        //Waiting for Edit 'My Info' page to load
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@value='Edit' and@id='btnSave']")));

        //Locating 'Qualifications' from Left Side panel and clicking it
        driver.findElement(By.linkText("Qualifications")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[text()='Work Experience']")));

        //Clicking on 'Add' in 'Qualifications' page
        driver.findElement(By.id("addWorkExperience")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[text()='Add Work Experience']")));

        //Enter Work Exp. details
        String company = "iGate";
        String jobTitle = "Software Engineer";
        driver.findElement(By.id("experience_employer")).sendKeys(company);
        driver.findElement(By.id("experience_jobtitle")).sendKeys(jobTitle);
        driver.findElement(By.id("btnWorkExpSave")).click();

        //Validating if data is getting saved or not
        if(driver.findElement(By.xpath("//div[contains(text(),'Successfully')]")).isDisplayed())
        {
            System.out.println("Added data saved successfully");
            Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(),'Successfully')]")).isDisplayed());
        }
        else
            System.out.println("Added data not saved. Please Check .. !!");


        //Closing the Browser
        driver.close();
    }
}
