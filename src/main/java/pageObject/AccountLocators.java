package pageObject;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selenide.*;

public class AccountLocators {

    private static final By ACCOUNT_LIST = By.cssSelector("div#account-account ul.list-unstyled");
    private static final By ACCOUNT_LIST_ELEMENTS = By.cssSelector("div#account-account ul.list-unstyled>li");
    private static final By SUCCESS_REGISTRATION_CONTENT = By.cssSelector("div#common-success");
    private static final By SUCCESS_REGISTRATION_TEXT = By.cssSelector("div#content>p:nth-child(2)");


    public boolean accountListVisible() {
        return $(ACCOUNT_LIST).isDisplayed();
    }

    public boolean successRegistrationContentVisible() {
        return $(SUCCESS_REGISTRATION_CONTENT).isDisplayed();}

    public int accountListElementsCount() {
        return $$(ACCOUNT_LIST_ELEMENTS).size();
    }

    public void accountListElementsCount_2(int count) {
        $$(ACCOUNT_LIST_ELEMENTS).shouldHave(CollectionCondition.size(count));
    }

    public String successRegistrationText(){return $(SUCCESS_REGISTRATION_TEXT).text();}
}
