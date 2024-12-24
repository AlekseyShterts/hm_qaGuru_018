package tests;

import data.DataForTest;
import helpers.WithLogin;
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
        WorkWithBooksSteps booksSteps = new WorkWithBooksSteps();
        ProfilePage page = new ProfilePage();
        DataForTest data = new DataForTest();

        booksSteps.deleteAllBookAPI();
        booksSteps.addBookAPI(data.isbn);
        page.openPageUI();
        page.checkUserNameUI();
        page.checkAddedBookUI("Addy Osmani");
        page.deleteBookUI();
        page.checkProfileIsEmptyUI();

    }
}
