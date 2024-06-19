package Tests;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {

    @BeforeMethod
    public void PageSetUp() {
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        loginPage.login("standard_user", "secret_sauce");
    }

    @Test
    public void testSuccessfulClickOnCheckoutButton() {
        inventoryPage.addToCart(0);
        inventoryPage.getCartIcon().click();
        checkoutPage.clickOnCheckoutButton();
        Assert.assertTrue(checkoutPage.getCheckoutHeader().isDisplayed());
        Assert.assertEquals(checkoutPage.getCheckoutHeader().getText(), "Checkout: Your Information");
    }

    @Test
    public void testSuccessfulCheckoutWithValidInformation() {
        inventoryPage.addToCart(0);
        inventoryPage.getCartIcon().click();
        checkoutPage.clickOnCheckoutButton();
        checkoutPage.fillShippingInformation("Pera", "Peric", "11000");
        checkoutPage.completeCheckout();
        Assert.assertTrue(checkoutPage.getCompleteHeader().isDisplayed());
        Assert.assertEquals(checkoutPage.getCompleteHeader().getText(), "Thank you for your order!");
    }

    @Test
    public void testReturnToInventoryPage() {
        inventoryPage.addToCart(0);
        inventoryPage.getCartIcon().click();
        checkoutPage.clickOnCheckoutButton();
        checkoutPage.fillShippingInformation("Pera", "Peric", "11000");
        checkoutPage.completeCheckout();
        checkoutPage.returnToInventoryPage();
        Assert.assertTrue(inventoryPage.getCartIcon().isDisplayed());
        Assert.assertTrue(inventoryPage.getProducts().getFirst().isDisplayed());
    }

    @Test
    public void testCheckoutWithoutEnteringShippingInformation() {
        inventoryPage.addToCart(0);
        inventoryPage.getCartIcon().click();
        checkoutPage.clickOnCheckoutButton();
        checkoutPage.getContinueButton().click();
        Assert.assertTrue(checkoutPage.getErrorMessage().isDisplayed());
        Assert.assertEquals(checkoutPage.getErrorMessage().getText(), "Error: First Name is required");
    }

    @Test
    public void testSuccessfulClickOnCancelButton() {
        inventoryPage.addToCart(0);
        inventoryPage.getCartIcon().click();
        checkoutPage.clickOnCheckoutButton();
        checkoutPage.clickOnCancelButton();
        Assert.assertTrue(checkoutPage.getCheckoutButton().isDisplayed());
        Assert.assertTrue(checkoutPage.getCancelHeader().isDisplayed());
        Assert.assertEquals(checkoutPage.getCancelHeader().getText(), "Your Cart");
    }
}
