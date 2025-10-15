package com.TimeAndFees.Locators;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class SettingsLocators {

	@FindBy(xpath = "//mat-icon[contains(text(),'settings_outline')]")
	@CacheLookup
	public  WebElement TF_Settings;
	
	@FindBy(xpath = "//button[contains(text(),'My Business')]")
	@CacheLookup
	public  WebElement TF_Myubusiness;
	
	@FindBy(xpath = "//button[contains(text(),'Integrations')]")
	@CacheLookup
	public  WebElement TF_Intigration;
	
	@FindBy(xpath = "//input[@formcontrolname='companyNumber']")
	@CacheLookup
	public  WebElement TF_companynumber;
	
	@FindBy(xpath = "//input[@formcontrolname='vatNumber']")
	@CacheLookup
	public  WebElement TF_vatnumber;
	
	@FindBy(xpath = "//input[@formcontrolname='address1']")
	@CacheLookup
	public  WebElement TF_address1;
	
	@FindBy(xpath = "//input[@formcontrolname='address2']")
	@CacheLookup
	public  WebElement TF_address2;
	
	@FindBy(xpath = "//input[@formcontrolname='postCode']")
	@CacheLookup
	public  WebElement TF_postcode;
	
	@FindBy(xpath = "//input[@formcontrolname='city']")
	@CacheLookup
	public  WebElement TF_city;
	
	@FindBy(xpath = "//input[@formcontrolname='county']")
	@CacheLookup
	public  WebElement TF_county;
	
	@FindBy(xpath = "//input[@formcontrolname='fullName']")
	@CacheLookup
	public  WebElement TF_Fullname;
	
	@FindBy(xpath = "//input[@formcontrolname='name']")
	@CacheLookup
	public  WebElement TF_name;
	
	@FindBy(xpath = "//input[@formcontrolname='email']")
	@CacheLookup
	public  WebElement TF_email;
	
	@FindBy(xpath = "//input[@formcontrolname='phone']")
	@CacheLookup
	public  WebElement TF_phone;
	
	@FindBy(xpath = "//a[contains(text(),'Add New Line')]")
	@CacheLookup
	public  WebElement TF_addnewline;
	
	@FindBy(xpath = "//button[contains(text(),'Estimates')]")
	@CacheLookup
	public  WebElement TF_Estimate;
	
	@FindBy(xpath = "//a//span[contains(text(),'Fees')]")
	@CacheLookup
	public  WebElement TF_Fees;
	
	@FindBy(xpath = "//button[contains(text(),'Templates')]")
	@CacheLookup
	public  WebElement TF_Templates;
	
	@FindBy(xpath = "//textarea")
	@CacheLookup
	public  WebElement footer;
	
	@FindBy(xpath = "//mat-icon[contains(text(),'keyboard_double_arrow_down')]")
	@CacheLookup
	public  WebElement ExpendDown;
	
	@FindBy(xpath = "//mat-icon[contains(text(),'keyboard_double_arrow_up')]")
	@CacheLookup
	public  WebElement ExpendUP;
	
	@FindBy(xpath = "(//mat-radio-button)[1]")
	@CacheLookup
	public  WebElement TimeRadioBtn;
	
	@FindBy(xpath = "(//mat-radio-button)[2]")
	@CacheLookup
	public  WebElement GmailRadioBtn;
	
	@FindBy(xpath = "//span[contains(text(),'Save')]/ancestor::button")
	@CacheLookup
	public  WebElement SaveBtn;
	
	/////////////////////////////////praks//////////////////////////////////////////////////
	
	@FindBy(xpath = "//button[.//mat-icon[text()='data_usage'] and contains(.,'Demo Data')]")
	@CacheLookup
	public  WebElement TF_Demodata;
	
	@FindBy(xpath = "//button[normalize-space(.)='Add Demo Data']")
	@CacheLookup
	public  WebElement TF_AddDemodatabtn;
	
	@FindBy(xpath = "//button[normalize-space(.)='Yes']")
	@CacheLookup
	public  WebElement TF_AddDemodataYesbtn;
	
	
	@FindBy(xpath = "//input[@placeholder='Search']")
	@CacheLookup
	public  WebElement TF_Search;
	
	
	@FindBy(xpath = "//a[@href='/manage/clients' and normalize-space(span)='Manage']")
	@CacheLookup
	public WebElement managemenu;
  
	
	@FindBy(xpath = "//a[contains(@href, '/manage/tasks') and contains(., 'Tasks')]")
	@CacheLookup
	public WebElement tasksMenuLink;

	@FindBy(xpath = "//a[contains(@href, '/manage/users') and .//span[text()='Users']]")
	public WebElement usersMenuLink;
	
	@FindBy(xpath = "//a[contains(@class, 'menu-link') and contains(@href, '/manage/expenseTypes')]")
	public WebElement expenseTypesMenuLink;
	
	@FindBy(xpath = "//a[contains(@href,'/expenses/expenseList') and span[text()='Expenses']]")
	public WebElement expensesTab;
	
	@FindBy(xpath = "//a[@href='/invoicestype/invoiceOverview' and normalize-space(span)='Fees']")
	public WebElement FeesTab;
	
	@FindBy(xpath = "//a[@href='/invoicestype/invoices' and normalize-space(.//span)='Invoices']")
	public WebElement InvoiceTab;
	
	
	@FindBy(xpath = "//a[@href='/invoicestype/estimates' and normalize-space(.//span)='Estimates']")
	public WebElement EstimatesTab;
	
	@FindBy(xpath = "//a[@href='/jobs/jobList' and normalize-space(.//span)='Jobs']")
	public WebElement JobsTab;
	
	@FindBy(xpath = "//a[@href='/time/timesheet' and normalize-space(.//span)='Time']")
	public WebElement TimeTab;
	
	@FindBy(xpath = "//button[.//mat-icon[normalize-space(.)='receipt'] and contains(normalize-space(.), 'Invoices')]")
    @CacheLookup
    public WebElement invoiceSettingsMenu;
	
	
	 // Add Invoice button
    @FindBy(xpath = "//button[.//span[normalize-space(text())='Add Invoice']]")
    public WebElement AddInvoiceButton;

    // Invoice ID input (should be disabled if auto-generated)
    @FindBy(xpath = "//input[@formcontrolname='invoiceId']")
    public WebElement InvoiceIdField;
    

    // Add Manually radio button
    @FindBy(xpath = "//mat-radio-button[@value='2']//span[contains(.,'Add Manually')]")
    @CacheLookup
    public WebElement addManuallyRadio;

    // Save and Exit button
    @FindBy(xpath = "//button[.//span[normalize-space()='Save and Exit']]")
    @CacheLookup
    public WebElement saveAndExitButton;
	
    @FindBy(xpath = "//div[@class='ng-dropdown-panel-items']//div[contains(@class,'ng-option')]")
    public java.util.List<WebElement> paymentMethodOptions;
    
    // Edit Icon in Invoice Table
    @FindBy(xpath = "//button[@title='Edit']//mat-icon[normalize-space(text())='edit']")
    @CacheLookup
    public WebElement editIcon;

    // Record Payment Button
    @FindBy(xpath = "//button[.//span[contains(text(),'Record Payment')]]")
    @CacheLookup
    public WebElement recordPaymentButton;

    // Payment Method in Payment Dialog (selected label)
    @FindBy(xpath = "//span[contains(@class,'ng-value-label') and contains(@class, 'ng-star-inserted')]")
    public WebElement selectedPaymentMethodLabel;

    @FindBy(xpath = "//ng-select[@formcontrolname='paymentMethods']")
    @CacheLookup
    public WebElement paymentMethodDropdown;

	
	
 // Payment Due Term Dropdown (ng-select)
    @FindBy(xpath = "//ng-select[@formcontrolname='paymentDueTerms']")
    public WebElement paymentDueTermDropdown;

    // All options in dropdown (span containing text label)
    @FindBy(xpath = "//div[contains(@class,'ng-option')]//span[contains(@class,'ng-option-label')]")
    public List<WebElement> paymentDueTermOptions;

    // Selected Payment Due Term label (in main screen/dialog)
    @FindBy(xpath = "(//div[contains(@class,'ng-select-container') and contains(@class,'ng-has-value')]//span[contains(@class,'ng-value-label')])[2]")
    public WebElement selectedPaymentDueTermLabel;

	
	
 // VAT Checkbox input inside mat-checkbox
    @FindBy(xpath = "//label[@for='mat-checkbox-1-input']")
    public WebElement vatCheckbox;
	
	
    // Tax dropdown button
    @FindBy(xpath = "//button[contains(@class,'show-tax-button')]")
    public WebElement taxDropdownButton;
	
    // Settings footer textarea
    @FindBy(xpath = "//textarea[@formcontrolname='paymentFooter']")
    public WebElement settingsFooterTextarea;

    
 // Invoice footer textarea in add invoice
    @FindBy(xpath = "//textarea[@formcontrolname='footer']")
    public WebElement invoiceFooterTextarea;
	
 // Settings checkboxes (Type, Job Id, Hour/Qty)
    @FindBy(xpath = "//label[@for='mat-checkbox-2-input']")
    public WebElement typeCheckboxLabel;

    @FindBy(xpath = "//label[@for='mat-checkbox-3-input']")
    public WebElement jobIdCheckboxLabel;

    @FindBy(xpath = "//label[@for='mat-checkbox-5-input']")
    public WebElement hourQtyCheckboxLabel;

    // Invoice grid headers for validation
    @FindBy(xpath = "//span[@class='detail-title' and normalize-space(text())='Type']")
    public WebElement typeColumnHeader;

    @FindBy(xpath = "//span[@class='detail-title' and normalize-space(text())='Job Id - Task']")
    public WebElement jobIdColumnHeader;

    @FindBy(xpath = "//span[@class='detail-title' and contains(normalize-space(text()),'Hours/Qty')]")
    public WebElement hourQtyColumnHeader;
    
    
    // Rename input fields in settings
    @FindBy(xpath = "//input[@id='mat-input-6']")
    public WebElement typeRenameInput;

    @FindBy(xpath = "//input[@id='mat-input-7']")
    public WebElement jobIdRenameInput;

    @FindBy(xpath = "//input[@id='mat-input-8']")
    public WebElement descriptionRenameInput;

    @FindBy(xpath = "//input[@id='mat-input-9']")
    public WebElement hourqtyRenameInput;

    @FindBy(xpath = "//input[@id='mat-input-10']")
    public WebElement pricegbpRenameInput;

    @FindBy(xpath = "//input[@id='mat-input-11']")
    public WebElement amountRenameInput;

    
//    // Invoice grid headers (find by contains text – robust for renamed value!)
//    @FindBy(xpath = "//th//span[@class='detail-title' and contains(text(),'TestType')]")
//    public WebElement typeColumnHeader;
//
//    @FindBy(xpath = "//th//span[@class='detail-title' and contains(text(),'TestJobId')]")
//    public WebElement jobIdColumnHeader;

    @FindBy(xpath = "//th//span[@class='detail-title' and contains(text(),'TestDesc')]")
    public WebElement descriptionColumnHeader;

    @FindBy(xpath = "//th//span[@class='detail-title' and contains(text(),'TestHours')]")
    public WebElement hourqtyColumnHeader;

    @FindBy(xpath = "//th//span[@class='detail-title' and contains(text(),'TestPrice')]")
    public WebElement pricegbpColumnHeader;

    @FindBy(xpath = "//th//span[@class='detail-title' and contains(text(),'TestAmount')]")
    public WebElement amountColumnHeader;


 // Auto-generate radio button input
    @FindBy(xpath = "//input[@id='mat-radio-11-input']")
    public WebElement autoGenerateRadioButton;
    
    // Radio button container (optional - if you want to click visible circle)
    @FindBy(xpath = "//span[@class='mat-radio-container' and .//input[@id='mat-radio-11-input']]")
    public WebElement autoGenerateRadioButtonContainer;
    
}
