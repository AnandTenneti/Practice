package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

public class CustomerPage extends LoadableComponent<CustomerPage> {
    private WebDriver driver;

    public CustomerPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void load() {
    }

    public void isLoaded() {
    }

    @FindBy(how = How.XPATH, using = "//a[@href='/Admin/Customer/Create']")
    private WebElement addNewBtn;

    @FindBy(how = How.ID, using = "Email")
    private WebElement email;

    @FindBy(how = How.ID, using = "Password")
    private WebElement password;

    @FindBy(how = How.ID, using = "//a[@href='/Admin/Customer/Create']")
    private WebElement addNewButton;

    @FindBy(how = How.XPATH, using = "//button[@name='save']")
    private WebElement saveButton;

    @FindBy(how = How.CSS, using = "div.alert.alert-success.alert-dismissable")
    private WebElement alertMessage;

    @FindBy(how = How.XPATH, using = "//div/h1[contains(text(),'Dashboard')]")
    private WebElement dashboardHeader;

    @FindBy(how = How.XPATH, using = "//p[contains(text(),'Customers')]")
    private WebElement customersMenu;

    @FindBy(how = How.ID, using = "FirstName")
    private WebElement firstName;

    @FindBy(how = How.ID, using = "LastName")
    private WebElement lastName;

    @FindBy(how = How.ID, using = "Email")
    private WebElement emailField;


    public void clickOnSaveButton() {
        saveButton.click();
    }

    public String getMessage() {
        return alertMessage.getText();
    }

    public String getDashboardHeader() {
        return dashboardHeader.getText();
    }

    public void clickOnCustomersMenu() {
        customersMenu.click();
    }

    public void clickOnCustomersMenuItem() {
        WebElement customersMenuItem = driver.findElement(
                By.xpath("//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", customersMenuItem);
    }

    public void clickOnAddNewButton() {
        addNewBtn.click();
    }

    public void setEmail(String email) {
        emailField.sendKeys(email);
    }
    public void setFirstName(String fname) {
        firstName.sendKeys(fname);
    }
    public void setLastName(String lname) {
        lastName.sendKeys(lname);
    }


}
