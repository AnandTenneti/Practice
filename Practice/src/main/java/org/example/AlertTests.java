package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import javax.xml.transform.sax.SAXResult;
import java.util.ArrayList;
import java.util.Objects;

public class AlertTests {

    @Test
   public void testAlert() throws Exception {
//        WebDriverManager.chromedriver().setup();
//        ;
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://demo.guru99.com/test/delete_customer.php");
//        driver.findElement(By.name("submit")).click();
//        Thread.sleep(15000);
//        Alert alert = driver.switchTo().alert();
//        alert.accept();
//        //String alertMessage = driver.switchTo().alert().getText();
//        //System.out.println(alertMessage);
//        Thread.sleep(5000);
//        driver.switchTo().alert();
//        alert.accept();
//        Thread.sleep(10000);
//        driver.quit();
        ArrayList<String> arrList = new ArrayList<>(5);
        arrList.add("a");
        arrList.add("b");
        arrList.add("c");
        arrList.add("d");
        arrList.add("a");
        System.out.println(arrList);
        for (int i = 0; i < arrList.size() - 1; i++) {
            if (arrList.get(i).equals(arrList.get(i + 1))) {
                arrList.remove(i);
            }
        }
        System.out.println(arrList);

    }
}
