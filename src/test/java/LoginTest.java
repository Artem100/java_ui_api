import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObject.AccountLocators;
import pageObject.LoginLocators;
import pageObject.RegistrationPage;
import setupBrowsers.SetupBrowser;

import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static setupBrowsers.SetupBrowser.close_browser;

public class LoginTest {

    Faker faker = new Faker();
    LoginLocators loginPage = new LoginLocators();
    AccountLocators accountPage = new AccountLocators();
    RegistrationPage registrationpage = new RegistrationPage();

    @BeforeMethod
    public static void start(){ SetupBrowser.start_browser(); }


    @AfterMethod
    public void closeBrowser(){ close_browser(); }

    @Severity(SeverityLevel.CRITICAL)
    @Description("Simple login")
    @Test
    public void test_login_positive(){
        open("http://10.0.6.74/opencart/index.php?route=account/login");

//        loginPage.emailFieldInput("test@ayay.coo");
//        loginPage.passwordFieldInput("12345");
//        loginPage.buttonLoginClick();
        loginPage.login_to_account("test@ayay.coo", "12345");
        assertTrue(accountPage.accountListVisible());
        assertEquals(accountPage.accountListElementsCount(), 10);

    }

    @Severity(SeverityLevel.NORMAL)
    @Description("Positive registration")
    @Test
    public void test_registration_positive(){

        open("http://10.0.6.74/opencart/index.php?route=account/register");

        String name = faker.name().name();
        String lastName = faker.name().firstName();
        String email = faker.internet().emailAddress();
        String telephone = faker.phoneNumber().phoneNumber();
        String password = faker.internet().password();

        registrationpage.userRegistrationFullConfirm(name, lastName, email, telephone, password, password);
        assertTrue(accountPage.successRegistrationContentVisible());
        assertEquals(accountPage.successRegistrationText(), "Congratulations! Your new account has been successfully created!");

    }

}
