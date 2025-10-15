Feature: TimeandFees settings tab

  Background: User login
    Given Launch the browser
    And User need to enter the Application Url
    When User Enter username and password
    Then User Click on login button
    And redirect to Time and Fees module

  @settings @mybusiness
  Scenario: Validate my business settings tab
    Given click on settings icon
    Then click on my business icon
    Then validate my business page
    And click on company
    Then fill all the details in company section
    And fill all the details of contact details
    And click on the save
    And Validate changes saved or not
    And click on the save and exit
    Then Validate changes saved or not
    And Validate changes saved and exit

  @settings @mybusiness
  Scenario: Validate filling details in fields in individual save
    Given click on settings icon
    Then click on my business icon
    And click on individual
    Then fill all the details in individual section
    And fill all the details of contact details
    And click on the save
    And Validate changes saved or not
    And click on the save and exit
    Then Validate changes saved or not
    And Validate changes saved and exit

  @settings @mybusiness
  Scenario: Validate filling details in fields in individual save and exit
    Given click on settings icon
    Then click on my business icon
    And click on individual
    Then fill all the details in individual section
    And fill all the details of contact details

  #demo data
  @settings @demodata
  Scenario: User clicks on the Demo Data button
    Given I am on the dashboard page
    When I click on the settings icon
    Then the settings menu should be displayed
    When I click on the Demo Data button
    Then the Demo Data section should be displayed

  @settings @demodata
  Scenario: User clicks on the Add Demo Data button and verify
    Given I am on the dashboard page
    When I click on the settings icon
    Then the settings menu should be displayed
    When I click on the Demo Data button
    Then the Demo Data section should be displayed
    Then click on the add demo data button
    Then click on the demo data yes button
    When I perform manage search flow

  # invoice 
  @settings @invoicesetting
  Scenario: User clicks on the Invoice and validating Auto genrating id
    Given I am on the dashboard page
    When I click on the settings icon
    Then the settings menu should be displayed
    Then click on the Invoice setting menu
    Then click on Autogenrate and save and exit
    Then click on the fees tab
    Then click on the on the invoice tab
    Then click on the add invoice and verify

  @settings @invoicesetting
  Scenario: User clicks on the Invoice and validating manually genrating id
    Given I am on the dashboard page
    When I click on the settings icon
    Then the settings menu should be displayed
    Then click on the Invoice setting menu
    Then click on add manually and save
    Then click on the fees tab
    Then click on the on the invoice tab
    Then click on the add invoice and verify

  @settings @invoicesetting 
  Scenario: User clicks on the Invoice and validating payment method
    Given I am on the dashboard page
    When I click on the settings icon
    Then the settings menu should be displayed
    Then click on the Invoice setting menu
    Then click on payment method and select random
    Then click on the fees tab
    Then click on the on the invoice tab
    Then Hover on record
    Then click on the edit icon in invoice
    Then click on the record payment button
    Then verify that in payment method is default or not and take screen short

  @settings @invoicesetting 
  Scenario: User clicks on the Invoice and validating payment Due
    Given I am on the dashboard page
    When I click on the settings icon
    Then the settings menu should be displayed
    Then click on the Invoice setting menu
    Then select random payment due term and save
    Then click on the fees tab
    Then click on the on the invoice tab
    Then Hover on record
    Then click on the edit icon in invoice
    Then verify the payment due term and take screenshot

  @settings @invoicesetting
  Scenario: User clicks on the Invoice and validating VAT
    Given I am on the dashboard page
    When I click on the settings icon
    Then the settings menu should be displayed
    Then click on the Invoice setting menu
    Then select VAT checkbox and save and exit
    Then click on the fees tab
    Then click on the on the invoice tab
    Then click on the add invoice and verify vat
    Then click on the tax dropdown and take screenshort

  @settings @invoicesetting
  Scenario: User clicks on the Invoice and validating footer
    Given I am on the dashboard page
    When I click on the settings icon
    Then the settings menu should be displayed
    Then click on the Invoice setting menu
    Then click on footer and add footer
    Then click on the fees tab
    Then click on the on the invoice tab
    Then click on the add invoice and verify footer should same and take screenshort

  @settings @invoicesetting 
  Scenario Outline: User toggles an Invoice Details grid option and verifies in invoice grid
    Given I am on the dashboard page
    When I click on the settings icon
    Then the settings menu should be displayed
    Then click on the Invoice setting menu
    Then toggle details grid option "<GridOption>"
    Then click on the fees tab
    Then click on the on the invoice tab
    Then click on the add invoice and verify "<GridOption>" option in invoice grid and take screenshot

    Examples: 
      | GridOption |
      | type       |
      | jobid      |
      | hourqty    |

  @settings @invoicesetting @rename
  Scenario Outline: User renames an Invoice Details grid column and verifies in invoice grid
    Given I am on the dashboard page
    When I click on the settings icon
    Then the settings menu should be displayed
    Then click on the Invoice setting menu
    Then rename grid column "<GridOption>" to "<NewName>"
    Then click on the fees tab
    Then click on the on the invoice tab
    Then click on the add invoice and verify "<GridOption>" column is renamed to "<NewName>" and take screenshot

    Examples: 
      | GridOption  | NewName    |
      | type        | TestType   |
      | jobid       | TestJobId  |
      | description | TestDesc   |
      | hourqty     | TestHours  |
      | pricegbp    | TestPrice  |
      | amount      | TestAmount |

  #estimate
  @settings @Estimate
  Scenario: Validate autogenrate estimate page
    Given click on settings icon
    Then click on my estimate icon
    Then validate estimate page
    Then click on autogenrate radio button
    And fill the data in footer
    And click on the save and exit
    And Validate changes saved and exit
    And Navigation to Fees tab
    Then Navigate to estimates sub tab
    And click on add estimates button
    Then validate estimate id disable
    And vaslidate footer text

  @settings @Estimate
  Scenario: Validate add manualy readio button
    Given click on settings icon
    Then click on my estimate icon
    Then click on Add manually radio button
    And fill the data in footer
    And click on the save and exit
    Then Validate changes saved and exit
    And Navigation to Fees tab
    Then Navigate to estimates sub tab
    And click on add estimates button
    Then validate estimate id enable

  #templates
  @settings @Templates
  Scenario: Validate all templates are visible
    Given click on settings icon
    Then click on templates icon
    Then validate templates page

  @settings @Templates
  Scenario: Validate text in subject and message field in every expansion panel
    Given click on settings icon
    Then click on templates icon
    Then expend all the panels
    And Enter text in all the subject and message field
    Then click on save
    And Validate all the text are there or not

  @settings @Templates
  Scenario: Validate Cancel Changes and save and exit button
    Given click on settings icon
    Then click on templates icon
    Then expend all the panels
    And Enter text in all the subject and message field cancel changes
    Then click on cancel changes
    And Validate text not added
    And Enter text in all the subject and message field
    Then click on the save and exit
    And Validate changes saved and exit

  #Intigrates
  @settings @Intigrations
  Scenario: Validate Intigration page
    Given click on settings icon
    Then click on intigrations button
    And validate intigrations page
    And click on capium time and fee method
    Then vlidate capium method checked

  @settings @Intigrations
  Scenario: Validate gmail/outlook radio button
    Given click on settings icon
    Then click on intigrations button
    And click on gmail method
    Then vlidate gmail method checked

  @settings @Intigrations
  Scenario: Validate save and exit and cancel changes button
    Given click on settings icon
    Then click on intigrations button
    Then validate cancel changes on alternative method
    Then click on alternative method
    Then click on the save and exit
    And Validate changes saved and exit
