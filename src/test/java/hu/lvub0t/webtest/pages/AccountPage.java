package hu.lvub0t.webtest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage extends PageBase {

    private By emailBy =By.xpath("//p[@class='email']");

    public AccountPage(WebDriver driver) {
        super(driver);

        getElementAfterWait(By.tagName("h1"));
    }

    public String getUserEmail() {
        return getElementAfterWait(emailBy).getText();
    }
}
