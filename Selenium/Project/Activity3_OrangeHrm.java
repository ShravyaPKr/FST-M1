import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

//3. Logging into the site
//Goal: Open the site and login with the credentials provided

public class Activity3_OrangeHrm {
    public static void main(String[] args) {
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
        if(driver.findElement(By.xpath("//a[@id='welcome']")).isDisplayed()) {
            System.out.println("User has logged successfully and is landed on Homepage");
            Assert.assertTrue(driver.findElement(By.xpath("//a[@id='welcome']")).isDisplayed(),
                    "User has logged successfully and is landed on Homepage");
        }
        else
            System.out.println("Login failed.. !! Please check");

        //Closing the Browser
        driver.close();
    }
}
