package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    WebDriver driver;

    WebElement usernameField;
    WebElement passwordField;
    WebElement loginButton;
    WebElement errorMessage;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getUsernameField() {
        return driver.findElement(By.id("user-name"));
    }

    public WebElement getPasswordField() {
        return driver.findElement(By.id("password"));
    }

    public WebElement getLoginButton() {
        return driver.findElement(By.id("login-button"));
    }

    public WebElement getErrorMessage() {
        return driver.findElement(By.cssSelector("h3[data-test='error']"));
    }

    //------------------------------

    public void login(String username, String password) {
        getUsernameField().clear();
        getUsernameField().sendKeys(username);
        getPasswordField().clear();
        getPasswordField().sendKeys(password);
        getLoginButton().click();
    }






}
