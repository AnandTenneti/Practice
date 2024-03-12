//package stepdefinitions;
//
//import io.cucumber.java.en.And;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import org.openqa.selenium.WebDriver;
//import pageObjects.LoginPage;
//import pageObjects.ProductsPage;
//
//public class ProductSteps extends BaseClass {
//    WebDriver driver;
//
//    LoginPage loginPage;
//
//    ProductsPage productsPage;
//
//
//    @And("user clicks on Products menu item")
//    public void userClicksOnProductsMenuItem() {
//
//    }
//
//    @When("user clicks on Catalog menu")
//    public void user_clicks_on_catalog_menu() throws Exception {
//        ProductsPage productsPage = new ProductsPage(driver);
//        productsPage.clickOnCatalogMenu();
//
//    }
//
//    @And("user clicks on Add new button")
//    public void userClicksOnAddNewButton() {
//
//    }
//
//    @Then("user can view Add new product page")
//    public void userCanViewAddNewProductPage() {
//    }
//
//    @When("user enter product info")
//    public void userEnterProductInfo() {
//        productsPage.setProductName();
//        productsPage.addProductDescription();
//        productsPage.selectProductCategory();
//
//    }
//}
