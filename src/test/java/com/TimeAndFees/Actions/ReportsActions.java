package com.TimeAndFees.Actions;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.Capium.Utilites.HelperClass;
import com.TimeAndFees.Locators.ReportsLocators;
import com.TimeAndFees.Stepdefinations.Hooks;
import com.aventstack.extentreports.MediaEntityBuilder;

public class ReportsActions {

	ReportsLocators ReportsLocators;
	WebDriverWait wait = HelperClass.getWait();
	WebDriver driver = HelperClass.getDriver();

	public ReportsActions() {

		ReportsLocators = PageFactory.initElements(HelperClass.getDriver(), ReportsLocators.class);
	}

	public void Navigation_to_Reports_tab() throws InterruptedException {

	    Thread.sleep(8000);
	    HelperClass.waitForLoaderToDisappear(30);
		HelperClass.waitUntilVisible(wait, ReportsLocators.TF_Reports).click();
		HelperClass.waitUntilClickable(wait, ReportsLocators.TF_Reports).click();
	}


	public void Validate_each_value_of_dropdown_of_hours_dropdown() throws InterruptedException {
	    Thread.sleep(2000);

	    Map<String, String> screenshots = HelperClass.validateEachDropdownOptionAndCaptureScreenshot(
	            ReportsLocators.TF_AllhoursDropdown,
	            ReportsLocators.TF_Options,
	            "Allhours",
	            "screenshots"
	    );

	    // Assertion: ensure dropdown options were captured
	    if (screenshots != null && !screenshots.isEmpty()) {
	        Assert.assertTrue(true, "All Hours dropdown options validated successfully with screenshots.");
	        System.out.println("All Hours dropdown validated successfully.");
	    } else {
	        Assert.fail("All Hours dropdown validation failed! No screenshots captured.");
	    }

	    // Attach screenshots to report
	    for (Map.Entry<String, String> entry : screenshots.entrySet()) {
	        Hooks.getScenarioTest().info("Screenshot for: " + entry.getKey(),
	                MediaEntityBuilder.createScreenCaptureFromBase64String(entry.getValue()).build());
	    }
	}


	public void Validate_each_value_of_group_by_dropdown() throws InterruptedException {
	    Thread.sleep(2000);

	    Map<String, String> screenshots = HelperClass.validateEachDropdownOptionAndCaptureScreenshot(
	            ReportsLocators.TF_groupByDropdown,
	            ReportsLocators.TF_Options,
	            "GroupBy",
	            "screenshots"
	    );

	    // Assertion: ensure dropdown options were captured
	    if (screenshots != null && !screenshots.isEmpty()) {
	        Assert.assertTrue(true, "Group By dropdown options validated successfully with screenshots.");
	        System.out.println("Group By dropdown validated successfully.");
	    } else {
	        Assert.fail("Group By dropdown validation failed! No screenshots captured.");
	    }

	    // Attach screenshots to report
	    for (Map.Entry<String, String> entry : screenshots.entrySet()) {
	        Hooks.getScenarioTest().info("Screenshot for: " + entry.getKey(),
	                MediaEntityBuilder.createScreenCaptureFromBase64String(entry.getValue()).build());
	    }
	}


	public void click_on_filters_button() throws InterruptedException {
		Thread.sleep(2000);

		HelperClass.waitUntilVisible(wait, By.xpath("//mat-icon[contains(text(),'filter_list')]/ancestor::button")).click();
	}

	public void click_on_save_filter() throws InterruptedException {
		Thread.sleep(2000);

		HelperClass.waitUntilVisible(wait, ReportsLocators.TF_Savesilter).click();
	}

	public void select_users_dropdown() throws InterruptedException {
		Thread.sleep(2000);

		WebElement usersDropdown = HelperClass.waitUntilVisible(wait, ReportsLocators.TF_UsersList);
		usersDropdown.click();
		Thread.sleep(2000);
		WebElement selectAllCheckbox = driver.findElement(By.xpath("(//li[@class='multiselect-item-checkbox ng-star-inserted'])[135]"));
		HelperClass.ClickUsingJS(driver, selectAllCheckbox);

		usersDropdown.click(); // Close dropdown
	}

	public void select_tasks_dropdown() throws InterruptedException {
		

		WebElement tasksDropdown = HelperClass.waitUntilVisible(wait, ReportsLocators.TF_TaskList);
		tasksDropdown.click();
		Thread.sleep(2000);
		WebElement selectAllCheckbox = driver.findElement(By.xpath("(//li[@class='multiselect-item-checkbox ng-star-inserted'])[105]"));
		HelperClass.ClickUsingJS(driver, selectAllCheckbox);

		tasksDropdown.click(); // Close dropdown
	}

	public void select_clients_dropdown() throws InterruptedException {

		WebElement clientsDropdown = HelperClass.waitUntilVisible(wait, ReportsLocators.TF_clientsList);
		clientsDropdown.click();
		Thread.sleep(2000);
		WebElement specificClientCheckbox = driver.findElement(By.xpath("(//li[@class='multiselect-item-checkbox ng-star-inserted'])[2]"));
		HelperClass.ClickUsingJS(driver, specificClientCheckbox);
		clientsDropdown.click(); // Close dropdown
	}

