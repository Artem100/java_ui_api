import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.codeborne.selenide.testng.TextReport;
import com.codeborne.selenide.testng.annotations.Report;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selenide.*;

@Report
@Listeners(TextReport.class)
public class SimpleTest {

    String basicUrl = "http://10.0.6.74/";
//    @BeforeTest
//    public void open_browser(){
//        Configuration.browser = "firefox";
//        Configuration.timeout = 10000;
//
//        WebDriverManager.firefoxdriver().setup();
//        open(basicUrl+"opencart/index.php?route=account/login");
//    }

    @Test
    public void test_login(){
        Configuration.browser = "firefox";
        Configuration.timeout = 10000;

        WebDriverManager.firefoxdriver().setup();
        open(basicUrl+"opencart/index.php?route=account/login");

        $("input#input-email").sendKeys("test@ayay.coo");
        $("input#input-password").sendKeys("12345");
        $("input[type='submit']").click();
        $("div#account-account ul.list-unstyled").should(Condition.visible);
        $$("div#account-account ul.list-unstyled>li").shouldHave(size(10));
    }


}

