package yahoo.andreikuzn.tests;

import com.github.javafaker.Faker;

import java.io.File;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class TestData {

    public static Faker FAKER = new Faker(new Locale("ru"));
    public static File IMAGE = new File("src/test/resources/pic.jpg");

    static String FIRSTNAME = FAKER.name().firstName(),
            LASTNAME = FAKER.name().lastName(),
            ADDRESS = FAKER.address().streetAddress(),
            PHONE = FAKER.numerify("9#########"),
            GENDER = FAKER.options().option("Female", "Male", "Other"),
            HOBBY = FAKER.options().option("Music", "Reading", "Sports");

    public static String IMAGENAME = "pic.jpg",
            EMAIL = "andrey@smith.com",
            MONTH = "October",
            YEAR = "1996",
            DAY = "30",
            SEARCHLETTER = "c",
            SUBJECT = "Economics",
            STATE = "Rajasthan",
            CITY = "Jaiselmer";
    // assert с коллекцией строк
    public static Map<String, String> EXPECTEDDATA = new HashMap<String, String>() {{
        put("Student Name", FIRSTNAME + " " + LASTNAME);
        put("Student Email", EMAIL);
        put("Gender", GENDER);
        put("Mobile", PHONE);
        put("Date of Birth", DAY + " " + MONTH + "," + YEAR);
        put("Subjects", SUBJECT);
        put("Hobbies", HOBBY);
        put("Picture", IMAGENAME);
        put("Address", ADDRESS);
        put("State and City", STATE + " " + CITY);
    }};

    /*      assert без коллекции строк
    public static checkRegistrationResults ("Student name", TestData.FIRSTNAME + " " + TestData.LASTNAME)
            .checkRegistrationResults("Student Email", TestData.EMAIL)
            .checkRegistrationResults("Gender", TestData.GENDER)
            .checkRegistrationResults("Mobile", TestData.PHONE)
            .checkRegistrationResults("Date of Birth", TestData.DAY + " " + TestData.MONTH + "," + TestData.YEAR)
            .checkRegistrationResults("Subjects", TestData.SUBJECT)
            .checkRegistrationResults("Hobbies", TestData.HOBBY)
            .checkRegistrationResults("Picture", TestData.IMAGENAME)
            .checkRegistrationResults("Address", TestData.ADDRESS)
            .checkRegistrationResults("State and City", TestData.STATE + " " + TestData.CITY);*/


}
