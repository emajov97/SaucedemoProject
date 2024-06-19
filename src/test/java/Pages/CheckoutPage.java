package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage {
    WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    WebElement firstNameField;
    WebElement lastNameField;
    WebElement postalCodeField;
    WebElement continueButton;
    WebElement checkoutButton;
    WebElement finishButton;
    WebElement errorMessage;
    WebElement completeHeader;
    WebElement backHomeButton;
    WebElement checkoutHeader;
    WebElement cancelButton;
    WebElement cancelHeader;


    public WebElement getFirstNameField() {
        return driver.findElement(By.id("first-name"));
    }

    public WebElement getLastNameField() {
        return driver.findElement(By.id("last-name"));
    }

    public WebElement getPostalCodeField() {
        return driver.findElement(By.id("postal-code"));
    }

    public WebElement getContinueButton() {
        return driver.findElement(By.id("continue"));
    }

    public WebElement getCheckoutButton() {
        return driver.findElement(By.id("checkout"));
    }

    public WebElement getFinishButton() {
        return driver.findElement(By.id("finish"));
    }

    public WebElement getErrorMessage() {
        return driver.findElement(By.cssSelector("h3[data-test='error']"));
    }

    public WebElement getCompleteHeader() {
        return driver.findElement(By.className("complete-header"));
    }

    public WebElement getBackHomeButton() {
        return driver.findElement(By.id("back-to-products"));
    }

    public WebElement getCheckoutHeader() {
        return driver.findElement(By.className("title"));
    }

    public WebElement getCancelButton() {
        return driver.findElement(By.id("cancel"));
    }

    public WebElement getCancelHeader() {
        return driver.findElement(By.className("title"));
    }

    //------------------------------

    public void fillShippingInformation(String firstName, String lastName, String postalCode) {
        getFirstNameField().clear();
        getFirstNameField().sendKeys(firstName);
        getLastNameField().clear();
        getLastNameField().sendKeys(lastName);
        getPostalCodeField().clear();
        getPostalCodeField().sendKeys(postalCode);
        getContinueButton().click();
    }

    public void clickOnCheckoutButton() {
        getCheckoutButton().click();
    }


    public void completeCheckout() {
        getFinishButton().click();
    }

    public void returnToInventoryPage() {
        getBackHomeButton().click();
    }

    public void clickOnCancelButton() {
        getCancelButton().click();
    }

}
