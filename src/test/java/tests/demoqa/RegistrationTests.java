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
        $("#firstName").setValue("Oksana");
        $("#lastName").setValue("Bel");
        $("#userEmail").setValue("web@gmail.com");
        $(byText("Female")).click();
        $("#userNumber").setValue("1234567891");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").find(byText("July")).click();
        $(".react-datepicker__year-select").find(byText("1991")).click();
        $(".react-datepicker__day--013").click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $("#hobbiesWrapper").find(byText("Reading")).click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/img/1.png"));
        $("#currentAddress").setValue("bla bla bla");
        $("#state").click();
        $("#react-select-3-input").setValue("Haryana").pressEnter();
        $("#city").click();
        $("#react-select-4-input").setValue("Panipat").pressEnter();

        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("Oksana"), text("Bel"));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text("web@gmail.com"));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Female"));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("1234567891"));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text("13 July,1991"));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text("Maths"));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text("Reading"));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text("task1.jpg"));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text("bla bla bla"));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text("Haryana"), text("Panipat"));

        $("#closeLargeModal").click();

    }
}