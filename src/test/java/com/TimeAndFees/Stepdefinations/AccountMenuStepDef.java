package com.TimeAndFees.Stepdefinations;

import com.Capium.Utilites.HelperClass;
import com.Capium.Utilites.StepTracker;
import com.TimeAndFees.Actions.AccountMenuActions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AccountMenuStepDef {

	AccountMenuActions AccountPage = new AccountMenuActions();

	@Then("click on quick add button")
	public void click_on_quick_add_button() throws InterruptedException {
		AccountPage.click_on_quick_add_button();
		StepTracker.setCurrentStep("clicking on quick add");
	}
	
	@Then("click on history button")
	public void click_on_histroy_button() throws InterruptedException {
		AccountPage.click_on_histroy_button();
		StepTracker.setCurrentStep("clicking on history");
	}

	@Then("click on add time log in quick add")
	public void click_on_add_time_log_in_quick_add() throws InterruptedException {
		AccountPage.click_on_add_time_log_in_quick_add();
		StepTracker.setCurrentStep("clicking add time log in quick add");
	}

	@Then("click on add invoice in quick add")
	public void click_on_add_invoice_in_quick_add() throws InterruptedException {
		AccountPage.click_on_add_invoice_in_quick_add();
		StepTracker.setCurrentStep("clicking add invoice in quick add");
	}


	@Then("click on add expense in quick add")
	public void click_on_add_expense_in_quick_add() throws InterruptedException {
		AccountPage.click_on_add_expense_in_quick_add();
		StepTracker.setCurrentStep("clicking add expense in quick add");
	}
	
	@Then("click on add estimate in quick add")
	public void click_on_add_estimate_in_quick_add() throws InterruptedException {
		AccountPage.click_on_add_estimate_in_quick_add();
		StepTracker.setCurrentStep("clicking add estimate in quick add");
	}

	@Then("click on add task in quick add")
	public void click_on_add_task_in_quick_add() throws InterruptedException {
		AccountPage.click_on_add_task_in_quick_add();
		StepTracker.setCurrentStep("clicking add task in quick add");
	}
	
	@Then("click on add clients in quick add")
	public void click_on_add_clients_in_quick_add() throws InterruptedException {
		AccountPage.click_on_add_clients_in_quick_add();
		StepTracker.setCurrentStep("clicking add clients in quick add");
	}
	
	@Then("click on add users in quick add")
	public void click_on_add_users_in_quick_add() throws InterruptedException {
		AccountPage.click_on_add_users_in_quick_add();
		StepTracker.setCurrentStep("clicking add users in quick add");
	}
	
	@Then("click on add expense type in quick add")
	public void click_on_add_expensetype_in_quick_add() throws InterruptedException {
		AccountPage.click_on_add_expensetype_in_quick_add();
		StepTracker.setCurrentStep("clicking add expanse type in quick add");
	}
	
	@Then("click on add recurring in quick add")
	public void click_on_add_recurring_in_quick_add() throws InterruptedException {
		AccountPage.click_on_add_recurring_in_quick_add();
		StepTracker.setCurrentStep("clicking add recurring in quick add");
	}
	
	@Then("Validate recent activity panel")
	public void Validate_recent_activity_panel() throws InterruptedException {
		AccountPage.Validate_recent_activity_panel();
		StepTracker.setCurrentStep("validating recent activity panel");
	}
	
	@Then("click on view all activity text")
	public void click_on_view_all_activity_text() throws InterruptedException {
		AccountPage.click_on_view_all_activity_text();
		StepTracker.setCurrentStep("clicking on view all activity text");
	}
	
	@Then("validating all dropdown in activity")
	public void validating_all_dropdown_in_activity() throws InterruptedException {
		AccountPage.validating_all_dropdown_in_activity();
		StepTracker.setCurrentStep("validating each option of all dropdown");
	}
	
	@Then("Validate each value of dropdown of time filter in activity page")
	public void Validate_each_value_of_dropdown_of_time_filter_in_activity_page() throws InterruptedException {
		AccountPage.Validate_each_value_of_dropdown_of_time_filter_in_activity_page();
		StepTracker.setCurrentStep("validating each option of time dropdown");
	}
	
	@Then("validate activity page")
	public void validate_activity_page() throws InterruptedException {
		AccountPage.validate_activity_page();
		StepTracker.setCurrentStep("validating activity page");
	}
	
	@Then("click on Announcment button")
	public void click_on_Announcment_button() throws InterruptedException {
		AccountPage.click_on_Announcment_button();
		StepTracker.setCurrentStep("clicking on announcment button");
	}
	
	@Then("fill all the details in add ticket")
	public void fill_all_the_details_in_add_ticket() throws InterruptedException {
		AccountPage.fill_all_the_details_in_add_ticket();
		StepTracker.setCurrentStep("filling all the details in add ticket");
	}
	
	@Then("click on add ticket button")
	public void click_on_add_ticket_button() throws InterruptedException {
		AccountPage.click_on_add_ticket_button();
		StepTracker.setCurrentStep("clicking on add ticket button");
	}
	
	@Then("click on ticket button")
	public void click_on_ticket_button() throws InterruptedException {
		AccountPage.click_on_ticket_button();
		StepTracker.setCurrentStep("clicking on tickets button");
	}
	
	@Then("validate search functionality in tickets")
	public void validate_search_functionality_in_tickets() throws InterruptedException {
		AccountPage.validate_search_functionality_in_tickets();
		StepTracker.setCurrentStep("validate search functionality");
	}
	
	@Then("validate status dropdown in tickets")
	public void validate_status_dropdown_in_tickets() throws InterruptedException {
		AccountPage.validate_status_dropdown_in_tickets();
		StepTracker.setCurrentStep("validate status dropdown");
	}
	
	@Given("click on profile logo")
	public void click_on_profile_logo() throws InterruptedException {
		AccountPage.click_on_profile_logo();
		StepTracker.setCurrentStep("clicking on profile logo");
	  
	}
	@And("validate Purple color option")
	public void validate_purple_color_option() throws InterruptedException {
		
		AccountPage.validate_purple_color_option();
		StepTracker.setCurrentStep("validating purple color");
	    
	}
	@And("validate Periwinkle color option")
	public void validate_periwinkle_color_option() throws InterruptedException {
		AccountPage.validate_periwinkle_color_option();
		StepTracker.setCurrentStep("validating periwinkle color");
	    
	}
	@And("validate Royal Blue color option")
	public void validate_royal_blue_color_option() throws InterruptedException {
		AccountPage.validate_royal_blue_color_option();
		StepTracker.setCurrentStep("validating royal blue color");
	    
	}
	@And("validate Crimson color option")
	public void validate_crimson_color_option() throws InterruptedException {
		AccountPage.validate_crimson_color_option();
		StepTracker.setCurrentStep("validating Crimson color");
	    
	}
	@And("validate Teal color option")
	public void validate_teal_color_option() throws InterruptedException {
		AccountPage.validate_teal_color_option();
		StepTracker.setCurrentStep("validating  Teal color");
	    
	}
	@And("validate Blue color option")
	public void validate_blue_color_option() throws InterruptedException {
		AccountPage.validate_blue_color_option();
		StepTracker.setCurrentStep("validating Blue color");
	    
	}
	@And("validate Mustard  color option")
	public void validate_mustard_color_option() throws InterruptedException {
		AccountPage.validate_mustard_color_option();
		StepTracker.setCurrentStep("validating Mustard  color");
	    
	}
	@And("validate Black color option")
	public void validate_black_color_option() throws InterruptedException {
		AccountPage.validate_black_color_option();
		StepTracker.setCurrentStep("validating black color");
	    
	}

	@Given("Validate Announcment page")
	public void validate_announcment_page() {
		
	    Hooks.captureScreenshotBase64(HelperClass.getDriver(), Hooks.getScenarioTest(), "Announcement Tab");
	}

}
