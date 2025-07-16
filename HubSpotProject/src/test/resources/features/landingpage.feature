Feature: HubSpot CRM Page Validation

@Regression
Scenario: Verify CRM Product Page Title
  Given User launch the browser
  When User open the CRM product page
  Then the page title should be "Streamline Your Entire Business with a Free CRM | HubSpot"
    
@Regression
Scenario: Verify Get free CRM button is Enabled
  Given User open the HubSpot CRM product page
  When User click the Get free CRM button
  Then the free CRM page title should be "Get started with HubSpot"
    
@Smoke @Regression
Scenario: Verify login button is enabled and redirects to login page
  Given User open the HubSpot CRM product page
  When User click the Log in button
  Then User should be redirected to the login page
  
@Smoke @Regression
Scenario Outline: Verify top navigation dropdown "<dropdownName>" is enabled and clickable
  Given User open the HubSpot CRM product page
  When User click on the "<dropdownName>" dropdown
  Then The "<dropdownName>" dropdown should be Enabled

    Examples:
      | dropdownName |
      | Products     |
      | Solutions    |
      | Resources    |
  	
@Smoke @Regression
Scenario Outline: Click on "<menuButton>" from "<dropdownName>" dropdown
  Given User open the HubSpot CRM product page
  When User click on the "<dropdownName>" dropdown
  And User click on "<menuButton>" menu button
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
  Given User open the HubSpot CRM product page
  And The chat widget is expanded
  When User click the Get free CRM button
  Then User should not be able to click it until the chat is closed

@Negative @UI @Regression
Scenario: Toggle High Contrast mode and check broken UI
  Given User open the HubSpot CRM product page
  When User enable High Contrast mode
  Then UI elements like text, buttons, and layout should not break

@Negative @Validation @Regression 
Scenario: Open "Get free CRM" form and input emoji in name field
  Given User open the HubSpot CRM product page
  When User click the Get free CRM button
  And User enter an emoji in the email input box
  Then User should see email input box disabled

@Negative @UI @Regression
Scenario: Click "Get free CRM" button when it is partially hidden
  Given User open the HubSpot CRM product page
  And User resize the window to mobile size
  When User scroll and click the Get free CRM button
  Then It should not be clickable or accessible
  
@Regression @Test
Scenario: Validate footer links navigation
Given User open the HubSpot CRM product page
When User scroll down to the footer
Then User should see all footer links are displayed
And All footer links should be clickable and navigable

    
  	