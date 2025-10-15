package com.TimeAndFees.Actions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.Capium.Utilites.HelperClass;
import com.TimeAndFees.Locators.DashboardLocators;
import com.TimeAndFees.Stepdefinations.Hooks;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.gherkin.model.Scenario;

public class DashboardAction {

	DashboardLocators DashboardLocators;
	WebDriverWait wait = HelperClass.getWait();
	WebDriver driver = HelperClass.getDriver();

	public DashboardAction() {

		DashboardLocators = PageFactory.initElements(HelperClass.getDriver(), DashboardLocators.class);
	}

	public void Navigate_to_Dashboard() {
		try {

			wait.until(ExpectedConditions.elementToBeClickable(DashboardLocators.TF_Dashboard));

			System.out.println("Clicking TF_Dashboard...");
			Thread.sleep(1000);
			DashboardLocators.TF_Dashboard.click();

		} catch (Exception e) {
			System.err.println("Error in Navigate_to_Dashboard: " + e.getMessage());
			//throw new RuntimeException(e);
		}
	}

	public void Validate_Add_Widget_button() {

		wait.until(ExpectedConditions.visibilityOf(DashboardLocators.TF_AddWidget));

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		DashboardLocators.TF_AddWidget.click();
		System.out.println("Clicked on add widget button");
	}

	public void uncheck_all_boxes_time_section_charts_and_fees_section_charts() throws InterruptedException {

		Thread.sleep(3000);

		WebDriverWait wait = HelperClass.getWait1();
		JavascriptExecutor js = (JavascriptExecutor) driver;

		boolean anyChecked = false;

		for (WebElement label : DashboardLocators.TF_AllWidgetCheckboxes) {
			try {
				WebElement input = label.findElement(By.tagName("input"));

				if (!label.isDisplayed())
					continue;
				js.executeScript("arguments[0].scrollIntoView(true);", label);

				boolean isChecked = (Boolean) js.executeScript("return arguments[0].checked;", input);

				if (isChecked) {
					anyChecked = true;

					js.executeScript("arguments[0].click();", label);
					System.out.println("Unchecked checkbox: " + label.getText());

					wait.until(driver1 -> !(Boolean) js.executeScript("return arguments[0].checked;", input));

				}

			} catch (Exception e) {
				System.err.println("Error unchecking widget: " + e.getMessage());
			}
		}

		if (anyChecked) {
			System.out.println("Unchecked all selected widgets.");
		} else {
			System.out.println("All widgets were already unchecked.");
		}
	}

	public void click_on_save_button() {

		wait.until(ExpectedConditions.elementToBeClickable(DashboardLocators.TF_SaveBtn)).click();
		System.out.println("Clicked Save button.");
	}

	public void Check_all_boxes_time_section_charts_and_fees_section_charts() throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(1000);

		DashboardLocators.TF_AddWidget.click();

		Thread.sleep(1000);
		boolean anyUnchecked = false;

		int count = driver.findElements(By.xpath("//label[contains(@class, 'mat-checkbox-layout')]")).size();

		for (int i = 0; i < count; i++) {
			try {
				WebElement checkbox = driver.findElements(By.xpath("//label[contains(@class, 'mat-checkbox-layout')]"))
						.get(i);

				if (!checkbox.isDisplayed())
					continue;

				WebElement input = checkbox.findElement(By.xpath(".//preceding-sibling::input[@type='checkbox']"));
				if (!input.isSelected()) {
					anyUnchecked = true;
					js.executeScript("arguments[0].click();", checkbox);
					Thread.sleep(200);
				}
			} catch (StaleElementReferenceException e) {
				System.err.println("Retrying due to stale element...");
				i--; 
			} catch (Exception e) {
				System.err.println("Error processing checkbox at index " + i + ": " + e.getMessage());
			}
		}

