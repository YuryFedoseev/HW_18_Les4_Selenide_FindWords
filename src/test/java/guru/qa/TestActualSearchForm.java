package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class TestActualSearchForm {



    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1220x880";
        Configuration.holdBrowserOpen = true;
    }


    @Test
    void searchTextAssertions() {
        open("https://github.com/selenide/selenide");

        $("#wiki-tab").click();
        $(byXpath("//button[contains(@class,'f6 Link')]")).click();
        $("#wiki-pages-box").shouldBe(text("SoftAssertions"));
        $(byText("Soft assertions")).click();
        //$(".Layout-main").shouldHave(text("Using JUnit5 extend"));

        $("#wiki-wrapper").shouldHave(text("Using JUnit5 extend test class: " + "@ExtendWith({SoftAssertsExtension.class}) " +
                        "class Tests { " + "  @Test " + "  void test() { " + "    Configuration.assertionMode = SOFT; " + " open(\"page.html\"); "));


    }
}
