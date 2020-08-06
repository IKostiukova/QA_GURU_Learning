package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ActitimeTests {
    @BeforeEach
    void openPage(){
    }

    @Test
    void navigateToTryFreePageTest() {
        open("https://www.actitime.com/");
        
        $(byText("TRY FREE")).click();

        $(".great-message__h1").shouldHave(text("Start Your Free Online Timesheet Trial"));
    }

    @Test
    void emailValidationTest() {
        open("https://www.actitime.com/");

        $(byText("TRY FREE")).click();
        sleep(4000);
        
        $("#first-name").setValue("Lili").pressEnter();
        sleep(4000);
        $("#last-name").setValue("Popolos").pressEnter();
        sleep(4000);
        $("#email").setValue("lilip@gmail.com").pressEnter();
        sleep(4000);
        $("#start-trial-submit").click();
        sleep(4000);

        $(".form-free-trial__errors")
                .shouldHave(text("Cannot validate the specified e-mail address"));
    }
}

