package com.TimeAndFees.Stepdefinations;

import com.Capium.Utilites.StepTracker;
import com.TimeAndFees.Actions.JobActions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class JobStepDef {


	JobActions JobPage=new JobActions();


	@Given("Navigation to Jobs tab")
	public void navigation_to_jobs_tab() {
		JobPage.navigation_to_jobs_tab();
		StepTracker.setCurrentStep("Navigating to jobs tab");

	}

	@Then("click on add Job button")
	public void click_on_add_job_button() throws InterruptedException {

		JobPage.click_on_add_job_button();
		StepTracker.setCurrentStep("clicking on addm job button");

	}
	
	@Then("click on cancel button for customize column")
	public void click_on_cancel_button_for_customize_column() {
		JobPage.click_on_cancel_button_for_customize_column();
		StepTracker.setCurrentStep("clicking on cancel button");
	}
	@Then("validate panel should disappear")
	public void validate_panel_should_disappear() {
		JobPage.validate_panel_should_disappear();
		StepTracker.setCurrentStep("validating panel should disappear");
	}

	@Then("fill all the fields in job popup")
	public void fill_all_the_fields_in_job_popup() throws InterruptedException {

		JobPage.fill_all_the_fields_in_job_popup();
		StepTracker.setCurrentStep("filling all details in job popup");

	}

	@Then("verify search functionality")
	public void verify_Search_functionality() throws InterruptedException {

		JobPage.verify_Search_functionality();
		StepTracker.setCurrentStep("verify search functionality");

	}

	@Then("click on the save & view details")
	public void click_on_the_save_and_view_details() throws InterruptedException {

		JobPage.click_on_the_save_and_view_details();
		StepTracker.setCurrentStep("clicking on save and view details page");

	}

	@Then("job details page validate")
	public void job_details_page_validate() throws InterruptedException {

		JobPage.job_details_page_validate();
		StepTracker.setCurrentStep("job details page validating");

	}

	@Then("click on the save & add another")
	public void click_on_the_save_and_add_another() throws InterruptedException {

		JobPage.click_on_the_save_and_add_another();
		StepTracker.setCurrentStep("clicking on save and add another button");

	}

	@Then("Validate add jobs dialog")
	public void Validate_add_jobs_dialog() throws InterruptedException {

		JobPage.Validate_add_jobs_dialog();
		StepTracker.setCurrentStep("Add job dialog verifying");

	}

	@Then("click on my jobs option")
	public void click_on_my_jobs_option() throws InterruptedException {

		JobPage.click_on_my_jobs_option();
		StepTracker.setCurrentStep("clicking on my jobs option");

	}

	@Then("validate user column should disappear")
	public void validate_user_column_should_disappear() {
		JobPage.validate_user_column_should_disappear();
		StepTracker.setCurrentStep("user columnn should disappear from grid");

	}

	@Then("click on status dropdown and select status")
	public void click_on_status_dropdown_and_select_status() throws InterruptedException {
		JobPage.click_on_status_dropdown_and_select_status();
		StepTracker.setCurrentStep("clicking on dropdown and selctiong status");

	}

	@Then("Validate status is displaying in grid")
	public void validate_status_is_displaying_in_grid() {
		JobPage.validate_status_is_displaying_in_grid();
		StepTracker.setCurrentStep("status displaying in grid");

	}

	@Then("click on task dropdown")
	public void click_on_task_dropdown() throws InterruptedException {
		JobPage.click_on_task_dropdown();
		StepTracker.setCurrentStep("clicking task dropdown");

	}

	@Then("select any option")
	public void select_any_option() throws InterruptedException {
		JobPage.select_any_option();
		StepTracker.setCurrentStep("selecting any option");

	}

	@Then("task should display in grid validate")
	public void task_should_display_in_grid_validate() {
		JobPage.task_should_display_in_grid_validate();
		StepTracker.setCurrentStep("validate task should display in grid");

	}

	@Then("click on customize columns")
	public void click_on_customize_columns() throws InterruptedException {
		JobPage.click_on_customize_columns();
		StepTracker.setCurrentStep("clicking on customize columns");


	}

	@Then("uncheck all boxes")
	public void uncheck_all_boxes() throws InterruptedException {
		JobPage.uncheck_all_boxes();
		StepTracker.setCurrentStep("unchecking all boxes");


	}

	@Then("validate columns should disappear")
	public void validate_columns_should_disappear() throws InterruptedException {
		JobPage.validate_columns_should_disappear();
		StepTracker.setCurrentStep("column should disappear after uncheck columns");
	}

	@Then("check all boxes")
	public void check_all_boxes() throws InterruptedException {
		JobPage.check_all_boxes();
		StepTracker.setCurrentStep("checking all boxes");

	}

	@Then("validate columns should appear")
	public void validate_columns_should_appear() throws InterruptedException {
		JobPage.validate_columns_should_appear();
		StepTracker.setCurrentStep("Column should appear after enable checkbox");

	}

	@Then("Validate each value of dropdown of time filter in jobs")
	public void Validate_each_value_of_dropdown_of_time_filter_in_jobs() throws InterruptedException  {
		JobPage.Validate_each_value_of_dropdown_of_time_filter_in_jobs();
		StepTracker.setCurrentStep("validating each option of dropdown in time filter");

	}	

	@Then("click on toolbar jobs")
	public void click_on_toolbar_jobs() throws InterruptedException {
		JobPage.click_on_toolbar_jobs();
		StepTracker.setCurrentStep("Clicking tools bar button");

	}
	@Then("click on Bulk job")
	public void click_on_bulk_job() {
		JobPage.click_on_bulk_job();
		StepTracker.setCurrentStep("clicking on bulk job button");
	}
	@Then("fill all the details in bulk job popup")
	public void fill_all_the_details_in_bulk_job_popup() throws InterruptedException {
		JobPage.fill_all_the_details_in_bulk_job_popup();
		StepTracker.setCurrentStep("Fill all the details in bulk Jobpopup");

	}


	@Then("click on edit icon")
	public void click_on_edit_icon() throws InterruptedException {
		JobPage.click_on_edit_icon();
		StepTracker.setCurrentStep("clicking on edit icon");

	}
	
	@Then("Validate edit page")
	public void validate_edit_page() throws InterruptedException {
		JobPage.validate_edit_page();
		StepTracker.setCurrentStep("Verifying edit job page");

	}

	@Then("click on add sub task button")
	public void click_on_add_sub_task_button() throws InterruptedException {
		JobPage.click_on_add_sub_task_button();
		StepTracker.setCurrentStep("clicking on add sub task button");

	}
	
	@Then("validate cancel changes in email sub section")
	public void validate_cancel_changes_in_email_sub_section() throws InterruptedException {
		JobPage.validate_cancel_changes_in_email_sub_section();
		StepTracker.setCurrentStep("validating cancel changes in email sub section");

	}
	
	@Then("validate save and exit in details")
	public void validate_save_and_exit_in_details() throws InterruptedException {
		JobPage.validate_save_and_exit_in_details();
		StepTracker.setCurrentStep("validating save and exit screen");
	}

	@Then("enter the data in new row")
	public void enter_the_data_in_new_row() {

		JobPage.enter_the_data_in_new_row();
		StepTracker.setCurrentStep("enter data in enw row");

	}
	
	@Then("Validate cancel in comments")
	public void Validate_cancel_in_comments() {

		JobPage.Validate_cancel_in_comments();
		StepTracker.setCurrentStep("validate cancel changes in comments");

	}

	@Then("click on subtask dropdown and select option")
	public void click_on_subtask_users_dropdown_and_select_option() throws InterruptedException {
		JobPage.click_on_subtask_users_dropdown_and_select_option();
		StepTracker.setCurrentStep("clicking on subtask/users dropdown");

	}

	@Then("validate selected option")
	public void validate_selected_option() {

		JobPage.validate_selected_option();
		StepTracker.setCurrentStep("selection option verify");
	}

	@Then("click on email sub section")
	public void click_on_email_sub_section() {
		JobPage.click_on_email_sub_section();
		StepTracker.setCurrentStep("clicking on email sub section");

	}

	@Then("send the keys in fields")
	public void send_the_keys_in_fields() {
		JobPage.send_the_keys_in_fields();
		StepTracker.setCurrentStep("sending keys in fields");

	}

	@Then("click on send mail button")
	public void click_on_send_mail_button() {
		JobPage.click_on_send_mail_button();
		StepTracker.setCurrentStep("clicking send email button");

	}

	@Then("click on recurring sub section")
	public void click_on_recurring_sub_section() {
		JobPage.click_on_recurring_sub_section();
		StepTracker.setCurrentStep("clicking recurring sub section");

	}

	@Then("click on repeat this job dropdown and select option")
	public void click_on_repeat_this_job_dropdown_and_select_option() {
		JobPage.click_on_repeat_this_job_dropdown_and_select_option();
		StepTracker.setCurrentStep("clicking on repeat this job dropdown and selecting option");

	}

	@Then("select option from create first job on dropdown")
	public void select_option_from_create_first_job_on_dropdown() {
		JobPage.select_option_from_create_first_job_on_dropdown();
		StepTracker.setCurrentStep("selecting option from create first job dropdown");

	}

	@Then("click on end this recurring")
	public void click_on_end_this_recurring() {
		JobPage.click_on_end_this_recurring();
		StepTracker.setCurrentStep("clicking on end this recurring");
	}

	@Then("click on comment sub section")
	public void click_on_comment_sub_section() {
		JobPage.click_on_comment_sub_section();
		StepTracker.setCurrentStep("clicking on comment sub section");

	}

	@Then("send keys in comments")
	public void send_keys_in_comments() {
		JobPage.send_keys_in_comments();
		StepTracker.setCurrentStep("sending keys in comments");

	}

	@Then("click on submit button")
	public void click_on_submit_button() throws InterruptedException {
		JobPage.click_on_submit_button();
		StepTracker.setCurrentStep("clicking on the submit button");

	}

	@Then("click on timelog sub section")
	public void click_on_timelog_sub_section() {
		
		JobPage.click_on_timelog_sub_section();
		StepTracker.setCurrentStep("clicking on time log sub section");
		
	}

	@Then("click on files sub section")
	public void click_on_files_sub_section() {
		JobPage.click_on_files_sub_section();
		StepTracker.setCurrentStep("clicking on the files sub section");
		
	}
	
	@Then("click on invoice sub section")
	public void click_on_invoice_sub_section() {
		JobPage.click_on_invoice_sub_section();
		StepTracker.setCurrentStep("clicking on the invoice sub section");
		
	}

	@Then("click on activity sub section")
	public void click_on_activity_sub_section() {
		JobPage.click_on_activity_sub_section();
		StepTracker.setCurrentStep("clicking on the activity sub section");
		
	}
	
	@Then("click on search icon")
	public void click_on_search_icon() {
		JobPage.click_on_search_icon();
		StepTracker.setCurrentStep("clicking on search icon");
		
	}
	
	@Then("fill all the fields in job popup in side panel")
	public void fill_all_the_fields_in_job_popup_side_panel() throws InterruptedException {
		JobPage.fill_all_the_fields_in_job_popup_side_panel();
		StepTracker.setCurrentStep("filling value in fields in add job popup in side panel");
	}

	@Then("click on delete icon")
	public void click_on_delete_icon() throws InterruptedException {
		JobPage.click_on_delete_icon();
		StepTracker.setCurrentStep("click on delete icon");

	}

	@Then("Validate record delete")
	public void validate_record_delete() {
		JobPage.validate_record_delete();
		StepTracker.setCurrentStep("Verifying delete record");

	}




	// Calendar sub tab

	@Then("Click on calender sub-tab")
	public void Click_on_calender_sub_tab() throws InterruptedException {
		JobPage.Click_on_calender_sub_tab();
		StepTracker.setCurrentStep("clicking calender sub-tab");

	}

	@Then("Click on add job button calendar")
	public void Click_on_add_job_button_calendar() throws InterruptedException {
		JobPage.Click_on_add_job_button_calendar();
		StepTracker.setCurrentStep("add job clicking on calendar sub tab");

	}

	@Then("verify Job is created or not in calendar")
	public void verify_Job_is_created_or_not_in_calendar() throws InterruptedException {
		JobPage.verify_Job_is_created_or_not_in_calendar();
		StepTracker.setCurrentStep("Verifying job is created or not");

	}

	@Then("click on calender button")
	public void click_on_calender_button() {
		JobPage.click_on_calender_button();
		StepTracker.setCurrentStep("clicking on calender button");

	}
	@Then("selct year and month")
	public void selct_year_and_month() {
		JobPage.selct_year_and_month();
		StepTracker.setCurrentStep("slecting year and month");

	}
	@Then("Validate the year and month")
	public void validate_the_year_and_month() {
		JobPage.validate_the_year_and_month();
		StepTracker.setCurrentStep("Validating year and month selection");

	}

	@Then("switch to week view and validate")
	public void switch_to_week_view_and_validate() {
		JobPage.switch_to_week_view_and_validate();
		StepTracker.setCurrentStep("Validating week view and grid result");

	}

	@Then("switch to day view and validate")
	public void switch_to_day_view_and_validate() {
		JobPage.switch_to_day_view_and_validate();
		StepTracker.setCurrentStep("Validating day view and grid result");

	}

	@Then("click on side bar icon")
	public void click_on_side_bar_icon() {
		JobPage.click_on_side_bar_icon();
		StepTracker.setCurrentStep("clicking on side bar icon");

	}


	@Then("Send key is search field and validate")
	public void Send_key_is_search_field_and_validate() {
		JobPage.Send_key_is_search_field_and_validate();
		StepTracker.setCurrentStep("sending keys in serach field");

	}

	@Then("click on checkbox of grid")
	public void click_on_checkbox_of_grid() throws InterruptedException {
		JobPage.click_on_checkbox_of_grid();
		StepTracker.setCurrentStep("click on checkbox of grid");
	    
	}
	@Then("click on mark as completed button")
	public void click_on_mark_as_completed_button() {
		JobPage.click_on_mark_as_completed_button();
		StepTracker.setCurrentStep("click on mark as completed button");
	   
	}
	@Then("validate with custome message")
	public void validate_with_custome_message() throws InterruptedException {
		JobPage.validate_with_custome_message();
		StepTracker.setCurrentStep("validate with custome message");
	    
	}
	@Then("click on mark as yet to start button")
	public void click_on_mark_as_yet_to_start_button() {
		JobPage.click_on_mark_as_yet_to_start_button();
		StepTracker.setCurrentStep("click on mark as yet to start button");
	    
	}
	@Then("click on delete button on checkbox")
	public void click_on_delete_button_on_checkbox() throws InterruptedException {
		JobPage.click_on_delete_button_on_checkbox();
		StepTracker.setCurrentStep("click on delete button on checkbox");
	   
	}













}
