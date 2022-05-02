package hu.lvub0t.webtest.tests;

import static org.junit.Assert.assertEquals;
import static hu.lvub0t.webtest.util.TestUtils.ACCOUNT_PAGE_TITLE;
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
import io.github.bonigarcia.wdm.WebDriverManager;

public class AccountTest extends TestBase {

    @Test
    public void checkOpeningAccountPage() {
        SigninPage signInPage = new SigninPage(driver);
        HomePage homePage = signInPage.loginValidUser(EMAIL, PASSWORD);
        AccountPage accountPage = homePage.checkAccount();
        assertEquals(accountPage.getPageTitle(), ACCOUNT_PAGE_TITLE);
    }
}
