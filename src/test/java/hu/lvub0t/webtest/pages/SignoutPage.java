package hu.lvub0t.webtest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignoutPage extends PageBase {

    private By titleBy = By.xpath("//h6[@data-testid='identity-card-title']");


    public SignoutPage(WebDriver driver) {
        super(driver);
    }

    public String getAccountPickerTitle() {
        return getElementAfterWait(titleBy).getText();
    }
}
