package pageObject;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class LoginLocators extends BasePage{

    private static final By EMAIL_FIELD = By.cssSelector("input#input-email");
    private static final By PASSWORD_FIELD = By.cssSelector("input#input-password");
//    private static final By BUTTON_LOGIN = By.cssSelector("input[type='submit']");
//    String [] BUTTON_LOGIN = {"LOGIN BUTTON", "input[type='submit']"};
     private static final By BUTTON_LOGIN = By.cssSelector("input[type='submit']1");

    public void emailFieldInput(String email) {
        $(EMAIL_FIELD).sendKeys(email);
    }

    public void passwordFieldInput(String password) {
        $(PASSWORD_FIELD).sendKeys(password);
    }

    @Step("Click *login* button")
    public void buttonLoginClick() {
        $(BUTTON_LOGIN).click();
//        click(BUTTON_LOGIN);
    }


    @Step("Positive login")
    public void login_to_account(String email, String password) {
        emailFieldInput(email);
        passwordFieldInput(password);
        buttonLoginClick();
    }


}