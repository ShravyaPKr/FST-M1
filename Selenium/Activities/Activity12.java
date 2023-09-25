package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity12 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        //Launching the page URL
        driver.get("https://training-support.net/selenium/dynamic-controls");
        Thread.sleep(1000);

        //Getting Home page Title
        String pageTitle = driver.getTitle();
        System.out.println("Title of the Page is : " + " " +pageTitle);

       //Checking if the Text Box is Enabled or Not.
        boolean flag = driver.findElement(By.id("input-text")).isEnabled();
        System.out.println("Is the Text Field Enabled ? " + " - " + flag);

        driver.findElement(By.id("toggleInput")).click();

        //Re-checking if the Text Box is Enabled or Not.
        boolean reCheckFlag = driver.findElement(By.id("input-text")).isEnabled();
        System.out.println("Is the Text Field Enabled ? " + " - " + reCheckFlag);

        driver.close();
    }
}
