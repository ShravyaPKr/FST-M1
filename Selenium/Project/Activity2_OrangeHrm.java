import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

// 2. Get the url of the header image
//Goal: Print the url of the header image to the console

public class Activity2_OrangeHrm {
    public static void main(String[] args) {
        String appUrl = "http://alchemy.hguy.co/orangehrm";

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        //Launching URL
        driver.navigate().to(appUrl);

        //Locating Header Image and obtaining its URL
        String headerImg = driver.findElement(By.xpath("//div[@id='divLogo']/img")).getAttribute("src");
        System.out.println(headerImg);

        //Closing the Browser
        driver.close();
    }
}
