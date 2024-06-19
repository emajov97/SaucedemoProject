package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class InventoryTest extends BaseTest {

    @BeforeMethod
    public void PageSetUp() {

        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        loginPage.login("standard_user", "secret_sauce");
        resetAppState();

    }

    @Test
    public void testViewProducts() {
        Assert.assertTrue(inventoryPage.getProducts().size() > 0);
    }

    @Test
    public void testAddSingleProductToCart() {
        inventoryPage.addToCart(0);
        Assert.assertEquals(inventoryPage.getCartIcon().getText(), "1");
    }

    @Test
    public void testAddMultipleProductsToCart() {
        inventoryPage.addToCart(0);
        inventoryPage.addToCart(1);
        Assert.assertEquals(inventoryPage.getCartIcon().getText(), "2");
    }

    @Test
    public void testViewProductsInCart() {
        inventoryPage.addToCart(0);
        inventoryPage.addToCart(1);
        inventoryPage.getCartIcon().click();
        Assert.assertTrue(driver.getCurrentUrl().contains("cart.html"));
    }

    @Test
    public void testRemoveProductFromCart() {
        inventoryPage.addToCart(0);
        inventoryPage.addToCart(1);
        inventoryPage.removeFromCart(0);
        Assert.assertEquals(inventoryPage.getCartIcon().getText(), "1");
    }

    @Test
    public void testContinueShoppingAfterClickingTheCart() {
        inventoryPage.addToCart(0);
        inventoryPage.getCartIcon().click();
        Assert.assertTrue(driver.getCurrentUrl().contains("cart.html"));
        inventoryPage.getContinueShoppingButton().click();
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory.html"));
        Assert.assertEquals(inventoryPage.getCartIcon().getText(), "1");
    }
}
