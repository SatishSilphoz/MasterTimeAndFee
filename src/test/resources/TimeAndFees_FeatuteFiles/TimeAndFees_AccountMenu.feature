Feature: TimeandFees Account menu section

  Background: User login
    Given Launch the browser
    And User need to enter the Application Url
    When User Enter username and password
    Then User Click on login button
    And redirect to Time and Fees module

  @AccountMenu @QuickAdd 
  Scenario: Creation of expense and verify
    Given click on quick add button
    Then click on add expense in quick add
    Given click on quick add button
    Then click on add invoice in quick add
    Given click on quick add button
    Then click on add estimate in quick add
    Given click on quick add button
    Then click on add task in quick add
    Given click on quick add button
    Then click on add expense type in quick add
    Given click on quick add button
    Then click on add time log in quick add
    Given click on quick add button
    Then click on add recurring in quick add
    Given click on quick add button
    Then click on add clients in quick add
    Given click on quick add button
    Then click on add users in quick add

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

  @AccountMenu @Activity
  Scenario: validating time period dropdown functionality in activity page
    Given click on history button
    Then click on view all activity text
    And Validate each value of dropdown of time filter in activity page

  #Annoucment
  @AccountMenu @Announcment 
  Scenario: validating Announcment page
    Given click on Announcment button
    And Validate Announcment page

  #Tickets
  @AccountMenu @Tickets 
  Scenario: creation of ticket
    Given click on ticket button
    And click on add ticket button
    Then fill all the details in add ticket
    And click on submit button
    Then validate search functionality in tickets

  @AccountMenu @Tickets
  Scenario: validate status dropdown funtionality
    Given click on ticket button
    And validate status dropdown in tickets

  #profile
  @AccountMenu @profile
  Scenario: validate change colors
    Given click on profile logo
    And validate Purple color option
    Given click on profile logo
    And validate Periwinkle color option
    Given click on profile logo
    And validate Royal Blue color option
    Given click on profile logo
    And validate Crimson color option
    Given click on profile logo
    And validate Teal color option
    Given click on profile logo
    And validate Blue color option
    Given click on profile logo
    And validate Mustard  color option
    Given click on profile logo
    And validate Black color option
