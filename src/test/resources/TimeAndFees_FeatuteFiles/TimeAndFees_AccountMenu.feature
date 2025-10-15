Feature: TimeandFees Account menu section

  Background: User login
    Given Launch the browser
    And User need to enter the Application Url
    When User Enter username and password
    Then User Click on login button
    And redirect to Time and Fees module

 

  #activity
  @AccountMenu @Activity 
  Scenario: Validate history panel in activity
    Given click on history button
    Then Validate recent activity panel
    Then click on view all activity text
    And validate activity page

  @AccountMenu @Activity
  Scenario: validating serach functionality in activity page
    Given click on history button
    Then click on view all activity text
    And verify search functionality

  @AccountMenu @Activity
  Scenario: validating all dropdown functionality in activity page
    Given click on history button
    Then click on view all activity text
    And validating all dropdown in activity

  