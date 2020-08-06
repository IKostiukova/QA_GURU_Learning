package tests;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AmazonSearchTest {

    @Test
    void searchResultTest() throws InterruptedException {
        open("https://www.amazon.com/");

        $(byName("field-keywords")).setValue("Test Automation Engineer").pressEnter();
        Thread.sleep(1000);
        $(byPartialLinkText("Test Automation Engineer")).click();
        Thread.sleep(1000);

        $(byId("productTitle")).shouldHave(text("Test Automation Engineer: Guide to the ISTQB Advanced Level Certification"));
    }
}
