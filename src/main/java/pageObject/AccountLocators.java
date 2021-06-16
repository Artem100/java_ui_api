package pageObject;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selenide.*;

public class AccountLocators extends BasePage{

    private static final String [] ACCOUNT_LIST = {"ACCOUNT LIST","div#account-account ul.list-unstyled"};
    private static final String [] ACCOUNT_LIST_ELEMENTS = {"ACCOUNT LIST","div#account-account ul.list-unstyled>li"};
    private static final By SUCCESS_REGISTRATION_CONTENT = By.cssSelector("div#common-success");
    private static final By SUCCESS_REGISTRATION_TEXT = By.cssSelector("div#content>p:nth-child(2)");


    public void accountListVisible() {
        element_visible_on_page(ACCOUNT_LIST);
    }

    public boolean successRegistrationContentVisible() {
        return $(SUCCESS_REGISTRATION_CONTENT).isDisplayed();}

    public void accountListElementsCount(int count) {
        check_number_elements_on_page(count, ACCOUNT_LIST_ELEMENTS);
    }

    public String successRegistrationText(){return $(SUCCESS_REGISTRATION_TEXT).text();}
}
