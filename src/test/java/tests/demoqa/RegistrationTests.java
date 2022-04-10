package tests.demoqa;

import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationTests extends TestBase {

    @Test
    void fillPracticeForm() {
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("Robin");
        $("#lastName").setValue("Hood");
        $("#userEmail").setValue("forhonor@gmail.com");
        $(byText("Male")).click();
        $("#userNumber").setValue("1234567891");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").find(byText("July")).click();
        $(".react-datepicker__year-select").find(byText("1900")).click();
        $(".react-datepicker__day--013").click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $("#hobbiesWrapper").find(byText("Reading")).click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/img/1.png"));
        $("#currentAddress").setValue("unknown");
        $("#state").click();
        $("#react-select-3-input").setValue("Haryana").pressEnter();
        $("#city").click();
        $("#react-select-4-input").setValue("Panipat").pressEnter();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").$(byText("Student Name"))
                .parent().shouldHave(text("Robin Hood"));

    }
}