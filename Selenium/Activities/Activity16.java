package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity16 {
    public static void main(String[] args) throws InterruptedException {
                WebDriverManager.firefoxdriver().setup();
                WebDriver driver = new FirefoxDriver();

                //Launching the page URL
                driver.get("https://training-support.net/selenium/dynamic-attributes");
                Thread.sleep(1000);

                //Getting Home page Title
                String pageTitle = driver.getTitle();
                System.out.println("Title of the Page is : " + " " +pageTitle);

                //Finding the Sign-Up fields and entering details to Sign-Up
                WebElement signUpUsername = driver.findElement(By.xpath("//div[contains(text(),'Sign Up')]/parent::h2/following-sibling::div/label[text()='Username']/following-sibling::input"));
                WebElement signUpPassword  = driver.findElement(By.xpath("//div[contains(text(),'Sign Up')]/parent::h2/following-sibling::div/label[text()='Password']/following-sibling::input"));
                WebElement signUpConfirmPwd  = driver.findElement(By.xpath("//div[contains(text(),'Sign Up')]/parent::h2/following-sibling::div/label[text()='Confirm Password']/following-sibling::input"));
                WebElement signUpEmail  = driver.findElement(By.xpath("//div[contains(text(),'Sign Up')]/parent::h2/following-sibling::div/label[text()='Email']/following-sibling::input"));

                signUpUsername.sendKeys("admin");
                signUpPassword.sendKeys("password!");
                signUpConfirmPwd.sendKeys("password!");
                signUpEmail.sendKeys("admin234@gmail.com");
                driver.findElement(By.xpath("//button[text()='Sign Up']")).click();

                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
                wait.until(ExpectedConditions.presenceOfElementLocated(By.id("action-confirmation")));

                boolean confirmationFlag =driver.findElement(By.id("action-confirmation")).isDisplayed();
                if (confirmationFlag) {
                    System.out.println("Confirmation Message displayed - Sign Up Successful");
                    System.out.println("Confirmation Message is as follows");
                    System.out.println(driver.findElement(By.id("action-confirmation")).getText());
                }
                else
                    System.out.println("Confirmation Message NOT displayed");

                //Closing the Browser
                driver.close();
            }
        }