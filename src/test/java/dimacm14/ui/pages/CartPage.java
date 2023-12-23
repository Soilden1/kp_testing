package dimacm14.ui.pages;

import com.codeborne.selenide.SelenideElement;
import dimacm14.ui.pages.components.Header;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class CartPage {

    private final Header header = new Header();
    SelenideElement placeOrderButton = $(".btn-success"),
            nameInput = $("#name"),
            countryInput = $("#country"),
            cityInput = $("#city"),
            cardInput = $("#card"),
            monthInput = $("#month"),
            yearInput = $("#year"),
            purchaseButton = $(byText("Purchase"));

    @Step("Нажать кнопку 'Place Order'")
    public CartPage placeOrderSubmit() {
        placeOrderButton.click();
        sleep(500);
        return this;
    }

    @Step("Нажать кнопку 'Purchase'")
    public CartPage purchaseSubmit() {
        purchaseButton.click();
        return this;
    }

    @Step("Ввести имя")
    public CartPage setName(String name) {
        nameInput.setValue(name);
        return this;
    }

    @Step("Ввести страну")
    public CartPage setCountry(String country) {
        countryInput.setValue(country);
        return this;
    }

    @Step("Ввести город")
    public CartPage setCity(String city) {
        cityInput.setValue(city);
        return this;
    }

    @Step("Ввести карту")
    public CartPage setCard(String card) {
        cardInput.setValue(card);
        return this;
    }

    @Step("Ввести месяц")
    public CartPage setMonth(String month) {
        monthInput.setValue(month);
        return this;
    }

    @Step("Ввести год")
    public CartPage setYear(String year) {
        yearInput.setValue(year);
        return this;
    }

    @Step("Проверить оформление заказа")
    public CartPage checkPurchase() {
        $(".sweet-alert").shouldHave(text("Thank you for your purchase!"));
        return this;
    }
}
