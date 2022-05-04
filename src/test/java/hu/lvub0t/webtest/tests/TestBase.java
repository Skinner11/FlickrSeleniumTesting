package hu.lvub0t.webtest.tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;

import hu.lvub0t.webtest.util.TestUtils;
import io.github.bonigarcia.wdm.WebDriverManager;

public abstract class TestBase {
    public WebDriver driver;
    private ChromeOptions options;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        // Set download folder
        options = new ChromeOptions();
        var prefs = new HashMap<String, Object>();
        prefs.put("download.default_directory", TestUtils.getDownloadsPath());
        options.setExperimentalOption("prefs", prefs);

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @After
    public void after() {
        driver.close();
    }
}
