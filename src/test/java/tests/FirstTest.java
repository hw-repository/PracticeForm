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

        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        System.out.println("Hello Elena");


    }



}
