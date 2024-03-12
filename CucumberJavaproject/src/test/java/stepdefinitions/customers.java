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
import pageObjects.ProductsPage;
import pageObjects.SearchCustomerPage;

import java.io.IOException;

public class customers extends BaseClass {

    WebDriver driver;
    LoginPage loginPage;
    CustomerPage customerPage;

    SearchCustomerPage srchCustomerPage;

    ProductsPage productsPage;

    @Before
    public void setup() {
        System.out.println("Hello, Execution of test started");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }


    @When("User opens URL {string}")
    public void user_opens_url(String URL) {
        loginPage = new LoginPage(driver);
        driver.get(URL);
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
//
//    @Then("close browser")
//    public void close_browser() {
//        driver.quit();
//    }


    @When("Enter customer Email")
    public void enter_customer_email() {
        srchCustomerPage = new SearchCustomerPage(driver);
        srchCustomerPage.setEmail("abcd@gmail.com");
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
    public void click_on_search_button() throws InterruptedException {
        SearchCustomerPage srchCustomerPage = new SearchCustomerPage(driver);
        srchCustomerPage.clickOnSearchButton();
        Thread.sleep(4000);
    }

    @Then("User should find Name in the Search table")
    public void user_should_find_name_in_the_search_table() {
        SearchCustomerPage srchCustomerPage = new SearchCustomerPage(driver);
        int customerNameList = srchCustomerPage.searchCustomerByName();
        Assert.assertEquals(1, customerNameList);
    }

    @When("user clicks on Catalog menu")
    public void user_clicks_on_catalog_menu() throws Exception {
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.clickOnCatalogMenu();

    }

    @And("user clicks on Products menu item")
    public void user_clicks_on_products_menu_item() {
        productsPage = new ProductsPage(driver);
        productsPage.clickOnProductsMenuItem();
    }

    @And("user clicks on Add new button")
    public void userClicksOnAddNewButton() {
        productsPage.clickOnAddNewButton();
    }

    @Then("user can view Add new product page")
    public void userCanViewAddNewProductPage() {
        String pageTitle = "Add a new product";
        Assert.assertTrue(productsPage.getPageTitle().contains(pageTitle));
    }

    @When("user enter product info")
    public void user_enter_product_info() throws InterruptedException {
        productsPage.setProductName();
        productsPage.addProductDescription();
        Thread.sleep(5000);
        productsPage.selectProductCategory();
        Thread.sleep(5000);
    }

    @When("click on Export button with selected products option")
    public void click_on_export_button_with_selected_products_option() throws Exception{
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.clickonExport();
        Thread.sleep(5000);
    }

    @Then("User can view {string} message is displayed")
    public void user_can_view_message_is_displayed(String string) {
       productsPage = new ProductsPage(driver);
       Assert.assertTrue(productsPage.verifyAlertMessage().contains(string));
    }

    @And("click on Product Save button")
    public void clickOnProductSaveButton() {
        productsPage.saveProductDetails();
    }

    @Then("User can view product configuration message {string}")
    public void user_can_view_product_configuration_message(String message) {
        // Assert.assertEquals(message, customerPage.getMessage());
        Assert.assertTrue(productsPage.getMessage().contains(message));
    }

    @After
    public void close() {
        driver.quit();
    }

    @When("Enter Product Name")
    public void enter_product_name() throws Exception {
        productsPage.enterProductName();
        Thread.sleep(5000);
    }


    @When("click on Search button in Products")
    public void clickOnSearchButtonInProducts() throws Exception {
        productsPage.clickOnSearchButton();
    }

    @When("user enters invalid email address")
    public void user_enters_invalid_email_address() {
        customerPage.setEmail("a");
    }

    @Then("User can view validation message {string}")
    public void user_can_view_validation_message(String emailErrorMessage) {
        emailErrorMessage = "Please enter a valid email address.";
        Assert.assertEquals(emailErrorMessage, customerPage.getEmailValidationErrorMessage());
    }

    @When("select the result and click on Delete button")
    public void select_the_result_and_click_on_delete_button() throws Exception {
        srchCustomerPage.clickOnEditButton();
        customerPage = new CustomerPage(driver);
        customerPage.clickOnDeleteButton();
        Thread.sleep(10000);
        Assert.assertTrue(customerPage.isModalDisplayed());
        customerPage.clickOnDeleteInConfirmationDialog();
        Thread.sleep(10000);
    }

    @And("click on Import button")
    public void click_on_import_button() throws Exception {
        customerPage = new CustomerPage(driver);
        customerPage.clickOnImportButton();
        Thread.sleep(10000);
    }
}
