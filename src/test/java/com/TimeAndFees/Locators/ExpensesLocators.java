package com.TimeAndFees.Locators;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ExpensesLocators {

	@FindBy(xpath = "//a[contains(@href,'/expenses/expenseList') and span[text()='Expenses']]")
	public WebElement expensesTab;

	@FindBy(xpath = "//button[.//span[text()='Add Expense']]")
	public WebElement addExpenseBtn;

	@FindBy(xpath = "//ng-select[@formcontrolname='expenseType']")
	public WebElement expenseTypeDropdown;

	@FindBy(xpath = "//ng-select[@formcontrolname='client']")
	public WebElement clientDropdown;

	@FindBy(xpath = "//ng-select[@formcontrolname='task']")
	public WebElement taskDropdown;

	@FindBy(xpath = "//ng-select[@formcontrolname='user']")
	public WebElement userDropdown;

	@FindBy(xpath = "//input[@formcontrolname='expenseDate']")
	public WebElement dateField;

	@FindBy(xpath = "//input[@formcontrolname='numberOfUnits']")
	public WebElement noOfUnits;

	@FindBy(xpath = "//input[@formcontrolname='unitPrice']")
	public WebElement unitPrice;

	@FindBy(xpath = "//input[@formcontrolname='totalPrice']")
	public WebElement totalPrice;

	@FindBy(xpath = "//textarea[@formcontrolname='notes']")
	public WebElement notes;

	@FindBy(xpath = "//button[.//span[contains(text(),'Save')]]")
	public WebElement saveButton;

	@FindBy(xpath = "//button[.//span[contains(text(),'Save and Exit')]]")
	public WebElement saveAndExitButton;

	// Search input field (inside the mat-form-field)
	@FindBy(xpath = "//input[@placeholder='Search']")
	public WebElement searchInput;

	// Grid result element - adjust text or column to match your expected value
	@FindBy(xpath = "//tbody//td[contains(text(), 'Test Data')]") // change 'Test Data' dynamically in action class
	public WebElement searchResultCell;

	@FindBy(xpath = "//ng-select[contains(@class,'month-filter')]")
	public WebElement dateFilterDropdown;

	@FindBy(xpath = "//div[@class='ng-dropdown-panel-items scroll-host']//div[contains(@class,'ng-option')]")
	public List<WebElement> dateFilterOptions;

	@FindBy(xpath = "//ng-select[contains(@class,'ng-select') and contains(@class,'w-130')]//div[contains(@class,'ng-select-container')]")
	public WebElement statusDropdown;

	@FindBy(xpath = "//div[@role='option']//span[@class='ng-option-label ng-star-inserted']")
	public List<WebElement> statusOptions;

	@FindBy(xpath = "//ng-select[contains(@class,'ng-select-single') and contains(@class,'w-150')]")
	public WebElement expenseTypesDropdown;

	@FindBy(xpath = "//div[@role='option']//span[contains(@class,'ng-option-label')]")
	public List<WebElement> expenseTypeOptions;

	@FindBy(xpath = "//span[@class='ng-clear']")
	public WebElement expenseTypeClearIcon;

	@FindBy(xpath = "//span[contains(text(),'Users')]/ancestor::ng-select")
	public WebElement ExpenseuserDropdown;

	@FindBy(xpath = "//div[@role='option']//span[@class='ng-option-label ng-star-inserted']")
	public List<WebElement> userFilterOptions;
	
	@FindBy(xpath = "//button[@title='Delete']//mat-icon[text()='delete_outline']")
	public WebElement DeleteBtn;

	@FindBy(xpath = "//button[normalize-space(.)='Yes']")
	public WebElement yesButton;

	@FindBy(xpath = "//button[@title='Reminder' and .//mat-icon[text()='alternate_email']]")
	public WebElement ReminderBtn;
	
	@FindBy(xpath = "//button[@title='Submit' and .//mat-icon[text()='playlist_add_check']]")
	public WebElement SubmitBtn;
	
	@FindBy(xpath = "//button[@title='Edit' and .//mat-icon[text()='edit']]")
	public WebElement EditBtn;
	
	
}
