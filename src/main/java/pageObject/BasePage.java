package pageObject;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;

public class BasePage {

    private static final Logger logger = LogManager.getLogger(BasePage.class);


    public void click(String... array){
        step("Click on *" + array[0] + "*");
        logger.info("Click element " + array[0]);
        $(array[1]).click();
    }

    public void input_text(String text, String... array){
        step("Input text to *" + array[0] + "*");
        logger.info("Input text'"+ text +"' to *" + array[0] + "*");
        $(array[1]).sendKeys(text);
    }

    public void check_number_elements_on_page(int count, String... array){
        step(array[0]+ " on page should be: " + count + "elements");
        logger.info(array[0]+ " on page should be: " + count + "elements");
        $$(array[1]).shouldHave(CollectionCondition.size(count));
    }

    public void element_visible_on_page(String... array){
        step(array[0]+ " is visible on page");
        logger.info(array[0]+ " is visible on page");
        $(array[1]).shouldBe(Condition.visible);
    }
}
