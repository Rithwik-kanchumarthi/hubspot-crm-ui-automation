package stepdefinitionfiles;

import base.BaseTest;
import io.cucumber.java.en.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import pages.DemoFormPage;
import pages.LandingPage;

import static org.testng.Assert.*;

public class FreeDemoPageSteps 
{
	WebDriver driver;
    LandingPage landingPage;
    DemoFormPage demoForm;
    
	@Given("I open the CRM demo page")
    public void open_demo_form_page() 
    {
        driver = BaseTest.getDriver();
        driver.get("https://www.hubspot.com/products/crm/demo");
        demoForm = new DemoFormPage(driver);
    }

    @When("I fill and submit valid form details")
    public void fill_form() throws InterruptedException 
    {
        demoForm.fillForm("Rithwik Venkatesh", "Kanchumarthi", "ritturithwik@gmail.com", "6303864339", "TCS", "http://tcs.com", "1", "India");
        demoForm.submit();
        Thread.sleep(5000);
    }

    @Then("I should see a redirection")
    public void verify_success() 
    {
    	String redirectedurl = driver.getCurrentUrl();
    	String expectedurl = "https://offers.hubspot.com/thank-you/starter-platform-demo?hubs_signup-url=https%3A%2F%2Foffers.hubspot.com%2Fcrm-platform-demo";
    	Assert.assertEquals(redirectedurl,expectedurl);
    }
    
    @When("I submit the demo form with missing required fields")
    public void submit_form_with_missing_fields() 
    {
        demoForm.submitWithMissingFields();
    }

    @Then("I should see validation error messages for required fields")
    public void validate_required_field_errors() 
    {
        Assert.assertTrue(demoForm.isRequiredFieldErrorDisplayed());
    }

    @When("I submit the demo form with invalid email address")
    public void submit_form_with_invalid_email() 
    {
        demoForm.fillFormWithInvalidEmail();
    }

    @Then("I should see a validation error for email field")
    public void validate_email_error() 
    {
        Assert.assertTrue(demoForm.isEmailErrorDisplayed());
    }


}
