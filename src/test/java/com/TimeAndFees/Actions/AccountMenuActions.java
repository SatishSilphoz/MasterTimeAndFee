package com.TimeAndFees.Actions;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.Capium.Utilites.ExcelUtil;
import com.Capium.Utilites.HelperClass;
import com.TimeAndFees.Locators.AccountMenuLocators;
import com.TimeAndFees.Stepdefinations.Hooks;
import com.aventstack.extentreports.MediaEntityBuilder;


public class AccountMenuActions {

	AccountMenuLocators AccountMenuLocators;
	WebDriverWait wait = HelperClass.getWait();
	WebDriver driver = HelperClass.getDriver();
	private static int currentRow = 1;

	public AccountMenuActions() {

		AccountMenuLocators = PageFactory.initElements(HelperClass.getDriver(), AccountMenuLocators.class);
	}

	public void click_on_quick_add_button() throws InterruptedException {

		Thread.sleep(7000);
		HelperClass.waitForLoaderToDisappear(20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//mat-icon[normalize-space()='add_circle_outline']//parent::a")));
		HelperClass.clickUsingJS(By.xpath("//mat-icon[normalize-space()='add_circle_outline']//parent::a"));
		//HelperClass.waitUntilVisible(wait, AccountMenuLocators.TF_quick_add).click();
		

	}

	public void click_on_histroy_button() throws InterruptedException {
		Thread.sleep(7000);
		HelperClass.waitForLoaderToDisappear(20);
		HelperClass.waitUntilVisible(wait, AccountMenuLocators.TF_History).click();

	}

	public void click_on_add_task_in_quick_add() throws InterruptedException {

		HelperClass.waitUntilVisible(wait, AccountMenuLocators.TF_Tasks).click();
		HelperClass.validatepageloaded(By.xpath("//span[normalize-space()='Add New Task']"), null);

	}

	public void click_on_add_estimate_in_quick_add() throws InterruptedException {

		HelperClass.waitUntilVisible(wait, AccountMenuLocators.TF_Estimates).click();
		HelperClass.validatepageloaded(By.xpath("//span[normalize-space()='Add New Estimate']"), null);
	}

	public void click_on_add_expense_in_quick_add() throws InterruptedException {

		HelperClass.waitUntilVisible(wait, AccountMenuLocators.TF_Expesne).click();
		HelperClass.validatepageloaded(By.xpath("//span[normalize-space()='Add New Expense']"), null);
	}

	public void click_on_add_invoice_in_quick_add() throws InterruptedException {

		HelperClass.waitUntilVisible(wait, AccountMenuLocators.TF_Invoice).click();
		HelperClass.validatepageloaded(By.xpath("//span[normalize-space()='Add New Invoice']"), null);
	}

	public void click_on_add_time_log_in_quick_add() throws InterruptedException {
		HelperClass.waitUntilVisible(wait, AccountMenuLocators.TF_Timelog).click();
		HelperClass.validatepageloaded(By.xpath("//span[normalize-space()='Log Time']"), null);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Log Time']//parent::h2//parent::div//mat-icon")));
		HelperClass.waitUntilVisible(wait, By.xpath("//span[text()='Log Time']//parent::h2//parent::div//mat-icon")).click();

	}

	public void click_on_add_clients_in_quick_add() throws InterruptedException {
		HelperClass.waitUntilVisible(wait, AccountMenuLocators.TF_Clients).click();
		HelperClass.validatepageloaded(By.xpath("//span[normalize-space()='Add New Client']"), null);

	}

	public void click_on_add_users_in_quick_add() throws InterruptedException {
		HelperClass.waitUntilVisible(wait, AccountMenuLocators.TF_Users).click();
		HelperClass.validatepageloaded(By.xpath("//span[normalize-space()='Add New User']"), null);

	}

	public void click_on_add_expensetype_in_quick_add() throws InterruptedException {
		HelperClass.waitUntilVisible(wait, AccountMenuLocators.TF_ExpenseTypes).click();
		HelperClass.validatepageloaded(By.xpath("//span[normalize-space()='Add New Expense Type']"), null);

	}

	public void click_on_add_recurring_in_quick_add() throws InterruptedException {
		HelperClass.waitUntilVisible(wait, AccountMenuLocators.TF_Recurring).click();
		HelperClass.validatepageloaded(By.xpath("//span[normalize-space()='Add New Recurring Invoice']"), null);

	}

	public void Validate_recent_activity_panel() throws InterruptedException {
	    Thread.sleep(4000);

	    WebElement recentActivityPanel = new WebDriverWait(driver, Duration.ofSeconds(10))
	            .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='notification-list']//ul)[2]")));

	    if (recentActivityPanel.isDisplayed()) {
	    	
	        // Case 1: Match → Pass test
	        Assert.assertTrue(true, "Recent activity panel is displayed successfully.");
	        System.out.println("Recent activity is displayed successfully.");
	    } else {
	    	
	        // Case 2: Mismatch → Fail fast with clear message
	        Assert.fail("Recent activity panel did not appear!");
	    }

	    Thread.sleep(2000);
	    HelperClass.captureAndAttachScreenshot(HelperClass.getScenarioTest(), "");
	}


