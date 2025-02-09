package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(description = "Verify the user can sign in")
    public void loginUserTest() {
        logger.info("Login user test");
        loginPage.loginUser("standard_user", "secret_sauce");
        boolean result = loginPage.hasUserLoggedIn();

        Assert.assertTrue(result, "The after sign page is not displayed, user may not be signed in");
        logger.info("The login user test executed");
    }
}
