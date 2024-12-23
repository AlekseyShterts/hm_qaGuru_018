package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import org.junit.jupiter.api.BeforeAll;
import io.qameta.allure.selenide.AllureSelenide;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import helpers.AllureAttachments;
import org.junit.jupiter.api.AfterEach;
import config.ConfigRunner;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;


public class BaseTest {

    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI = "https://demoqa.com";
        Configuration.baseUrl = "https://demoqa.com";

        new ConfigRunner();
    }

    @BeforeEach
    public void beforeEach() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        AllureAttachments.screenshotAs("Last screenshot");
        if (!Configuration.browser.equals("firefox")) {
            AllureAttachments.pageSource();
            AllureAttachments.browserConsoleLogs();
        }
        AllureAttachments.addVideo();
        closeWebDriver();
    }
}
