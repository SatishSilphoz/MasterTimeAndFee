package com.TimeAndFees.Actions;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.Capium.Utilites.ExcelUtil;
import com.Capium.Utilites.HelperClass;
import com.TimeAndFees.Locators.SettingsLocators;

public class SettingsActions {
	SettingsLocators settingsLocators = null;
	WebDriverWait wait = HelperClass.getWait();
	WebDriver driver = HelperClass.getDriver();
	private static int currentRow = 1;

	public SettingsActions() {

		this.settingsLocators = new SettingsLocators();
		PageFactory.initElements(HelperClass.getDriver(), settingsLocators);
	}

	public void validate_my_business_page() throws InterruptedException {

		HelperClass.validatepageloaded(By.xpath("//span[contains(text(),'Company')]"), null);
	}

	public void click_on_my_business_icon() {

		HelperClass.waitUntilVisible(wait, settingsLocators.TF_Myubusiness).click();
	}

	public void click_on_settings_icon() throws InterruptedException {

		Thread.sleep(10000);
		HelperClass.waitUntilVisible(wait, settingsLocators.TF_Settings).click();
	}

	public void fill_all_the_details_in_company_section() throws InterruptedException {
		String filePath = "D:\\TimeandFees_5.0\\src\\test\\resources\\invoice_data_template.xlsx";
		String sheetName = "Company";

		int totalRows = ExcelUtil.getRowCount(filePath, sheetName);

		System.out.println("Before adjustment: currentRow = " + currentRow + ", totalRows = " + totalRows);

		// Ensure currentRow always stays within valid range
		if (currentRow > totalRows) {
			// Wrap around but keep alternate pattern
			currentRow = (totalRows % 2 == 0) ? 2 : 1;
		}

		// Read data from Excel
		String companynumber = ExcelUtil.getCellData(filePath, sheetName, currentRow, 1);
		String vatnumber = ExcelUtil.getCellData(filePath, sheetName, currentRow, 2);
		String address1 = ExcelUtil.getCellData(filePath, sheetName, currentRow, 3);
		String address2 = ExcelUtil.getCellData(filePath, sheetName, currentRow, 4);
		String postcode = ExcelUtil.getCellData(filePath, sheetName, currentRow, 5);
		String city = ExcelUtil.getCellData(filePath, sheetName, currentRow, 6);
		String county = ExcelUtil.getCellData(filePath, sheetName, currentRow, 7);

		// Fill the fields
		Thread.sleep(2000);
		HelperClass.sendKeys(settingsLocators.TF_companynumber, companynumber);
		Thread.sleep(2000);
		HelperClass.sendKeys(settingsLocators.TF_vatnumber, vatnumber);
		Thread.sleep(2000);
		HelperClass.sendKeys(settingsLocators.TF_address1, address1);
		Thread.sleep(2000);
		HelperClass.sendKeys(settingsLocators.TF_address2, address2);
		Thread.sleep(2000);
		HelperClass.sendKeys(settingsLocators.TF_postcode, postcode);
		Thread.sleep(2000);
		HelperClass.sendKeys(settingsLocators.TF_city, city);
		Thread.sleep(2000);
		HelperClass.sendKeys(settingsLocators.TF_county, county);
		Thread.sleep(2000);

		System.out.println("Filled from Excel row: " + currentRow);

		// Move to the next alternate row
		currentRow += 2;
	}

	public void click_on_add_new_line_for_add_contact() {

		HelperClass.scrollIntoView(settingsLocators.TF_addnewline);
		HelperClass.waitUntilVisible(wait, settingsLocators.TF_addnewline).click();

	}

	public void fill_all_the_details_of_contact_details() throws InterruptedException {

		String filePath = "D:\\TimeandFees_5.0\\src\\test\\resources\\invoice_data_template.xlsx";
		String sheetName = "Contact";

		int totalRows = ExcelUtil.getRowCount(filePath, sheetName);

		if (currentRow >= totalRows) {
			currentRow = 1;
		}

		// Read data from Excel using the current row
		String Fullname = ExcelUtil.getCellData(filePath, sheetName, currentRow, 0);
		String Email = ExcelUtil.getCellData(filePath, sheetName, currentRow, 1);
		String Phone = ExcelUtil.getCellData(filePath, sheetName, currentRow, 2);


		// Fill remaining fields
		Thread.sleep(2000);
		HelperClass.sendKeys(settingsLocators.TF_name, Fullname);
		Thread.sleep(2000);
		HelperClass.sendKeys(settingsLocators.TF_email, Email);
		Thread.sleep(2000);
		HelperClass.sendKeys(settingsLocators.TF_phone, Phone);

		System.out.println("Filled from Excel row: " + currentRow);

		// Move to next alternate row
		currentRow += 2;

	}

	public void click_on_individual() throws InterruptedException {

		Thread.sleep(3000);
		HelperClass.waitUntilVisible(wait, By.xpath("//span[contains(text(),' Individual')]/ancestor::button")).click();

	}


