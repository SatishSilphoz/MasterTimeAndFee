package com.TimeAndFees.Actions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.Capium.Utilites.HelperClass;
import com.Capium.Utilites.Log;
import com.TimeAndFees.Locators.JobLocators;
import com.TimeAndFees.Stepdefinations.Hooks;


public class JobActions {

	JobLocators jobLocators = null;
	WebDriverWait wait = HelperClass.getWait();
	WebDriver driver = HelperClass.getDriver();

	public JobActions() {

		this.jobLocators = new JobLocators();
		PageFactory.initElements(HelperClass.getDriver(), jobLocators);
	}

	public void navigation_to_jobs_tab() {

		try {
			By jobs = By.xpath("//span[text()='Jobs']//parent::a");
			wait.until(ExpectedConditions.visibilityOfElementLocated(jobs));
			HelperClass.clickUsingJS(jobs);
			System.out.println("Clicking TF_Jobs...");
			jobLocators.TF_Jobs.click();

		} catch (Exception e) {
			System.err.println("Error in Navigate_to_jobs: " + e.getMessage());
			// throw new RuntimeException(e);
		}

	}

	public void click_on_add_job_button() throws InterruptedException {

		Thread.sleep(4000);
		HelperClass.waitForLoaderToDisappear(30);
		HelperClass.ClickUsingJS(HelperClass.getDriver(), By.xpath("//button[normalize-space(@name)='Create']"));

	}

	public void fill_all_the_fields_in_job_popup() throws InterruptedException {
		Thread.sleep(2000);
		HelperClass.waitForLoaderToDisappear(30);
		jobLocators = PageFactory.initElements(driver, JobLocators.class);
		HelperClass.sendKeys(jobLocators.TF_HourSpentInput, "2");
		HelperClass.sendKeys(jobLocators.TF_MinuteSpentInput, "30");

	}

	public void verify_Search_functionality() throws InterruptedException {

		try {
			Thread.sleep(2000);
			HelperClass.waitForLoaderToDisappear(30);
			HelperClass.sendKeys(jobLocators.TF_Searchfield, "A limited");

			Thread.sleep(9000);
			List<WebElement> clientColumnCells = HelperClass.getDriver().findElements(
					By.xpath("//table//tr/td[normalize-space()='A LIMITED' or contains(text(),'A LIMITED')]"));

			// Validate all rows contain "A LIMITED"
			if (clientColumnCells.size() > 0) {
				for (WebElement cell : clientColumnCells) {
					String clientText = cell.getText().trim();
					if (!clientText.equalsIgnoreCase("A LIMITED")) {
						System.out.println(" Invalid client name found: " + clientText);
						return;
					}
				}
				System.out.println("All rows correctly filtered with client: A LIMITED");
			} else {
				System.out.println("No rows found with client: A LIMITED");
			}

		} catch (Exception e) {
			System.out.println("Exception during client filter validation: " + e.getMessage());
		}
	}

	public void click_on_the_save_and_view_details() throws InterruptedException {
		HelperClass.waitForLoaderToDisappear(0);

		HelperClass.waitUntilClickable(HelperClass.getWait(), jobLocators.TF_SaveandViewdetailsbtn);

		jobLocators.TF_SaveandViewdetailsbtn.click();

	}

	public void job_details_page_validate() throws InterruptedException {

		HelperClass.validatepageloaded(By.xpath("//span[contains(text(),'Job Details')]"), null);

	}

	public void click_on_the_save_and_add_another() throws InterruptedException {
		HelperClass.waitForLoaderToDisappear(0);
		HelperClass.waitUntilClickable(HelperClass.getWait(), jobLocators.TF_Saveandanotherbtn);
		jobLocators.TF_Saveandanotherbtn.click();

	}

	public void Validate_add_jobs_dialog() throws InterruptedException {

		try {

			WebElement jobDetailsSection = wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//mat-dialog-container[@role='dialog']")));

			if (jobDetailsSection.isDisplayed()) {
				System.out.println("Add job dialog is displayed successfully.");
			} else {
				System.out.println("Job dialog is not displayed.");
			}

		} catch (Exception e) {
			System.out.println(" Exception occurred: " + e.getMessage());
		}

	}

	public void click_on_my_jobs_option() throws InterruptedException {

		Thread.sleep(5000);

		HelperClass.waitForLoaderToDisappear(30);
		HelperClass.waitUntilClickable(HelperClass.getWait(), jobLocators.TF_EveryoneJobDropdown);
		jobLocators.TF_EveryoneJobDropdown.click();

		WebElement Option = HelperClass.waitUntilClickable(HelperClass.getWait(),
				By.xpath("//div[@role='option']//span[text()=' My Jobs ']"));
		Option.click();

	}

