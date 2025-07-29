package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Page Object Model for HubSpot Login Page.
 * Author: Rithwik Kanchumarthi
 * 
 */

public class LoginPage 
{

    WebDriver driver;
	WebDriverWait wait;

    // Web Elements

    @FindBy(id = "username")
    WebElement emailInput;

    @FindBy(id = "password")
    WebElement passwordInput;

    @FindBy(id = "loginBtn")
    WebElement loginButton;

    @FindBy(linkText = "Forgot my password")
    WebElement forgotPasswordLink;

    @FindBy(css = "div.private-alert__inner")  // Adjust selector based on actual error element
    WebElement authError;

    @FindBy(css = "span[data-test-id='error-email']")
    WebElement emailFormatError;

    @FindBy(css = "span[data-test-id='error-required-email']")
    WebElement requiredEmailError;

    @FindBy(css = "span[data-test-id='error-required-password']")
    WebElement requiredPasswordError;

    // ================================
    // Constructor
    // ================================

    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // ================================
    // Actions
    // ================================

    public void enterEmail(String email) 
    {
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    public void enterPassword(String password)
    {
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void clickLogin()
    {
        loginButton.click();
    }

    public void clearEmail()
    {
        emailInput.clear();
    }

    public void clearPassword()
    {
        passwordInput.clear();
    }

    // ================================
    // Validations
    // ================================

    public boolean isAuthenticationErrorVisible()
    {
        try
        {
            return authError.isDisplayed();
        } 
        catch (Exception e)
        {
            return false;
        }
    }

    public boolean isEmailFormatErrorVisible()
    {
        try
        {
            return emailFormatError.isDisplayed();
        }
        catch (Exception e) 
        {
            return false;
        }
    }

    public boolean areRequiredFieldErrorsVisible()
    {
        try
        {
            return requiredEmailError.isDisplayed() && requiredPasswordError.isDisplayed();
        } 
        catch (Exception e)
        {
            return false;
        }
    }

    public boolean isForgotPasswordLinkDisplayed()
    {
        try 
        {
            return forgotPasswordLink.isDisplayed();
        }
        catch (Exception e) 
        {
            return false;
        }
    }

    public boolean isLoginButtonEnabled()
    {
        try 
        {
            return loginButton.isEnabled();
        }
        catch (Exception e)
        {
            return false;
        }
    }
}