	public void fill_all_the_details_in_individual_section() throws InterruptedException{
		String filePath = "D:\\TimeandFees_5.0\\src\\test\\resources\\invoice_data_template.xlsx";
		String sheetName = "Company";

		int totalRows = ExcelUtil.getRowCount(filePath, sheetName);

		if (currentRow > totalRows) {
			currentRow = (totalRows % 2 == 0) ? 2 : 1;
		}

		// Read data from Excel using the current row
		String Fullnamenumber = ExcelUtil.getCellData(filePath, sheetName, currentRow, 0);
		String address1 = ExcelUtil.getCellData(filePath, sheetName, currentRow, 3);
		String address2 = ExcelUtil.getCellData(filePath, sheetName, currentRow, 4);
		String postcode = ExcelUtil.getCellData(filePath, sheetName, currentRow, 5);
		String city = ExcelUtil.getCellData(filePath, sheetName, currentRow, 6);
		String county = ExcelUtil.getCellData(filePath, sheetName, currentRow, 7);

		// Fill remaining fields
		Thread.sleep(2000);
		HelperClass.sendKeys(settingsLocators.TF_Fullname, Fullnamenumber);
		Thread.sleep(2000);
		HelperClass.sendKeys(settingsLocators.TF_address1, address1);
		Thread.sleep(2000);
		HelperClass.sendKeys(settingsLocators.TF_address2, address2);
		Thread.sleep(2000);
		HelperClass.sendKeys(settingsLocators.TF_postcode, postcode);
		Thread.sleep(2000);
		HelperClass.sendKeys(settingsLocators.TF_city, city);
		Thread.sleep(2000);
		HelperClass.sendKeys(settingsLocators.TF_county, county);
		Thread.sleep(2000);

		System.out.println("Filled from Excel row: " + currentRow);

		// Move to next alternate row
		currentRow += 2;
	}

	public void click_on_company() throws InterruptedException {

		Thread.sleep(3000);
		HelperClass.waitUntilVisible(wait, By.xpath("//span[contains(text(),'Company')]/ancestor::button")).click();
	}

	public void Validate_changes_saved_or_not() throws InterruptedException {

		HelperClass.validatepageloaded(By.xpath("//div[contains(@class,'alert-success')]//p[contains(text(),'The operation completed successfully!')]"), null);
	}

	public void Validate_changes_saved_and_exit() throws InterruptedException {

		HelperClass.validatepageloaded(By.xpath("//span[contains(text(),'Add Widget')]"), null);
	}

	public void validate_estimate_page() throws InterruptedException {

		HelperClass.validatepageloaded(By.xpath("//p[contains(text(),'Estimate ID')]"), null);
	}

	public void click_on_my_estimate_icon() throws InterruptedException {

		HelperClass.waitUntilVisible(wait, settingsLocators.TF_Estimate);
		HelperClass.ClickUsingJS(driver, settingsLocators.TF_Estimate);

	}

	public void validate_estimate_id_disable() throws InterruptedException {

		HelperClass.validatepageloaded(By.xpath("//input[@formcontrolname='estimateId' and @disabled]"), null);

	}

	public void validate_estimate_id_enable() throws InterruptedException {

		HelperClass.validatepageloaded(By.xpath("//input[@formcontrolname='estimateId']"), null);

	}

	public void fill_the_data_in_footer() {
		
		settingsLocators = PageFactory.initElements(driver, SettingsLocators.class); 
		HelperClass.scrollIntoView(settingsLocators.footer);
		HelperClass.sendKeysAndPressEnter(By.xpath("//textarea"), "This is an note for testing");
		HelperClass.ClickUsingJS(driver, By.xpath("//span[contains(text(),'Save')]/ancestor::button"));
	}

	public void click_on_autogenrate_radio_button() throws InterruptedException {

		Thread.sleep(3000);
		HelperClass.waitUntilVisible(wait, By.xpath("(//label[contains(@class,'mat-radio-label')])[1]")).click();
	}

	public void vaslidate_footer_text() throws InterruptedException {
		Thread.sleep(2000);
		HelperClass.scrolling1();
		HelperClass.captureAndAttachScreenshot(HelperClass.getScenarioTest(), "Validate footer");

	}

	public void click_on_Add_manually_radio_button() throws InterruptedException {
		Thread.sleep(3000);
		HelperClass.waitUntilVisible(wait, By.xpath("(//label[contains(@class,'mat-radio-label')])[2]")).click();

	}

	public void click_on_templates_icon() {
		HelperClass.waitUntilVisible(wait, settingsLocators.TF_Templates).click();

	}

	public void validate_templates_page() throws InterruptedException {
		Thread.sleep(2000);
		HelperClass.waitUntilVisible(wait, settingsLocators.ExpendUP).click();
		Thread.sleep(2000);
		HelperClass.validatepageloaded(By.xpath("//span[contains(text(),'Invoices')]/ancestor::mat-expansion-panel-header"), null);
		HelperClass.validatepageloaded(By.xpath("//span[contains(text(),'Timesheets')]/ancestor::mat-expansion-panel-header"), null);
		HelperClass.validatepageloaded(By.xpath("//span[contains(text(),'Payments')]/ancestor::mat-expansion-panel-header"), null);
		HelperClass.validatepageloaded(By.xpath("//span[contains(text(),'Reminders')]/ancestor::mat-expansion-panel-header"), null);
		HelperClass.validatepageloaded(By.xpath("//span[contains(text(),'Estimates')]/ancestor::mat-expansion-panel-header"), null);
		HelperClass.validatepageloaded(By.xpath("//span[contains(text(),'Expense')]/ancestor::mat-expansion-panel-header"), null);
		HelperClass.validatepageloaded(By.xpath("//span[contains(text(),'Signature')]/ancestor::mat-expansion-panel-header"), null);

	}

	public void expend_all_the_panels() throws InterruptedException {
		Thread.sleep(4000);
		HelperClass.scrollToTop();
		HelperClass.waitUntilVisible(wait, settingsLocators.ExpendUP).click();
		Thread.sleep(3000);
		HelperClass.waitUntilVisible(wait, settingsLocators.ExpendDown).click();
	}

	public void enter_text_in_all_the_subject_and_message_field() {
		String textToAdd = " Testing";

		// Subject fields
		List<WebElement> subjects = driver.findElements(By.xpath("//p[text()='Subject']/following-sibling::app-textarea-highlight//div[@contenteditable='true']"));
		for (WebElement subject : subjects) {
			subject.sendKeys(textToAdd);
		}

		// Message fields
		List<WebElement> messages = driver.findElements(By.xpath("//p[text()='Message']/following-sibling::app-textarea-highlight//div[@contenteditable='true']"));
		for (WebElement message : messages) {
			message.sendKeys(textToAdd);
		}
		
		List<WebElement> signatures = driver.findElements(By.xpath("//angular-editor"));
		for (WebElement signature : signatures) {
			signature.sendKeys(textToAdd);
		}
	}


