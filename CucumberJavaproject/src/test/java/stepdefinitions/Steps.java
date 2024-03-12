package stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.datatable.DataTable;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import pageObjects.LoginPage;

import java.util.List;

public class Steps {

    WebDriver driver;
    LoginPage loginPage;
    @Before
    public void setup() {
        System.out.println("Hello, Execution of test started");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
//
//    @When("User opens URL {string}")
//    public void user_opens_url(String URL) {
//       // loginPage = new LoginPage(driver);
//        driver.get(URL);
//    }

//    @When("User opens URL 'http:\\/\\/admin-demo.nopcommerce.com\\/login")
//    public void user_opens_url_http_admin_demo_nopcommerce_com_login() {
//        driver.get("http://admin-demo.nopcommerce.com/login");
//    }

    @And("User enters Email as {string} and Password as {string}")
    public void user_enters_email_as_and_password_as(String userEmail, String userPassword) {
        loginPage.setUserName(userEmail);
        loginPage.setPassword(userPassword);
    }

    @And("click on Login button")
    public void clickOnLoginButton() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.clickLogin();
        Thread.sleep(5000);
    }

    @Then("Page title should be {string}")
    public void page_title_should_be(String title) {
        if (driver.getPageSource().contains("Login was unsuccessful")) {
            driver.close();
            Assert.assertTrue(false);
        } else {
            Assert.assertEquals(title, driver.getTitle());
        }
    }

    @When("User clicks on Logout button")
    public void user_clicks_on_logout_button() throws Exception {
        loginPage.clickLogout();
        Thread.sleep(300);
    }

    @Then("Close browser")
    public void close_browser() {
        driver.quit();
    }


    //    @When("user enters valid credentials")
//    public void userEntersValidCredentials(DataTable dataTable) {
//        List<List<String>> signInForm = dataTable.asLists(String.class);
//        String userName = signInForm.get(0).get(0);
//        String password = signInForm.get(0).get(1);
//        loginPage.setUserName(userName);
//        loginPage.setPassword(password);
//    }
    @And("user enters valid credentials")
    public void user_enters_valid_credentials(io.cucumber.datatable.DataTable dataTable) {
        List<List<String>> signInForm = dataTable.asLists(String.class);
        String userName = signInForm.get(0).get(0);
        String password = signInForm.get(0).get(1);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUserName(userName);
        loginPage.setPassword(password);
    }

    @And("User enters email {string} and Password {string}")
    public void userEntersEmailAndPassword(String userEmail, String userPassword) {
        loginPage.setUserName(userEmail);
        loginPage.setPassword(userPassword);
    }

    @When("User opens URL as {string}")
    public void userOpensURLAsHttpAdminDemoNopcommerceComLogin() {
        driver.get("http://admin-demo.nopcommerce.com/login");
    }

    @When("User opens {string}")
    public void userOpens(String URL) {
        loginPage = new LoginPage(driver);
        URL =  "http://admin-demo.nopcommerce.com/login";
        driver.get(URL);
    }
}
