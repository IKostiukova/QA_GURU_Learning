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
        open("https://www.actitime.com/");
    }

    @Test
    void navigateToTryFreePageTest(){
        $(By.linkText("TRY FREE")).click();

        $(byClassName("great-message__h1")).shouldHave(text("Start Your Free Online Timesheet Trial"));
    }

    @Test
    void emailValidationTest() throws InterruptedException {
        $(By.linkText("TRY FREE")).click();
        Thread.sleep(4000);
        $(byId("first-name")).setValue("Lili").pressEnter();
        Thread.sleep(4000);
        $(byId("last-name")).setValue("Popolos").pressEnter();
        Thread.sleep(4000);
        $(byId("email")).setValue("lilip@gmail.com").pressEnter();
        Thread.sleep(4000);
        $(byId("start-trial-submit")).click();
        Thread.sleep(4000);

        $(byClassName("form-free-trial__errors"))
                .shouldHave(text("Cannot validate the specified e-mail address"));
    }
}

