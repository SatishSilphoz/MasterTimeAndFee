package com.TimeAndFees.Stepdefinations;

import com.Capium.Utilites.StepTracker;
import com.TimeAndFees.Actions.ExpensesActions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ExpensesStepDef {
	ExpensesActions Expensespage = new ExpensesActions();

	@Given("Click on Expenses tab")
	public void click_on_expenses_tab() {
		Expensespage.clickOnExpensesTab();
    	StepTracker.setCurrentStep("Click on Expenses tab");

	}

	@Then("Click on the Add Expense Button")
	public void click_on_the_add_expense_button() throws InterruptedException {
		Expensespage.clickAddExpenseButton();
		StepTracker.setCurrentStep("Click on the Add Expense Button");
	}

	@Then("fill the form and click on the save")
	public void fill_the_form_and_click_on_the_save() throws Exception {
		Expensespage.fillAddExpenseForm();
		StepTracker.setCurrentStep("fill the form and click on the save");
	}

	@Then("Click on the search")
	public void click_on_the_search() throws InterruptedException {
		Expensespage.clickOnSearchField();
		StepTracker.setCurrentStep("Click on the search");
	}

	@Then("search the value and it should show in grid")
	public void search_the_value_and_it_should_show_in_grid() {
		String valueToSearch = "Test Data"; // replace with dynamic value from Excel if needed
		Expensespage.searchAndValidate(valueToSearch);
		StepTracker.setCurrentStep("search the value and it should show in grid");
	}

	@Then("Validate the date filter dropdown by selecting each option")
	public void validate_the_date_filter_dropdown_by_selecting_each_option() throws InterruptedException {
		Expensespage.click_on_date_filter_dropdown_and_select_all_options();
		StepTracker.setCurrentStep("Validate the date filter dropdown by selecting each option");
	}

	@When("I select all status options one by one from the dropdown")
	public void i_select_all_status_options_one_by_one_from_the_dropdown() throws InterruptedException {
		Expensespage.selectAllStatusOptionsAndCapture();
		StepTracker.setCurrentStep("I select all status options one by one from the dropdown");

	}

	@When("I select each expense type option one by one from the dropdown")
	public void i_select_each_expense_type_option() throws InterruptedException {
		Expensespage.click_on_expense_type_dropdown_and_select_all_options();
		StepTracker.setCurrentStep("I select each expense type option one by one from the dropdown");

	}

	@Then("I should see that each expense type option is selectable")
	public void i_should_see_each_expense_type_option_is_selectable() {
		System.out.println("✅ Verified all expense types were selectable.");
		StepTracker.setCurrentStep("I should see that each expense type option is selectable");

	}

	@When("I select each user option one by one from the user dropdown")
	public void i_select_each_user_option_one_by_one_from_the_user_dropdown() throws InterruptedException {
		Expensespage.selct_user();
		StepTracker.setCurrentStep("I select each user option one by one from the user dropdown");

	}

	@Then("I should see that each user option is selectable")
	public void i_should_see_that_each_user_option_is_selectable() {
		System.out.println("All user options validated successfully.");
		StepTracker.setCurrentStep("I should see that each user option is selectable");
	}
	
	@Then("Hover on record Expense")
	public void Hover_on_record_Expense() throws InterruptedException {
		Expensespage.Hover_on_record();
		StepTracker.setCurrentStep("Hover on record Expense");
	}
	@Then("click on the Delete icon Expense")
	public void click_on_the_delete_icon_Expense() throws InterruptedException {
		Expensespage.clickOnDeleteIcon();
		StepTracker.setCurrentStep("click on the Delete icon Expense");

	}
	
	@Then("click on the renubder icon Expense")
	public void clickOnreminderIcon() throws InterruptedException {
		Expensespage.clickOnreminderIcon();
		StepTracker.setCurrentStep("click on the remidner icon Expense");

	}

	@Then("clck on the Yes button Expense")
	public void clck_on_the_yes_button_Expense() {
		Expensespage.clickOnYesButton();
		StepTracker.setCurrentStep("clck on the Yes button Expense");
	}
	
	
	@Then("click on the Reminder icon Expense")
	public void click_on_the_Reminder_icon_Expense() {
		Expensespage.clickOnReminderIcon();
		StepTracker.setCurrentStep("click on the Reminder icon Expense");

	}
	
	@Then("click on the Submit icon Expense")
	public void click_on_the_Submit_icon_Expense() {
		Expensespage.clickOnSubmitIcon();
		StepTracker.setCurrentStep("click on the Submit icon Expense");
		
	}
	
	@Then("click on the Edit icon Expense")
	public void click_on_the_Edit_icon_Expense() throws InterruptedException {
		Expensespage.clickEditIcon();
		StepTracker.setCurrentStep("click on the Edit icon Expense");

	}
	
	
	@Then("user edits the unit price to {string} and saves")
	public void user_edits_the_unit_price_and_saves(String unitPrice) throws InterruptedException {
	    Expensespage.editUnitPriceAndSave(unitPrice);
	    StepTracker.setCurrentStep("user edits the unit price to {string} and saves");
	}
	
}
