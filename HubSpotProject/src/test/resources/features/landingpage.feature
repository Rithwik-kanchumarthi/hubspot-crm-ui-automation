Feature: HubSpot CRM Page Validation

	@Regression
  Scenario: Verify CRM Product Page Title
    Given I launch the browser
    When I open the CRM product page
    Then the page title should be "Free CRM Software for Small Businesses - HubSpot"
    
	@Regression
  Scenario: Verify HubSpot Logo Navigation
    Given I open the CRM product page
    When I click the HubSpot logo
    Then I should be navigated to the homepage
    
	@Regression
  Scenario: Submit demo form with valid data
    Given I open the CRM demo page
    When I fill and submit valid form details
    Then I should see a success message or redirection
