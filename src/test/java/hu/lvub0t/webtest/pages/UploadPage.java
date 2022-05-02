package hu.lvub0t.webtest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UploadPage extends PageBase {

    private By uploadCountBy = By.xpath("//p[@class='upload-limit-remaining-count']");

    public UploadPage(WebDriver driver) {
        super(driver);
        getElementAfterWait(uploadCountBy);
    }


}
