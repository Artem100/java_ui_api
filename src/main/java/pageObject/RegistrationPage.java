package pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage {

    private static final By FIRST_NAME_FIELD = By.cssSelector("input#input-firstname");
    private static final By LAST_NAME_FIELD= By.cssSelector("input#input-lastname");
    private static final By EMAIL_FIELD = By.cssSelector("input#input-email");
    private static final By TELEPHONE_FIELD= By.cssSelector("input#input-telephone");
    private static final By PASSWORD_FIELD= By.cssSelector("input#input-password");
    private static final By PASSWORD_CONFIRM_FIELD = By.cssSelector("input#input-confirm");
    private static final By AGREE_CHECKBOX = By.cssSelector("div.buttons input[name='agree']");
    private static final By CONTINUE_BUTTON = By.cssSelector("input[type='submit']");


    @Step()
    public void firstNameFieldInput(String text){
        $(FIRST_NAME_FIELD).sendKeys(text);
    }

    @Step()
    public void lastNameFieldInput(String text){
        $(LAST_NAME_FIELD).sendKeys(text);
    }

    @Step()
    public void emailFieldInput(String text){
        $(EMAIL_FIELD).sendKeys(text);
    }

    @Step()
    public void telephoneFieldInput(String text){
        $(TELEPHONE_FIELD).sendKeys(text);
    }

    @Step()
    public void passwordFieldInput(String text){
        $(PASSWORD_FIELD).sendKeys(text);
    }

    @Step()
    public void passwordConfirmFieldInput(String text){
        $(PASSWORD_CONFIRM_FIELD).sendKeys(text);
    }

    @Step()
    public void agreeCheckboxClick(){
        $(AGREE_CHECKBOX).click();
    }

    @Step()
    public void continueButton(){
        $(CONTINUE_BUTTON).click();
    }

    @Step("Full registration of new user")
    public void userRegistrationFullConfirm(String name, String lastName, String email, String telephone,
                                 String password, String repeat_password){
        firstNameFieldInput(name);
        lastNameFieldInput(lastName);
        emailFieldInput(email);
        telephoneFieldInput(telephone);
        passwordFieldInput(password);
        passwordConfirmFieldInput(repeat_password);
        agreeCheckboxClick();
        continueButton();
    }

}
