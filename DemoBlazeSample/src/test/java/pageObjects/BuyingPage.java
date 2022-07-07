package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class BuyingPage {
    WebDriver driver;
    public BuyingPage(WebDriver driver) {
        this.driver=driver;
    }

    private By phoneCategory = By.linkText("Phones");
    private By galaxyS7 = By.linkText("Samsung galaxy s7");
    private By galaxyS6 = By.linkText("Samsung galaxy s6");
    private By addToCartS6 = By.xpath("//a[@onclick='addToCart(1)']");
    private By s6addedProduct = By.xpath("//td[normalize-space()='Samsung galaxy s6']");
    private By cartButton=By.id("cartur");
    private By deleteButton = By.xpath("//a[normalize-space()='Delete']");
    private By totalCart = By.id("totalp");
    private By placeOrderButton = By.xpath("//button[@data-toggle='modal']");
    private By totalModal = By.id("totalm");
    private By nameCardHolder = By.id("name");
    private By countryCardHolder = By.id("country");
    private By cityCardHolder = By.id("city");
    private By numberCard = By.id("card");
    private By monthCard = By.id("month");
    private By yearCard = By.id("year");
    private By purchaseButton = By.xpath("//button[normalize-space()='Purchase']");
    private By confirmButton = By.xpath("//button[@class='confirm btn btn-lg btn-primary']");



    public void clickingOnCategoryButton(){
        driver.findElement(phoneCategory).click();
    }
    public void validateCategoryLoaded(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement product = driver.findElement(galaxyS7);
        wait.until(ExpectedConditions.visibilityOf(product));
        Assert.assertEquals(product.getText(), "Samsung galaxy s7");
    }

    public void addingProducts(){
        driver.findElement(galaxyS6).click();
        driver.findElement(addToCartS6).click();
    }
    public void productAdded(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
        driver.findElement(cartButton).click();
        driver.findElement(s6addedProduct).isDisplayed();
    }

    public void deleteProducts(){
        driver.findElement(deleteButton).click();
    }
    public void validateDelete(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement s6Added = driver.findElement(s6addedProduct);
        wait.until(ExpectedConditions.invisibilityOf(s6Added));
    }
    public void purchaseButton(String name,String country,String city,String creditCard,String expMonth, String expYear){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.findElement(s6addedProduct).isDisplayed();
        String cartSum = driver.findElement(totalCart).getText();
        driver.findElement(placeOrderButton).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(totalModal)));
        Assert.assertEquals(driver.findElement(totalModal).getText(), "Total: " + cartSum); //Assert.assertEquals(cP.appleMonitor().getText(), "Apple monitor 24");
        driver.findElement(nameCardHolder).sendKeys(name);
        driver.findElement(countryCardHolder).sendKeys(country);
        driver.findElement(cityCardHolder).sendKeys(city);
        driver.findElement(numberCard).sendKeys(creditCard);
        driver.findElement(monthCard).sendKeys(expMonth);
        driver.findElement(yearCard).sendKeys(expYear);
    }

    public void orderValidation(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.findElement(purchaseButton).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(confirmButton)));
        driver.findElement(confirmButton).click();

    }
}
