package tests;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class AmazonSearchTest {

    @Test
    void searchResultTest() {
        open("https://www.amazon.com/");

        $(byName("field-keywords")).setValue("Test Automation Engineer").pressEnter();
        sleep(1000);
        $(byPartialLinkText("Test Automation Engineer")).click();
        sleep(1000);

        $("#productTitle").shouldHave(text("Test Automation Engineer: Guide to the ISTQB Advanced Level Certification"));
        $("#tmmSwatches .a-color-price").shouldHave(text("$41.16"));
    }
}
