package tests;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.selector.ByAttribute;
import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;
import java.util.HashMap;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FirstTest {

    @BeforeAll
    static void beforeAll(){

        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1280";
        Configuration.holdBrowserOpen = true;


    }

    @Test
    void happyTest(){

        String name = "Lena";

        open("/text-box");

        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        $("[id=userName]").setValue(name);
        $("[id=userEmail]").setValue("ku4eremkoElena@gmail.com");
        $("[id=currentAddress]").setValue("Minsk");
        $("[id=permanentAddress]").setValue("Horlovka");
        $("[id=submit]").click();
        $("[id=output]").shouldHave(text("name"), text("ku4eremkoElena@gmail.com"),
                text("Minsk"), text("Horlovka"));
        System.out.println("All is good!");
        Configuration.timeout = 8000;


        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");




    }

    @Test
    void PracticeForm(){

        HashMap<String,String> Student = new HashMap<String,String>();
        Student.put("Name","Olena");
        Student.put("Last Name","Kucherenko");
        Student.put("Email","ku4erenkoElena@gmail.com");
        Student.put("Gender","Female");
        Student.put("Mobile","1234567890");
        Student.put("Year of birth","1987");
        Student.put("Month of birth","September");
        Student.put("Day of birth","5");
        Student.put("Subject","Computer Science");
        Student.put("Hobbies","Reading");
        Student.put("Picture","Kitten.jpg");
        Student.put("Address","Minsk");
        Student.put("State","Rajasthan");
        Student.put("City","Jaipur");


        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        $("#firstName").setValue(Student.get("Name"));
        $("#lastName").setValue(Student.get("Last Name"));
        $("#userEmail").setValue(Student.get("Email"));
        $("#genterWrapper").$(byText(Student.get("Gender"))).click();
        $("#userNumber").setValue(Student.get("Mobile"));
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(Student.get("Month of birth"));
        $(".react-datepicker__year-select").selectOption(Student.get("Year of birth"));
        //$("[aria-label='Choose Saturday, September 5th, 1987']").click();
        $("[aria-label='Choose Saturday, "+Student.get("Month of birth")+" "+Student.get("Day of birth")+"th, "+Student.get("Year of birth")+"']").click();
        $("#subjectsInput").sendKeys("C");
        $(byText(Student.get("Subject"))).click();
        $("#hobbiesWrapper").$(byText(Student.get("Hobbies"))).click();
        File file = new File("src/test/resources/"+Student.get("Picture"));
        $("#uploadPicture").uploadFile(file);
        $("#currentAddress").setValue(Student.get("Address"));

        //$("[id=react-select-4-input]").click();
        $("#state").click();
        $(byText(Student.get("State"))).click();
        $("#city").click();
        $(byText(Student.get("City"))).click();
        $("#submit").click();


        Student.forEach((k,v)->
                $(".table-responsive").shouldHave(text(Student.get(k)))

        );

        $("#closeLargeModal").click();


//










    }


}
