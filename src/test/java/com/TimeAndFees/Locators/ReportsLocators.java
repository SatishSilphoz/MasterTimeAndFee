package com.TimeAndFees.Locators;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ReportsLocators {

	@FindBy(xpath = "//span[text()='Reports']")
	public WebElement TF_Reports;
	
	@FindBy(xpath = "(//span[contains(text(),'')]/ancestor::ng-select)[1]")
	public WebElement TF_AllhoursDropdown;
	
	@FindBy(xpath = "//div[@role='option']")
	public List<WebElement> TF_Options;
	
	@FindBy(xpath = "(//span[contains(text(),'')]/ancestor::ng-select)[2]")
	public WebElement TF_groupByDropdown;

	@FindBy(xpath = "//div[@class='form-field']//span[@class='dropdown-btn']")
	public WebElement TF_clientsList;
	
	@FindBy(xpath = "//p[text()='Tasks']/following-sibling::ng-multiselect-dropdown//div[@class='multiselect-dropdown']")
	public WebElement TF_TaskList;
	
	@FindBy(xpath = "//p[text()='Users']/following-sibling::ng-multiselect-dropdown//div[@class='multiselect-dropdown']")
	public WebElement TF_UsersList;
	
	@FindBy(xpath = "//p[text()='Jobs']/following-sibling::ng-multiselect-dropdown//div[@class='multiselect-dropdown']")
	public WebElement TF_JobsList;
	
	@FindBy(xpath = "//p[text()='Expense Type']/following-sibling::ng-multiselect-dropdown//div[@class='multiselect-dropdown']")
	public WebElement TF_ExpenseList;
	
	@FindBy(xpath = "//p[text()='Status']/following-sibling::ng-multiselect-dropdown//div[@class='multiselect-dropdown']")
	public WebElement TF_StatusList;
	
	@FindBy(xpath = "//span[contains(text(),'Save Filter')]/ancestor::button")
	public WebElement TF_Savesilter;
	
	@FindBy(xpath = "//span[contains(text(),'Clear Filter')]/ancestor::button")
	public WebElement TF_Clear_filter;
	
	@FindBy(xpath = "//span[contains(text(),'Contractors')]/ancestor::ng-select")
	public WebElement TF_Contractordropdown;
}
