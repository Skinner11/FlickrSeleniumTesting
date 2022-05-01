import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SigninPage extends PageBase {

    private By usernameBy =By.xpath("//*[@id=\"username\"]");
    private By passwordBy =By.xpath("//*[@id=\"password\"]");
    private By buttonBy =By.xpath("//*[@id=\"Imgur\"]");

    public SigninPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Login as valid user
     *
     * @param userName
     * @param password
     * @return HomePage object
     */
    public HomePage loginValidUser(String userName, String password) {
        getElementAfterWait(usernameBy).sendKeys(userName);
        getElementAfterWait(passwordBy).sendKeys(password);
        getElementAfterWait(buttonBy).click();
        return new HomePage(driver);
    }
}
