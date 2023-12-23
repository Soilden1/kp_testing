package dimacm14.api.steps;

import dimacm14.api.modeles.RegistrationBodyModel;
import dimacm14.api.modeles.RegistrationResponseModel;
import io.qameta.allure.Step;

import static dimacm14.api.specs.TestSpecs.bodyRequestSpec;
import static dimacm14.api.specs.TestSpecs.responseSpec;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class RegistrationSteps {

    @Step("Регистрация с валидными логином и паролем")
    public void successfulSingUp(String username, String password) {
        RegistrationBodyModel registrationBody = new RegistrationBodyModel();
        registrationBody.setUsername(username);
        registrationBody.setPassword(password);

        step("При регистрации с валидными логином и паролем ответ имеет код статуса 200", () ->
                given(bodyRequestSpec)
                        .body(registrationBody)
                        .when()
                        .post("/signup")
                        .then()
                        .spec(responseSpec)
                        .statusCode(200));
    }

    @Step("Регистрация уже существующего пользователя")
    public void unsuccessfulAlreadyExistSingUp(String username, String password) {
        RegistrationBodyModel registrationBody = new RegistrationBodyModel();
        registrationBody.setUsername(username);
        registrationBody.setPassword(password);

        RegistrationResponseModel registrationResponse =
                step("При регистрации с уже существующего пользователя возникает ошибка", () ->
                        given(bodyRequestSpec)
                                .body(registrationBody)
                                .when()
                                .post("/signup")
                                .then()
                                .spec(responseSpec)
                                .statusCode(200)
                                .extract().as(RegistrationResponseModel.class));

        step("Проверить текст ошибки", () ->
                assertThat(registrationResponse.getErrorMessage().equals("This user already exist.")));
    }
}
