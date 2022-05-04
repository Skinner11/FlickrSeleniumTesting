package hu.lvub0t.webtest.tests;

import static org.junit.Assert.assertEquals;
import static hu.lvub0t.webtest.util.TestUtils.EMAIL;
import static hu.lvub0t.webtest.util.TestUtils.PASSWORD;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

import hu.lvub0t.webtest.pages.HomePage;
import hu.lvub0t.webtest.pages.PhotoPage;
import hu.lvub0t.webtest.pages.PhotostreamPage;
import hu.lvub0t.webtest.pages.SigninPage;
import hu.lvub0t.webtest.util.TestUtils;

public class DownloadTest extends TestBase {

    @Test
    public void downloadAllPicturesTest() {
        // Delete files from folder, maybe the test was already executed before
        String downloadsPath = TestUtils.getDownloadsPath();
        try {
            FileUtils.cleanDirectory(new File(downloadsPath));
        } catch (IOException e) {
            e.printStackTrace();
        }

        SigninPage signInPage = new SigninPage(driver);
        HomePage homePage = signInPage.loginValidUser(EMAIL, PASSWORD);
        PhotostreamPage photostreamPage = homePage.goToPhotoStreamPage();
        List<WebElement> photoUrls = photostreamPage.getUploadedPhotoUrls();

        // Download the full size version of each photo
        for (int i=0;i<photoUrls.size();i++) {
            PhotoPage photoPage = photostreamPage.goToPhotoPage(photoUrls.get(i));
            photoPage.downloadPhoto();
            photostreamPage = photoPage.backToPhotostream();
            photoUrls = photostreamPage.getUploadedPhotoUrls();
        }

        Collection<File> files = FileUtils.listFiles(new File(downloadsPath),null,false);

        // Check that the photos were indeed downloaded
        assertEquals(photoUrls.size(), files.size());
    }

}
