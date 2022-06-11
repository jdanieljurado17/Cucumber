package io.cucumber.shouty;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.netty.handler.codec.http.websocketx.WebSocketHandshakeException;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StepDefinitions {

    public String baseUrl = "https://www.demoblaze.com/index.html";
    public WebDriver driver;
    String username = "thisTest4";
    String password = "thisTest1";

    @Given("a user with an username and password")
    public void a_user_with_an_username_and_password() {
        // Write code here that turns the phrase above into concrete actions
        System.setProperty("webdriver.chrome.driver",".\\src\\test\\resources\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver(); // src\test\resources\Drivers
        driver.get(baseUrl);
        //Step to step
        driver.findElement(By.id("login2")).click();


        /*lP.usernameLogIn().sendKeys(username);
        lP.passwordLogIn().sendKeys(password);
        lP.confirmLogInButton().click();
        wait.until(ExpectedConditions.visibilityOf(lP.nameOfUser()));
        System.out.println(lP.nameOfUser().getText());
        Assert.assertEquals(lP.nameOfUser().getText(), "Welcome " +username);*/
    }

    @When("when user types in the username and password")
    public void when_user_types_in_the_username_and_password() {
        // Write code here that turns the phrase above into concrete actions

        driver.findElement(By.id("loginusername")).sendKeys(username);
        driver.findElement(By.id("loginpassword")).sendKeys(password);


    }

    @Then("is successfully logged in")
    public void is_successfully_logged_in() {
        // Write code here that turns the phrase above into concrete actions

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement nameOfUser = driver.findElement(By.id("nameofuser"));
        wait.until(ExpectedConditions.visibilityOf(nameOfUser));
        System.out.println(nameOfUser.getText());
        Assert.assertEquals(nameOfUser.getText(), "Welcome " +username);
    }
}


//nameOfUser.getText(), "Welcome " +username