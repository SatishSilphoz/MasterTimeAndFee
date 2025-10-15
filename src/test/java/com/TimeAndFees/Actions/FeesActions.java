package com.TimeAndFees.Actions;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.Capium.Utilites.ExcelUtil;
import com.Capium.Utilites.HelperClass;
import com.TimeAndFees.Locators.FeesLocators;
import com.TimeAndFees.Stepdefinations.Hooks;
import com.aventstack.extentreports.MediaEntityBuilder;

public class FeesActions {

	FeesLocators feesLocators = null;
	WebDriverWait wait = HelperClass.getWait();
	WebDriver driver = HelperClass.getDriver();
	private static int currentRow = 1;

	public FeesActions() {


		this.feesLocators = new FeesLocators();
		PageFactory.initElements(HelperClass.getDriver(), feesLocators);
	}

	public void Navigation_to_Fees_tab() throws InterruptedException {

		Thread.sleep(7000);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Fees']")));
		HelperClass.waitUntilVisible(wait, feesLocators.TF_Fees);
		HelperClass.ClickUsingJS(driver, feesLocators.TF_Fees);
	}

	public void navigate_to_invoice_sub_tab() throws InterruptedException {

		HelperClass.waitForLoaderToDisappear(30);
		HelperClass.waitUntilClickable(wait, feesLocators.TF_Invoice).click();		
	}

	public void click_on_add_invoice_button() {

		HelperClass.waitForLoaderToDisappear(30);
		HelperClass.waitUntilClickable(wait, By.xpath("//span[text()='Add Invoice']/ancestor::button")).click();	
	}

