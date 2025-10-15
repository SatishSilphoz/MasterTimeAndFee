Feature: TimeandFees dashboard

  Background: User login
   Given Launch the browser
    And User need to enter the Application Url
    When User Enter username and password
    Then User Click on login button
    And redirect to Time and Fees module

  @Dashboard 
  Scenario: Validate widget functionality in dashboard
    Given Navigate to Dashboard
    Then Validate Add Widget button
    And uncheck all boxes time section charts and fees section charts
    Then click on save
    Then Check all boxes time section charts and fees section charts
    Then click on save
    And scroll to view and verify

  @Dashboard
  Scenario: Validate each value of time filter dropdown
    Given Navigate to Dashboard
    Then Validate each value of dropdown of time filter

  @Dashboard
  Scenario: Validate lock functionality in dashboard
    Given Navigate to Dashboard
    Then Validate lock button
 
  @Dashboard 
  Scenario: Validate timer widget functionality in dashboard
    Given Navigate to Dashboard
    Then Validate the timer section

  @Dashboard 
  Scenario: Validate task wise hour details widget dropdown functionality in dashboard
    Given Navigate to Dashboard
    Then take each value from task wise hour dropdown and take screenshot

  @Dashboard
  Scenario: Validate total task hours widget dropdown functionality in dashboard
    Given Navigate to Dashboard
    Then take each value from task hours dropdown and take screenshot
