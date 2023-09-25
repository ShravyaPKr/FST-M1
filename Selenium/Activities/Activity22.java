package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.xmlbeans.GDuration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class Activity22 {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        //Launching the page URL
        driver.get("https://www.training-support.net/selenium/popups");
        Thread.sleep(2000);

        //Getting Home page Title
        String pageTitle = driver.getTitle();
        System.out.println("Title of the Page is : " + " " + pageTitle);
        Thread.sleep(2000);

        //Hovering on the Button to get the Tool Tip Visible
        Actions act = new Actions(driver);
        act.moveToElement(driver.findElement(By.xpath("//button[text()='Sign In']"))).build().perform();
        Thread.sleep(4000);

        //Getting the tool tip text
        String tooltipText = driver.findElement(By.xpath("//button[text()='Sign In']")).getAttribute("data-tooltip");
        System.out.println(tooltipText);

        //Clicking on the 'Sign In' button
        driver.findElement(By.xpath("//button[text()='Sign In']")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='Sign In']")));

        //Entering the Username and Password on the Sign In pop-up
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("password");
        driver.findElement(By.xpath("//button[text()='Log in']")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'Welcome') and @id ='action-confirmation']")));

        //Message after logging in
        String msg = driver.findElement(By.xpath("//div[contains(text(),'Welcome') and @id ='action-confirmation']")).getText();
        System.out.println("Message after logging in is : " +  " " + msg);

        //Closing the browser
        driver.close();
    }
}