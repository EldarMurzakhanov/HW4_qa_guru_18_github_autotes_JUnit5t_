package github;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideWikiPageTest {

    @Test
    void SelenideWikiPageSoftAssertionsContainsJUnit5Example() {
        //1.Откройте страницу Selenide в Github
        open("https://github.com/selenide/selenide");
        //2.Перейдите в раздел Wiki проекта
        $("#wiki-tab").click();
        //3.Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
        $("div.js-wiki-sidebar-toggle-display").$(byText("Show 2 more pages…")).click();
        //4.Откройте страницу SoftAssertions
        $(byText("SoftAssertions")).click();
        //5.проверьте что внутри есть пример кода для JUnit5
        $("#user-content-3-using-junit5-extend-test-class").parent().sibling(0)
                .shouldHave(text("@ExtendWith({SoftAssertsExtension.class})\n" +
                        "class Tests {\n" +
                        "  @Test\n" +
                        "  void test() {\n" +
                        "    Configuration.assertionMode = SOFT;\n" +
                        "    open(\"page.html\");\n" +
                        "\n" +
                        "    $(\"#first\").should(visible).click();\n" +
                        "    $(\"#second\").should(visible).click();\n" +
                        "  }\n" +
                        "}"));
    }
}
