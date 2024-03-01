package org.example;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.*;
import java.util.Scanner;

public class CSVFileReadTests {
    ExtentSparkReporter htmlReporter;
    ExtentReports extent;
    ExtentTest test1, test2, test3;

    static String CSV_FILE_PATH = "/Users/tennetikiran/IdeaProjects/Practice/src/main/resources/testFile.csv";

    @BeforeSuite
    public void setup() {
        htmlReporter = new ExtentSparkReporter("extentReport_csv.html");
//create ExtentReports and attach reporter(s)
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }

    @Test
    public void CSVFileReadUsingScanner() throws FileNotFoundException {
        test1 = extent.createTest("read using Scanner CSV file Test", "test to validate search box ");
        test1.log(Status.INFO, "Starting test case");
        Scanner sc = new Scanner(new File(CSV_FILE_PATH));
        sc.useDelimiter(",");
        while (sc.hasNext()) {
            System.out.println(sc.next());
        }
        sc.close();

    }

    @Test
    public void CSVFileReadUsingSplitByDelimiter() throws IOException {
        test2 = extent.createTest("read using split stringfile Test", "test to validate search box ");
        test2.log(Status.INFO, "Starting test case");
        String line = "";
        String splitBy = ",";
        BufferedReader br = new BufferedReader(new FileReader(CSV_FILE_PATH));
        while ((line = br.readLine()) != null) {
            String[] employeeDetails = line.split(splitBy);
            System.out.println(
                    "Employee [First Name + Last Name =" + employeeDetails[0] +
                            ", Designation=" + employeeDetails[1] +
                            ", Contact=" + employeeDetails[2] +
                            ", Salary= " + employeeDetails[3] +
                            ", City= " + employeeDetails[4] + "]");
        }
    }

    @Test(priority = 3)
    public void CSVFileReadUsingOpenCSV() throws IOException {
        System.out.println("File Read using Open CSV");
        test3 = extent.createTest("read using split stringfile Test", "test to validate search box ");
        test3.log(Status.INFO, "Starting test case");
        CSVReader reader = null;
        try {
            reader = new CSVReader(new FileReader(CSV_FILE_PATH));
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                for (String token : nextLine) {
                    System.out.println(token);
                }
                System.out.println("\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterSuite
    public void tearDown() {
        test1.info("test1 completed");
        test2.info("test2 completed");
        test1.info("test3 completed");
        //write results into the file
        extent.flush();
    }
}
