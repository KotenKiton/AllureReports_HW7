package qa.guru.allure;


import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.annotation.*;


public class LabelsTest {

    @Test
    @Owner("Pavel")
    @Severity(SeverityLevel.BLOCKER)
    @Feature("Задачи в репозитории")// фича - что отделяемо
    @Story("Просмотр созданных задач в репозитории")// Story - пользовательский сценарий
    @IssueShow
    @DisplayName("Мой любимый тест")
    @Link(value = "Тестинг", url = "https://github.com")

    public void testAnnotated() {
    }

    @Test
    public void testCode() {
        Allure.label("owner", "Pavel");
        Allure.label("severity", SeverityLevel.CRITICAL.value());
        Allure.feature("Задачи в репозитории");
        Allure.story("Просмотр созданных задач в репозитории");
        Allure.link("Тестинг",  "https://github.com");
    }

    @Documented
    @Owner("Pavel")
    @Severity(SeverityLevel.BLOCKER)
    @Feature("Задачи в репозитории")// фича - что отделяемо
    @Story("Просмотр созданных задач в репозитории")// Story - пользовательский сценарий
    @Target({ ElementType.TYPE, ElementType.METHOD })
    @Retention(RetentionPolicy.RUNTIME)
    // Разбить продукт на фичи а фичи на тесты.
    public @interface IssueShow {

    }

    @Test
    @DisplayName("Любимый параметрайзед тест!")
    public void testCity (){
        Allure.parameter("Регион", "Московская область");
        Allure.parameter("Город", "Москва");

    }

}

