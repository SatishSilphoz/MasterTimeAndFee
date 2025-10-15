package com.TimeAndFees.Stepdefinations;

import java.io.IOException;

import com.Capium.Utilites.StepTracker;
import com.TimeAndFees.Actions.FeesActions;

import io.cucumber.java.en.Then;

public class FeesStepDef {

	FeesActions FeesPage = new FeesActions();

	@Then("Navigation to Fees tab")
	public void Send_key_is_search_field_and_validate() throws InterruptedException {
		FeesPage.Navigation_to_Fees_tab();
		StepTracker.setCurrentStep("navigating to fees tab");

	}

	@Then("Navigate to invoice sub tab")
	public void navigate_to_invoice_sub_tab() throws InterruptedException {
		FeesPage.navigate_to_invoice_sub_tab();
		StepTracker.setCurrentStep("navigating to invoice sub tab");

	}
	
	@Then("validate all invoice fiieds shuoul clear")
	public void validate_all_invoice_fields_should_clear() {
	    FeesActions.validate_all_invoice_fields_should_clear();
	    StepTracker.setCurrentStep("validating all invoice fields are cleared after cancel");
	}
	
	
	
	@Then("validate all estimate fiieds shuoul clear")
	public void validate_all_estimate_fields_should_clear() {
	    FeesActions.validate_all_estimate_fields_should_clear();
	    StepTracker.setCurrentStep("validating all estimate fields are cleared after cancel");
	}
	@Then("click on add invoice button")
	public void click_on_add_invoice_button() {
		FeesPage.click_on_add_invoice_button();
		StepTracker.setCurrentStep("clicking on add invoice button");

	}

	@Then("fill all the data in invoice")
	public void fill_all_the_data_in_invoice() throws InterruptedException, IOException {
		FeesPage.fill_all_the_data_in_invoice();
		StepTracker.setCurrentStep("filling all fields in invoice tab");

	}
	
	@Then("click on the save and exit")
	public void click_on_the_save_and_exit() {
		FeesPage.click_on_the_save_and_exit();
		StepTracker.setCurrentStep("clicking on save and exit button");

	}
	
	@Then("validate each value of status filter")
	public void validate_each_value_of_status_filter() throws InterruptedException {
		FeesPage.validate_each_value_of_status_filter();
		StepTracker.setCurrentStep("validating each value of status filter");

	}
	
	@Then("click on preview icon")
	public void click_on_preview_icon() {
		
		FeesPage.click_on_preview_icon();
		StepTracker.setCurrentStep("clicking on preview icon");
	   
	}
	@Then("Validate preview screen")
	public void validate_preview_screen() throws InterruptedException {
	
		FeesPage.validate_preview_screen();
		StepTracker.setCurrentStep("validating preview screen");

	}
	
	@Then("click on send")
	public void click_on_send() throws InterruptedException {
	
		FeesPage.click_on_send();
		StepTracker.setCurrentStep("clicking on send button");

	}
	
	@Then("click on more action")
	public void click_on_more_action() {
		
		FeesPage.click_on_more_action();
		StepTracker.setCurrentStep("clicking on more action");
	    
	}
	
	
	@Then("click on record payment action")
	public void click_on_record_payment_action() throws InterruptedException {
		
		FeesPage.click_on_record_payment_action();
		StepTracker.setCurrentStep("clicking on record payment action");
	    
	}
	
	@Then("click on export action")
	public void click_on_export_action() throws InterruptedException {
		
		FeesPage.click_on_export_action();
		StepTracker.setCurrentStep("clicking on export action");
	}
	
	@Then("click on duplicate action")
	public void click_on_duplicate_action() throws InterruptedException {
		FeesPage.click_on_duplicate_action();
		StepTracker.setCurrentStep("clicking on duplicate action");
	   
	}
	
	@Then("click on copy link action")
	public void click_on_copy_link_action() throws InterruptedException {
		FeesPage.click_on_copy_link_action();
		StepTracker.setCurrentStep("clicking on copy link action");
	
	   
	}
	
	@Then("click on id hyperlink")
	public void click_on_invoice_id_hyperlink() throws InterruptedException {
		FeesPage.click_on_invoice_id_hyperlink();
		StepTracker.setCurrentStep("clicking on hyperlink of id");
	   
	}
	
	@Then("click on preview button")
	public void click_on_preview_button() {
		FeesPage.click_on_preview_button();
		StepTracker.setCurrentStep("clicking on preview button in edit page");
	   
	}
	
