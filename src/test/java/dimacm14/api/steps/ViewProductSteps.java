package dimacm14.api.steps;

import dimacm14.api.modeles.ProductResponseModel;
import dimacm14.api.modeles.ViewProductBodyModel;
import io.qameta.allure.Step;

import static dimacm14.api.specs.TestSpecs.bodyRequestSpec;
import static dimacm14.api.specs.TestSpecs.responseSpec;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class ViewProductSteps {

    @Step("Посмотреть товар")
    public void view(String id) {
        ViewProductBodyModel viewProductBody = new ViewProductBodyModel();
        viewProductBody.setId(id);

        ProductResponseModel productResponse =
                step("При просмотре товара ответ имеет код статуса 200", () ->
                        given(bodyRequestSpec)
                                .body(viewProductBody)
                                .when()
                                .post("/view")
                                .then()
                                .spec(responseSpec)
                                .statusCode(200)
                                .extract().as(ProductResponseModel.class));

        step("Идентификатор просматриваемого товара соответствует запрашиваемому", () ->
                assertThat(id.equals(productResponse.getId())));
    }
}