	public void select_jobs_dropdown() throws InterruptedException {

		WebElement jobsDropdown = HelperClass.waitUntilVisible(wait, ReportsLocators.TF_JobsList);
		jobsDropdown.click();
		Thread.sleep(2000);
		WebElement selectAllCheckbox = driver.findElement(By.xpath("(//li[@class='multiselect-item-checkbox ng-star-inserted'])[191]"));
		HelperClass.ClickUsingJS(driver, selectAllCheckbox);
		jobsDropdown.click();
	}

	public void click_on_modifiy_results() throws InterruptedException {
		Thread.sleep(2000);
		HelperClass.waitUntilVisible(wait, By.xpath("//div[contains(text(),'Modify Results')]")).click();

	}

	public void click_on_show_filter_details() throws InterruptedException {
		Thread.sleep(2000);

		HelperClass.waitUntilVisible(wait, By.xpath("//span[contains(text(),'Show Filter Details')]")).click();
	}

	public void click_on_clear_filter() throws InterruptedException {
		Thread.sleep(2000);

		HelperClass.waitUntilVisible(wait, ReportsLocators.TF_Clear_filter).click();
	}

	public void click_on_clear_all_filter() throws InterruptedException {
		Thread.sleep(2000);
		HelperClass.waitUntilVisible(wait, By.xpath("//div[contains(text(),'Clear All Filters')]")).click();
		
	}

	public void Navigate_to_expenses_sub_tab() throws InterruptedException {
		Thread.sleep(5000);
		HelperClass.waitUntilClickable(wait, By.xpath("(//span[contains(text(),'Expenses')])[2]")).click();
		HelperClass.waitUntilVisible(wait, By.xpath("(//span[contains(text(),'Expenses')])[2]")).click();
		
	}

	public void select_expense_dropdown() throws InterruptedException {
	
		WebElement ExpenseDropdown = HelperClass.waitUntilVisible(wait, ReportsLocators.TF_ExpenseList);
		ExpenseDropdown.click();
		Thread.sleep(2000);
		WebElement selectAllCheckbox = driver.findElement(By.xpath("(//li[@class='multiselect-item-checkbox ng-star-inserted'])[191]"));
		HelperClass.ClickUsingJS(driver, selectAllCheckbox);
		ExpenseDropdown.click();
	}
	
	public void select_status_dropdown() throws InterruptedException {
		
		WebElement StatusDropdown = HelperClass.waitUntilVisible(wait, ReportsLocators.TF_StatusList);
		StatusDropdown.click();
		Thread.sleep(2000);
		WebElement selectAllCheckbox = driver.findElement(By.xpath("//input[@aria-label='Draft']"));
		HelperClass.ClickUsingJS(driver, selectAllCheckbox);
		StatusDropdown.click();
	}
	
	public void printSelectedFilterValues() {
	    try {
	        // Wait for the 'Selected Filter Values' container
	        WebElement filterContainer = HelperClass.waitUntilVisible(wait, By.xpath("//div[contains(@class,'job-wrapper')]"));

	        // Extract all value elements in the container
	        List<WebElement> values = filterContainer.findElements(By.xpath(".//span[contains(text(), ':')]"));

	        for (WebElement val : values) {
	            String[] parts = val.getText().split(":");
	            if (parts.length == 2) {
	                String label = parts[0].trim();
	                String count = parts[1].trim();
	                System.out.println(label + " => " + count);
	            }
	        }
	    } catch (Exception e) {
	        System.out.println("Error while reading selected filter values: " + e.getMessage());
	    }
	}

	public void Navigate_to_invoice_sub_tab() throws InterruptedException {
		Thread.sleep(3000);
		HelperClass.waitUntilClickable(wait, By.xpath("//span[contains(text(),'Invoices')]")).click();
		HelperClass.waitUntilVisible(wait, By.xpath("//span[contains(text(),'Invoices')]")).click();
		
		
	}


	public void Validate_contracter_dropdown() throws InterruptedException {
		Thread.sleep(2000);
		Map<String, String> screenshots = HelperClass.validateEachDropdownOptionAndCaptureScreenshot(
				ReportsLocators.TF_Contractordropdown,
				ReportsLocators.TF_Options,
				"Contractor",
				"screenshots"
				);

		// Attach to report here
		for (Map.Entry<String, String> entry : screenshots.entrySet()) {
			Hooks.getScenarioTest().info("Screenshot for: " + entry.getKey(),
					MediaEntityBuilder.createScreenCaptureFromBase64String(entry.getValue()).build());
		}

	}

	public void Navigate_to_users_sub_tab_in_reports() throws InterruptedException {
		Thread.sleep(4000);
		HelperClass.waitUntilClickable(wait, By.xpath("//span[contains(text(),'Users')]")).click();
		HelperClass.waitUntilVisible(wait, By.xpath("//span[contains(text(),'Users')]")).click();
		
	}




}
