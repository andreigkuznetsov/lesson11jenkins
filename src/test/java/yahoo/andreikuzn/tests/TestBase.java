package yahoo.andreikuzn.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import configuration.ConfigurationSelenoidSets;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;
import yahoo.andreikuzn.pages.RegistrationPage;
import org.aeonbits.owner.ConfigFactory;

import static com.codeborne.selenide.Configuration.remote;

public class TestBase {

    static ConfigurationSelenoidSets cfg = ConfigFactory.create(ConfigurationSelenoidSets.class);
    RegistrationPage registrationPage = new RegistrationPage();

    @BeforeAll
    static void setup() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        Configuration.startMaximized = true;
        remote = String.format("https://%s:%s@%s",
                cfg.login(), cfg.password(), System.getProperty("remoteUrlSelenoid"));

        //Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub/";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);

        Configuration.browserCapabilities = capabilities;
    }

    @AfterEach
    public void tearDown() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}