package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class GooglePage {

    public static void main(String args[]) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.google.com");
        driver.findElement(By.xpath("//textarea")).sendKeys("anand");
        Thread.sleep(5000);
//        WebElement suggestionList = driver.findElement(
//                By.xpath("//div//ul/li[@data-attrid='AutocompletePrediction']" +
//                        "//div[@aria-description='1971 film']"));
//
//
//        suggestionList.click();


        List<WebElement> suggestionsList = driver.findElements(By.xpath("//div//ul/li[@data-attrid='AutocompletePrediction']"));
        for(WebElement suggestions: suggestionsList) {
            suggestions.findElement(By.xpath("//div[@aria-description='1971 film']")).click();
                break;
            }
       // }

        Thread.sleep(10000);
        driver.quit();
    }
}
