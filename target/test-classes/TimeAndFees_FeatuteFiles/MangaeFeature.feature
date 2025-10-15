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

 
