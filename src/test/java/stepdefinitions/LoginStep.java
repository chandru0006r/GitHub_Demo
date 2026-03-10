package stepdefinitions;

import org.testng.Assert;

import drivers.WebDriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.login;

public class LoginStep {

    private login loginPage;

    public LoginStep() {
        loginPage = new login(WebDriverFactory.getDriver());
    }

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        loginPage.navigateToLoginPage("https://example.com/login");
    }

    @When("the user enters valid credentials and submits")
    public void the_user_enters_valid_credentials_and_submits() {
        loginPage.enterCredentialsAndLogin("testuser", "testpassword");
    }

    @Then("the user should be logged in successfully")
    public void the_user_should_be_logged_in_successfully() {
        boolean isSuccess = loginPage.isLoginSuccessful();
        Assert.assertTrue(isSuccess, "Login was not successful (success message not displayed)");
    }
}
