package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class Activity14 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        //Launching the page URL
        driver.get("https://www.training-support.net/selenium/tables");
        Thread.sleep(1000);

        //Getting Home page Title
        String pageTitle = driver.getTitle();
        System.out.println("Title of the Page is : " + " " +pageTitle);

       //Finding the number of Rows and Columns from the Second table
        int fRow = driver.findElements(By.xpath("//table[@id='sortableTable']//tr")).size();
        System.out.println("Number of Rows in the Second table are: " + " " +fRow);

        int fCol = driver.findElements(By.xpath("//table[@id='sortableTable']//tr/td")).size();
        System.out.println("Number of Columns in the Second table are: " + " " +fCol);

        //Finding and Printing the cell value at 2nd row & 2nd column in the table
        String specificCellValue = driver.findElement(By.xpath("//table[@id='sortableTable']//tr[2]/td[2]")).getText();
        System.out.println("Cell value of 2nd row & 2nd column in the table is :"+ " " + specificCellValue);

        //Clicking on 1st Header to sort the Table
        driver.findElement(By.xpath("//th[text()='Name']")).click();
        Thread.sleep(3000);

        //Finding and Printing the cell value at 2nd row & 2nd column in the table post sorting
        String specificCellValueAfterSort = driver.findElement(By.xpath("//table[@id='sortableTable']//tr[2]/td[2]")).getText();
        System.out.println("Cell value of 2nd row & 2nd column in the table post Sorting is :"+ " " + specificCellValueAfterSort);

        //Printing the cell values of the Footer table
        List<WebElement> cellValues = driver.findElements(By.xpath("//table[@id='sortableTable']//tr/td"));
        System.out.println("Following are the cell values from the table");
        for (WebElement cellVal :  cellValues) {
            System.out.println(cellVal.getText());
        }

        driver.close();
    }
}
