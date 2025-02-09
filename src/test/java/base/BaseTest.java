package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;
import org.slf4j.Logger;
import utils.Log;

public class BaseTest {

    protected WebDriver driver;
    protected LoginPage loginPage;
    protected final Logger logger = Log.getLogger(getClass());

    @BeforeMethod
    public void setUp() {
        logger.info("Setting up web driver");
        driver = DriverFactory.getDriver();
        driver.manage().window().maximize();

        this.loginPage = new LoginPage(driver);
        logger.info("Web driver set up complete");
    }

    @AfterMethod
    public void tearDown() {
        logger.info("Tear down method");
        // Quit the driver and clean up
        DriverFactory.quitDriver();
        logger.info("Executed tear down method");
    }
}

