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
import java.util.ArrayList;
import java.util.List;

//7. Adding qualifications
//Goal: Add employee qualifications

public class Activity9_OrangeHrm {
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

        //Locating 'Emergency Contacts' from Left Side panel and clicking it
        driver.findElement(By.linkText("Emergency Contacts")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[text()='Assigned Emergency Contacts']")));
        Thread.sleep(1500);

        //Printing the Emergency Contact details displayed in the Emergency Details Page

        //Contact Name
        List<WebElement> emgContactName = new ArrayList<>();
        System.out.println("Following are the Contact Name Detail :");
        emgContactName = driver.findElements(By.xpath("//table[@id='emgcontact_list']//td[@class='emgContactName']"));
        for (WebElement ecn : emgContactName) {
            System.out.println(ecn.getText());
        }

        List<WebElement> emgOtherDetails = new ArrayList<>();
        System.out.println("Following are the Relationship,Home Telephone,Mobile and Work Telephone Details :");
        emgOtherDetails = driver.findElements(By.xpath("//table[@id='emgcontact_list']//td[@class='emgContactName']/following-sibling::td"));
        for (WebElement eod : emgOtherDetails) {
            if(eod.getText().isEmpty()){
                System.out.print("No Details present - Blank");
            }
            System.out.print(eod.getText());
            System.out.println(" ");
        }

        //Closing the Browser
        driver.close();
    }
}
