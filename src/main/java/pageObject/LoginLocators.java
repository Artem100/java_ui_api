package pageObject;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class LoginLocators {

    private static final By EMAIL_FIELD = By.cssSelector("input#input-email");
    private static final By PASSWORD_FIELD = By.cssSelector("input#input-password");
    private static final By BUTTON_LOGIN = By.cssSelector("input[type='submit']");


    public void emailFieldInput(String email){
        $(EMAIL_FIELD).sendKeys(email);
    }

    public void passwordFieldInput(String password){
        $(PASSWORD_FIELD).sendKeys(password);
    }

    public void buttonLoginClick(){
        $(BUTTON_LOGIN).click();}
    }
