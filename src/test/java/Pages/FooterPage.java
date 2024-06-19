package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FooterPage {
    WebDriver driver;

    public FooterPage(WebDriver driver) {
        this.driver = driver;
    }

    WebElement twitterLink;
    WebElement facebookLink;
    WebElement linkedInLink;

    public WebElement getTwitterLink() {
        return driver.findElement(By.cssSelector("a[href*='twitter.com']"));
    }

    public WebElement getFacebookLink() {
        return driver.findElement(By.cssSelector("a[href*='facebook.com']"));
    }

    public WebElement getLinkedInLink() {
        return driver.findElement(By.cssSelector("a[href*='linkedin.com']"));
    }

    //------------------------------

    public void clickTwitterLink() {
        getTwitterLink().click();
    }

    public void clickFacebookLink() {
        getFacebookLink().click();
    }

    public void clickLinkedInLink() {
        getLinkedInLink().click();
    }
}
