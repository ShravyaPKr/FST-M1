package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity8 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        //Launching the page URL
        driver.get("https://training-support.net/selenium/dynamic-controls");
        Thread.sleep(1000);

        //Getting Home page Title
        String pageTitle = driver.getTitle();
        System.out.println("Title of the Page is : " + " " +pageTitle);

        WebElement toggleCheckBoxButton = driver.findElement(By.id("toggleCheckbox"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        //Click on 'Remove Checkbox button and wait for it to be removed from UI
        toggleCheckBoxButton.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(("//button[text()='Add Checkbox']"))));

        //Click on 'Add Checkbox button and wait for toggle Check box to be visible and Click on it.
        toggleCheckBoxButton.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(("//button[text()='Remove Checkbox']"))));
        driver.findElement(By.xpath("//div[@id='dynamicCheckbox']/input")).click();

        driver.close();


    }
}
