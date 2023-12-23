package dimacm14.ui.pages;

import com.codeborne.selenide.SelenideElement;
import dimacm14.ui.pages.components.Header;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.dismiss;

public class ProductPage {

    private final Header header = new Header();
    private final SelenideElement addToCartButton = $(".btn-success");

    @Step("Добваить товар в корзину")
    public ProductPage addToCart() {
        addToCartButton.click();
        dismiss();
        return this;
    }

    @Step("Перейти в корзину")
    public CartPage goToCart() {
        return header.goToCart();
    }
}
