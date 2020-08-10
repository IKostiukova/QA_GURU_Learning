package tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class AlfaBankTests {
    @Test
    void archiveDepositListSizeTest() {
        open("https://alfabank.ru/");

        $("[title=Вклады]").click();
        $$("[title=Инвестиции]").last().parent()
                .preceding(2).click();

        sleep(4000);
        $(".col-sm-frame p")
                .sibling(0).$("a").click();

        $(".product-cell__cell").closest("div")
                .$$(".product-cell__cell-back").shouldHaveSize(3);
    }

    @Test
    void  depositInsuranceTitleTest() {
        open("https://alfabank.ru/");

        $("[title=Вклады]").click();
        $$("[title=Инвестиции]").last().parent()
                .sibling(0).click();

        $("h1").shouldHave(Condition.text("Страхование вкладов"));
    }
}
