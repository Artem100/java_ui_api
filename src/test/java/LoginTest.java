import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.Test;
import pageObject.AccountLocators;
import pageObject.LoginLocators;
import pageObject.RegistrationPage;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest {

    @Test
    public void test_login_positive(){
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

    @Test
    public void test_registration_positive(){
        Configuration.browser = "firefox";
        Configuration.timeout = 10000;
        Faker faker = new Faker();

        WebDriverManager.firefoxdriver().setup();
        open("http://10.0.6.74/opencart/index.php?route=account/register");

        String name = faker.name().name();
        String lastName = faker.name().firstName();
        String email = faker.internet().emailAddress();
        String telephone = faker.phoneNumber().phoneNumber();
        String password = faker.internet().password();

        AccountLocators accountPage = new AccountLocators();
        RegistrationPage registrationpage = new RegistrationPage();

        registrationpage.userRegistrationFullConfirm(name, lastName, email, telephone, password, password);
        assertTrue(accountPage.successRegistrationContentVisible());
        assertEquals(accountPage.successRegistrationText(), "Congratulations! Your new account has been successfully created!");

    }
}
