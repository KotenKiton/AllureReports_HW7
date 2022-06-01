package qa.guru.allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

// Переиспользование степов
public class WebSteps {

    @Step("Открываем главную страницу")
    public void openMainPage() {
        open("https://github.com");
    }


    @Step("Ищем репозиторий {repo}")
    public void searchForRepository(String repo) {
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(repo);
        $(".header-search-input").submit();
        attachScreenshot(); // сделай в этом месте скриншот
    }

    @Step("Переходим по ссылке репозитория {repo} ")
    public void clickOnRepositoryLink(String repo) {
        $(linkText(repo)).click();
    }


    @Step("Кликакаем на таб Issues {repo} ")
    public void openIssuesTab() {
        $(By.partialLinkText("Issues")).click();
    }

    @Step("Проверяем что существует Issue c номером {number} ")
    public void shouldSeeIssuesWithNumber(int number) {
        $(withText("#" + number)).shouldBe(Condition.visible);
        attachScreenshot(); // сделай в этом месте скриншот
    }
    // Аннотация для создания скриншота.

    // При степовом подходе ( как в этом классе) Лучше использовать анотацию как ниже.
    @Attachment(value = "Топовый скрин", type = "image/png", fileExtension = "png" )
    public byte [] attachScreenshot (){
        return ((TakesScreenshot)WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
