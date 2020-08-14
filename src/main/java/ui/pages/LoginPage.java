package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * @author Jean Carlo Rodriguez
 */
public class LoginPage extends BasePageObject{
    @FindBy(id = "email")
    private WebElement emailInput;
    
    @FindBy(id = "passwd")
    private WebElement passwordInput;

    @FindBy(id = "SubmitLogin")
    private WebElement submitLoginButton;

	public void waitUntilPageIsLoaded() {
		wait.until(ExpectedConditions.visibilityOf(submitLoginButton));
    }
    
    public void loginWith(String email, String password) {
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        submitLoginButton.click();
    }
}