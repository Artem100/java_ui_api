package pageObject;

import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$;

public class BasePage {

    private static final Logger logger = LogManager.getLogger(BasePage.class);

//    private void Timeout(String[] args){
//        logger.info("Click element" + args[0]);
//    }


    @Step("Click element {array[0]}")
    public void click(String... array){
        logger.info("Click element " + array[0]);
        $(array[1]).click();
    }
}
