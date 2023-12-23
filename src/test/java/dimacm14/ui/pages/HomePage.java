package dimacm14.ui.pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class HomePage {

    @Step("Открыть главную страницу")
    public HomePage openPage() {
        open("https://www.demoblaze.com/");
        return new HomePage();
    }

    @Step("Выбрать товар")
    public ProductPage selectProduct(String title) {
        $("#tbodyid").$(byText(title)).click();
        return new ProductPage();
    }
}
