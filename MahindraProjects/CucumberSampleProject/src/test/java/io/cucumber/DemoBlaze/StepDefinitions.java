package io.cucumber.DemoBlaze;


import io.cucumber.DemoBlaze.PageObjects.CategoryProductsPage;
import io.cucumber.DemoBlaze.PageObjects.LogInPage;
import io.cucumber.DemoBlaze.PageObjects.MainPage;
import io.cucumber.DemoBlaze.PageObjects.WebDriverSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StepDefinitions /*extends WebDriverSetup*/ {
//Declaring variables

    public String baseUrl = "https://www.demoblaze.com/index.html";
    public WebDriver driver;
    //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    String username = "thisTest47";
    String password = "thisTest1";
    String email = "thisemail@example.com";
    String name = "Joe Smith";
    String message = "This is a message hehehe";
    String country = "USA";
    String city = "Buffalo";
    String creditCard = "0000000";
    String expMonth = "00";
    String expYear = "00";

    public void setBaseUrl(){
        System.setProperty("webdriver.chrome.driver",".\\src\\test\\resources\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().window().maximize();
    }



    @Given("the website loaded")
    public void the_website_loaded() {
        // Write code here that turns the phrase above into concrete actions
        setBaseUrl();
    }

    @When("user clicks on Sign Up button")
    public void user_clicks_on_sign_up_button() {
        // Write code here that turns the phrase above into concrete actions
        MainPage mP = new MainPage(driver);
        mP.signUpButton().click();
    }

    @Then("user can type in data to sign up")
    public void user_can_type_in_data_to_sign_up() {
        // Write code here that turns the phrase above into concrete actions
        MainPage mP = new MainPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(mP.usernameSignUp()));
        mP.usernameSignUp().sendKeys(username);
        mP.passwordSignUp().sendKeys(password);
    }

    @Then("clicks on Sign Up to complete Signing Up")
    public void clicks_on_sign_up_to_complete_signing_up() {
        // Write code here that turns the phrase above into concrete actions
        MainPage mP = new MainPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        mP.confirmSignUpButton().click();
        wait.until(ExpectedConditions.alertIsPresent());
        String alertText = driver.switchTo().alert().getText();
        System.out.println(alertText);
        Assert.assertEquals(alertText, "Sign up successful.");
        driver.switchTo().alert().accept();
    }

    @When("the user clicks on LogIn Button")
    public void the_user_clicks_on_log_in_button() {
        // Write code here that turns the phrase above into concrete actions
        LogInPage lP = new LogInPage(driver);
        lP.loginButton().click();
    }

    @Then("user can fill logIn form")
    public void user_can_fill_log_in_form() {
        // Write code here that turns the phrase above into concrete actions
        LogInPage lP = new LogInPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(lP.usernameLogIn()));
        lP.usernameLogIn().sendKeys(username);
        lP.passwordLogIn().sendKeys(password);
    }

    @Then("click on LogIn to complete Login")
    public void click_on_log_in_to_complete_login() {
        // Write code here that turns the phrase above into concrete actions
        LogInPage lP = new LogInPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        lP.confirmLogInButton().click();
        wait.until(ExpectedConditions.visibilityOf(lP.nameOfUser()));
        System.out.println(lP.nameOfUser().getText());
        Assert.assertEquals(lP.nameOfUser().getText(), "Welcome " +username);
    }

    @Given("the user logged In")
    public void the_user_logged_in() {
        // Write code here that turns the phrase above into concrete actions

    }

    @When("the user clicks on contact button")
    public void the_user_clicks_on_contact_button() {
        // Write code here that turns the phrase above into concrete actions
        MainPage mP = new MainPage(driver);
        mP.contactButton().click();
    }

    @Then("can fill the contact form")
    public void can_fill_the_contact_form() {
        // Write code here that turns the phrase above into concrete actions
        MainPage mP = new MainPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(mP.emailContact()));
        mP.emailContact().sendKeys(email);
        mP.nameContact().sendKeys(name);
        mP.messageContact().sendKeys(message);
    }

    @Then("click on confirm contact button")
    public void click_on_confirm_contact_button() {
        // Write code here that turns the phrase above into concrete actions
        MainPage mP = new MainPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        mP.contactButtonConfirmation().click();
        wait.until(ExpectedConditions.alertIsPresent());
        String alertText = driver.switchTo().alert().getText();
        System.out.println(alertText);
        Assert.assertEquals(alertText, "Thanks for the message!!");
        driver.switchTo().alert().accept();
    }

    @When("the user clicks on Phone button")
    public void the_user_clicks_on_phone_button() {
        // Write code here that turns the phrase above into concrete actions
        CategoryProductsPage cP = new CategoryProductsPage(driver);
        cP.phoneCategory().click();
    }

    @Then("Phones category page is loaded")
    public void phones_category_page_is_loaded() {
        // Write code here that turns the phrase above into concrete actions
        CategoryProductsPage cP = new CategoryProductsPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        wait.until(ExpectedConditions.visibilityOf(cP.galaxyS7()));
        System.out.println(cP.galaxyS7().getText());
        Assert.assertEquals(cP.galaxyS7().getText(), "Samsung galaxy s7");
    }

}