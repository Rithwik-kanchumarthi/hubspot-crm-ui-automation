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
  
@Smoke @Regression
Scenario Outline: Verify top navigation dropdown "<dropdownName>" is enabled and clickable
  Given I open the HubSpot CRM product page
  When I click on the "<dropdownName>" dropdown
  Then The "<dropdownName>" dropdown should be Enabled

    Examples:
      | dropdownName |
      | Products     |
      | Solutions    |
      | Resources    |
  	
@Smoke @Regression
Scenario Outline: Click on "<menuButton>" from "<dropdownName>" dropdown
  Given I open the HubSpot CRM product page
  When I click on the "<dropdownName>" dropdown
  And I click on "<menuButton>" menu button
  Then Page should be redirected to "<partialUrl>"
  	
  	Examples:
    | dropdownName | menuButton               | partialUrl     |
    | Products     | Marketing Hub            | marketing      |
    | Products     | Sales Hub                | sales          |
    | Products     | Service Hub              | service?hub    |
    | Products     | Content Hub              | content        |
    | Products     | Operations Hub           | operations     |
    | Products     | Commerce Hub             | commerce       |
    
@Negative @UI @Regression 
Scenario: Click "Get free CRM" with chat widget obstructing the button
  Given I open the HubSpot CRM product page
  And The chat widget is expanded
  When I click the Get free CRM button
  Then I should not be able to click it until the chat is closed

@Negative @UI @Regression
Scenario: Toggle High Contrast mode and check broken UI
  Given I open the HubSpot CRM product page
  When I enable High Contrast mode
  Then UI elements like text, buttons, and layout should not break

@Negative @Validation @Regression @Test
Scenario: Open "Get free CRM" form and input emoji in name field
  Given I open the HubSpot CRM product page
  When I click the Get free CRM button
  And I enter an emoji in the email input box
  Then I should see email input box disabled

@Negative @UI @Regression
Scenario: Click "Get free CRM" button when it is partially hidden
  Given I open the HubSpot CRM product page
  And I resize the window to mobile size
  When I scroll and click the Get free CRM button
  Then It should not be clickable or accessible

    
  	