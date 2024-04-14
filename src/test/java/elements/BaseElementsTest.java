package elements;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BaseElementsTest {
    @BeforeAll
    public static void setUp(){
        if ("true".equals(System.getProperty("run_remotely"))) {
            Configuration.remote = "http://localhost:4444/wd/hub";
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setPlatform(Platform.WIN11);
            Configuration.browserCapabilities = desiredCapabilities;
        }

        Configuration.browser = System.getProperty("browser");
        Configuration.timeout = 10000;
        Configuration.screenshots = true;
        Configuration.fastSetValue = true;
        Configuration.headless = false;
        Configuration.reopenBrowserOnFail = true;
    }
}
