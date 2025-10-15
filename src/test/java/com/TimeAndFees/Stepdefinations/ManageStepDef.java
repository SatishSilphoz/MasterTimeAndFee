package com.TimeAndFees.Stepdefinations;

import java.io.IOException;

import com.Capium.Utilites.HelperClass;
import com.Capium.Utilites.StepTracker;
import com.TimeAndFees.Actions.ManageAction;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ManageStepDef {

	ManageAction managebtn = new ManageAction();

	@Given("user is on Time")
	public void user_is_on_time() {
		System.out.println("user is on time menu");
		StepTracker.setCurrentStep("user is on Time");
	}

	@When("user clicks manage button")
	public void user_clicks_manage_button() {
		managebtn.clickonManage();
		StepTracker.setCurrentStep("user clicks manage button");
	}

	@Then("manage page should open")
	public void manage_page_should_open() {
		System.out.println("manage page is opened");
		StepTracker.setCurrentStep("manage page should open");
	}

	@Then("click on the Add Client button")
	public void click_on_the_add_client_button() {
		managebtn.clickonaddclientbtn();
		StepTracker.setCurrentStep("click on the Add Client button");
	}

	@Given("client Create in Time and Fees")
	public void client_create_in_time_and_fees() throws IOException, InterruptedException {
		managebtn.ClientCreation(); // Excel-driven creation
		StepTracker.setCurrentStep("client Create in Time and Fees");
		Hooks.captureScreenshotBase64(HelperClass.getDriver(), Hooks.getScenarioTest(), "Client Created Successfully");
	}

	@Then("Verify the client created or not")
	public void verify_the_client_created_or_not() throws IOException, InterruptedException {
		managebtn.verifyClientCreation(); // Client search + match
		StepTracker.setCurrentStep("Verify the client created or not");
		Hooks.captureScreenshotBase64(HelperClass.getDriver(), Hooks.getScenarioTest(), "Client Verified Successfully");
//		managebtn.Click_Selected_Client();
	}

	@Given("user is on manage")
	public void user_is_on_manage() {
		System.out.println("user is on Manage menu");
		StepTracker.setCurrentStep("user is on manage");
	}

	@Then("click on the edit icon")
	public void click_on_the_edit_icon() {
		managebtn.clickOnEditButton();
		StepTracker.setCurrentStep("click on the edit icon");
	}

	@Then("verify it opening Edit client Page")
	public void verify_it_opening_edit_client_page() {
		managebtn.verifyEditClientPageOpened();
		System.out.println("edit page is open");
		StepTracker.setCurrentStep("verify it opening Edit client Page");
		
	}

	@Then("edit client and click on save")
	public void edit_client_and_click_on_save() throws InterruptedException {
		managebtn.editClientDetailsAndSave();
		StepTracker.setCurrentStep("edit client and click on save");
	}

	@Then("click on the Delete icon")
	public void click_on_the_delete_icon() {
		managebtn.clickOnDeleteIcon();
		StepTracker.setCurrentStep("click on the Delete icon");

	}

	@Then("select the checkbox in Popup")
	public void select_the_checkbox_in_popup() {
		managebtn.clickDeleteCheckbox();
		StepTracker.setCurrentStep("select the checkbox in Popup");

	}

	@Then("click on the Yes button")
	public void clck_on_the_yes_button() {
		managebtn.clickOnDeleteYesButton();
		StepTracker.setCurrentStep("click on the Yes button");
	}

	// archive

	@Then("Hover on record for archive")
	public void Hover_on_records_for_archive() throws InterruptedException {
		managebtn.Hover_on_record();
		StepTracker.setCurrentStep("Hover on record for archive");

	}

	@Then("click on the Archive icon")
	public void click_on_the_Archive_icon() {
		managebtn.clickOnArchiveButton();
		StepTracker.setCurrentStep("click on the Archive icon");
	}

	@Then("click on the yes button")
	public void click_on_the_yes_button() {
		managebtn.clickOnYesButton();
		StepTracker.setCurrentStep("click on the yes button");
	}

	@Then("click on toolbar manage")
	public void click_on_toolbar_manage() throws InterruptedException {
		managebtn.click_on_toolbar();
		StepTracker.setCurrentStep("Clicking tools bar button");

	}


	@Then("click on status dropdown and select status manage")
	public void click_on_status_dropdown_and_select_status() throws InterruptedException {
		managebtn.click_on_status_dropdown_and_select_status();
		StepTracker.setCurrentStep("clicking on dropdown and selctiong status");

	}

	@Then("Validate status is displaying in grid manage")
	public void validate_status_is_displaying_in_grid() {
		managebtn.validate_status_is_displaying_in_grid();
		StepTracker.setCurrentStep("status displaying in grid");

	}

	/////////////////////////// TASK ///////////////////////

	@Then("click on the Tasks menu")
	public void click_on_the_tasks_menu() {
		managebtn.clickOnTasksMenu();
		StepTracker.setCurrentStep("click on the Tasks menu");
	}

	@Then("click on the Add Task button and verify")
	public void click_on_the_add_task_button() {
		managebtn.clickOnAddTaskButton();
		StepTracker.setCurrentStep("click on the Add Task button and verify");
		
	}

	@Then("Fill all details and click on save")
	public void fill_all_details_and_click_on_save() {
		managebtn.fillAddTaskForm(); // Fills form fields
		managebtn.clickSaveTaskButton(); // Clicks the Save button
		StepTracker.setCurrentStep("Fill all details and click on save");
	}

	@Then("verify created task appears in search")
	public void verify_created_task_appears_in_search() throws IOException, InterruptedException {
		managebtn.verifyTaskCreation();
		StepTracker.setCurrentStep("verify created task appears in search");
	}

	@Then("click on edit icon in task")
	public void click_on_edit_icon_in_task() {
		managebtn.clickOnEditIconInTask();
		StepTracker.setCurrentStep("click on edit icon in task");
	}

	@Then("update task details and verify in form and search")
	public void update_task_details_and_verify_in_form_and_search() {
		managebtn.updateAndVerifyTask(); // Call action method from ManageAction
		StepTracker.setCurrentStep("update task details and verify in form and search");
	}

	////////////////////////////////////// USER
	////////////////////////////////////// /////////////////////////////////////////////

	@Then("click on the Users menu")
	public void click_on_the_users_menu() {
		managebtn.clickOnUsersMenu();
		StepTracker.setCurrentStep("click on the Users menu");
	}

	@Then("Users page should open")
	public void users_page_should_open() {
		managebtn.verifyUsersPage();
		StepTracker.setCurrentStep("Users page should open");
	}

	@Then("click on the Add User button")
	public void click_on_add_user_button() {
		managebtn.clickAddUserButton();
		StepTracker.setCurrentStep("click on the Add User button");
	}

	@Then("fill user form from Excel and verify in search")
	public void fill_user_form_from_excel_and_verify_in_search() {
	    managebtn.fillAddUserFormAndVerify();
	    StepTracker.setCurrentStep("fill user form from Excel and verify in search");
	}

	@Then("search and verify the user from excel")
	public void search_and_verify_the_user_from_excel() {
	    managebtn.searchUserFromExcel();
	    StepTracker.setCurrentStep("search and verify the user from excel");
	}

	
	@Then("edit user details and verify in search")
	public void edit_user_details_and_verify_in_search() {
		managebtn.editUserAndVerifyUpdate();
		StepTracker.setCurrentStep("edit user details and verify in search");
	}

	
	///////////////////////////////////// EXPENSE TYPES /////////////////////////////////////////
	
	@Then("click on the Expense Types menu")
	public void click_on_expense_types_menu() {
	    managebtn.clickOnExpenseTypesMenu();
	    StepTracker.setCurrentStep("click on the Expense Types menu");
	}
	
	@Then("click on the Add Expense Type button and verify URL")
	public void click_on_add_expense_type_button_and_verify_url() {
	    managebtn.clickAddExpenseTypeButton();
	    StepTracker.setCurrentStep("click on the Add Expense Type button and verify URL");
	}

	@Then("fill the Add Expense Type form from Excel and submit")
	public void fill_the_Add_Expense_Type_form_from_Excel_and_submit() {
	    managebtn.fillExpenseTypeFormFromExcel();
	    StepTracker.setCurrentStep("fill the Add Expense Type form from Excel and submit");
	}

	
	@Then("click on edit icon in Expense Types")
	public void click_on_edit_icon_in_expense_types() {
		managebtn.clickEditIconInExpenseTypes();
	    StepTracker.setCurrentStep("click on edit icon in Expense Types");
	}

	@Then("update task details and verify it from search")
	public void update_task_details_and_verify_it_from_search() {
		managebtn.updateExpenseTypeFromExcelAndSearch(); // Separate action class
		StepTracker.setCurrentStep("update task details and verify it from search");
	}
	
	
	/////////////////////////////////IMPORT ///////////////////////////////////
	
	
	
//	/remove comment for run import for client
	 @Then("Click on Import menu")
	    public void click_on_import_menu() throws InterruptedException {
		 managebtn.clickImportMenu();
			StepTracker.setCurrentStep("Click on Import menu");
	    }
	
	
	
	 @Then("Click on client checkbox")
	    public void click_on_client_checkbox() {
		 managebtn.clickClientCheckBox();
		 StepTracker.setCurrentStep("Click on client checkbox");
	    }

	    @Then("Click on Next button")
	    public void click_on_next_button() {
	    	managebtn.clickNextButton();
	    	StepTracker.setCurrentStep("Click on Next button");
	    }
	
	
	    @Then("Select random module from dropdown")
	    public void select_random_module_from_dropdown() throws InterruptedException {
	    	managebtn.selectRandomModule();
	    	StepTracker.setCurrentStep("Select random module from dropdown");
	    }

	    @Then("Select all client types")
	    public void select_all_client_types() throws InterruptedException {
	    	managebtn.selectAllClientTypes();
	    	StepTracker.setCurrentStep("Select all client types");
	    }
	
	    @Then("Click Next buttons")
	    public void Click_Next_buttons() {
	    	managebtn.clickNextButton();
	    	StepTracker.setCurrentStep("Click Next buttons");
	    }
	
	    @Then("Click on Accept And Continue and take screenshot")
	    public void click_on_accept_and_continue_and_take_screenshot() throws IOException, InterruptedException {
	    	managebtn.clickAcceptAndContinueAndTakeScreenshot("AcceptAndContinue");
	    	StepTracker.setCurrentStep("Click on Accept And Continue and take screenshot");
	    	
	    }
	
	
	
	    
	    
	    
	    ///////////////////////////for all type import //////
	
	    @Given("User is on the Import page")
	    public void user_is_on_the_import_page() throws InterruptedException {
	    	managebtn.navigateToImportPage();
	    	StepTracker.setCurrentStep("User is on the Import page");
	    }

	    @When("User imports data for all categories")
	    public void user_imports_data_for_all_categories() throws Exception {
	    	managebtn.importForAllCategories();
	    	StepTracker.setCurrentStep("User imports data for all categories");

	    }

	    @Then("The data should be imported successfully for all categories")
	    public void data_should_be_imported_successfully_for_all_categories() {
	    	managebtn.verifyImportSuccess();
	    	StepTracker.setCurrentStep("The data should be imported successfully for all categories");

	    }
	
	
	
	
	/////////////////////////////////////////  Export /////////////////////////////////////////////////////
	
	@Then("click on the Export menu")
	    public void click_on_export_menu() throws InterruptedException {
		 managebtn.clickExportMenu();
	    	StepTracker.setCurrentStep("click on the Export menu");

	    }
	 @Then("user exports data for each date range, each category, and each file format")
	    public void user_exports_for_all_combinations() throws InterruptedException {
		 managebtn.exportAllDateRangesCategoriesAndFormats();
	    	StepTracker.setCurrentStep("user exports data for each date range, each category, and each file format");

	    }
	
}
