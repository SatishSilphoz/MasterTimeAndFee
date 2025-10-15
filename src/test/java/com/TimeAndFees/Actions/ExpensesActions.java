package com.TimeAndFees.Actions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Capium.Utilites.ExcelUtil;
import com.Capium.Utilites.HelperClass;
import com.TimeAndFees.Locators.ExpensesLocators;
import com.TimeAndFees.Stepdefinations.Hooks;
import com.aventstack.extentreports.MediaEntityBuilder;

public class ExpensesActions {
	ExpensesLocators ExpensesLocators = null;
	WebDriverWait wait = HelperClass.getWait();
	WebDriver driver = HelperClass.getDriver();
	String Filepath = "D:\\TimeandFees_5.0\\src\\test\\resources\\invoice_data_template.xlsx";

	public ExpensesActions() {
		this.ExpensesLocators = new ExpensesLocators();
		PageFactory.initElements(driver, ExpensesLocators);
	}

	public void clickOnExpensesTab() {

		try {

//			HelperClass.waitForLoaderToDisappear(30);
			Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOf(ExpensesLocators.expensesTab));
			wait.until(ExpectedConditions.elementToBeClickable(ExpensesLocators.expensesTab));
			Thread.sleep(2000);

			System.out.println("Clicking TF_Jobs...");
			ExpensesLocators.expensesTab.click();

		} catch (Exception e) {
			System.err.println("Error in Navigate_to_Expense: " + e.getMessage());
			throw new RuntimeException(e);
		}

	}

	public void clickAddExpenseButton() throws InterruptedException {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		Thread.sleep(3000);
		// Wait until spinner overlay disappears
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ngx-spinner-overlay")));

		// Now click the button safely
		wait.until(ExpectedConditions.elementToBeClickable(ExpensesLocators.addExpenseBtn));
		ExpensesLocators.addExpenseBtn.click();
	}

	public void fillAddExpenseForm() throws IOException, InterruptedException {
		FileInputStream file = new FileInputStream(Filepath);
		XSSFWorkbook wb = new XSSFWorkbook(file);
		XSSFSheet sheet = wb.getSheet("AddExpense");
		int rowcount = sheet.getLastRowNum();

		DataFormatter formatter = new DataFormatter();
		SimpleDateFormat targetFormat = new SimpleDateFormat("dd/MM/yyyy");

		for (int i = 1; i <= rowcount; i++) {
			XSSFRow row = sheet.getRow(i);

			// Step 1: Navigate to Add Expense Page
			HelperClass.waitForLoaderToDisappear(30);
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//ng-select[@formcontrolname='expenseType']")));

			// Step 2: Read Excel Values
			String expenseType = ExcelUtil.getFormattedValue(row.getCell(0), formatter);
//			String client = ExcelUtil.getFormattedValue(row.getCell(1), formatter);
//			String task = ExcelUtil.getFormattedValue(row.getCell(2), formatter);
			String user = ExcelUtil.getFormattedValue(row.getCell(3), formatter);
//			String date = ExcelUtil.getFormattedDate(row.getCell(4), targetFormat, formatter);
			String noOfUnits = ExcelUtil.getFormattedValue(row.getCell(5), formatter);
			String unitPrice = ExcelUtil.getFormattedValue(row.getCell(6), formatter);
			String totalPrice = ExcelUtil.getFormattedValue(row.getCell(7), formatter);
//			String notes = ExcelUtil.getFormattedValue(row.getCell(8), formatter);

			// Step 3: Fill ng-select Dropdowns by typing and selecting
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ngx-spinner-overlay")));
			HelperClass.selectNgDropdownByTyping(By.xpath("//ng-select[@formcontrolname='expenseType']"), expenseType);

//		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ngx-spinner-overlay")));
//			HelperClass.selectNgDropdownByTyping(By.xpath("//ng-select[@formcontrolname='client']"), client);
//		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ngx-spinner-overlay")));
//			HelperClass.selectNgDropdownByTyping(By.xpath("//ng-select[@formcontrolname='task']"), task);

//		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ngx-spinner-overlay")));
			HelperClass.selectNgDropdownByTyping(By.xpath("//ng-select[@formcontrolname='user']"), user);

			// Step 4: Fill other fields
//			fillDateField(ExpensesLocators.dateField, date);
			HelperClass.ClickUsingJS(driver, By.xpath("//div[@class='sidenav-body-content']"));
			fill(ExpensesLocators.noOfUnits, noOfUnits);
			HelperClass.setValueUsingJS(By.xpath("//input[@formcontrolname='unitPrice']"), unitPrice);
//			fill(ExpensesLocators.unitPrice, unitPrice + Keys.ENTER);

			fill(ExpensesLocators.totalPrice, totalPrice);
//			fill(ExpensesLocators.notes, notes);

			// Step 5: Save the Expense
			wait.until(ExpectedConditions.elementToBeClickable(ExpensesLocators.saveAndExitButton));
			HelperClass.ClickUsingJS(driver, ExpensesLocators.saveAndExitButton);

			Thread.sleep(2000); // Optional pause
		}

		wb.close();
		file.close();
	}

	public void selectDropdownOption(WebElement dropdown, String visibleText) {
		dropdown.click();
		WebElement option = driver
				.findElement(By.xpath("//mat-option//span[normalize-space(text())='" + visibleText + "']"));
		wait.until(ExpectedConditions.elementToBeClickable(option));
		option.click();
	}

	public void fill(WebElement element, String value) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement input = wait.until(ExpectedConditions.elementToBeClickable(element));

		try {
			// Make sure it's editable (remove readonly if present)
			((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('readonly')", input);

			// Scroll into view (optional but useful)
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", input);

			// Click and set value using sendKeys
			input.click();
			input.sendKeys(Keys.CONTROL + "a");
			input.sendKeys(Keys.BACK_SPACE);
			input.sendKeys(value);
			input.sendKeys(Keys.TAB); // trigger blur/validation

		} catch (Exception e) {
			System.out.println("Fallback to JS value set due to error: " + e.getMessage());

			// Fallback: set value directly via JS
			((JavascriptExecutor) driver).executeScript("arguments[0].value='" + value + "';", input);
		}
	}

	public void fillDateField(WebElement field, String expenseDate) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		WebElement dateField = wait.until(ExpectedConditions.elementToBeClickable(field));

		try {
			// Remove readonly if it exists (common in Angular forms)
			((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('readonly')", dateField);

			// Click the date field
			dateField.click();

			// Select all text, then send the new date
			dateField.sendKeys(Keys.CONTROL + "a");
			dateField.sendKeys(expenseDate);

			// Optionally tab out to trigger any onBlur validation
			dateField.sendKeys(Keys.TAB);

		} catch (Exception e) {
			System.out.println("Date field not typeable directly, trying calendar picker fallback.");

			try {
				// Click calendar icon as fallback
				WebElement calendarIcon = driver.findElement(By.xpath("//button[@aria-label='Open calendar']"));
				calendarIcon.click();

				// optionally select a date in the calendar here

			} catch (Exception ex) {
				System.out.println("Could not open calendar picker either: " + ex.getMessage());
			}
		}
	}

	public void clickOnSearchField() throws InterruptedException {
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(ExpensesLocators.searchInput)).click();
	}

	public void searchAndValidate(String value) {
		WebElement searchField = wait.until(ExpectedConditions.visibilityOf(ExpensesLocators.searchInput));
		searchField.clear();
		searchField.sendKeys(value);
		searchField.sendKeys(Keys.ENTER);

		try {
			Thread.sleep(2000); // Wait for search results to load
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}

	public void click_on_date_filter_dropdown_and_select_all_options() throws InterruptedException {
		Thread.sleep(4000); // allow page to settle
		HelperClass.waitForLoaderToDisappear(30);

		// Step 1: Click to open dropdown and collect all option texts
		ExpensesLocators.dateFilterDropdown.click();
		Thread.sleep(2000);

		List<String> optionTexts = new ArrayList<>();
		for (WebElement option : ExpensesLocators.dateFilterOptions) {
			String text = option.getText().trim();
			if (!text.isEmpty()) {
				optionTexts.add(text);
			}
		}

		System.out.println("Options found in date filter: " + optionTexts);

		// Step 2: Loop through each option
		for (String optionText : optionTexts) {
			boolean found = false;

			// reopen dropdown every time
			ExpensesLocators.dateFilterDropdown.click();
			Thread.sleep(2000);

			// re-fetch fresh options
			List<WebElement> options = HelperClass.getDriver().findElements(By.xpath(
					"//div[@class='ng-dropdown-panel-items scroll-host']//div[contains(@class,'ng-option')]//span[@class='ng-option-label ng-star-inserted']"));

			for (WebElement opt : options) {
				String visibleText = opt.getText().trim();
				if (visibleText.equals(optionText)) {
					((JavascriptExecutor) HelperClass.getDriver()).executeScript("arguments[0].scrollIntoView(true);",
							opt);
					opt.click();
					found = true;
					System.out.println("Selected: " + optionText);

					// Screenshot
					Thread.sleep(2000);
					File screenshot = ((TakesScreenshot) HelperClass.getDriver()).getScreenshotAs(OutputType.FILE);
					String fileName = "screenshots/ExpenseDateFilter_" + optionText.replaceAll("[^a-zA-Z0-9]", "_")
							+ ".png";
					try {
						FileUtils.copyFile(screenshot, new File(fileName));
						System.out.println("Screenshot saved: " + fileName);
					} catch (IOException e) {
						System.out.println("Error saving screenshot: " + e.getMessage());
					}

					// Extent report screenshot
					String base64 = ((TakesScreenshot) HelperClass.getDriver()).getScreenshotAs(OutputType.BASE64);
					Hooks.getScenarioTest().info("Screenshot for: " + optionText,
							MediaEntityBuilder.createScreenCaptureFromBase64String(base64).build());

					break; // move to next optionText
				}
			}

			if (!found) {
				System.out.println("Option not found in dropdown: " + optionText);
			}
		}
	}

	public void selectAllStatusOptionsAndCapture() throws InterruptedException {
		Thread.sleep(3000); // Let the page settle
		HelperClass.waitForLoaderToDisappear(30);

		// Step 1: Open dropdown once and capture all option texts
		HelperClass.waitForElementToDisappear(By.xpath("//div[contains(@class,'ngx-spinner-overlay')]"), 30);
		ExpensesLocators.statusDropdown.click();
		Thread.sleep(1000);

		List<String> optionTexts = new ArrayList<>();
		for (WebElement option : ExpensesLocators.statusOptions) {
			String text = option.getText().trim();
			if (!text.isEmpty()) {
				optionTexts.add(text);
			}
		}

		System.out.println("Found status options: " + optionTexts);

		// Step 2: Loop and select each status option
		for (String statusName : optionTexts) {
			boolean found = false;

			// 🛑 Wait for spinner to disappear before clicking
			HelperClass.waitForElementToDisappear(By.xpath("//div[contains(@class,'ngx-spinner-overlay')]"), 30);
			ExpensesLocators.statusDropdown.click();
			Thread.sleep(2000);

			// Re-fetch the options fresh
			List<WebElement> freshOptions = HelperClass.getDriver()
					.findElements(By.xpath("//div[@role='option']//span[@class='ng-option-label ng-star-inserted']"));

			for (WebElement opt : freshOptions) {
				String visibleText = opt.getText().trim();
				if (visibleText.equalsIgnoreCase(statusName)) {
					((JavascriptExecutor) HelperClass.getDriver()).executeScript("arguments[0].scrollIntoView(true);",
							opt);
					opt.click();
					found = true;
					System.out.println("Selected status: " + statusName);

					// Screenshot
					Thread.sleep(1500);
					File screenshot = ((TakesScreenshot) HelperClass.getDriver()).getScreenshotAs(OutputType.FILE);
					String fileName = "screenshots/Status_" + statusName.replaceAll("[^a-zA-Z0-9]", "_") + ".png";
					try {
						FileHandler.copy(screenshot, new File(fileName));
						System.out.println("Screenshot saved: " + fileName);
					} catch (IOException e) {
						System.out.println("Error saving screenshot: " + e.getMessage());
					}

					// Extent Report
					String base64 = ((TakesScreenshot) HelperClass.getDriver()).getScreenshotAs(OutputType.BASE64);
					Hooks.getScenarioTest().info("Screenshot for status: " + statusName,
							MediaEntityBuilder.createScreenCaptureFromBase64String(base64).build());

					break;
				}
			}

			if (!found) {
				System.out.println("Status option not found: " + statusName);
			}
		}
	}

	public void click_on_expense_type_dropdown_and_select_all_options() throws InterruptedException {
		Thread.sleep(2000); // let the page settle
		HelperClass.waitForLoaderToDisappear(30);

		// Step 1: open the dropdown and get all the option texts
		ExpensesLocators.expenseTypesDropdown.click();
		Thread.sleep(1000);

		List<String> optionTexts = new ArrayList<>();
		for (WebElement option : ExpensesLocators.expenseTypeOptions) {
			String text = option.getText().trim();
			if (!text.isEmpty()) {
				optionTexts.add(text);
			}
		}

		System.out.println("Expense Type options found: " + optionTexts);

		// Step 2: loop through each option
		for (String optionText : optionTexts) {
			boolean found = false;

			// reopen dropdown every time
			ExpensesLocators.expenseTypesDropdown.click();
			Thread.sleep(1000);

			// refetch fresh options each time
			List<WebElement> options = HelperClass.getDriver()
					.findElements(By.xpath("//div[@role='option']//span[@class='ng-option-label ng-star-inserted']"));

			for (WebElement opt : options) {
				String visibleText = opt.getText().trim();
				if (visibleText.equalsIgnoreCase(optionText)) {
					((JavascriptExecutor) HelperClass.getDriver()).executeScript("arguments[0].scrollIntoView(true);",
							opt);
					opt.click();
					found = true;
					System.out.println("Selected Expense Type: " + optionText);

					// Screenshot
					Thread.sleep(2000);
					File screenshot = ((TakesScreenshot) HelperClass.getDriver()).getScreenshotAs(OutputType.FILE);
					String fileName = "screenshots/ExpenseType_" + optionText.replaceAll("[^a-zA-Z0-9]", "_") + ".png";
					try {
						FileUtils.copyFile(screenshot, new File(fileName));
						System.out.println("Screenshot saved: " + fileName);
					} catch (IOException e) {
						System.out.println("Error saving screenshot: " + e.getMessage());
					}

					// Extent report
					String base64 = ((TakesScreenshot) HelperClass.getDriver()).getScreenshotAs(OutputType.BASE64);
					Hooks.getScenarioTest().info("Screenshot for Expense Type: " + optionText,
							MediaEntityBuilder.createScreenCaptureFromBase64String(base64).build());

					break; // move to next optionText
				}
			}

			if (!found) {
				System.out.println("Option not found in dropdown: " + optionText);
			}
		}
	}

	public void selectAllUserOptionsAndCapture() throws InterruptedException {
		Thread.sleep(2000); // Let the page settle
		HelperClass.waitForLoaderToDisappear(30);

		// Open dropdown once and get all option texts
		ExpensesLocators.ExpenseuserDropdown.click();
		Thread.sleep(1000);

		List<String> optionTexts = new ArrayList<>();
		for (WebElement option : ExpensesLocators.userFilterOptions) {
			String text = option.getText().trim();
			if (!text.isEmpty()) {
				optionTexts.add(text);
			}
		}

		System.out.println("Found user options: " + optionTexts);

		// Loop through each user and select
		for (String userName : optionTexts) {
			boolean found = false;

			HelperClass.waitForElementToDisappear(By.xpath("//div[contains(@class,'ngx-spinner-overlay')]"), 30);
//	            ExpensesLocators.ExpenseuserDropdown.click();
			Thread.sleep(1000);

			HelperClass.waitUntilClickable(wait, ExpensesLocators.ExpenseuserDropdown).click();
			Thread.sleep(1000);

			List<WebElement> freshOptions = HelperClass.getDriver()
					.findElements(By.xpath("//div[@role='option']//span[@class='ng-option-label ng-star-inserted']"));

			for (WebElement opt : freshOptions) {
				String visibleText = opt.getText().trim();
				if (visibleText.equalsIgnoreCase(userName)) {
					((JavascriptExecutor) HelperClass.getDriver()).executeScript("arguments[0].scrollIntoView(true);",
							opt);
					opt.click();
					found = true;
					System.out.println("Selected user: " + userName);

					// Screenshot
					Thread.sleep(1500);
					File screenshot = ((TakesScreenshot) HelperClass.getDriver()).getScreenshotAs(OutputType.FILE);
					String fileName = "screenshots/User_" + userName.replaceAll("[^a-zA-Z0-9]", "_") + ".png";
					try {
						FileHandler.copy(screenshot, new File(fileName));
						System.out.println("Screenshot saved: " + fileName);
					} catch (IOException e) {
						System.out.println("Error saving screenshot: " + e.getMessage());
					}

					// Extent Report
					String base64 = ((TakesScreenshot) HelperClass.getDriver()).getScreenshotAs(OutputType.BASE64);
					Hooks.getScenarioTest().info("Screenshot for user: " + userName,
							MediaEntityBuilder.createScreenCaptureFromBase64String(base64).build());

					break;
				}
			}

			if (!found) {
				System.out.println("⚠️ User option not found: " + userName);
			}
		}
	}

	public void selct_user() throws InterruptedException {

		Thread.sleep(5000);
		wait.until(ExpectedConditions.elementToBeClickable(ExpensesLocators.ExpenseuserDropdown)).click();

		String userName = "yomox";
		JavascriptExecutor js = (JavascriptExecutor) HelperClass.getDriver();

		// Define a locator for all dropdown options
		By optionsLocator = By
				.xpath("//div[@class='ng-dropdown-panel-items scroll-host']//div[contains(@class, 'ng-option')]");
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

	public void Hover_on_record() throws InterruptedException {

		Thread.sleep(2000);
		WebElement gridRow = HelperClass.getDriver().findElement(By.xpath("//table/tbody/tr[1]"));
		HelperClass.forceHover(gridRow);

	}

	public void clickOnDeleteIcon() throws InterruptedException {
		Thread.sleep(3000);

		WebDriverWait wait = HelperClass.getWait1();

		try {
			// Click the "Send Reminder" button
			wait.until(ExpectedConditions.elementToBeClickable(ExpensesLocators.DeleteBtn)).click();
			System.out.println("Clicked Delete button");

		} catch (Exception e) {
			System.out.println("Error in sending reminder: " + e.getMessage());
		}

	}
	
	public void clickOnreminderIcon() throws InterruptedException {
		Thread.sleep(3000);

		WebDriverWait wait = HelperClass.getWait1();

		try {
			// Click the "Send Reminder" button
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//mat-icon[contains(text(),'alternate_email')]"))).click();
			System.out.println("📤 Clicked remidner button");

		} catch (Exception e) {
			System.out.println("❌ Error in sending reminder: " + e.getMessage());
		}

	}


	public void clickOnYesButton() {
		try {
			WebDriverWait wait = new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(ExpensesLocators.yesButton));

			ExpensesLocators.yesButton.click();
			System.out.println("Clicked on the Yes button in delete confirmation popup.");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Failed to click on the Yes button.");
		}
	}

	public void clickOnReminderIcon() {

		WebDriverWait wait = HelperClass.getWait1();

		try {
			// Click the "Send Reminder" button
			wait.until(ExpectedConditions.elementToBeClickable(ExpensesLocators.ReminderBtn)).click();
			System.out.println("📤 Clicked Delete button");

		} catch (Exception e) {
			System.out.println("❌ Error in sending reminder: " + e.getMessage());
		}

	}

	public void clickOnSubmitIcon() {

		WebDriverWait wait = HelperClass.getWait1();

		try {
			// Click the "Send Reminder" button
			wait.until(ExpectedConditions.elementToBeClickable(ExpensesLocators.SubmitBtn)).click();
			System.out.println("📤 Clicked Delete button");

		} catch (Exception e) {
			System.out.println("❌ Error in sending reminder: " + e.getMessage());
		}

	}
	
	public void clickEditIcon() throws InterruptedException {
	    HelperClass.waitForLoaderToDisappear(30);
	    ExpensesLocators.EditBtn.click();
	    Thread.sleep(1000); // wait for the edit form to open
	}

	
	public void editUnitPriceAndSave(String newUnitPrice) throws InterruptedException {
	    WebElement unitPriceInput = ExpensesLocators.unitPrice;

	    ((JavascriptExecutor) HelperClass.getDriver()).executeScript("arguments[0].focus(); arguments[0].value='';", unitPriceInput);
	    ExpensesLocators.unitPrice.clear();
	    Thread.sleep(5000);
	    unitPriceInput.sendKeys(newUnitPrice);
	    Thread.sleep(5000);

	    WebElement saveExitBtn = ExpensesLocators.saveAndExitButton;
	    ((JavascriptExecutor) HelperClass.getDriver()).executeScript("arguments[0].click();", saveExitBtn);

	    Thread.sleep(2000);
	}
	

}
