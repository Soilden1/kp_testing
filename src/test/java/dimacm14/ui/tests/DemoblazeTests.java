package dimacm14.ui.tests;

import dimacm14.ui.pages.HomePage;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.Story;
import io.qameta.allure.testng.Tag;
import org.testng.annotations.Test;

import static io.qameta.allure.SeverityLevel.BLOCKER;

@Feature("Оформление заказа")
@Tag("Smoke")
@Severity(BLOCKER)
public class DemoblazeTests extends TestBase {

    HomePage homePage = new HomePage();

    @Story("Выбор и фоормление заказа")
    @Test(description = "Выбрать и заказать товар")
    void selectAndPurchaseProduct() {
        homePage.openPage()
                .selectProduct("Samsung galaxy s6")
                .addToCart()
                .goToCart()
                .placeOrderSubmit()
                .setName("Ivan")
                .setCountry("Russia")
                .setCity("Moskow")
                .setCard("8888-8888-8888-8888")
                .setMonth("October")
                .setYear("2023")
                .purchaseSubmit()
                .checkPurchase();
    }
}
