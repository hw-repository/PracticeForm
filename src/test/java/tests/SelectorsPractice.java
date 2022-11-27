package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class SelectorsPractice {


    @BeforeAll
    static void beforeAll() {

        Configuration.baseUrl = "https://magento.softwaretestingboard.com";
        Configuration.browserSize = "1920x1280";
        Configuration.holdBrowserOpen = true;

    }

    @Test
    void BuyStaff(){

        open("/men/tops-men/jackets-men.html");
        SelenideElement menMenuItem = $(By.xpath("//ul[@role='menu']//descendant::span[contains(text(),'Men')]"));
        SelenideElement menTopsMenuItem = $(By.xpath("//ul[@role='menu']//descendant::a[contains(@href,'tops-men')]"));
        SelenideElement styleShoppingOption =$(By.xpath("//div[@class='filter-options']/descendant::div[contains(text(),'Style')]"));
        SelenideElement rainCoatOption = $(By.xpath("//ol[@class='items']//descendant::a[contains(text(),'Rain Coat')]"));
        SelenideElement listMode = $(By.xpath("//a[@id='mode-list']"));
        SelenideElement selectSorter = $(By.xpath("//select[@id='sorter']"));
        SelenideElement sortByPrice = $(By.xpath("//select[@id='sorter']/option[@value='price']"));
        SelenideElement lSize = $(By.xpath("//li[@class='item product product-item']/div[1]//descendant::div[@option-label='L']"));
        SelenideElement yellowColour = $(By.xpath("//li[@class='item product product-item']/div[1]//descendant::div[@option-label='Yellow']"));
        SelenideElement addToCard = $(By.xpath("//li[@class='item product product-item']/div[1]//descendant::button[@type='submit']"));
        SelenideElement itemName = $(By.xpath("//li[@class='item product product-item']/div[1]//descendant::a[@class='product-item-link']"));
        SelenideElement itemPrice = $(By.xpath("//li[@class='item product product-item']/div[1]//descendant::span[@class='price']"));
        SelenideElement shoppingCart = $(By.xpath("//div[@data-block='minicart']/a"));
        SelenideElement addedItems = $(By.xpath("//span[@class='counter-number']"));
        SelenideElement itemNameOnCart = $(By.xpath("//ol[@id='mini-cart']//li[1]//strong[@class='product-item-name']"));
        SelenideElement itemPriceOnCart = $(By.xpath("//ol[@id='mini-cart']//li[1]//span[@class='price']"));
        SelenideElement itemQuantityOnCart =  $(By.xpath("//ol[@id='mini-cart']//li[1]//input"));
        SelenideElement removeItem = $(By.xpath("//ol[@id='mini-cart']//li[1]//a[@title='Remove item']"));
        SelenideElement confirmDelete = $(By.xpath("//button[@class='action-primary action-accept']"));
        SelenideElement dropDownDialogContent = $(By.xpath("//strong[@class='subtitle empty']"));

        menMenuItem.hover();
        menTopsMenuItem.click();
        styleShoppingOption.click();
        rainCoatOption.click();
        listMode.click();
        selectSorter.click();
        sortByPrice.click();
        String name = itemName.text();
        String price = itemPrice.text();
        lSize.click();
        yellowColour.click();
        addToCard.click();
        addedItems.shouldHave(exactText("1"));
        shoppingCart.click();
        itemNameOnCart.shouldHave(text(name));
        itemPriceOnCart.shouldHave(text(price));
        itemQuantityOnCart.shouldHave(attribute("data-item-qty","1"));
        removeItem.click();
        confirmDelete.shouldBe(visible).click();
        dropDownDialogContent.shouldBe(visible).shouldHave(text("You have no items in your shopping cart."));



    }
}