	@Then("click on send reminder button")
	public void click_on_send_reminder_button() throws InterruptedException {
		FeesPage.click_on_send_reminder_button();
		StepTracker.setCurrentStep("clicking on send reminder button in edit page");
	   
	}
	
	@Then("click on add note button and send keys")
	public void click_on_add_note_button() throws InterruptedException {
		FeesPage.click_on_add_note_button();
		StepTracker.setCurrentStep("clicking on add note button in edit page");
	   
	}
	
	@Then("clcik on each value of paginator")
	public void clcik_on_each_value_of_paginator() throws InterruptedException {
		FeesPage.clcik_on_each_value_of_paginator();
		StepTracker.setCurrentStep("clicking on wach value of paginator");
	   
	}
	@Then("click on next button")
	public void click_on_next_button() {
		FeesPage.click_on_next_button();
		StepTracker.setCurrentStep("clicking on next button of pagination");
	 
	}
	@Then("click on previous button")
	public void click_on_previous_button() throws InterruptedException {
		FeesPage.click_on_previous_button();
		StepTracker.setCurrentStep("clicking on pagination button of pagination");
	   
	}
// recurring 
	
	@Then("Navigate to recurring invoice sub tab")
	public void navigate_to_recurring_invoice_sub_tab() {
		FeesPage.navigate_to_recurring_invoice_sub_tab();
		StepTracker.setCurrentStep("clicking on recurring invoice sub tab");
	  
	}
	@Then("click on add recurring invoice button")
	public void click_on_add_recurring_invoice_button() {
		FeesPage.click_on_add_recurring_invoice_button();
		StepTracker.setCurrentStep("clicking on add recurring invoice button");
	  
	}
	@Then("add recurring details")
	public void add_recurring_details() throws InterruptedException {
		FeesPage.add_recurring_details();
		StepTracker.setCurrentStep("adding recurring details");
	    
	}
	
	@Then("click on end icon")
	public void click_on_end_icon() {
		FeesPage.click_on_end_icon();
		StepTracker.setCurrentStep("clocking on end icon");
	    
	}
	
	@Then("click on pause action")
	public void click_on_pause_action() {
		FeesPage.click_on_pause_action();
		StepTracker.setCurrentStep("clicking on pause action");
	   
	}

	@Then("click on play action")
	public void click_on_play_action() {
		FeesPage.click_on_play_action();
		StepTracker.setCurrentStep("clicking on play icon");
	    
	}
	
	@Then("Navigate to estimates sub tab")
	public void navigate_to_estimates_sub_tab() {
		FeesPage.navigate_to_estimates_sub_tab();
		StepTracker.setCurrentStep("navigating to estimates sub tab");
	    
	}
	@Then("click on add estimates button")
	public void click_on_add_estimates_button() {
		FeesPage.click_on_add_estimates_button();
		StepTracker.setCurrentStep("clicking on add estimate button");
	   
	}
	@Then("fill all the data in estimates")
	public void fill_all_the_data_in_estimates() throws InterruptedException {
		FeesPage.fill_all_the_data_in_estimates();
		StepTracker.setCurrentStep("fill all details in estimates page");
	   
	}
	
	@Then("click on accepted button")
	public void click_on_accepted_button() {
		FeesPage.click_on_accepted_button();
		StepTracker.setCurrentStep("clicking on accepted button");
	}
	
	@Then("click on draft button")
	public void click_on_draft_button() {
		FeesPage.click_on_draft_button();
		StepTracker.setCurrentStep("clicking on draft button");
	}
	
	@Then("click on declined button")
	public void click_on_declined_button() {
		FeesPage.click_on_declined_button();
		StepTracker.setCurrentStep("clicking on declined button");
	}
	
	@Then("click on mark as sent")
	public void click_on_Mark_as_sent_button() throws InterruptedException {
		FeesPage.click_on_Mark_as_sent_button();
		StepTracker.setCurrentStep("clicking on mark as sent button");
	}
	
	@Then("click on mark as declined")
	public void click_on_Mark_as_declined_button() throws InterruptedException {
		FeesPage.click_on_Mark_as_declined_button();
		StepTracker.setCurrentStep("clicking on mark as declined button");
	}
	
	@Then("click on mark as accepted")
	public void click_on_Mark_as_accepted_button() throws InterruptedException {
		FeesPage.click_on_Mark_as_accepted_button();
		StepTracker.setCurrentStep("clicking on mark as accepted button");
	}
	
	@Then("click on copy")
	public void click_on_Mark_as_copy_button() {
		FeesPage.click_on_Mark_as_copy_button();
		StepTracker.setCurrentStep("clicking on copy button");
	}
	