		if (anyUnchecked) {
			System.out.println("All unchecked checkboxes have been checked.");
		} else {
			System.out.println("All checkboxes were already selected.");
		}
	}

	public void scroll_to_view_and_verify() throws InterruptedException {
	    try {
	        Thread.sleep(2000);
	        // Expected widget titles
	        List<String> expectedWidgets = Arrays.asList(
	                "Summary", "Most vs Least by Profit & Working Hours", "Task Wise Hours Details", "Timer",
	                "Total Task Hours", "Billable & Non-billable Hours", "Time off Hours by Users", "Job Count by Status",
	                "Fees Summary", "By Invoiced Amount", "By Due Amount", "Invoice Amount by Category",
	                "Top 5 Clients by Invoice Amount", "Top 5 Clients With Balance", "Income Trend", "Revenue Flow",
	                "Amount Received by Payment Methods", "Estimates by Status and Amount", "Invoiced Amount by Status"
	        );

	        List<WebElement> widgetContainers = driver.findElements(
	                By.xpath("//div[@class='cdk-drag dashboard-card ng-star-inserted']")
	        );

	        List<String> actualWidgetNames = new ArrayList<>();

	        for (WebElement widget : widgetContainers) {
	            HelperClass.scrollIntoView(widget);
	            Thread.sleep(200);

	            try {
	                WebElement titleElement = widget.findElement(By.xpath(".//div[@class='dash-title']"));
	                String widgetTitle = titleElement.getText().trim();
	                actualWidgetNames.add(widgetTitle);
	                System.out.println("Found widget: " + widgetTitle);
	            } catch (Exception e) {
	                System.out.println("Widget title not found in one of the containers.");
	            }
	        }

	        System.out.println("\nTotal widgets found: " + actualWidgetNames.size());
	        HelperClass.captureAndAttachScreenshot(HelperClass.getScenarioTest(), "");

	        // Validation: ensure at least some expected widgets are visible
	        boolean hasExpectedWidgets = actualWidgetNames.stream().anyMatch(expectedWidgets::contains);

	        if (hasExpectedWidgets) {
	            Assert.assertTrue(true, "Dashboard widgets verified successfully. Found expected widgets.");
	            System.out.println("Dashboard widgets verified successfully.");
	        } else {
	            Assert.fail("No expected widgets were found on the Dashboard.");
	        }

	    } catch (Exception e) {
	        Assert.fail("Exception while verifying widgets on dashboard: " + e.getMessage());
	    }
	}


	public void Validate_each_value_of_dropdown_of_time_filter() throws InterruptedException {

		Map<String, String> screenshots = HelperClass.validateEachDropdownOptionAndCaptureScreenshot(
				DashboardLocators.TF_TimeFilterDropdown, DashboardLocators.TF_TimeFilterOptions, "Timefilter",
				"screenshots");

		for (Map.Entry<String, String> entry : screenshots.entrySet()) {
			Hooks.getScenarioTest().info("Screenshot for: " + entry.getKey(),
					MediaEntityBuilder.createScreenCaptureFromBase64String(entry.getValue()).build());
		}
	}

	public void Validate_lock_button() {

		wait.until(ExpectedConditions.elementToBeClickable(DashboardLocators.TF_Lockbtn)).click();
		System.out.println("Lock button clicked.");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		boolean allDisabled = true;

		for (WebElement widget : DashboardLocators.TF_AllWidgets) {
			String classAttr = widget.getAttribute("class");
			if (classAttr == null || !classAttr.contains("disabled")) {
				allDisabled = false;
				System.out.println("Widget not disabled: " + widget.getText());
			}
		}

		if (allDisabled) {
			System.out.println("All widgets are disabled as expected.");
		} else {
			System.out.println(" Some widgets are still enabled.");
		}

	}

	public void validate_the_timer_section() throws InterruptedException {
		Thread.sleep(4000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		HelperClass.scrollIntoView(DashboardLocators.TF_JobDropdown);
		DashboardLocators.TF_JobDropdown.click();
		System.out.println("Job dropdown clicked.");

		List<WebElement> jobOptions = wait
				.until(ExpectedConditions.visibilityOfAllElements(DashboardLocators.TF_JobDropdownOptions));

		if (!jobOptions.isEmpty()) {
			WebElement jobToSelect;

			if (jobOptions.size() > 1) {
				jobToSelect = jobOptions.get(1);
				System.out.println("Second job selected: " + jobToSelect.getText().trim());
			} else {
				jobToSelect = jobOptions.get(0);
				System.out.println("Only one job available. Selected: " + jobToSelect.getText().trim());
			}

			jobToSelect.click();
		} else {
			System.out.println("No job options found.");
			return;
		}

		HelperClass.scrollIntoView(DashboardLocators.TF_StartTimerBtn);
		wait.until(ExpectedConditions.elementToBeClickable(DashboardLocators.TF_StartTimerBtn)).click();
		System.out.println("First Start Timer clicked.");

		DashboardLocators.TF_SubTaskDropdown.click();
		System.out.println("Subtask dropdown opened.");

		try {
			WebElement subtaskOption = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@role='option'])[2]")));
			js.executeScript("arguments[0].click();", subtaskOption);
			System.out.println("Subtask 'Filling' selected.");
		} catch (Exception e) {
			System.out.println("Failed to select subtask: " + e.getMessage());
			return;
		}

		Thread.sleep(1000);

		try {
			WebElement secondStartBtn = wait
					.until(ExpectedConditions.elementToBeClickable(DashboardLocators.TF_SecondStartTimerBtn));
			js.executeScript("arguments[0].click();", secondStartBtn);
			System.out.println("Second Start Timer clicked.");
		} catch (Exception e) {
			System.out.println("Failed to click Second Start Timer: " + e.getMessage());
			return;
		}

		Thread.sleep(5000);

		try {
			WebElement stopBtn = wait.until(ExpectedConditions.elementToBeClickable(DashboardLocators.TF_StopTimerBtn));
			js.executeScript("arguments[0].click();", stopBtn);
			System.out.println("Timer stopped.");
		} catch (Exception e) {
			System.out.println("Failed to stop timer: " + e.getMessage());
		}
	}

	public void take_each_value_from_task_wise_hour_dropdown_and_take_screenshot(Scenario scenario)
			throws InterruptedException {
		Thread.sleep(4000);
		HelperClass.scrollIntoView(DashboardLocators.TF_Taskwisehourdropdown);
		Map<String, String> screenshots = HelperClass.validateEachDropdownOptionAndCaptureScreenshot(
				DashboardLocators.TF_Taskwisehourdropdown, DashboardLocators.TF_TimeFilterOptions, "Taskwise",
				"screenshots");
		for (Map.Entry<String, String> entry : screenshots.entrySet()) {
			Hooks.getScenarioTest().info("Screenshot for: " + entry.getKey(),
					MediaEntityBuilder.createScreenCaptureFromBase64String(entry.getValue()).build());
		}

	}

	public void take_each_value_from_task_hours_dropdown_and_take_screenshot() throws InterruptedException {
		Thread.sleep(4000);
		HelperClass.scrollIntoView(DashboardLocators.TF_Totaltaskhourdropdown);
		Map<String, String> screenshots = HelperClass.validateEachDropdownOptionAndCaptureScreenshot(
				DashboardLocators.TF_Totaltaskhourdropdown, DashboardLocators.TF_TimeFilterOptions, "TotalTask hour",
				"screenshots");
		for (Map.Entry<String, String> entry : screenshots.entrySet()) {
			Hooks.getScenarioTest().info("Screenshot for: " + entry.getKey(),
					MediaEntityBuilder.createScreenCaptureFromBase64String(entry.getValue()).build());
		}

	}

}
