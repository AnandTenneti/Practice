package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

public class LoginPage extends LoadableComponent<LoginPage> {

     WebDriver driver;

    @Override
    public void load() {
    }

    @Override
    public void isLoaded() {
    }

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.ID, using = "Email")
    private WebElement emailField;

    @FindBy(how = How.ID, using = "Password")
    private WebElement passwordField;

    @FindBy(how = How.CSS, using = "button.login-button")
    private WebElement btnLogin;

    @FindBy(how = How.LINK_TEXT, using = "Logout")
    private WebElement lnkLogout;


    public void setUserName(String userName) {
        emailField.clear();
        emailField.sendKeys(userName);
    }

    public void setPassword(String pwd) {
        passwordField.clear();
        passwordField.sendKeys(pwd);
    }

    public void clickLogin() {
        btnLogin.click();
    }

    public void clickLogout() {
        lnkLogout.click();
    }
}
