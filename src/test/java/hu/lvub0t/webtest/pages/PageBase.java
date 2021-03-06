package hu.lvub0t.webtest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class PageBase {
    protected WebDriver driver;
    private WebDriverWait wait;
    private ChromeOptions options;

    public PageBase(WebDriver driver, boolean manualNavigation) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    protected WebElement getElementAfterWait(By selector) {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
        return this.driver.findElement(selector);
    }

    protected void hoverElement(WebElement element) {
        Actions builder = new Actions(driver);
        builder.moveToElement(element).perform();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }
}
