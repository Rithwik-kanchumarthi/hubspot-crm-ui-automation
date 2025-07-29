package pages;

import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;

/**
 * This class represents the Demo Form Page in the HubSpot CRM UI Automation Project.
 * It encapsulates all interactions with the form elements using Page Object Model (POM)
 * and PageFactory design patterns.
 *
 * Author: Rithwik Kanchumarthi
 * 
 */
public class DemoFormPage 
{
	WebDriver driver;
	WebDriverWait wait;

	// Constructor to initialize driver and PageFactory
	public DemoFormPage(WebDriver driver) 
	{
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 20);
		PageFactory.initElements(driver, this);
	}

	// ---------------- WebElements ----------------

	@FindBy(name = "firstname")
	WebElement firstName;

	@FindBy(name = "lastname")
	WebElement lastName;

	@FindBy(name = "email")
	WebElement email;

	@FindBy(name = "phone")
	WebElement phone;

	@FindBy(name = "company")
	WebElement company;

	@FindBy(name = "website")
	WebElement website;

	@FindBy(name = "employees__c")
	WebElement employeesDropdown;

	@FindBy(name = "country_dropdown")
	WebElement headquartersDropdown;

	@FindBy(css = "input[type='submit']")
	WebElement submitButton;

	@FindBy(css = ".hs-error-msg")
	List<WebElement> errorMessages;

	@FindBy(css = ".hs-error-msg.hs-main-font-element")
	WebElement emailError;

	// ---------------- Business Methods ----------------

	/**
	 * Fill the demo form with provided data.
	 */
	public void fillForm(String fn, String ln, String em, String ph, String co, String we, String emp, String hq) {
		try {
			firstName.sendKeys(fn);
			lastName.sendKeys(ln);
			email.sendKeys(em);
			phone.sendKeys(ph);
			company.sendKeys(co);
			website.sendKeys(we);
			selectDropdownByVisibleText(employeesDropdown, emp);
			selectDropdownByVisibleText(headquartersDropdown, hq);
		} catch (Exception e) {
			System.out.println("Error while filling the form: " + e.getMessage());
			Assert.fail("Form filling failed");
		}
	}

	/**
	 * Select dropdown value by visible text.
	 */
	public void selectDropdownByVisibleText(WebElement dropdownElement, String visibleText) {
		try {
			Select dropdown = new Select(dropdownElement);
			dropdown.selectByVisibleText(visibleText);
		} catch (Exception e) {
			System.out.println("Dropdown selection failed for value: " + visibleText);
			Assert.fail("Dropdown selection failed");
		}
	}

	/**
	 * Click the form submit button.
	 */
	public void submit() 
	{
		try
		{
			wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
		}
		catch (Exception e) 
		{
			System.out.println("Submit button click failed: " + e.getMessage());
			Assert.fail("Submit failed");
		}
	}

	/**
	 * Check if the confirmation message or thank you URL is present.
	 */
	public boolean confirmationDisplayed()
	{
		try
		{
			return driver.getPageSource().contains("Thank you") || driver.getCurrentUrl().contains("thank-you");
		}
		catch (Exception e)
		{
			System.out.println("Error checking confirmation: " + e.getMessage());
			return false;
		}
	}

	/**
	 * Submit the form without entering any fields.
	 */
	public void submitWithMissingFields()
	{
		submit();
	}

	/**
	 * Check if any required field error messages are displayed.
	 */
	public boolean isRequiredFieldErrorDisplayed() 
	{
		try 
		{
			wait.until(ExpectedConditions.visibilityOfAllElements(errorMessages));
			return errorMessages.stream().anyMatch(WebElement::isDisplayed);
		} 
		catch (TimeoutException e) 
		{
			System.out.println("Required field errors not displayed in time.");
			return false;
		}
	}

	/**
	 * Fill form with invalid email for negative test case.
	 */
	public void fillFormWithInvalidEmail() 
	{
		try
		{
			firstName.sendKeys("Rithwik Venkatesh");
			lastName.sendKeys("Kanchumarthi");
			email.sendKeys("1@g.com");  // Invalid format test
			phone.sendKeys("6303864339");
			company.sendKeys("TCS");
			website.sendKeys("http://tcs.com");
			selectDropdownByVisibleText(employeesDropdown, "1");
			selectDropdownByVisibleText(headquartersDropdown, "India");
			submit();
		} 
		catch (Exception e) 
		{
			System.out.println("Error filling form with invalid email: " + e.getMessage());
			Assert.fail("Form fill with invalid email failed");
		}
	}

	/**
	 * Verify if email-specific error message is displayed.
	 */
	public boolean isEmailErrorDisplayed()
	{
		try
		{
			wait.until(ExpectedConditions.visibilityOf(emailError));
			return emailError.isDisplayed();
		} 
		catch (TimeoutException e)
		{
			System.out.println("Email error message not visible.");
			return false;
		}
	}

	/**
	 * Assert if a heading with specified text is visible.
	 */
	public void headingIsVisible(String headingText)
	{
		try 
		{
			WebElement heading = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//h1[contains(text(),'" + headingText + "')]")));
			Assert.assertTrue(heading.isDisplayed(), "Heading is not displayed");
		}
		catch (TimeoutException e)
		{
			System.out.println("Heading not found: " + headingText);
			Assert.fail("Heading visibility check failed");
		}
	}
}
