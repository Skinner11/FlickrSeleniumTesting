package hu.lvub0t.webtest.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TestUtils {
    public static final String ACCOUNT_PAGE_TITLE = "Account settings | Flickr";
    public static final String EXPLORE_PAGE_TITLE = "Explore | Flickr";
    public static final String HOME_PAGE_TITLE_NOSIGNIN = "Find your inspiration. | Flickr";
    public static final String SIGNIN_PAGE_TITLE = "Flickr Login";

    public static final String ACCOUNT_PICKER_TEXT = "Choose an account";
    public static final String EMAIL = "projekteszkozok@freemail.hu";
    public static final String PASSWORD = "b4n4n4b4n4n4";
    public static final String[] NEW_NAMES = {"Mrs. Ape", "Ms. Ape", "Jr. Ape", "Mr. Ape"};

    public static String getDownloadsPath() {
        String path = Paths.get("").toAbsolutePath().toString()+"\\downloads\\";

        if(!Files.exists(Paths.get(path))) {
            try {
                Files.createDirectories(Paths.get(path));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return path;
    }
}
