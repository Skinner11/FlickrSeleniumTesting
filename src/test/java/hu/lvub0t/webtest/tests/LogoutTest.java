package hu.lvub0t.webtest.tests;

import static org.junit.Assert.assertEquals;
import static hu.lvub0t.webtest.util.TestUtils.ACCOUNT_PICKER_TEXT;
import static hu.lvub0t.webtest.util.TestUtils.EMAIL;
import static hu.lvub0t.webtest.util.TestUtils.PASSWORD;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import hu.lvub0t.webtest.pages.AccountPage;
import hu.lvub0t.webtest.pages.HomePage;
import hu.lvub0t.webtest.pages.SigninPage;
import hu.lvub0t.webtest.pages.SignoutPage;
import io.github.bonigarcia.wdm.WebDriverManager;

/***
 * Tests logout feature
 */
public class LogoutTest extends TestBase {

    @Test
    public void testLogout() {
        SigninPage signInPage = new SigninPage(driver);
        HomePage homePage = signInPage.loginValidUser(EMAIL, PASSWORD);
        SignoutPage signoutPage = homePage.signOut();
        assertEquals(signoutPage.getAccountPickerTitle(), ACCOUNT_PICKER_TEXT);
    }

}

