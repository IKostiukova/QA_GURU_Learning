package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class ActitimeTests {

    @Test
    void navigateToTryFreePageTest() {
        open("https://www.actitime.com/");

        $(By.linkText("TRY FREE")).click();

        $(".great-message__h1").shouldHave(text("Start Your Free Online Timesheet Trial"));
    }

    @Test
    void emailValidationTest() {
        open("https://www.actitime.com/");

        $(By.linkText("TRY FREE")).click();
        sleep(2000);

        $("#first-name").setValue("Lili").pressEnter();
        sleep(2000);
        $("#last-name").setValue("Popolos").pressEnter();
        sleep(2000);
        $("#email").setValue("lilip@gmail.com").pressEnter();
        sleep(4000);

        $(".form-free-trial__errors")
                .shouldHave(text("Cannot validate the specified e-mail address"));
    }
}

//byId -> #
//byClassName -> .
