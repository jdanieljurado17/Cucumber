package io.cucumber.DemoBlaze.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    WebDriver driver;
    public MainPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    // Locators for the Sign Up

    @FindBy(id = "sign-username")
    WebElement usernameSignUp;
    @FindBy(id = "sign-password")
    WebElement passwordSignUp;
    @FindBy(xpath = "//button[@onclick='register()']")
    WebElement confirmSignUpButton;

    //Locators of the nav - bar
    @FindBy(xpath = "//a[@data-target='#exampleModal']")
    WebElement contactButton;
    @FindBy(id = "signin2")
    WebElement signUpButton;
    @FindBy(id = "cartur")
    WebElement cartButton;
    @FindBy(xpath = "//li[@class='nav-item active'] //a[contains(@href, 'index')]")
    WebElement homeButton;

    //Locators for contact form
    @FindBy(id = "recipient-email")
    WebElement emailContact;
    @FindBy(id = "recipient-name")
    WebElement nameContact;
    @FindBy(id = "message-text")
    WebElement messageContact;
    @FindBy(xpath = "//button[@onclick='send()']")
    WebElement contactButtonConfirmation;

    //Locators for Slider
    @FindBy(xpath = "//span[@class='carousel-control-prev-icon']")
    WebElement prevIconButton;

    // Sign Up Locators methods
    public WebElement signUpButton(){
        return signUpButton;
    }
    public WebElement usernameSignUp(){
        return usernameSignUp;
    }
    public WebElement passwordSignUp(){
        return passwordSignUp;
    }
    public WebElement confirmSignUpButton(){
        return confirmSignUpButton;
    }

    //Contact form locators
    public WebElement contactButton(){
        return contactButton;
    }
    public WebElement emailContact(){
        return emailContact;
    }
    public WebElement nameContact(){
        return nameContact;
    }
    public WebElement messageContact(){
        return messageContact;
    }
    public WebElement contactButtonConfirmation(){
        return contactButtonConfirmation;
    }

    //Methods for nav - bar locators
    public WebElement cartButton(){return cartButton;}
    public WebElement homeButton(){return homeButton;}
}