	public void click_on_view_all_activity_text() throws InterruptedException {
		
		Thread.sleep(3000);
		HelperClass.waitUntilVisible(wait, AccountMenuLocators.TF_AllActivityText).click();
	
	}

	public void validating_all_dropdown_in_activity() throws InterruptedException {
		
		Thread.sleep(2000);
		Map<String, String> screenshots = HelperClass.validateEachDropdownOptionAndCaptureScreenshot(
				AccountMenuLocators.TF_AllDropdown,
				AccountMenuLocators.TF_Options,
				"All",
				"screenshots"
				);

		// Attach to report here
		for (Map.Entry<String, String> entry : screenshots.entrySet()) {
			Hooks.getScenarioTest().info("Screenshot for: " + entry.getKey(),
					MediaEntityBuilder.createScreenCaptureFromBase64String(entry.getValue()).build());
		}
		
	}

	public void Validate_each_value_of_dropdown_of_time_filter_in_activity_page() throws InterruptedException {
	    Thread.sleep(2000);

	    Map<String, String> screenshots = HelperClass.validateEachDropdownOptionAndCaptureScreenshot(
	            AccountMenuLocators.TF_TimeFilterDropdown,
	            AccountMenuLocators.TF_Options,
	            "AllTime",
	            "screenshots"
	    );

	    if (screenshots != null && !screenshots.isEmpty()) {
	    	
	        // Case 1: Dropdown worked fine → Pass
	        Assert.assertTrue(true, "Time filter dropdown options validated successfully with screenshots.");
	        System.out.println("All dropdown options validated successfully.");
	    } else {
	    	
	        // Case 2: Dropdown failed → Fail
	        Assert.fail("Time filter dropdown validation failed! No screenshots were captured.");
	    }

	    for (Map.Entry<String, String> entry : screenshots.entrySet()) {
	        Hooks.getScenarioTest().info("Screenshot for: " + entry.getKey(),
	                MediaEntityBuilder.createScreenCaptureFromBase64String(entry.getValue()).build());
	    }
	}


	public void validate_activity_page() throws InterruptedException {
	    Thread.sleep(2000);

	    WebElement activityPageContainer = new WebDriverWait(driver, Duration.ofSeconds(10))
	            .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//app-activity")));


	    if (activityPageContainer.isDisplayed()) {
	    	
	        // Case 1: Match → Pass test
	        Assert.assertTrue(true, "Activity page is displayed successfully.");
	        System.out.println("Activity page is displayed successfully.");
	    } else {
	    	
	        // Case 2: Mismatch → Fail fast with clear message
	        Assert.fail("Activity page did not appear!");
	    }

	    Thread.sleep(2000);
	    HelperClass.captureAndAttachScreenshot(HelperClass.getScenarioTest(), "");
	}


	public void click_on_Announcment_button() throws InterruptedException {
		Thread.sleep(3000);
		HelperClass.waitUntilVisible(wait, AccountMenuLocators.TF_Announcment).click();
		
	}

