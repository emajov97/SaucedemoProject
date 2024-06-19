package Tests;

import Base.BaseTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BurgerMenuTest extends BaseTest {

    @BeforeMethod
    public void PageSetUp() {
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        loginPage.login("standard_user", "secret_sauce");
    }

    @Test
    public void testViewMenuAfterClickingBurgerMenu() {
        burgerMenuPage.openBurgerMenu();
        Assert.assertTrue(burgerMenuPage.isBurgerMenuOpen(), "Menu should be open.");
    }

    @Test
    public void testBurgerMenuNavigationToAbout() {
        burgerMenuPage.openBurgerMenu();
        Assert.assertTrue(burgerMenuPage.isBurgerMenuOpen(), "Menu should be open.");
        burgerMenuPage.navigateToAbout();
        wait.until(ExpectedConditions.urlContains("saucelabs.com"));
        Assert.assertTrue(driver.getCurrentUrl().contains("saucelabs.com"));
    }

    @Test
    public void testBurgerMenuNavigationToAllItems() {
        burgerMenuPage.openBurgerMenu();
        Assert.assertTrue(burgerMenuPage.isBurgerMenuOpen(), "Menu should be open");
        burgerMenuPage.navigateToAllItems();
        wait.until(ExpectedConditions.urlContains("inventory.html"));
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory.html"));
        Assert.assertTrue(inventoryPage.getCartIcon().isDisplayed());
    }

    @Test
    public void testBurgerMenuNavigationToResetAppState() {
        burgerMenuPage.openBurgerMenu();
        Assert.assertTrue(burgerMenuPage.isBurgerMenuOpen(), "Menu should be open");
        inventoryPage.addToCart(0);
        burgerMenuPage.navigateToResetAppState();
        Assert.assertTrue(burgerMenuPage.isCartEmpty(), "Cart should be empty after reset.");
    }

    @Test
    public void testBurgerMenuNavigationToLogout() {
        burgerMenuPage.openBurgerMenu();
        Assert.assertTrue(burgerMenuPage.isBurgerMenuOpen(), "Menu should be open");
        burgerMenuPage.navigateToLogout();
        wait.until(ExpectedConditions.urlContains("saucedemo.com"));
        Assert.assertTrue(driver.getCurrentUrl().contains("saucedemo.com"));
        Assert.assertTrue(loginPage.getUsernameField().isDisplayed());
        Assert.assertTrue(loginPage.getPasswordField().isDisplayed());
        Assert.assertTrue(loginPage.getLoginButton().isDisplayed());

    }
}
