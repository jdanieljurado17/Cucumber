package stepDefinitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObjects.LogInPage;
import utils.TestContextSetup;

import java.io.IOException;

public class LoginStepDefinitions {

    public LogInPage logInPage;
    TestContextSetup testContextSetup;

    public LoginStepDefinitions(TestContextSetup testContextSetup) throws IOException {
        this.testContextSetup = testContextSetup;
        this.logInPage = new LogInPage(this.testContextSetup.driver);
    }
    @Given("User is on Demo Blaze")
    public void user_is_on_demo_blaze() {

        Assert.assertTrue(logInPage.getURL().contains("demo"));
    }
    @When("user clicks on sign up button and fills the form")
    public void user_clicks_on_sign_up_button_and_fills_the_form() {

        logInPage.signingIntoWebsite();
    }
    @Then("Alert indicating sign up successful is displayed")
    public void alert_indicating_sign_up_successful_is_displayed() {

        logInPage.validateSignUp();
    }

    @When("user login with username {string} and password: {string}")
    public void user_login_with_username_and_password(String username, String password) {

        logInPage.fillLogInForm(username, password);
    }


    @Then("user is logged in")
    public void userIsLoggedIn() {

        logInPage.validateUserIsLoggedIn();
    }

    @When("fill contact form with email {string} name {string} message {string}")
    public void fill_contact_form_with_email_name_message(String email, String name, String message) {

        logInPage.fillContactForm(email, name, message);
    }

    @Then("contact form is submitted")
    public void contact_form_is_submitted() {

        logInPage.validateContactForm();
    }
}
