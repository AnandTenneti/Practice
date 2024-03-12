package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ProductsPage extends LoadableComponent<ProductsPage> {

    public WebDriver driver;

    public void load() {
    }

    public void isLoaded() {
    }

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "//p[contains(text(),'Sales')]")
    private List<WebElement> catalogMenu;

    @FindBy(how = How.XPATH, using = "//a[@href='/Admin/Product/Create']")
    private WebElement addNewButton;

    @FindBy(how = How.NAME, using = "save")
    private WebElement saveButton;
    @FindBy(how = How.ID, using = "Name")
    private WebElement productName;
    @FindBy(how = How.ID, using = "ShortDescription")
    private WebElement shortDescription;
    @FindBy(how = How.CSS, using = "ul#SelectedCategoryIds_listbox li")
    private List<WebElement> categoryIds;

    @FindBy(how = How.CSS, using = "div.alert.alert-success.alert-dismissable")
    private WebElement alertMessage;

    @FindBy(how = How.ID, using = "SearchProductName")
    private WebElement searchProductName;

    @FindBy(how = How.ID, using = "search-products")
    private WebElement searchButtonInProducts;

    @FindBy(how = How.CSS, using = "button.dropdown-toggle")
    private WebElement exportDropdownToggle;


    @FindBy(how = How.ID, using = "exportexcel-selected")
    private WebElement exportSelectedProductsInExcel;

    @FindBy(how = How.ID, using = "exportExcelSelected-info")
    private WebElement alertMessageForExportSelected;


    public void clickOnCatalogMenu() throws Exception {
        List<WebElement> sidebarMenus = driver.findElements(By.cssSelector("ul.nav-sidebar li"));
        for (WebElement sidebarMenu : sidebarMenus) {
            if (sidebarMenu.getText().equals("Catalog")) {
                System.out.println(sidebarMenu.getText());
                sidebarMenu.click();
            }
        }
    }

    public void setProductName() {
        productName.sendKeys("Philips");
    }

    public void addProductDescription() {
        shortDescription.sendKeys("This ia an awesome product");
    }

    public void clickOnAddNewButton() {
        addNewButton.click();
    }

    public void selectProductCategory() {
        driver.findElement(By.cssSelector("input.k-input")).click();
        for (WebElement categoryId : categoryIds) {
            if (categoryId.getText().equals("Computers")) {
                categoryId.click();
                break;
            }
        }
        driver.findElement(By.cssSelector("input.k-input")).sendKeys(Keys.TAB);
    }

    public void clickOnProductsMenuItem() {
        WebElement productsMenuItem = driver.findElement(
                By.xpath("//a[@href='/Admin/Product/List']//p[contains(text(),'Products')]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", productsMenuItem);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public void saveProductDetails() {
        saveButton.click();
    }

    public String getMessage() {
        return alertMessage.getText();
    }

    public void enterProductName() throws Exception {
        searchProductName.sendKeys("Windows 8 Pro");
        Thread.sleep(5000);
    }

    public void clickOnSearchButton() throws Exception {
        searchButtonInProducts.click();
        Thread.sleep(3000);
    }

    public void clickOnImportButton() {
        driver.findElement(By.name("importexcel")).click();
    }

    public void clickonExport() {
        exportDropdownToggle.click();
        exportSelectedProductsInExcel.click();
    }

    public String verifyAlertMessage() {
        return alertMessageForExportSelected.getText();
    }

}
