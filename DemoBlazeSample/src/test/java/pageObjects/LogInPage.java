package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LogInPage {
    WebDriver driver;

    public LogInPage(WebDriver driver) {
        this.driver=driver;
    }

    //variables
    String randomNumber = String.valueOf(Math.random()).substring(2, 5);
    String randomUsername = "thisTest" + randomNumber;
    String password = "Thisisapassword";
    String singMessage = "Sign up successful.";
    String email = "this@email.com";

    //Locators for Sign up
    private By signUpButton = By.id("signin2");
    private By usernameSignUp = By.id("sign-username");
    private By passwordSignUp = By.id("sign-password");
    private By confirmSignUpButton = By.xpath("//button[@onclick='register()']");

    // Login sign up
    private By loginButton = By.id("login2");
    private By usernameLogIn = By.id("loginusername");
    private By passwordLogIn = By.id("loginpassword");
    private By confirmLogInButton = By.xpath("//button[@onclick='logIn()']");

    //Locators contact form
    private By contactButton = By.xpath("//a[@data-target='#exampleModal']");
    private By emailContact = By.id("recipient-email");
    private By nameContact = By.id("recipient-name");
    private By messageContact = By.id("message-text");
    private By contactButtonConfirmation = By. xpath("//button[@onclick='send()']");

    // Methods

    public void fillLogInForm(String username, String password){
        driver.findElement(loginButton).click();
        driver.findElement(usernameLogIn).sendKeys(username);
        driver.findElement(passwordLogIn).sendKeys(password);
        driver.findElement(confirmLogInButton).click();
    }
    public void validateUserIsLoggedIn(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement button = driver.findElement(confirmLogInButton);
        wait.until(ExpectedConditions.invisibilityOf(button));
    }


    public String  getURL(){
        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);
        return  currentUrl;
    }

    public void signingIntoWebsite(){
        driver.findElement(signUpButton).click();
        driver.findElement(usernameSignUp).sendKeys(randomUsername);
        driver.findElement(passwordSignUp).sendKeys(password);
        driver.findElement(confirmSignUpButton).click();
    }

    public void validateSignUp(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());
        String textAlert = driver.switchTo().alert().getText();
        System.out.println(textAlert);
        Assert.assertEquals(textAlert, singMessage);
        driver.switchTo().alert().accept();
    }
    public void fillContactForm(String email, String name, String message){
        driver.findElement(contactButton).click();
        driver.findElement(emailContact).sendKeys(email);
        driver.findElement(nameContact).sendKeys(name);
        driver.findElement(messageContact).sendKeys(message);
        driver.findElement(contactButtonConfirmation).click();
    }

    public void validateContactForm(){
        String alertText = driver.switchTo().alert().getText();
        System.out.println(alertText);
        Assert.assertEquals(alertText, "Thanks for the message!!");
        driver.switchTo().alert().accept();
    }
}
