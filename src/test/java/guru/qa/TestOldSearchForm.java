package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TestOldSearchForm {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1220x880";
        Configuration.holdBrowserOpen = true;
    }


    @Test
    void searchText() {
        open("https://github.com/");

        $("[placeholder= 'Search GitHub']").setValue("Selenide").pressEnter();
        $$("ul.repo-list li").first().$("a").click();
        $("#wiki-tab").click();
        $(".markdown-body").shouldHave(text("Soft assertions"));
        $(byText("Soft assertions")).click();
        $(".Layout-main").shouldHave(text("Using JUnit5 extend")).scrollIntoView(false);
        // screenshot("scrin.jpg");

    }

}

