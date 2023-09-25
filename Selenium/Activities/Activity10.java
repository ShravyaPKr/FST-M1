package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity10 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        //Launching the page URL
        driver.get("https://training-support.net/selenium/dynamic-controls");
        Thread.sleep(1000);

        //Getting Home page Title
        String pageTitle = driver.getTitle();
        System.out.println("Title of the Page is : " + " " +pageTitle);

       //Checking if the Checkbox element is visible on the screen
        boolean flag = driver.findElement(By.xpath("//div[@id='dynamicCheckbox']/input")).isDisplayed();
        System.out.println("Is the Checkbox element displayed on the screen ? " + " - " + flag);

        driver.findElement(By.xpath("//button[text()='Remove checkbox']")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(("//button[text()='Add Checkbox']"))));

        //Re-checking if the Checkbox element is visible on the screen
        boolean recheckFlag = driver.findElement(By.xpath("//div[@id='dynamicCheckbox']/input")).isDisplayed();
        System.out.println("Is the Checkbox element displayed on the screen ? " + " - " + recheckFlag);

        driver.close();
    }
}
