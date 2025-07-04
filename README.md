==================================================================================================================
# hubspot-crm-ui-automation
===================================================================================================================
# 🚀 HubSpot CRM Automation Testing Framework

This repository contains an automated test framework for validating the **HubSpot CRM product page** using:

- Java
- Selenium WebDriver
- Cucumber BDD
- TestNG & JUnit
- Maven
- Page Object Model (POM)

-----------------------------------------------------------------------------------------------------------------

## 📁 Project Structure

-----------------------------------------------------------------------------------------------------------------
📄 Sample Feature File
------------------------------------------------------------------------------------------------------------------
Feature: HubSpot CRM Page

  @RegressionTest @SmokeTest
  Scenario: Validate CRM Page Title and Logo Click
    Given I launch the browser
    When I open the CRM product page
    Then the page title should be "Free CRM Software for Small Businesses - HubSpot"
    When I click the HubSpot logo
    Then I should be redirected to the homepage
------------------------------------------------------------------------------------------------------------------
