package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

import java.util.List;

public class SearchCustomerPage extends LoadableComponent<SearchCustomerPage> {
    private WebDriver driver;

    public void load() {
    }

    public void isLoaded() {
    }

    public SearchCustomerPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.ID, using = "SearchEmail")
    private WebElement txtEmail;

    @FindBy(how = How.ID, using = "SearchFirstName")
    private WebElement txtFirstName;

    @FindBy(how = How.ID, using = "SearchLastName")
    private WebElement txtLastName;

    @FindBy(how = How.ID, using = "search-customers")
    @CacheLookup
    private WebElement searchCustomers;

    @FindBy(how = How.XPATH, using = "//table[@id='customers-grid']//tbody/tr")
    private List<WebElement> searchTableResults;

    @FindBy(how = How.ID, using = "//table[@id='customers-grid']")
    private WebElement table;

    @FindBy(how = How.XPATH, using = "//table[@id='customers-grid']//tbody/tr")
    List<WebElement> tableRows;

    @FindBy(how = How.XPATH, using = "//table[@id='customers-grid']//tbody/tr/td")
    List<WebElement> tableColumns;


    public void setEmail(String email) {
        txtEmail.sendKeys(email);
    }

    public void setFirstName(String fname) {
        txtFirstName.sendKeys(fname);
    }

    public void setLastName(String lname) {
        txtLastName.sendKeys(lname);
    }

    public void clickOnSearchButton() {

        searchCustomers.click();
    }

    public int getNumberOfRows() {
        return tableRows.size();

    }

    public int getNumberOfColumns() {
        return tableColumns.size();
    }

   public int searchCustomerByEmail() {
       List<WebElement> emailIds = driver.findElements(By.xpath("//table[@id='customers-grid']/tbody/tr[1]/td[2]"));
       int size = emailIds.size();
       return size;

//        boolean flag = false;
//        for (int i = 1; i <= getNumberOfRows(); i++) {
//            String emailId = driver.findElement(
//                            By.xpath("//table/tbody/tr/td[contains(text(),'victoria_victoria@nopCommerce.com')]"))
//                    .getText();
//            if (emailId.equals(email)) {
//                flag = true;
//            }
//        }
//        return flag;
    }

    public int searchCustomerByName() {
        String customerName = "";
        // for (int i = 1; i <= getNumberOfRows(); i++) {
        List<WebElement> names = driver.findElements(By.xpath("//table[@id='customers-grid']/tbody/tr[1]/td[3]"));
        int size = names.size();
        return size;

    }


}

