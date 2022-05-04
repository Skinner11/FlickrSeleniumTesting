package hu.lvub0t.webtest.util;

import java.nio.file.Paths;

public class TestUtils {
    public static final String ACCOUNT_PAGE_TITLE = "Account settings | Flickr";
    public static final String ACCOUNT_PICKER_TEXT = "Choose an account";
    public static final String EMAIL = "projekteszkozok@freemail.hu";
    public static final String PASSWORD = "b4n4n4b4n4n4";
    public static final String[] NEW_NAMES = {"Mrs. Ape", "Ms. Ape", "Jr. Ape", "Mr. Ape"};

    public static String getDownloadsPath() {
        return Paths.get("").toAbsolutePath().toString()+"\\downloads\\";
    }
}
