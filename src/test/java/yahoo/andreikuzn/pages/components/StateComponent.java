package yahoo.andreikuzn.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class StateComponent {

    private SelenideElement stateInput = $("#state");

    public void setState(String state) {
        stateInput.click();
        $(byText(state)).click();
    }
}
