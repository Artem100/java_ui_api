import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.Test;
import pageObject.AccountLocators;
import pageObject.LoginLocators;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest {

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

    @Test
    public void test_login_selenide(){
        Configuration.browser = "firefox";
        Configuration.timeout = 10000;

        WebDriverManager.firefoxdriver().setup();
        open("http://10.0.6.74/opencart/index.php?route=account/login");

        LoginLocators loginPage = new LoginLocators();
        AccountLocators accountPage = new AccountLocators();


        loginPage.emailFieldInput("test@ayay.coo");
        loginPage.passwordFieldInput("12345");
        loginPage.buttonLoginClick();
        assertTrue(accountPage.accountListVisible());
        assertEquals(accountPage.accountListElementsCount(), 12);

    }
}
