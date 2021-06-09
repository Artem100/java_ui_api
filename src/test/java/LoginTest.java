import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObject.AccountLocators;
import pageObject.LoginLocators;
import pageObject.RegistrationPage;
import setupBrowsers.SetupBrowser;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest {

    Faker faker = new Faker();
    LoginLocators loginPage = new LoginLocators();
    AccountLocators accountPage = new AccountLocators();
    RegistrationPage registrationpage = new RegistrationPage();

    @BeforeMethod
    public static void start(){ SetupBrowser.start_browser(); }


    @Test
    public void test_login_positive(){
        open("http://10.0.6.74/opencart/index.php?route=account/login");

        loginPage.emailFieldInput("test@ayay.coo");
        loginPage.passwordFieldInput("12345");
        loginPage.buttonLoginClick();
        assertTrue(accountPage.accountListVisible());
        assertEquals(accountPage.accountListElementsCount(), 12);

    }

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

//    @AfterMethod
//    public void closeBrowser(){
//        close();
//    }

}
