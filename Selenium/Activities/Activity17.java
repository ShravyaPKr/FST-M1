package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Activity17 {
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
        Select selct = new Select(driver.findElement(By.id("single-select")));
        selct.selectByVisibleText("Option 2");
        // Print the selected option
        System.out.println("Selected option: " + selct.getFirstSelectedOption().getText());

        selct.selectByIndex(3);
        // Print the selected option
        System.out.println("Selected option: " + selct.getFirstSelectedOption().getText());

        selct.selectByValue("4");
        // Print the selected option
        System.out.println("Selected option: " + selct.getFirstSelectedOption().getText());

        //Obtaining all the options from the dropdown and printing them.
        List<WebElement> options = selct.getOptions();
        System.out.println("Following are the Options present in the Dropdown : ");
        for (WebElement e : options)
        {
            System.out.println(e.getText());
        }
        //Closing the browser
        driver.close();
    }
}
