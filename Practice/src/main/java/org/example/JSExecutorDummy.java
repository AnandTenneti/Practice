package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class JSExecutorDummy {
     WebDriver driver;
     @Test
    public void testMethods() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://www.gmail.com");
        driver.manage().window().maximize();

         JavascriptExecutor js = (JavascriptExecutor) driver;
         // 1.  Passing values without using sendKeys
         js.executeScript("document.getElementById('identifierId').value='tenneti.anand';");

         WebElement loginButton = driver.findElement(By.xpath("//button[@jsname='LgbsSe']//span[contains(text(),'Next')]"));
         // 2. Click on a button
         js.executeScript("arguments[0].click();", loginButton);
         // 3. Get the title
         String sText =  js.executeScript("return document.title;").toString();
         System.out.println(sText);
        // 4. Get the domain
         String sText1 =  js.executeScript("return document.domain;").toString();
         System.out.println(sText1);

         js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

         // 5. Refresh browser window
         js.executeScript("history.go(0)");
        // 6. Alert
        js.executeScript("alert('Hello there');");
        driver.quit();
    }
}
