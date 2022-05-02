package hu.lvub0t.webtest.tests;

import org.junit.Test;

import hu.lvub0t.webtest.pages.AccountPage;
import hu.lvub0t.webtest.pages.HomePage;
import hu.lvub0t.webtest.pages.SigninPage;

import static org.junit.Assert.*;
import static hu.lvub0t.webtest.util.TestUtils.*;

/***
 * Tests login feature
 */
public class LoginTest extends TestBase {

    @Test
    public void testLogin() {
        SigninPage signInPage = new SigninPage(driver);
        HomePage homePage = signInPage.loginValidUser(EMAIL, PASSWORD);
        AccountPage accountPage = homePage.goToAccountPage();
        assertEquals(accountPage.getUserEmail(), EMAIL);
    }
}

