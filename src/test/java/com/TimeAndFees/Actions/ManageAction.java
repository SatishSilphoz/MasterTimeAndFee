// Updated ManageAction.java with fixes for readonly date fields and improved stability
package com.TimeAndFees.Actions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.Capium.Utilites.ExcelUtil;
import com.Capium.Utilites.HelperClass;
import com.Capium.Utilites.Log;
import com.TimeAndFees.Locators.ManageLocator;
import com.TimeAndFees.Stepdefinations.Hooks;
import com.aventstack.extentreports.MediaEntityBuilder;

public class ManageAction {
	

	ManageLocator manageLocators = null;
	WebDriver driver = HelperClass.getDriver();
	WebDriverWait wait = HelperClass.getWait();
	String Filepath = "D:\\TimeandFees_5.0\\src\\test\\resources\\invoice_data_template.xlsx";
	

	public ManageAction() {
		this.manageLocators = new ManageLocator();
		PageFactory.initElements(driver, manageLocators);
	}

	// Spinner Wait Method
	public void waitForSpinnerToDisappear() {
		try {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(
					By.xpath("//div[contains(@class,'ngx-spinner-overlay') and contains(@style,'position: fixed')]")));
			Log.info("Spinner disappeared.");
		} catch (Exception e) {
			Log.error("Spinner did not disappear.");
		}
	}

	// Updated Manage Click with Spinner Wait
	public void clickonManage() {
		waitForSpinnerToDisappear();
		wait.until(ExpectedConditions.elementToBeClickable(manageLocators.managemenu));
		HelperClass.ClickUsingJS(driver, manageLocators.managemenu);
		Log.info("Clicked on Manage menu.");
	}

	public void clickonaddclientbtn() {
		waitForSpinnerToDisappear();
		wait.until(ExpectedConditions.elementToBeClickable(manageLocators.addclientbtn));
		HelperClass.ClickUsingJS(driver, manageLocators.addclientbtn);
		Log.info("Clicked on Add Client button.");
	}

	public void ClientCreation() throws IOException, InterruptedException {
		FileInputStream file = new FileInputStream(Filepath);
		XSSFWorkbook wb = new XSSFWorkbook(file);
		XSSFSheet sheet = wb.getSheet("ClientCreation");
		int rowcount = sheet.getLastRowNum();

		DataFormatter formatter = new DataFormatter();
		SimpleDateFormat targetFormat = new SimpleDateFormat("dd/MM/yyyy");

		for (int i = 1; i <= rowcount; i++) {
			XSSFRow row = sheet.getRow(i);

			// Step 1: Navigate to Manage Page
			driver.navigate().to("https://timeandfees.capium.com/manage/clients");
			wait.until(ExpectedConditions.visibilityOf(manageLocators.ClientSearch));

			// Step 2: Click Add Client Button
			WebElement addClientBtn = retryFindElement(
					By.xpath("//span[contains(@class,'mat-button-wrapper')]//span[text()='Add Client']"), 3);
			HelperClass.ClickUsingJS(driver, addClientBtn);

			// Step 3: Read Excel Values
			String companyName = ExcelUtil.getFormattedValue(row.getCell(0), formatter);
			String businessStart = ExcelUtil.getFormattedDate(row.getCell(1), targetFormat, formatter);
			String bookStart = ExcelUtil.getFormattedDate(row.getCell(2), targetFormat, formatter);
			String registrationNo = ExcelUtil.getFormattedValue(row.getCell(3), formatter);
			String utr = ExcelUtil.getFormattedValue(row.getCell(4), formatter);
			String vatNo = ExcelUtil.getFormattedValue(row.getCell(5), formatter);
			String vatRegDate = ExcelUtil.getFormattedDate(row.getCell(6), targetFormat, formatter);
			String accountOfficeRef = ExcelUtil.getFormattedValue(row.getCell(7), formatter);
			String payeRef = ExcelUtil.getFormattedValue(row.getCell(8), formatter);
			String address = ExcelUtil.getFormattedValue(row.getCell(9), formatter);
			String city = ExcelUtil.getFormattedValue(row.getCell(10), formatter);
			String county = ExcelUtil.getFormattedValue(row.getCell(11), formatter);
			String zip = ExcelUtil.getFormattedValue(row.getCell(12), formatter);
			String fullName = ExcelUtil.getFormattedValue(row.getCell(13), formatter); // ✅ New full name
			String email = ExcelUtil.getFormattedValue(row.getCell(14), formatter);
			String phone = ExcelUtil.getFormattedValue(row.getCell(15), formatter);
			

			// Step 4: Fill Form

			Thread.sleep(3000);
//			wait.until(ExpectedConditions.visibilityOf(manageLocators.InputCompanyName));
			// Step 4: Fill Form
			selectCompanyFromDropdown(manageLocators.InputCompanyName, companyName);
			Thread.sleep(3000);
			HelperClass.ClickUsingJS(driver, By.xpath("(//div[@role='listbox']/mat-option/span)[1]"));

			// ✅ Wait for a field that only appears after company is selected
			wait.until(ExpectedConditions.visibilityOf(manageLocators.InputBusinessStartDate));

			// Optional: brief pause to stabilize layout
			Thread.sleep(1000);

			// ✅ Now fill the rest of the form safely
			fillDateField(manageLocators.InputBusinessStartDate, businessStart);
			fillDateField(manageLocators.InputBookStartDate, bookStart);
			fill(manageLocators.InputRegistrationNo, registrationNo);
			fill(manageLocators.InputUTRno, utr);
			fill(manageLocators.InputVatRegNo, vatNo);
			fillDateField(manageLocators.InputVatRegDate, vatRegDate);
			fill(manageLocators.InputAccountOfficeRefNo, accountOfficeRef);
			fill(manageLocators.InputPAYERefNo, payeRef);
			fill(manageLocators.InputAddress1, address);
			fill(manageLocators.InputCity, city);
			fill(manageLocators.InputCounty, county);
			fill(manageLocators.InputZip, zip);
			fill(manageLocators.InputFullName, fullName);
			fill(manageLocators.InputEmail, email);
			fill(manageLocators.InputPhone, phone);

			// ✅ Submit the form
			wait.until(ExpectedConditions.elementToBeClickable(manageLocators.Savenexitbtn));
			HelperClass.ClickUsingJS(driver, manageLocators.Savenexitbtn);

		}

		wb.close();
		file.close();
	}

	private void selectCompanyFromDropdown(WebElement inputField, String companyName) throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(inputField));
		inputField.click(); // focus the field
		inputField.clear();
		inputField.sendKeys(companyName);

		// Add small wait for dropdown options to appear
		Thread.sleep(1000);

		// XPath for mat-option with exact match of company name
