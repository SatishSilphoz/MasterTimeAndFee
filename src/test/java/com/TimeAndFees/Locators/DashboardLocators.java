package com.TimeAndFees.Locators;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class DashboardLocators {
	
	@FindBy(xpath = "//span[text()='Dashboard']")
	@CacheLookup
	public  WebElement TF_Dashboard;
	
	@FindBy(xpath = "//span[text()='Add Widget']")
	@CacheLookup
	public  WebElement TF_AddWidget;
	
	@FindBy(xpath = "//label[contains(@class, 'mat-checkbox-layout')]")
	public List<WebElement> TF_AllWidgetCheckboxes;
	
	@FindBy(xpath = "//button//span[contains(text(),'Save')]/ancestor::button")
	public WebElement TF_SaveBtn;
	
	@FindBy(xpath = "//ng-select[contains(@class, 'month-filter')]//div[contains(@class, 'ng-select-container')]")
	public WebElement TF_TimeFilterDropdown;
	
	@FindBy(xpath = "(//div[@class='ng-select-container ng-has-value'])[2]")
	public WebElement TF_TaskWiseHors;

	@FindBy(xpath = "//div[@role='option']")
	public List<WebElement> TF_TimeFilterOptions;
	
	@FindBy(xpath = "//button[@title='Lock']")
	public WebElement TF_Lockbtn;
	
	@FindBy(xpath = "//div[contains(@class, 'dashboard-widget-container')]")
	public List<WebElement> TF_AllWidgets;
	
	@FindBy(xpath = "//ng-select[contains(@class, 'w-200')]//div[contains(@class, 'ng-select-container')]")
	public WebElement TF_JobDropdown;

	@FindBy(xpath = "(//div[@role='option'])[2]")
	public List<WebElement> TF_JobDropdownOptions;

	@FindBy(xpath = "//mat-icon[text()='timer']")
	public WebElement TF_StartTimerBtn;
	
	@FindBy(xpath = "//div[@class='card p-0' and .//div[contains(text(), 'Timer')]]")
	public WebElement TF_TimerWidgetContainer;
	
	@FindBy(xpath = "(//div[@class='ng-select-container ng-has-value'])[5]")
	public WebElement TF_SubTaskDropdown;
	
	@FindBy(xpath = "//div[contains(@class,'timer-box')]//button[contains(., 'Start Timer')]")
	public WebElement TF_SecondStartTimerBtn ;
	
	@FindBy(xpath = "//mat-icon[text()='stop_circle']")
	public WebElement TF_StopTimerBtn ;
	
	@FindBy(xpath = "//div[contains(@class, 'dash-title') and contains(text(), 'Task Wise Hours Details')]/ancestor::div[contains(@class,'card')]//ng-select")
	public WebElement TF_Taskwisehourdropdown;
	
	@FindBy(xpath = "//div[contains(@class, 'dash-title') and contains(text(), 'Total Task Hours')]/ancestor::div[contains(@class,'card')]//ng-select")
	public WebElement TF_Totaltaskhourdropdown;
	
	
	
	









}
