package pages;

import base.BasePage;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.Log;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//input[@id='user-name']")
    WebElement usernameField;
    @FindBy(xpath = "//input[@id='password']")
    WebElement passwordField;
    @FindBy(xpath = "//input[@id='login-button']")
    WebElement loginBtn;

    /**
     * Constructor initializes the WebDriver instance, WebDriverWait, logger,
     * and uses the PageFactory to initialize all WebElements defined in the child classes.
     *
     * @param driver the WebDriver instance used by the page
     */
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void loginUser(String username, String password) {
        Log.getLogger(LoginPage.class).info("Sign in user");
        if(username == null || password == null || username.isEmpty() || password.isEmpty()) {
            throw new IllegalArgumentException("Please provide valid string for username and password");
        }

        driver.get(configReader.getProperty("loginUrl"));
        sendKeys(usernameField, username);
        sendKeys(passwordField, password);
        click(loginBtn);
    }

    public boolean hasUserLoggedIn() {

        try{
            return wait.until(ExpectedConditions.urlToBe(configReader.getProperty("afterLoginUrl")));
        }catch (TimeoutException e) {
            return false;
        }
    }
}
