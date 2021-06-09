package setupBrowsers;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;

//import static com.codeborne.selenide.Selenide.close;

public class SetupBrowser {

    public static void start_browser(){
        Configuration.browser = "chrome";
        Configuration.timeout = 10000;

//        WebDriverManager.firefoxdriver().setup();
    }

//    public static void close_browser(){
//        close();
//    }
}
