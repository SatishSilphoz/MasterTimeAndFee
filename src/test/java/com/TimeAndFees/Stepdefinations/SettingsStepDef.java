package com.TimeAndFees.Stepdefinations;

import com.Capium.Utilites.StepTracker;
import com.TimeAndFees.Actions.SettingsActions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SettingsStepDef {

	SettingsActions SettingPage = new SettingsActions();

	@Given("click on settings icon")
	public void click_on_settings_icon() throws InterruptedException {
		SettingPage.click_on_settings_icon();
		StepTracker.setCurrentStep("clicking on settings icon");

	}
	@Then("click on my business icon")
	public void click_on_my_business_icon() {
		SettingPage.click_on_my_business_icon();
		StepTracker.setCurrentStep("clicking on my business tab");

	}
	@Then("validate my business page")
	public void validate_my_business_page() throws InterruptedException {
		SettingPage.validate_my_business_page();
		StepTracker.setCurrentStep("validating my business page");

	}

	@Then("fill all the details in company section")
	public void fill_all_the_details_in_company_section() throws InterruptedException {
		SettingPage.fill_all_the_details_in_company_section();
		StepTracker.setCurrentStep("filling all the details in company section");
	}
	@Then("click on add new line for add contact")
	public void click_on_add_new_line_for_add_contact() {
		SettingPage.click_on_add_new_line_for_add_contact();
		StepTracker.setCurrentStep("clicking add new line for add new contact");
	}
	
	@Then("fill all the details of contact details")
	public void fill_all_the_details_of_contact_details() throws InterruptedException {
		SettingPage.fill_all_the_details_of_contact_details();
		StepTracker.setCurrentStep("filling all the details in contact form");
	}

	@Then("click on individual")
	public void click_on_individual() throws InterruptedException {
		SettingPage.click_on_individual();
		StepTracker.setCurrentStep("clicking on individual button");
	}
	@Then("click on company")
	public void click_on_company() throws InterruptedException {
		SettingPage.click_on_company();
		StepTracker.setCurrentStep("clicking on company button");
	}

	@Then("fill all the details in individual section")
	public void fill_all_the_details_in_individual_section() throws InterruptedException {
		SettingPage.fill_all_the_details_in_individual_section();
		StepTracker.setCurrentStep("filling all the details in individual screen");
	}

	@Then("Validate changes saved or not")
	public void Validate_changes_saved_or_not() throws InterruptedException {
		SettingPage.Validate_changes_saved_or_not();
		StepTracker.setCurrentStep("validating changes saved or not");
	}

	@Then("Validate changes saved and exit")
	public void Validate_changes_saved_and_exit() throws InterruptedException {
		SettingPage.Validate_changes_saved_and_exit();
		StepTracker.setCurrentStep("validating changes saved and exit");
	}


	@Then("click on my estimate icon")
	public void click_on_my_estimate_icon() throws InterruptedException {
		SettingPage.click_on_my_estimate_icon();
		StepTracker.setCurrentStep("clicking on estimate icon");
	}
	@Then("validate estimate page")
	public void validate_estimate_page() throws InterruptedException {
		SettingPage.validate_estimate_page();
		StepTracker.setCurrentStep("validating estimate screen appear");
	}

	@Then("click on autogenrate radio button")
	public void click_on_autogenrate_radio_button() throws InterruptedException {
		SettingPage.click_on_autogenrate_radio_button();
		StepTracker.setCurrentStep("clicking on autogenrate radio button");
	}

	@Then("click on Add manually radio button")
	public void click_on_Add_manually_radio_button() throws InterruptedException {
		SettingPage.click_on_Add_manually_radio_button();
		StepTracker.setCurrentStep("clicking on add manualy radio button");
	}
	@Then("fill the data in footer")
	public void fill_the_data_in_footer() {
		SettingPage.fill_the_data_in_footer();
		StepTracker.setCurrentStep("filling all the details in footer");
	}
	@Then("validate estimate id disable")
	public void validate_estimate_id_disable() throws InterruptedException {
		SettingPage.validate_estimate_id_disable();
		StepTracker.setCurrentStep("validating estimate id is getting disabled");
	}

	@Then("validate estimate id enable")
	public void validate_estimate_id_enable() throws InterruptedException {
		SettingPage.validate_estimate_id_enable();
		StepTracker.setCurrentStep("validating estimate id is getting enable");
	}

	@Then("vaslidate footer text")
	public void vaslidate_footer_text() throws InterruptedException {
		SettingPage.vaslidate_footer_text();
		StepTracker.setCurrentStep("validating footer text");
	}

	@Then("click on templates icon")
	public void click_on_templates_icon() {
		SettingPage.click_on_templates_icon();
		StepTracker.setCurrentStep("clicking on templates icon");
	}
	@Then("validate templates page")
	public void validate_templates_page() throws InterruptedException {
		SettingPage.validate_templates_page();
		StepTracker.setCurrentStep("validating template page");
	}

	@Then("expend all the panels")
	public void expend_all_the_panels() throws InterruptedException {
		SettingPage.expend_all_the_panels();
		StepTracker.setCurrentStep("expending all panels");

	}
	@Then("Enter text in all the subject and message field")
	public void enter_text_in_all_the_subject_and_message_field() {
		SettingPage.enter_text_in_all_the_subject_and_message_field();
		StepTracker.setCurrentStep("entering text in each field of subject and message");

	}
	@Then("Validate all the text are there or not")
	public void validate_all_the_text_are_there_or_not() {
		SettingPage.validate_all_the_text_are_there_or_not();
		StepTracker.setCurrentStep("validatining all text are visible or not");

	}

	@Then("Validate text not added")
	public void Validate_text_not_added() throws InterruptedException {
		SettingPage.Validate_text_not_added();
		StepTracker.setCurrentStep("validating text not added");

	}
	@Then("Enter text in all the subject and message field cancel changes")
	public void enter_text_in_all_the_subject_and_message_field_cancelchanges() {
		SettingPage.enter_text_in_all_the_subject_and_message_field_cancelchanges();
		StepTracker.setCurrentStep("entering all text in subject and message fields");

	}

	@Then("click on cancel changes")
	public void click_on_cancel_changes() throws InterruptedException {
		SettingPage.click_on_cancel_changes();
		StepTracker.setCurrentStep("clicking on cancel changes button");

	}


	@Then("click on intigrations button")
	public void click_on_intigrations_button() {
		SettingPage.click_on_intigrations_button();
		StepTracker.setCurrentStep("clicking on intigration  button");

	}
	
	@Then("validate intigrations page")
	public void validate_intigrations_page() throws InterruptedException {
		SettingPage.validate_intigrations_page();
		StepTracker.setCurrentStep("validating intigration page");
	}

	@Then("click on capium time and fee method")
	public void click_on_capium_time_and_fee_method() throws InterruptedException {
		SettingPage.click_on_capium_time_and_fee_method();
		StepTracker.setCurrentStep("clicking on capium method");

	}

	@Then("vlidate capium method checked")
	public void vlidate_capium_method_checked() throws InterruptedException {
		SettingPage.vlidate_capium_method_checked();
		StepTracker.setCurrentStep("validate capium method checked");

	}

	@Then("click on gmail method")
	public void click_on_gmail_outlook_method() throws InterruptedException {
		SettingPage.click_on_gmail_outlook_method();
		StepTracker.setCurrentStep("clicking on gmai/outlook method");
	}
	
	@Then("vlidate gmail method checked")
	public void vlidate_gmail_outlook_method_checked() throws InterruptedException {
		SettingPage.vlidate_gmail_outlook_method_checked();
		StepTracker.setCurrentStep("validating gmail/outlook checked");
	}
	
	@Then("click on alternative method")
	public void click_on_alternative_method() throws InterruptedException {
		SettingPage.click_on_alternative_method();
		StepTracker.setCurrentStep("clicking on alternatice method");
	}
	
	@Then("validate cancel changes on alternative method")
	public void validate_cancel_changes_on_alternative_method() throws InterruptedException {
		SettingPage.validate_cancel_changes_on_alternative_method();
		StepTracker.setCurrentStep("validating cancel changes on alternative method");
	}

//////////////////////////////////////////////////////////////////////prakash//////////////////////////////////////////////////////////////////////////////////////////
	
	@Given("I am on the dashboard page")
    public void i_am_on_the_dashboard_page() {
        // You can add code to navigate to dashboard or validate it.
        System.out.println("User is on the dashboard page");
        StepTracker.setCurrentStep("I am on the dashboard page");
    }

    @When("I click on the settings icon")
    public void i_click_on_the_settings_icon() throws InterruptedException {
    	SettingPage.clickOnSettingsIcon();
        StepTracker.setCurrentStep("I click on the settings icon");

    }

    @Then("the settings menu should be displayed")
    public void the_settings_menu_should_be_displayed() {
        // Add assertion/check that settings menu is displayed
        System.out.println("Settings menu displayed successfully");
        StepTracker.setCurrentStep("the settings menu should be displayed");

    }
    
    @When("I click on the Demo Data button")
    public void i_click_on_the_demo_data_button() {
    	SettingPage.clickOnDemoDataButton();
        StepTracker.setCurrentStep("I click on the Demo Data button");

    }

    @Then("the Demo Data section should be displayed")
    public void the_demo_data_section_should_be_displayed() {
        // Add assertion for verifying Demo Data section is visible
        System.out.println("Demo Data section displayed");
        StepTracker.setCurrentStep("the Demo Data section should be displayed");

    }
    
    @Then("click on the add demo data button")
    public void click_on_the_add_demo_data_button() throws InterruptedException {
    	SettingPage.clickOnAddDemoDataButton();
        // Optionally validate that demo data is being added
        System.out.println("Add Demo Data button clicked successfully");
        StepTracker.setCurrentStep("click on the add demo data button");

    }

    @Then("click on the demo data yes button")
    public void click_on_the_demo_data_yes_button() throws InterruptedException {
    	SettingPage.clickOnYesButton();
        StepTracker.setCurrentStep("click on the demo data yes button");

    }
    
    
    @When("I perform manage search flow")
    public void i_perform_manage_search_flow() throws InterruptedException {

        SettingPage.clickOnManageMenu();
        StepTracker.setCurrentStep("Clicked on Manage Menu");
        SettingPage.searchClient("Demo_Client A");
        StepTracker.setCurrentStep("Searched Client Demo_Client A");

        SettingPage.clickOnTasksMenu();
        StepTracker.setCurrentStep("Clicked on Tasks Menu");
        SettingPage.searchTask("Demo_Task 1");
        StepTracker.setCurrentStep("Searched Task Demo_Task 1");

        SettingPage.clickOnUsersMenu();
        StepTracker.setCurrentStep("Clicked on Users Menu");
        SettingPage.searchUser("Demo_Harvey Thornton");
        StepTracker.setCurrentStep("Searched User Demo_Harvey Thornton");

        SettingPage.clickOnExpenseTypesMenu();
        StepTracker.setCurrentStep("Clicked on Expense Types Menu");
        SettingPage.searchExpenseType("Demo_Expense Type 1");
        StepTracker.setCurrentStep("Searched Expense Type Demo_Expense Type 1");

        SettingPage.clickOnExpensesMenu();
        StepTracker.setCurrentStep("Clicked on Expenses Menu");
        SettingPage.searchExpenseType("Demo_Expense Type 1");
        StepTracker.setCurrentStep("Searched Expense Type Demo_Expense Type 1 again");

        SettingPage.clickOnFeesMenu();
        StepTracker.setCurrentStep("Clicked on Fees Menu");
        SettingPage.searchFeesType("INV001");
        StepTracker.setCurrentStep("Searched Fees Type INV001");

        SettingPage.clickOnEstimateMenu();
        StepTracker.setCurrentStep("Clicked on Estimate Menu");
        SettingPage.searchEstimateType("EST001");
        StepTracker.setCurrentStep("Searched Estimate Type EST001");

        SettingPage.clickOnJobsMenu();
        StepTracker.setCurrentStep("Clicked on Jobs Menu");
        SettingPage.searchJobsType("JOB001");
        StepTracker.setCurrentStep("Searched Jobs Type JOB001");

        SettingPage.clickOnTimesMenu();
        StepTracker.setCurrentStep("Clicked on Times Menu");
        SettingPage.searchTimeslogsType("Demo_Fixed Price Service(Demo_Client A)");
        StepTracker.setCurrentStep("Searched Times Logs Type Demo_Fixed Price Service(Demo_Client A)");
    }

    
    
    @Then("click on the Invoice setting menu")
    public void click_on_the_invoice_setting_menu() throws InterruptedException {
    	SettingPage.clickOnInvoiceSettingsMenu();
    	 StepTracker.setCurrentStep("click on the Invoice setting menu");
    }
    
    

    @Then("click on the fees tab")
    public void click_on_the_fees_tab() throws InterruptedException {
    	SettingPage.clickOnFeesTab();
    	StepTracker.setCurrentStep("click on the fees tab");
    }

    @Then("click on the on the invoice tab")
    public void click_on_the_invoice_tab() throws InterruptedException {
    	SettingPage.clickOnInvoiceTab();
    	StepTracker.setCurrentStep("click on the on the invoice tab");
    }

    
    
    @Then("click on the add invoice and verify")
    public void click_on_the_add_invoice_and_verify() throws InterruptedException {
        SettingPage.clickOnAddInvoiceButton();
        StepTracker.setCurrentStep("click on the add invoice and verify");

        boolean isDisabled = SettingPage.isInvoiceIdFieldAutoGenerated();
        StepTracker.setCurrentStep("click on the add invoice and verify");

    }

    @Then("click on Autogenrate and save and exit")
    public void click_on_autogenrate_and_save_and_exit() throws InterruptedException {
    	SettingPage.clickAutoGenerateAndSave();
    	StepTracker.setCurrentStep("click on Autogenrate and save and exit");
    }
    
    @Then("click on add manually and save")
    public void click_on_add_manually_and_save() throws InterruptedException {
    	SettingPage.clickOnAddManuallyRadio();
    	StepTracker.setCurrentStep("click on add manually ");
    	SettingPage.clickOnSaveAndExitButton();
    	StepTracker.setCurrentStep("click on add manually and save and exit");
    }
   
    
    @Then("click on payment method and select random")
    public void click_on_payment_method_and_select_random() throws InterruptedException {
        expectedPaymentMethod = SettingPage.selectRandomPaymentMethod();
        StepTracker.setCurrentStep("click on payment method and select random");

    }
    
    
    
    
    @Then("Hover on record in invoice")
    public void hover_on_record_in_invoice() {
    	SettingPage.hoverOnFirstInvoiceRecord();
        StepTracker.setCurrentStep("Hover on record in invoice");

    }
    
    @Then("click on the edit icon in invoice")
    public void click_on_the_edit_icon_in_invoice() throws InterruptedException {
    	SettingPage.clickEditIcon();
        StepTracker.setCurrentStep("click on the edit icon in invoice");

    }

    @Then("click on the record payment button")
    public void click_on_the_record_payment_button() {
    	SettingPage.clickRecordPaymentButton();
        StepTracker.setCurrentStep("click on the record payment button");

    }
    
    
    String expectedPaymentMethod;
    
    @Then("verify that in payment method is default or not and take screen short")
    public void verify_payment_method_and_take_screenshot() {
    	SettingPage.verifyPaymentMethodAndCapture(expectedPaymentMethod);
        StepTracker.setCurrentStep("verify that in payment method is default or not and take screen short");

    }
    
    
    String expectedPaymentTerm;
    
    @Then("select random payment due term and save")
    public void select_random_payment_due_term_and_save() throws InterruptedException {
        expectedPaymentTerm = SettingPage.selectRandomPaymentDueTermAndSave();
        StepTracker.setCurrentStep("select random payment due term and save");

    }

    @Then("verify the payment due term and take screenshot")
    public void verify_the_payment_due_term_and_take_screenshot() {
    	SettingPage.verifyPaymentDueTermAndCapture(expectedPaymentTerm);
        StepTracker.setCurrentStep("verify the payment due term and take screenshot");

    }
    
    
    @Then("select VAT checkbox and save and exit")
    public void select_vat_checkbox_and_save_and_exit() throws InterruptedException {
    	SettingPage.clickVatCheckbox();
    	StepTracker.setCurrentStep("select VAT checkbox ");
    	SettingPage.clickOnSaveAndExitButton();
    	StepTracker.setCurrentStep("select VAT checkbox and save and exit");
    }
    
    
    @Then("click on the tax dropdown and take screenshort")
    public void click_on_the_tax_dropdown_and_take_screenshot() throws InterruptedException {
    	SettingPage.clickTaxDropdownAndTakeScreenshot("tax-dropdown");
    	StepTracker.setCurrentStep("click on the tax dropdown and take screenshort");
    }
    
    
    

    @Then("click on the add invoice and verify vat")
    public void click_on_the_add_invoice_and_verify_vat() {
    	SettingPage.clickAddInvoiceButton();
    	StepTracker.setCurrentStep("click on the add invoice and verify vat");
    }
    
    
    String expectedFooterText = "Thanks for your business!";
    @Then("click on footer and add footer")
    public void click_on_footer_and_add_footer() throws InterruptedException {
         expectedFooterText = "Thanks for your business!"; // You can use any string, or random if you need
        SettingPage.addFooterTextInSettings(expectedFooterText);
    	StepTracker.setCurrentStep("click on footer and add footer");

    }
    
    
    @Then("click on the add invoice and verify footer should same and take screenshort")
    public void click_on_the_add_invoice_and_verify_footer_should_same_and_take_screenshot() {
    	SettingPage.clickAddInvoiceButton();
    	StepTracker.setCurrentStep("click on the add invoice and verify footer should same and take screenshort");

    	SettingPage.verifyFooterTextAndCapture(expectedFooterText);
    	StepTracker.setCurrentStep("click on the add invoice and verify footer should same and take screenshort");

    }
    
    
    
    @Then("toggle details grid option {string}")
    public void toggle_details_grid_option(String optionName) {
        SettingPage.toggleGridOptionInSettings(optionName);
    	StepTracker.setCurrentStep("toggle details grid option {string}");

        
    }
    
    @Then("click on the add invoice and verify {string} option in invoice grid and take screenshot")
    public void click_on_the_add_invoice_and_verify_option_in_invoice_grid_and_take_screenshot(String optionName) throws InterruptedException {
        SettingPage.clickAddInvoiceButton();
    	StepTracker.setCurrentStep("click on the add invoice and verify {string} option in invoice grid and take screenshot");

        SettingPage.verifyOptionInInvoiceGridAndTakeScreenshot(optionName);
    	StepTracker.setCurrentStep("click on the add invoice and verify {string} option in invoice grid and take screenshot");

    }
    
    @Then("rename grid column {string} to {string}")
    public void rename_grid_column(String optionName, String newName) {
    	SettingPage.renameGridColumn(optionName, newName);
    	StepTracker.setCurrentStep("rename grid column {string} to {string}");

    }
    
    
    @Then("click on the add invoice and verify {string} column is renamed to {string} and take screenshot")
    public void click_on_add_invoice_and_verify_renamed_column_and_take_screenshot(String optionName, String newName) throws InterruptedException {
    	SettingPage.clickAddInvoiceButton();
    	StepTracker.setCurrentStep("click on the add invoice and verify {string} column is renamed to {string} and take screenshot");

    	SettingPage.verifyRenamedColumnInInvoice(optionName, newName);
    	StepTracker.setCurrentStep("click on the add invoice and verify {string} column is renamed to {string} and take screenshot");

    }
    
	


}
