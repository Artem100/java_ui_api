package pageObject;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class LoginLocators extends BasePage{

    private static final String [] EMAIL_FIELD = {"PASSWORD FIELD", "input#input-email"};
    private static final String [] PASSWORD_FIELD = {"PASSWORD FIELD", "input#input-password"};
    private static final String [] BUTTON_LOGIN = {"LOGIN BUTTON", "input[type='submit']1"};


    public void emailFieldInput(String email) {
        input_text(email, EMAIL_FIELD);
    }

    public void passwordFieldInput(String password) {
        input_text(password, PASSWORD_FIELD);
    }

    public void buttonLoginClick() {
        click(BUTTON_LOGIN);
    }

    @Step("Positive login")
    public void login_to_account(String email, String password) {
        emailFieldInput(email);
        passwordFieldInput(password);
        buttonLoginClick();
    }


}