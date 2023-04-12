import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

//5. Edit user information
//Goal: Edit a user’s information

public class Activity5_OrangeHrm {
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
        if(driver.findElement(By.xpath("//a[@id='welcome']")).isDisplayed()) {
            System.out.println("User has logged successfully and is landed on Homepage");

            //Finding 'My Info' button
            Actions act = new Actions(driver);
            WebElement pimButton = driver.findElement(By.xpath("//b[text()='My Info']/parent::a"));
            act.moveToElement(pimButton).pause(1000).click().build().perform();

            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@value='Edit' and@id='btnSave']")));

            //Editing 'My Info' Details and Saving
            driver.findElement(By.xpath("//input[@value='Edit' and@id='btnSave']")).click();

            String firstName = "Kumar";
            String lastName = "TestUser";

            driver.findElement(By.id("personal_txtEmpFirstName")).clear();
            driver.findElement(By.id("personal_txtEmpFirstName")).sendKeys(firstName);
            driver.findElement(By.id("personal_txtEmpLastName")).clear();
            driver.findElement(By.id("personal_txtEmpLastName")).sendKeys(lastName);

            driver.findElement(By.xpath("//label[text()='Male']/preceding-sibling::input")).click();

            Select nationality = new Select(driver.findElement(By.id("personal_cmbNation")));
            nationality.selectByValue("9");

            driver.findElement(By.id("personal_DOB")).clear();
            driver.findElement(By.id("personal_DOB")).sendKeys("1997-11-13");
            Thread.sleep(1000);

            driver.findElement(By.xpath("//input[@value='Save' and@id='btnSave']")).click();

            //Validating if data is getting saved or not
            if(driver.findElement(By.xpath("//div[contains(text(),'Successfully')]")).isDisplayed())
            {
                System.out.println("Edited data saved successfully");
                Assert.assertTrue(true,"Data Saved Successfully");
            }
            else
                System.out.println("Edited data not saved. Please Check .. !!");
        }
        else
            System.out.println("Login failed.. !! Please check");

        //Closing the Browser
        driver.close();
    }
}
