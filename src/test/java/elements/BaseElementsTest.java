package elements;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class BaseElementsTest {
    @BeforeAll
    public static void setUp(){
        Configuration.browser = System.getProperty("browser");
        Configuration.timeout = 10000;
        Configuration.browserSize = "1980x1080";
        Configuration.screenshots = true;
        Configuration.fastSetValue = true;
        Configuration.headless = true;
        Configuration.reopenBrowserOnFail = false;
    }
}
