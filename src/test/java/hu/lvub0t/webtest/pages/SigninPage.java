package hu.lvub0t.webtest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

public class SigninPage extends PageBase {

    private By emailBy =By.xpath("//input[@id='login-email']");
    private By nextButtonBy = By.xpath("//button[@class='mt-5 c-white bg-blue flickr-button flex align-center justify-center f-size-3 f-weight-bold over-y-hidden block w-100 b-rad-1 py-2 px-4']");
    private By passwordBy =By.xpath("//input[@id='login-password']");

    public SigninPage(WebDriver driver) {
        super(driver,true);
        this.driver.get("https://identity.flickr.com/");
        consentToCookies();
    }

    private void consentToCookies() {
        driver.manage().addCookie(new Cookie("cmapi_cookie_privacy", "permit 1,2,3",".flickr.com","/",null));
        driver.manage().addCookie(new Cookie("notice_gdpr_prefs", "0,1,2:",".flickr.com","/",null));
    }

    /**
     * Login as valid user
     *
     * @param email
     * @param password
     * @return hu.lvub0t.imgurtesting.pages.HomePage object
     */
    public HomePage loginValidUser(String email, String password) {
        getElementAfterWait(emailBy).sendKeys(email);
        getElementAfterWait(nextButtonBy).click();
        getElementAfterWait(passwordBy).sendKeys(password);
        getElementAfterWait(nextButtonBy).click();
        return new HomePage(driver, false);
    }
}
