package hu.lvub0t.webtest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * Page Object encapsulates the Home Page
 */
public class HomePage extends PageBase {

    private By signoutButtonBy = By.xpath("//input[@name='go' and @value='YES, SIGN ME OUT']");

    // Buttons
    private By accountButtonBy = By.xpath("//div[@class='avatar person tiny no-menu']");
    private By uploadButtonBy = By.xpath("//i[@class='upload-icon']");
    private By photostreamButtonBy = By.cssSelector("[aria-label='Photostream']");

    // Elements
    private By advertBy = By.cssSelector("[aria-label='Advertisement']");

    // Hoverable elements
    private By youBy = By.cssSelector("[aria-label='You']");

    public HomePage(WebDriver driver){
        super(driver);
        // Wait for adverts to load...
        getElementAfterWait(advertBy);
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

    public PhotostreamPage goToPhotoStreamPage() {
        Actions actionProvider = new Actions(driver);
        actionProvider.moveToElement(getElementAfterWait(youBy)).build().perform();
        getElementAfterWait(photostreamButtonBy).click();
        return new PhotostreamPage(driver);
    }
}