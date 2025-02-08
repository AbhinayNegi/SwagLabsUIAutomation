package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;

public class BaseTest {

    protected WebDriver driver;
    protected LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        // Get the WebDriver instance from DriverFactory
        driver = DriverFactory.getDriver();
        driver.manage().window().maximize();

        this.loginPage = new LoginPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        // Quit the driver and clean up
        DriverFactory.quitDriver();
    }
}

