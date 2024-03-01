package org.example;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;


import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.annotations.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import com.aventstack.extentreports.ExtentReports;


public class FileReadTests {
    ExtentSparkReporter htmlReporter;
    ExtentReports extent;
    ExtentTest test1, test2, test3;

    public static String FILE_PATH = "/Users/tennetikiran/IdeaProjects/Practice/src/main/resources/TestFile.txt";
    File file = new File(FILE_PATH);

    @BeforeSuite
    public void setup() {
        htmlReporter = new ExtentSparkReporter("extentReport.html");
//create ExtentReports and attach reporter(s)
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }


    @Test(priority = 1)
    public void readUsingFileReader() throws IOException {
        test1 = extent.createTest("read using FileReader Test", "test to validate search box ");
        test1.log(Status.INFO, "Starting test case");
        FileReader fr = new FileReader(file);
        int i;
        while ((i = fr.read()) != -1) {
            System.out.println((char) i);
        }
    }

    @Test(priority = 2)
    public void readUsingBufferedReader() throws IOException {
        test2 = extent.createTest("BuffeeredReader Test", "test to validate search box ");
        test2.log(Status.INFO, "Starting test case");
        File file = new File(FILE_PATH);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        while ((st = br.readLine()) != null) {
            System.out.println(st);
        }

    }

    @Test(priority = 3)
    public void readUsingScanner() throws IOException {
        test3 = extent.createTest("Scanner read Test", "test to validate search box ");
        test3.log(Status.INFO, "Starting test case");

        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()) {
            System.out.println(sc.nextLine());
        }

    }
    @AfterSuite
    public void tearDown() {

       // test1.info("test1 completed");
        //test2.info("test2 completed");
        test3.info("test3 completed");

        //write results into the file
        extent.flush();
    }

}



