package base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import org.slf4j.Logger;
import utils.ConfigReader;
import utils.Log;

public abstract class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Logger logger;
    protected ConfigReader configReader;

    /**
     * Constructor initializes the WebDriver instance, WebDriverWait, logger,
     * and uses the PageFactory to initialize all WebElements defined in the child classes.
     *
     * @param driver the WebDriver instance used by the page
     */
    public BasePage(WebDriver driver) {
        this.driver = driver;
        // Define an explicit wait with a default timeout (adjust as needed)
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Initialize logger (using SLF4J)
        this.logger = Log.getLogger(this.getClass());
        configReader = new ConfigReader();
        // Initialize web elements annotated with @FindBy in child classes
        PageFactory.initElements(driver, this);
    }

    /**
     * Waits until the provided element is visible on the page.
     *
     * @param element the WebElement to wait for
     */
    protected void waitForVisibility(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Waits until the provided element is clickable.
     *
     * @param element the WebElement to wait for
     */
    protected void waitForClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * Clicks on the given WebElement after waiting for it to be clickable.
     *
     * @param element the WebElement to click
     */
    protected void click(WebElement element) {
        waitForClickable(element);
        element.click();
        logger.info("Clicked on element: " + element);
    }

    /**
     * Sends text to the given WebElement after waiting for its visibility.
     *
     * @param element the WebElement to which text will be sent
     * @param text the text to send to the element
     */
    protected void sendKeys(WebElement element, String text) {
        waitForVisibility(element);
        element.clear();
        element.sendKeys(text);
        logger.info("Sent keys to element: " + element + " text: " + text);
    }

    /**
     * Retrieves the text content of the given WebElement after ensuring it's visible.
     *
     * @param element the WebElement from which to retrieve text
     * @return the text contained within the element
     */
    protected String getText(WebElement element) {
        waitForVisibility(element);
        return element.getText();
    }

    // You can add additional common methods here (e.g., scrollIntoView, hover, etc.)
}
