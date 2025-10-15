package com.TimeAndFees.Locators;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class JobLocators {

	@FindBy(xpath = "//span[text()='Jobs']//parent::a")
	@CacheLookup
	public  WebElement TF_Jobs;
	
	@FindBy(xpath = "//button[@name='Create']")
	@CacheLookup
	public  WebElement TF_AddJob;
	
	@FindBy(xpath = "//input[@formcontrolname='estimatedHours']")
	@CacheLookup
	public  WebElement TF_HourSpentInput;
	
	@FindBy(xpath = "//input[@formcontrolname='estimatedMinutes']")
	@CacheLookup
	public  WebElement TF_MinuteSpentInput;
	
	@FindBy(xpath = "//div[@class='cdk-overlay-pane']//input[@formcontrolname='estimatedHours']")
	@CacheLookup
	public  WebElement TF_HourSpentInputside;
	
	@FindBy(xpath = "//div[@class='cdk-overlay-pane']//input[@formcontrolname='estimatedMinutes']")
	@CacheLookup
	public  WebElement TF_MinuteSpentInputside;
	
	@FindBy(xpath = "(//mat-form-field[contains(@class, 'search-field')]//input[@placeholder='Search' and not(ancestor::div[contains(@style, 'display: none')])])[1]")
	@CacheLookup
	public  WebElement TF_Searchfield;
	
	@FindBy(xpath = "//span[text()=' Save & View Details ']/ancestor::button")
	@CacheLookup
	public  WebElement TF_SaveandViewdetailsbtn;
	
	@FindBy(xpath = "//span[text()=' Save & Add Another ']/ancestor::button")
	@CacheLookup
	public  WebElement TF_Saveandanotherbtn;
	
	@FindBy(xpath = "(//ng-select[@panelclass='myPanelClass']//input[@type='text'])[1]")
	@CacheLookup
	public  WebElement TF_EveryoneJobDropdown;
	
	@FindBy(xpath = "(//ng-select[@panelclass='myPanelClass']//input[@type='text'])[2]")
	@CacheLookup
	public  WebElement TF_StatusJobDropdown;
	
	@FindBy(xpath = "//span[@class='dropdown-btn']")
	@CacheLookup
	public  WebElement TF_TaskJobDropdown;
	
	@FindBy(xpath = "//button[@type='button']//span[text()=' Save ']")
	@CacheLookup
	public  WebElement TF_SaveBtn;
	
	@FindBy(xpath = "//ng-select[@panelclass='myPanelClass' and contains(@class,'w-120')]")
	public WebElement TF_TimeFilterDropdown;
	
	@FindBy(xpath = "//div[@role='option']/span")
	public List<WebElement> TF_TimeFilterOptions;
	
//	@FindBy(xpath = "//mat-icon[text()='more_vert']/ancestor::button") 
//    @CacheLookup
//    public WebElement TF_Toolbar;
	
	@FindBy(xpath = "(//div[@routerlinkactive='active']//span[text()='Calendar']/ancestor::div)[6]") 
    @CacheLookup
    public WebElement TF_CalendarSubTab;
	
	@FindBy(xpath = "(//mat-form-field[contains(@class, 'search-field')]//input[@placeholder='Search'])[2]")
    @CacheLookup
    public WebElement TF_Searchfield2;
	
	@FindBy(xpath = "//mat-icon[text()='edit']")
    @CacheLookup
    public WebElement TF_EditIcon;
	
	@FindBy(xpath = "//mat-icon[text()='delete_outline']")
    @CacheLookup
    public WebElement TF_deleteIcon;
	
	@FindBy(xpath = "//span[text()=' Add Subtask']")
    @CacheLookup
    public WebElement TF_Subtask;
	
	@FindBy(xpath = "//div[@class='ng-value ng-star-inserted']//span[text()=' Subtasks ']/ancestor::ng-select")
    @CacheLookup
    public WebElement TF_SubTaskDropdown;
	
	@FindBy(xpath = "//input[@formcontrolname='sentTo']")
    @CacheLookup
    public WebElement TF_SentTo;
	
	@FindBy(xpath = "//input[@formcontrolname='subject']")
    @CacheLookup
    public WebElement TF_Subject;
	
	@FindBy(xpath = "//textarea[@formcontrolname='message']")
    @CacheLookup
    public WebElement TF_Message;
	
	
	
	

	
	
}
