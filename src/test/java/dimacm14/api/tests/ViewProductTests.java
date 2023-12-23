package dimacm14.api.tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.Story;
import io.qameta.allure.testng.Tag;
import org.testng.annotations.Test;

import static dimacm14.api.steps.Steps.VIEW_PRODUCT_STEPS;
import static io.qameta.allure.SeverityLevel.BLOCKER;

@Feature("Просмотр товара")
@Tag("Smoke")
@Severity(BLOCKER)
public class ViewProductTests {

    @Story("Просмотр товара по идентификатору")
    @Test(description = "Просмотреть товар с идентификатором '1'")
    void successfulSingUpTest() {
        VIEW_PRODUCT_STEPS.view("1");
    }
}
