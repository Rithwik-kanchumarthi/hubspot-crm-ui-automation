package stepdefinitionfiles;

import base.BaseTest;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;

import pages.DemoFormPage;
import pages.LandingPage;

import static org.testng.Assert.*;

public class LandingPageSteps {
    WebDriver driver;
    LandingPage landingPage;
    DemoFormPage demoForm;

    @Given("I launch the browser")
    public void i_launch_the_browser() {
        driver = BaseTest.getDriver();
    }

    @When("I open the CRM product page")
    public void i_open_the_crm_product_page() {
        driver = BaseTest.getDriver();
        driver.get("https://www.hubspot.com/products/crm");
        landingPage = new LandingPage(driver);
    }

    @Then("the page title should be {string}")
    public void verify_page_title(String expectedTitle) {
        assertEquals(driver.getTitle(), expectedTitle);
    }

    @When("I click the HubSpot logos")
    public void click_hubspot_logo()
    {
        landingPage.clickLogo();
    }

    @Then("I should be navigated to the homepage")
    public void validate_homepage_navigation() {
        assertTrue(driver.getCurrentUrl().contains("hubspot.com"));
    }

    @Given("I open the CRM demo page")
    public void open_demo_form_page() {
        driver = BaseTest.getDriver();
        driver.get("https://www.hubspot.com/products/crm/demo");
        demoForm = new DemoFormPage(driver);
    }

    @When("I fill and submit valid form details")
    public void fill_form() {
        demoForm.fillForm("John", "Doe", "john@example.com", "1234567890", "Company Inc.");
        demoForm.submit();
    }

    @Then("I should see a success message or redirection")
    public void verify_success() {
        assertTrue(demoForm.confirmationDisplayed());
    }
}