	@Then("click on plus icon of dicount")
	public void click_on_plus_icon_of_dicount() throws InterruptedException {
		FeesPage.click_on_plus_icon_of_dicount();
		StepTracker.setCurrentStep("clicking on plus icon of discount");
	   
	}
	@Then("click on discount button")
	public void click_on_discount_button() {
		FeesPage.click_on_discount_button();
		StepTracker.setCurrentStep("clicking on discount button");
	   
	}
	@Then("add the name of discount")
	public void add_the_name_of_discount() {
		FeesPage.add_the_name_of_discount();
		StepTracker.setCurrentStep("adding name of that discount");
	   
	}
	@Then("select pound from dropdown")
	public void select_pound_from_dropdown() throws InterruptedException {
		FeesPage.select_pound_from_dropdown();
		StepTracker.setCurrentStep("selecting pound from dropdown");
	   
	}
	@Then("add the dicount amount")
	public void add_the_dicount_amount() {
	 
		FeesPage.add_the_dicount_amount();
		StepTracker.setCurrentStep("adding discount amount");
	}
	@Then("validate dicount currency display")
	public void validate_dicount_display() throws InterruptedException {
	 
		FeesPage.validate_dicount_display();
		StepTracker.setCurrentStep("validating discount currency display ");
	}
	
	@Then("validate dicount percentage display")
	public void validate_dicount_percentage_display() throws InterruptedException {
	 
		FeesPage.validate_dicount_percentage_display();
		StepTracker.setCurrentStep("validating discount percentage display ");
	}
	
	@Then("select percentage from dropdown")
	public void select_percentage_from_dropdown() {
		FeesPage.select_percentage_from_dropdown();
		StepTracker.setCurrentStep("selecting percentage from dropdown");
	   
	}
	
	@Then("click on add cost button")
	public void click_on_add_cost_button() {
		FeesPage.click_on_add_cost_button();
		StepTracker.setCurrentStep("clicking on add cost button");
	   
	}
	@Then("add the name of additional cost")
	public void add_the_name_of_additional_cost() {
	    
		FeesPage.add_the_name_of_additional_cost();
		StepTracker.setCurrentStep("adding the name of additional cost");
	}
	@Then("add the cost amount")
	public void add_the_cost_amount() {
		FeesPage.add_the_cost_amount();
		StepTracker.setCurrentStep("adding the amount of cost");
	   
	}
	@Then("validate additional cost currency display")
	public void validate_additional_cost_currency_display() throws InterruptedException {
	    
		FeesPage.validate_additional_cost_currency_display();
		StepTracker.setCurrentStep("validating additional cost currency");
	}
	@Then("validate additional cost percentage display")
	public void validate_additional_cost_percentage_display() throws InterruptedException {
		FeesPage.validate_additional_cost_percentage_display();
		StepTracker.setCurrentStep("validating additional cost percentage");
	   
	}
	
	@Then("click on cross icon")
	public void click_on_cross_icon() throws InterruptedException {
	    FeesPage.click_on_cross_icon();
	    StepTracker.setCurrentStep("click on cross icon");
	}
	
	@Then("click on copy button in checkbox")
	public void  click_on_copy_button_in_checkbox() throws InterruptedException {
	    FeesPage.click_on_copy_button_in_checkbox();
	    StepTracker.setCurrentStep("click on copy button in checkbox");
	}
	
	@Then("click on mark as sent on checkbox")
	public void  click_on_mark_as_sent_on_checkbox() throws InterruptedException {
	    FeesPage.click_on_mark_as_sent_on_checkbox();
	    StepTracker.setCurrentStep("click on mark as sent on checkbox");
	}
	
	@Then("click on mark as declined on checkbox")
	public void  click_on_mark_as_declined_on_checkbox() throws InterruptedException {
	    FeesPage.click_on_mark_as_declined_on_checkbox();
	    StepTracker.setCurrentStep("click on mark as declined on checkbox");
	}
	
	@Then("click on mark as accepted on checkbox")
	public void  click_on_mark_as_accepted_on_checkbox() throws InterruptedException {
	    FeesPage.click_on_mark_as_accepted_on_checkbox();
	    StepTracker.setCurrentStep("click on mark as accepted on checkbox");
	}
	
	@Then("click on revart status on checkbox")
	public void  click_on_revart_status_on_checkbox() throws InterruptedException {
	    FeesPage.click_on_revart_status_on_checkbox();
	    StepTracker.setCurrentStep("click on revart status on checkbox");
	}






	
	
	
}