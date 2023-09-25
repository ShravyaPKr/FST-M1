package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity15 {
    public static void main(String[] args) throws InterruptedException {
                WebDriverManager.firefoxdriver().setup();
                WebDriver driver = new FirefoxDriver();

                //Launching the page URL
                driver.get("https://training-support.net/selenium/dynamic-attributes");
                Thread.sleep(1000);

                //Getting Home page Title
                String pageTitle = driver.getTitle();
                System.out.println("Title of the Page is : " + " " +pageTitle);

                //Finding the login fields and entering details to login
                driver.findElement(By.xpath("//div[contains(text(),'Sign in')]/parent::h2/following-sibling::div/label[text()='Username']/following-sibling::input")).sendKeys("admin");
                driver.findElement(By.xpath("//div[contains(text(),'Sign in')]/parent::h2/following-sibling::div/label[text()='Password']/following-sibling::input")).sendKeys("password");
                driver.findElement(By.xpath("//button[text()='Log in']")).click();

                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
                wait.until(ExpectedConditions.presenceOfElementLocated(By.id("action-confirmation")));

                boolean confirmationFlag =driver.findElement(By.id("action-confirmation")).isDisplayed();
                if (confirmationFlag) {
                    System.out.println("Confirmation Message displayed - Login Successful");
                    System.out.println("Confirmation Message is as follows");
                    System.out.println(driver.findElement(By.id("action-confirmation")).getText());
                }
                else
                    System.out.println("Confirmation Message NOT displayed");

                //Closing the Browser
                driver.close();
            }
        }