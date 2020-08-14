package steps.hooks;

import framework.DriverManager;
import io.cucumber.java.After;
// import io.cucumber.java.Before;
// import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import ui.pages.LoginPage;

// import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;

/**
 * @author Jean Carlo Rodriguez
 */

public class GlobalHooks {

    LoginPage LoginPage;

    public GlobalHooks() {
        LoginPage = new LoginPage();
    }

    @Given("I go to the main page")
    public void iGoToTheMainPage() {
        WebDriver driver;
        driver = DriverManager.getInstance().getWebDriver();
        // go to main page
        driver.get("http://automationpractice.com/index.php");
    }

    @Given("I am signed in using the credentials email {string} and password {string}")
    public void iAmSignedInUsingTheCredentials(String email, String password) {
        WebDriver driver;
        driver = DriverManager.getInstance().getWebDriver();
        // go to login page
        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        LoginPage.loginWith(email, password);
    }

    @After
    public void afterExecution() {
        try {
            DriverManager.getInstance().quit();
        } catch (Exception e) {
            System.out.println("Unable to quit the driver " + e);
        }
    }
}
