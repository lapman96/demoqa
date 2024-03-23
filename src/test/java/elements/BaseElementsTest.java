package elements;

import com.codeborne.selenide.Configuration;
public class BaseElementsTest {
    public void setUp(){
        Configuration.browser = "chrome";
        Configuration.timeout = 10000;
        Configuration.browserSize = "1980x1080";
        Configuration.screenshots = true;
        Configuration.fastSetValue = true;
    }
}
