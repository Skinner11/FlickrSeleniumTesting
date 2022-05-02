package hu.lvub0t.webtest.tests;

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
        AccountPage accountPage = homePage.checkAccount();
        assertEquals(accountPage.getUserEmail(), EMAIL);
    }
}

