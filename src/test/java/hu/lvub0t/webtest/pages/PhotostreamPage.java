package hu.lvub0t.webtest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PhotostreamPage extends PageBase {

    private By photoStreamContainerBy = By.xpath("//div[@class='photolist-container fluid-centered']//div[2]");
    private By photoLinkBy = By.xpath("//a[@class='overlay']");

    WebElement photoStreamContainer;

    public PhotostreamPage(WebDriver driver, boolean manualNavigation) {
        super(driver,manualNavigation);

        if(manualNavigation)
            driver.get("https://www.flickr.com/photos/me");

        photoStreamContainer = getElementAfterWait(photoStreamContainerBy);
    }

    public List<WebElement> getUploadedPhotoUrls() {
        return photoStreamContainer.findElements(photoLinkBy);
    }

    public PhotoPage goToPhotoPage(WebElement photoUrl) {
        photoUrl.click();
        return new PhotoPage(driver);
    }

}
