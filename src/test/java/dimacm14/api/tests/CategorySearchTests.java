package dimacm14.api.tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.Story;
import io.qameta.allure.testng.Tag;
import org.testng.annotations.Test;

import static io.qameta.allure.SeverityLevel.BLOCKER;

@Feature("Поиск по категориям")
@Tag("Smoke")
@Severity(BLOCKER)
public class CategorySearchTests extends BaseTest {

    @Story("Успешный поиск по категории")
    @Test(description = "Поиска товаров по категории 'monitor'")
    void searchByCategoryTest() {
        CATEGORY_SEARCH_STEPS.searchByCategory("monitor");
    }
}