	public void fill_all_the_data_in_invoice() throws InterruptedException {
		String filePath = "D:\\TimeandFees_5.0\\src\\test\\resources\\invoice_data_template.xlsx";
		String sheetName = "Invoice";

		int totalRows = ExcelUtil.getRowCount(filePath, sheetName);

		// If row exceeds Excel limit, reset to 1
		if (currentRow >= totalRows) {
			currentRow = 1;
		}

		// Read data from Excel using the current row
		String client = ExcelUtil.getCellData(filePath, sheetName, currentRow, 0);
		String reference = ExcelUtil.getCellData(filePath, sheetName, currentRow, 1);
		String paymentDue = ExcelUtil.getCellData(filePath, sheetName, currentRow, 2);
		String job = ExcelUtil.getCellData(filePath, sheetName, currentRow, 3);
		String description = ExcelUtil.getCellData(filePath, sheetName, currentRow, 4);
		String qty = ExcelUtil.getCellData(filePath, sheetName, currentRow, 5);
		String price = ExcelUtil.getCellData(filePath, sheetName, currentRow, 6);
		String footer = ExcelUtil.getCellData(filePath, sheetName, currentRow, 7);

		// Fill client field and immediately handle popup
		Thread.sleep(2000);
		HelperClass.sendKeys(feesLocators.clientDropdown, client);

		// Handle confirmation popup if it appears after selecting client
		try {
			WebDriverWait wait = new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(5));
			WebElement popupOkButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//button[normalize-space()='OK' or normalize-space()='Yes' or contains(text(),'Confirm')]")
					));
			popupOkButton.click();
			System.out.println("Confirmation popup after client selection handled.");
		} catch (TimeoutException e) {
			System.out.println("No confirmation popup appeared after client selection.");
		}

		// Fill remaining fields
		Thread.sleep(2000);
		HelperClass.sendKeys(feesLocators.referenceField, reference);
		Thread.sleep(2000);
		HelperClass.sendKeys(feesLocators.paymentDue, paymentDue);
		Thread.sleep(2000);
		HelperClass.sendKeys(feesLocators.jobDropdown, job);
		Thread.sleep(2000);
		HelperClass.sendKeys(feesLocators.descriptionField, description);
		Thread.sleep(2000);
		HelperClass.sendKeys(feesLocators.qtyField, qty);
		Thread.sleep(2000);
		HelperClass.sendKeys(feesLocators.priceField, price);
		Thread.sleep(2000);
		HelperClass.sendKeys(feesLocators.footerField, footer);
		Thread.sleep(2000);

		System.out.println("Filled from Excel row: " + currentRow);

		// Move to next alternate row
		currentRow += 2;
	}


	public void click_on_the_save_and_exit() {
		HelperClass.waitForLoaderToDisappear(30);
		HelperClass.waitUntilClickable(wait, By.xpath("//span[text()=' Save and Exit ']/ancestor::button")).click();	

	}

	public void validate_each_value_of_status_filter() throws InterruptedException {
	    Map<String, String> screenshots = HelperClass.validateEachDropdownOptionAndCaptureScreenshot(
	            feesLocators.TF_StatusFilterDropdown,
	            feesLocators.TF_StatusFilterOptions,
	            "Status",
	            "screenshots"
	    );

	    if (screenshots != null && !screenshots.isEmpty()) {
	        Assert.assertTrue(true, "Status filter dropdown options validated successfully with screenshots.");
	        System.out.println("Status filter dropdown validated successfully.");
	    } else {
	        Assert.fail("Status filter dropdown validation failed! No screenshots were captured.");
	    }

	    for (Map.Entry<String, String> entry : screenshots.entrySet()) {
	        Hooks.getScenarioTest().info("Screenshot for: " + entry.getKey(),
	                MediaEntityBuilder.createScreenCaptureFromBase64String(entry.getValue()).build());
	    }
	}


	public void click_on_preview_icon() {

		HelperClass.waitUntilClickable(wait, By.xpath("//mat-icon[text()='visibility']")).click();


	}

	public void validate_preview_screen() throws InterruptedException {

		WebElement editPageContainer = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Preview estimate')]")));

		if (!editPageContainer.isDisplayed()) {
			throw new AssertionError("preview page did not appear.");
		}

		System.out.println("preview page is displayed successfully.");

		Thread.sleep(2000);
		HelperClass.captureAndAttachScreenshot(HelperClass.getScenarioTest(), "");


	}

	public void click_on_send() throws InterruptedException {
		Thread.sleep(2000);
		HelperClass.waitUntilClickable(wait, By.xpath("//span[contains(text(),'Send')]/ancestor::button")).click();
		Thread.sleep(4000);
		HelperClass.waitUntilClickable(wait, By.xpath("//span[contains(text(),'Send')]/ancestor::button")).click();


	}

	public void click_on_more_action() {

		HelperClass.waitUntilClickable(wait, By.xpath("//tbody//mat-icon[text()='more_vert']")).click();

	}

	public void click_on_record_payment_action() throws InterruptedException {

		HelperClass.waitUntilClickable(wait, By.xpath("//span[normalize-space()='Record Payment']/ancestor::button")).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Wait till page is loaded
		HelperClass.waitForLoaderToDisappear(10);

		// Fetch value from read-only Amount Due field
		Thread.sleep(4000);
		WebElement amountDueField = driver.findElement(By.xpath("//p[contains(text(),'Amount Due')]/following::input[1]"));
		String amountDue = (String) js.executeScript("return arguments[0].value;", amountDueField);

		// Input that value into Amount (GBP) field
		HelperClass.sendKeys(feesLocators.TF_Amountfield, amountDue);

	}

	public void click_on_export_action() throws InterruptedException {

		HelperClass.waitUntilClickable(wait, By.xpath("//span[text()='Export as PDF ']/ancestor::button")).click();
		Thread.sleep(2000);
		HelperClass.captureAndAttachScreenshot(HelperClass.getScenarioTest(), "");

	}

	public void click_on_copy_link_action() throws InterruptedException {

		HelperClass.waitUntilClickable(wait, By.xpath("//span[text()='Copy Link ']/ancestor::button")).click();
		Thread.sleep(2000);
		HelperClass.captureAndAttachScreenshot(HelperClass.getScenarioTest(), "");

	}

	public void click_on_duplicate_action() throws InterruptedException {
		HelperClass.waitUntilClickable(wait, By.xpath("//span[text()='Duplicate ']/ancestor::button")).click();
		Thread.sleep(2000);
		HelperClass.captureAndAttachScreenshot(HelperClass.getScenarioTest(), "");
	}

	public void click_on_invoice_id_hyperlink() throws InterruptedException {	
		Thread.sleep(2000);
		feesLocators = PageFactory.initElements(driver, FeesLocators.class); 
		HelperClass.waitUntilClickable(wait, By.xpath("//a[contains(@class, 'hyperlink')]")).click();
	}

	public void click_on_preview_button() {	
		HelperClass.waitUntilClickable(wait, By.xpath("//span[contains(text(),'Preview')]/ancestor::button")).click();
	}

	public void click_on_send_reminder_button() throws InterruptedException {
		HelperClass.waitUntilClickable(wait, By.xpath("//span[contains(text(),'Send Reminder')]/ancestor::button")).click();
		Thread.sleep(2000);
		HelperClass.waitUntilClickable(wait, By.xpath("//span[contains(text(),'Send')]/ancestor::button")).click();
	}

	public void click_on_add_note_button() throws InterruptedException {
		Thread.sleep(2000);
		HelperClass.waitUntilClickable(wait, By.xpath("//span[contains(text(),'Add Notes')]/ancestor::button")).click();
		HelperClass.sendKeysAndPressEnter(By.xpath("//textarea"), "This is an note for testing");
	}

	public void clcik_on_each_value_of_paginator() throws InterruptedException {

		Thread.sleep(2000);
		HelperClass.waitForLoaderToDisappear(10);

		// Desired order
		List<String> preferredOrder = Arrays.asList("100", "50", "20", "10");

		for (String optionText : preferredOrder) {
			feesLocators.TF_PageFilterDropdown.click();
			Thread.sleep(2000);

			boolean found = false;
			for (WebElement opt : feesLocators.TF_PageFilterOptions) {
				if (opt.getText().trim().equals(optionText)) {
					opt.click();
					System.out.println("Selected: " + optionText);
					found = true;

					Thread.sleep(2000); // Wait for update

					// Save screenshot
					String fileName = "screenshots/TaskWise_" + optionText.replaceAll("[^a-zA-Z0-9]", "_") + ".png";
					File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

					try {
						FileUtils.copyFile(screenshot, new File(fileName));
						System.out.println(" Screenshot saved: " + fileName);
					} catch (IOException e) {
						System.out.println("Error saving screenshot: " + e.getMessage());
					}

					// Attach to Extent Report and Cucumber Report
					String base64 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
					Hooks.getScenarioTest().info("Screenshot for: " + optionText,
							MediaEntityBuilder.createScreenCaptureFromBase64String(base64).build());
					break;
				}
			}

			if (!found) {
				System.out.println("Option not found: " + optionText);
			}
		}
	}

	public void click_on_next_button() {

		HelperClass.waitUntilVisible(wait, By.xpath("//mat-icon[text()='chevron_right']")).click();

	}

	public void click_on_previous_button() throws InterruptedException {

		Thread.sleep(2000);
		HelperClass.waitUntilVisible(wait, By.xpath("//mat-icon[text()='chevron_left']")).click();

	}

	public void add_recurring_details() throws InterruptedException {

		Thread.sleep(4000);
		HelperClass.scrollIntoView(feesLocators.TF_recurringtype);
		HelperClass.waitUntilClickable(wait, feesLocators.TF_recurringtype).click();
		HelperClass.ClickUsingJS(driver, By.xpath("//span[normalize-space()='Daily']"));
	}


	public void click_on_add_recurring_invoice_button() {

		HelperClass.waitForLoaderToDisappear(30);
		HelperClass.waitUntilClickable(wait, By.xpath("//span[text()='Add Recurring Invoice']/ancestor::button")).click();	

	}

	public void navigate_to_recurring_invoice_sub_tab() {

		HelperClass.waitForLoaderToDisappear(30);
		HelperClass.waitUntilClickable(wait, feesLocators.TF_RecurrInvoice).click();		

	}

	public void click_on_end_icon() {

		HelperClass.waitUntilClickable(wait, By.xpath("//mat-icon[text()='not_interested']")).click();
		HelperClass.waitUntilClickable(wait, By.xpath("//span[text()=' Yes ']/ancestor::button")).click();
	}

	public void click_on_pause_action() {

		HelperClass.waitUntilClickable(wait, By.xpath("//span[text()='Pause ']")).click();

	}

	public void click_on_play_action() {
		List<WebElement> rows = driver.findElements(By.xpath("//table//tbody//tr"));
		Actions actions = new Actions(driver);

		for (WebElement row : rows) {
			WebElement statusCell = row.findElement(By.xpath(".//td[last()]")); // Status column
			String statusText = statusCell.getText().trim();

			if (statusText.equalsIgnoreCase("Inactive (paused)")) {
				// Hover on row first to reveal hidden icons
				actions.moveToElement(row).perform();

				// Wait until play icon becomes visible after hover
				WebElement playIcon = new WebDriverWait(driver, Duration.ofSeconds(5))
						.until(ExpectedConditions.visibilityOf(
								row.findElement(By.xpath(".//mat-icon[normalize-space()='play_circle']"))
								));

				playIcon.click();
				break; 
			}
		}
	}

	//estimates
	public void fill_all_the_data_in_estimates() throws InterruptedException {

		String filePath = "D:\\TimeandFees_5.0\\src\\test\\resources\\invoice_data_template.xlsx";
		String sheetName = "Estimates";

		int totalRows = ExcelUtil.getRowCount(filePath, sheetName);

		// If row exceeds Excel limit, reset to 1
		if (currentRow >= totalRows) {
			currentRow = 1;
		}

		// Read data from Excel using the current row
		String client = ExcelUtil.getCellData(filePath, sheetName, currentRow, 0);
		String reference = ExcelUtil.getCellData(filePath, sheetName, currentRow, 1);
		String PO_ID = ExcelUtil.getCellData(filePath, sheetName, currentRow, 2);
		String job = ExcelUtil.getCellData(filePath, sheetName, currentRow, 3);
		String description = ExcelUtil.getCellData(filePath, sheetName, currentRow, 4);
		String qty = ExcelUtil.getCellData(filePath, sheetName, currentRow, 5);
		String price = ExcelUtil.getCellData(filePath, sheetName, currentRow, 6);
		String footer = ExcelUtil.getCellData(filePath, sheetName, currentRow, 7);

		// Fill client field and immediately handle popup
		Thread.sleep(2000);
		HelperClass.sendKeys(feesLocators.clientDropdown, client);

		// Handle confirmation popup if it appears after selecting client
		try {
			WebDriverWait wait = new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(5));
			WebElement popupOkButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//button[normalize-space()='OK' or normalize-space()='Yes' or contains(text(),'Confirm')]")
					));
			popupOkButton.click();
			System.out.println("Confirmation popup after client selection handled.");
		} catch (TimeoutException e) {
			System.out.println("No confirmation popup appeared after client selection.");
		}

		// Fill remaining fields
		Thread.sleep(2000);
		HelperClass.sendKeys(feesLocators.RefID_estimate, reference);
		Thread.sleep(2000);
		HelperClass.sendKeys(feesLocators.PO_ID, PO_ID);
		Thread.sleep(2000);
		HelperClass.sendKeys(feesLocators.jobDropdown, job);
		Thread.sleep(2000);
		HelperClass.sendKeys(feesLocators.descriptionField, description);
		Thread.sleep(2000);
		HelperClass.sendKeys(feesLocators.qtyField, qty);
		Thread.sleep(2000);
		HelperClass.sendKeys(feesLocators.priceField, price);
		Thread.sleep(2000);
		HelperClass.sendKeys(feesLocators.footerField, footer);
		Thread.sleep(2000);

		System.out.println("Filled from Excel row: " + currentRow);

		// Move to next alternate row
		currentRow += 2;

	}

	public void navigate_to_estimates_sub_tab() {
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Estimates']")));
		HelperClass.waitUntilVisible(wait, feesLocators.TF_Estimates);
		HelperClass.ClickUsingJS(driver, feesLocators.TF_Estimates);

	}

	public void click_on_add_estimates_button() {

		HelperClass.waitForLoaderToDisappear(30);
		HelperClass.waitUntilClickable(wait, By.xpath("//span[text()='Add Estimate']/ancestor::button")).click();	

	}

	public void click_on_accepted_button() {

		HelperClass.waitUntilClickable(wait, By.xpath("//mat-icon[contains(text(),'thumb_up')]")).click();	
	}

	public void click_on_draft_button() {

		HelperClass.waitUntilClickable(wait, By.xpath("(//div[@class='status-button ng-star-inserted']//mat-icon)[3]")).click();	
	}

	public void click_on_declined_button() {

		HelperClass.waitUntilClickable(wait, By.xpath("//mat-icon[contains(text(),'thumb_down')]")).click();	
	}

	public void click_on_Mark_as_sent_button() throws InterruptedException {

		HelperClass.waitUntilClickable(wait, By.xpath("//span[contains(text(),'Mark as Sent')]/ancestor::button")).click();	
		Thread.sleep(2000);
		HelperClass.waitForLoaderToDisappear(30);
		String status = HelperClass.getFirstRowStatusText();
		Assert.assertEquals(status, "Sent", "Status should be 'Sent' after clicking Mark as Sent.");
	}

	public void click_on_Mark_as_declined_button() throws InterruptedException {

		HelperClass.waitUntilClickable(wait, By.xpath("//span[contains(text(),'Mark as Decline')]/ancestor::button")).click();
		Thread.sleep(2000);
		HelperClass.waitForLoaderToDisappear(30);
		String status = HelperClass.getFirstRowStatusText();
		Assert.assertEquals(status, "Declined", "Status should be 'Declined' after clicking Mark as Decline.");
	}

	public void click_on_Mark_as_accepted_button() throws InterruptedException {

		HelperClass.waitUntilClickable(wait, By.xpath("//span[contains(text(),'Mark as Accepted')]/ancestor::button")).click();
		Thread.sleep(2000);
		HelperClass.waitForLoaderToDisappear(30);
		String status = HelperClass.getFirstRowStatusText();
		Assert.assertEquals(status, "Accepted", "Status should be 'Accepted' after clicking Mark as Accepted.");
	}

	public void click_on_Mark_as_copy_button() {

		HelperClass.waitUntilClickable(wait, By.xpath("//span[contains(text(),'Copy')]/ancestor::button")).click();	
	}

	public void click_on_plus_icon_of_dicount() throws InterruptedException {

		Thread.sleep(3000);

		HelperClass.waitUntilClickable(wait, By.xpath("(//mat-icon[contains(text(),'add_circle_outline')])[2]")).click();	

	}

	public void click_on_discount_button() {
		HelperClass.waitUntilClickable(wait, By.xpath("//button[contains(text(),'Discount')]")).click();	

	}

	public void add_the_name_of_discount() {
		HelperClass.sendKeysAndPressEnter(By.xpath("//input[contains(@formcontrolname,'discountName')]"), "Familydiscount");

	}

	public void select_pound_from_dropdown() throws InterruptedException {

		Thread.sleep(3000);
		HelperClass.waitUntilClickable(wait, By.xpath("//mat-select[contains(@panelclass,'myPanelClass')]")).click();
		HelperClass.waitUntilVisible(wait, By.xpath("//mat-option//span[contains(text(),'£')]")).click();


	}

	public void add_the_dicount_amount() {
		HelperClass.sendKeysAndPressEnter(By.xpath("//input[contains(@formcontrolname,'discountValue')]"), "5");

	}

	public void validate_dicount_display() throws InterruptedException {
		Thread.sleep(2000);
		HelperClass.validatepageloaded(By.xpath("//span[contains(text(),'£')]/ancestor::mat-select"), null);

	}

	public void select_percentage_from_dropdown() {
		HelperClass.waitUntilClickable(wait, By.xpath("//mat-select[contains(@panelclass,'myPanelClass')]")).click();
		HelperClass.waitUntilVisible(wait, By.xpath("//mat-option//span[contains(text(),'%')]")).click();

	}

	public void validate_dicount_percentage_display() throws InterruptedException {
		Thread.sleep(2000);
		HelperClass.validatepageloaded(By.xpath("//span[contains(text(),'%')]/ancestor::mat-select"), null);

	}

	public void validate_additional_cost_currency_display() throws InterruptedException {
		Thread.sleep(2000);
		HelperClass.validatepageloaded(By.xpath("//p[contains(text(),'Additional Cost (£)')]"), null);
	}

	public void validate_additional_cost_percentage_display() throws InterruptedException {
		Thread.sleep(2000);
		HelperClass.validatepageloaded(By.xpath("//p[contains(text(),'Additional Cost (%)')]"), null);

	}

	public void add_the_cost_amount() {

		HelperClass.sendKeysAndPressEnter(By.xpath("//input[contains(@formcontrolname,'costValue')]"), "5");
	}

	public void add_the_name_of_additional_cost() {

		HelperClass.sendKeysAndPressEnter(By.xpath("//input[contains(@formcontrolname,'costName')]"), "FuelCost");
	}

	public void click_on_add_cost_button() {

		HelperClass.waitUntilClickable(wait, By.xpath("//button[contains(text(),'Add Cost')]")).click();
	}

	public static void validate_all_invoice_fields_should_clear() {
		FeesLocators loc = new FeesLocators();
		PageFactory.initElements(HelperClass.getDriver(), loc);

		List<WebElement> fields = Arrays.asList(
				loc.clientDropdown,
				loc.referenceField,
				loc.paymentDue,
				loc.jobDropdown,
				loc.descriptionField,
				loc.qtyField,
				loc.priceField,
				loc.footerField
				);

		for (WebElement field : fields) {
			String tag = field.getTagName();
			String value = tag.equalsIgnoreCase("input") || tag.equalsIgnoreCase("textarea")
					? field.getAttribute("value")
							: field.getText();

			if (value != null && !value.trim().isEmpty()) {
				throw new AssertionError("Field is not cleared: " + field);
			}
		}
	}

	public static void validate_all_estimate_fields_should_clear() {
		FeesLocators loc = new FeesLocators();
		PageFactory.initElements(HelperClass.getDriver(), loc);

		List<WebElement> fields = Arrays.asList(
				loc.RefID_estimate,
				loc.PO_ID,
				loc.jobDropdown,
				loc.descriptionField,
				loc.qtyField,
				loc.priceField,
				loc.footerField
				);

		for (WebElement field : fields) {
			String tag = field.getTagName();
			String value = tag.equalsIgnoreCase("input") || tag.equalsIgnoreCase("textarea")
					? field.getAttribute("value")
							: field.getText();

			if (value != null && !value.trim().isEmpty()) {
				throw new AssertionError("Field is not cleared: " + field);
			}
		}


	}



	public void click_on_cross_icon() throws InterruptedException {
		Thread.sleep(2000);
		HelperClass.waitForLoaderToDisappear(30);
		WebElement crossIcon = driver.findElement(By.xpath("//mat-icon[normalize-space()='close']"));
		crossIcon.click();

		// If Yes button exists → click it
		if (driver.findElements(By.xpath("//button[normalize-space()='Yes']")).size() > 0) {
			driver.findElement(By.xpath("//button[normalize-space()='Yes']")).click();
		}

	}

	public void click_on_copy_button_in_checkbox() throws InterruptedException {
		HelperClass.waitUntilVisible(wait, By.xpath("//button[@name='Copy']")).click();

		HelperClass.validatepageloaded(By.xpath("//div[contains(@class,'alert-success') and contains(.,'Record copied successfully')]"), null);

	}

	public void click_on_mark_as_sent_on_checkbox() {
		HelperClass.waitUntilVisible(wait, By.xpath("//p[contains(text(),'Mark As Sent')]/ancestor::button")).click();

	}

	public void click_on_mark_as_declined_on_checkbox() {
		HelperClass.waitUntilVisible(wait, By.xpath("//p[contains(text(),'Mark As Decline')]/ancestor::button")).click();

	}

	public void click_on_mark_as_accepted_on_checkbox() {

		HelperClass.waitUntilVisible(wait, By.xpath("//p[contains(text(),'Mark As Accepted')]/ancestor::button")).click();
	}

	public void click_on_revart_status_on_checkbox() {
		HelperClass.waitUntilVisible(wait, By.xpath("//p[contains(text(),'Revert Status')]/ancestor::button")).click();

	}








}





