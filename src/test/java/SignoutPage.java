import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignoutPage extends PageBase {

    private By signoutMessage = By.xpath("/html/body/div[8]/div[2]/h1");

    public SignoutPage(WebDriver driver) {
        super(driver);
    }

    public boolean isUserSignedOut() {
        return getElementAfterWait(signoutMessage).getText().equals("You have been signed out");
    }
}
