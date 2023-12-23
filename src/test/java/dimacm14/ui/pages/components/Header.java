package dimacm14.ui.pages.components;

import com.codeborne.selenide.SelenideElement;
import dimacm14.ui.pages.CartPage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class Header {

    private final SelenideElement cartButton = $("#cartur");

    @Step("Перейти в корзину")
    public CartPage goToCart() {
        cartButton.click();
        return new CartPage();
    }
}