	public void validate_all_the_text_are_there_or_not() {
		String expected = " Testing";

		List<WebElement> subjects = driver.findElements(By.xpath("//p[text()='Subject']/following-sibling::app-textarea-highlight//div[@contenteditable='true']"));
		for (WebElement subject : subjects) {
			if (!subject.getText().contains(expected)) {
				throw new AssertionError("Text not found in subject: " + subject.getText());
			}

			System.out.println("Text found in all subject fields");
		}

		List<WebElement> messages = driver.findElements(By.xpath("//p[text()='Message']/following-sibling::app-textarea-highlight//div[@contenteditable='true']"));
		for (WebElement message : messages) {
			if (!message.getText().contains(expected)) {
				throw new AssertionError("Text not found in message: " + message.getText());
			}

			System.out.println("Text found in all message fields");
		}

		List<WebElement> signatures = driver.findElements(By.xpath("//angular-editor"));
		for (WebElement signature : signatures) {
			signature.sendKeys(expected);
		}


	}

	public void enter_text_in_all_the_subject_and_message_field_cancelchanges() {
		String textToAdd = "Cancel Testing";

		// Subject fields
		List<WebElement> subjects = driver.findElements(By.xpath("//p[text()='Subject']/following-sibling::app-textarea-highlight//div[@contenteditable='true']"));
		for (WebElement subject : subjects) {
			subject.sendKeys(textToAdd);
		}

		// Message fields
		List<WebElement> messages = driver.findElements(By.xpath("//p[text()='Message']/following-sibling::app-textarea-highlight//div[@contenteditable='true']"));
		for (WebElement message : messages) {
			message.sendKeys(textToAdd);
		}

		// signature fields
		List<WebElement> signatures = driver.findElements(By.xpath("//angular-editor"));
		for (WebElement signature : signatures) {
			signature.sendKeys(textToAdd);
		}
	}

	public void Validate_text_not_added() throws InterruptedException {
		
		Thread.sleep(3000);
		// Subject fields
		List<WebElement> subjects = driver.findElements(By.xpath("//p[text()='Subject']/following-sibling::app-textarea-highlight//div[@contenteditable='true']"));
		for (WebElement subject : subjects) {
			String text = subject.getText();
			if (text.contains("Cancel Testing")) {
				throw new AssertionError("Cancel failed: Found 'Cancel Testing' in Subject field -> " + text);
			}
		}

		// Message fields
		List<WebElement> messages = driver.findElements(By.xpath("//p[text()='Message']/following-sibling::app-textarea-highlight//div[@contenteditable='true']"));
		for (WebElement message : messages) {
			String text = message.getText();
			if (text.contains("Cancel Testing")) {
				throw new AssertionError("Cancel failed: Found 'Cancel Testing' in Message field -> " + text);
			}
		}
		
		List<WebElement> signatures = driver.findElements(By.xpath("//angular-editor"));
		for (WebElement signature : signatures) {
			String text = signature.getText();
			if (text.contains("Cancel Testing")) {
				throw new AssertionError("Cancel failed: Found 'Cancel Testing' in Message field -> " + text);
			}
		}
	}

	public void click_on_cancel_changes() throws InterruptedException {
		Thread.sleep(3000);
		HelperClass.waitUntilVisible(wait, By.xpath("//span[contains(text(),'Cancel Changes')]/ancestor::button")).click();
		
	}

	public void validate_cancel_changes_on_alternative_method() throws InterruptedException {
	    Thread.sleep(3000);

	    // Locate actual radio button containers (not the inner <h4>)
	    By capiumRadio = By.xpath("//mat-radio-button[.//h4[contains(text(),'Capium’s Time and Fees')]]");
	    By gmailOutlookRadio = By.xpath("//mat-radio-button[.//h4[contains(text(),'Gmail, Outlook')]]");

	    WebElement capium = driver.findElement(capiumRadio);
	    WebElement gmailOutlook = driver.findElement(gmailOutlookRadio);

	    boolean isCapiumSelected = capium.getAttribute("class").contains("mat-radio-checked");
	    boolean isGmailSelected = gmailOutlook.getAttribute("class").contains("mat-radio-checked");

	    WebElement originallySelected = isCapiumSelected ? capium : gmailOutlook;
	    WebElement alternative = isCapiumSelected ? gmailOutlook : capium;
 
	    if (!alternative.getAttribute("class").contains("mat-radio-checked")) {
	        alternative.click();
	        System.out.println("Alternative method selected.");
	    } else {
	        System.out.println("Alternative was already selected, skipping.");
	    }

	    driver.findElement(By.xpath("//span[contains(text(),'Cancel Changes')]/ancestor::button")).click();

	    capium = driver.findElement(capiumRadio);
	    gmailOutlook = driver.findElement(gmailOutlookRadio);

	    Assert.assertTrue(
	        (isCapiumSelected && capium.getAttribute("class").contains("mat-radio-checked")) ||
	        (isGmailSelected && gmailOutlook.getAttribute("class").contains("mat-radio-checked")),
	        "Original radio should remain selected after Cancel Changes"
	    );
	}


