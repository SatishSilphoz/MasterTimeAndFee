Feature: Expenses

 Background: User login
    Given Launch the browser
    And User need to enter the Application Url
    When User Enter username and password
    Then User Click on login button
    And redirect to Time and Fees module

@Expense @Rerun
Scenario: click on ADD expense tab
	Given Click on Expenses tab
	Then Click on the Add Expense Button
	Then fill the form and click on the save 
	Given Click on Expenses tab
  Then Click on the search
	Then search the value and it should show in grid
	
@Expense 
Scenario: validating date filter
    Given Click on Expenses tab
    Then Validate the date filter dropdown by selecting each option
	
@Expense 	
Scenario: validating status filter
    Given Click on Expenses tab
		 When I select all status options one by one from the dropdown	
		 
@Expense 		 
Scenario: Validate selecting each expense type one by one from the dropdown
    Given Click on Expenses tab
    When I select each expense type option one by one from the dropdown
    Then I should see that each expense type option is selectable
		 
		 
@Expense 		 
Scenario: Validate selecting each user option from the user dropdown
    Given Click on Expenses tab
    When I select each user option one by one from the user dropdown
    Then I should see that each user option is selectable
		 
@Expense
Scenario: validate Delete in Expense
    Then Click on Expenses tab
    Then Hover on record Expense
    Then click on the Edit icon Expense
    Then user edits the unit price to "10" and saves
		Given Click on Expenses tab
		Then Hover on record Expense
    Then click on the Delete icon Expense
		Then clck on the Yes button Expense
		Then Hover on record Expense
    Then click on the renubder icon Expense
		Then clck on the Yes button Expense
		Then Hover on record Expense
    Then click on the Submit icon Expense
		Then clck on the Yes button Expense	 
		 
@Expense
  Scenario: validate export as excel option
    Given Click on Expenses tab
    Then click on toolbar jobs
    And click on export as excel
    Then click on toolbar jobs
    And click on export as csv
    Then click on toolbar jobs
    And click on export as pdf
    
  @Expense
  Scenario: validate checkbox of grid
    Given Click on Expenses tab
    Then click on checkbox of grid
    And click on delete button on checkbox
    Then click on checkbox of grid
    And click on export as excel
    Then click on checkbox of grid
    And click on export as csv
    Then click on checkbox of grid
    And click on export as pdf
    Then click on checkbox of grid
		
				 
		 
		 
		 