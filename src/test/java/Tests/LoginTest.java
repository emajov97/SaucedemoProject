package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @BeforeMethod
    public void PageSetUp() {
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    public void testValidLoginTest() {
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");

    }

    @Test
    public void testInvalidUsername() {
        loginPage.login("invalid_user", "secret_sauce");
        Assert.assertTrue(loginPage.getErrorMessage().isDisplayed());
        Assert.assertEquals(loginPage.getErrorMessage().getText(), "Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    public void testInvalidPassword() {
        loginPage.login("standard_user", "invalid_sauce");
        Assert.assertTrue(loginPage.getErrorMessage().isDisplayed());
        Assert.assertEquals(loginPage.getErrorMessage().getText(), "Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    public void testInvalidCredentials() {
        loginPage.login("invalid_user", "invalid_sauce");
        Assert.assertTrue(loginPage.getErrorMessage().isDisplayed());
        Assert.assertEquals(loginPage.getErrorMessage().getText(), "Epic sadface: Username and password do not match any user in this service");
    }

    @Test void testEmptyUsername() {
        loginPage.login("", "secret_sauce");
        Assert.assertTrue(loginPage.getErrorMessage().isDisplayed());
        Assert.assertEquals(loginPage.getErrorMessage().getText(), "Epic sadface: Username is required");
    }

    @Test void testEmptyPassword() {
        loginPage.login("standard_user", "");
        Assert.assertTrue(loginPage.getErrorMessage().isDisplayed());
        Assert.assertEquals(loginPage.getErrorMessage().getText(), "Epic sadface: Password is required");
    }

    @Test void testEmptyCredentials() {
        loginPage.login("","");
        Assert.assertTrue(loginPage.getErrorMessage().isDisplayed());
        Assert.assertEquals(loginPage.getErrorMessage().getText(), "Epic sadface: Username is required");
    }

}
