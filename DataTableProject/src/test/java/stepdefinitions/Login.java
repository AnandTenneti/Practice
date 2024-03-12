package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class Login {

    WebDriver driver;

    @Before
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }

    @Given("User is on HRMLogin page")
    public void userOnHomePage() {
        driver.get("https://opensource-demo.orangehrmlive.com/");
    }

    @When("User enters valid credentials")
    public void entersValidCredential(DataTable dataTable) throws InterruptedException{

        System.out.println("Credentials Entered");

        List<List<String>> signUpForm = dataTable.asLists(String.class);
        String userName = signUpForm.get(0).get(0);
        String passWord = signUpForm.get(0).get(1);
        driver.findElement(By.name("username")).sendKeys(userName);
        driver.findElement(By.name("password")).sendKeys(passWord);
        driver.findElement(By.xpath("//*[@class='oxd-form']/div[3]/button")).submit();
    }

    @Then("User should be able to login successfully and new page open")
    public void successfulLogin() throws InterruptedException {

        String newPageText = driver.findElement(By.xpath("//*[@class='oxd-topbar-header-breadcrumb']/h6")).getText();
        System.out.println("newPageText :" + newPageText);
        assertThat(newPageText, containsString("Dashboard"));
    }

    @After
    public void teardown(){
        driver.quit();
    }
}
