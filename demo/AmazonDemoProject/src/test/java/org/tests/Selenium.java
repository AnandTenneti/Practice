package org.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.HashSet;
import java.util.List;

public class Selenium {
    static ExtentReports extentReport;
    static ExtentTest extentTest;
    public static void main(String args[]) {
        HashSet t = new HashSet();

        WebDriver driver;
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://www.google.com");
        driver.findElement(By.name("q")).sendKeys("Selenium" + Keys.ENTER);
        Actions act = new Actions(driver);
        act.scrollByAmount(0, 750).perform();
               List<WebElement> questions = driver.findElements(By.xpath("//span[@jsname='r4nke']"));
        for (WebElement question : questions) {
            System.out.println(question.getText());
        }
        driver.quit();
        int a[] = {0,2,3,4,1};
        System.out.println(a[1]);

    }
}
