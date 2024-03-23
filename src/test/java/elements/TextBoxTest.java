package elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

class TextBoxTest extends BaseElementsTest {
    private final String PAGE_URL = "https://demoqa.com/text-box";
    private SelenideElement fullNameField = $(By.id("userName"));
    private SelenideElement emailField = $(By.id("userEmail"));
    private SelenideElement currentAddressField = $(By.cssSelector("textarea#currentAddress"));
    private SelenideElement permanentAddressField = $(By.cssSelector("textarea#permanentAddress"));
    private SelenideElement fullNameOutput = $(By.id("name"));
    private SelenideElement emailOutput = $(By.id("email"));
    private SelenideElement currentAddressOutput = $(By.cssSelector("p#currentAddress"));
    private SelenideElement permanentAddressOutput = $(By.cssSelector("p#permanentAddress"));
    private SelenideElement submitButton = $(By.id("submit"));

    @Test
    void checkSubmitFullName() {
        String fullName = "Serhii Lapin";
        open(PAGE_URL);
        fullNameField.setValue(fullName);
        submitButton.scrollTo()
                .click();
        fullNameOutput.shouldHave(Condition.text(fullName));
    }

    @Test
    void checkSubmitValidEmailField() {
        String email = "test@test.com";
        open(PAGE_URL);
        emailField.setValue(email);
        submitButton.scrollTo()
                .click();
        emailOutput.shouldHave(Condition.text(email));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/listOfInvalidEmails.csv")
    void checkSubmitInvalidEmailField(String invalidEmail) {
        open(PAGE_URL);
        emailField.setValue(invalidEmail);
        submitButton.scrollTo()
                .click();
        emailField.scrollTo()
                .shouldHave(Condition.attribute("class", "mr-sm-2 field-error form-control"));
    }

    @Test
    void checkSubmitCurrentAddress() {
        String currentAddress = "Budapest, Viola 100, 777";
        open(PAGE_URL);
        currentAddressField.setValue(currentAddress);
        submitButton.scrollTo()
                .click();
        currentAddressOutput.shouldHave(Condition.text(currentAddress));
    }

    @Test
    void checkSubmitPermanentAddress() {
        String permanentAddress = "Budapest, Viola 100, 777";
        open(PAGE_URL);
        permanentAddressField.setValue(permanentAddress);
        submitButton.scrollTo()
                .click();
        permanentAddressOutput.shouldHave(Condition.text(permanentAddress));
    }

    @Test
    void checkSubmitAllTextFields() {
        String fullName = "Serhii Lapin";
        String email = "test@test.com";
        String currentAddress = "Budapest, Viola 100, 777";
        String permanentAddress = "Budapest, Viola 150, 1000";
        open(PAGE_URL);
        fullNameField.setValue(fullName);
        emailField.setValue(email);
        currentAddressField.setValue(currentAddress);
        permanentAddressField.setValue(permanentAddress);
        submitButton.scrollTo()
                .click();
        fullNameOutput.shouldHave(Condition.text(fullName));
        emailOutput.shouldHave(Condition.text(email));
        currentAddressOutput.shouldHave(Condition.text(currentAddress));
        permanentAddressOutput.shouldHave(Condition.text(permanentAddress));
    }
}
