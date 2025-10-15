Feature: TimeandFees jobs tab

  Background: User login
    Given Launch the browser
    And User need to enter the Application Url
    When User Enter username and password
    Then User Click on login button
    And redirect to Time and Fees module

  @Jobs @Job 
  Scenario: Creation of Job and verify
    Given Navigation to Jobs tab
    Then click on add Job button
    And fill all the fields in job popup
    Then click on the save
    And verify search functionality
    Then click on add Job button
    And fill all the fields in job popup
    Then click on the save & view details
    Then click on cross icon
    Then click on add Job button
    And fill all the fields in job popup
    Then click on the save & add another
    And Validate add jobs dialog
    And fill all the fields in job popup
    Then click on the cancel
    And validate popup is getting close

  @Jobs @Job
  Scenario: validate evryone jobs dropdown
    Given Navigation to Jobs tab
    Then click on my jobs option
    Then validate user column should disappear

  @Jobs @Job 
  Scenario: validate status dropdown in Jobs
    Given Navigation to Jobs tab
    Then click on status dropdown and select status
    Then Validate status is displaying in grid

  @Jobs @Job 
  Scenario: validate task dropdown in jobs
    Given Navigation to Jobs tab
    Then click on task dropdown
    Then select any option
    Then task should display in grid validate

  @Jobs @Job @Rerun
  Scenario: validate customize columns with save and cancel button
    Given Navigation to Jobs tab
    Then click on customize columns
    And uncheck all boxes
    Then validate columns should disappear
    Then click on customize columns
    Then check all boxes
    And validate columns should appear
    Then click on customize columns
    And click on cancel button for customize column
    Then validate panel should disappear

  @Jobs @Job 
  Scenario: Validate time status filter
    Given Navigation to Jobs tab
    Then Validate each value of dropdown of time filter in jobs

  @Jobs @Job 
  Scenario: validate Bulk jobs option
    Given Navigation to Jobs tab
    Then click on toolbar jobs
    And click on Bulk job
    Then fill all the details in bulk job popup
    And click on the save
    Then validate with custome message

  @Jobs @Job
  Scenario: validate export option
    Given Navigation to Jobs tab
    Then click on toolbar jobs
    And click on export as excel
    Then click on toolbar jobs
    And click on export as csv
    Then click on toolbar jobs
    And click on export as pdf

  @Jobs @Job @Rerun
  Scenario: validate edit page of jobs
    Given Navigation to Jobs tab
    Then Hover on record
    And click on edit icon
    And Validate edit page
    And click on add sub task button
    Then enter the data in new row
    And click on the save
    And click on the save and exit
    Then Hover on record
    And click on edit icon
    And fill all the fields in job popup
    And click on add sub task button
    Then enter the data in new row
    And click on cancel changes
    And click on subtask dropdown and select option
    Then validate selected option
    And click on timelog sub section
    Then click on email sub section
    And send the keys in fields
    Then click on send mail button
    Then click on cancel button for customize column
    And validate cancel changes in email sub section
    Then click on recurring sub section
    And click on repeat this job dropdown and select option
    Then select option from create first job on dropdown
    And click on the save
    And click on save and exit
    Then validate save and exit in details
    Then Hover on record
    And click on edit icon
    Then click on recurring sub section
    And click on end this recurring
    And click on files sub section
    And click on comment sub section
    And send keys in comments
    Then click on submit button
    And send keys in comments
    Then click on cancel button for customize column
    And Validate cancel in comments
    And click on activity sub section
    And click on invoice sub section
    And click on side bar icon
    Then click on add Job button
    And fill all the fields in job popup in side panel
    Then click on the save
    And click on side bar icon
    Then click on search icon
    And verify time is created or not
    Given Navigation to Jobs tab
    Then Hover on record
    And click on delete icon
    And Validate record delete

  @Jobs @Job 
  Scenario: validate checkbox  of grid
    Given Navigation to Jobs tab
    Then click on checkbox of grid
    And click on mark as completed button
    And validate with custome message
    Then click on checkbox of grid
    And click on mark as yet to start button
    And validate with custome message
    Then click on checkbox of grid
    And click on delete button on checkbox
    Then click on checkbox of grid
    And click on export as excel
    Then click on checkbox of grid
    And click on export as csv
    Then click on checkbox of grid
    And click on export as pdf
    Then click on checkbox of grid

  # Claneder
  @Jobs @calender
  Scenario: validate side panel view
    Given Navigation to Jobs tab
    Then Click on calender sub-tab
    And click on side bar icon
    Then Send key is search field and validate

  @Jobs @calender 
  Scenario: Creation of Job and verify
    Given Navigation to Jobs tab
    Then Click on calender sub-tab
    Then Click on add job button calendar
    And fill all the fields in job popup
    Then click on the save
    And verify Job is created or not in calendar

  @Jobs @calender
  Scenario: validate calender actions
    Given Navigation to Jobs tab
    Then Click on calender sub-tab
    And click on calender button
    Then selct year and month
    Then Validate the year and month
    And switch to week view and validate
    And switch to day view and validate
