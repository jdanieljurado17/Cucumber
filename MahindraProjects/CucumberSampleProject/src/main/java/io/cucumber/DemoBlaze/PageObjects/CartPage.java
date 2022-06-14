package io.cucumber.DemoBlaze.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    WebDriver driver;
    public CartPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    //products added locator
    @FindBy(xpath = "//td[normalize-space()='Samsung galaxy s6']")
    WebElement s6Added;
    @FindBy(xpath = "//a[normalize-space()='Delete']")
    WebElement deleteButton;

    //Credit card form and button
    @FindBy(xpath = "//button[@data-toggle='modal']")
    WebElement placeOrderButton;
    @FindBy(id = "totalp")
    WebElement totalCart;
    @FindBy(id = "totalm")
    WebElement totalModal;
    @FindBy(id = "name")
    WebElement nameCardHolder;
    @FindBy(id = "country")
    WebElement countryCardHolder;
    @FindBy(id = "city")
    WebElement cityCardHolder;
    @FindBy(id = "card")
    WebElement numberCard;
    @FindBy(id = "month")
    WebElement monthCard;
    @FindBy(id= "year")
    WebElement yearCard;
    @FindBy(xpath = "//button[normalize-space()='Purchase']")
    WebElement purchaseButton;
    @FindBy(xpath = "//button[@class='confirm btn btn-lg btn-primary']")
    WebElement confirmButton;

    //Methods
    public WebElement s6Added(){
        return s6Added;
    }
    public WebElement deleteButton(){
        return deleteButton;
    }
    public WebElement placeOrderButton(){
        return placeOrderButton;
    }
    public  WebElement totalCart(){
        return totalCart;
    }
    public WebElement totalModal(){
        return totalModal;
    }
    public WebElement nameCardHolder(){
        return nameCardHolder;
    }
    public WebElement countryCardHolder(){
        return countryCardHolder;
    }
    public WebElement cityCardHolder(){
        return cityCardHolder;
    }
    public WebElement numberCard(){
        return numberCard;
    }
    public WebElement monthCard(){
        return monthCard;
    }
    public WebElement yearCard(){
        return yearCard;
    }
    public WebElement purchaseButton(){
        return purchaseButton;
    }
    public WebElement confirmButton(){
        return confirmButton;
    }
}
