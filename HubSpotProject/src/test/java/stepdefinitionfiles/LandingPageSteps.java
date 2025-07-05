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
        Thread.sleep(5000);
    }

    @Then("the free CRM page title should be {string}")
    public void free_CRMpageTitle(String expectedTitle) 
    {
        String actualTitle = driver.getTitle();
        System.out.println(actualTitle);
        System.out.println(expectedTitle);
        Assert.assertEquals(actualTitle, expectedTitle);
    }

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
}