	public void click_on_alternative_method() throws InterruptedException {
		
		Thread.sleep(3000);
	    WebElement timeAndFeesRadio = HelperClass.getDriver().findElement(
	        By.xpath("//mat-radio-button[.//h4[contains(text(),'Capium’s Time and Fees')]]")
	    );
	    WebElement gmailOutlookRadio = HelperClass.getDriver().findElement(
	        By.xpath("//mat-radio-button[.//h4[contains(text(),'Gmail, Outlook')]]")
	    );

	    boolean isTimeAndFeesSelected = timeAndFeesRadio.getAttribute("class").contains("mat-radio-checked");
	    boolean isGmailOutlookSelected = gmailOutlookRadio.getAttribute("class").contains("mat-radio-checked");

	    if (isTimeAndFeesSelected) {
	        gmailOutlookRadio.click();
	        System.out.println("Switched from Time and Fees → Gmail/Outlook");
	    } else if (isGmailOutlookSelected) {
	        timeAndFeesRadio.click();
	        System.out.println("Switched from Gmail/Outlook → Time and Fees");
	    } else {
	        System.out.println("No radio button was selected by default");
	    }
	}


	public void vlidate_gmail_outlook_method_checked() throws InterruptedException {
		HelperClass.validatepageloaded(By.xpath("//mat-radio-button[.//h4[contains(normalize-space(),'Gmail, Outlook')] and contains(@class,'mat-radio-checked')]"), null);
		
	}

	public void click_on_gmail_outlook_method() throws InterruptedException {
	    Thread.sleep(3000);
	    WebElement gmailRadioBtn = HelperClass.waitUntilVisible(wait, settingsLocators.GmailRadioBtn);

	    boolean isSelected = gmailRadioBtn.getAttribute("class").contains("mat-radio-checked");

	    if (!isSelected) {
	       
	        gmailRadioBtn.click();
	        System.out.println("Gmail/Outlook method selected.");

	        WebElement saveBtn = HelperClass.waitUntilVisible(wait, settingsLocators.SaveBtn);
	        saveBtn.click();
	        System.out.println("Changes saved after selecting Gmail/Outlook method.");
	    } else {
	        System.out.println("Gmail/Outlook method is already selected. Skipping click and save.");
	    }
	}



	public void vlidate_capium_method_checked() throws InterruptedException {
		
		HelperClass.validatepageloaded(By.xpath("//mat-radio-button[.//h4[contains(normalize-space(),'Capium’s Time and Fees')] and contains(@class,'mat-radio-checked')]"), null);
	}

	public void click_on_capium_time_and_fee_method() throws InterruptedException {
	    Thread.sleep(3000);
	    WebElement timeRadioBtn = HelperClass.waitUntilVisible(wait, settingsLocators.TimeRadioBtn);

	    // Check if already selected
	    boolean isSelected = timeRadioBtn.getAttribute("class").contains("mat-radio-checked");

	    if (!isSelected) {
	        // Click radio button
	        timeRadioBtn.click();
	        System.out.println("Capium Time & Fee method selected.");

	        // Click Save button after selecting
	        WebElement saveBtn = HelperClass.waitUntilVisible(wait, settingsLocators.SaveBtn);
	        saveBtn.click();
	        System.out.println("Changes saved after selecting Capium Time & Fee method.");
	    } else {
	        System.out.println("Capium Time & Fee method is already selected. Skipping click and save.");
	    }
	}


	public void validate_intigrations_page() throws InterruptedException {
		
		HelperClass.validatepageloaded(By.xpath("//mat-panel-title[contains(text(),'Email')]/ancestor::mat-expansion-panel-header"), null);
	}

	public void click_on_intigrations_button() {
		
	    
		HelperClass.waitUntilVisible(wait, settingsLocators.TF_Intigration).click();
	}
	
	//////////////////////////////////////////////////////////prakash/////////////////////////////////////////////////
	
	 public void clickOnSettingsIcon() throws InterruptedException {
	    	Thread.sleep(3000);
	    	HelperClass.waitForLoaderToDisappear(30);
	    	Thread.sleep(3000);
	        wait.until(ExpectedConditions.elementToBeClickable(settingsLocators.TF_Settings)).click();
	        System.out.println("Clicked on the Settings icon");
	    }
	    
	    public void clickOnDemoDataButton() {
	        wait.until(ExpectedConditions.elementToBeClickable(settingsLocators.TF_Demodata)).click();
	        System.out.println("Clicked on Demo Data button");
	    }
	    public void clickOnAddDemoDataButton() throws InterruptedException {
	    	Thread.sleep(3000);
	    	settingsLocators = PageFactory.initElements(driver, SettingsLocators.class);
	        wait.until(ExpectedConditions.elementToBeClickable(settingsLocators.TF_AddDemodatabtn)).click();
	        System.out.println("Clicked on 'Add Demo Data' button");
	    }
	    
	    
	    public void clickOnYesButton() throws InterruptedException {
	        wait.until(ExpectedConditions.elementToBeClickable(settingsLocators.TF_AddDemodataYesbtn)).click();
	        System.out.println("'Yes' button clicked successfully");
	        Thread.sleep(3000);
	    }
	    
