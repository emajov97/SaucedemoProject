package Base;

import Pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseTest {

    public WebDriver driver;
    public WebDriverWait wait;

    public LoginPage loginPage;
    public InventoryPage inventoryPage;
    public CheckoutPage checkoutPage;
    public BurgerMenuPage burgerMenuPage;
    public FooterPage footerPage;

    public String mainWindow;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        checkoutPage = new CheckoutPage(driver);
        burgerMenuPage = new BurgerMenuPage(driver, wait);
        footerPage = new FooterPage(driver);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    //-----------------------------


    public void switchToNewWindow() {

        // Closing all windows except the main one
        closeAllWindows();

        for (String window : driver.getWindowHandles()) {
            if (!window.equals(mainWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }
    }

    public void closeAllWindows() {
        for (String window : driver.getWindowHandles()) {
            if (!window.equals(mainWindow)) {
                driver.switchTo().window(window);
                driver.close();
            }
            break;
        }
    }

    public void resetAppState() {
        burgerMenuPage.openBurgerMenu();
        burgerMenuPage.navigateToResetAppState();
        driver.navigate().refresh();
    }

}
