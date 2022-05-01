import com.gargoylesoftware.htmlunit.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class PageBase {
    private WebDriver driver;
    private WebDriverWait wait;

    public PageBase(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 3);
    }

    protected WebElement getElementAfterWait(By selector) {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
        return this.driver.findElement(selector);
    }
}
