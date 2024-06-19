package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BurgerMenuPage {
    WebDriver driver;
    WebDriverWait wait;

    public BurgerMenuPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    WebElement MenuButton;
    WebElement AllItemsLink;
    WebElement AboutLink;
    WebElement LogoutLink;
    WebElement resetAppStateLink;
    WebElement burgerMenu;

    public WebElement getMenuButton() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("react-burger-menu-btn")));
    }

    public WebElement getAllItemsLink() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("inventory_sidebar_link")));
    }

    public WebElement getAboutLink() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("about_sidebar_link")));
    }

    public WebElement getLogoutLink() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("logout_sidebar_link")));
    }

    public WebElement getResetAppStateLink() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("reset_sidebar_link")));
    }

    public WebElement getBurgerMenu() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("bm-menu")));
    }

    //------------------------------

    public void openBurgerMenu() {
        getMenuButton().click();
    }

    public void navigateToAllItems() {
        getAllItemsLink().click();
    }

    public void navigateToAbout() {
        getAboutLink().click();
    }
    public void clickOnBurgerMenu() {
        burgerMenu.click();
    }

    public void navigateToLogout() {
        getLogoutLink().click();
    }

    public void navigateToResetAppState() {
        getResetAppStateLink().click();
    }

    public boolean isBurgerMenuOpen() {
        return getBurgerMenu().isDisplayed();
    }

    public boolean isCartEmpty() {
        return  driver.findElements(By.className("shopping_cart_badge")).isEmpty();
    }


}
