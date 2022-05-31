package qa.guru.allure;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;


public class AnnotatedStepTest {

    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final int ISSUE_NUMBER = 68;

    @BeforeAll
    static void setUp() {
        Configuration.holdBrowserOpen = true; //
        Configuration.baseUrl = "https://github.com";
        Configuration.browserSize = "1920x1080";
    }
    // Алюр позволяет сделать тесты наглядыми для всей команды а тесты могут использоваться как документация.
    @Test
    public void testGithubIssue() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        // лямбда выражение.
        // первым аргументов идёт строка вторым идёт функция.
        // Лямбда это сокращение того как выглядит метод
        step("Открываем главную страницу ", () -> {
            open("https://github.com");
        });
        step("Ищем репозиторий " + REPOSITORY, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys("eroshenkoam/allure-example");
            $(".header-search-input").submit();
        });
        step("Переходим по ссылке репозитория " + REPOSITORY, () -> {
            $(linkText(REPOSITORY)).click();
        });
        step("Кликакаем на таб Issues " + REPOSITORY, () -> {
            $(By.partialLinkText("Issues")).click();
        });
        step("Проверяем что существует Issue c номером " + ISSUE_NUMBER, () -> {
            $(withText("#76")).click();
        });
    }
}

