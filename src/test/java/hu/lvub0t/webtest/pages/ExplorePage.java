package hu.lvub0t.webtest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ExplorePage extends PageBase {

    private By titleDivBy = By.xpath("//div[@class='title-row']");

    public ExplorePage(WebDriver driver, boolean manualNavigation) {
        super(driver,manualNavigation);

        if(manualNavigation)
            driver.get("https://www.flickr.com/explore");

        getElementAfterWait(titleDivBy);
    }

}
