package setupBrowsers;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class SetupBrowser {

    public static void start_browser(){
        Configuration.browser = "chrome";
        Configuration.timeout = 10000;
        Configuration.startMaximized = true;
        Configuration.headless = true;
    }

    public static void close_browser(){
        closeWebDriver();
    }
}
