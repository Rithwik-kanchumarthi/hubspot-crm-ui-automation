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
    
@Smoke @Regression @Test
Scenario: Verify login button is enabled and redirects to login page
  Given I open the HubSpot CRM product page
  When I click the Log in button
  Then I should be redirected to the login page
  
@Smoke @Regression 
  Scenario Outline: Verify top navigation dropdown "<dropdownName>" is enabled and clickable
    Given I open the HubSpot CRM product page
    When I click on the "<dropdownName>" dropdown
    Then The "<dropdownName>" dropdown should be Selected

    Examples:
      | dropdownName |
      | Products     |
      | Solutions    |
      | Resources    |
  	
@Smoke @Regression
Scenario Outline: Click on "<menuButton>" from "<dropdownName>" dropdown
  	Given I open the HubSpot CRM product page
  	When I click on the "<dropdownName>" dropdown
  	And All options are listed and click on "<menuButton>"
  	Then "<menuButton>" should be clickable
  	
  	Examples:
    | dropdownName | menuButton               |
    | Products     | Marketing Hub            |
    | Products     | Sales Hub                |
    | Products     | Service Hub              |
    | Products     | Content Hub              |
    | Products     | Operation Hub            |
    | Products     | Commerce Hub             |
    | Solutions    | Generating leads         |
    | Solutions    | Build pipeline           |
    | Resources    | INBOUND Event            |
    | Resources    | Hubspot Community        |
  	