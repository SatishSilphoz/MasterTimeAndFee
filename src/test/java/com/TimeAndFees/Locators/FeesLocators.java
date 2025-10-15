package com.TimeAndFees.Locators;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class FeesLocators {

	@FindBy(xpath = "//span[text()='Fees']")
	@CacheLookup
	public  WebElement TF_Fees;
	
	@FindBy(xpath = "//span[text()='Invoices']")
	@CacheLookup
	public  WebElement TF_Invoice;
	
	@FindBy(xpath = "//span[text()='Recurring']")
	@CacheLookup
	public  WebElement TF_RecurrInvoice;
	
	@FindBy(xpath = "//span[text()='Estimates']")
	@CacheLookup
	public  WebElement TF_Estimates;

	// invoice

	@FindBy(xpath = "//div[@role='combobox']//input[@type='text']")
	public  WebElement clientDropdown;

	@FindBy(xpath = "//input[@formcontrolname='titleStartDate']")
	public  WebElement invoiceDate;

	@FindBy(xpath = "//input[@formcontrolname='estimateId']")
	public  WebElement referenceField;

	@FindBy(xpath = "(//div[@class='ng-input']//input[@aria-autocomplete='list'])[2]")
	public  WebElement paymentDue;

	@FindBy(xpath = "//input[@formcontrolname='itemName']")
	public  WebElement jobDropdown;

	@FindBy(xpath = "//input[@formcontrolname='subItemName']")
	public  WebElement descriptionField;

	@FindBy(xpath = "//input[@formcontrolname='totalQuantity']")
	public  WebElement qtyField;

	@FindBy(xpath = "//input[@formcontrolname='price']")
	public  WebElement priceField;

	@FindBy(xpath = "//textarea[@formcontrolname='footer']")
	public  WebElement footerField;
	
	// end invoice
	
	@FindBy(xpath ="//span[text()]/ancestor::ng-select")
	public  WebElement TF_StatusFilterDropdown;
	
	@FindBy(xpath ="(//mat-icon[contains(text(),'add_circle_outline')])[2]")
	public  WebElement TF_PlusIcon;
	
	@FindBy(xpath = "//div[@role='option']")
	public List<WebElement> TF_StatusFilterOptions;
	
	@FindBy(xpath ="//p[contains(text(),'Amount') and contains(text(),'GBP')]/following::input[1]")
	public  WebElement TF_Amountfield;
	
	@FindBy(xpath = "//mat-option[@role='option']")
	public List<WebElement> TF_PageFilterOptions;
	
	@FindBy(xpath = "(//mat-form-field[contains(@appearance, 'fill')])[2]")
	public WebElement TF_PageFilterDropdown;
	
	@FindBy(xpath = "//ng-select[@formcontrolname='recurringType']//div[@aria-haspopup='listbox']")
	public WebElement TF_recurringtype;

	@FindBy(xpath = "//input[@formcontrolname='poId']")
	public  WebElement PO_ID;
	
	@FindBy(xpath = "//input[@formcontrolname='ref']")
	public  WebElement RefID_estimate;

}
