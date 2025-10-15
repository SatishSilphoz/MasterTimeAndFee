Feature: TimeandFees Fees tab

  Background: User login
    Given Launch the browser
    And User need to enter the Application Url
    When User Enter username and password
    Then User Click on login button
    And redirect to Time and Fees module

  @Fees @Dashboard
  Scenario: Validate time status filter
    Given Navigation to Fees tab
    Then Validate each value of dropdown of time filter

  @Fees @invoice
  Scenario: Validate create invoice
    Given Navigation to Fees tab
    Then Navigate to invoice sub tab
    And click on add invoice button
    Then fill all the data in invoice
    And click on the save
    And click on the save and exit
    And verify search functionality
    Then Navigate to invoice sub tab
    And click on add invoice button
    Then fill all the data in invoice
    And click on cancel changes
    Then validate all invoice fiieds shuoul clear

  @Fees @invoice @Rerun1
  Scenario: Validate edit invoice
    Given Navigation to Fees tab
    Then Navigate to invoice sub tab
    And click on id hyperlink
    Then fill all the data in invoice
    And click on the save
    Then click on plus icon of dicount
    And click on discount button
    And add the name of discount
    Then select pound from dropdown
    And add the dicount amount
    And click on the save
    Then validate dicount currency display
    Then select percentage from dropdown
    And add the dicount amount
    And click on the save
    Then validate dicount percentage display
    Then click on plus icon of dicount
    And click on add cost button
    And add the name of additional cost
    Then select pound from dropdown
    And add the cost amount
    And click on the save
    Then validate additional cost currency display
    Then select percentage from dropdown
    And add the cost amount
    And click on the save
    Then validate additional cost percentage display
    And click on side bar icon
    Then click on add Job button
    And fill all the data in invoice
    Then click on save
    And click on side bar icon
    Then click on search icon
    Then verify search functionality

  @Fees @invoice @Rerun
  Scenario: Validate preview button in edit invoice
    Given Navigation to Fees tab
    Then Navigate to invoice sub tab
    And click on id hyperlink
    Then click on preview button
    And click on send
    Then click on send
    Then click on record payment action
    And click on the save
    Then Navigate to invoice sub tab
    Then Hover on record
    And click on delete icon
    And click on id hyperlink
    And click on send reminder button

  @Fees @invoice
  Scenario: Validate status filter functionality
    Given Navigation to Fees tab
    Then Navigate to invoice sub tab
    And validate each value of status filter

  @Fees @invoice
  Scenario: validate export as excel option
    Given Navigation to Fees tab
    Then Navigate to invoice sub tab
    Then click on toolbar jobs
    And click on export as excel
    Then click on toolbar jobs
    And click on export as csv
    Then click on toolbar jobs
    And click on export as pdf

  @Fees @invoice @Rerun
  Scenario: validate button on grid
    Given Navigation to Fees tab
    Then Navigate to invoice sub tab
    Then Hover on record
    Then click on preview icon
    And Validate preview screen
    And click on send
    Then Hover on record
    And click on edit icon
    And Validate edit page
    Then click on cross icon
    Then Hover on record
    And click on delete icon
    And Validate record delete
    Then Hover on record
    And click on more action
    And click on duplicate action
    Then Hover on record
    And click on more action
    And click on export action
    Then Hover on record
    And click on more action
    And click on copy link action
    Then Hover on record
    And click on more action
    And click on record payment action
    Then click on the save

  @Fees @invoice 
  Scenario: validate checkbox of grid
    Given Navigation to Fees tab
    Then Navigate to invoice sub tab
    Then click on checkbox of grid
    And click on copy button in checkbox
    Then click on checkbox of grid
    And click on delete button on checkbox
    Then click on checkbox of grid
    And click on export as excel
    Then click on checkbox of grid
    And click on export as csv
    Then click on checkbox of grid
    And click on export as pdf
    Then click on checkbox of grid

  @Fees @invoice
  Scenario: validate pagination
    Given Navigation to Fees tab
    Then Navigate to invoice sub tab
    And clcik on each value of paginator
    Then click on next button
    Then click on previous button

  #// recurring
  @Fees @recuringinvoice 
  Scenario: Validate create recurring invoice
    Given Navigation to Fees tab
    Then Navigate to recurring invoice sub tab
    And click on add recurring invoice button
    Then fill all the data in invoice
    And click on the save
    And add recurring details
    And click on the save
    And click on the save and exit
    Then Navigate to recurring invoice sub tab
    And verify search functionality

  @Fees @recuringinvoice
  Scenario: Validate edit recurring invoice
    Given Navigation to Fees tab
    Then Navigate to recurring invoice sub tab
    And click on id hyperlink
    Then fill all the data in invoice
    And click on the save
    Then click on the save and exit
 
  @Fees @recuringinvoice 
  Scenario: Validate button in edit invoice
    Given Navigation to Fees tab
    Then Navigate to recurring invoice sub tab
    And click on id hyperlink
    Then click on preview button
    And click on send
    Then click on send
    Then click on record payment action
    And click on the save
    Then Navigate to recurring invoice sub tab
    Then Hover on record
    And click on delete icon
    And click on id hyperlink
    And click on send reminder button

  @Fees @recuringinvoice
  Scenario: Validate status filter functionality
    Given Navigation to Fees tab
    Then Navigate to recurring invoice sub tab
    And validate each value of status filter

  @Fees @recuringinvoice
  Scenario: validate export as excel option
    Given Navigation to Fees tab
    Then Navigate to recurring invoice sub tab
    Then click on toolbar jobs
    And click on export as excel
    Then click on toolbar jobs
    And click on export as csv
    Then click on toolbar jobs
    And click on export as pdf

  @Fees @recuringinvoice
  Scenario: validate edit button on grid
    Given Navigation to Fees tab
    Then Navigate to recurring invoice sub tab
    Then Hover on record
    And click on edit icon
    And Validate edit page
    Then click on cross icon
    Then Navigate to recurring invoice sub tab
    Then Hover on record
    Then click on end icon
    Then Hover on record
    And click on delete icon
    And Validate record delete
    Then Hover on record
    And click on more action
    And click on pause action
    Then Hover on record
    And click on play action

  @Fees @recuringinvoice
  Scenario: validate pagination
    Given Navigation to Fees tab
    Then Navigate to recurring invoice sub tab
    And clcik on each value of paginator
    Then click on next button
    Then click on previous button

  @Fees @recuringinvoice 
  Scenario: validate checkbox  of grid
    Given Navigation to Fees tab
    Then Navigate to recurring invoice sub tab
    Then click on checkbox of grid
    And click on delete button on checkbox
    Then click on checkbox of grid
    And click on export as excel
    #Then click on checkbox of grid
    And click on export as csv
   # Then click on checkbox of grid
    And click on export as pdf

  #estimates
  @Fees @estimates 
  Scenario: Validate create estimates
    Given Navigation to Fees tab
    Then Navigate to estimates sub tab
    And click on add estimates button
    Then fill all the data in estimates
    And click on the save
    And click on the save and exit
    And verify search functionality
    Then Navigate to estimates sub tab
    And click on add estimates button
    Then fill all the data in estimates
    And click on cancel changes
    Then validate all estimate fiieds shuoul clear

  @Fees @estimates 
  Scenario: Validate edit estimates
    Given Navigation to Fees tab
    Then Navigate to estimates sub tab
    And click on id hyperlink
    Then fill all the data in estimates
    Then click on plus icon of dicount
    And click on discount button
    And add the name of discount
    Then select pound from dropdown
    And add the dicount amount
    And click on the save
    Then validate dicount currency display
    Then select percentage from dropdown
    And add the dicount amount
    And click on the save
    Then validate dicount percentage display
    Then click on plus icon of dicount
    And click on add cost button
    And add the name of additional cost
    Then select pound from dropdown
    And add the cost amount
    And click on the save
    Then validate additional cost currency display
    Then select percentage from dropdown
    And add the cost amount
    And click on the save
    Then validate additional cost percentage display
    And click on the save
    And click on side bar icon
    Then click on add Job button
    And fill all the data in estimates
    Then click on save
    And click on edit icon
    And click on side bar icon
    Then click on search icon
    Then verify search functionality

  @Fees @estimates
  Scenario: Validate  button in edit estimate
    Given Navigation to Fees tab
    Then Navigate to estimates sub tab
    And click on id hyperlink
    Then click on accepted button
    Then click on declined button
    Then click on draft button
    Then click on send
    Then click on add note button and send keys
    And click on the save

  @Fees @estimates
  Scenario: Validate status filter functionality
    Given Navigation to Fees tab
    Then Navigate to estimates sub tab
    And validate each value of status filter

  @Fees @estimates
  Scenario: validate export as excel option
    Given Navigation to Fees tab
    Then Navigate to estimates sub tab
    Then click on toolbar jobs
    And click on export as excel
    Then click on toolbar jobs
    And click on export as csv
    Then click on toolbar jobs
    And click on export as pdf

  @Fees @estimates
  Scenario: validate button on grid
    Given Navigation to Fees tab
    Then Navigate to estimates sub tab
    Then Hover on record
    Then click on preview icon
    And Validate preview screen
    Then click on cross icon
    Then Hover on record
    And click on edit icon
    And Validate edit page
    Then click on cross icon
    Then Hover on record
    And click on delete icon
    And Validate record delete
    Then Hover on record
    And click on more action
    And click on mark as sent
    Then Hover on record
    And click on more action
    And click on mark as declined
    Then Hover on record
    And click on more action
    And click on mark as accepted
    Then Hover on record
    And click on more action
    And click on copy
    Then Hover on record
    And click on more action
    And click on export action
    Then Hover on record
    And click on more action
    And click on copy link action

  @Fees @estimates
  Scenario: validate checkbox  of grid
    Given Navigation to Fees tab
    Then Navigate to estimates sub tab
    Then click on checkbox of grid
    And click on copy button in checkbox
    Then click on checkbox of grid
    And click on delete button on checkbox
    Then click on checkbox of grid
    And click on export as excel
    Then click on checkbox of grid
    And click on export as csv
    Then click on checkbox of grid
    And click on export as pdf
    Then click on checkbox of grid
    And click on mark as sent on checkbox
    And validate with custome message
    Then click on checkbox of grid
    And click on mark as declined on checkbox
    And validate with custome message
    Then click on checkbox of grid
    And click on mark as accepted on checkbox
    And validate with custome message
    Then click on checkbox of grid
    And click on revart status on checkbox
    And validate with custome message

  @Fees @estimates
  Scenario: validate pagination
    Given Navigation to Fees tab
    Then Navigate to estimates sub tab
    And clcik on each value of paginator
    Then click on next button
    Then click on previous button
