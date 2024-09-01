package tests.steps;


import com.codeborne.selenide.WebDriverRunner;
import data.DataTest;
import io.qameta.allure.Step;
import org.openqa.selenium.Cookie;
import models.AuthBodyModel;
import models.AuthResposeModel;
import tests.BaseTest;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static io.restassured.RestAssured.given;
import static specs.BookShopSpecs.*;

public class AuthSteps extends BaseTest {

    @Step("Получаем данные для авторизации")
    public static AuthResposeModel getResponse() {
        AuthBodyModel authData = new AuthBodyModel();
        DataTest acc = new DataTest();
        authData.setUserName(acc.login);
        authData.setPassword(acc.password);


        return given(requestSpecification)
                .body(authData)
                .when()
                .post("Account/v1/Login")
                .then()
                .spec(responseSpec200)
                .extract().as(AuthResposeModel.class);

    }

    @Step("Подкладываем данные для авторизации в cookie")
    public static void setCookies(AuthResposeModel response) {
        open("/favicon.ico");
        getWebDriver().manage().addCookie(new Cookie("userID", response.getUserId()));
        getWebDriver().manage().addCookie(new Cookie("expires", response.getExpires()));
        getWebDriver().manage().addCookie(new Cookie("token", response.getToken()));
        open("");
    }

    public static String extractValueFromCookieString(String value) {
        String cookieValue = String.valueOf(WebDriverRunner.getWebDriver().manage().getCookieNamed(value));
        return cookieValue.substring(cookieValue.indexOf("=") + 1, cookieValue.indexOf(";"));
    }
}
