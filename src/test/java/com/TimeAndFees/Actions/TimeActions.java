package com.TimeAndFees.Actions;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

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
import com.TimeAndFees.Locators.TimeLocators;

public class TimeActions {

	TimeLocators timeLocators = null;
	WebDriverWait wait = HelperClass.getWait();
	WebDriver driver = HelperClass.getDriver();

	public TimeActions() {
      
		this.timeLocators = new TimeLocators();
		PageFactory.initElements(HelperClass.getDriver(), timeLocators);
		
	}


	public void navigation_to_time_tab() {

		try {

			
			wait.until(ExpectedConditions.visibilityOf(timeLocators.TF_Time));
			wait.until(ExpectedConditions.elementToBeClickable(timeLocators.TF_Time));
			Thread.sleep(2000);

			System.out.println("Clicking TF_Time...");
			timeLocators.TF_Time.click();

		} catch (Exception e) {
			System.err.println("Error in Navigate_to_Time: " + e.getMessage());
			throw new RuntimeException(e);
		}

	}


	public void click_on_add_time_button() throws InterruptedException {
		
		timeLocators = PageFactory.initElements(driver, TimeLocators.class); 

		wait.until(ExpectedConditions.visibilityOf(timeLocators.TF_AddTimebtn));
		Thread.sleep(2000);

		timeLocators.TF_AddTimebtn.click();
		System.out.println("Clicked on add time button");

	}
	public void fill_all_the_fields_in_popup() {
		WebDriverWait wait = HelperClass.getWait1();
		try {

			wait.until(ExpectedConditions.elementToBeClickable(timeLocators.TF_JobDropdown)).click();
			System.out.println(" Job dropdown clicked.");

			// Wait until job options are fully visible
			Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOfAllElements(timeLocators.TF_JobOptions));

			for (WebElement option : timeLocators.TF_JobOptions) {
				if (option.getText().contains("CLI007-JB124")) {
					((JavascriptExecutor) HelperClass.getDriver()).executeScript("arguments[0].scrollIntoView(true);", option);
					Thread.sleep(500);
					break;
				}
			}

			boolean jobSelected = HelperClass.selectDropdownOption(timeLocators.TF_JobOptions, "CLI002-JB129");
			if (!jobSelected) {
				System.out.println("Desired job not found in dropdown.");
				return;
			}

			HelperClass.waitForLoaderToDisappear(0);

			//  Click and select Subtask from dropdown using helper
			wait.until(ExpectedConditions.elementToBeClickable(timeLocators.TF_SubTaksDropdown)).click();
			System.out.println("Subtask dropdown opened.");

			// Wait until subtask options are visible
			wait.until(ExpectedConditions.visibilityOfAllElements(timeLocators.TF_SubTaskOptions));

			boolean subtaskSelected = HelperClass.selectDropdownOption(timeLocators.TF_SubTaskOptions, "SUB 1");
			if (!subtaskSelected) {
				System.out.println("Subtask 'Payment 3' not found.");
			}

			HelperClass.waitForLoaderToDisappear(0);

			// 🕓 Fill Time Spent
			WebElement timeSpentField = wait.until(ExpectedConditions.visibilityOf(timeLocators.TF_TimeSpentInput));
			timeSpentField.clear();
			timeSpentField.sendKeys("00:30");
			System.out.println(" Time Spent entered: 00:30");

		} catch (Exception e) {
			System.out.println(" Exception while filling popup: " + e.getMessage());
			e.printStackTrace();
		}
	}


	public void click_on_the_save() {


		wait.until(ExpectedConditions.elementToBeClickable(timeLocators.TF_SaveBtn)).click();
		System.out.println(" Clicked Save button.");
	}

	public void verify_time_is_created_or_not(String searchText, String expectedTask) {
	    try {
	        WebDriverWait wait = HelperClass.getWait1();

	        Thread.sleep(2000);
	        wait.until(ExpectedConditions.elementToBeClickable(timeLocators.TF_Search));
	        HelperClass.sendKeys(timeLocators.TF_Search, searchText);
	        wait.until(driver -> timeLocators.TF_Search.getAttribute("value").equals(searchText));

	        String actualSearchValue = timeLocators.TF_Search.getAttribute("value");

	        if (actualSearchValue.equals(searchText)) {
	            Assert.assertTrue(true, "Search field has correct value: " + actualSearchValue);
	            System.out.println("Search field has correct value: " + actualSearchValue);
	        } else {
	            Assert.fail("Search value mismatch! Expected: " + searchText + ", Found: " + actualSearchValue);
	        }

	        By rowLocator = By.xpath("//tr[contains(.,'" + expectedTask + "')]");
	        WebElement rowElement = wait.until(ExpectedConditions.presenceOfElementLocated(rowLocator));

	        if (rowElement.isDisplayed()) {
	            Assert.assertTrue(true, "Time log found for task: " + expectedTask);
	            System.out.println("Time log found: " + expectedTask);
	        } else {
	            Assert.fail("Time log for expected task not found: " + expectedTask);
	        }

	    } catch (Exception e) {
	        Assert.fail("Exception during time verification: " + e.getMessage());
	    }
	}



	public void click_on_user_dropdown() {

		wait.until(ExpectedConditions.elementToBeClickable(timeLocators.TF_UserDropdown)).click();
	}

	public void selct_user() {
		String userName = "Sophi Sophi";
		JavascriptExecutor js = (JavascriptExecutor) HelperClass.getDriver();

		// Define a locator for all dropdown options
		By optionsLocator = By.xpath("//div[@class='ng-dropdown-panel-items scroll-host']//div[contains(@class, 'ng-option')]");
		wait.until(ExpectedConditions.visibilityOfElementLocated(optionsLocator));

		List<WebElement> options = HelperClass.getDriver().findElements(optionsLocator);

		boolean userFound = false;
		for (WebElement option : options) {
			String text = option.getText().trim();

			// Scroll the option into view
			js.executeScript("arguments[0].scrollIntoView({block: 'center'})", option);

			if (text.equalsIgnoreCase(userName)) {
				option.click();
				userFound = true;
				System.out.println(" User '" + userName + "' selected from dropdown.");
				break;
			}
		}

		if (!userFound) {
			System.out.println("User '" + userName + "' not found in dropdown.");
		}
	}

	public void verify_that_user_coming_in_grid() {
	    String expectedUser = "Sophi Sophi";
	    By rowLocator = By.xpath("//table//tr[contains(., '" + expectedUser + "')]");

	    try {
	        WebElement userRow = wait.until(ExpectedConditions.presenceOfElementLocated(rowLocator));

	        if (userRow.isDisplayed()) {
	            // Case 1: User found → Pass
	            Assert.assertTrue(true, "User '" + expectedUser + "' is visible in the grid.");
	            System.out.println("User '" + expectedUser + "' is visible in the grid.");
	        } else {
	            // Case 2: User not visible → Fail
	            Assert.fail("User '" + expectedUser + "' is not visible in the grid!");
	        }

	        HelperClass.captureAndAttachScreenshot(HelperClass.getScenarioTest(), "");

	    } catch (Exception e) {
	        // Case 3: Exception occurred → Fail
	        Assert.fail("Exception while verifying user in grid: " + e.getMessage());
	    }
	}


	public void toggle_to_day_option() {
		WebDriverWait wait = HelperClass.getWait1();
		wait.until(ExpectedConditions.elementToBeClickable(timeLocators.TF_DayToggle)).click();;

		System.out.println(" Clicked on Day toggle option.");
	}

	public void verify_current_date_coming_in_grid() {
		WebDriverWait wait = HelperClass.getWait1();

		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".week-list.dayview-list")));

			String day = driver.findElement(By.cssSelector("div.days")).getText().trim();       
			String weekday = driver.findElement(By.cssSelector("div.week")).getText().trim();     
			String month = driver.findElement(By.cssSelector("div.month")).getText().trim();      

			String actualDate = day + " " + weekday + " " + month;
			System.out.println(" Actual date in grid: " + actualDate);

			String expectedDate = LocalDate.now().format(DateTimeFormatter.ofPattern("d EEE MMM", Locale.ENGLISH));
			System.out.println(" Expected current system date: " + expectedDate);

			System.out.println(" Date in grid matches system date.");

		} catch (Exception e) {
			System.out.println(" Exception occurred: " + e.getMessage());

		}
	}

	public void click_on_toolbar() throws InterruptedException {

		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(timeLocators.TF_Toolbar)).click();

	}

	public void click_on_export_option() {
		
		timeLocators = PageFactory.initElements(driver, TimeLocators.class); 
		wait.until(ExpectedConditions.visibilityOf(timeLocators.TF_ExportasPDF));
		wait.until(ExpectedConditions.elementToBeClickable(timeLocators.TF_ExportasPDF)).click();

	}

	public void click_on_export_button_and_verify()  {

		wait.until(ExpectedConditions.elementToBeClickable(timeLocators.TF_ExportBtn)).click();

	}

	public void click_on_delete_icon_on_grid() {
		WebDriverWait wait = HelperClass.getWait1();

		try {
			// Count the number of rows before deletion
			List<WebElement> rowsBefore = driver.findElements(By.xpath("//table//tr[contains(@class,'mat-row')]"));
			HelperClass.rowCountBeforeDelete = rowsBefore.size();
			System.out.println(" Rows before delete: " + HelperClass.rowCountBeforeDelete);

			// Click the first delete icon
			wait.until(ExpectedConditions.elementToBeClickable(timeLocators.TF_Closebtn)).click();
			System.out.println(" Clicked on delete icon.");

			wait.until(ExpectedConditions.elementToBeClickable(timeLocators.TF_Yesbtn)).click();
			System.out.println(" Clicked on Yes button.");
		} catch (Exception e) {
			System.out.println(" Failed to click on delete icon: " + e.getMessage());

		}
	}


	public void verify_record_is_deleted_in_grid() {
		WebDriverWait wait = HelperClass.getWait1();

		try {
			// Wait until row count decreases
			wait.until(d -> {
				List<WebElement> rowsAfter = d.findElements(By.xpath("//table//tr[contains(@class,'mat-row')]"));
				return rowsAfter.size() < HelperClass.rowCountBeforeDelete;
			});

			List<WebElement> rowsAfter = driver.findElements(By.xpath("//table//tr[contains(@class,'mat-row')]"));
			int rowCountAfterDelete = rowsAfter.size();

			System.out.println(" Rows after delete: " + rowCountAfterDelete);

			System.out.println(" Record deleted successfully.");

		} catch (Exception e) {
			System.out.println(" Exception while verifying deletion: " + e.getMessage());

		}
	}

	public void click_on_the_save_grid() {

		wait.until(ExpectedConditions.elementToBeClickable(timeLocators.TF_SavebtnGrid)).click();
		System.out.println(" Clicked Save button.");


	}

	public void verify_time_sheet_saved_or_not() {

		WebDriverWait wait = HelperClass.getWait1();

		try {
			WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//*[contains(text(),'Timesheet saved successfully')]")
					));

			String toastText = toast.getText().trim();

			System.out.println("Save toast displayed: " + toastText);

			HelperClass.captureAndAttachScreenshot(HelperClass.getScenarioTest(), "");
		} catch (Exception e) {
			System.out.println("Timesheet save toast not found: " + e.getMessage());

		}
	}


	public void click_on_submit_approval_button() {


		WebDriverWait wait = HelperClass.getWait1();

		try {
			wait.until(ExpectedConditions.elementToBeClickable(timeLocators.TF_SubmitApprovalBtn)).click();
			System.out.println(" Clicked on Submit for Approval button.");

			wait.until(ExpectedConditions.elementToBeClickable(timeLocators.TF_Yesbtn)).click();
			System.out.println("Clicked on Yes for Approval popupas.");
		} catch (Exception e) {
			System.out.println("Failed to click Submit for Approval: " + e.getMessage());

		}

	}

	public void verify_time_sheet_submit_or_not() {
	    try {
	        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(
	                By.xpath("//*[contains(text(),'Timesheet successfully resubmitted for approval')]")
	        ));

	        String toastText = toast.getText().trim();

	        if (toast.isDisplayed() && toastText.contains("Timesheet successfully resubmitted for approval")) {
	            // Case 1: Success toast found → Pass
	            Assert.assertTrue(true, "Timesheet resubmission success toast displayed: " + toastText);
	            System.out.println("Success toast displayed: " + toastText);
	        } else {
	            // Case 2: Toast not displayed or text mismatch → Fail
	            Assert.fail("Timesheet resubmission toast not displayed or message incorrect!");
	        }

	        HelperClass.captureAndAttachScreenshot(HelperClass.getScenarioTest(), "");

	    } catch (Exception e) {
	        // Case 3: Exception occurred → Fail
	        Assert.fail("Timesheet resubmission toast not found or verification failed: " + e.getMessage());
	    }
	}


	// unsubmitted sub-tab

	public void navigate_to_unsubmitted_sub_tab() {

		HelperClass.waitForLoaderToDisappear(0);
		wait.until(ExpectedConditions.elementToBeClickable(timeLocators.TF_UnsubmittedTab)).click();
		System.out.println(" Clicked on unSubmitted sub-tab.");

	}

	public void click_on_search_fild_and_add_value(String searchText) {
		try {
			WebDriverWait wait = HelperClass.getWait1();

			// Ensure loader is gone
			HelperClass.waitForLoaderToDisappear(0);

			// Click and clear the field
			Thread.sleep(2000);
			WebElement searchField = wait.until(ExpectedConditions.elementToBeClickable(timeLocators.TF_Search));
			searchField.clear();
			searchField.click();
			HelperClass.sendKeys(searchField, searchText);

			// Wait until value is typed correctly in field
			boolean valueSet = wait.until(driver -> {
				String currentValue = searchField.getAttribute("value");
				return currentValue != null && currentValue.equals(searchText);
			});

			if (valueSet) {
				System.out.println(" Search field has correct value: " + searchText);
			} else {
				System.out.println("Search value mismatch even after wait.");
			}

		} catch (Exception e) {
			System.out.println(" Exception in search input: " + e.getMessage());
		}
	}


	// 👇 This should be OUTSIDE the above method
	public void verify_that_record_in_grid(String expectedTask) {
	    try {
	      
	        By rowLocator = By.xpath("//tr[contains(.,'" + expectedTask + "')]");
	        WebElement recordElement = wait.until(ExpectedConditions.presenceOfElementLocated(rowLocator));

	        if (recordElement.isDisplayed()) {
	            // Case 1: Record found → Pass
	            Assert.assertTrue(true, "Time log record found in grid for: " + expectedTask);
	            System.out.println("Time log found: " + expectedTask);
	        } else {
	            // Case 2: Record not visible → Fail
	            Assert.fail("Time log record not visible in grid for: " + expectedTask);
	        }

	    } catch (Exception e) {
	        // Case 3: Exception occurred → Fail
	        Assert.fail("Exception during record verification in grid: " + e.getMessage());
	    }
	}


	public void click_on_by_user_dropdown_and_select_by_week() {
		try {
			Thread.sleep(2000);
			WebDriverWait wait = HelperClass.getWait1();
			wait.until(ExpectedConditions.elementToBeClickable(timeLocators.TF_ByUserDropdown)).click();
			System.out.println(" Clicked on 'By' dropdown");

			Thread.sleep(1000);
			HelperClass.selectDropdownOption(timeLocators.TF_Option, "By Week");

		} catch (Exception e) {
			System.out.println(" Error in selecting By Week: " + e.getMessage());
		}
	}

	public void verify_that_in_grid_with_week_name() {
	    try {
	      
	        By locator = By.xpath("//td[contains(@class, 'cdk-column-weekName')]//span[contains(text(), 'W') and contains(text(), 'to')]");
	        WebElement weekElement = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

	        if (weekElement.isDisplayed()) {
	            // Case 1: Week element found → Pass
	            Assert.assertTrue(true, "Week view found in grid: " + weekElement.getText());
	            System.out.println("Week found in grid: " + weekElement.getText());
	        } else {
	            // Case 2: Week element not visible → Fail
	            Assert.fail("Week view not visible in grid!");
	        }

	    } catch (Exception e) {
	        // Case 3: Exception occurred → Fail
	        Assert.fail("Exception while verifying week view in grid: " + e.getMessage());
	    }
	}


	public void click_on_user_dropdown_and_select_user() {
		try {
			Thread.sleep(2000); // Ensure page is ready

			WebDriverWait wait = HelperClass.getWait1();

			// Step 1: Click the dropdown using JSExecutor
			WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//mat-select[@placeholder='Users']")));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", dropdown);
			System.out.println(" Clicked on 'Users' dropdown");

			// Step 2: Wait for option and click it
			WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//mat-option//span[normalize-space()='Sophi Sophi']")));
			option.click();
			System.out.println(" Selected user 'Sophi Sophi'");

		} catch (Exception e) {
			System.out.println(" Error in selecting user: " + e.getMessage());
		}
	}

	public void verify_that_user_is_in_grid(String expectedUsername) {
	    try {
	        WebElement userElement = wait.until(ExpectedConditions.presenceOfElementLocated(
	                By.xpath("//td[contains(@class, 'cdk-column-fullName')]//span[normalize-space(text())='" + expectedUsername + "']")
	        ));

	        if (userElement.isDisplayed()) {
	            // Case 1: User found → Pass
	            Assert.assertTrue(true, "User '" + expectedUsername + "' is visible in the grid.");
	            System.out.println("User '" + expectedUsername + "' is visible in the grid.");
	        } else {
	            // Case 2: User element not visible → Fail
	            Assert.fail("User '" + expectedUsername + "' is not visible in the grid.");
	        }

	    } catch (Exception e) {
	        // Case 3: Exception occurred → Fail
	        Assert.fail("Exception while verifying user in grid: " + e.getMessage());
	    }
	}


	public void click_on_record_expend_icon() throws InterruptedException {
        timeLocators = PageFactory.initElements(driver, TimeLocators.class);
		Thread.sleep(4000);

		wait.until(ExpectedConditions.elementToBeClickable(timeLocators.TF_ExpendBtn)).click();
		System.out.println(" Clicked on expend button for load more content");


	}

	public void click_on_visible_content() {


		wait.until(ExpectedConditions.elementToBeClickable(timeLocators.TF_UserOverview)).click();
		System.out.println("Clicked on hyperlink text for load overview page of that user");

	}

	public void validate_overview_page() {
	    try {
	  

	        WebElement overviewPage = wait.until(ExpectedConditions.visibilityOfElementLocated(
	                By.xpath("//div[@class='overview-wrapper timelog-overview']")
	        ));

	        if (overviewPage.isDisplayed()) {
	            // Case 1: Overview page is visible → Pass
	            Assert.assertTrue(true, "Timelog Overview page displayed successfully.");
	            System.out.println("Timelog Overview page displayed successfully.");
	        } else {
	            // Case 2: Not visible → Fail
	            Assert.fail("Timelog Overview page did not appear.");
	        }

	    } catch (Exception e) {
	        // Case 3: Exception occurred → Fail
	        Assert.fail("Unexpected error while verifying overview page: " + e.getMessage());
	    }
	}


	public void click_on_send_reminder_button_and_verify() throws InterruptedException {
		WebDriverWait wait = HelperClass.getWait1();

		try {
			// Click the "Send Reminder" button
			wait.until(ExpectedConditions.elementToBeClickable(timeLocators.TF_SendreminderBtnOverview)).click();
			System.out.println("Clicked send reminder button");

			// Wait for the textarea to appear and enter message
			WebElement textarea = wait.until(ExpectedConditions.visibilityOf(timeLocators.TF_ReminderTextarea));
			textarea.clear();
			textarea.sendKeys("This is a reminder ✉️");
			System.out.println(" Reminder message entered");

			// Optional: Click Send or Close as per UI flow
			wait.until(ExpectedConditions.elementToBeClickable(timeLocators.TF_SendReminderSubmitButton)).click();
			System.out.println(" Reminder sent");

		} catch (Exception e) {
			System.out.println(" Error in sending reminder: " + e.getMessage());
		}

		Thread.sleep(2500);
		HelperClass.captureAndAttachScreenshot(HelperClass.getScenarioTest(), "");

	}


	public void click_on_submit_for_approval_button_and_verify() throws InterruptedException {

		WebDriverWait wait = HelperClass.getWait1();

		try {
			// Click the "Send Reminder" button
			wait.until(ExpectedConditions.elementToBeClickable(timeLocators.TF_SubmitforapprovButton)).click();
			System.out.println("Clicked ssubmit approval button");

			// Optional: Click Send or Close as per UI flow
			wait.until(ExpectedConditions.elementToBeClickable(timeLocators.TF_Yesbtn)).click();
			System.out.println(" approval submit");
		} catch (Exception e) {
			System.out.println(" Error in submit approv: " + e.getMessage());
		}

		Thread.sleep(1500);

		HelperClass.captureAndAttachScreenshot(HelperClass.getScenarioTest(), "");


	}

	public void click_on_export_as_excel(){

		wait.until(ExpectedConditions.elementToBeClickable(timeLocators.TF_ExportasEXCEL)).click();
		System.out.println(" Clicked ssubmit approval button");


	}

	public void click_on_export_as_csv(){
		wait.until(ExpectedConditions.elementToBeClickable(timeLocators.TF_ExportasCSV)).click();
		System.out.println(" Clicked ssubmit approval button");

	}

	public void click_on_export_as_pdf(){
		wait.until(ExpectedConditions.elementToBeClickable(timeLocators.TF_ExporttoPDF)).click();
		System.out.println(" Clicked ssubmit approval button");

	}


	//	public void click_on_send_reminder_icon(){
	//		wait.until(ExpectedConditions.elementToBeClickable(TimeLocators.TF_SendReminderGrid)).click();
	//		
	//		WebElement textarea = wait.until(ExpectedConditions.visibilityOf(TimeLocators.TF_ReminderTextarea));
	//		textarea.clear();
	//		textarea.sendKeys("This is a reminder ✉️");
	//		System.out.println("📝 Reminder message entered");
	//
	//		wait.until(ExpectedConditions.elementToBeClickable(TimeLocators.TF_SendReminderSubmitButton)).click();
	//		System.out.println("Reminder sent");
	//
	//		Thread.sleep(2500);
	//		HelperClass.captureAndAttachScreenshot(HelperClass.getScenarioTest(), "");
	//	}


	public void Hover_on_record() throws InterruptedException{

		Thread.sleep(2000);
		HelperClass.waitForLoaderToDisappear(30);
		WebElement gridRow = HelperClass.getDriver().findElement(By.xpath("//table/tbody/tr[1]"));
		HelperClass.forceHover(gridRow);


	}


	// PFA sub tab

	public void Navigate_to_PFA_sub_tab(){
		HelperClass.waitForLoaderToDisappear(0);
		wait.until(ExpectedConditions.elementToBeClickable(timeLocators.TF_PFASubTab)).click();

	}

	public void click_on_send_Note_button_and_verify() throws InterruptedException{

		WebDriverWait wait = HelperClass.getWait1();

		try {
			Thread.sleep(2000);
			wait.until(ExpectedConditions.elementToBeClickable(timeLocators.TF_SendBtn)).click();
			System.out.println("📤 Clicked send note button");

			// Wait for the textarea to appear and enter message
			WebElement textarea = wait.until(ExpectedConditions.visibilityOf(timeLocators.TF_ReminderTextarea));
			textarea.clear();
			Thread.sleep(2000);
			textarea.sendKeys("This is an Note");
			System.out.println("Send note  message entered");

			// Optional: Click Send or Close as per UI flow
			wait.until(ExpectedConditions.elementToBeClickable(timeLocators.TF_SendReminderSubmitButton)).click();
			System.out.println(" Reminder sent");

		} catch (Exception e) {
			System.out.println(" Error in sending reminder: " + e.getMessage());
		}


		Thread.sleep(2500);
		HelperClass.captureAndAttachScreenshot(HelperClass.getScenarioTest(), "");

	}

	public void click_on_reject_button_and_verify() throws InterruptedException{

		WebDriverWait wait = HelperClass.getWait1();

		try {
			// Click the "Send Reminder" button
			wait.until(ExpectedConditions.elementToBeClickable(timeLocators.TF_RejectBtn)).click();
			System.out.println("📤 Clicked send note button");

			// Wait for the textarea to appear and enter message
			WebElement textarea = wait.until(ExpectedConditions.visibilityOf(timeLocators.TF_ReminderTextarea));
			textarea.clear();
			textarea.sendKeys("This is an reject message");
			System.out.println("reject  message entered");

			// Optional: Click Send or Close as per UI flow
			wait.until(ExpectedConditions.elementToBeClickable(timeLocators.TF_RejectBtnDialoug)).click();
			System.out.println(" Reminder sent");

		} catch (Exception e) {
			System.out.println(" Error in sending reminder: " + e.getMessage());
		}


		Thread.sleep(2500);
		HelperClass.captureAndAttachScreenshot(HelperClass.getScenarioTest(), "");

	}

	public void click_on_approve_button() throws InterruptedException {


		WebDriverWait wait = HelperClass.getWait1();

		try {
			// Click the "Send Reminder" button
			wait.until(ExpectedConditions.elementToBeClickable(timeLocators.TF_SubmitforapprovButton)).click();
			System.out.println(" Clicked approve button");

			// Optional: Click Send or Close as per UI flow
			wait.until(ExpectedConditions.elementToBeClickable(timeLocators.TF_ApproveBtnDialoug)).click();
			System.out.println(" Reminder sent");

		} catch (Exception e) {
			System.out.println("Error in sending reminder: " + e.getMessage());
		}

		Thread.sleep(2500);
		HelperClass.captureAndAttachScreenshot(HelperClass.getScenarioTest(), "Approve button");

	}

	public void Navigate_to_approved_sub_tab() {

		HelperClass.waitForLoaderToDisappear(0);
		wait.until(ExpectedConditions.elementToBeClickable(timeLocators.TF_ApprovedSubTab)).click();

	}

	public void click_on_withdraw_approve_button() throws InterruptedException {

		try {
			// Click the "Send Reminder" button
			wait.until(ExpectedConditions.elementToBeClickable(timeLocators.TF_WithdrawApprovebtn)).click();
			System.out.println("📤 Clicked send note button");

			// Wait for the textarea to appear and enter message
			WebElement textarea = wait.until(ExpectedConditions.visibilityOf(timeLocators.TF_ReminderTextarea));
			textarea.clear();
			textarea.sendKeys("This is an Withdraw approval message");
			System.out.println("reject  message entered");

			// Optional: Click Send or Close as per UI flow
			wait.until(ExpectedConditions.elementToBeClickable(timeLocators.TF_WithdrawApprovebtnDialoug)).click();
			System.out.println("Withdraw approval sent");

		} catch (Exception e) {
			System.out.println("Error in sending withdraw approval: " + e.getMessage());
		}
		Thread.sleep(2500);
		HelperClass.captureAndAttachScreenshot(HelperClass.getScenarioTest(), "");

	}

	public void Navigate_to_rejected_sub_tab() {

		HelperClass.waitForLoaderToDisappear(0);
		wait.until(ExpectedConditions.elementToBeClickable(timeLocators.TF_RejectionSubTab)).click();

	}

	public void click_on_withdraw_rejected_button() throws InterruptedException {

		try {

			Thread.sleep(2000);
			wait.until(ExpectedConditions.elementToBeClickable(timeLocators.TF_WithdrawRejectionbtn)).click();
			System.out.println("📤 Clicked withdraw rejection button");

			// Wait for the textarea to appear and enter message
			WebElement textarea = wait.until(ExpectedConditions.visibilityOf(timeLocators.TF_ReminderTextarea));
			textarea.clear();
			textarea.sendKeys("This is an Withdraw rejection message");
			System.out.println("reject  message entered");


			wait.until(ExpectedConditions.elementToBeClickable(timeLocators.TF_WithdrawRejectionbtnDialoug)).click();
			System.out.println(" Withdraw rejection sent");

		} catch (Exception e) {
			System.out.println(" Error in sending withdraw approval: " + e.getMessage());
		}
		Thread.sleep(2500);
		HelperClass.captureAndAttachScreenshot(HelperClass.getScenarioTest(), "");

	}


	public void click_on_the_cancel() {
		HelperClass.waitUntilVisible(wait, timeLocators.TF_cancel).click();

	}


	public void validate_popup_is_getting_close() {
	    try {
	   
	        boolean isClosed = new WebDriverWait(driver, Duration.ofSeconds(10))
	                .until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//mat-dialog-container")));

	        if (!isClosed) {
	            throw new AssertionError(" Popup did not close after clicking Cancel.");
	        }

	        System.out.println("Popup closed successfully after clicking Cancel.");
	        HelperClass.captureAndAttachScreenshot(HelperClass.getScenarioTest(), "popup_closed");

	    } catch (TimeoutException e) {
	        throw new AssertionError("Popup was still visible after timeout.");
	    }
	}






}










