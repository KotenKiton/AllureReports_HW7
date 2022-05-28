package qa.guru.allure;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;


import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;


public class SelenideTest {

    @BeforeAll
    static void setUp() {
        Configuration.holdBrowserOpen = true; //
        Configuration.baseUrl = "https://github.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    public void testGithubIssue(){
        open("https://github.com");

        $(".header-search-input").click();
        $(".header-search-input").sendKeys("eroshenkoam/allure-example");
        $(".header-search-input").submit();

        $(linkText("eroshenkoam/allure-example")).click(); // By.linkText - это селектор!
        $(By.partialLinkText("POPA")).click(); //  By.partialLinkText  - поиск по частичному тексту.
        $(withText("#76")).click();
    }

}
