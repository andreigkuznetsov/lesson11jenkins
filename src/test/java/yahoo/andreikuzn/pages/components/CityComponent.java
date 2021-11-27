package yahoo.andreikuzn.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CityComponent {

    private SelenideElement cityInput = $("#city");

    public void setCity(String city) {
        cityInput.click();
        $(byText(city)).click();
    }
}