	    public void takeScreenshot(String screenshotName) {
	        try {
	            File screenshot = ((TakesScreenshot) HelperClass.getDriver()).getScreenshotAs(OutputType.FILE);
	            String filePath = System.getProperty("user.dir") + "/screenshots/" + screenshotName + ".png";
	            FileUtils.copyFile(screenshot, new File(filePath));
	            System.out.println("📸 Screenshot saved at: " + filePath);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }


	    /** Step 1: Click on Manage 
	     * @throws InterruptedException */
	    public void clickOnManageMenu() throws InterruptedException {
	    	settingsLocators = PageFactory.initElements(driver, SettingsLocators.class);
	    	Thread.sleep(3000);
	        wait.until(ExpectedConditions.elementToBeClickable(settingsLocators.managemenu)).click();
	        System.out.println("Clicked on Manage Menu");
	    }

	    /** Step 2: Search for client 
	     * @throws InterruptedException */
	    public void searchClient(String clientName) throws InterruptedException {
	    	Thread.sleep(2000);
	        wait.until(ExpectedConditions.visibilityOf(settingsLocators.TF_Search)).clear();
	        settingsLocators.TF_Search.sendKeys(clientName);
	        System.out.println("Searched Client: " + clientName);
	        takeScreenshot("ClientSearch_" + clientName);
	    }

	    /** Step 3: Click on Tasks menu 
	     * @throws InterruptedException */
	    public void clickOnTasksMenu() throws InterruptedException {
	    	Thread.sleep(3000);
	        wait.until(ExpectedConditions.elementToBeClickable(settingsLocators.tasksMenuLink)).click();
	        System.out.println("Clicked on Tasks Menu");
	    }

	    /** Step 4: Search for Task 
	     * @throws InterruptedException */
	    public void searchTask(String taskName) throws InterruptedException {
	    	settingsLocators = PageFactory.initElements(driver, SettingsLocators.class);
	    	Thread.sleep(2000);
	        wait.until(ExpectedConditions.visibilityOf(settingsLocators.TF_Search)).clear();
	        settingsLocators.TF_Search.sendKeys(taskName);
	        System.out.println("Searched Task: " + taskName);
	        takeScreenshot("TaskSearch_" + taskName);
	    }

	    /** Step 5: Click on Users menu 
	     * @throws InterruptedException */
	    public void clickOnUsersMenu() throws InterruptedException {
	    	Thread.sleep(3000);
	        wait.until(ExpectedConditions.elementToBeClickable(settingsLocators.usersMenuLink)).click();
	        System.out.println("Clicked on Users Menu");
	    }

	    /** Step 6: Search for User 
	     * @throws InterruptedException */
	    public void searchUser(String userName) throws InterruptedException {
	    	settingsLocators = PageFactory.initElements(driver, SettingsLocators.class);
	    	Thread.sleep(2000);
	        wait.until(ExpectedConditions.visibilityOf(settingsLocators.TF_Search)).clear();
	        settingsLocators.TF_Search.sendKeys(userName);
	        System.out.println("Searched User: " + userName);
	        takeScreenshot("UserSearch_" + userName);
	    }

	    /** Step 7: Click on Expense Types menu 
	     * @throws InterruptedException */
	    public void clickOnExpenseTypesMenu() throws InterruptedException {
	    	Thread.sleep(3000);
	        wait.until(ExpectedConditions.elementToBeClickable(settingsLocators.expenseTypesMenuLink)).click();
	        System.out.println("Clicked on Expense Types Menu");
	    }

	    /** Step 8: Search for Expense Type 
	     * @throws InterruptedException */
	    public void searchExpenseType(String expenseName) throws InterruptedException {
	    	settingsLocators = PageFactory.initElements(driver, SettingsLocators.class);
	    	Thread.sleep(2000);
	        wait.until(ExpectedConditions.visibilityOf(settingsLocators.TF_Search)).clear();
	        settingsLocators.TF_Search.sendKeys(expenseName);
	        System.out.println("Searched Expense Type: " + expenseName);
	        takeScreenshot("ExpenseTypeSearch_" + expenseName);
	    }

	    /** Step 9: Click on Expenses menu 
	     * @throws InterruptedException */
	    public void clickOnExpensesMenu() throws InterruptedException {
	    	Thread.sleep(3000);
	        wait.until(ExpectedConditions.elementToBeClickable(settingsLocators.expensesTab)).click();
	        System.out.println("Clicked on Expenses Menu");
	    }
	    
	    
	    /** Step 10: Click on Fees menu 
	     * @throws InterruptedException */
	    public void clickOnFeesMenu() throws InterruptedException {
	    	Thread.sleep(3000);
	        wait.until(ExpectedConditions.elementToBeClickable(settingsLocators.FeesTab)).click();
	        System.out.println("Clicked on fees Menu");
	        Thread.sleep(3000);
	        wait.until(ExpectedConditions.elementToBeClickable(settingsLocators.InvoiceTab)).click();
	        System.out.println("Clicked on Invoice Menu");
	    }
	    
	    
	    /** Step 11: Search for Invoice menu 
	     * @throws InterruptedException */
	    public void searchFeesType(String InvoiceNo) throws InterruptedException {
	    	settingsLocators = PageFactory.initElements(driver, SettingsLocators.class);
	    	Thread.sleep(2000);
	        wait.until(ExpectedConditions.visibilityOf(settingsLocators.TF_Search)).clear();
	        settingsLocators.TF_Search.sendKeys(InvoiceNo);
	        System.out.println("Searched Invoice No: " + InvoiceNo);
	        takeScreenshot("InvoiceNoSearch_" + InvoiceNo);
	    }
	    
	    
	    
	    
	    
	    /** Step 12: Click on Estimate menu 
	     * @throws InterruptedException */
	    public void clickOnEstimateMenu() throws InterruptedException {
	    	Thread.sleep(3000);
	        wait.until(ExpectedConditions.elementToBeClickable(settingsLocators.EstimatesTab)).click();
	        System.out.println("Clicked on Estimate Menu");
	        
	    }
	    
	    
	    /** Step 13: Search for Estimate menu 
	     * @throws InterruptedException */
	    public void searchEstimateType(String EstimateNo) throws InterruptedException {
	    	settingsLocators = PageFactory.initElements(driver, SettingsLocators.class);
	    	Thread.sleep(2000);
	        wait.until(ExpectedConditions.visibilityOf(settingsLocators.TF_Search)).clear();
	        settingsLocators.TF_Search.sendKeys(EstimateNo);
	        System.out.println("Searched EstimateNo: " + EstimateNo);
	        takeScreenshot("EstimateNoSearch_" + EstimateNo);
	    }
	    
	    
	    
	    
	    /** Step 14: Click on Jobs menu 
	     * @throws InterruptedException */
	    public void clickOnJobsMenu() throws InterruptedException {
	    	Thread.sleep(3000);
	        wait.until(ExpectedConditions.elementToBeClickable(settingsLocators.JobsTab)).click();
	        System.out.println("Clicked on Jobs Menu");
	        
	    }
	    
	    
	    /** Step 15: Search for Jobs menu 
	     * @throws InterruptedException */
	    public void searchJobsType(String JobsNo) throws InterruptedException {
	    	settingsLocators = PageFactory.initElements(driver, SettingsLocators.class);
	    	Thread.sleep(2000);
	        wait.until(ExpectedConditions.visibilityOf(settingsLocators.TF_Search)).clear();
	        settingsLocators.TF_Search.sendKeys(JobsNo);
	        System.out.println("Searched JobsNo: " + JobsNo);
	        takeScreenshot("JobsNoSearch_" + JobsNo);
	    }
	    
	    
	    /** Step 16: Click on times menu 
	     * @throws InterruptedException */
	    public void clickOnTimesMenu() throws InterruptedException {
	    	Thread.sleep(3000);
	        wait.until(ExpectedConditions.elementToBeClickable(settingsLocators.TimeTab)).click();
	        System.out.println("Clicked on TimeTab Menu");
	        
	    }
	    
	    
	    /** Step 17: Search for Time logs menu 
	     * @throws InterruptedException */
	    public void searchTimeslogsType(String Timelogs) throws InterruptedException {
	    	settingsLocators = PageFactory.initElements(driver, SettingsLocators.class);
	    	Thread.sleep(2000);
	        wait.until(ExpectedConditions.visibilityOf(settingsLocators.TF_Search)).clear();
	        settingsLocators.TF_Search.sendKeys(Timelogs);
	        System.out.println("Searched Timelogs: " + Timelogs);
	        takeScreenshot("TimelogsSearch_" + Timelogs);
	    }
	    
	    
	    ///////// invoice setting ///
	    
	    
	    
	    public void clickOnInvoiceSettingsMenu() throws InterruptedException {
	    	Thread.sleep(3000);
	        wait.until(ExpectedConditions.elementToBeClickable(settingsLocators.invoiceSettingsMenu)).click();
	        System.out.println("Clicked on Invoice Settings menu");
	    }
	    
	    
	 // Click Fees tab
	    public void clickOnFeesTab() throws InterruptedException {
	    	Thread.sleep(3000);
	        wait.until(ExpectedConditions.elementToBeClickable(settingsLocators.FeesTab)).click();
	        System.out.println("Clicked on Fees tab.");
	    }

	    // Click Invoice tab
	    public void clickOnInvoiceTab() throws InterruptedException {
	    	Thread.sleep(3000);
	        wait.until(ExpectedConditions.elementToBeClickable(settingsLocators.InvoiceTab)).click();
	        System.out.println("Clicked on Invoices tab.");
	    }

	    // Click Add Invoice button
	    public void clickOnAddInvoiceButton() {
//	    	Thread.sleep(3000);
	        wait.until(ExpectedConditions.elementToBeClickable(settingsLocators.AddInvoiceButton)).click();
	        System.out.println("Clicked on Add Invoice button.");
	    }

	    
	    public void clickAutoGenerateAndSave() throws InterruptedException {
	        // Click the auto-generate radio button container for reliable click on visible element
	    	Thread.sleep(4000);
	    	clickOnAddManuallyRadio();
	    	Thread.sleep(4000);
	        wait.until(ExpectedConditions.elementToBeClickable(settingsLocators.autoGenerateRadioButtonContainer)).click();
	        System.out.println("Clicked on Auto-generate radio button.");

	        wait.until(ExpectedConditions.elementToBeClickable(settingsLocators.saveAndExitButton)).click();
	        System.out.println("Clicked on Save and Exit.");
	    }

	    
	    
	    public boolean isInvoiceIdFieldAutoGenerated() throws InterruptedException {
	        wait.until(ExpectedConditions.visibilityOf(settingsLocators.InvoiceIdField));
	        try {
	        	Thread.sleep(5000);
	            settingsLocators.InvoiceIdField.click();
	            System.out.println("Invoice ID field is clickable → manual generated.");
	            takeScreenshot("Invoice ID→ manual generated.");
	            return false;
	        } catch (ElementNotInteractableException e) {
	            System.out.println("Invoice ID field is NOT clickable → auto-generated.");
	            takeScreenshot("Invoice ID→ auto-generated.");
	            return true;
	        }

	    }
	    
	    
	    
	    
	    
	    public void clickOnAddManuallyRadio() throws InterruptedException {
//	    	Thread.sleep(4000);
//	    	clickAutoGenerateAndSave();
	    	
	    	Thread.sleep(3000);
	        wait.until(ExpectedConditions.elementToBeClickable(settingsLocators.addManuallyRadio)).click();
	        System.out.println("Clicked on Add Manually radio button.");
	    }

	    public void clickOnSaveAndExitButton() throws InterruptedException {
	    	Thread.sleep(3000);
	        wait.until(ExpectedConditions.elementToBeClickable(settingsLocators.saveAndExitButton)).click();
	        System.out.println("Clicked on Save and Exit button.");
	    }
	    

	    public String selectRandomPaymentMethod() {
	        wait.until(ExpectedConditions.elementToBeClickable(settingsLocators.paymentMethodDropdown)).click();
	        List<WebElement> options = wait.until(
	            ExpectedConditions.visibilityOfAllElements(
	                driver.findElements(By.xpath("//div[contains(@class,'ng-option')]//span[contains(@class,'ng-option-label')]"))
	            )
	        );
	        for (WebElement optionLabel : options) {
	            System.out.println("Dropdown option: " + optionLabel.getText());
	        }
	        int optionIndex = (int) (Math.random() * options.size());
	        WebElement randomOptionLabel = options.get(optionIndex);
	        String selectedMethod = randomOptionLabel.getText().trim();
	        WebElement randomOptionDiv = randomOptionLabel.findElement(By.xpath(".."));
	        wait.until(ExpectedConditions.elementToBeClickable(randomOptionDiv)).click();
	        System.out.println("Random payment method selected: " + selectedMethod);
	        wait.until(ExpectedConditions.elementToBeClickable(settingsLocators.saveAndExitButton)).click();
	        System.out.println("Clicked on Save and Exit button after selecting payment method.");
	        return selectedMethod;
	    }
	    
	    
	    
	    
	    
	    
	    
	    public void hoverOnFirstInvoiceRecord() {
			WebElement gridRow = HelperClass.getDriver().findElement(By.xpath("//table/tbody/tr[1]"));
			HelperClass.forceHover(gridRow);
	    	
	    }

	    public void clickEditIcon() throws InterruptedException {
	    	Thread.sleep(3000);
	        wait.until(ExpectedConditions.elementToBeClickable(settingsLocators.editIcon)).click();
	    }

	    public void clickRecordPaymentButton() {
	        wait.until(ExpectedConditions.elementToBeClickable(settingsLocators.recordPaymentButton)).click();
	    }


	    
	    public String getPaymentMethodInDialog() {
	        HelperClass.waitForLoaderToDisappear(30);
	        wait.until(ExpectedConditions.visibilityOf(settingsLocators.selectedPaymentMethodLabel));
	        String method = settingsLocators.selectedPaymentMethodLabel.getText().trim();
	        System.out.println("Payment method in dialog: " + method);
	        return method;
	    }

	    
	    

	    public void verifyPaymentMethodAndCapture(String expectedPaymentMethod) {
	        String actualPaymentMethod = getPaymentMethodInDialog();
	        if (actualPaymentMethod.equals(expectedPaymentMethod)) {
	            System.out.println("✅ Payment method matches expected: " + actualPaymentMethod);
	            takeScreenshot("payment-method-verification");
	        } else {
	            System.out.println("❌ Payment method does NOT match. Actual: " + actualPaymentMethod + ", Expected: " + expectedPaymentMethod);
	            takeScreenshot("payment-method-verification failed");
	        }
	        
	    }

	    
	    // Select a random term from dropdown and save
	    public String selectRandomPaymentDueTermAndSave() throws InterruptedException {
	    	Thread.sleep(3000);
	        wait.until(ExpectedConditions.elementToBeClickable(settingsLocators.paymentDueTermDropdown)).click();
	        List<WebElement> options = wait.until(
	            ExpectedConditions.visibilityOfAllElements(settingsLocators.paymentDueTermOptions)
	        );
	        int idx = (int)(Math.random() * options.size());
	        WebElement randomLabel = options.get(idx);
	        String selectedTerm = randomLabel.getText().trim();
	        WebElement optionDiv = randomLabel.findElement(By.xpath(".."));
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", optionDiv);
	        wait.until(ExpectedConditions.elementToBeClickable(optionDiv)).click();
	        System.out.println("Random payment due term selected: " + selectedTerm);
	        Thread.sleep(3000);
	        wait.until(ExpectedConditions.elementToBeClickable(settingsLocators.saveAndExitButton)).click();
	        System.out.println("Clicked on Save and Exit.");
	        return selectedTerm;
	    }

	    // Get selected due term from dialog/screen for verification
	    public String getDisplayedPaymentDueTerm() {
	        HelperClass.waitForLoaderToDisappear(30);
	        wait.until(ExpectedConditions.visibilityOf(settingsLocators.selectedPaymentDueTermLabel));
	        return settingsLocators.selectedPaymentDueTermLabel.getText().trim();
	    }

	   
	    // Verify and capture screenshot
	    public void verifyPaymentDueTermAndCapture(String expectedTerm) {
	        String actualTerm = getDisplayedPaymentDueTerm();
	        takeScreenshot("payment-due-term-verification");
	        if (!actualTerm.equals(expectedTerm)) {
	            System.out.println("❌ Payment due term mismatch! Expected: " + expectedTerm + ", Actual: " + actualTerm);
	        } else {
	            System.out.println("✅ Payment due term matches expected: " + actualTerm);
	        }
	    }
	    
	    
	    // Click VAT checkbox
	    public void clickVatCheckbox() throws InterruptedException {
	    	Thread.sleep(3000);
	        wait.until(ExpectedConditions.elementToBeClickable(settingsLocators.vatCheckbox)).click();
	        System.out.println("Clicked on VAT checkbox");
	    }
	    
	    // Click Tax dropdown and take screenshot
	    public void clickTaxDropdownAndTakeScreenshot(String fileName) throws InterruptedException {
	    	Thread.sleep(3000);
	        wait.until(ExpectedConditions.elementToBeClickable(settingsLocators.taxDropdownButton)).click();
	        System.out.println("Clicked on Tax dropdown");

	        takeScreenshot(fileName);
	    }
	    
	    public void clickAddInvoiceButton() {
	        wait.until(ExpectedConditions.elementToBeClickable(settingsLocators.AddInvoiceButton)).click();
	        System.out.println("Clicked on Add Invoice button.");
	    }
	    
	    
	    public void addFooterTextInSettings(String footerText) throws InterruptedException {
	    	Thread.sleep(3000);
	        wait.until(ExpectedConditions.visibilityOf(settingsLocators.settingsFooterTextarea)).clear();
	        Thread.sleep(3000);
	        settingsLocators.settingsFooterTextarea.sendKeys(footerText);
	        System.out.println("Entered footer text in settings: " + footerText);
	        Thread.sleep(3000);
	        wait.until(ExpectedConditions.elementToBeClickable(settingsLocators.saveAndExitButton)).click();
	        System.out.println("Clicked on Save and Exit in settings.");
	    }
	    
	    
	 // Get footer value in invoice - enhanced with wait, debug print
	    public String getFooterTextInInvoice() {
	        wait.until(ExpectedConditions.visibilityOf(settingsLocators.invoiceFooterTextarea));
	        // Optionally wait some extra time to ensure textarea fully loads
	        try {
	            Thread.sleep(2000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	        String actualFooter = settingsLocators.invoiceFooterTextarea.getAttribute("value").trim();
	        System.out.println("Invoice footer textarea value: '" + actualFooter + "'");
	        return actualFooter;
	    }
	    
	 // Verify footer value and take screenshot
	    public void verifyFooterTextAndCapture(String expectedFooter) {
	        String actualFooter = getFooterTextInInvoice();
	        takeScreenshot("footer-verification");
	        if (!actualFooter.equals(expectedFooter)) {
	            System.out.println("❌ Footer text mismatch! Expected: " + expectedFooter + ", Actual: " + actualFooter);
	        } else {
	            System.out.println("✅ Footer text matches expected: " + actualFooter);
	        }
	        org.testng.Assert.assertEquals(actualFooter, expectedFooter, "Footer value mismatch in invoice!");
	    }
	    
	    
	    
	    

	    
	    // Toggle checkbox in settings for the specified grid option
	    public void toggleGridOptionInSettings(String optionName) {
	        WebElement label;
	        switch (optionName.toLowerCase()) {
	            case "type":
	                label = settingsLocators.typeCheckboxLabel;
	                break;
	            case "jobid":
	                label = settingsLocators.jobIdCheckboxLabel;
	                break;
	            case "hourqty":
	                label = settingsLocators.hourQtyCheckboxLabel;
	                break;
	            default:
	                throw new IllegalArgumentException("Unsupported grid option: " + optionName);
	        }
	        wait.until(ExpectedConditions.elementToBeClickable(label)).click();
	        System.out.println("Toggled checkbox for: " + optionName);
	        wait.until(ExpectedConditions.elementToBeClickable(settingsLocators.saveAndExitButton)).click();
	        System.out.println("Clicked on Save and Exit.");
	    }
	    
	    
	    // Verify column header in invoice grid & take screenshot
	    public void verifyOptionInInvoiceGridAndTakeScreenshot(String optionName) throws InterruptedException {
	        WebElement header;
	        String screenshotLabel;
	        switch (optionName.toLowerCase()) {
	            case "type":
	                header = settingsLocators.typeColumnHeader;
	                screenshotLabel = "type-grid";
	                break;
	            case "jobid":
	                header = settingsLocators.jobIdColumnHeader;
	                screenshotLabel = "jobid-grid";
	                break;
	            case "hourqty":
	                header = settingsLocators.hourQtyColumnHeader;
	                screenshotLabel = "hourqty-grid";
	                break;
	            default:
	                throw new IllegalArgumentException("Unsupported grid option: " + optionName);
	        }
	        // Wait and check header presence
	        Thread.sleep(1500); // Ensures grid renders
	        boolean displayed = isGridHeaderDisplayed(header);
	        System.out.println("Option [" + optionName + "] in invoice grid displayed: " + displayed);

	        takeScreenshot(screenshotLabel);
	    }

	    // Helper for header visibility check
	    public boolean isGridHeaderDisplayed(WebElement headerElement) {
	        try {
	            wait.until(ExpectedConditions.visibilityOf(headerElement));
	            return headerElement.isDisplayed();
	        } catch (NoSuchElementException | org.openqa.selenium.TimeoutException e) {
	            return false;
	        }
	    }
	    
	    
	    
	    
	    // Rename a column in settings
	    public void renameGridColumn(String optionName, String newName) {
	        WebElement input;
	        switch (optionName.toLowerCase()) {
	            case "type":
	                input = settingsLocators.typeRenameInput;
	                break;
	            case "jobid":
	                input = settingsLocators.jobIdRenameInput;
	                break;
	            case "description":
	                input = settingsLocators.descriptionRenameInput;
	                break;
	            case "hourqty":
	                input = settingsLocators.hourqtyRenameInput;
	                break;
	            case "pricegbp":
	                input = settingsLocators.pricegbpRenameInput;
	                break;
	            case "amount":
	                input = settingsLocators.amountRenameInput;
	                break;
	            default:
	                throw new IllegalArgumentException("Unknown grid column: " + optionName);
	        }
	        wait.until(ExpectedConditions.visibilityOf(input)).clear();
	        input.sendKeys(newName);
	        System.out.println("Renamed column '" + optionName + "' to '" + newName + "'");
	        wait.until(ExpectedConditions.elementToBeClickable(settingsLocators.saveAndExitButton)).click();
	        System.out.println("Clicked Save and Exit.");
	    }
	    
	    // Helper for grid header locator after rename
	    public WebElement getRenamedHeader(String optionName, String newName) throws InterruptedException {
	    	Thread.sleep(3000);
	        String headerXpath = "//th//span[@class='detail-title' and contains(text(),'" + newName + "')]";
	        return driver.findElement(By.xpath(headerXpath));
	    }

	    public void verifyRenamedColumnInInvoice(String optionName, String newName) throws InterruptedException {
	    	Thread.sleep(3000);
	        WebElement header = getRenamedHeader(optionName, newName);
	        try {
	            wait.until(ExpectedConditions.visibilityOf(header));
	            boolean displayed = header.isDisplayed();
	            System.out.println("Column header '" + newName + "' displayed: " + displayed);
	        } catch (NoSuchElementException | org.openqa.selenium.TimeoutException e) {
	            System.out.println("❌ Column header '" + newName + "' not found in invoice grid!");
	        }
	        takeScreenshot(optionName + "-grid-rename-" + newName);

	    }

}
