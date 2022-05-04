package hu.lvub0t.webtest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * Page Object encapsulates the Home Page
 */
public class HomePage extends PageBase {

    // Buttons
    private By accountButtonBy = By.xpath("//div[@class='avatar person tiny no-menu']");
    private By settingsButtonBy = By.xpath("//div//section//ul/li/a[@href='/account']");
    private By signoutButtonBy = By.xpath("//section[@class='menu-section']//ul//li[4]//a");
    private By photostreamButtonBy = By.cssSelector("[aria-label='Photostream']");

    // Elements
    private By advertBy = By.cssSelector("[aria-label='Advertisement']");

    // Hoverable elements
    private By youBy = By.cssSelector("[aria-label='You']");

    public HomePage(WebDriver driver, boolean manualNavigation){
        super(driver, manualNavigation);

        if(manualNavigation)
            driver.get("https://www.flickr.com/");
        else
            // Wait for adverts to load...
            getElementAfterWait(advertBy);
    }

    public AccountPage goToAccountPage() {
        getElementAfterWait(accountButtonBy).click();
        getElementAfterWait(settingsButtonBy).click();
        return new AccountPage(driver, false);
    }

    public SignoutPage signOut() {
        getElementAfterWait(accountButtonBy).click();
        getElementAfterWait(signoutButtonBy).click();
        return new SignoutPage(driver);
    }

    public PhotostreamPage goToPhotoStreamPage() {
        Actions actionProvider = new Actions(driver);
        actionProvider.moveToElement(getElementAfterWait(youBy)).build().perform();
        getElementAfterWait(photostreamButtonBy).click();
        return new PhotostreamPage(driver, false);
    }
}