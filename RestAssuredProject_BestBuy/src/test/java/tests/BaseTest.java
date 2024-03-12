package tests;

import com.aventstack.extentreports.Status;
import io.restassured.RestAssured;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import request.RequestFactory;
import utils.ConfigRead;
import utils.ExtentReportUtils;

import java.io.IOException;
import java.util.Properties;

public class BaseTest {

    RequestFactory requestFactory;
    Properties configProperties;
    String configFileName;
    String currentWorkingDirectory;

    String htmlReportFileName;

    ExtentReportUtils extentReportUtils;

    @BeforeSuite
    public void preSetUp() throws IOException {
        currentWorkingDirectory = System.getProperty("user.dir");
        configFileName = currentWorkingDirectory + "/src/test/resources/config/config.properties";
        htmlReportFileName = currentWorkingDirectory + "/src/test/resources/reports/htmlReport.html";
        configProperties = ConfigRead.configProperties(configFileName);
        extentReportUtils = new ExtentReportUtils(htmlReportFileName);

    }

    @BeforeClass
    public void setUp() {
        extentReportUtils.createTestCase("setup: load all configurations");
        RestAssured.baseURI = configProperties.getProperty("baseUri");
        RestAssured.port = Integer.parseInt(configProperties.getProperty("portNumber"));
        extentReportUtils.addLog(Status.INFO, "Info level");
        requestFactory = new RequestFactory();
    }
    @AfterMethod
    public void testStatusCheck(ITestResult result) {
        String testName = result.getName();
        if(result.getStatus()==ITestResult.SUCCESS) {
            extentReportUtils.addLog(Status.PASS, "Test case passed");
        } else if(result.getStatus()==ITestResult.FAILURE){
            extentReportUtils.addLog(Status.FAIL, "Test Case failed");
        } else {
            extentReportUtils.addLog(Status.SKIP, "Test Case skipped");
        }
    }

    @AfterClass
    public void cleanUp() {
        RestAssured.reset();
        extentReportUtils.closeReport();
    }
}