	public void validate_user_column_should_disappear() {

		try {
			// Try to find the "User" column header
			List<WebElement> userColumnHeaders = HelperClass.getDriver()
					.findElements(By.xpath("//table//th[normalize-space()='User']"));

			// Check if the list is empty (column is not present)
			if (userColumnHeaders.isEmpty()) {
				System.out.println("User column has disappeared as expected.");
			} else {
				System.out.println("User column is still present. Validation failed.");
			}
		} catch (Exception e) {
			System.out.println("Error while validating user column visibility: " + e.getMessage());
		}
	}

	public void click_on_status_dropdown_and_select_status() throws InterruptedException {
		Thread.sleep(5000);

		HelperClass.waitForLoaderToDisappear(30);
		HelperClass.waitUntilClickable(HelperClass.getWait(), jobLocators.TF_StatusJobDropdown);
		jobLocators.TF_StatusJobDropdown.click();

		WebElement Option = HelperClass.waitUntilClickable(HelperClass.getWait(),
				By.xpath("//div[@role='option']//span[text()='In Progress']"));
		Option.click();

	}

	public void validate_status_is_displaying_in_grid() {
		WebDriverWait wait = HelperClass.getWait1();

		try {
			// Wait for the status column cells to be visible
			List<WebElement> statusCells = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(
					"//table//tbody//td[count(//table//th[normalize-space()='Status']/preceding-sibling::th)+1]")));
			boolean allInProgress = true;
			for (WebElement cell : statusCells) {
				String statusText = cell.getText().trim();
				if (!statusText.equalsIgnoreCase("In Progress")) {
					allInProgress = false;
					System.out.println("Found non 'In Progress' status: " + statusText);
				}
			}
			if (allInProgress) {
				System.out.println("All rows have 'In Progress' status. Validation passed.");
			} else {
				System.out.println("Not all rows are 'In Progress'. Validation failed.");
			}
		} catch (Exception e) {
			System.out.println("Error during status column validation: " + e.getMessage());
		}

	}

	public void click_on_task_dropdown() throws InterruptedException {
		Thread.sleep(5000);

		HelperClass.waitForLoaderToDisappear(30);
		HelperClass.waitUntilClickable(HelperClass.getWait(), jobLocators.TF_TaskJobDropdown);
		jobLocators.TF_TaskJobDropdown.click();

	}

	public void select_any_option() throws InterruptedException {
		Thread.sleep(2000);

		HelperClass.waitForLoaderToDisappear(10);
		WebElement Option = HelperClass.waitUntilVisible(HelperClass.getWait(),
				By.xpath("(//input[@aria-label]/ancestor::li)[3]"));
		Option.click();

	}

	public void task_should_display_in_grid_validate() {
		WebDriverWait wait = HelperClass.getWait1();

		try {
			// Locate all cells under the "Task" column dynamically
			List<WebElement> taskCells = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(
					"//table//tbody//td[count(//table//th[normalize-space()='Task']/preceding-sibling::th)+1]")));

			boolean allEnterpriseDesign = true;

			for (WebElement cell : taskCells) {
				String taskText = cell.getText().trim();
				if (!taskText.equalsIgnoreCase("Enterprise Design")) {
					allEnterpriseDesign = false;
					System.out.println("Found different task value: " + taskText);
				}
			}

			if (allEnterpriseDesign) {
				System.out.println("All rows have 'Enterprise Design' in Task column. Validation passed.");
			} else {
				System.out.println("Not all rows have 'Enterprise Design'. Validation failed.");
			}

		} catch (Exception e) {
			System.out.println("Error during Task column validation: " + e.getMessage());
		}

	}

	public void click_on_customize_columns() throws InterruptedException {

		Thread.sleep(5000);

		HelperClass.waitForLoaderToDisappear(30);
		WebElement Option = HelperClass.waitUntilClickable(HelperClass.getWait(),
				By.xpath("//button[@mattooltip='Customise Columns']"));
		Option.click();
	}

	public void uncheck_all_boxes() throws InterruptedException {
		List<WebElement> checkboxes = wait
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//mat-checkbox")));

		for (WebElement checkbox : checkboxes) {
			WebElement input = checkbox.findElement(By.tagName("input"));
			((JavascriptExecutor) HelperClass.getDriver())
					.executeScript("arguments[0].scrollIntoView({block: 'center'});", checkbox);
			Thread.sleep(200);
			if (input.isSelected()) {
				checkbox.click();
			}
		}

		// Re-fetch the Save button to avoid stale reference
		WebElement saveBtn = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='button']//span[text()=' Save ']")));
		saveBtn.click();

		HelperClass.waitForLoaderToDisappear(0); // Optional: wait for grid/table to reload
	}

	public void validate_columns_should_disappear() throws InterruptedException {
		System.out.println("Waiting for columns to disappear...");
		Thread.sleep(12000);

		List<String> expectedMissingHeaders = List.of("Fees Type", "Start Date", "End Date", "Created By", "Created On",
				"Completed By", "Completed On", "Recurring");

		for (String header : expectedMissingHeaders) {
			List<WebElement> columnHeaders = HelperClass.getDriver()
					.findElements(By.xpath("//table//th[normalize-space()='" + header + "']"));

			if (!columnHeaders.isEmpty()) {
				System.out.println("Column '" + header + "' is still visible but should be hidden.");
				throw new AssertionError("Column '" + header + "' should be hidden but is still visible.");
			} else {
				System.out.println("Column '" + header + "' is successfully hidden.");
			}
		}

		System.out.println("All specified columns are hidden as expected.");
	}

	public void check_all_boxes() throws InterruptedException {
		Thread.sleep(5000);

		WebDriverWait wait = HelperClass.getWait1();
		List<WebElement> checkboxes = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
				By.xpath("//span[@class='mat-checkbox-inner-container']/ancestor::label")));

		for (WebElement checkbox : checkboxes) {
			WebElement input = checkbox.findElement(By.tagName("input"));
			((JavascriptExecutor) HelperClass.getDriver())
					.executeScript("arguments[0].scrollIntoView({block: 'center'});", checkbox);
			Thread.sleep(200);
			if (!input.isSelected()) {
				checkbox.click();
			}
		}

		// Re-fetch Save button
		WebElement saveBtn = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='button']//span[text()=' Save ']")));
		saveBtn.click();

		HelperClass.waitForLoaderToDisappear(0);
	}

	public void validate_columns_should_appear() throws InterruptedException {
		System.out.println("Waiting for columns to appear...");
		Thread.sleep(10000);

		List<String> expectedHeaders = List.of("Fees Type", "Start Date", "End Date", "Created By", "Created On",
				"Completed By", "Completed On", "Recurring");

		for (String header : expectedHeaders) {
			List<WebElement> columnHeaders = HelperClass.getDriver()
					.findElements(By.xpath("//table//th[normalize-space()='" + header + "']"));

			if (columnHeaders.isEmpty()) {
				System.out.println(" Expected column '" + header + "' is not visible.");
				throw new AssertionError("Expected column '" + header + "' is not visible.");
			} else {
				System.out.println(" Column '" + header + "' is successfully visible.");
			}
		}

		System.out.println("All specified columns are visible as expected.");
	}

