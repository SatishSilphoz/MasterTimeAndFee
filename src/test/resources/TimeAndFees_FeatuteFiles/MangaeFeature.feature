Feature: Manage

  Background: User login
    Given Launch the browser
    And User need to enter the Application Url
    When User Enter username and password
    Then User Click on login button
    And redirect to Time and Fees module

  @Manage @client
  Scenario: Manage validateion
    Given user is on Time
    When user clicks manage button
    Then manage page should open
    Then click on the Add Client button
    Given client Create in Time and Fees
    Then Verify the client created or not

  @Manage @client @editclient
  Scenario: Edit client
    Given user is on Time
    When user clicks manage button
    Then manage page should open
    Given user is on manage
    And Hover on record
    Then click on the edit icon
    Then verify it opening Edit client Page
    Then edit client and click on save

  @Manage @client
  Scenario: grid action
    Given user is on Time
    When user clicks manage button
    Then manage page should open
    Given user is on manage
    Then Hover on record
    Then click on the Archive icon
    Then click on the yes button
    Then Hover on record
    Then click on the Delete icon
    Then select the checkbox in Popup
    Then click on the Yes button

  @Manage @client
  Scenario: Archive client
    Given user is on Time
    When user clicks manage button
    Then manage page should open

  @Manage @client
  Scenario: Validate export as excel
    Given user is on Time
    When user clicks manage button
    Then manage page should open
    Then click on toolbar manage
    And click on export as excel

  @Manage @client
  Scenario: Validate export as csv
    Given user is on Time
    When user clicks manage button
    Then manage page should open
    Then click on toolbar manage
    And click on export as csv

  @Manage @client
  Scenario: Validate export as pdf
    Given user is on Time
    When user clicks manage button
    Then manage page should open
    Then click on toolbar manage
    And click on export as pdf

  @Manage @client
  Scenario: validate status dropdown in manage
    Given user is on Time
    When user clicks manage button
    Then manage page should open
    Then click on status dropdown and select status manage
    Then Validate status is displaying in grid manage

  #//////////////////////////////////////////////////// TASK ///////////////////////////////////////////////////
  @Manage @task
  Scenario: Validate Task Menu
    Given user is on Time
    When user clicks manage button
    Then manage page should open
    Then click on the Tasks menu

  @Manage @task
  Scenario: Validate Add Task
    Given user is on Time
    When user clicks manage button
    Then manage page should open
    Then click on the Tasks menu
    Then click on the Add Task button and verify

  @Manage @task
  Scenario: validate Add new task
    Given user is on Time
    When user clicks manage button
    Then manage page should open
    Then click on the Tasks menu
    Then click on the Add Task button and verify
    Then Fill all details and click on save

  @Manage @task
  Scenario: validate search in Task
    Given user is on Time
    When user clicks manage button
    Then manage page should open
    Then click on the Tasks menu
    Then verify created task appears in search

  @Manage @task
  Scenario: validate status dropdown in task
    Given user is on Time
    When user clicks manage button
    Then manage page should open
    Then click on the Tasks menu
    Then click on status dropdown and select status manage
    Then Validate status is displaying in grid manage

  @Manage @task
  Scenario: validating export as in task
    When user clicks manage button
    Then click on the Tasks menu
    Then click on toolbar jobs
    And click on export as excel
    Then click on toolbar jobs
    And click on export as csv
    Then click on toolbar jobs
    And click on export as pdf

  @Manage @task
  Scenario: validating edit icon in task
    Given user is on Time
    When user clicks manage button
    Then manage page should open
    Then click on the Tasks menu
    Then Hover on record
    Then click on edit icon in task

  @Manage @task
  Scenario: Edit a task, verify update in form and in search
    Given user is on Time
    When user clicks manage button
    Then manage page should open
    Then click on the Tasks menu
    Then Hover on record
    Then click on edit icon in task
    Then update task details and verify in form and search

  @Manage @task
  Scenario: validate grid action
    Given user is on Time
    When user clicks manage button
    Then manage page should open
    Then click on the Tasks menu
    Then Hover on record
    Then click on the Archive icon
    Then click on the yes button
    Then Hover on record
    Then click on the Delete icon
    Then select the checkbox in Popup
    Then clck on the Yes button

  #//////////////////////////////////// USER //////////////////////////////////////
  @Manage @user
  Scenario: Navigate to Users page
    Given user is on Time
    When user clicks manage button
    Then manage page should open
    Then click on the Users menu
    Then Users page should open

  @Manage @user
  Scenario: Validate Add User functionality
    Given user is on Time
    When user clicks manage button
    Then manage page should open
    Then click on the Users menu
    Then Users page should open
    Then click on the Add User button

  @Manage @user
  Scenario: Add new user and verify
    Given user is on Time
    When user clicks manage button
    Then manage page should open
    Then click on the Users menu
    Then Users page should open
    Then click on the Add User button
    When fill user form from Excel and verify in search

  #//////////////   can not edit the user but code is ready
  @Manage @user
  Scenario: Edit an existing user and verify the update
    Given user is on Time
    When user clicks manage button
    Then manage page should open
    Then click on the Users menu
    Then Users page should open
    Then Hover on record
    Then edit user details and verify in search

  @Manage @user
  Scenario: Validate user search using Excel data
    Given user is on Time
    When user clicks manage button
    Then manage page should open
    Then click on the Users menu
    Then search and verify the user from excel

  @Manage @user
  Scenario: validate status dropdown in user
    Given user is on Time
    When user clicks manage button
    Then manage page should open
    Then click on the Users menu
    Then click on status dropdown and select status manage
    Then Validate status is displaying in grid manage

  @Manage @user
  Scenario: validating export as in Users
    Given user is on Time
    When user clicks manage button
    Then manage page should open
    Then click on the Users menu
    Then click on toolbar jobs
    And click on export as excel
    Then click on toolbar jobs
    And click on export as csv
    Then click on toolbar jobs
    And click on export as pdf

  @Manage @user
  Scenario: validate Delete in task
    Given user is on Time
    When user clicks manage button
    Then manage page should open
    Then click on the Users menu
    Then Hover on record
    Then click on the Archive icon
    Then click on the yes button
    Then Hover on record
    Then click on the Delete icon
    Then select the checkbox in Popup
    Then clck on the Yes button

  #/////////////////////////////// EXPENSE TYPES //////////////////////////////////////
  @Manage @expensetype
  Scenario: Validate navigation to Expense Types menu
    Given user is on Time
    When user clicks manage button
    Then manage page should open
    Then click on the Expense Types menu

  @Manage @expensetype
  Scenario: Validate navigation to Add Expense Type page
    Given user is on Time
    When user clicks manage button
    Then manage page should open
    Then click on the Expense Types menu
    Then click on the Add Expense Type button and verify URL

  @Manage @expensetype
  Scenario: Add Expense Type from Excel
    Given user is on Time
    When user clicks manage button
    Then manage page should open
    Then click on the Expense Types menu
    Then click on the Add Expense Type button and verify URL
    Then fill the Add Expense Type form from Excel and submit

  @Manage @expensetype
  Scenario: validating Satus dropdown in the Expense Types
    Given user is on Time
    When user clicks manage button
    Then manage page should open
    Then click on the Expense Types menu
    Then click on status dropdown and select status manage
    Then Validate status is displaying in grid manage

  @Manage @expensetype
  Scenario: validating export as Excel in Expense Types
    Given user is on Time
    When user clicks manage button
    Then manage page should open
    Then click on the Expense Types menu
    Then click on toolbar jobs
    And click on export as excel
    Then click on toolbar jobs
    And click on export as csv
    Then click on toolbar jobs
    And click on export as pdf

  @Manage @expensetype
  Scenario: validating Edit in Expense Types
    Given user is on Time
    When user clicks manage button
    Then manage page should open
    Then click on the Expense Types menu
    Then Hover on record
    Then click on edit icon in Expense Types
    Then update task details and verify it from search

  @Manage @expensetype
  Scenario: validating Delete in Expense Types
    Given user is on Time
    When user clicks manage button
    Then manage page should open
    Then click on the Expense Types menu
    Then Hover on record
    Then click on the Archive icon
    Then click on the yes button
    Then Hover on record
    Then click on the Delete icon
    Then select the checkbox in Popup
    Then click on the Yes button

  #//////////////////////////////////IMPORT ///////////////////////////////////
  @Manage @Import
  Scenario: Validate navigation to Import  menu
    Given user is on Time
    When user clicks manage button
    Then manage page should open
    Then Click on Import menu

  @Manage @Import
  Scenario: Validate navigation to Import menu 1
    Given user is on Time
    When user clicks manage button
    Then manage page should open
    Then Click on Import menu
    Then Click on client checkbox
    Then Click on Next button

  @Manage @Import
  Scenario: Validate navigation to Import menu 2
    Given user is on Time
    When user clicks manage button
    Then manage page should open
    Then Click on Import menu
    Then Click on client checkbox
    Then Click on Next button
    Then Select random module from dropdown
    Then Select all client types
    Then Click Next buttons

  @Manage @Import
  Scenario: Validate navigation to Import menu 3
    Given user is on Time
    When user clicks manage button
    Then manage page should open
    Then Click on Import menu
    Then Click on client checkbox
    Then Click on Next button
    Then Select random module from dropdown
    Then Select all client types
    Then Click Next buttons
    Then Click on Accept And Continue and take screenshot

  #//for all type import
  @Manage @Import
  Scenario: Import data for all categories
    Given user is on Time
    When user clicks manage button
    Then manage page should open
    Given User is on the Import page
    When User imports data for all categories
    Then The data should be imported successfully for all categories

  #////////////////////////////////////// EXPORT ////////////////////////////////////////////////
  @Manage @export
  Scenario: Validate navigation to Export menu
    Given user is on Time
    When user clicks manage button
    Then manage page should open
    Then click on the Export menu

  @Manage @export
  Scenario: Export data for each date range, each category, and each format
    Given user is on Time
    When user clicks manage button
    Then manage page should open
    Then click on the Export menu
    Then user exports data for each date range, each category, and each file format
