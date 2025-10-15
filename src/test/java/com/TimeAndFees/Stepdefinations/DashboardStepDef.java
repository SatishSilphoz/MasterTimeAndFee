package com.TimeAndFees.Stepdefinations;




import com.Capium.Utilites.Log;
import com.Capium.Utilites.StepTracker;
import com.TimeAndFees.Actions.DashboardAction;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class DashboardStepDef {
	
	DashboardAction DashboardPage=new DashboardAction();
	
	@Given("Navigate to Dashboard")
	public void navigate_to_dashboard() {
		
	
		DashboardPage.Navigate_to_Dashboard();
		StepTracker.setCurrentStep("NAVIGATE TO DASHBOARD");
		Log.info("after click on dashboard should navigate to dashboard");	
 
		
	}
	
	@Then("Validate Add Widget button")
	public void validate_add_widget_button() {
	

		DashboardPage.Validate_Add_Widget_button();
		StepTracker.setCurrentStep("Navigate to dashboard");
		  
	}

	@Then("uncheck all boxes time section charts and fees section charts")
	public void uncheck_all_boxes_time_section_charts_and_fees_section_charts() throws InterruptedException {
	
		DashboardPage.uncheck_all_boxes_time_section_charts_and_fees_section_charts();
		StepTracker.setCurrentStep("Navigate to dashboard");
	    
	}

	@Then("click on save")
	public void click_on_save() {
		System.out.println("=== Clicking on save button ===");
		DashboardPage.click_on_save_button();
	 
	}

	@Then("Check all boxes time section charts and fees section charts")
	public void check_all_boxes_time_section_charts_and_fees_section_charts() throws InterruptedException {
		System.out.println("=== Checking all boxes ===");
		DashboardPage.Check_all_boxes_time_section_charts_and_fees_section_charts();
	}

	@Then("scroll to view and verify")
	public void scroll_to_view_and_verify() throws InterruptedException { 

		System.out.println("=== scroll to verify all widget ===");
		DashboardPage.scroll_to_view_and_verify();
		
	}

	@Then("Validate each value of dropdown of time filter")
	public void validate_each_value_of_dropdown_of_time_filter() throws InterruptedException {
		
		System.out.println("=== Validating each value in dropdown ===");
		DashboardPage.Validate_each_value_of_dropdown_of_time_filter();
	    
	}

	@Then("Validate lock button")
	public void validate_lock_button() {
		
		System.out.println("=== Validating each value in dropdown ===");
		DashboardPage.Validate_lock_button();
		
	    
	}
	
	@Then("Validate the timer section")
	public void validate_the_timer_section() throws InterruptedException {
		
		System.out.println("=== Validating start timer  ===");
		DashboardPage.validate_the_timer_section();
	   
	}
	
	@Then("take each value from task wise hour dropdown and take screenshot")
	public void take_each_value_from_task_wise_hour_dropdown_and_take_screenshot() throws InterruptedException {
		
		System.out.println("=== Validating start timer  ===");
		DashboardPage.take_each_value_from_task_wise_hour_dropdown_and_take_screenshot(null);
	   
	}

	
	@Then("take each value from task hours dropdown and take screenshot")
	public void take_each_value_from_task_hours_dropdown_and_take_screenshot() throws InterruptedException {
		
		System.out.println("=== Validating start timer  ===");
		DashboardPage.take_each_value_from_task_hours_dropdown_and_take_screenshot();
	   
	}


	 
}
