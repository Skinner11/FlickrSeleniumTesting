package hu.lvub0t.webtest.tests;

import static org.junit.Assert.assertEquals;
import static hu.lvub0t.webtest.util.TestUtils.ACCOUNT_PAGE_TITLE;
import static hu.lvub0t.webtest.util.TestUtils.EMAIL;
import static hu.lvub0t.webtest.util.TestUtils.NEW_NAMES;
import static hu.lvub0t.webtest.util.TestUtils.PASSWORD;

import org.junit.Test;

import java.util.Random;

import hu.lvub0t.webtest.pages.AccountPage;
import hu.lvub0t.webtest.pages.HomePage;
import hu.lvub0t.webtest.pages.NameChangePage;
import hu.lvub0t.webtest.pages.SigninPage;

public class AccountTest extends TestBase {

    @Test
    public void checkOpeningAccountPage() {
        SigninPage signInPage = new SigninPage(driver);
        HomePage homePage = signInPage.loginValidUser(EMAIL, PASSWORD);
        AccountPage accountPage = homePage.goToAccountPage();
        assertEquals(accountPage.getPageTitle(), ACCOUNT_PAGE_TITLE);
    }

    @Test
    public void checkNameChange() {

        Random rand = new Random();
        int index = rand.nextInt(NEW_NAMES.length);

        String newName = NEW_NAMES[index];
        SigninPage signInPage = new SigninPage(driver);
        HomePage homePage = signInPage.loginValidUser(EMAIL, PASSWORD);
        AccountPage accountPage = homePage.goToAccountPage();
        NameChangePage nameChangePage = accountPage.goToNameChange();
        accountPage = nameChangePage.changeName(newName);

        assertEquals(accountPage.getUserName(),newName);
    }
}