	public void Validate_Announcment_page() throws InterruptedException {
		Thread.sleep(3000);
		WebElement editPageContainer = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='comingsoon']")));

		if (!editPageContainer.isDisplayed()) {
			throw new AssertionError(" announcment page did not appear.");
		}
		System.out.println(" announcment page is displayed successfully.");
		Thread.sleep(2000);
		HelperClass.captureAndAttachScreenshot(HelperClass.getScenarioTest(), "");
	
	}

	public void click_on_ticket_button() throws InterruptedException {
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//mat-icon[normalize-space()='confirmation_number']//parent::a")));
		HelperClass.clickUsingJS(By.xpath("//mat-icon[normalize-space()='confirmation_number']//parent::a"));
		//HelperClass.waitUntilVisible(wait, AccountMenuLocators.TF_Ticket).click();
		
	}

	public void click_on_add_ticket_button() throws InterruptedException {
		Thread.sleep(3000);
		HelperClass.waitUntilVisible(wait, AccountMenuLocators.TF_AddTicket).click();
		
	}

	public void fill_all_the_details_in_add_ticket() throws InterruptedException {
		String filePath = "D:\\Core Modules\\TimeAndFees\\src\\test\\resources\\invoice_data_template.xlsx";
		String sheetName = "Ticket";

		int totalRows = ExcelUtil.getRowCount(filePath, sheetName);

		// If row exceeds Excel limit, reset to 1
		if (currentRow >= totalRows) {
			currentRow = 1;
		}
		
		// Read data from Excel using the current row
		String PhoneNO = ExcelUtil.getCellData(filePath, sheetName, currentRow, 0);
		String Subject = ExcelUtil.getCellData(filePath, sheetName, currentRow, 1);
		String Message = ExcelUtil.getCellData(filePath, sheetName, currentRow, 2);
		
		Thread.sleep(2000);
		HelperClass.sendKeys(AccountMenuLocators.PhoneNO, PhoneNO);
		Thread.sleep(2000);
		HelperClass.sendKeys(AccountMenuLocators.Subject, Subject);
		Thread.sleep(2000);
		HelperClass.sendKeys(AccountMenuLocators.Message, Message);
		Thread.sleep(2000);

		System.out.println("Filled from Excel row: " + currentRow);
		currentRow += 2;
		
	}
	
	public void validate_search_functionality_in_tickets() throws InterruptedException {
	    Thread.sleep(3000);
	    String searchText = "Test";

	    HelperClass.waitUntilVisible(wait, By.xpath("//input[@placeholder='Search']")).click();
	    HelperClass.sendKeysAndPressEnter(By.xpath("//input[@placeholder='Search']"), searchText);
	    Thread.sleep(3000);

	    List<WebElement> subjectCells = driver.findElements(By.xpath("//table//tr/td[position()=2]")); 

	    boolean allMatch = true;
	    for (WebElement cell : subjectCells) {
	        String cellText = cell.getText().trim();
	        if (!cellText.toLowerCase().contains(searchText.toLowerCase())) {
	            allMatch = false;
	            
	            // Fail fast with clear message
	            Assert.fail("Search validation failed! Expected keyword: '" + searchText + "' but found value: '" + cellText + "'");
	            break;
	        }
	    }

	    if (allMatch) {
	        // Case 1: Pass → All rows matched searchText
	        Assert.assertTrue(true, "Search functionality validated successfully for: " + searchText);
	        System.out.println("Search functionality validated successfully for: " + searchText);
	    }
	}



	public void validate_status_dropdown_in_tickets() throws InterruptedException {
	    Thread.sleep(2000);

	    Map<String, String> screenshots = HelperClass.validateEachDropdownOptionAndCaptureScreenshot(
	            AccountMenuLocators.TF_TicketDropdown,
	            AccountMenuLocators.TF_Options,
	            "Status",
	            "screenshots"
	    );


	    if (screenshots != null && !screenshots.isEmpty()) {
	    	
	        // Case 1: Dropdown worked fine → Pass
	        Assert.assertTrue(true, "Ticket Status dropdown options validated successfully with screenshots.");
	        System.out.println("Ticket Status dropdown validated successfully.");
	    } else {
	    	
	        // Case 2: Dropdown failed → Fail
	        Assert.fail("Ticket Status dropdown validation failed! No screenshots were captured.");
	    }

	    // Attach screenshots to report
	    for (Map.Entry<String, String> entry : screenshots.entrySet()) {
	        Hooks.getScenarioTest().info("Screenshot for: " + entry.getKey(),
	                MediaEntityBuilder.createScreenCaptureFromBase64String(entry.getValue()).build());
	    }
	}


	public void click_on_profile_logo() throws InterruptedException {
		Thread.sleep(5000);
		
//		HelperClass.waitUntilVisible(wait, AccountMenuLocators.TF_profile).click();
//	
//		HelperClass.waitUntilClickable(wait, AccountMenuLocators.TF_profile).click();
		
		HelperClass.ClickUsingJS(driver, AccountMenuLocators.TF_profile);
		
	}

	public void validate_purple_color_option() throws InterruptedException {
//	    WebElement purpleOption = HelperClass.waitUntilVisible(wait, By.xpath("(//span[normalize-space(@class)='mat-radio-outer-circle'])[2]"));
//	    Assert.assertTrue(purpleOption.isDisplayed(), "Purple color option is not visible.");
//	    purpleOption.click();
		
		
		HelperClass.ClickUsingJS(driver, By.xpath("(//span[normalize-space(@class)='mat-radio-outer-circle'])[1]"));
		Thread.sleep(2000);
		HelperClass.captureAndAttachScreenshot(HelperClass.getScenarioTest(), "");
		
	   
	}

	public void validate_periwinkle_color_option() throws InterruptedException {

		HelperClass.ClickUsingJS(driver, By.xpath("(//span[normalize-space(@class)='mat-radio-outer-circle'])[2]"));
		Thread.sleep(2000);
		HelperClass.captureAndAttachScreenshot(HelperClass.getScenarioTest(), "");
	}

	public void validate_royal_blue_color_option() throws InterruptedException {

		HelperClass.ClickUsingJS(driver, By.xpath("(//span[normalize-space(@class)='mat-radio-outer-circle'])[3]"));
		Thread.sleep(2000);
		HelperClass.captureAndAttachScreenshot(HelperClass.getScenarioTest(), "");
	}

	public void validate_crimson_color_option() throws InterruptedException {
		
		HelperClass.ClickUsingJS(driver, By.xpath("(//span[normalize-space(@class)='mat-radio-outer-circle'])[4]"));
		Thread.sleep(2000);
		HelperClass.captureAndAttachScreenshot(HelperClass.getScenarioTest(), "");
	}

	public void validate_teal_color_option() throws InterruptedException {
	
		HelperClass.ClickUsingJS(driver, By.xpath("(//span[normalize-space(@class)='mat-radio-outer-circle'])[5]"));
		Thread.sleep(2000);
		HelperClass.captureAndAttachScreenshot(HelperClass.getScenarioTest(), "");
	}

	public void validate_blue_color_option() throws InterruptedException {
	
		HelperClass.ClickUsingJS(driver, By.xpath("(//span[normalize-space(@class)='mat-radio-outer-circle'])[6]"));
		Thread.sleep(2000);
		HelperClass.captureAndAttachScreenshot(HelperClass.getScenarioTest(), "");
	}

	public void validate_mustard_color_option() throws InterruptedException {

		HelperClass.ClickUsingJS(driver, By.xpath("(//span[normalize-space(@class)='mat-radio-outer-circle'])[7]"));
		Thread.sleep(2000);
		HelperClass.captureAndAttachScreenshot(HelperClass.getScenarioTest(), "");
	}

	public void validate_black_color_option() throws InterruptedException {
	
		HelperClass.ClickUsingJS(driver, By.xpath("(//span[normalize-space(@class)='mat-radio-outer-circle'])[8]"));
		Thread.sleep(2000);
		HelperClass.captureAndAttachScreenshot(HelperClass.getScenarioTest(), "");
	}





}