package yahoo.andreikuzn.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class SubjectComponent {

    private SelenideElement subjectInput = $("#subjectsInput");

    public void setSubject(String searchLetter, String subject) {
        subjectInput.click();
        subjectInput.setValue(searchLetter);
        $(byText(subject)).click();
    }
}
