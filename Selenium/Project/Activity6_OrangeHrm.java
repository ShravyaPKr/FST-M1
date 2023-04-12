import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

//6. Verify that the “Directory” menu item is visible and clickable
//Goal: Verify that the “Directory” menu item is visible and clickable

public class Activity6_OrangeHrm {
    public static void main(String[] args) throws InterruptedException {
        String appUrl = "http://alchemy.hguy.co/orangehrm";

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        //Launching URL
        driver.navigate().to(appUrl);

        //Locating Username and Password fields - Logging in
        String userName = "orange";
        String password = "orangepassword123";

        driver.findElement(By.id("txtUsername")).sendKeys(userName);
        driver.findElement(By.id("txtPassword")).sendKeys(password);
        driver.findElement(By.id("btnLogin")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@id='welcome']")));

        //Validating if Homepage opened or not
        Assert.assertTrue(driver.findElement(By.xpath("//a[@id='welcome']")).isDisplayed(), "Landed on Homepage");

        //Checking if 'Directory' menu option is visible
        Assert.assertTrue(driver.findElement(By.xpath("//b[text()='Directory']/parent::a")).isDisplayed(), "'Directory' menu " +
                "option is visible");

        //Checking if 'Directory' menu option is Clickable
        Thread.sleep(2000);
        driver.findElement(By.xpath("//b[text()='Directory']/parent::a")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[text()='Search Directory']")));

        Assert.assertTrue(driver.findElement(By.xpath("//h1[text()='Search Directory']")).isDisplayed(), "'Directory' menu " +
                "option is Clickable");

        //Verifying Page title
        String actualPageTitle = driver.findElement(By.xpath("//h1[text()='Search Directory']")).getText();
        String expectedPageTitle = "Search Directory";
        Assert.assertEquals(actualPageTitle,expectedPageTitle,"Actual and Expected page title - 'Search Directory' matches");

        driver.close();
    }
}
