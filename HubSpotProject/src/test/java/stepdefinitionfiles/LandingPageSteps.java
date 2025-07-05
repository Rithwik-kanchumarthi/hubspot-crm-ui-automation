package stepdefinitionfiles;

import base.BaseTest;
import io.cucumber.java.en.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import pages.DemoFormPage;
import pages.LandingPage;

import static org.testng.Assert.*;

public class LandingPageSteps 
{
    WebDriver driver;
    LandingPage landingPage;
    DemoFormPage demoForm;

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
    public void click_Get_free_CRM_button()
    {
        landingPage.clickCRMButton();
    }

    @Then("Get free CRM button should be Enabled")
    public void validate_homepage_navigation() 
    {
        assertTrue(driver.findElement(By.cssSelector(".cl-button.-primary.-medium.wf-page-header__cta.freecrm-hero")).isEnabled());
    }

    @Given("I open the CRM demo page")
    public void open_demo_form_page() {
        driver = BaseTest.getDriver();
        driver.get("https://www.hubspot.com/products/crm/demo");
        demoForm = new DemoFormPage(driver);
    }

    @When("I fill and submit valid form details")
    public void fill_form() throws InterruptedException {
        demoForm.fillForm("Rithwik Venkatesh", "Kanchumarthi", "ritturithwik@gmail.com", "6303864339", "TCS", "http://tcs.com", "India");
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
}

