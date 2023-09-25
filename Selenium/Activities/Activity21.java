package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class Activity21 {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        //Launching the page URL
        driver.get("https://www.training-support.net/selenium/tab-opener");
        Thread.sleep(2000);

        //Getting Home page Title
        String pageTitle = driver.getTitle();
        System.out.println("Title of the Page is : " + " " + pageTitle);
        Thread.sleep(2000);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'Click Me') and @id='launcher']")));

        //Finding the 'Click Me' button in the first tab and click it
        driver.findElement(By.xpath("//a[contains(text(),'Click Me') and @id='launcher']")).click();

        Thread.sleep(2000);
        Set<String> openWin = driver.getWindowHandles();
        Iterator<String> openWindowIDs = openWin.iterator();

        //Printing all the Handles
        System.out.println("Currently there are : " + " " + openWin.size() + "  " + "Open Window Handles");

        //Switching to new window
        while (openWindowIDs.hasNext()) {
            driver.switchTo().window(openWindowIDs.next());
        }

        String newSwitchedPage = driver.getTitle();
        System.out.println("Title of the switched Page is : " + " " + newSwitchedPage);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'Open Another One') and @id='actionButton']")));

        //Finding the 'Open Another One' button in the second tab and click it
        driver.findElement(By.xpath("//a[contains(text(),'Open Another One') and @id='actionButton']")).click();

        Thread.sleep(2000);
        Set<String> openNewWin = driver.getWindowHandles();
        Iterator<String> openNewWindowIDs = openNewWin.iterator();

        //Printing all the Handles
        System.out.println("Currently there are : " + " " + openNewWin.size() + "  " + "Open Window");

        //Switching to new window
        while (openNewWindowIDs.hasNext()) {
            driver.switchTo().window(openNewWindowIDs.next());
        }

        String secondSwitchPage = driver.getTitle();
        System.out.println("Title of the switched Page is : " + " " + secondSwitchPage);

        //Closing the browser
        driver.quit();
    }
}