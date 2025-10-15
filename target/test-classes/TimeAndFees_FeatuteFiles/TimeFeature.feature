Feature: TimeandFees time tab

  Background: User login
    Given Launch the browser
    And User need to enter the Application Url
    When User Enter username and password
    Then User Click on login button
    And redirect to Time and Fees module

  @Time @TimeLog
  Scenario: Creation of time and verify
    Given Navigation to time tab
    Then click on add time button
    And fill all the fields in popup
    Then click on the save
    And verify time is created or not
    Then click on add time button
    And fill all the fields in popup
    Then click on the cancel
    And validate popup is getting close

  @Time @TimeLog
  Scenario: Validate user dropdown and verify
    Given Navigation to time tab
    Then click on user dropdown
    And selct user
    Then verify that user coming in grid

  