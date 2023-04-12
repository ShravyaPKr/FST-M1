import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

//4. Add a new employee
//Goal: Add an employee and their details to the site

public class Activity4_OrangeHrm {
    public static void main(String[] args) throws InterruptedException {
        String appUrl = "http://alchemy.hguy.co/orangehrm";

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        //Launching URL
        driver.navigate().to(appUrl);

        //Locating Username and Password fields - Logging in
        String userName = "orange";
        driver.findElement(By.id("txtUsername")).sendKeys(userName);

        String password = "orangepassword123";
        driver.findElement(By.id("txtPassword")).sendKeys(password);
        driver.findElement(By.id("btnLogin")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@id='welcome']")));

        //Validating if Homepage opened or not
        if(driver.findElement(By.xpath("//a[@id='welcome']")).isDisplayed()) {
            System.out.println("User has logged successfully and is landed on Homepage");

            //Finding 'PIM' button
            Actions act = new Actions(driver);
            WebElement pimButton = driver.findElement(By.xpath("//b[text()='PIM']/parent::a"));
            act.moveToElement(pimButton).pause(1000).click().build().perform();

            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnAdd")));

            //Adding a new Employee Detail
            driver.findElement(By.id("btnAdd")).click();

            String firstName = "Kumar";
            String lastName = "TestUser";

            driver.findElement(By.id("firstName")).sendKeys(firstName);
            driver.findElement(By.id("lastName")).sendKeys(lastName);

            String empId = driver.findElement(By.id("employeeId")).getAttribute("value");
            driver.findElement(By.id("btnSave")).click();
            Thread.sleep(1000);

            //Searching for the added employee detail
            driver.findElement(By.id("menu_pim_viewEmployeeList")).click();
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("empsearch_id")));
            driver.findElement(By.id("empsearch_id")).sendKeys(empId);
            driver.findElement(By.id("searchBtn")).click();
            Thread.sleep(1000);

            String actualEmpFname = driver.findElement(By.xpath("//table[@id='resultTable']//td[3]/a")).getText();
            String actualEmpLname = driver.findElement(By.xpath("//table[@id='resultTable']//td[4]/a")).getText();

            if((actualEmpFname.equals(firstName)) && (actualEmpLname.equals(lastName)))
            {
                System.out.println("Entered Employee Data is Saved Successfully and Retrieved.");
            }
            else
                System.out.println("Entered Employee Data is NOT Saved Successfully. Unable to find the New Employee. Please Check .. !!");

        }
        else
            System.out.println("Login failed.. !! Please check");

        //Closing the Browser
        driver.close();
    }
}
