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

  @Time @TimeLog
  Scenario: Validate day/week toggel
    Given Navigation to time tab
    Then toggle to day option
    And verify current Date coming in grid

  @Time @TimeLog 
  Scenario: Validate export option
    Given Navigation to time tab
    Then click on toolbar
    And click on export option
    Then click on export button and verify

  @Time @TimeLog
  Scenario: Validate save button and verify
    Given Navigation to time tab
    Then click on the save grid
    And Verify time sheet saved or not
    Then click on submit approval button
    And Verify time sheet submit or not
    Then click on delete icon on grid
    Then verify record is deleted in grid

  #//unsubmitted sub-tab
  @Time @Unsubmitted
  Scenario: Validate search field and verify
    Given Navigation to time tab
    Then Navigate to unsubmitted sub-tab
    Then click on search fild and add value
    And Verify that record in grid

  @Time @Unsubmitted
  Scenario: Validate By user/week and verify
    Given Navigation to time tab
    Then Navigate to unsubmitted sub-tab
    Then click on By user dropdown and select By week
    And Verify that in grid with week name

  @Time @Unsubmitted
  Scenario: Validate user filter and verify
    Given Navigation to time tab
    Then Navigate to unsubmitted sub-tab
    Then click on user dropdown and select user
    And Verify that user in grid

  @Time @Unsubmitted
  Scenario: Validate overview page of user
    Given Navigation to time tab
    Then Navigate to unsubmitted sub-tab
    Then click on record expend icon
    And click on visible content
    Then Validate overview page
    Then click on send reminder button and verify
    Then click on record expend icon
    And click on visible content
    Then click on submit for approval button and verify

  @Time @Unsubmitted
  Scenario: Validate Send reminder and submit for approval icon on grid action
    Given Navigation to time tab
    Then Navigate to unsubmitted sub-tab
    And Hover on record
    Then click on send reminder button and verify
    And Hover on record
    Then click on submit for approval button and verify
 
  @Time @Unsubmitted @one
  Scenario: Validate export option
    Given Navigation to time tab
    Then Navigate to unsubmitted sub-tab
    Then click on toolbar
    And click on export as excel
    Then click on toolbar
    And click on export as csv
    Then click on toolbar
    And click on export as pdf

  #PFA sub-tab
  @Time @PFA
  Scenario: Validate search field and verify
    Given Navigation to time tab
    Then Navigate to PFA sub-tab
    Then click on search fild and add value
    And Verify that record in grid

  @Time @PFA
  Scenario: Validate By user/week and verify
    Given Navigation to time tab
    Then Navigate to PFA sub-tab
    Then click on By user dropdown and select By week
    And Verify that in grid with week name

  @Time @PFA
  Scenario: Validate user filter and verify
    Given Navigation to time tab
    Then Navigate to PFA sub-tab
    Then click on user dropdown and select user
    And Verify that user in grid

  @Time @PFA
  Scenario: Validate overview page of user
    Given Navigation to time tab
    Then Navigate to PFA sub-tab
    Then click on record expend icon
    And click on visible content
    Then Validate overview page
    Then click on send Note button and verify
    Then click on record expend icon
    And click on visible content
    Then click on reject button and verify
    Then click on record expend icon
    And click on visible content
    Then click on approve button

  @Time @PFA
  Scenario: Validate Approve icon on grid action
    Given Navigation to time tab
    Then Navigate to PFA sub-tab
    And Hover on record
    Then click on approve button
    And Hover on record
    Then click on reject button and verify
    And Hover on record
    Then click on send Note button and verify

  @Time @PFA
  Scenario: Validate export option
    Given Navigation to time tab
    Then Navigate to PFA sub-tab
    Then click on toolbar
    And click on export as excel
    Then click on toolbar
    And click on export as csv
    Then click on toolbar
    And click on export as pdf

  #Approved sub-tab
  @Time @Approved
  Scenario: Validate search field and verify
    Given Navigation to time tab
    Then Navigate to approved sub-tab
    Then click on search fild and add value
    And Verify that record in grid

  @Time @Approved
  Scenario: Validate By user/week and verify
    Given Navigation to time tab
    Then Navigate to approved sub-tab
    Then click on By user dropdown and select By week
    And Verify that in grid with week name

  @Time @Approved
  Scenario: Validate user filter and verify
    Given Navigation to time tab
    Then Navigate to approved sub-tab
    Then click on user dropdown and select user
    And Verify that user in grid

  @Time @Approved
  Scenario: Validate overview page of user
    Given Navigation to time tab
    Then Navigate to approved sub-tab
    Then click on record expend icon
    And click on visible content
    Then Validate overview page
    Then click on withdraw approve button

  @Time @Approved
  Scenario: Validate withdraw approve button on grid action
    Given Navigation to time tab
    Then Navigate to approved sub-tab
    And Hover on record
    Then click on withdraw approve button

  @Time @Approved
  Scenario: Validate export option
    Given Navigation to time tab
    Then Navigate to approved sub-tab
    Then click on toolbar
    And click on export as excel
    Then click on toolbar
    And click on export as csv
    Then click on toolbar
    And click on export as pdf

  #Rejection sub-tab
  @Time @Rejection
  Scenario: Validate search field and verify
    Given Navigation to time tab
    Then Navigate to rejected sub-tab
    Then click on search fild and add value
    And Verify that record in grid

  @Time @Rejection
  Scenario: Validate By user/week and verify
    Given Navigation to time tab
    Then Navigate to rejected sub-tab
    Then click on By user dropdown and select By week
    And Verify that in grid with week name

  @Time @Rejection
  Scenario: Validate user filter and verify
    Given Navigation to time tab
    Then Navigate to rejected sub-tab
    Then click on user dropdown and select user
    And Verify that user in grid

  @Time @Rejection
  Scenario: Validate overview page of user
    Given Navigation to time tab
    Then Navigate to rejected sub-tab
    Then click on record expend icon
    And click on visible content
    Then Validate overview page
    Then click on withdraw rejected button

  @Time @Rejection
  Scenario: Validate withdraw reject button on grid action
    Given Navigation to time tab
    Then Navigate to rejected sub-tab
    And Hover on record
    Then click on withdraw rejected button

  @Time @Rejection
  Scenario: Validate export option
    Given Navigation to time tab
    Then Navigate to rejected sub-tab
    Then click on toolbar
    And click on export as excel
    Then click on toolbar
    And click on export as csv
    Then click on toolbar
    And click on export as pdf
