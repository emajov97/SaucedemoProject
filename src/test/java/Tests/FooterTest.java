package Tests;

import Base.BaseTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FooterTest extends BaseTest {

    @BeforeMethod
    public void PageSetUp() {
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        loginPage.login("standard_user", "secret_sauce");
        mainWindow = driver.getWindowHandle();

    }

    @Test
    public void testTwitterLinkNavigation() {
        footerPage.clickTwitterLink();
        switchToNewWindow();
        Assert.assertEquals(driver.getCurrentUrl(), "https://x.com/saucelabs");
    }

    @Test
    public void testFacebookLinkNavigation() {
        footerPage.clickFacebookLink();
        switchToNewWindow();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.facebook.com/saucelabs");

    }

    @Test
    public void testLinkedInLinkNavigation() {
        footerPage.clickLinkedInLink();
        switchToNewWindow();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.linkedin.com/company/sauce-labs/");
    }

}