//		By optionLocator = By.xpath("//mat-option//span[normalize-space(text())='" + companyName + "']");
//		wait.until(ExpectedConditions.visibilityOfElementLocated(optionLocator));
//
//		WebElement optionElement = driver.findElement(optionLocator);
//
//		// Click via JavaScript to avoid hover issues
//		((JavascriptExecutor) driver).executeScript("arguments[0].click();", optionElement);

		Thread.sleep(1000); // wait for dropdown to register selection
	}

	private void fill(WebElement element, String value) {
		wait.until(ExpectedConditions.visibilityOf(element));
		element.clear();
		element.sendKeys(value);
	}

	private void fillDateField(WebElement element, String dateValue) {
		wait.until(ExpectedConditions.visibilityOf(element));
		((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('readonly')", element);
		element.clear();
		element.sendKeys(dateValue);
	}

	private WebElement retryFindElement(By locator, int retries) {
		for (int i = 0; i < retries; i++) {
			try {
				return wait.until(ExpectedConditions.elementToBeClickable(locator));
			} catch (StaleElementReferenceException e) {
				System.out.println("Stale element, retrying... attempt " + (i + 1));
			}
		}
		throw new RuntimeException("Element could not be found after retries");
	}

	public void verifyClientCreation() throws IOException, InterruptedException {
		FileInputStream file = new FileInputStream(Filepath);
		XSSFWorkbook wb = new XSSFWorkbook(file);
		XSSFSheet sheet = wb.getSheet("ClientCreation");
		int rowcount = sheet.getLastRowNum();
		Log.info("Starting verification of clients...");

		DataFormatter formatter = new DataFormatter();

		for (int i = 1; i <= rowcount; i++) {
			String expectedClientName = ExcelUtil.getFormattedValue(sheet.getRow(i).getCell(0), formatter);
			Thread.sleep(3000);
			wait.until(ExpectedConditions.visibilityOf(manageLocators.ClientSearch));
			manageLocators.ClientSearch.clear();
			manageLocators.ClientSearch.sendKeys(expectedClientName);
			Thread.sleep(2000);
			boolean isClientFound = driver.getPageSource().contains(expectedClientName);

			if (isClientFound) {
				Log.info("Client '" + expectedClientName + "' found successfully in search results.");
			} else {
				Log.error("Client '" + expectedClientName + "' was NOT found in search results.");
			}

			Thread.sleep(1000);
		}

		wb.close();
		file.close();
	}

//	public void Click_Selected_Client() {
//		manageLocators.ClickClient.click();
//	}

	public void clickOnEditButton() {
		Actions actions = new Actions(driver);

		// Hover on the row that contains the grid-actions div
		WebElement hoverTarget = driver.findElement(By.xpath(
				"//div[contains(@class,'grid-actions')]/ancestor::*[contains(@class,'mat-row') or contains(@class,'table-row')]")); // update
																																	// ancestor
																																	// if
																																	// needed
		actions.moveToElement(hoverTarget).perform();

		// Wait until the edit button is clickable
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(manageLocators.EditBtn));

		// Click the Edit button
		manageLocators.EditBtn.click();
	}

	public void verifyEditClientPageOpened() {
		WebDriver driver = HelperClass.getDriver();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		boolean urlMatched = wait.until(ExpectedConditions.urlContains("/manage/addClient;id="));

		String currentUrl = driver.getCurrentUrl();
		Assert.assertTrue(urlMatched, "Edit Client Page URL not matched. Current URL: " + currentUrl);

		System.out.println("✅ Successfully opened Edit Client Page. URL: " + currentUrl);
	}

	public void editClientDetailsAndSave() throws InterruptedException {
		WebDriver driver = HelperClass.getDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Edit the "Name" field
		WebElement nameField = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@formcontrolname='name']")));
		nameField.clear();
		nameField.sendKeys("Edited Client Name");

		// Edit the "email" field
		WebElement EmailField = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@formcontrolname='email']")));
		EmailField.clear();
		EmailField.sendKeys("EditedClientName@gmail.com");

		// Click the Save button
		WebElement saveButton = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//button[.//span[normalize-space()='Save']]")));

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", saveButton);

		saveButton.click();

		System.out.println("✅ Client details edited and Save button clicked.");
		WebElement SavenExitButton = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//button[.//span[normalize-space()='Save and Exit']]")));

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", SavenExitButton);

		SavenExitButton.click();
	}

	public void clickOnDeleteIcon() {

		WebDriverWait wait = HelperClass.getWait1();

		try {
			// Click the "Send Reminder" button
			wait.until(ExpectedConditions.elementToBeClickable(manageLocators.DeleteBtn)).click();
			System.out.println("📤 Clicked Delete button");

		} catch (Exception e) {
			System.out.println("❌ Error in sending reminder: " + e.getMessage());
		}

	}

	public void Hover_on_record() throws InterruptedException {

		Thread.sleep(2000);
		WebElement gridRow = HelperClass.getDriver().findElement(By.xpath("//table/tbody/tr[1]"));
		HelperClass.forceHover(gridRow);

	}

	public void clickDeleteCheckbox() {
		try {
			WebDriverWait wait = new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(manageLocators.Deletecheckbox));

			manageLocators.Deletecheckbox.click();

			System.out.println("Delete checkbox clicked successfully.");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Failed to click Delete checkbox.");
		}
	}

	public void clickOnDeleteYesButton() {
		try {
			WebDriverWait wait = new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(manageLocators.DeleteyesButton));

			manageLocators.DeleteyesButton.click();
			System.out.println("Clicked on the Yes button in delete confirmation popup.");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Failed to click on the Yes button.");
		}
	}

	public void clickOnArchiveButton() {
		try {
			WebDriverWait wait = new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(manageLocators.ArchiveButton));

			manageLocators.ArchiveButton.click();
			System.out.println("Archive button clicked successfully.");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Failed to click on the Archive button.");
		}
	}

	public void clickOnYesButton() {
		try {
			WebDriverWait wait = new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(manageLocators.ArchiveYesButton));

			manageLocators.ArchiveYesButton.click();
			System.out.println("Clicked on the 'Yes' button.");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Failed to click on the 'Yes' button.");
		}
	}

	public void click_on_toolbar() throws InterruptedException {

		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(manageLocators.TF_Toolbar)).click();

	}

	public void click_on_export_as_excel() {

		wait.until(ExpectedConditions.elementToBeClickable(manageLocators.TF_ExportasEXCEL)).click();
		System.out.println("📤 Clicked ssubmit approval button");

	}

	public void click_on_export_as_csv() {
		wait.until(ExpectedConditions.elementToBeClickable(manageLocators.TF_ExportasCSV)).click();
		System.out.println("📤 Clicked ssubmit approval button");

	}

	public void click_on_export_as_pdf() {
		wait.until(ExpectedConditions.elementToBeClickable(manageLocators.TF_ExportasPDF)).click();
		System.out.println("📤 Clicked ssubmit approval button");

	}

	public void click_on_status_dropdown_and_select_status() throws InterruptedException {
		Thread.sleep(4000);
		HelperClass.waitForLoaderToDisappear(30);

		// Step 1: Click dropdown and collect option texts
		manageLocators.TF_StatusManageDropdown.click();
		List<String> optionTexts = new ArrayList<>();
		for (WebElement option : manageLocators.TF_TimeFilterOptions) {
			String text = option.getText().trim();
			if (!text.isEmpty()) {
				optionTexts.add(text);
			}
		}

		// Step 2: Loop through each optionText and re-open dropdown each time
		for (String optionText : optionTexts) {
			boolean found = false;

			// Reopen dropdown
			manageLocators.TF_StatusManageDropdown.click();
			Thread.sleep(1000); // wait for options to render

			// Re-fetch fresh options
			List<WebElement> options = HelperClass.getDriver().findElements(
					By.xpath("//div[contains(@class,'ng-option')]//span[@class='ng-option-label ng-star-inserted']"));

			for (WebElement opt : options) {
				String visibleText = opt.getText().trim();
				if (visibleText.equals(optionText)) {
					((JavascriptExecutor) HelperClass.getDriver()).executeScript("arguments[0].scrollIntoView(true);",
							opt);
					opt.click();
					found = true;
					System.out.println("✅ Selected: " + optionText);

					// Screenshot
					Thread.sleep(2000);
					File screenshot = ((TakesScreenshot) HelperClass.getDriver()).getScreenshotAs(OutputType.FILE);
					String fileName = "screenshots/TaskWise_" + optionText.replaceAll("[^a-zA-Z0-9]", "_") + ".png";
					try {
						FileUtils.copyFile(screenshot, new File(fileName));
						System.out.println("📸 Screenshot saved: " + fileName);
					} catch (IOException e) {
						System.out.println("❌ Error saving screenshot: " + e.getMessage());
					}

					// Extent report screenshot
					String base64 = ((TakesScreenshot) HelperClass.getDriver()).getScreenshotAs(OutputType.BASE64);
					Hooks.getScenarioTest().info("Screenshot for: " + optionText,
							MediaEntityBuilder.createScreenCaptureFromBase64String(base64).build());

					break; // break inner loop after selecting
				}
			}

			if (!found) {
				System.out.println("⚠️ Option not found in dropdown: " + optionText);
			}
		}
	}

	public void validate_status_is_displaying_in_grid() {
		WebDriverWait wait = HelperClass.getWait1();

		try {
			// Wait for the status column cells to be visible
			List<WebElement> statusCells = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(
					"//table//tbody//td[count(//table//th[normalize-space()='Status']/preceding-sibling::th)+1]")));

			boolean allInActive = true;
			for (WebElement cell : statusCells) {
				String statusText = cell.getText().trim();
				if (!statusText.equalsIgnoreCase("Active")) {
					allInActive = false;
					System.out.println("Found non 'Active' status: " + statusText);
				}
			}

			if (allInActive) {
				System.out.println("All rows have 'Active' status. Validation passed.");
			} else {
				System.out.println("Not all rows are 'Active'. Validation failed.");
			}
		} catch (Exception e) {
			System.out.println("Error during status column validation: " + e.getMessage());
		}

	}

	///////////////////// TASK ////////////////////////

	public void clickOnTasksMenu() {
		try {
			Thread.sleep(2500);
			WebDriverWait wait = new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(manageLocators.tasksMenuLink));
			manageLocators.tasksMenuLink.click();
			System.out.println("✅ Clicked on Tasks menu.");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("❌ Failed to click on Tasks menu.");
		}
	}

	public void clickOnAddTaskButton() {
		try {
			WebDriver driver = HelperClass.getDriver();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

			// Click the 'Add Task' button
			wait.until(ExpectedConditions.elementToBeClickable(manageLocators.addTaskButton));
			manageLocators.addTaskButton.click();
			System.out.println("✅ Clicked on 'Add Task' button.");

			// Wait for the heading "Add New Task" to confirm the form is visible
			WebElement heading = wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[normalize-space()='Add New Task']")));

			if (heading.isDisplayed()) {
				System.out.println("✅ 'Add New Task' form is visible.");
			} else {
				throw new RuntimeException("❌ 'Add New Task' heading is not visible.");
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("❌ Failed to click 'Add Task' button or verify form.");
		}
	}

	public void fillAddTaskForm() {
		String excelPath = Filepath;
		String sheetName = "TaskCreation";

		try {
			FileInputStream fis = new FileInputStream(excelPath);
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			Sheet sheet = workbook.getSheet(sheetName);
			Row row = sheet.getRow(1); // Read from second row (row index 1)

			DataFormatter formatter = new DataFormatter(); // Handles all data types safely

			String taskName = formatter.formatCellValue(row.getCell(0));
			String estimatedTime = formatter.formatCellValue(row.getCell(1));
			String feePerHour = formatter.formatCellValue(row.getCell(2));

			WebDriverWait wait = new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(10));

			// Fill Task Name
			wait.until(ExpectedConditions.visibilityOf(manageLocators.taskNameField));
			manageLocators.taskNameField.clear();
			manageLocators.taskNameField.sendKeys(taskName);
			System.out.println("✅ Task Name: " + taskName);

			// Estimated Time
			manageLocators.estimatedTimeField.clear();
			manageLocators.estimatedTimeField.sendKeys(estimatedTime);
			System.out.println("✅ Estimated Time: " + estimatedTime);

			// Fees Per Hour
			manageLocators.feeInputField.clear();
			manageLocators.feeInputField.sendKeys(feePerHour);
			System.out.println("✅ Fee per Hour: " + feePerHour);

			// Expand Subtasks Section (scrolling into view)
			JavascriptExecutor js = (JavascriptExecutor) HelperClass.getDriver();
			js.executeScript("arguments[0].scrollIntoView(true);", manageLocators.subTaskNameField);
			Thread.sleep(1000); // wait for any animations if needed

			workbook.close();
			fis.close();

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("❌ Failed to fill task form from Excel.");
		}

	}

	public void clickSaveTaskButton() {

		try {
			Thread.sleep(3500);
			WebDriverWait wait = new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(manageLocators.saveTaskButton)).click();
			System.out.println("✅ Clicked Save Task button.");
		} catch (Exception e) {
			throw new RuntimeException("❌ Failed to click Save Task button.");
		}
	}

	public void verifyTaskCreation() throws IOException, InterruptedException {
		FileInputStream file = new FileInputStream(Filepath);
		XSSFWorkbook wb = new XSSFWorkbook(file);
		XSSFSheet sheet = wb.getSheet("TaskCreation"); // Sheet with task names

		int rowcount = sheet.getLastRowNum();
		Log.info("🔍 Starting verification of task creation...");

		DataFormatter formatter = new DataFormatter();

		for (int i = 1; i <= rowcount; i++) {
			String expectedTaskName = ExcelUtil.getFormattedValue(sheet.getRow(i).getCell(0), formatter);

			Thread.sleep(2000); // optional wait

			WebDriverWait wait = new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(manageLocators.taskSearchInput));

			manageLocators.taskSearchInput.clear();
			manageLocators.taskSearchInput.sendKeys(expectedTaskName);

			Thread.sleep(1500); // wait for results to load

			boolean isTaskFound = HelperClass.getDriver().getPageSource().contains(expectedTaskName);

			if (isTaskFound) {
				Log.info("✅ Task '" + expectedTaskName + "' found successfully in search results.");
			} else {
				Log.error("❌ Task '" + expectedTaskName + "' was NOT found in search results.");
			}

			Thread.sleep(1000); // buffer before next iteration
		}

		wb.close();
		file.close();
	}

	public void clickOnEditIconInTask() {
		try {
			WebDriverWait wait = new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(manageLocators.editIcontask));
			manageLocators.editIcontask.click();
			System.out.println("✅ Clicked on Edit icon.");
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("❌ Failed to click Edit icon.");
		}
	}

	
	
	public void updateAndVerifyTask() {
	    String updatedTaskName = "Updated Task Name";
	    String updatedEstimatedTime = "15:00";
	    String updatedFixedPrice = "25";

	    WebDriver driver = HelperClass.getDriver();
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	    Random random = new Random();

	    try {
	        Thread.sleep(10000);
	        // Wait for Task Name field to become clickable
	        wait.until(ExpectedConditions.elementToBeClickable(manageLocators.taskNameField));

	        // Append random numeric suffix to updatedTaskName
	        int randomSuffix = 10000 + random.nextInt(90000);  // Generate 5-digit random number
	        String uniqueTaskName = updatedTaskName + randomSuffix;

	        // Update Task Name with unique name
	        wait.until(ExpectedConditions.visibilityOf(manageLocators.taskNameField));
	        manageLocators.taskNameField.clear();
	        manageLocators.taskNameField.sendKeys(uniqueTaskName);
	        System.out.println("✅ Task name updated: " + uniqueTaskName);

	        // Update Estimated Time and click out (to Task Name field) to trigger blur/change event
	        manageLocators.estimatedTimeField.clear();
	        manageLocators.estimatedTimeField.sendKeys(updatedEstimatedTime);
	        System.out.println("✅ Estimated Time updated.");
	        manageLocators.taskNameField.click();  // Click out to trigger any form validation/event

	        // Select Fixed Price option if not already selected
	        Thread.sleep(4000);
	        if (!manageLocators.fixedPriceRadio.isSelected()) {
	            ((JavascriptExecutor)driver).executeScript("arguments[0].click();", manageLocators.fixedPriceRadio);
	            System.out.println("✅ Fixed Price radio selected via JS click.");
	        }

	        // Update Fixed Price
	        manageLocators.fixedPriceInputField.clear();
	        manageLocators.fixedPriceInputField.sendKeys(updatedFixedPrice);
	        System.out.println("✅ Fixed Price updated.");

	        // Save Task
	        Thread.sleep(1000);
	        manageLocators.saveTaskButton.click();
	        System.out.println("✅ Save clicked.");

	        // Save & Exit and verify in search only with unique task name
	        wait.until(ExpectedConditions.elementToBeClickable(manageLocators.saveAndExitTaskButton)).click();
	        System.out.println("✅ Clicked Save & Exit.");
	        Thread.sleep(2000);
	        wait.until(ExpectedConditions.visibilityOf(manageLocators.taskSearchInput));
	        Thread.sleep(2000);
	        manageLocators.taskSearchInput.clear();
	        manageLocators.taskSearchInput.sendKeys(uniqueTaskName);
	        Thread.sleep(2000);

	        if (driver.getPageSource().contains(uniqueTaskName)) {
	            System.out.println("✅ Updated task found in search results: " + uniqueTaskName);
	        } else {
	            throw new RuntimeException("❌ Updated task NOT found in search results: " + uniqueTaskName);
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	        throw new RuntimeException("❌ Task update and verification failed.");
	    }
	}


	/////////////////////////////////////////// USER
	/////////////////////////////////////////// ///////////////////////////////////////////

	public void clickOnUsersMenu() {
		try {
			Thread.sleep(3000);
//			WebDriverWait wait = new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(10));
//			wait.until(ExpectedConditions.elementToBeClickable(manageLocators.usersMenuLink)).click();
			HelperClass.ClickUsingJS(driver, manageLocators.usersMenuLink);
			System.out.println("✅ Clicked on Users menu.");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("❌ Failed to click on Users menu.");
		}
	}

	public void verifyUsersPage() {
		try {
			WebDriver driver = HelperClass.getDriver();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

			// Wait until URL contains the expected path
			wait.until(ExpectedConditions.urlContains("/manage/users"));

			String currentUrl = driver.getCurrentUrl();
			if (currentUrl.equalsIgnoreCase("https://timeandfees.capium.com/manage/users")
					|| currentUrl.equalsIgnoreCase("https://timeandfees.beta.capium.co.uk/manage/users")) {
				System.out.println("✅ Users page URL verified: " + currentUrl);
			} else {
				throw new RuntimeException("❌ Unexpected URL: " + currentUrl);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("❌ Users page verification via URL failed.");
		}
	}

	public void clickAddUserButton() {
		try {
			WebDriver driver = HelperClass.getDriver();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

			// Wait for spinner to be invisible (adjust the XPath if necessary)
			wait.until(ExpectedConditions
					.invisibilityOfElementLocated(By.xpath("//div[contains(@class, 'ngx-spinner-overlay')]")));

			// Wait for button to be clickable
			wait.until(ExpectedConditions.elementToBeClickable(manageLocators.addUserButton)).click();
			System.out.println("✅ Clicked on Add User button.");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("❌ Failed to click Add User button.");
		}
	}

	public void fillAddUserFormAndVerify() {
	    String path = Filepath;
	    String sheetName = "AddUser";
	    WebDriver driver = HelperClass.getDriver();
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	    DataFormatter formatter = new DataFormatter();
	    Random random = new Random();

	    try (FileInputStream fis = new FileInputStream(path); XSSFWorkbook wb = new XSSFWorkbook(fis)) {

	        Sheet sheet = wb.getSheet(sheetName);
	        Row row = sheet.getRow(1);

	        String firstName = formatter.formatCellValue(row.getCell(0));
	        String middleName = formatter.formatCellValue(row.getCell(1));
	        String lastName = formatter.formatCellValue(row.getCell(2));
	        String email = formatter.formatCellValue(row.getCell(3));
	        String phone = formatter.formatCellValue(row.getCell(4));
	        String role = formatter.formatCellValue(row.getCell(5)); // e.g., "Manager"
	        String rate = formatter.formatCellValue(row.getCell(6));
	        String hours = formatter.formatCellValue(row.getCell(7));
	        String cost = formatter.formatCellValue(row.getCell(8));

	        // Add random number to the start of the email
	        int rand = 10000 + random.nextInt(90000); // 5-digit random number
	        String uniqueEmail = rand + email;

	        // Fill user form fields
	        wait.until(ExpectedConditions.visibilityOf(manageLocators.firstNameField)).sendKeys(firstName);
	        manageLocators.middleNameField.sendKeys(middleName);
	        manageLocators.lastNameField.sendKeys(lastName);
	        manageLocators.emailField.sendKeys(uniqueEmail);
	        manageLocators.phoneField.sendKeys(phone);
	        manageLocators.rateField.sendKeys(rate);
	        manageLocators.hoursField.sendKeys(hours);
	        manageLocators.costRateField.sendKeys(cost);

	        // Select Role from <ng-select>
	        manageLocators.roleDropdown.click();
	        String xpathForRole = "//span[contains(@class,'ng-option-label') and normalize-space(text())='" + role + "']";
	        WebElement roleOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathForRole)));
	        roleOption.click();

	        Thread.sleep(1000); // buffer before clicking save
	        manageLocators.saveAndExitButton.click();
	        System.out.println("✅ User saved via Save & Exit.");

	        // Wait until redirected to Users page
	        wait.until(ExpectedConditions.urlContains("/manage/users"));

	        // Search and verify user using the unique email
	        wait.until(ExpectedConditions.visibilityOf(manageLocators.userSearchField)).clear();
	        manageLocators.userSearchField.sendKeys(uniqueEmail); // Use email, as it's unique
	        Thread.sleep(2000);

	        if (driver.getPageSource().contains(uniqueEmail)) {
	            System.out.println("✅ User found in search with email: " + uniqueEmail);
	        } else {
	            throw new RuntimeException("❌ User not found in search with email: " + uniqueEmail);
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	        throw new RuntimeException("❌ Failed to add and verify user.");
	    }
	}

	public void searchUserFromExcel() {
		WebDriver driver = HelperClass.getDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		DataFormatter formatter = new DataFormatter();

		String excelPath = Filepath;
		String sheetName = "AddUser";

		try (FileInputStream fis = new FileInputStream(excelPath); XSSFWorkbook workbook = new XSSFWorkbook(fis)) {

			Sheet sheet = workbook.getSheet(sheetName);
			Row row = sheet.getRow(1); // assumes second row has data

			String firstName = formatter.formatCellValue(row.getCell(0));

			// Perform search
			wait.until(ExpectedConditions.visibilityOf(manageLocators.userSearchField));
			manageLocators.userSearchField.clear();
			manageLocators.userSearchField.sendKeys(firstName);
			Thread.sleep(2000);

			if (driver.getPageSource().contains(firstName)) {
				System.out.println("✅ User '" + firstName + "' found in search.");
			} else {
				System.out.println("⚠️ Warning: User '" + firstName + "' not found in search, but test continues.");
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("❌ Failed to search user from Excel.");
		}
	}

	
	public void editUserAndVerifyUpdate() {
	    String path = Filepath;
	    String sheetName = "EditUser";
	    WebDriver driver = HelperClass.getDriver();
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	    DataFormatter formatter = new DataFormatter();

	    try (FileInputStream fis = new FileInputStream(path);
	         XSSFWorkbook wb = new XSSFWorkbook(fis)) {

	        Sheet sheet = wb.getSheet(sheetName);
	        Row row = sheet.getRow(1);

	        String updatedFirstName = formatter.formatCellValue(row.getCell(0));
	        String updatedPhone = formatter.formatCellValue(row.getCell(1));
	        String updatedRole = formatter.formatCellValue(row.getCell(2));

	        // Click edit icon of the first row (without search)
	        WebElement editIcon = driver.findElement(By.xpath("//tbody//tr[1]//button[@title='Edit']"));
	        wait.until(ExpectedConditions.elementToBeClickable(editIcon)).click();

	        // Wait for form to load
	        wait.until(ExpectedConditions.visibilityOf(manageLocators.firstNameField));

	        // Edit First Name
	        manageLocators.firstNameField.clear();
	        manageLocators.firstNameField.sendKeys(updatedFirstName);

	        // Edit Phone
	        manageLocators.phoneField.clear();
	        manageLocators.phoneField.sendKeys(updatedPhone);

	        // Edit Role
	        manageLocators.roleDropdown.click();
	        WebElement roleOption = driver.findElement(By.xpath("//span[@class='ng-option-label ng-star-inserted' and text()='" + updatedRole + "']"));
	        wait.until(ExpectedConditions.visibilityOf(roleOption)).click();

	        Thread.sleep(1000);

	        // Save and Exit
	        manageLocators.saveAndExitButton.click();
	        System.out.println("✅ User updated and saved.");

	        // Wait to return to Users list
	        wait.until(ExpectedConditions.urlContains("/manage/users"));

	        // Search using updated First Name
	        wait.until(ExpectedConditions.visibilityOf(manageLocators.userSearchField)).clear();
	        manageLocators.userSearchField.sendKeys(updatedFirstName);
	        Thread.sleep(2000);

	        if (driver.getPageSource().contains(updatedFirstName)) {
	            System.out.println("✅ Edited user found in search.");
	        } else {
	            throw new RuntimeException("❌ Edited user not found in search.");
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	        throw new RuntimeException("❌ Failed to edit and verify user.");
	    }
	}


	
	
	
	
	
	
	///////////////// ////////////////////////// EXPENSE TYPES
	///////////////// /////////////////////////////////////////////////////////

	public void clickOnExpenseTypesMenu() {
		try {
			Thread.sleep(2000);
//			WebDriverWait wait = new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(10));
//			wait.until(ExpectedConditions.elementToBeClickable(manageLocators.expenseTypesMenuLink));
//			manageLocators.expenseTypesMenuLink.click();
			HelperClass.ClickUsingJS(driver, manageLocators.expenseTypesMenuLink);
			System.out.println("✅ Clicked on Expense Types menu.");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("❌ Failed to click on Expense Types menu.");
		}
	}

	public void clickAddExpenseTypeButton() {
		try {
			WebDriverWait wait = new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(manageLocators.addExpenseTypeButton));
			manageLocators.addExpenseTypeButton.click();
			System.out.println("✅ Clicked on Add Expense Type button.");

			// Verify URL
			wait.until(ExpectedConditions.urlToBe("https://timeandfees.capium.com/manage/addExpenseType"));
			System.out.println("✅ Navigated to Add Expense Type page successfully.");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("❌ Failed to click Add Expense Type or verify URL.");
		}
	}

	public void fillExpenseTypeFormFromExcel() {
	    String path = Filepath; // Globally set
	    String sheetName = "ExpenseType";
	    WebDriver driver = HelperClass.getDriver();
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	    DataFormatter formatter = new DataFormatter();
	    Random random = new Random();

	    try (FileInputStream fis = new FileInputStream(path); XSSFWorkbook wb = new XSSFWorkbook(fis)) {

	        Sheet sheet = wb.getSheet(sheetName);
	        Row row = sheet.getRow(1);

	        String typeName = formatter.formatCellValue(row.getCell(0));
	        String hasUnitPrice = formatter.formatCellValue(row.getCell(1));

	        // Add random number after type name
	        int rand = 10000 + random.nextInt(90000); // 5-digit random number
	        String uniqueTypeName = typeName + rand;

	        // Fill the Type Name field
	        wait.until(ExpectedConditions.visibilityOf(manageLocators.typeNameField)).sendKeys(uniqueTypeName);
	        System.out.println("✅ Type Name entered: " + uniqueTypeName);

	        // Handle the checkbox (use isSelected for best practice)
	        if (hasUnitPrice.equalsIgnoreCase("Yes")) {
	            WebElement checkboxInput = manageLocators.hasUnitPriceCheckbox.findElement(By.tagName("input"));
	            if (!checkboxInput.isSelected()) {
	                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", manageLocators.hasUnitPriceCheckbox);
	                wait.until(ExpectedConditions.elementToBeClickable(manageLocators.hasUnitPriceCheckbox)).click();
	                System.out.println("✅ 'Has unit price?' checkbox clicked.");
	            } else {
	                System.out.println("ℹ️ 'Has unit price?' is already checked.");
	            }
	        }

	        // Click Save and Exit
	        wait.until(ExpectedConditions.elementToBeClickable(manageLocators.saveAndExitExpenseTypeBtn)).click();
	        System.out.println("✅ Save and Exit clicked.");

	        // Wait for redirect
	        wait.until(ExpectedConditions.urlContains("/manage/expenseTypes"));
	        System.out.println("✅ Redirected to Expense Types main page.");

	        // Verify via search using the uniqueTypeName
	        wait.until(ExpectedConditions.visibilityOf(manageLocators.expenseTypeSearchField)).clear();
	        manageLocators.expenseTypeSearchField.sendKeys(uniqueTypeName);
	        Thread.sleep(2000);

	        if (driver.getPageSource().contains(uniqueTypeName)) {
	            System.out.println("✅ Expense Type '" + uniqueTypeName + "' found in search.");
	        } else {
	            System.out.println("⚠️ Expense Type '" + uniqueTypeName + "' NOT found in search (but not failing test).");
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	        throw new RuntimeException("❌ Failed to add and verify Expense Type.");
	    }
	}

	
	
	
	public void clickEditIconInExpenseTypes() {
		WebDriverWait wait = new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(manageLocators.editIconExpenseType)).click();
		System.out.println("✅ Clicked on edit icon.");
	}

	public void updateExpenseTypeFromExcelAndSearch() {
		String path = Filepath;
		String sheet = "ExpenseType";
		WebDriver driver = HelperClass.getDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		DataFormatter format = new DataFormatter();

		try (FileInputStream fis = new FileInputStream(path); XSSFWorkbook wb = new XSSFWorkbook(fis)) {

			Row row = wb.getSheet(sheet).getRow(2); // Updated data in row 3
			String updatedName = format.formatCellValue(row.getCell(0));
			String updatedUnitPrice = format.formatCellValue(row.getCell(1));

			WebElement nameField = manageLocators.typeNameField;
			nameField.clear();
			nameField.sendKeys(updatedName);
			System.out.println("✅ Updated name: " + updatedName);

			if (updatedUnitPrice.equalsIgnoreCase("Yes")) {
				if (!manageLocators.hasUnitPriceCheckbox.isSelected()) {
					manageLocators.hasUnitPriceCheckbox.click();
					System.out.println("✅ Checked 'Has unit price?'");
				}
			} else {
				if (manageLocators.hasUnitPriceCheckbox.isSelected()) {
					manageLocators.hasUnitPriceCheckbox.click();
					System.out.println("✅ Unchecked 'Has unit price?'");
				}
			}

			manageLocators.saveAndExitExpenseTypeBtn.click();
			System.out.println("✅ Clicked Save and Exit");

			wait.until(ExpectedConditions.urlContains("/expenseTypes"));
			System.out.println("✅ Navigated back to Expense Types main page");

			// Search and validate
			wait.until(ExpectedConditions.visibilityOf(manageLocators.expenseTypeSearchField)).clear();
			manageLocators.expenseTypeSearchField.sendKeys(updatedName);
			Thread.sleep(1500);

			if (driver.getPageSource().contains(updatedName)) {
				System.out.println("✅ Updated Expense Type '" + updatedName + "' found in search.");
			} else {
				System.out.println("⚠️ Updated Expense Type '" + updatedName + "' NOT found (not failing test).");
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("❌ Failed to update and search expense type.");
		}
	}
	
	
	//////////////////////////////////IMPORT ////////////////////////////////////
	

	    public void clickImportMenu() throws InterruptedException {
	    	Thread.sleep(2000);
	        wait.until(ExpectedConditions.elementToBeClickable(manageLocators.importMenu)).click();
	        System.out.println("✅ Clicked on Import Menu button.");
	    }

	    public void clickClientCheckBox() {
	        wait.until(ExpectedConditions.elementToBeClickable(manageLocators.clientCheckBox)).click();
	        System.out.println("✅ Clicked on client checkbox.");
	    }

	    public void clickNextButton() {
	        wait.until(ExpectedConditions.elementToBeClickable(manageLocators.nextButton)).click();
	        System.out.println("✅ Clicked on Next button.");
	    }

	    public void selectRandomModule() throws InterruptedException {
	        wait.until(ExpectedConditions.elementToBeClickable(manageLocators.moduleDropdown)).click();
	        Thread.sleep(5000);
	        
	        List<WebElement> options = manageLocators.moduleOptions;
	        if (!options.isEmpty()) {
	            Random random = new Random();
	            int randomIndex = random.nextInt(options.size());
	            WebElement randomOption = options.get(randomIndex);
	            wait.until(ExpectedConditions.elementToBeClickable(randomOption)).click();
//	            System.out.println("✅ Selected Module: " + randomOption.getText());
	        } else {
	            throw new RuntimeException("No module options found!");
	        }
	    }

	    public void selectAllClientTypes() throws InterruptedException {
	        Thread.sleep(5000);

	        wait.until(ExpectedConditions.elementToBeClickable(manageLocators.clientTypeDropdown)).click();
	        Thread.sleep(5000);

	        wait.until(ExpectedConditions.elementToBeClickable(manageLocators.clientTypeSelectAll)).click();
	        System.out.println("✅ Selected all client types.");
	    }
	
	    
	    public void clickAcceptAndContinueAndTakeScreenshot(String screenshotName) throws IOException, InterruptedException {
	        wait.until(ExpectedConditions.elementToBeClickable(manageLocators.acceptAndContinueButton)).click();
	        System.out.println("✅ Clicked on 'Accept And Continue'.");
	        Thread.sleep(2000);
	        wait.until(ExpectedConditions.elementToBeClickable(manageLocators.acceptAndContinueYesButton)).click();
	        System.out.println("✅ Clicked on 'Accept And Continue yes button'.");
	        Thread.sleep(2000);
	        wait.until(ExpectedConditions.elementToBeClickable(manageLocators.DoneButton)).click();
	        System.out.println("✅ Clicked on 'Accept And Continue Done button'.");
	        // Take screenshot
	        File screenshot = ((TakesScreenshot) HelperClass.getDriver()).getScreenshotAs(OutputType.FILE);
	        String filePath = System.getProperty("user.dir") + "/screenshots/" + screenshotName + ".png";
	        FileUtils.copyFile(screenshot, new File(filePath));
	        System.out.println("📸 Screenshot saved at: " + filePath);
	    }


	    
	    
	    public void clickBrowseButton() {
	        wait.until(ExpectedConditions.elementToBeClickable(manageLocators.browseButton)).click();
	        System.out.println("✅ Clicked on the Browse button.");
	    }
	    
	    public void clickSaveAndNext() {
	    	manageLocators.saveAndNextBtn.click();
	    	System.out.println("✅ Clicked on Save And Next button.");
	    }

	    public void clickDoneButton() {
	    	manageLocators.DoneButton.click();
	    	System.out.println("✅ Clicked on Done button.");
	    }
	    
	    
	    ////// for all options import ///////////////
	    
	    public void navigateToImportPage() throws InterruptedException {
	        Thread.sleep(2000);
	        wait.until(ExpectedConditions.elementToBeClickable(manageLocators.importMenu)).click();
	        System.out.println("✅ Navigated to Import Page.");
	    }

	    private static final Map<String, String> CATEGORY_FILE_PATH_MAP = Map.of(
	    	    "Clients", "C:\\Users\\Prakash\\Downloads\\Clients.xlsx",
	    	    "Tasks", "C:\\Users\\Prakash\\Downloads\\Tasks.xlsx",
	    	    "Users", "C:\\Users\\Prakash\\Downloads\\Users.xlsx",
	    	    "Expense Types", "C:\\Users\\Prakash\\Downloads\\ExpenseTypes.xlsx"
	    	);

	    
	    public void selectFileForCategory(String category) throws InterruptedException {
	        String filePath = CATEGORY_FILE_PATH_MAP.get(category);
	        if (filePath == null) throw new IllegalArgumentException("No file path mapped for " + category);

	        // Locate the file input after clicking 'Browse'
	        // Example: Assume only one file input visible at a time
	        WebElement fileInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[type='file']")));

	        fileInput.sendKeys(filePath);  // Directly set the file path
	        System.out.println("✅ File selected for " + category + ": " + filePath);
	        Thread.sleep(2000);
	    }

	    
	    public void importForAllCategories() throws InterruptedException, IOException {
	        Thread.sleep(2000);
	        wait.until(ExpectedConditions.elementToBeClickable(manageLocators.importMenu)).click();
	        System.out.println("✅ Clicked on Import Menu button.");

	        List<String> categories = Arrays.asList("Clients", "Tasks", "Users", "Expense Types");

	        for (String category : categories) {
	            System.out.println("🔄 Starting import for category: " + category);

	            WebElement categoryElement = driver.findElement(
	                By.xpath("//h2[normalize-space(.)='" + category + "']/ancestor::div[contains(@class,'import-card')]//mat-radio-button")
	            );

	            wait.until(ExpectedConditions.elementToBeClickable(categoryElement)).click();
	            System.out.println("✅ Clicked on category: " + category);

	            Thread.sleep(3500);
	            clickNextButton();
	            Thread.sleep(3500);
//	            clickBrowseButton();

	            // ---> FILE SELECTION <---
	            selectFileForCategory(category);
	            Thread.sleep(3500);
	            clickNextButton();
	            Thread.sleep(3000);
	            clickSaveAndNext();
	            Thread.sleep(3000);
	            clickDoneButton();

//	            clickAcceptAndContinueAndTakeScreenshot(category + "_Import");

	            System.out.println("✅ Completed import for category: " + category);
	            wait.until(ExpectedConditions.elementToBeClickable(manageLocators.importMenu)).click();
	            Thread.sleep(2000);
	        }
	    }
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    public void verifyImportSuccess() {
	        boolean successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(manageLocators.successMessage)).isDisplayed();
	        if (successMessage) {
	            System.out.println("✅ Import completed successfully.");
	        } else {
	            System.out.println("❌ Import did not complete successfully.");
	        }
	    }
	
	    
	    
	    
	    
	    
	    
	    
	    
	
	
	
	
	
	
	///////////////////////////////////// EXPORT //////////////////////////////
	
	public void clickExportMenu() throws InterruptedException {
		Thread.sleep(4000);
	    wait.until(ExpectedConditions.elementToBeClickable(manageLocators.exportMenu)).click();
	    System.out.println("✅ Clicked on export Menu button and menu is visible.");
	}

	
	   // Export for all combinations of date range, category, and download format
	public void exportAllDateRangesCategoriesAndFormats() throws InterruptedException {

	    By dateRangeDropdown = By.xpath("//div[contains(@class,'ng-select-container')]");
	    By dateRangePanelOptions = By.xpath("//div[contains(@class,'ng-dropdown-panel')]//div[contains(@class,'ng-option')]");
	    By categoryInput = By.xpath("//mat-checkbox//input[@type='checkbox']");
	    By categoryLabel = By.xpath("//mat-checkbox");
	    By downloadOptions = By.xpath("//button//p");
	    By exportButton = By.xpath("//button[contains(@class, 'action-button') and contains(@class, 'primary-button') and .//span[normalize-space()='Export']]");

	    // Open date range dropdown just to count options
	    wait.until(ExpectedConditions.elementToBeClickable(dateRangeDropdown));
	    driver.findElement(dateRangeDropdown).click();
	    wait.until(ExpectedConditions.visibilityOfElementLocated(dateRangePanelOptions));
	    List<WebElement> dateRangeOptions = driver.findElements(dateRangePanelOptions);
	    int totalDateRanges = dateRangeOptions.size();
	    // Close dropdown after counting
	    driver.findElement(dateRangeDropdown).click();
	    Thread.sleep(500);

	    for (int dRangeIdx = 0; dRangeIdx < totalDateRanges; dRangeIdx++) {
	        // >>> FIX: Always relocate and click the dropdown! <<<
	        wait.until(ExpectedConditions.elementToBeClickable(dateRangeDropdown));
	        driver.findElement(dateRangeDropdown).click();

	        wait.until(ExpectedConditions.visibilityOfElementLocated(dateRangePanelOptions));
	        List<WebElement> options = driver.findElements(dateRangePanelOptions);

	        // Re-pick WebElement every loop!
	        WebElement option = options.get(dRangeIdx);
	        String optionText = option.getText();
	        option.click();
	        System.out.println("Selected date range: " + optionText);
	        Thread.sleep(1000);

	        List<WebElement> categories = driver.findElements(categoryInput);
	        List<WebElement> categoryLabels = driver.findElements(categoryLabel);
	        int nCategories = categories.size();

	        for (int catIdx = 0; catIdx < nCategories; catIdx++) {
	            // Always re-fetch!
	            categories = driver.findElements(categoryInput);
	            categoryLabels = driver.findElements(categoryLabel);
	            WebElement catCheckbox = categories.get(catIdx);
	            WebElement catLabel = categoryLabels.get(catIdx);

	            if (!catCheckbox.isSelected()) {
	                wait.until(ExpectedConditions.elementToBeClickable(catLabel)).click();
	                Thread.sleep(300);
	            }

	            List<WebElement> formats = driver.findElements(downloadOptions);
	            int nFormats = formats.size();

	            for (int fmtIdx = 0; fmtIdx < nFormats; fmtIdx++) {
	                formats = driver.findElements(downloadOptions); // Refresh for stale cases
	                WebElement formatBtn = formats.get(fmtIdx).findElement(By.xpath("./ancestor::button"));
	                String fmtText = formats.get(fmtIdx).getText();

	                formatBtn.click();
	                Thread.sleep(400);

	                WebElement exportBtn = driver.findElement(exportButton);
	                exportBtn.click();
	                System.out.println("Exported: DateRange[" + (dRangeIdx + 1) + "], Category[" + (catIdx + 1) + "], Format[" + fmtText + "]");
	                Thread.sleep(1200);
	            }
	            // Uncheck category
	            if (catCheckbox.isSelected()) {
	                wait.until(ExpectedConditions.elementToBeClickable(catLabel)).click();
	                Thread.sleep(300);
	            }
	        }
	    }
	    System.out.println("✅ Completed export for all date ranges, categories, and formats.");
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
