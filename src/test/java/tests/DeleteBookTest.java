package tests;

import data.DataTest;
import helpers.WithLogin;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import pages.ProfilePage;
import tests.steps.WorkWithBooksSteps;

public class DeleteBookTest extends BaseTest {

    @Test
    @WithLogin
    @DisplayName("Проверка удаления книг из профиля")
    @Tag("smoke")
    void addedDeletedItemTest() {
        WorkWithBooksSteps booksSteps = new WorkWithBooksSteps();
        ProfilePage page = new ProfilePage();
        DataTest data = new DataTest();

        booksSteps.deleteAllBookAPI();
        booksSteps.addBookAPI(data.isbn);
        page.openPageUI();
        page.checkUserNameUI();
        page.checkAddedBookUI();
        page.deleteBookUI();
        page.checkProfileIsEmptyUI();

    }
}
