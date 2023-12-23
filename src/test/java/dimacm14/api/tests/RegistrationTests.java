package dimacm14.api.tests;

import com.github.javafaker.Faker;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.Story;
import io.qameta.allure.testng.Tag;
import org.testng.annotations.Test;

import static io.qameta.allure.SeverityLevel.BLOCKER;

@Feature("Регистрация")
@Tag("Smoke")
@Severity(BLOCKER)
public class RegistrationTests extends BaseTest {

    @Story("Успешная регистрация")
    @Test(description = "Регистрация с валидными логином и паролем")
    void successfulSingUpTest() {
        Faker faker = new Faker();
        REGISTRATION_STEPS.successfulSingUp(faker.name().username(), faker.internet().password());
    }

    @Story("Неуспешная регистрация")
    @Test(description = "Регистрация уже существующего пользователя")
    void unsuccessfulAlreadyExistSingUpTest() {
        REGISTRATION_STEPS.unsuccessfulAlreadyExistSingUp("querty123", "querty123");
    }
}
