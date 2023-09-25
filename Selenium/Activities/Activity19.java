package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity19 {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        //Launching the page URL
        driver.get("https://training-support.net/selenium/javascript-alerts");
        Thread.sleep(1000);

        //Getting Home page Title
        String pageTitle = driver.getTitle();
        System.out.println("Title of the Page is : " + " " +pageTitle);

        //Finding the Confirm Button, clicking and get the message - Then Accepting it
        driver.findElement(By.id("confirm")).click();

        Alert alt = driver.switchTo().alert();
        System.out.println("Message in the Alert Box is: ");
        System.out.println(alt.getText());
        alt.accept();
        System.out.println("Closed the Alert by Accepting it.");
        //Finding the Confirm Button, clicking and get the message - Then Accepting it
        driver.findElement(By.id("confirm")).click();
        Thread.sleep(2000);
        alt.dismiss();
        System.out.println("Closed the Alert via Dismiss");
        //Closing the browser
        driver.close();
    }
}
