Feature: HubSpot CRM Page Validation

	@Regression
  Scenario: Verify CRM Product Page Title
    Given I launch the browser
    When I open the CRM product page
    Then the page title should be "Streamline Your Entire Business with a Free CRM | HubSpot"
    
	@Regression
  Scenario: Verify Get free CRM button is Enabled
    Given I open the HubSpot CRM product page
    When I click the Get free CRM button
    Then the free CRM page title should be "Get started with HubSpot"
    
	@Regression
  Scenario: Submit demo form with valid data
    Given I open the CRM demo page
    When I fill and submit valid form details
    Then I should see a redirection