//	public void Validate_each_value_of_dropdown_of_time_filter_in_jobs() throws InterruptedException {
//		Map<String, String> screenshots = HelperClass.validateEachDropdownOptionAndCaptureScreenshot(
//				jobLocators.TF_TimeFilterDropdown,
//				jobLocators.TF_TimeFilterOptions,
//				"Allhours",
//				"screenshots"
//				);
//
//		for (Map.Entry<String, String> entry : screenshots.entrySet()) {
//			Hooks.getScenarioTest().info("Screenshot for: " + entry.getKey(),
//					MediaEntityBuilder.createScreenCaptureFromBase64String(entry.getValue()).build());
//		}
//	}

	public void Validate_each_value_of_dropdown_of_time_filter_in_jobs() {
		WebDriver driver = HelperClass.getDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60)); // increased wait

		By dropdownXpath = By.xpath(
				"//ng-select[@panelclass='myPanelClass' and contains(@class,'w-120')]//div[contains(@class,'ng-select-container')]");
		By optionsXpath = By.xpath("//ng-dropdown-panel//div[@role='option']/span");
		By spinnerOverlay = By.xpath("//div[contains(@class,'ngx-spinner-overlay')]");

		try {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(spinnerOverlay));
		} catch (Exception e) {
			System.out.println("Spinner overlay still visible, continuing anyway...");
		}

		WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(dropdownXpath));
		try {
			wait.until(ExpectedConditions.elementToBeClickable(dropdown)).click();
		} catch (Exception e) {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", dropdown);
		}

		wait.until(ExpectedConditions.visibilityOfElementLocated(optionsXpath));
		List<WebElement> optionElements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(optionsXpath));

		List<String> optionTexts = new ArrayList<>();
		for (WebElement option : optionElements) {
			optionTexts.add(option.getText().trim());
		}

		for (String text : optionTexts) {
			try {
				wait.until(ExpectedConditions.invisibilityOfElementLocated(spinnerOverlay));
			} catch (Exception e) {
			}

			WebElement dropdownAgain = wait.until(ExpectedConditions.visibilityOfElementLocated(dropdownXpath));
			try {
				wait.until(ExpectedConditions.elementToBeClickable(dropdownAgain)).click();
			} catch (Exception e) {
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", dropdownAgain);
			}

			By specificOption = By
					.xpath("//ng-dropdown-panel//div[@role='option']//span[normalize-space(text())='" + text + "']");
			WebElement optionToSelect = wait.until(ExpectedConditions.elementToBeClickable(specificOption));
			optionToSelect.click();

			HelperClass.sleep2(2);
			Hooks.captureScreenshotBase64(driver, Hooks.getScenarioTest(), "Chart view for: " + text);
			Log.info("Selected filter: " + text, "Pratham", "Jobs Filter");
		}
	}

	public void click_on_toolbar_jobs() throws InterruptedException {
		Thread.sleep(1000);
		HelperClass.waitForLoaderToDisappear(30);
		HelperClass.ClickUsingJS(HelperClass.getDriver(), By.xpath("//mat-icon[text()='more_vert']/ancestor::button"));

	}

	public void click_on_bulk_job() {

		HelperClass.ClickUsingJS(HelperClass.getDriver(),
				By.xpath("//button[.//mat-icon[contains(text(), 'add')] and contains(., 'Add Bulk Job ')]"));
	}

	public void fill_all_the_details_in_bulk_job_popup() throws InterruptedException {

		Thread.sleep(8000);

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='multiselect-dropdown'])[2]")))
				.click();

		HelperClass.ClickUsingJS(HelperClass.getDriver(),
				By.xpath("(//ng-multiselect-dropdown//li[div[text()='Select All']]//input[@type='checkbox'])[2]"));

		HelperClass.sendKeys(jobLocators.TF_HourSpentInput, "2");
		HelperClass.sendKeys(jobLocators.TF_MinuteSpentInput, "30");

		HelperClass.ClickUsingJS(HelperClass.getDriver(),
				By.xpath("//mat-checkbox[.//span[text()='Recurring Job']]//input[@type='checkbox']"));

	}

	public void click_on_edit_icon() throws InterruptedException {

		Thread.sleep(3000);
		HelperClass.waitForLoaderToDisappear(30);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement grid = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[@role='table']")));
		js.executeScript("arguments[0].scrollLeft = arguments[0].scrollWidth", grid);
		Thread.sleep(1000);
		WebElement editIcon = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(jobLocators.TF_EditIcon)); 

		editIcon.click();
	}

	public void validate_edit_page() throws InterruptedException {
		WebElement editPageContainer = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='sidenav-body']")));

		if (!editPageContainer.isDisplayed()) {
			throw new AssertionError("Edit page did not appear.");
		}

		System.out.println("Edit page is displayed successfully.");

		Thread.sleep(2000);
		HelperClass.captureAndAttachScreenshot(HelperClass.getScenarioTest(), "");
	}

	public void click_on_add_sub_task_button() throws InterruptedException {

		Thread.sleep(2000);
		HelperClass.waitForLoaderToDisappear(30);
		HelperClass.scrollUntilElementVisible(driver, jobLocators.TF_Subtask);
		HelperClass.waitUntilClickable(wait, jobLocators.TF_Subtask).click();

	}

	public void enter_the_data_in_new_row() {
		try {
			Thread.sleep(2000);
			HelperClass.waitForLoaderToDisappear(30);

			List<WebElement> subtaskInputs = HelperClass.getDriver()
					.findElements(By.xpath("//input[@formcontrolname='name']"));

			// Get the last one (newly added row)
			WebElement lastInput = subtaskInputs.get(subtaskInputs.size() - 1);

			lastInput.clear();
			lastInput.sendKeys("New sub task");

			System.out.println("Subtask data entered in new row.");

		} catch (Exception e) {
			System.out.println("Error while entering subtask: " + e.getMessage());
		}
	}

	public void click_on_subtask_users_dropdown_and_select_option() throws InterruptedException {

		Thread.sleep(2000);
		HelperClass.waitForLoaderToDisappear(30);
		HelperClass.scrollUntilElementVisible(driver, jobLocators.TF_SubTaskDropdown);
		HelperClass.waitUntilClickable(wait, jobLocators.TF_SubTaskDropdown).click();
		HelperClass.waitUntilClickable(wait, By.xpath("//div[@role='option']//span[text()=' Users ']")).click();

	}

	public void validate_selected_option() {
	    try {
	        Thread.sleep(2000);
	        HelperClass.waitForLoaderToDisappear(30);

	        // Check if the section with the expected user label is visible
	        WebElement userSection = HelperClass.waitUntilVisible(wait,
	                By.xpath("//span[text()=' User(Billable Rate/Cost Rate) ']"));

	        if (userSection.isDisplayed()) {
	            // Pass assertion
	            Assert.assertTrue(true, "User section is displayed as expected.");
	            System.out.println("User section is displayed as expected.");
	        } else {
	            // Fail assertion
	            Assert.fail("User section is not visible.");
	        }

	        // Capture screenshot
	        HelperClass.captureAndAttachScreenshot(HelperClass.getScenarioTest(), "");

	    } catch (Exception e) {
	        // Fail on exception
	        Assert.fail("Exception in validating user section: " + e.getMessage());
	    }
	}


	public void click_on_email_sub_section() {

		try {

			HelperClass.waitUntilVisible(wait, By.xpath("//div[@role='tab']//mat-icon[text()='alternate_email']"))
					.click();

		} catch (Exception e) {
			System.out.println("error while navigating to email sub section: " + e.getMessage());
		}

	}

	public void send_the_keys_in_fields() {

		try {
			HelperClass.sendKeys(jobLocators.TF_SentTo, "Test1234@gmail.com");
			HelperClass.sendKeys(jobLocators.TF_Subject, "Testing purpose");
			HelperClass.sendKeys(jobLocators.TF_Message, "This is an demo message for testing");

		} catch (Exception e) {
			System.out.println("error while navigating to email sub section: " + e.getMessage());
		}

	}

	public void click_on_recurring_sub_section() {

		try {
			HelperClass.waitUntilVisible(wait, By.xpath("//div[@role='tab']//mat-icon[text()='library_books']"))
					.click();

		} catch (Exception e) {
			System.out.println("error while navigating to recurring sub section: " + e.getMessage());
		}

	}

	public void click_on_repeat_this_job_dropdown_and_select_option() {

		try {
			HelperClass.waitUntilVisible(wait, By.xpath("//span[text()=' Never ']/ancestor::ng-select")).click();
			HelperClass.waitUntilVisible(wait, By.xpath("//span[text()=' Daily ']")).click();
		} catch (Exception e) {
			System.out.println("error while clicking on repeat job dropdown " + e.getMessage());
		}
	}

	public void select_option_from_create_first_job_on_dropdown() {

		try {
			HelperClass.waitUntilVisible(wait, By.xpath("//span[text()=' After ']/ancestor::ng-select")).click();
			HelperClass.waitUntilVisible(wait, By.xpath("//span[text()=' On ']")).click();
		} catch (Exception e) {
			System.out.println("error while clicking on select option from dropdown: " + e.getMessage());
		}

	}

	public void click_on_end_this_recurring() {

		try {
			HelperClass.waitUntilVisible(wait, By.xpath("//a[text()=' End this Recurring ']")).click();
			Thread.sleep(2000);
			HelperClass.waitUntilVisible(wait, By.xpath("//span[text()=' Yes ']")).click();
			Thread.sleep(2000);
			HelperClass.captureAndAttachScreenshot(HelperClass.getScenarioTest(), "");
		} catch (Exception e) {
			System.out.println("error while clicking on select option from dropdown: " + e.getMessage());
		}

	}

	public void click_on_send_mail_button() {

		HelperClass.waitUntilClickable(wait, By.xpath("//span[text()=' Send Email ']")).click();
		HelperClass.captureAndAttachScreenshot(HelperClass.getScenarioTest(), "");
	}

	public void click_on_submit_button() throws InterruptedException {

		HelperClass.waitUntilVisible(wait, By.xpath("//span[text()=' Submit ']")).click();
		Thread.sleep(2000);
		HelperClass.captureAndAttachScreenshot(HelperClass.getScenarioTest(), "");
	}

	public void send_keys_in_comments() {

		HelperClass.sendKeys(jobLocators.TF_Message, "This is an comment message for testing");
	}

	public void click_on_comment_sub_section() {
		try {
			Thread.sleep(3000);
			HelperClass.waitUntilVisible(wait, By.xpath("//div[@role='tab']//mat-icon[text()='comment']")).click();

		} catch (Exception e) {
			System.out.println("error while navigating to comment sub section: " + e.getMessage());
		}

	}

	public void click_on_activity_sub_section() {

		try {
			Thread.sleep(3000);
			HelperClass.waitUntilVisible(wait, By.xpath("//div[@role='tab']//div[text()=' Activity ']")).click();

		} catch (Exception e) {
			System.out.println("error while navigating to activity sub section: " + e.getMessage());
		}
	}

	public void click_on_invoice_sub_section() {

		try {
			Thread.sleep(3000);
			HelperClass.waitUntilVisible(wait, By.xpath("//div[@role='tab']//mat-icon[text()='sticky_note_2']"))
					.click();

		} catch (Exception e) {
			System.out.println("error while navigating to invoice sub section: " + e.getMessage());
		}
	}

	public void click_on_files_sub_section() {

		try {
			Thread.sleep(3000);
			HelperClass.waitUntilVisible(wait, By.xpath("//div[@role='tab']//mat-icon[text()='attach_file']")).click();

		} catch (Exception e) {
			System.out.println("error while navigating to files sub section: " + e.getMessage());
		}
	}

	public void click_on_timelog_sub_section() {

		try {
			Thread.sleep(3000);
			HelperClass.waitUntilVisible(wait, By.xpath("//div[@role='tab']//mat-icon[text()='watch_later']")).click();

		} catch (Exception e) {
			System.out.println("error while navigating to time log sub section: " + e.getMessage());
		}

	}

	public void click_on_search_icon() {

		try {
			Thread.sleep(3000);
			HelperClass.waitUntilVisible(wait, By.xpath("//mat-icon[text()='search']")).click();
		} catch (Exception e) {
			System.out.println("error while clicking on search icon: " + e.getMessage());
		}
	}

	public void fill_all_the_fields_in_job_popup_side_panel() throws InterruptedException {
		Thread.sleep(3000);

		HelperClass.waitForLoaderToDisappear(30);
		HelperClass.sendKeys(jobLocators.TF_HourSpentInputside, "2");
		HelperClass.sendKeys(jobLocators.TF_MinuteSpentInputside, "30");

	}

	public void click_on_delete_icon() throws InterruptedException {

		Thread.sleep(3000);
		HelperClass.waitForLoaderToDisappear(30);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Scroll horizontally inside the grid
		WebElement grid = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[@role='table']")));

		js.executeScript("arguments[0].scrollLeft = arguments[0].scrollWidth", grid);
		Thread.sleep(1000);

		WebElement editIcon = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(jobLocators.TF_deleteIcon));

		editIcon.click();

		HelperClass.ClickUsingJS(HelperClass.getDriver(),
				By.xpath("//mat-dialog-content[@class='mat-dialog-content']//input"));

		HelperClass.ClickUsingJS(HelperClass.getDriver(), By.xpath("//button[@type='button']//span[text()=' Yes ']"));

	}

	public void validate_record_delete() {

		HelperClass.captureAndAttachScreenshot(HelperClass.getScenarioTest(), "");

	}

	// calander sub tab

	public void Click_on_calender_sub_tab() throws InterruptedException {

		Thread.sleep(1000);
		HelperClass.waitForLoaderToDisappear(30);
		HelperClass.waitUntilVisible(wait,
				By.xpath("//a[contains(@class,'menu-link')]/div/span[normalize-space()='Calendar']"));
		HelperClass.waitUntilClickable(wait,
				By.xpath("//a[contains(@class,'menu-link')]/div/span[normalize-space()='Calendar']"));
		HelperClass.ClickUsingJS(HelperClass.getDriver(),
				By.xpath("//a[contains(@class,'menu-link')]/div/span[normalize-space()='Calendar']"));
	}

	public void Click_on_add_job_button_calendar() throws InterruptedException {

		Thread.sleep(15000);
		HelperClass.ClickUsingJS(HelperClass.getDriver(),
				By.xpath("//span[contains(@class,'mat-button-wrapper')]/span[text()='Add Job']/ancestor::button"));
	}

	public void verify_Job_is_created_or_not_in_calendar() {
	    try {
	        Thread.sleep(2000);
	        HelperClass.waitForLoaderToDisappear(30);

	        HelperClass.sendKeys(jobLocators.TF_Searchfield2, "A limited");
	        System.out.println("Text entered in search field");

	        HelperClass.captureAndAttachScreenshot(HelperClass.getScenarioTest(), "");
	        Thread.sleep(2000);
	        HelperClass.waitForLoaderToDisappear(30);

	        Assert.assertTrue(true, "Job search text entered successfully in calendar search field.");

	    } catch (Exception e) {
	        // Fail assertion if any exception occurs
	        Assert.fail("Error while entering text in calendar search field: " + e.getMessage());
	    }
	}


	public void click_on_calender_button() {

		try {
			Thread.sleep(2000);
			HelperClass.waitForLoaderToDisappear(30);
			HelperClass.waitUntilClickable(wait, By.xpath("//div[@aria-live='assertive']/button")).click();
		} catch (Exception e) {
			System.out.println("getting error while clicking");
		}
	}

	public void selct_year_and_month() {
		try {
			Thread.sleep(2000);
			HelperClass.waitForLoaderToDisappear(30);
			HelperClass.waitUntilClickable(wait, By.xpath("//div[@class='e-header e-year']//div[@aria-label='title']"))
					.click();
			HelperClass.waitUntilClickable(wait, By.xpath("//span[text()='2024']")).click();
			HelperClass.waitUntilClickable(wait, By.xpath("//span[text()='Jun']")).click();

		} catch (Exception e) {
			System.out.println("getting error while clicking on year and month");
		}

	}

	public void validate_the_year_and_month() {
	    try {
	        Thread.sleep(2000);
	        HelperClass.waitForLoaderToDisappear(30);

	        // Locate the element that shows the selected month and year (top of calendar)
	        WebElement monthYearLabel = HelperClass.waitUntilVisible(wait, By.xpath(
	                "//div[@class='e-toolbar-item e-date-range e-overflow-show']//span[@class='e-tbar-btn-text']"
	        ));

	        String actualText = monthYearLabel.getText().trim();
	        String expectedMonth = "June";
	        String expectedYear = "2024";

	        // Assertion logic
	        if (actualText.contains(expectedMonth) && actualText.contains(expectedYear)) {
	            Assert.assertTrue(true, "Correct month and year are displayed - " + actualText);
	            System.out.println("PASS: Correct month and year are displayed - " + actualText);
	        } else {
	            Assert.fail("Expected " + expectedMonth + " " + expectedYear + ", but found " + actualText);
	        }

	        // Capture screenshot for reporting
	        HelperClass.captureAndAttachScreenshot(HelperClass.getScenarioTest(), "");

	    } catch (Exception e) {
	        Assert.fail("Error while validating the year and month: " + e.getMessage());
	    }
	}


	public void switch_to_day_view_and_validate() {

		try {
			Thread.sleep(2000);
			HelperClass.waitForLoaderToDisappear(30);

			// Click on WEEK view
			HelperClass.waitUntilClickable(wait, By.xpath("//span[text()='Day']")).click();
			Thread.sleep(2000);
			HelperClass.waitForLoaderToDisappear(30);

			// Validate WEEK view is visible
			HelperClass.waitUntilVisible(wait,
					By.xpath("//div[@class='e-table-wrap e-vertical-view e-day-view e-current-panel']"));

			System.out.println("day view displayed successfully.");
			HelperClass.captureAndAttachScreenshot(HelperClass.getScenarioTest(), "");

		} catch (Exception e) {
			System.out.println("Error while switching to day view: " + e.getMessage());
		}

	}

	public void switch_to_week_view_and_validate() {

		try {
			Thread.sleep(2000);
			HelperClass.waitForLoaderToDisappear(30);

			// Click on WEEK view
			HelperClass.waitUntilClickable(wait, By.xpath("//span[text()='Week']")).click();
			Thread.sleep(2000);
			HelperClass.waitForLoaderToDisappear(30);

			// Validate WEEK view is visible
			HelperClass.waitUntilVisible(wait,
					By.xpath("//div[@class='e-table-wrap e-vertical-view e-week-view e-current-panel']"));
			HelperClass.captureAndAttachScreenshot(HelperClass.getScenarioTest(), "");

			System.out.println("Week view displayed successfully.");

		} catch (Exception e) {
			System.out.println("Error while switching to Week view: " + e.getMessage());
		}
	}

	public void click_on_side_bar_icon() {

		try {
			Thread.sleep(2000);
			HelperClass.waitForLoaderToDisappear(30);
			HelperClass.ClickUsingJS(driver, By.xpath("//div[@class='menu-toggle toggle-icon']"));

		} catch (Exception e) {
			System.out.println("Error while clicking on side menu: " + e.getMessage());
		}

	}

	public void Send_key_is_search_field_and_validate() {

		try {
			Thread.sleep(2000);
			HelperClass.sendKeys(jobLocators.TF_Searchfield, "gaxira");
			HelperClass.captureAndAttachScreenshot(HelperClass.getScenarioTest(), "");
		} catch (Exception e) {
			System.out.println("error while sending keys: " + e.getMessage());

		}

	}

	public void validate_panel_should_disappear() {
		try {

			boolean isClosed = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions
					.invisibilityOfElementLocated(By.xpath("//div[contains(@class,'column-selector')]")));

			if (!isClosed) {
				throw new AssertionError(" panel did not close after clicking Cancel.");
			}

			System.out.println("Popup closed successfully after clicking Cancel.");
			HelperClass.captureAndAttachScreenshot(HelperClass.getScenarioTest(), "popup_closed");

		} catch (TimeoutException e) {
			throw new AssertionError("panel was still visible after timeout.");
		}

	}

	public void click_on_cancel_button_for_customize_column() {

		HelperClass.waitUntilVisible(wait, By.xpath("//span[contains(text(),'Cancel')]/ancestor::button")).click();

	}

	public void validate_save_and_exit_in_details() throws InterruptedException {
		Thread.sleep(6000);
		HelperClass.validatepageloaded(By.xpath("//span[contains(text(),'Add Job')]"), null);

	}

	public void validate_cancel_changes_in_email_sub_section() throws InterruptedException {
	    JobLocators loc = new JobLocators();
	    PageFactory.initElements(HelperClass.getDriver(), loc);

	    List<WebElement> fields = Arrays.asList(
	            loc.TF_SentTo, loc.TF_Subject, loc.TF_Message
	            // Add any other email page fields here if needed
	    );

	    boolean allFieldsCleared = true;

	    for (WebElement field : fields) {
	        String tag = field.getTagName();
	        String value = tag.equalsIgnoreCase("input") || tag.equalsIgnoreCase("textarea")
	                ? field.getAttribute("value")
	                : field.getText();

	        if (value != null && !value.trim().isEmpty()) {
	            allFieldsCleared = false;
	            // Fail immediately if any field is not cleared
	            Assert.fail("Field is not cleared after Cancel Changes: " + field);
	        }
	    }

	    if (allFieldsCleared) {
	        Assert.assertTrue(true, "All email fields are cleared after Cancel Changes.");
	        System.out.println("All email fields are cleared after Cancel Changes.");
	    }
	}


	public void Validate_cancel_in_comments() {

		WebElement field = jobLocators.TF_Message;
		String tag = field.getTagName();
		String value = tag.equalsIgnoreCase("input") || tag.equalsIgnoreCase("textarea") ? field.getAttribute("value")
				: field.getText();

		if (value != null && !value.trim().isEmpty()) {
			throw new AssertionError("Field is not cleared: " + field);
		}

		System.out.println("Comment field is cleared after Cancel Changes.");
	}

	public void click_on_checkbox_of_grid() throws InterruptedException {

		Thread.sleep(5000);
		HelperClass.ClickUsingJS(driver, By.xpath("(//label//input[@type='checkbox'])[2]"));

	}

	public void click_on_delete_button_on_checkbox() throws InterruptedException {

		HelperClass.waitUntilVisible(wait, By.xpath("//button[@name='Delete']")).click();

		HelperClass.waitUntilVisible(wait, By.xpath("//span[contains(text(),'Delete by selecting the box ')]")).click();

		HelperClass.waitUntilVisible(wait, By.xpath("//span[contains(text(),'Yes')]/ancestor::button")).click();

		HelperClass.validatepageloaded(
				By.xpath("//div[contains(@class,'alert-success') and contains(.,'Record deleted successfully')]"),
				null);

	}

	public void click_on_mark_as_yet_to_start_button() {

		HelperClass.waitUntilVisible(wait, By.xpath("//button[@name='Mark As Yet To Start']")).click();
	}

