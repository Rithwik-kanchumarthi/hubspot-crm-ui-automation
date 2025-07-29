Feature: HubSpot Login Functionality

  As a valid or invalid user
  I want to verify the login scenarios
  So that I can ensure HubSpot authentication behaves as expected

  Background:
    Given User is on the HubSpot login page

  @Positive @Regression
  Scenario: Login with valid email and password
    When User enters valid email "ritturithwik@gmail.com"
    And User clicks on login button
    And User enters valid password "R@ithwik1234"
    And User clicks on login button
    Then User should be redirected to the dashboard

  @Negative @Regression
  Scenario: Login with invalid email and valid password
    When User enters invalid email "invalid@example.com"
    And User clicks on login button
    Then User should see an authentication error message

  @Negative @Regression
  Scenario: Login with valid email and invalid password
    When User enters valid email "ritturithwik@gmail.com"
    And User clicks on login button
    And User enters invalid password "wrongpass"
    And User clicks on login button
    Then User should see an authentication error message

  @Negative @Regression
  Scenario: Login with empty credentials
    When User leaves email blank
    And User clicks on login button
    Then User should see required field errors

  @UI @Regression
  Scenario: Check forgot password link is visible
    Then "Forgot my password" link should be displayed

  @UI @Regression
  Scenario: Check login button is disabled with empty fields
    Then Login button should be disabled
