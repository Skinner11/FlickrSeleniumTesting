package hu.lvub0t.webtest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class NameChangePage extends PageBase {

    private By nameInputBy = By.xpath("//input[@name='new_name']");

    public NameChangePage(WebDriver driver, boolean manualNavigation) {
        super(driver, manualNavigation);

        if(manualNavigation)
            driver.get("https://www.flickr.com/account/prefs/screenname/?from=personal");

        getElementAfterWait(By.tagName("h1"));
    }

    public AccountPage changeName(String newName) {
        getElementAfterWait(nameInputBy).clear();
        getElementAfterWait(nameInputBy).sendKeys(newName + Keys.ENTER);
        return new AccountPage(driver, false);
    }
}
