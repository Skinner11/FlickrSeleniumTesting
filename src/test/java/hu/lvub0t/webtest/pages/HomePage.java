package hu.lvub0t.webtest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Page Object encapsulates the Home Page
 */
public class HomePage extends PageBase {

    private By cookieFrameBy = By.xpath("//iframe[@title='TrustArc Cookie Consent Manager']");
    private By acceptCookiesButtonBy = By.xpath("//*[@class=\"acceptAll\"]");
    private By signoutButtonBy = By.xpath("//input[@name='go' and @value='YES, SIGN ME OUT']");

    // Account and dropdown items
    private By accountButtonBy = By.xpath("//div[@class='avatar person tiny no-menu']");

    public HomePage(WebDriver driver){
        super(driver);
        handleCookies();
    }

    private void handleCookies() {
        WebElement cookieFrame = getElementAfterWait(cookieFrameBy);
        driver.switchTo().frame(cookieFrame);
        getElementAfterWait(acceptCookiesButtonBy).click();
    }

    public AccountPage checkAccount() {
        getElementAfterWait(accountButtonBy).click();
        return new AccountPage(driver);
    }

    public SignoutPage signOut() {
        // Due to the nature of the way the website was scripted,
        // the profile pic dropdown is not openable by sending a click with Selenium
        // hence I'm directly going to the logout page url
        driver.get("https://www.flickr.com/logout.gne");
        getElementAfterWait(signoutButtonBy).click();
        return new SignoutPage(driver);
    }
}