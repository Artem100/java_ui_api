package pageObject;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selenide.*;

public class AccountLocators {

    private static final By ACCOUNT_LIST = By.cssSelector("div#account-account ul.list-unstyled");
    private static final By ACCOUNT_LIST_ELEMENTS = By.cssSelector("div#account-account ul.list-unstyled>li");

    public boolean accountListVisible() {
        return $(ACCOUNT_LIST).isDisplayed();
    }

    public int accountListElementsCount() {
        return $$(ACCOUNT_LIST_ELEMENTS).size();
    }
}
