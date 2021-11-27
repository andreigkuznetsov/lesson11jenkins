package yahoo.andreikuzn.pages;

import com.codeborne.selenide.ElementsCollection;
import yahoo.andreikuzn.pages.components.CalendarComponent;
import com.codeborne.selenide.SelenideElement;
import yahoo.andreikuzn.pages.components.CityComponent;
import yahoo.andreikuzn.pages.components.StateComponent;
import yahoo.andreikuzn.pages.components.SubjectComponent;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static yahoo.andreikuzn.tests.TestData.EXPECTEDDATA;

public class RegistrationPage {

    private final String FORM_TITLE = "Student Registration Form",
            MODAL_TITLE = "Thanks for submitting the form";
    private SelenideElement
            formTitle = $(".practice-form-wrapper"),
            scrollPage = $("#submit"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderChoice = $("#genterWrapper"),
            phoneInput = $("#userNumber"),
            hobbyInput = $("#hobbiesWrapper"),
            photoUpload = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            submitForm = $("#submit"),
    //          resultsTable = $(".table-responsive"), локатор для assert без коллекции строк
    textModal = $("#example-modal-sizes-title-lg"),
            closeModal = $("#closeLargeModal");
    public CalendarComponent calendar = new CalendarComponent();
    public SubjectComponent subject = new SubjectComponent();
    public StateComponent state = new StateComponent();
    public CityComponent city = new CityComponent();

    public RegistrationPage openPage() {
        open("https://demoqa.com/automation-practice-form");
        formTitle.shouldHave(text(FORM_TITLE));

        return this;
    }

    public RegistrationPage scrollPageUp() {
        scrollPage.scrollIntoView(true);

        return this;
    }

    public RegistrationPage typeFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage typeLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage typeEmail(String value) {
        emailInput.setValue(value);

        return this;
    }

    public RegistrationPage makeGenderChoice(String value) {
        genderChoice.$(byText(value)).click();

        return this;
    }

    public RegistrationPage typePhone(String value) {
        phoneInput.setValue(value);

        return this;
    }

    public RegistrationPage typeHobby(String value) {
        hobbyInput.$(byText(value)).click();

        return this;
    }

    public RegistrationPage uploadImage(File image) {
        photoUpload.uploadFile(image);

        return this;
    }

    public RegistrationPage typeAddress(String value) {
        addressInput.setValue(value);

        return this;
    }

    public RegistrationPage submitRegistration() {
        submitForm.click();

        return this;
    }

    public RegistrationPage closeModalWidow() {
        closeModal.click();

        return this;
    }

    public RegistrationPage typeBirthday(String day, String month, String year) {
        calendar.setDate(day, month, year);

        return this;
    }

    public RegistrationPage typeSubject(String searchLetter, String subjects) {
        subject.setSubject(searchLetter, subjects);

        return this;
    }

    public RegistrationPage typeCity(String cities) {
        city.setCity(cities);

        return this;
    }

    public RegistrationPage typeState(String states) {
        state.setState(states);

        return this;
    }

    public RegistrationPage checkModalText() {
        textModal.shouldHave(text(MODAL_TITLE));

        return this;
    }

    // assert с коллекцией строк
    public RegistrationPage checkRegistrationResults() {
        ElementsCollection lines = $$(".table-responsive tbody tr").snapshot();
        for (SelenideElement line : lines) {
            String key = line.$("td").text();
            String expectedValue = EXPECTEDDATA.get(key);
            String actualValue = line.$("td", 1).text();
            assertEquals(expectedValue, actualValue, "The actual value is not equal to the expected value");
        }
        return this;
    }
    // assert без коллекции строк
      /* public RegistrationPage checkRegistrationResults(String key, String value) {
        resultsTable.shouldHave(text(key), text(value));
        return this;
    }*/
}