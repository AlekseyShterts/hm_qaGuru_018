package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ProfilePage {
    private SelenideElement emptyList = $(".rt-noData");
    private SelenideElement userName = $("#userName-value");
    private SelenideElement tableItem = $(".rt-tbody");
    private SelenideElement deleteButton = $("#delete-record-undefined");
    private SelenideElement okButton = $("#closeSmallModal-ok");



    @Step("открытие профиля")
    public ProfilePage openPageUI() {
        open("/profile");
        return this;
    }

    @Step("проверка отображения User Name в UI")
    public ProfilePage checkUserNameUI() {
        userName.shouldBe(text(System.getProperty("login")));
        return this;
    }

    @Step("проверка на удаление книг")
    public ProfilePage checkProfileIsEmptyUI() {
        emptyList.shouldHave(text("No rows found"));
        return this;
    }

    @Step("проверка наличия книг в UI")
    public void checkAddedBookUI(String value) {
        tableItem.shouldHave(text(value));
    }

    @Step("Удаление книги из списка")
    public ProfilePage deleteBookUI(){
        deleteButton.click();
        okButton.click();
        return this;
    }
}
