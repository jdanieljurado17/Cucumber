package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.BuyingPage;
import pageObjects.LogInPage;
import utils.TestContextSetup;

import java.io.IOException;

public class BuyingStepDefinitions {

    public BuyingPage buyingPage;
    TestContextSetup testContextSetup;

    public BuyingStepDefinitions(TestContextSetup testContextSetup) throws IOException {
        this.testContextSetup = testContextSetup;
        this.buyingPage = new BuyingPage(this.testContextSetup.driver);
    }

    @When("the user clicks on a category")
    public void the_user_clicks_on_a_category() {
        buyingPage.clickingOnCategoryButton();
    }
    @Then("user can see products")
    public void user_can_see_products() {
        buyingPage.validateCategoryLoaded();
    }

    @When("the user clicks on the product")
    public void the_user_clicks_on_the_product() {
        buyingPage.clickingOnCategoryButton();
        buyingPage.addingProducts();
    }
    @Then("the product is added to the cart")
    public void the_product_is_added_to_the_cart() {
        buyingPage.productAdded();
    }

    @When("the user clicks on delete button")
    public void the_user_clicks_on_delete_button() {
        buyingPage.clickingOnCategoryButton();
        buyingPage.addingProducts();
        buyingPage.productAdded();
        buyingPage.deleteProducts();
    }
    @Then("the product is deleted from the cart")
    public void the_product_is_deleted_from_the_cart() {
        buyingPage.validateDelete();
    }
    @When("user adds products and click on purchase button")
    public void user_adds_products_and_click_on_purchase_button() {
        buyingPage.clickingOnCategoryButton();
        buyingPage.addingProducts();
        buyingPage.productAdded();

    }
    @When("user fills form with name {string} country {string} city {string} card {string} expMonth {string} expYear {string}")
    public void user_fills_form_with_name_country_city_card_exp_month_exp_year(String name, String country, String city, String creditCard, String expMonth, String expYear) {
        buyingPage.purchaseButton(name, country, city, creditCard, expMonth, expYear);
    }
    @Then("order is placed")
    public void order_is_placed() {
        buyingPage.orderValidation();
    }
}
