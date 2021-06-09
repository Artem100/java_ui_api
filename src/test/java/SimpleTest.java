import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.Test;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selenide.*;

public class SimpleTest {

    @Test
    public void test_login(){
        Configuration.browser = "firefox";
        Configuration.timeout = 10000;

        WebDriverManager.firefoxdriver().setup();
        open("http://10.0.6.74/opencart/index.php?route=account/login");

        $("input#input-email").sendKeys("test@ayay.coo");
        $("input#input-password").sendKeys("12345");
        $("input[type='submit']").click();
        $("div#account-account ul.list-unstyled").should(Condition.visible);
        $$("div#account-account ul.list-unstyled>li").shouldHave(size(10));
    }


}

