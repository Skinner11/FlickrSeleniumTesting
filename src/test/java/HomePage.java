import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Page Object encapsulates the Home Page
 */
public class HomePage extends PageBase{
    protected WebDriver driver;

    private By userBy = By.xpath("/html/body/div[2]/div/div[1]/div/div[1]/div[2]/div[5]/div/div[2]/div/div[1]/span[1]");
    private By signoutBy = By.xpath("/html/body/div[2]/div/div[1]/div/div[1]/div[2]/div[5]/div/div[2]/div/div[2]/div/div[3]/div");

    public HomePage(WebDriver driver){
        super(driver);
        if (!driver.getCurrentUrl().equals("https://imgur.com/")) {
            throw new IllegalStateException("This is not the Home Page," +
                    " current page is: " + driver.getCurrentUrl());
        }
    }

    /**
     * Get logged in user's name (span tag)
     *
     * @return String message text
     */
    public String getLoggedInUsername() {
        return getElementAfterWait(userBy).getText();
    }

    public SignoutPage signOut() {
        getElementAfterWait(userBy).click();
        getElementAfterWait(signoutBy).click();
        return new SignoutPage(driver);
    }
}