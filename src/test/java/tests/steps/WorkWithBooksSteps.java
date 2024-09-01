package tests.steps;

import data.DataTest;
import io.qameta.allure.Step;
import models.AddBookBodyModel;

import static io.restassured.RestAssured.given;
import static specs.BookShopSpecs.*;


public class WorkWithBooksSteps {

    DataTest data = new DataTest();
    String token = AuthSteps.extractValueFromCookieString("token");
    AddBookBodyModel bookData = new AddBookBodyModel();
    String userID = AuthSteps.extractValueFromCookieString("userID");

    @Step("Добавление книги в профиль")
    public void addBookAPI(String isbn) {
        bookData.userId = userID;

        given(requestSpecification)
                .header("authorization", "Bearer " + token)
                .body(bookData)
                .when()
                .post("BookStore/v1/Books")
                .then()
                .spec(responseSpec201);
    }

    @Step("Удаление всех книг из профиля")
    public void deleteAllBookAPI() {
        bookData.userId = userID;
        bookData.setIsbn(data.isbn);
        given(requestSpecification)
                .header("authorization", "Bearer " + token)
                .queryParams("UserId", userID)
                .when()
                .delete("/BookStore/v1/Books")
                .then()
                .spec(responseSpec204);
    }

}
