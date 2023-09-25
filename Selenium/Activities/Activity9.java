package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity9 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        //Launching the page URL
        driver.get("https://training-support.net/selenium/ajax");
        Thread.sleep(1000);

        WebElement buttonToClick = driver.findElement(By.xpath("//button[text()='Change Content']"));
        buttonToClick.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        //Wait till 'Hello' is visible
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(("//div[@id='ajax-content']/h1"))));
        System.out.println(driver.findElement(By.xpath("//div[@id='ajax-content']/h1")).getText()+" " + " - " + "is displayed on Screen");
        System.out.println("Following Message is also displayed");
        System.out.println(driver.findElement(By.xpath("//h3[contains(text(), 'This text')]")).getText());

        //Wait till Message changes to new Message
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//h3[contains(text(), 'This text')]")));
        System.out.println("Old Message is changed to following");
        System.out.println(driver.findElement(By.xpath("//h3")).getText());

        driver.close();
    }
}
