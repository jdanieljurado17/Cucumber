package io.cucumber.DemoBlaze;


import io.cucumber.DemoBlaze.PageObjects.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.Before;
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

    String username = "thisTest63";
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
        LogInPage lP = new LogInPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));


        wait.until(ExpectedConditions.visibilityOf(lP.nameOfUser()));
        System.out.println(lP.nameOfUser().getText());
        Assert.assertEquals(lP.nameOfUser().getText(), "Welcome " +username);
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
    @Given("the user is on home page")
    public void the_user_is_on_home_page() {
        // Write code here that turns the phrase above into concrete actions
        MainPage mP = new MainPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        mP.homeButton().click();
        String currentURL = driver.getCurrentUrl();
        System.out.println(currentURL);
        Assert.assertEquals("https://www.demoblaze.com/index.html", currentURL);
    }

    @When("the user clicks on Laptop button")
    public void the_user_clicks_on_laptop_button() {
        // Write code here that turns the phrase above into concrete actions
        CategoryProductsPage cP = new CategoryProductsPage(driver);
        cP.laptopsCategory().click();
    }

    @Then("Laptops category is loaded")
    public void laptops_category_is_loaded() {
        // Write code here that turns the phrase above into concrete actions
        CategoryProductsPage cP = new CategoryProductsPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        wait.until(ExpectedConditions.visibilityOf(cP.macBook()));
        System.out.println(cP.macBook().getText());
        Assert.assertEquals(cP.macBook().getText(), "MacBook Pro");
    }

    @When("the user clicks on monitor category")
    public void the_user_clicks_on_monitor_category() {
        // Write code here that turns the phrase above into concrete actions
        CategoryProductsPage cP = new CategoryProductsPage(driver);
        cP.monitorsCategory().click();
    }

    @Then("Monitor category is loaded")
    public void monitor_category_is_loaded() {
        // Write code here that turns the phrase above into concrete actions
        CategoryProductsPage cP = new CategoryProductsPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        wait.until(ExpectedConditions.visibilityOf(cP.appleMonitor()));
        System.out.println(cP.appleMonitor().getText());
        Assert.assertEquals(cP.appleMonitor().getText(), "Apple monitor 24");
    }

    @Given("the user navigates to desired category")
    public void the_user_navigates_to_desired_category() {
        // Write code here that turns the phrase above into concrete actions
        CategoryProductsPage cP = new CategoryProductsPage(driver);

        cP.phoneCategory().click();
    }

    @Given("clicks on the product to add to the cart")
    public void clicks_on_the_product_to_add_to_the_cart() {
        // Write code here that turns the phrase above into concrete actions
        CategoryProductsPage cP = new CategoryProductsPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(cP.galaxyS6()));
        cP.galaxyS6().click();

    }

    @When("clicks on add to cart")
    public void clicks_on_add_to_cart() {
        // Write code here that turns the phrase above into concrete actions
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        CategoryProductsPage cP = new CategoryProductsPage(driver);
        wait.until(ExpectedConditions.visibilityOf(cP.addToCartS6()));
        cP.addToCartS6().click();

    }

    @Then("product is added to cart")
    public void product_is_added_to_cart() {
        // Write code here that turns the phrase above into concrete actions
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        CartPage cart = new CartPage(driver);
        MainPage mP = new MainPage(driver);

        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
        mP.cartButton().click();
        cart.s6Added().isDisplayed();

        System.out.println("Products added to the cart :)");
    }

    @Given("the user has added products to the cart")
    public void the_user_has_added_products_to_the_cart() {
        // Write code here that turns the phrase above into concrete actions
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        CategoryProductsPage cP = new CategoryProductsPage(driver);
        CartPage cart = new CartPage(driver);
        MainPage mP = new MainPage(driver);


        cP.galaxyS6().click();
        cP.addToCartS6().click();
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
        mP.cartButton().click();
        cart.s6Added().isDisplayed();
    }

    @When("the user clicks on delete button")
    public void the_user_clicks_on_delete_button() {
        // Write code here that turns the phrase above into concrete actions
        CartPage cart = new CartPage(driver);
        cart.deleteButton().click();
    }

    @Then("the products are deleted")
    public void the_products_are_deleted() {
        // Write code here that turns the phrase above into concrete actions
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        CartPage cart = new CartPage(driver);
        wait.until(ExpectedConditions.invisibilityOf(cart.s6Added()));
        System.out.println("Products has been deleted successfully");
    }

    @Given("navigates to desired category")
    public void navigates_to_desired_category() {
        // Write code here that turns the phrase above into concrete actions
        CategoryProductsPage cP = new CategoryProductsPage(driver);
        cP.phoneCategory().click();

    }

    @When("the user adds a product to the cart")
    public void the_user_adds_a_product_to_the_cart() {
        // Write code here that turns the phrase above into concrete actions
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        CategoryProductsPage cP = new CategoryProductsPage(driver);
        cP.galaxyS6().click();
    }

    @When("clicks on the cart button")
    public void clicks_on_the_cart_button() {
        // Write code here that turns the phrase above into concrete actions
        CategoryProductsPage cP = new CategoryProductsPage(driver);
        MainPage mP = new MainPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        cP.addToCartS6().click();
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
        mP.cartButton().click();

    }

    @When("clicks on place order button to fill the form")
    public void clicks_on_place_order_button_to_fill_the_form() {
        // Write code here that turns the phrase above into concrete actions
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        CategoryProductsPage cP = new CategoryProductsPage(driver);
        CartPage cart = new CartPage(driver);
        MainPage mP = new MainPage(driver);
        CartPage cartP = new CartPage(driver);

        cart.s6Added().isDisplayed();
        String totalCart = cartP.totalCart().getText();
        cartP.placeOrderButton().click();
        wait.until(ExpectedConditions.visibilityOf(cartP.totalModal()));
        Assert.assertEquals(cartP.totalModal().getText(), "Total: " + totalCart); //Assert.assertEquals(cP.appleMonitor().getText(), "Apple monitor 24");
        cartP.nameCardHolder().sendKeys(name);
        cartP.countryCardHolder().sendKeys(country);
        cartP.cityCardHolder().sendKeys(city);
        cartP.numberCard().sendKeys(creditCard);
        cartP.monthCard().sendKeys(expMonth);
        cartP.yearCard().sendKeys(expYear);

    }

    @Then("order is placed")
    public void order_is_placed() {
        // Write code here that turns the phrase above into concrete actions
        CartPage cartP = new CartPage(driver);

        cartP.purchaseButton().click();
    }

    @Then("can click on confirm button")
    public void can_click_on_confirm_button() {
        // Write code here that turns the phrase above into concrete actions
        CartPage cartP = new CartPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        wait.until(ExpectedConditions.visibilityOf(cartP.confirmButton()));
        cartP.confirmButton().click();
        System.out.println("Order has been placed successfully");
    }

    @Then("closes the driver")
    public void closes_the_driver() {
        // Write code here that turns the phrase above into concrete actions
        driver.quit();
    }
}