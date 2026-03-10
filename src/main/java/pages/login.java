package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.BasePage;

public class login extends BasePage {

    // Example Locators
    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginButton = By.id("loginBtn");
    private By successMessage = By.id("success-msg");

    public login(WebDriver driver) {
        super(driver);
    }

    public void navigateToLoginPage(String url) {
        System.out.println("-> Navigating to login page...");
        driver.get(url);
    }

    public void enterCredentialsAndLogin(String username, String password) {
        System.out.println("-> Entering credentials and clicking login...");
        WebElement uField = waitUtils.waitForElementVisible(driver.findElement(usernameField));
        uField.sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);

        WebElement lBtn = waitUtils.waitForElementClickable(driver.findElement(loginButton));
        lBtn.click();
    }

    public boolean isLoginSuccessful() {
        System.out.println("-> Verifying if login was successful...");
        try {
            WebElement msg = waitUtils.waitForElementVisible(driver.findElement(successMessage));
            return msg.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
