package stepdefinitionfiles;

import base.BaseTest;
import hooks.Hooks;
import io.cucumber.java.en.*;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import pages.DemoFormPage;
import pages.LandingPage;
import pages.LoginPage;

import static org.testng.Assert.*;

import java.util.List;

public class LoginPageSteps 
{
	WebDriver driver;
	LoginPage loginPage;
	Actions actions;
	
	@Given("User is on the HubSpot login page")
    public void user_is_on_the_hubspot_login_page()
	{
		driver = BaseTest.getDriver();
        driver.get("https://app.hubspot.com/login/");
        loginPage = new LoginPage(driver);
    }

    @When("User enters valid email {string}")
    public void user_enters_valid_email(String email) 
    {
        loginPage.enterEmail(email);
    }

    @When("User enters invalid email {string}")
    public void user_enters_invalid_email(String email) 
    {
        loginPage.enterEmail(email);
    }

    @When("User enters valid password {string}")
    public void user_enters_valid_password(String password)
    {
        loginPage.enterPassword(password);
    }

    @When("User enters invalid password {string}")
    public void user_enters_invalid_password(String password) 
    {
        loginPage.enterPassword(password);
    }

    @When("User leaves email blank")
    public void user_leaves_email_and_password_blank() 
    {
        loginPage.clearEmail();
        loginPage.clearPassword();
    }

    @When("User clicks on login button")
    public void user_clicks_on_login_button() 
    {
        loginPage.clickLogin();
    }

    @Then("User should be redirected to the dashboard")
    public void user_should_be_redirected_to_the_dashboard()
    {
        Assert.assertTrue(driver.getCurrentUrl().contains("app.hubspot.com"), 
            "Expected to be on dashboard, but URL was: " + driver.getCurrentUrl());
    }

    @Then("User should see an authentication error message")
    public void user_should_see_an_authentication_error_message()
    {
        Assert.assertTrue(loginPage.isAuthenticationErrorVisible(), 
            "Authentication error should be displayed");
    }

    @Then("User should see an email format error")
    public void user_should_see_an_email_format_error() 
    {
        Assert.assertTrue(loginPage.isEmailFormatErrorVisible(), 
            "Email format error should be visible");
    }

    @Then("User should see required field errors")
    public void user_should_see_required_field_errors() 
    {
        Assert.assertTrue(loginPage.areRequiredFieldErrorsVisible(), 
            "Required field errors should be displayed");
    }

    @Then("{string} link should be displayed")
    public void link_should_be_displayed(String linkText) 
    {
        Assert.assertTrue(loginPage.isForgotPasswordLinkDisplayed(), 
            linkText + " link should be displayed");
    }

    @Then("Login button should be disabled")
    public void login_button_should_be_disabled()
    {
        Assert.assertFalse(loginPage.isLoginButtonEnabled(), 
            "Login button should be disabled with empty fields");
    }
}

