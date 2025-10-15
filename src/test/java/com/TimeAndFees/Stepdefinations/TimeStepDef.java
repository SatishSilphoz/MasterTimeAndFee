package com.TimeAndFees.Stepdefinations;

import java.util.concurrent.TimeoutException;

import com.Capium.Utilites.StepTracker;
import com.TimeAndFees.Actions.TimeActions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class TimeStepDef {


	TimeActions TimePage=new TimeActions();

	@Given("Navigation to time tab")
	public void navigation_to_time_tab() {

		TimePage.navigation_to_time_tab();
		StepTracker.setCurrentStep("Navigating to Time tab");

	}

	@Then("click on add time button")
	public void click_on_add_time_button() throws InterruptedException {

		TimePage.click_on_add_time_button();
		StepTracker.setCurrentStep("clicking on add Time button");

	}
	
	@Then("validate popup is getting close")
	public void validate_popup_is_getting_close() throws InterruptedException {

		TimePage.validate_popup_is_getting_close();
		StepTracker.setCurrentStep("validating popup is getting close");

	}
	@Then("click on the cancel")
	public void click_on_the_cancel() throws InterruptedException {

		TimePage.click_on_the_cancel();
		StepTracker.setCurrentStep("clicking on cancel button");

	}

	@Then("fill all the fields in popup")
	public void fill_all_the_fields_in_popup() {

		TimePage.fill_all_the_fields_in_popup();
		StepTracker.setCurrentStep("filling all the fields in log time popup");

	}

	@Then ("click on the save")
	public void click_on_the_save() {

		TimePage.click_on_the_save();
		StepTracker.setCurrentStep("Clicking on save");

	}

	@Then("verify time is created or not")
	public void verify_time_is_created_or_not() throws TimeoutException {
		TimePage.verify_time_is_created_or_not("CLI007-JB124", "Enterprise design - SUB 1");
		StepTracker.setCurrentStep("Verifying time is created or not");
	}

	@Then("click on user dropdown")
	public void click_on_user_dropdown() {

		TimePage.click_on_user_dropdown();
		StepTracker.setCurrentStep("clicking on user dropdown");

	}

	@Then("selct user")
	public void selct_user() {

		TimePage.selct_user();
		StepTracker.setCurrentStep("selecting user");

	}

	@Then("verify that user coming in grid")
	public void verify_that_user_coming_in_grid() {

		TimePage.verify_that_user_coming_in_grid();
		StepTracker.setCurrentStep("Verifying use is coming on grid");

	}

	@Then("toggle to day option")
	public void toggle_to_day_option() {
		
		TimePage.toggle_to_day_option();
		StepTracker.setCurrentStep("switching to day option");

	}

	@Then("verify current Date coming in grid")
	public void verify_current_date_coming_in_grid() {

		TimePage.verify_current_date_coming_in_grid();
		StepTracker.setCurrentStep("Verifying current time is coming");

	}

	@Then("click on toolbar")
	public void click_on_toolbar() throws InterruptedException {

		TimePage.click_on_toolbar();
		StepTracker.setCurrentStep("Clicking on toolbar");

	}

	@Then("click on export option")
	public void click_on_export_option() {

		TimePage.click_on_export_option();
		StepTracker.setCurrentStep("clicking on export option");

	}

	@Then("click on export button and verify")
	public void click_on_export_button_and_verify() {
		TimePage.click_on_export_button_and_verify();
		StepTracker.setCurrentStep("verifying exported file");

	}

	@Then("click on delete icon on grid")
	public void click_on_delete_icon_on_grid() {
		TimePage.click_on_delete_icon_on_grid();
		StepTracker.setCurrentStep("clicking on delete icon on grid");

	}

	@Then("verify record is deleted in grid")
	public void verify_record_is_deleted_in_grid() {

		TimePage.verify_record_is_deleted_in_grid();
		StepTracker.setCurrentStep("verifying record deleted");

	}

	@Then("click on the save grid")
	public void click_on_the_save_grid() {
		TimePage.click_on_the_save_grid();
		StepTracker.setCurrentStep("clicking on save button");

	}

	@Then("Verify time sheet saved or not")
	public void verify_time_sheet_saved_or_not() {

		TimePage.verify_time_sheet_saved_or_not();
		StepTracker.setCurrentStep("verifying time sheet saved");

	}

	@Then("click on submit approval button")
	public void click_on_submit_approval_button() {

		TimePage.click_on_submit_approval_button();
		StepTracker.setCurrentStep("clicking on submit approval button");

	}

	@Then("Verify time sheet submit or not")
	public void verify_time_sheet_submit_or_not() {

		TimePage.verify_time_sheet_submit_or_not();
		StepTracker.setCurrentStep("verifying time sheet saved");

	}

	//undubmitted sub-tab

	@Then("Navigate to unsubmitted sub-tab")
	public void navigate_to_unsubmitted_sub_tab() {

		TimePage.navigate_to_unsubmitted_sub_tab();
		StepTracker.setCurrentStep("navigating to unsubmitted tab");

	}

	@Then("click on search fild and add value")
	public void click_on_search_fild_and_add_value() {

		TimePage.click_on_search_fild_and_add_value("Parekh Pratham");
		StepTracker.setCurrentStep("clicking on search field and add value");
	}

	@Then("Verify that record in grid")
	public void verify_that_record_in_grid() {
		TimePage.verify_that_record_in_grid("Parekh");
		StepTracker.setCurrentStep("verifying that record in grid");
	}

	@Then("click on By user dropdown and select By week")
	public void click_on_by_user_dropdown_and_select_by_week() {

		TimePage.click_on_by_user_dropdown_and_select_by_week();
		StepTracker.setCurrentStep("clicking on by user dropdown");

	}

	@Then("Verify that in grid with week name")
	public void verify_that_in_grid_with_week_name() {
		TimePage.verify_that_in_grid_with_week_name();
		StepTracker.setCurrentStep("Verifying week name instead of user name");

	}

	@Then("click on user dropdown and select user")
	public void click_on_user_dropdown_and_select_user() {
		TimePage.click_on_user_dropdown_and_select_user();
		StepTracker.setCurrentStep("clicking on user dropdown");

	}

	@Then("Verify that user in grid")
	public void verify_that_user_in_grid() {

		TimePage.verify_that_user_is_in_grid("Sophi Sophi");
		StepTracker.setCurrentStep("verifying that user in grid");

	}

	@Then("click on record expend icon")
	public void click_on_record_expend_icon() throws InterruptedException {
		TimePage.click_on_record_expend_icon();
		StepTracker.setCurrentStep("clicking on expend icon");

	}

	@Then("click on visible content")
	public void click_on_visible_content() {
		TimePage. click_on_visible_content();
		StepTracker.setCurrentStep("clicking on visible content");

	}

	@Then("Validate overview page")
	public void validate_overview_page() {
		TimePage.validate_overview_page();
		StepTracker.setCurrentStep("verifying overview page after click");


	}

	@Then("click on send reminder button and verify")
	public void click_on_send_reminder_button_and_verify() throws InterruptedException {
		
		TimePage.click_on_send_reminder_button_and_verify();
		StepTracker.setCurrentStep("clicking send reminder button");
		
	}


	@Then("click on submit for approval button and verify")
	public void click_on_submit_for_approval_button_and_verify() throws InterruptedException {
		TimePage.click_on_submit_for_approval_button_and_verify();
		StepTracker.setCurrentStep("clicking submit approval button");
		
	}
	
	@Then("click on export as excel")
	public void click_on_export_as_excel(){
		TimePage.click_on_export_as_excel();
		StepTracker.setCurrentStep("clicking on export as excel");
		
	}
	
	@Then("click on export as csv")
	public void click_on_export_as_csv(){
		TimePage.click_on_export_as_csv();
		StepTracker.setCurrentStep("clicking on export as csv");
		
	}
	
	@Then("click on export as pdf")
	public void click_on_export_as_pdf(){
		TimePage.click_on_export_as_pdf();
		StepTracker.setCurrentStep("clicking export as pdf");
		
	}
	
	@Then("Hover on record")
	public void Hover_on_record() throws InterruptedException{
		TimePage.Hover_on_record();
		StepTracker.setCurrentStep("Hover on grid record");
		
	}
//	
//	@Then("click on submit approval icon")
//	public void click_on_submit_approval_icon(){
//		TimePage.click_on_submit_approval_icon();
//		StepTracker.setCurrentStep("clicking submit approval icon on grid");
//		
//	}
	
	
//PFA sub tab
	@Then("Navigate to PFA sub-tab")
	public void Navigate_to_PFA_sub_tab(){
		TimePage.Navigate_to_PFA_sub_tab();
		StepTracker.setCurrentStep("navigating to PFA subtab");
		
	}
	
	@Then("click on send Note button and verify")
	public void click_on_send_Note_button_and_verify() throws InterruptedException{
		TimePage.click_on_send_Note_button_and_verify();
		StepTracker.setCurrentStep("clicking send note button");
		
	}
	
	@Then("click on reject button and verify")
	public void click_on_reject_button_and_verify() throws InterruptedException{
		TimePage.click_on_reject_button_and_verify();
		StepTracker.setCurrentStep("clicking reject button");
		
	}
	
	@Then("click on approve button")
	public void click_on_approve_button() throws InterruptedException {
		
		TimePage.click_on_approve_button();
		StepTracker.setCurrentStep("Click on approve button");
		
	}
	
	// approved sub tab
	
	@Then("Navigate to approved sub-tab")
	public void Navigate_to_approved_sub_tab() {
		TimePage.Navigate_to_approved_sub_tab();
		StepTracker.setCurrentStep("navigating to approved subtab");
	
		
	}
	
	@Then("click on withdraw approve button")
	public void click_on_withdraw_approve_button() throws InterruptedException {
		TimePage.click_on_withdraw_approve_button();
		StepTracker.setCurrentStep("clicking on withdraw approval button");
	
		
	}
	
	// rejection subtab
	
	@Then("Navigate to rejected sub-tab")
	public void Navigate_to_rejected_sub_tab() {
		TimePage.Navigate_to_rejected_sub_tab();
		StepTracker.setCurrentStep("navigating to rejected subtab");
	
		
	}
	
	@Then("click on withdraw rejected button")
	public void click_on_withdraw_rejected_button() throws InterruptedException {
		TimePage.click_on_withdraw_rejected_button();
		StepTracker.setCurrentStep("clicking on withdraw rejected button");
	 
	}
	
	

}
