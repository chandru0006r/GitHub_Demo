package hooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import drivers.WebDriverFactory;
import utils.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

    private WebDriverFactory driverFactory;
    private WebDriver driver;
    private ConfigReader configReader;

    @Before(order = 0)
    public void getProperty() {
        configReader = new ConfigReader();
    }

    @Before(order = 1)
    public void launchBrowser() {
        String browserName = configReader.getProperty("browser");
        if (browserName == null) {
            browserName = "chrome";
        }
        driverFactory = new WebDriverFactory();
        driver = driverFactory.initDriver(browserName);
    }

    @After(order = 0)
    public void quitBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }

    @After(order = 1)
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            String screenshotName = scenario.getName().replaceAll(" ", "_");
            byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(sourcePath, "image/png", screenshotName);
        }
    }
}
