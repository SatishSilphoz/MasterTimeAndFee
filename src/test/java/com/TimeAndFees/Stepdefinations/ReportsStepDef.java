package com.TimeAndFees.Stepdefinations;

import com.Capium.Utilites.StepTracker;
import com.TimeAndFees.Actions.ReportsActions;

import io.cucumber.java.en.Then;

public class ReportsStepDef {

	ReportsActions ReportPage = new ReportsActions();

	@Then("Navigation to Reports tab")
	public void Navigation_to_Reports_tab() throws InterruptedException {
		ReportPage.Navigation_to_Reports_tab();
		StepTracker.setCurrentStep("navigating to reports tab");
	}

	@Then("Validate each value of group by dropdown")
	public void Validate_each_value_of_group_by_dropdown() throws InterruptedException {
		ReportPage.Validate_each_value_of_group_by_dropdown();
		StepTracker.setCurrentStep("validating each value of group by dropdown");
	}
	
	@Then("Validate each value of billable dropdown")
	public void Validate_each_value_of_dropdown_of_hours_dropdown() throws InterruptedException {
		ReportPage.Validate_each_value_of_dropdown_of_hours_dropdown();
		StepTracker.setCurrentStep("validating each value of billable dropdown");
	}
	
	@Then("click on clear filter")
	public void click_on_clear_filter() throws InterruptedException {
		ReportPage.click_on_clear_filter();
		StepTracker.setCurrentStep("clicking on clear filter");

	}

	@Then("click on show filter details")
	public void click_on_show_filter_details() throws InterruptedException {
		ReportPage.click_on_show_filter_details();
		StepTracker.setCurrentStep("clicking on show filter details");

	}
	@Then("click on modifiy results")
	public void click_on_modifiy_results() throws InterruptedException {
		ReportPage.click_on_modifiy_results();
		StepTracker.setCurrentStep("clicking on modifiy resultes");

	}

	@Then("select jobs dropdown")
	public void select_jobs_dropdown() throws InterruptedException {
		ReportPage.select_jobs_dropdown();
		StepTracker.setCurrentStep("selecting job dropdown");
	}
	@Then("click on filters button")
	public void click_on_filters_button() throws InterruptedException {

		ReportPage.click_on_filters_button();
		StepTracker.setCurrentStep("clicking on filter button");

	}
	@Then("select clients dropdown")
	public void select_clients_dropdown() throws InterruptedException {

		ReportPage.select_clients_dropdown();
		StepTracker.setCurrentStep("selecting clients dropdown");

	}
	@Then("select tasks dropdown")
	public void select_tasks_dropdown() throws InterruptedException {
		ReportPage.select_tasks_dropdown();
		StepTracker.setCurrentStep("selecting tasks dropdown");
	}
	@Then("select users dropdown")
	public void select_users_dropdown() throws InterruptedException {
		ReportPage.select_users_dropdown();
		StepTracker.setCurrentStep("selecting users dropdown");
	}
	
	@Then("select expense dropdown")
	public void select_expense_dropdown() throws InterruptedException {
		ReportPage.select_expense_dropdown();
		StepTracker.setCurrentStep("selecting expense dropdown");
	}

	@Then("click on save filter")
	public void click_on_save_filter() throws InterruptedException {
		ReportPage.click_on_save_filter();
		StepTracker.setCurrentStep("clicking on save filter button");
	}
	
	@Then("click on clear all filter")
	public void click_on_clear_all_filter() throws InterruptedException {
		ReportPage.click_on_clear_all_filter();
		StepTracker.setCurrentStep("clicking on clear all filter ");
	}
	
	@Then("Navigate to expenses sub tab")
	public void Navigate_to_expenses_sub_tab() throws InterruptedException {
		ReportPage.Navigate_to_expenses_sub_tab();
		StepTracker.setCurrentStep("navigating to expenses sub tab ");
	}
	
	@Then("Valdiate job wrapper container")
	public void Valdiate_job_wrapper_container() throws InterruptedException {
		ReportPage.printSelectedFilterValues();
		StepTracker.setCurrentStep("validating job wrapper container");
	}
	
	@Then("Navigate to invoice sub tab in reports")
	public void Navigate_to_invoice_sub_tab() throws InterruptedException {
		ReportPage.Navigate_to_invoice_sub_tab();
		StepTracker.setCurrentStep("navigating to invoice sub tab ");
	}
	
	@Then("select status dropdown")
	public void select_status_dropdown() throws InterruptedException {
		ReportPage.select_status_dropdown();
		StepTracker.setCurrentStep("selecting status dropdown");
	}
	
	@Then("clicking on contractor dropdown")
	public void Validate_contracter_dropdown() throws InterruptedException {
		ReportPage.Validate_contracter_dropdown();
		StepTracker.setCurrentStep("selecting contractor dropdown");
	}
	
	@Then("Navigate to users sub tab in reports")
	public void Navigate_to_users_sub_tab_in_reports() throws InterruptedException {
		ReportPage.Navigate_to_users_sub_tab_in_reports();
		StepTracker.setCurrentStep("navigating to users sub tab");
	}

}
