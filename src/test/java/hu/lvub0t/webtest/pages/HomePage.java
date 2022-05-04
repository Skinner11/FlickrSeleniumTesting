package hu.lvub0t.webtest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Page Object encapsulates the Home Page
 */
public class HomePage extends PageBase {

    private By signoutButtonBy = By.xpath("//input[@name='go' and @value='YES, SIGN ME OUT']");

    // Buttons
    private By accountButtonBy = By.xpath("//div[@class='avatar person tiny no-menu']");
    private By uploadButtonBy = By.xpath("//i[@class='upload-icon']");

    public HomePage(WebDriver driver){
        super(driver);
    }

    public AccountPage goToAccountPage() {
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

    public UploadPage goToUploadPage() {
        getElementAfterWait(uploadButtonBy).click();
        return new UploadPage(driver);
    }
}