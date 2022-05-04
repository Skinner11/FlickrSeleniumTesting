package hu.lvub0t.webtest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class PhotoPage extends PageBase {

    private By viewCountLabelBy = By.xpath("//span[@class='view-count-label']");

    private By downloadButtonBy = By.xpath("//i[@class='ui-icon-download']");
    private By downloadOriginalButtonBy = By.xpath("//ul//li[@class='Original']//a");

    public PhotoPage(WebDriver driver) {
        super(driver);
        getElementAfterWait(viewCountLabelBy);
    }

    public void downloadPhoto() {
        getElementAfterWait(downloadButtonBy).click();
        getElementAfterWait(downloadOriginalButtonBy).click();

        // Close size selector by pressing ESC
        Actions actionProvider = new Actions(driver);
        actionProvider.sendKeys(Keys.ESCAPE).build().perform();
    }

    public PhotostreamPage backToPhotostream() {
        driver.navigate().back();
        return new PhotostreamPage(driver);
    }

}
