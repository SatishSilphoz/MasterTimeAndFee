Feature: TimeandFees reports tab

  Background: User login
    Given Launch the browser
    And User need to enter the Application Url
    When User Enter username and password
    Then User Click on login button
    And redirect to Time and Fees module

  @Reports @Time
  Scenario: Validate search functionality
    Given Navigation to Reports tab
    Then verify search functionality

  @Reports @Time
  Scenario: Validate hours dropdown
    Given Navigation to Reports tab
    Then Validate each value of billable dropdown

  @Reports @Time
  Scenario: Validate group by dropdown
    Given Navigation to Reports tab
    Then Validate each value of group by dropdown

  @Reports @Time
  Scenario: Validate filters button with save button
    Given Navigation to Reports tab
    Then click on filters button
    And select clients dropdown
    And select tasks dropdown
    And select users dropdown
    And select jobs dropdown
    Then click on save filter
    Then click on filters button
    And select clients dropdown
    And select tasks dropdown
    And select users dropdown
    And select jobs dropdown
    Then click on clear filter
    Then click on show filter details
    And click on modifiy results
    And select clients dropdown
    And select tasks dropdown
    And select users dropdown
    And select jobs dropdown
    Then click on save filter
    And click on clear all filter

  @Reports @Time
  Scenario: Validate time status filter
    Given Navigation to Reports tab
    Then Validate each value of dropdown of time filter

  @Reports @Time
  Scenario: validate export as excel option
    Given Navigation to Reports tab
    Then click on toolbar jobs
    And click on export as excel
    Then click on toolbar jobs
    And click on export as csv
    Then click on toolbar jobs
    And click on export as pdf

  @Reports @Time
  Scenario: validate pagination
    Given Navigation to Reports tab
    And clcik on each value of paginator
    Then click on next button
    Then click on previous button

  # Expenses
  @Reports @Expenses
  Scenario: Validate search functionality
    Given Navigation to Reports tab
    Then Navigate to expenses sub tab
    Then verify search functionality

  @Reports @Expenses
  Scenario: Validate hours dropdown
    Given Navigation to Reports tab
    Then Navigate to expenses sub tab
    Then Validate each value of billable dropdown

  @Reports @Expenses
  Scenario: Validate group by dropdown
    Given Navigation to Reports tab
    Then Navigate to expenses sub tab
    Then Validate each value of group by dropdown

  @Reports @Expenses
  Scenario: Validate filters button with save button
    Given Navigation to Reports tab
    Then Navigate to expenses sub tab
    Then click on filters button
    And select clients dropdown
    And select tasks dropdown
    And select users dropdown
    And select jobs dropdown
    Then click on save filter
    Then click on filters button
    And select clients dropdown
    And select tasks dropdown
    And select users dropdown
    And select expense dropdown
    Then click on clear filter
    Then click on show filter details
    And click on modifiy results
    And select clients dropdown
    And select tasks dropdown
    And select users dropdown
    And select expense dropdown
    Then click on save filter
    And click on clear all filter

  @Reports @Expenses
  Scenario: Validate time status filter
    Given Navigation to Reports tab
    Then Navigate to expenses sub tab
    Then Validate each value of dropdown of time filter

  @Reports @Expenses
  Scenario: validate export as excel option
    Given Navigation to Reports tab
    Then Navigate to expenses sub tab
    Then click on toolbar jobs
    And click on export as excel
    Then click on toolbar jobs
    And click on export as csv
    Then click on toolbar jobs
    And click on export as pdf

  @Reports @Expenses
  Scenario: validate pagination
    Given Navigation to Reports tab
    Then Navigate to expenses sub tab
    And clcik on each value of paginator
    Then click on next button
    Then click on previous button

  # Invoice
  @Reports @invoice
  Scenario: Validate search functionality
    Given Navigation to Reports tab
    Then Navigate to invoice sub tab in reports
    Then verify search functionality

  @Reports @invoice
  Scenario: Validate filters button with save button
    Given Navigation to Reports tab
    Then Navigate to invoice sub tab in reports
    Then click on filters button
    And select clients dropdown
    And select status dropdown
    Then click on save filter
    Then click on filters button
    And select clients dropdown
    And select status dropdown
    Then click on clear filter
    Then click on show filter details
    And click on modifiy results
    And select clients dropdown
    And select status dropdown
    Then click on save filter
    And click on clear all filter

  @Reports @invoice
  Scenario: Validate time status filter
    Given Navigation to Reports tab
    Then Navigate to invoice sub tab in reports
    Then Validate each value of dropdown of time filter

  @Reports @invoice
  Scenario: validate export as excel option
    Given Navigation to Reports tab
    Then Navigate to invoice sub tab in reports
    Then click on toolbar jobs
    And click on export as excel
    Then click on toolbar jobs
    And click on export as csv
    Then click on toolbar jobs
    And click on export as pdf

  @Reports @invoice
  Scenario: validate pagination
    Given Navigation to Reports tab
    Then Navigate to invoice sub tab in reports
    And clcik on each value of paginator
    Then click on next button
    Then click on previous button

  # users
  @Reports @users
  Scenario: Validate search functionality
    Given Navigation to Reports tab
    Then Navigate to users sub tab in reports
    Then verify search functionality

  @Reports @users
  Scenario: Validate contractor dropdown functionality
    Given Navigation to Reports tab
    Then Navigate to users sub tab in reports
    Then clicking on contractor dropdown

  @Reports @users
  Scenario: Validate time status filter
    Given Navigation to Reports tab
    Then Navigate to users sub tab in reports
    Then Validate each value of dropdown of time filter

  @Reports @users
  Scenario: validate export as excel option
    Given Navigation to Reports tab
    Then Navigate to users sub tab in reports
    Then click on toolbar jobs
    And click on export as excel
    Then click on toolbar jobs
    And click on export as csv
    Then click on toolbar jobs
    And click on export as pdf

  @Reports @users
  Scenario: validate pagination
    Given Navigation to Reports tab
    Then Navigate to users sub tab in reports
    And clcik on each value of paginator
    Then click on next button
    Then click on previous button
