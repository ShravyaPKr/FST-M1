package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Activity18 {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        //Launching the page URL
        driver.get("https://training-support.net/selenium/selects");
        Thread.sleep(1000);

        //Getting Home page Title
        String pageTitle = driver.getTitle();
        System.out.println("Title of the Page is : " + " " +pageTitle);

        //Selecting Various Options
        Select multiSelect = new Select(driver.findElement(By.id("multi-select")));

        //Selecting "JavaScript" option using the visible text.
        multiSelect.selectByVisibleText("Javascript");

        //Selecting - 4th , 5th and 6th Elements
        multiSelect.selectByIndex(4);
        multiSelect.selectByIndex(5);
        multiSelect.selectByIndex(6);

        //Selecting "NodeJS" option using the value.
        multiSelect.selectByValue("node");

        //De-Selecting 5th Option
        multiSelect.deselectByIndex(5);

        // Print all the selected options
        System.out.println("Following are the latest options which are selected : ");
        List<WebElement> selects = multiSelect.getAllSelectedOptions();
        for (WebElement e : selects)
        {
            System.out.println(e.getText());
        }

        //Closing the browser
        driver.close();
    }
}
