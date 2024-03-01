package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import pageObjects.CustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;

public class customers extends BaseClass {

    WebDriver driver;
    LoginPage loginPage;
    CustomerPage customerPage;

    SearchCustomerPage srchCustomerPage;


    @Given("Launch chrome browser")
    public void launch_chrome_browser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

    }

    @When("User opens URL {string}")
    public void user_opens_url(String URL) {
        loginPage = new LoginPage(driver);
        URL = "http://admin-demo.nopcommerce.com/login";
        driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
    }

    @When("User enters email as {string} and Password as {string}")
    public void user_enters_email_as_and_password_as(String email, String password) {
        loginPage.setUserName(email);
        loginPage.setPassword(password);
    }

    @And("click on Login")
    public void clickOnLogin() {
        loginPage.clickLogin();
    }

    @Then("User can view Dashboard")
    public void user_can_view_dashboard() throws Exception {
        CustomerPage customerPage = new CustomerPage(driver);
        Assert.assertTrue(customerPage.getDashboardHeader().contains("Dashboard"));
    }


    @When("User clicks on customers menu")
    public void user_clicks_on_customers_menu() {
        customerPage = new CustomerPage(driver);
        customerPage.clickOnCustomersMenu();
    }

    @When("click on customers Menu Item")
    public void click_on_customers_menu_item() {
        customerPage.clickOnCustomersMenuItem();
    }

    @When("click on Add new button")
    public void click_on_add_new_button() {
        customerPage.clickOnAddNewButton();
    }

    @Then("User can view Add new customer page")
    public void user_can_view_add_new_customer_page() {
        String title = "Add a new customer";
        Assert.assertTrue(driver.getTitle().contains(title));
    }

    @When("User enter customer info")
    public void user_enter_customer_info() {
        String email = randomString() + "@example.com";
        customerPage.setEmail(email);
        customerPage.setFirstName("Anand");
        customerPage.setLastName("Kiran");
    }

    @When("click on Save button")
    public void click_on_save_button() {
        customerPage = new CustomerPage(driver);
        customerPage.clickOnSaveButton();
    }

    @Then("User can view configuration message {string}")
    public void user_can_view_configuration_message(String message) {
        // Assert.assertEquals(message, customerPage.getMessage());
        Assert.assertTrue(customerPage.getMessage().contains(message));
    }

    @Then("close browser")
    public void close_browser() {
        driver.quit();
    }


    @When("Enter customer Email")
    public void enter_customer_email() {
        srchCustomerPage = new SearchCustomerPage(driver);
        srchCustomerPage.setEmail("victoria_victoria@nopCommerce.com");
    }

    @Then("User should find Email in the Search table")
    public void user_should_find_email_in_the_search_table() {
        SearchCustomerPage srchCustomerPage = new SearchCustomerPage(driver);
        int customerEmailList = srchCustomerPage.searchCustomerByEmail();
        Assert.assertEquals(1, customerEmailList);

//       // boolean status = srchCustomerPage.searchCustomerByEmail("victoria_victoria@nopCommerce.com");
//        Assert.assertTrue(status);
    }

    @And("Enter customer Firstname")
    public void enter_customer_firstname() {
        SearchCustomerPage srchCustomerPage = new SearchCustomerPage(driver);
        srchCustomerPage.setFirstName("Victoria");
    }

    @And("Enter customer LastName")
    public void enter_customer_last_name() {
        SearchCustomerPage srchCustomerPage = new SearchCustomerPage(driver);
        srchCustomerPage.setLastName("Terces");
    }

    @When("click on Search button")
    public void click_on_search_button() {
        SearchCustomerPage srchCustomerPage = new SearchCustomerPage(driver);
        srchCustomerPage.clickOnSearchButton();
    }

    @Then("User should find Name in the Search table")
    public void user_should_find_name_in_the_search_table() {
        SearchCustomerPage srchCustomerPage = new SearchCustomerPage(driver);
        int customerNameList = srchCustomerPage.searchCustomerByName();
        Assert.assertEquals(1, customerNameList);
    }
}
