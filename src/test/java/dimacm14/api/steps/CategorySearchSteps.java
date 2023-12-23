package dimacm14.api.steps;

import dimacm14.api.modeles.CategorySearchBodyModel;
import dimacm14.api.modeles.CategorySearchResponseModel;

import io.qameta.allure.Step;

import static dimacm14.api.specs.TestSpecs.bodyRequestSpec;
import static dimacm14.api.specs.TestSpecs.responseSpec;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class CategorySearchSteps {

    @Step("Поиска товаров по категории")
    public void searchByCategory(String category) {
        CategorySearchBodyModel categorySearchBody = new CategorySearchBodyModel();
        categorySearchBody.setCat(category);

        CategorySearchResponseModel categorySearchResponse =
                step("При поиске товаров по категории ответ имеет код статуса 200", () ->
                        given(bodyRequestSpec)
                                .body(categorySearchBody)
                                .when()
                                .post("/bycat")
                                .then()
                                .spec(responseSpec)
                                .statusCode(200)
                                .extract().as(CategorySearchResponseModel.class));

        step("В списке товаров отображаются только товары запрашиваемой категории", () ->
                assertThat(categorySearchResponse.getItems()[0].getCat().equals(category)));
    }
}
