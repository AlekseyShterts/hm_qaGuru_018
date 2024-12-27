package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import data.BookData;
import helpers.WithLogin;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import pages.ProfilePage;
import api.WorkWithBooksSteps;

public class DeleteBookTest extends BaseTest {

    @Test
    @WithLogin
    @DisplayName("Проверка удаления книг из профиля")
    @Tag("Smoke")
    void addedDeletedItemTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        WorkWithBooksSteps booksSteps = new WorkWithBooksSteps();
        ProfilePage page = new ProfilePage();
        BookData data = new BookData();

        booksSteps.deleteAllBookAPI();
        booksSteps.addBookAPI(data.isbn);
        page.openPageUI();
        page.checkUserNameUI(System.getProperty("login"));
        page.checkAddedBookUI("Addy Osmani");
        page.deleteBookUI();
        page.checkProfileIsEmptyUI();

    }
}