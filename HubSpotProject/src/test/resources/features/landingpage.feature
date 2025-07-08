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
    
@Smoke @Regression 
Scenario: Verify login button is enabled and redirects to login page
  Given I open the HubSpot CRM product page
  When I click the Log in button
  Then I should be redirected to the login page
  
@Smoke @Regressio
  Scenario Outline: Verify top navigation dropdown "<dropdownName>" is enabled and clickable
    Given I open the HubSpot CRM product page
    When I click on the "<dropdownName>" dropdown
    Then The "<dropdownName>" dropdown should be Enabled

    Examples:
      | dropdownName |
      | Products     |
      | Solutions    |
      | Resources    |
  	
@Smoke @Regression @Test
Scenario Outline: Click on "<menuButton>" from "<dropdownName>" dropdown
  	Given I open the HubSpot CRM product page
  	When I click on the "<dropdownName>" dropdown
  	And I click on "<menuButton>" menu button
  	Then Page should be redirected to "<partialUrl>"
  	
  	Examples:
    | dropdownName | menuButton               | partialUrl |
    | Products     | Marketing Hub            | marketing  |
    | Products     | Sales Hub                | sales      |
    | Products     | Service Hub              | service    |
    | Products     | Content Hub              | content    |
    | Products     | Operation Hub            | operation  |
    | Products     | Commerce Hub             | commerce   |
    
  	