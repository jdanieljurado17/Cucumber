package io.cucumber.DemoBlaze.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage {
    WebDriver driver;
    public LogInPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    //Locators for LogIn Page
    @FindBy(id = "login2")
    WebElement loginButton;
    @FindBy(id = "loginusername")
    WebElement usernameLogIn;
    @FindBy(id = "loginpassword")
    WebElement passwordLogIn;
    @FindBy(xpath = "//button[@onclick='logIn()']")
    WebElement confirmLogInButton;
    @FindBy(id = "nameofuser")
    WebElement nameOfUser;

    //Methods for LogIn locators

    public WebElement loginButton(){
        return loginButton;
    }
    public WebElement usernameLogIn(){
        return usernameLogIn;
    }
    public WebElement passwordLogIn(){
        return passwordLogIn;
    }
    public WebElement confirmLogInButton(){
        return confirmLogInButton;
    }
    public WebElement nameOfUser(){
        return nameOfUser;
    }
}
