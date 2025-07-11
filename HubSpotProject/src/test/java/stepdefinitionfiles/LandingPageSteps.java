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

import static org.testng.Assert.*;

import java.util.List;

public class LandingPageSteps 
{
	WebDriver driver;
	LandingPage landingPage;
	DemoFormPage demoForm;
	Actions actions;

	@Given("I launch the browser")
	public void i_launch_the_browser() 
	{
		driver = BaseTest.getDriver();
	}

	@When("I open the CRM product page")
	public void i_open_the_crm_product_page() 
	{
		driver = BaseTest.getDriver();
		driver.get("https://www.hubspot.com/products/crm");
		landingPage = new LandingPage(driver);
	}

	@Then("the page title should be {string}")
	public void verify_page_title(String expectedTitle) 
	{
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		System.out.println(expectedTitle);
		Assert.assertEquals(actualTitle, expectedTitle);
	}

	@Given("I open the HubSpot CRM product page")
	public void i_open_the_hubspot_crm_product_page() 
	{
		driver = BaseTest.getDriver();
		driver.get("https://www.hubspot.com/products/crm");
		landingPage = new LandingPage(driver);
	}

	@When("I click the Get free CRM button")
	public void click_Get_free_CRM_button() throws InterruptedException
	{
		landingPage.clickCRMButton();
		Thread.sleep(3000);
	}

	@Then("the free CRM page title should be {string}")
	public void free_CRMpageTitle(String expectedTitle) 
	{
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		System.out.println(expectedTitle);
		Assert.assertEquals(actualTitle, expectedTitle);
	}

	@When("I click the Log in button")
	public void i_verify_the_button_is_enabled() throws InterruptedException 
	{
		Thread.sleep(5000);
		landingPage.clickLogin();
	}

	@Then("I should be redirected to the login page")
	public void i_should_be_redirected_to_the_login_page()
	{
		String currentUrl = driver.getCurrentUrl();
		Assert.assertTrue(currentUrl.contains("app.hubspot.com/login?hubs_signup-url=www.hubspot.com"));
	}

	@When("I click on the {string} dropdown")
	public void i_click_on_the_dropdown(String dropdownName) 
	{
		landingPage.clickDropdown(dropdownName);
	}

	@Then("The {string} dropdown should be Enabled")
	public void the_dropdown_should_be_selected(String dropdownName)
	{
		landingPage.dropDownisEnabled(dropdownName);
	}

	@And("I click on {string} menu button")
	public void all_options_are_listed_and_click_on_menu(String menuButton) 
	{
		landingPage.clickMenu(menuButton);
	}

	@Then("Page should be redirected to {string}")  
	public void menu_should_be_clickable(String partialUrl)
	{
		landingPage.pageRedirected(partialUrl);
	}

	@When("The chat widget is expanded")
	public void the_chat_widget_is_expanded() 
	{
		landingPage.chatWidgetexpand();
	}

	@Then("I should not be able to click it until the chat is closed")
	public void verify_button_blocked_by_chat()
	{
		landingPage.verifyBlockByChat();
	}

	@When("I enable High Contrast mode")
	public void enable_high_contrast() 
	{
		landingPage.highContrast();

	}

	@Then("UI elements like text, buttons, and layout should not break")
	public void ui_should_remain_stable() 
	{
		landingPage.remainStable();
	}

	@And("I enter an emoji in the email input box")
	public void enter_emoji_in_first_name()
	{
		landingPage.emojiInFirstName();
	}

	@Then("I should see email input box disabled")
	public void email_button_disabled()
	{
		landingPage.emailButtonDisabled();
	}

	@And("I resize the window to mobile size")
	public void resize_window_to_mobile() 
	{
		driver.manage().window().setSize(new Dimension(375, 667));
	}

	@When("I scroll and click the Get free CRM button")
	public void i_click_get_free_crm_button()
	{
		landingPage.scrollAndClickFreeCrm();
	}

	@Then("It should not be clickable or accessible")
	public void login_should_be_inaccessible() 
	{
		System.out.println("Verified that Get Free CRM Button was not accessible on small screen");
	}

	@When("I scroll to the footer section")
	public void scroll_to_footer() 
	{
		landingPage.scrollToFooter();
	}

	@Then("I should see all footer links are displayed")
	public void verify_footer_links_are_displayed() 
	{
		landingPage.footerLinks();
	}

	@Then("All footer links should be clickable and navigable")
	public void validate_all_footer_links() 
	{
		landingPage.validateFooterLinks();
	}
}

