package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity11 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        //Launching the page URL
        driver.get("https://training-support.net/selenium/dynamic-controls");
        Thread.sleep(1000);

        //Getting Home page Title
        String pageTitle = driver.getTitle();
        System.out.println("Title of the Page is : " + " " +pageTitle);

       //Checking if the Checkbox element is Checked or not.
        boolean flag = driver.findElement(By.xpath("//div[@id='dynamicCheckbox']/input")).isSelected();
        System.out.println("Is the Checkbox element Selected / Checked ? " + " - " + flag);

        driver.findElement(By.xpath("//div[@id='dynamicCheckbox']/input")).click();

        //Re-checking if the Checkbox element is Checked or not.
        boolean recheckFlag = driver.findElement(By.xpath("//div[@id='dynamicCheckbox']/input")).isSelected();
        System.out.println("Is the Checkbox element Selected / Checked ? " + " - " + flag);

        driver.close();
    }
}
