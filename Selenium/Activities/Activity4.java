package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;

public class Activity4
{
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        //Launching the page URL
        driver.get("https://training-support.net/selenium/target-practice");
        Thread.sleep(1000);

        //Getting Home page Title
        String pageTitle = driver.getTitle();
        System.out.println("Title of the Page is : " + " " +pageTitle);

        //Locating Header 3 and printing its text
        System.out.println(driver.findElement(By.xpath("//h3[@id='third-header']")).getText());

        //Locating Header 5 and printing its colour
        String colorName = String.valueOf(driver.findElement(By.xpath("//h5[text()='Fifth header']")).getCssValue("color"));
        System.out.println("Colour of 5th Header is :" + "  " + colorName);

        //Another way to get Color
        String color = String.valueOf(driver.findElement(By.xpath("//h5[text()='Fifth header']")).getAttribute("Class"));
        String s1 = color.substring(3,8);
        System.out.println("Header 5 colour is : " + " " +s1);

        //Finding the Violet button
        System.out.print("Class of Violet Button is: " );
        System.out.print(driver.findElement(By.xpath("//button[text()='Violet']")).getAttribute("Class"));
        System.out.println(" ");

        //Finding the Grey button
        System.out.print("Text of Grey Button is: " );
        System.out.print(driver.findElement(By.xpath("//button[text()='Grey']")).getText());
        System.out.println(" ");

        driver.close();
    }
}
