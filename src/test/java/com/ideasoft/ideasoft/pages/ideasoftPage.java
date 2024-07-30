package com.ideasoft.ideasoft.pages;


import com.ideasoft.framework.core.Asserts;
import com.ideasoft.framework.core.Commands;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


@Getter
public class ideasoftPage
{

        @FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/form/input")
        private  WebElement searchBox;
        @FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/form/button")
        private  WebElement searchBtn;
        @FindBy(xpath = "//*[@id=\"results-page\"]/div[2]/div/div/div/div[3]/div[1]/div[1]")
        private  WebElement detailBtn;
        @FindBy(xpath = "//*[@id=\"product-detail-container\"]/div[1]/div/div[2]/div/div[4]/div[1]/div")
        private  WebElement quantityDropdown;
        @FindBy(xpath = "//*[@id=\"qty-input\"]")
        private  WebElement chooseQuantity;
        @FindBy(xpath = "//*[@id=\"product-detail-container\"]/div[1]/div/div[2]/div/div[4]/div[2]/div/div")
        private  WebElement addToBasketBtn;
        @FindBy(xpath = "//div[contains(@class, 'shopping-information-cart-inside')]")
        private  WebElement verifyMessage;
        @FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div[3]/div/div[3]/a")
        private  WebElement goToBasket;
        @FindBy(xpath = "//*[contains(@value, \"5\")]")
        private  WebElement verifyQuantity;




        /***********Constructor*************/
        public ideasoftPage(WebDriver driver)
        {
            PageFactory.initElements(driver, this);
        }

        /***********Commons Methods*************/
        @Step("ideasoftta ürün arar")
        public void searchOnIdeasoft(String urun)
        {
                Commands.Click(searchBox);
                Commands.SendKeys(searchBox,urun);
                Commands.Click(searchBtn);
        }
        @Step("ürün detayına gider")
        public void goToDetail()
        {
                Commands.Click(detailBtn);
        }
        @Step("sepete ekleme")
        public void addtoBasket()
        {
                Commands.Click(quantityDropdown);
                Select sayi = new Select(chooseQuantity);
                sayi.selectByVisibleText("5");
                Commands.Click(addToBasketBtn);
                Commands.Delay(2);
        }
        public void verifySuccessMessage(String verifyMessageText)
        {
                Asserts.AssertTrue(verifyMessage,verifyMessageText);
                Commands.Delay(2);
        }
        public void goToBasket(String value)
        {
                Commands.Click(goToBasket);
                Commands.Delay(2);
                if(verifyQuantity.getAttribute("value").equals(value)) {
                        System.out.println("Sepetteki sayı doğrulandı");
                }
                else {
                        System.out.println("Sepetteki sayı doğrulanamadı");
                        Assert.fail();
                }

        }




}

