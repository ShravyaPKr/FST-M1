package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();

        WebDriver driver = new FirefoxDriver();

        //Launching the page URL
        driver.get("https://training-support.net");
        Thread.sleep(2000);

        //Getting Home page Title
        String pageTitle = driver.getTitle();
        System.out.println("Title of the Page is : " + " " +pageTitle);

        //Navigating to 'About Us' page and getting the page title.
        driver.findElement(By.id("about-link")).click();
        Thread.sleep(2000);
        String aboutUsPageTitle = driver.getTitle();
        System.out.println("Title of the Navigated Page is : " + " " +aboutUsPageTitle);

        //Closing the Browser
        driver.close();
    }

}
