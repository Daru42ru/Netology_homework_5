package page;

import com.codeborne.selenide.SelenideElement;
import data.DataGenerator;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;

public class MoneyTransferPage {
    private SelenideElement heading = $(withText("Пополнение карты"));
    private final SelenideElement amount = $("[data-test-id=amount] input");
    private final SelenideElement from = $("[data-test-id=from] input");
    private final SelenideElement transferButton = $("[data-test-id=action-transfer]");
    private final SelenideElement cancelButton = $("[data-test-id=action-transfer]");
    private final SelenideElement error = $("[data-test-id=error-notification]");

    public MoneyTransferPage() {
        heading.shouldBe(visible);
    }

    public DashboardPage transferForm(String sum, DataGenerator.CardNumber cardNumber) {
        amount.setValue(sum);
        from.setValue(String.valueOf(cardNumber));
        transferButton.click();
        return new DashboardPage();

    }

    public void getError() {
        $(byText("Ошибка!")).shouldBe(visible);
    }

    public DashboardPage cancelButton() {
        cancelButton.click();
        return new DashboardPage();
    }
}
