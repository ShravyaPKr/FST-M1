package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity7 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        //Launching the page URL
        driver.get("https://training-support.net/selenium/drag-drop");
        Thread.sleep(1000);

        //Getting Home page Title
        String pageTitle = driver.getTitle();
        System.out.println("Title of the Page is : " + " " +pageTitle);

        Actions act = new Actions(driver);

        // Locating the ball
        WebElement footBallElement = driver.findElement(By.xpath("//img[@id='draggable']"));
        WebElement dropZone1 = driver.findElement(By.id("droppable"));
        WebElement dropZone2 = driver.findElement(By.xpath("//div[@id='dropzone2' and contains(text(),'Dropzone 2')]"));

        //Click and Drag the ball to DropZone1
        act.clickAndHold(footBallElement).moveToElement(dropZone1).release().build().perform();

        //Verifying if ball is moved to Dropzone1
        String verifyDropZone1 = driver.findElement(By.xpath("//div[@id='droppable' and contains(text(),'Dropzone 1')]/child::p")).getText();
        if(verifyDropZone1.contains("Dropped"))
        {
            System.out.println("Football has been dropped into DropZone1");
        }
        else
            System.out.println("Please Check! Football is NOT dropped into DropZone1");

        //Dropping the ball to DropZone2
       act.dragAndDrop(footBallElement,dropZone2).build().perform();

        //Verifying if ball is moved to Dropzone1
        String verifyDropZone2 = driver.findElement(By.xpath("//div[@id='dropzone2' and contains(text(),'Dropzone 2')]/child::p")).getText();
        if(verifyDropZone2.contains("Dropped"))
        {
            System.out.println("Football has been dropped into DropZone2");
        }
        else
            System.out.println("Please Check! Football is NOT dropped into DropZone2");

        driver.close();
    }
}
