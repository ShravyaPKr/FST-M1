import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

//1. Verify the website title
//Goal: Read the title of the website and verify the text

public class Activity1_OrangeHrm {
    public static void main(String[] args) {
        String appUrl = "http://alchemy.hguy.co/orangehrm";

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        //Launching URL
        driver.navigate().to(appUrl);

        //Getting Page title
        String actualPageTitle = driver.getTitle();
        String expectedPageTitle = "OrangeHRM";

        if(actualPageTitle.equals(expectedPageTitle))
        {
            System.out.println("Expected Page Title matches the Actual Page Title");
            Assert.assertEquals(actualPageTitle,expectedPageTitle,"Expected Page Title matches the Actual Page Title");
            //Closing the Browser based on the given condition
            driver.close();
        }

    }
}
