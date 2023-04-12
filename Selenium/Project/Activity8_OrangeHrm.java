import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

//7. Adding qualifications
//Goal: Add employee qualifications

public class Activity8_OrangeHrm {
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

        //Validating if landed on 'Dashboard' or not
        Assert.assertTrue(driver.findElement(By.xpath("//h1[text()='Dashboard']")).isDisplayed(), "Landed on Dashboard Page");
        Thread.sleep(2000);

        //Navigating to 'Apply Leave' page
        driver.findElement(By.xpath("//span[text()='Apply Leave']/parent::a")).click();
        Thread.sleep(1000);
        //Validating if landed on 'Apply Leave' page or not
        Assert.assertTrue(driver.findElement(By.xpath("//h1[text()='Apply Leave']")).isDisplayed(),
                "Landed on 'Apply Leave' Page");

        //Selecting Leave Type and Duration
        Select leaveType = new Select(driver.findElement(By.id("applyleave_txtLeaveType")));
        leaveType.selectByVisibleText("DayOff");

        driver.findElement(By.id("applyleave_txtFromDate")).clear();
        driver.findElement(By.id("applyleave_txtFromDate")).sendKeys("2023-05-09");
        Thread.sleep(2000);
        driver.findElement(By.id("applyleave_txtComment")).sendKeys("Test Comment");
        Thread.sleep(1000);
        driver.findElement(By.id("applyBtn")).click();

        //Validating if data is getting saved or not
        if(driver.findElement(By.xpath("//div[contains(text(),'Successfully')]")).isDisplayed())
        {
            System.out.println("Added data saved successfully");
            Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(),'Successfully')]")).isDisplayed());
        }
        else
            System.out.println("Added data not saved. Please Check .. !!");

        Thread.sleep(1000);
        driver.findElement(By.id("menu_leave_viewMyLeaveList")).click();
        Thread.sleep(1000);
        //Validating if landed on 'My Leave List' page or not
        Assert.assertTrue(driver.findElement(By.xpath("//h1[text()='My Leave List']")).isDisplayed(), "Landed on 'My Leave List' Page");

        Thread.sleep(1000);
        driver.findElement(By.id("calFromDate")).clear();
        driver.findElement(By.id("calFromDate")).sendKeys("2023-05-09");
        driver.findElement(By.id("calToDate")).clear();
        driver.findElement(By.id("calToDate")).sendKeys("2023-05-09");
        Thread.sleep(1000);
        driver.findElement(By.id("btnSearch")).click();
        Thread.sleep(2000);
        System.out.println("Status of Leave is : " + " " +
                driver.findElement(By.xpath("//table[@id='resultTable']//tr/td[6]")).getText());
        //Closing the Browser
        driver.close();
    }
}
