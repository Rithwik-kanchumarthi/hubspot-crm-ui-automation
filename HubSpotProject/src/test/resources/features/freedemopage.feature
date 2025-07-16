Feature: HubSpot Free Demo Page Validation
    
@Regression @Smoke
Scenario: Submit demo form with valid data
  Given User open the CRM demo page
  When User fill and submit valid form details
  Then User should see a redirection
  
@Negative @Validation @Regression
Scenario: Attempt to submit form without required fields
  Given User open the CRM demo page
  When User submit the demo form with missing required fields
  Then User should see validation error messages for required fields
  	   
@Negative @Regression
Scenario: Submit demo form with invalid email
  Given User open the CRM demo page
  When User submit the demo form with invalid email address
 	Then User should see a validation error for email field
 		
@Smoke @UI
Scenario: Open Demo Page Successfully
  Given User open the CRM demo page
  Then User should see the "Request a Demo" heading