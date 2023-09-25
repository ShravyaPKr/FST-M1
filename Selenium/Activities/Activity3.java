package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity3 {
    public static void main(String[] args) throws InterruptedException {
        //Repeating Activity 1 - With Xpath
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        //Launching the page URL
        driver.get("https://training-support.net");
        Thread.sleep(1000);

        //Getting Home page Title
        String pageTitle = driver.getTitle();
        System.out.println("Title of the Page is : " + " " +pageTitle);

        //Navigating to 'About Us' page and getting the page title.
        driver.findElement(By.xpath("//a[text()='About Us']")).click();
        Thread.sleep(1000);
        String aboutUsPageTitle = driver.getTitle();
        System.out.println("Title of the Navigated Page is : " + " " +aboutUsPageTitle);
        Thread.sleep(2000);

        //Repeating Activity 2 - With Xpath
        //Launching the page URL
        driver.navigate().to("https://training-support.net/selenium/login-form");
        Thread.sleep(1000);

        //Getting Home page Title
        String loginPageTitle = driver.getTitle();
        System.out.println("Title of the Page is : " + " " +loginPageTitle);

        //Finding the login fields and entering details to login
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("admin");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("password");
        driver.findElement(By.xpath("//button[text()='Log in']")).click();
        Thread.sleep(1000);

        boolean flag =driver.findElement(By.xpath("//div[contains(text(),'Welcome') and @id ='action-confirmation']")).isDisplayed();
        if (flag)
            System.out.println("Confirmation Message displayed - Login Successful");
        else
            System.out.println("Confirmation Message NOT displayed");

        //Closing the Browser
        driver.close();

    }
}
