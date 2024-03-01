package org.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.concurrent.TimeUnit;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class LoginPageDefinitions {
    WebDriver driver;

    @Before
    public void setup() {
        System.out.println("------------------Before Executing-------------------------");
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @BeforeStep
    public void beforeStepTest() {
        System.out.println("--------------BeforeStep Executing---------------");
    }

    @Given("User is on HRMLogin page")
    public void userOnHomePage() {
        System.out.println("Open Website");
        driver.get("https://opensource-demo.orangehrmlive.com/");
    }

    @When("User enters username as {string}")
    public void entersUsername(String userName){
        System.out.println("Enter username");
        driver.findElement(By.name("username")).sendKeys(userName);

    }

    @When("User enters password as {string}")
    public void entersPassword(String passWord) {
        System.out.println("Enter passWord");
        driver.findElement(By.name("password")).sendKeys(passWord);
        driver.findElement(By.xpath("//*[@id='app']/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).submit();

    }

    @Then("User should be able to login successfully")
    public void successfulLogin() throws InterruptedException {
        String newPageText = driver.findElement(By.xpath("//span[@class='oxd-topbar-header-breadcrumb']/h6")).getText();
        System.out.println("newPageText:" + newPageText);
        assertThat(newPageText, containsString("Dashboard"));
    }

    @AfterStep
    public void afterStepTest() {
        System.out.println("--------------------AfterStep Executing---------------------");
    }

    @After
    public void close() {
        driver.quit();
        System.out.println("--------------------After Executing-----------------------");
    }
}
