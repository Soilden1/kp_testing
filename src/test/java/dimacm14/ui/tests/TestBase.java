package dimacm14.ui.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import dimacm14.ui.helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.testng.annotations.AfterTest;

import static com.codeborne.selenide.Configuration.browser;
import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {

    @BeforeAll
    static void setUp() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://www.demoblaze.com/";
        Configuration.browserSize = "1920x1080";
        browser = "chrome";
        Configuration.holdBrowserOpen = false;
        Configuration.timeout = 10000;

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterTest
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        if (!browser.equals("firefox")) {
            Attach.browserConsoleLogs();
        }
        closeWebDriver();
    }
}
