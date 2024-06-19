package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class InventoryPage {
    WebDriver driver;
    WebDriverWait wait;

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    List<WebElement> products;
    WebElement cartIcon;
    WebElement removeButton;
    WebElement continueShoppingButton;


    public List<WebElement> getProducts() {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("inventory_item")));
    }

    public WebElement getCartIcon() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("shopping_cart_link")));
    }

    public WebElement getRemoveButton(int productIndex) {
        return wait.until(ExpectedConditions.visibilityOf(getProducts().get(productIndex).findElement(By.className("btn_secondary"))));
    }

    public WebElement getContinueShoppingButton() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("continue-shopping")));
    }

    //------------------------------

    public void addToCart(int productIndex) {
        getProducts().get(productIndex).findElement(By.className("btn_inventory")).click();
    }

    public void removeFromCart(int productIndex) {
        getRemoveButton(productIndex).click();
    }

}
