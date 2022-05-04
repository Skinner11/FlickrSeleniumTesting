package hu.lvub0t.webtest.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.Map;

import hu.lvub0t.webtest.pages.ExplorePage;
import hu.lvub0t.webtest.pages.HomePage;
import hu.lvub0t.webtest.pages.PageBase;
import hu.lvub0t.webtest.pages.SigninPage;
import hu.lvub0t.webtest.util.TestUtils;

public class ExtendableTest extends TestBase {
    Map<PageBase,String> expectedTitlesForPages = new HashMap<>();

    @Before
    public void fillMap() {
        expectedTitlesForPages.put(new HomePage(driver,true), TestUtils.HOME_PAGE_TITLE_NOSIGNIN);
        expectedTitlesForPages.put(new SigninPage(new ChromeDriver()), TestUtils.SIGNIN_PAGE_TITLE);
        expectedTitlesForPages.put(new ExplorePage(new ChromeDriver(),true), TestUtils.EXPLORE_PAGE_TITLE);
    }

    @Test
    public void testPageTitles() {
        for(Map.Entry<PageBase,String> pair: expectedTitlesForPages.entrySet()) {
            assertEquals(pair.getValue(), pair.getKey().getPageTitle());
        }
    }
}
