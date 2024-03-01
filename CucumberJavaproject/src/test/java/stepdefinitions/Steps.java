package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import pageObjects.LoginPage;

public class Steps {

    WebDriver driver;
    LoginPage loginPage;

    @Given("User launch chrome browser")
    public void user_launch_chrome_browser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
    }

    @When("User opens URL 'http:\\/\\/admin-demo.nopcommerce.com\\/login")
    public void user_opens_url_http_admin_demo_nopcommerce_com_login() {
        driver.get("http://admin-demo.nopcommerce.com/login");
    }

    @When("User enters Email as {string} and Password as {string}")
    public void user_enters_email_as_and_password_as(String userEmail, String userPassword) {
        loginPage.setUserName(userEmail);
        loginPage.setPassword(userPassword);
    }

    @And("click on Login button")
    public void clickOnLoginButton() {
        loginPage.clickLogin();
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
}
