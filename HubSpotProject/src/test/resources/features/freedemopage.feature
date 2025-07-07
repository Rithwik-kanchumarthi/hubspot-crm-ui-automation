Feature: HubSpot Free Demo Page Validation
    
	@Regression @Smoke
  Scenario: Submit demo form with valid data
    Given I open the CRM demo page
    When I fill and submit valid form details
    Then I should see a redirection
  
  @Negative @Validation @Regression
  Scenario: Attempt to submit form without required fields
  	Given I open the CRM demo page
  	When I submit the demo form with missing required fields
  	Then I should see validation error messages for required fields
  	
  @Negative @Regression
	Scenario: Submit demo form with invalid email
  	Given I open the CRM demo page
  	When I submit the demo form with invalid email address
 		Then I should see a validation error for email field