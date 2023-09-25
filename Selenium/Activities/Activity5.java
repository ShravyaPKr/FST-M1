package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity5 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        //Launching the page URL
        driver.get("https://www.training-support.net/selenium/input-events");
        Thread.sleep(1000);

        //Getting Home page Title
        String pageTitle = driver.getTitle();
        System.out.println("Title of the Page is : " + " " +pageTitle);

        Actions act = new Actions(driver);

        //Left Click and printing the active value
        act.click().pause(1000).build().perform();
        String activeValueAfterClick = driver.findElement(By.className("active")).getText();
        System.out.println("Active Value on the Cube after Left Click is : " + " " + activeValueAfterClick);

        //Double Click and Printing the active value
        act.doubleClick().pause(1000).build().perform();
        String activeValueAfterDoubleClick = driver.findElement(By.className("active")).getText();
        System.out.println("Active Value on the Cube after Double Click is : " + " " + activeValueAfterDoubleClick);

        //Right Click and Printing the active value
        act.contextClick().pause(1000).build().perform();
        String activeValueAfterRightClick = driver.findElement(By.className("active")).getText();
        System.out.println("Active Value on the Cube after Right Click is : " + " " + activeValueAfterRightClick);

        driver.close();
    }
}
