package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class Activity13 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        //Launching the page URL
        driver.get("https://www.training-support.net/selenium/tables");
        Thread.sleep(1000);

        //Getting Home page Title
        String pageTitle = driver.getTitle();
        System.out.println("Title of the Page is : " + " " +pageTitle);

       //Finding the number of Rows and Columns from the first table
        int fRow = driver.findElements(By.xpath("//table[@class='ui celled striped table']//tr")).size();
        System.out.println("Number of Rows in the first table are: " + " " +fRow);

        int fCol = driver.findElements(By.xpath("//table[@class='ui celled striped table']//tr/td")).size();
        System.out.println("Number of Columns in the first table are: " + " " +fCol);

        //Finding and Printing the cell values of 3rd row from the table
        List<WebElement> cellValues = driver.findElements(By.xpath("//table[@class='ui celled striped table']//tr[3]"));
        System.out.println("Following are the cell values of 3rd Row in the table");
        for (WebElement cellVal :  cellValues) {
            System.out.println(cellVal.getText());
        }

        //Finding and Printing the cell value of 2nd row & 2nd column in the table
        String specificCellValue = driver.findElement(By.xpath("//table[@class='ui celled striped table']//tr[2]/td[2]")).getText();
        System.out.println("Cell value of 2nd row & 2nd column in the table is :"+ " " + specificCellValue);

        driver.close();
    }
}
