package hu.lvub0t.webtest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage extends PageBase {

    private By emailBy = By.xpath("//p[@class='email']");
    private By nameBy = By.xpath("//div[@class='row profile']//div//div[@class='content']//p[2]//span");
    private By changeButtonBy = By.xpath("//div[@class='row profile']//div//div[@class='content']//p[2]//a");
    private By accountDivBy = By.xpath("//div[@id='account-details-settings']");

    public AccountPage(WebDriver driver, boolean manualNavigation) {
        super(driver, manualNavigation);

        if(manualNavigation)
            driver.get("https://www.flickr.com/account");

        getElementAfterWait(accountDivBy);
    }

    public String getUserEmail() {
        return getElementAfterWait(emailBy).getText();
    }

    public String getUserName() {
        return getElementAfterWait(nameBy).getText();
    }

    public NameChangePage goToNameChange() {
        getElementAfterWait(changeButtonBy).click();
        return new NameChangePage(driver, false);
    }
}