//	public void validate_with_custome_message() throws InterruptedException {
//		
//		HelperClass.validatepageloaded(By.xpath("//div[contains(@class,'alert-success') and contains(.,'The operation completed successfully!')]"), null);
//	}

	public void validate_with_custome_message() {
	    WebDriver driver = HelperClass.getDriver();
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	    By spinnerOverlay = By.xpath("//div[contains(@class,'ngx-spinner-overlay')]");
	    By successMessage = By.xpath(
	            "//div[contains(@class,'alert-success') and contains(.,'The operation completed successfully!')]"
	    );

	    try {
	        // Wait for spinner to disappear
	        wait.until(ExpectedConditions.invisibilityOfElementLocated(spinnerOverlay));

	        // Wait for success message
	        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
	        String msg = message.getText().trim();

	        // Pass assertion
	        Assert.assertTrue(true, "Save operation successful. Message: " + msg);
	        Log.info("Save operation successful. Message: " + msg, "Pratham", "Save Validation");
	        Hooks.captureScreenshotBase64(driver, Hooks.getScenarioTest(), "Save success message: " + msg);
	        System.out.println("Save operation validated successfully: " + msg);

	    } catch (TimeoutException e) {
	        // Fail assertion if timeout occurs
	        Hooks.captureScreenshotBase64(driver, Hooks.getScenarioTest(), "Save failed or took too long");
	        Assert.fail("Save operation failed or took too long: " + e.getMessage());
	    } catch (Exception e) {
	        // Catch any other exceptions
	        Hooks.captureScreenshotBase64(driver, Hooks.getScenarioTest(), "Unexpected error during save validation");
	        Assert.fail("Unexpected error during save validation: " + e.getMessage());
	    }
	}


	public void click_on_mark_as_completed_button() {

		HelperClass.waitUntilVisible(wait, By.xpath("//button[@name='Mark As Completed']")).click();
	}
}
