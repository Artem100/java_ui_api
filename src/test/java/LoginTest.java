import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.codeborne.selenide.testng.annotations.Report;
import com.github.javafaker.Faker;
import com.codeborne.selenide.testng.TextReport;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

import io.qameta.allure.selenide.AllureSelenide;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;
import pageObject.AccountLocators;
import pageObject.LoginLocators;
import pageObject.RegistrationPage;
import setupBrowsers.SetupBrowser;

import java.util.Dictionary;
import java.util.ResourceBundle;

import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static setupBrowsers.SetupBrowser.close_browser;

//@Report
//@Listeners(TextReport.class)
public class LoginTest {

    Faker faker = new Faker();
    LoginLocators loginPage = new LoginLocators();
    AccountLocators accountPage = new AccountLocators();
    RegistrationPage registrationpage = new RegistrationPage();

    private ResourceBundle env = ResourceBundle.getBundle("envs");
    private ResourceBundle creds = ResourceBundle.getBundle("creds");

    @BeforeMethod
    public static void start(){ SetupBrowser.start_browser(); }


    @AfterMethod
    public void closeBrowser(){ close_browser(); }

    @Severity(SeverityLevel.CRITICAL)
    @Description("Simple login")
    @Test
    public void test_login_positive(){
        open(env.getString("base_env")+"opencart/index.php?route=account/login");
        loginPage.login_to_account(creds.getString("username"), creds.getString("password"));
        accountPage.accountListVisible();
        accountPage.accountListElementsCount(12);
    }
//
//    @Severity(SeverityLevel.NORMAL)
//    @Description("Positive registration")
//    @Test
//    public void test_registration_positive(){
//
//        open(env.getString("base_env") + "opencart/index.php?route=account/register");
//
//        String name = faker.name().name();
//        String lastName = faker.name().firstName();
//        String email = faker.internet().emailAddress();
//        String telephone = faker.phoneNumber().phoneNumber();
//        String password = faker.internet().password();
//
//        registrationpage.userRegistrationFullConfirm(name, lastName, email, telephone, password, password);
//        assertTrue(accountPage.successRegistrationContentVisible());
//        assertEquals(accountPage.successRegistrationText(), "Congratulations! Your new account has been successfully created!");

//    }

}
