package yahoo.andreikuzn.tests;

import org.junit.jupiter.api.Test;

public class StudentRegistrationFormPageObject extends TestBase {

    @Test
    void fillRegFormTest() {

        registrationPage.openPage()
                .scrollPageUp()
                .typeFirstName(TestData.FIRSTNAME)
                .typeLastName(TestData.LASTNAME)
                .typeEmail(TestData.EMAIL)
                .makeGenderChoice(TestData.GENDER)
                .typePhone(TestData.PHONE)
                .typeBirthday(TestData.DAY, TestData.MONTH, TestData.YEAR)
                .typeSubject(TestData.SEARCHLETTER, TestData.SUBJECT)
                .typeHobby(TestData.HOBBY)
                .uploadImage(TestData.IMAGE)
                .typeAddress(TestData.ADDRESS)
                .typeState(TestData.STATE)
                .typeCity(TestData.CITY)
                .submitRegistration()
                .checkModalText()
                .checkRegistrationResults()
                .closeModalWidow();

    }
}
