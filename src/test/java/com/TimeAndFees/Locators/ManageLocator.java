package com.TimeAndFees.Locators;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class ManageLocator {

	// manage menu on top
	@FindBy(xpath = "//a[@href='/manage/clients' and .//span[text()='Manage']]")
	@CacheLookup
	public WebElement managemenu;

	// add new client button
	@FindBy(xpath = "//span[contains(@class,'mat-button-wrapper')]//span[text()='Add Client']")
	@CacheLookup
	public WebElement addclientbtn;

	// company name on client creation form
	@FindBy(xpath = "//input[@formcontrolname='companyName']")
	@CacheLookup
	public WebElement InputCompanyName;

	// business start date on client creation form
	@FindBy(xpath = "//input[@formcontrolname='businessStartDate']")
	@CacheLookup
	public WebElement InputBusinessStartDate;

	@FindBy(xpath = "//input[@formcontrolname='bookStartDate']")
	public WebElement InputBookStartDate;

	@FindBy(xpath = "//input[@formcontrolname='companyNumber']")
	public WebElement InputRegistrationNo;

	@FindBy(xpath = "//input[@formcontrolname='utrNumber']")
	public WebElement InputUTRno;

	@FindBy(xpath = "//input[@formcontrolname='vatRegNumber']")
	public WebElement InputVatRegNo;

	@FindBy(xpath = "//input[@formcontrolname='vatRegistrationDate']")
	public WebElement InputVatRegDate;

	@FindBy(xpath = "//input[@formcontrolname='accountOfficeRefNumber']")
	public WebElement InputAccountOfficeRefNo;

	@FindBy(xpath = "//input[@formcontrolname='payeRefNumber']")
	public WebElement InputPAYERefNo;

	@FindBy(xpath = "//input[@formcontrolname='address']")
	public WebElement InputAddress1;

	@FindBy(xpath = "//input[@formcontrolname='city']")
	public WebElement InputCity;

	@FindBy(xpath = "//input[@formcontrolname='county']")
	public WebElement InputCounty;

	@FindBy(xpath = "//input[@formcontrolname='postalCode']")
	public WebElement InputZip;

	@FindBy(xpath = "//input[@formcontrolname='name']")
	public WebElement InputFullName;

	@FindBy(xpath = "//input[@formcontrolname='email']")
	public WebElement InputEmail;

	@FindBy(xpath = "//input[@formcontrolname='phone']")
	public WebElement InputPhone;

	@FindBy(xpath = "//input[@type='file']")
	public WebElement UploadLogo;

	@FindBy(xpath = "//button[.//span[normalize-space()='Save']]")
	public WebElement Savebtn;

	@FindBy(xpath = "//button[.//span[normalize-space()='Save and Exit']]")
	public WebElement Savenexitbtn;

	@FindBy(xpath = "//input[@placeholder='Search']")
	public WebElement ClientSearch;

	@FindBy(xpath = "((//tr[contains(@class, 'mat-row')]//div[@class='onelineclamp']/a[1]")
	@CacheLookup
	public WebElement ClickClient;

	@FindBy(xpath = "//button[@title='Edit' and .//mat-icon[text()='edit']]")
	@CacheLookup
	public WebElement EditBtn;

	@FindBy(xpath = "//div[contains(@class, 'row-card-class')]")
	@CacheLookup
	public WebElement HoverTarget;

	@FindBy(xpath = "//button[.//mat-icon[text()='delete_outline']]")
	@CacheLookup
	public WebElement DeleteBtn;

	@FindBy(xpath = "//span[@class='mat-checkbox-inner-container']")
	@CacheLookup
	public WebElement Deletecheckbox;

	@FindBy(xpath = "//button[span[text()=' Yes ']]")
	@CacheLookup
	public WebElement DeleteyesButton;

	@FindBy(xpath = "//mat-icon[normalize-space(text())='archive']/ancestor::button")
	@CacheLookup
	public WebElement ArchiveButton;
	@FindBy(xpath = "//button[span[text()=' Yes ']]")
	@CacheLookup
	public WebElement ArchiveYesButton;

	@FindBy(xpath = "//mat-icon[normalize-space(text())='more_vert']/ancestor::button")
	@CacheLookup
	public WebElement TF_Toolbar;

	@FindBy(xpath = "//button[.//mat-icon[contains(text(), 'description')] and contains(., 'Export to CSV')]")
	@CacheLookup
	public WebElement TF_ExportasCSV;

	@FindBy(xpath = "//button[.//mat-icon[contains(text(), 'border_all')] and contains(., 'Export to Excel ')]")
	@CacheLookup
	public WebElement TF_ExportasEXCEL;

	@FindBy(xpath = "//button[.//mat-icon[text()='picture_as_pdf'] and contains(., 'Export')]")
	@CacheLookup
	public WebElement TF_ExportasPDF;

	@FindBy(xpath = "//div[contains(@class,'ng-select-container')]")
	@CacheLookup
	public WebElement TF_StatusManageDropdown;

	@FindBy(xpath = "//div[@role='option']")
	@CacheLookup
	public List<WebElement> TF_TimeFilterOptions;

	////////////////////////////////////////////////// TASK
	////////////////////////////////////////////////// /////////////////////////////////////////////////////////

	@FindBy(xpath = "//a[contains(@href, '/manage/tasks') and contains(., 'Tasks')]")
	@CacheLookup
	public WebElement tasksMenuLink;

	@FindBy(xpath = "//button[.//span[text()='Add Task']]")
	@CacheLookup
	public WebElement addTaskButton;

	@FindBy(xpath = "//input[@formcontrolname='name']")
	public WebElement taskNameField;

	@FindBy(xpath = "//input[@formcontrolname='estimatedTime']")
	public WebElement estimatedTimeField;

	@FindBy(xpath = "//input[@formcontrolname='timeAndFeesPrice']")
	public WebElement feeInputField; // or use fixedPrice if needed

	@FindBy(xpath = "//input[@formcontrolname='name'][1]")
	public WebElement subTaskNameField;

	@FindBy(xpath = "//mat-checkbox[@formcontrolname='isBillable']//input[@type='checkbox']")
	public WebElement subTaskBillableCheckbox;

	@FindBy(xpath = "//mat-checkbox[contains(., 'Add to all future clients')]//input")
	public WebElement assignToAllClientsCheckbox;

	@FindBy(xpath = "//mat-checkbox[contains(., 'Add to all future users')]//input")
	public WebElement assignToAllUsersCheckbox;

	@FindBy(xpath = "//button[span[text()=' Save ']]")
	public WebElement saveTaskButton;

	@FindBy(xpath = "//input[@placeholder='Search']")
	public WebElement taskSearchInput;

	@FindBy(xpath = "//mat-icon[normalize-space(text())='edit']")
	public WebElement editIcontask;

	@FindBy(xpath = "//input[@formcontrolname='fixedPrice']")
	public WebElement fixedPriceInputField;

	@FindBy(xpath = "//input[@id='mat-radio-12-input' and @type='radio']")
	public WebElement fixedPriceRadio;
	
	@FindBy(xpath = "//button[.//span[contains(text(),'Save and Exit')]]")
	public WebElement saveAndExitTaskButton;
	
	
	/////////////////////////// USER //////////////////////////////////////
	
	
	@FindBy(xpath = "//a//span[text()='Users']")
	public WebElement usersMenuLink;

	@FindBy(xpath = "//button[@name='Create' and .//span[text()='Add User']]")
	public WebElement addUserButton;

	
	
	
	
	
	
	@FindBy(xpath = "//input[@formcontrolname='firstName']")
	public WebElement firstNameField;

	@FindBy(xpath = "//input[@formcontrolname='middleName']")
	public WebElement middleNameField;

	@FindBy(xpath = "//input[@formcontrolname='lastName']")
	public WebElement lastNameField;

	@FindBy(xpath = "//input[@formcontrolname='email']")
	public WebElement emailField;

	@FindBy(xpath = "//input[@formcontrolname='phone']")
	public WebElement phoneField;
	
	
//	permissions in form 
	@FindBy(xpath = "//ng-select[@formcontrolname='permissions']//div[@role='combobox']//input[@aria-autocomplete='list']")
	public WebElement roleDropdown;

//	@FindBy(xpath = "//input[@formcontrolname='title']")
//	public WebElement titleField;

//	bill rate in form
	@FindBy(xpath = "//input[@formcontrolname='billableRate']")
	public WebElement rateField;

//	capicity in form
	@FindBy(xpath = "//ng-select[@formcontrolname='capacity']//div[@role='combobox']//input")
	public WebElement hoursField;

	@FindBy(xpath = "//input[@formcontrolname='costRate']")
	public WebElement costRateField;

	@FindBy(xpath = "//button[.//span[text()=' Save and Exit ']]")
	public WebElement saveAndExitButton;

	@FindBy(xpath = "//input[@placeholder='Search']")
	public WebElement userSearchField;

	
	
	//////////////////////////////////////// EXPENSE TYPES ///////////////////////////
	
	@FindBy(xpath = "//a[contains(@class, 'menu-link') and contains(@href, '/manage/expenseTypes')]")
	public WebElement expenseTypesMenuLink;
	
	@FindBy(xpath = "//button[.//span[contains(text(), 'Add Expense Type')]]")
	public WebElement addExpenseTypeButton;

	@FindBy(xpath = "//input[@formcontrolname='name']")
	public WebElement typeNameField;
	
	@FindBy(xpath = "//mat-checkbox[@formcontrolname='hasUnitPrice']")
	public WebElement hasUnitPriceCheckbox;

	@FindBy(xpath = "//button[.//span[text()[normalize-space()='Save and Exit']]]")
	public WebElement saveAndExitExpenseTypeBtn;

	@FindBy(xpath = "//input[@placeholder='Search']")
	public WebElement expenseTypeSearchField;
	
	@FindBy(xpath = "//tbody/tr[1]//button[@title='Edit']")
	public WebElement editIconExpenseType;


	//////////////////////////////////////////////////////////EXport ////////////////////////////////////
	
	@FindBy(xpath = "//a[@href='/manage/export' and contains(@class, 'menu-link')]")
	public WebElement exportMenu;

	
	//////////////////////////// IMPORT ///////////////
	// Import menu button
    @FindBy(xpath = "//mat-icon[@title='Import']")
    public WebElement importMenu;
    
    // Client checkbox (radio button)
    @FindBy(xpath = "//mat-radio-button[@id='mat-radio-11']")
    public WebElement clientCheckBox;

    // Next button
    @FindBy(xpath = "//button[span[normalize-space(text())='Next']]")
    public WebElement nextButton;
    
    
 // Module dropdown
    @FindBy(xpath = "//ng-select[contains(@class,'import-dropdown')]")
    public WebElement moduleDropdown;

    // Module options
    @FindBy(xpath = "//div[contains(@class,'ng-option')]//span[@class='ng-option-label ng-star-inserted']")
    public List<WebElement> moduleOptions;

    // Client Type dropdown
    @FindBy(xpath = "//div[contains(@class,'multiselect-dropdown')]")
    public WebElement clientTypeDropdown;

    // Select All option inside Client Type dropdown
    @FindBy(xpath = "//li[@class='multiselect-item-checkbox ng-star-inserted']//div[normalize-space()='Select All']")
    public WebElement clientTypeSelectAll;

    @FindBy(xpath = "//button[.//span[text()=' Accept And Continue ']]")
    public WebElement acceptAndContinueButton;
    
    @FindBy(xpath = "//button[normalize-space(span/text())='Yes']")
    public WebElement acceptAndContinueYesButton;
	
    @FindBy(xpath = "//button[normalize-space(.)='Done']")
    public WebElement DoneButton;
    
    
    public By moduleList = By.xpath("//div[contains(@class,'module-selection')]//mat-radio-button");
    public By clientTypeCheckboxes = By.xpath("//mat-checkbox");
    public By successMessage = By.xpath("//div[contains(text(),'Import completed successfully')]");
    
 // Locator for the Browse button
    @FindBy(xpath = "//button[contains(@class,'file-upload-button')]")
    public WebElement browseButton;
    
    @FindBy(xpath = "//button[contains(@class,'primary-button') and .//span[normalize-space()='Save And Next']]")
    public WebElement saveAndNextBtn;


    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

}
