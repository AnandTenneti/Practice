package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Map;

public class InvalidLogin {

    WebDriver driver;

    @Before
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Given("User is on OpenHRMLogin page")
    public void userOnLoginPage() {
        driver.get("https://opensource-demo.orangehrmlive.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }



    @After
    public void teardown(){
        driver.quit();
    }

    @Then("User enters invalid credentials and Login will be unsuccessful with error message")
    public void user_enters_invalid_credentials_and_login_will_be_unsuccessful_with_error_message(io.cucumber.datatable.DataTable dataTable) throws Exception {
        System.out.println("Enter Credentials");
        List<Map<String, String>> user = dataTable.asMaps(String.class, String.class);
        String userName = user.get(0).get("Username");
        System.out.println("Username :" + userName);
        driver.findElement(By.name("username")).sendKeys(userName);
        String passWord = user.get(0).get("Password");
        System.out.println("Password :" + passWord);
        driver.findElement(By.name("password")).sendKeys(passWord);

        driver.findElement(By.xpath("//*[@class='oxd-form']/div[3]/button")).submit();

        String errorMessage = user.get(0).get("ErrorMessage");
        String actualErrorMessage = driver.findElement(By.xpath("//*[@class='orangehrm-login-error']/div[1]/div[1]/p")).getText();
        System.out.println("Actual Error Message :" + actualErrorMessage);
        Assert.assertTrue(actualErrorMessage.equalsIgnoreCase(errorMessage));
    }


    @Given("User is in HRMLogin page")
    public void user_is_in_hrm_login_page() {
        driver.get("https://opensource-demo.orangehrmlive.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }
}
