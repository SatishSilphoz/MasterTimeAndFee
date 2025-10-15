package com.TimeAndFees.Locators;

import java.util.List;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class TimeLocators {
	
	@FindBy(xpath = "//span[text()='Time']")
	@CacheLookup
	public  WebElement TF_Time;
	
	@FindBy(xpath = "//span[text()='Add Time']")
	@CacheLookup
	public  WebElement TF_AddTimebtn;
	
	@FindBy(xpath = "//button[@mat-dialog-close and @type='button' and contains(@class,'secondary-button')]//span[normalize-space()='Cancel']")
	@CacheLookup
	public  WebElement TF_cancel;
	
	@FindBy(xpath = "//ng-select[@formcontrolname='jobId']//div[contains(@class, 'ng-select-container')]")
	@CacheLookup
	public  WebElement TF_JobDropdown;
	
	@FindBy(xpath = "//div[@role='option']")
	public List<WebElement> TF_JobOptions;;

	
	@FindBy(xpath = "//ng-select[@formcontrolname='subTaskId']//div[contains(@class,'ng-select-container')]")
	@CacheLookup
	public  WebElement TF_SubTaksDropdown;
	
	@FindBy(xpath = "//span[normalize-space(text())='SUB 1']")
	public List<WebElement> TF_SubTaskOptions;;
	
	@FindBy(xpath = "//button[@type='button' and @class='mat-focus-indicator action-button primary-button mr-1 mat-button mat-button-base']")
	@CacheLookup
	public  WebElement TF_SaveBtn;
	
	@FindBy(xpath = "//input[@placeholder='Search']")
	@CacheLookup
	public WebElement TF_Search;
	
	@FindBy(xpath = "//span[contains(@class, 'ng-value-label') and normalize-space(text())='Parekh Pratham']/ancestor::ng-select")
	@CacheLookup
	public WebElement TF_UserDropdown;
	
	@FindBy(xpath = "//mat-button-toggle[@value='Day']")
	@CacheLookup
	public WebElement TF_DayToggle;
	
	@FindBy(xpath = "//div[contains(@class, 'days')]")
	@CacheLookup
	public WebElement TF_Day;
	
	@FindBy(xpath = "//div[contains(@class, 'week font-size-14 line-height-normal')]")
	@CacheLookup
	public WebElement TF_WeekDay;
	
	@FindBy(xpath = "//div[contains(@class, 'month')]")
	@CacheLookup
	public WebElement TF_Month;
	
	@FindBy(xpath = "//mat-icon[contains(text(),'highlight_off')]") 
    @CacheLookup
    public WebElement TF_Closebtn;
	
	@FindBy(xpath = "//span[text()=' Yes ']") 
    @CacheLookup
    public WebElement TF_Yesbtn;
	
	@FindBy(xpath = "//button[@type='button']//span[text()=' Save ']") 
    @CacheLookup
    public WebElement TF_SavebtnGrid;
	
	@FindBy(xpath = "(//button[contains(@class, 'secondary-button')])[1]") 
    @CacheLookup
    public WebElement TF_SubmitApprovalBtn;
	
	@FindBy(xpath = "//mat-icon[text()='more_vert']") 
    @CacheLookup
    public WebElement TF_Toolbar;
	
	@FindBy(xpath = "//span[@class='mat-button-wrapper']//span[text()='Export']") 
    @CacheLookup
    public WebElement TF_ExportBtn;
	
	@FindBy(xpath = "//button[normalize-space(text())='Export']") 
    @CacheLookup
    public WebElement TF_ExportasPDF;
	
	@FindBy(xpath = "//mat-icon[normalize-space(text())='picture_as_pdf']/ancestor::button") 
    @CacheLookup
    public WebElement TF_ExporttoPDF;
	
	@FindBy(xpath = "//mat-dialog-container[@role='dialog']//input[@placeholder='MM']") 
    @CacheLookup
    public WebElement TF_TimeSpentInput;
	
	@FindBy(xpath = "//a[@class='menu-link']//span[text()='Unsubmitted']") 
    @CacheLookup
    public WebElement TF_UnsubmittedTab;
	
	@FindBy(xpath = "//span[contains(@class, 'ng-value-label ng-star-inserted') and (text())=' By User ']/ancestor::ng-select") 
    @CacheLookup
    public WebElement TF_ByUserDropdown;
	
	@FindBy(xpath = "//div[@role='option']")
	public List<WebElement> TF_Option;
	
	@FindBy(xpath = "//mat-select[@placeholder='Users']") 
    @CacheLookup
    public WebElement TF_UserDropdownFilter;
	
	@FindBy(xpath = "(//span[@class='mat-button-wrapper']//mat-icon[contains(text(),' keyboard_arrow_right ')])[2]") 
    @CacheLookup
    public WebElement TF_ExpendBtn;
	
	@FindBy(xpath = "//td[contains(@class,'cdk-column-fullName')]//a[starts-with(text(),'W')]") 
    @CacheLookup
    public WebElement TF_UserOverview;
	
	@FindBy(xpath = "//button[.//mat-icon[text()='email']]") 
    @CacheLookup
    public WebElement TF_SendreminderBtnOverview;
	
	@FindBy(xpath = "//textarea[@formcontrolname='message']") 
    @CacheLookup
    public WebElement TF_ReminderTextarea;
	
	@FindBy(xpath = "//button[@type='button']//span[text()='Send']") 
    @CacheLookup
    public WebElement TF_SendReminderSubmitButton;
	
	@FindBy(xpath = "//button[.//mat-icon[text()='check_circle']]") 
    @CacheLookup
    public WebElement TF_SubmitforapprovButton;
	
	@FindBy(xpath = "//button[.//mat-icon[contains(text(), 'description')] or contains(., 'Export to CSV')]") 
    @CacheLookup
    public WebElement TF_ExportasCSV;
	
	@FindBy(xpath = "//button[.//mat-icon[contains(text(), 'border_all')] or contains(., 'Export to Excel ')]") 
    @CacheLookup
    public WebElement TF_ExportasEXCEL;
	
	@FindBy(xpath = "//a[@class='menu-link']//span[text()='PFA']") 
    @CacheLookup
    public WebElement TF_PFASubTab;
	
	@FindBy(xpath = "//button[.//mat-icon[text()='edit_note']]") 
    @CacheLookup
    public WebElement TF_SendBtn;
	
	@FindBy(xpath = "(//button[.//mat-icon[text()='playlist_remove']])[2]") 
    @CacheLookup
    public WebElement TF_RejectBtn;
	
	@FindBy(xpath = "//mat-dialog-container[@role='dialog']//button[.//span[normalize-space(text())='Reject']]") 
    @CacheLookup
    public WebElement TF_RejectBtnDialoug;
	
	@FindBy(xpath = "//mat-dialog-container[@role='dialog']//button[.//span[normalize-space(text())='Approve']]") 
    @CacheLookup
    public WebElement TF_ApproveBtnDialoug;
	
	@FindBy(xpath = "//a[@class='menu-link']//span[text()='Approved']") 
    @CacheLookup
    public WebElement TF_ApprovedSubTab;
	
	@FindBy(xpath = "//button[.//mat-icon[text()='drive_file_move_rtl']]") 
    @CacheLookup
    public WebElement TF_WithdrawApprovebtn;
	
	@FindBy(xpath = "//mat-dialog-container[@role='dialog']//button[.//span[normalize-space(text())='Withdraw']]") 
    @CacheLookup
    public WebElement TF_WithdrawApprovebtnDialoug;
	
	@FindBy(xpath = "//a[@class='menu-link']//span[text()='Rejected']") 
    @CacheLookup
    public WebElement TF_RejectionSubTab;
	
	@FindBy(xpath = "//button[.//mat-icon[text()='assignment_returned']]") 
    @CacheLookup
    public WebElement TF_WithdrawRejectionbtn;
	
	@FindBy(xpath = "//mat-dialog-container[@role='dialog']//button[.//span[normalize-space(text())='Withdraw']]") 
    @CacheLookup
    public WebElement TF_WithdrawRejectionbtnDialoug;
	
	
	// Grid
	
//	@FindBy(xpath = "//button[@title='Send Reminder']") 
//    @CacheLookup
//    public WebElement TF_SendReminderGrid;
//	
//	@FindBy(xpath = "//button[@type='button']//span[text()='Withdraw Rejection']") 
//    @CacheLookup
//    public WebElement TF_SubmitApprovalGrid;
	
//	@FindBy(xpath = "//button[@type='button']//span[text()='Withdraw Rejection']") 
//    @CacheLookup
//    public WebElement TF_WithdrawRejectionbtn;
//	
//	@FindBy(xpath = "//button[@type='button']//span[text()='Withdraw Rejection']") 
//    @CacheLookup
//    public WebElement TF_WithdrawRejectionbtn;
//	
//	@FindBy(xpath = "//button[@type='button']//span[text()='Withdraw Rejection']") 
//    @CacheLookup
//    public WebElement TF_WithdrawRejectionbtn;
//	
//	@FindBy(xpath = "//button[@type='button']//span[text()='Withdraw Rejection']") 
//    @CacheLookup
//    public WebElement TF_WithdrawRejectionbtn;
//	
//	@FindBy(xpath = "//button[@type='button']//span[text()='Withdraw Rejection']") 
//    @CacheLookup
//    public WebElement TF_WithdrawRejectionbtn;
//	
//	@FindBy(xpath = "//button[@type='button']//span[text()='Withdraw Rejection']") 
//    @CacheLookup
//    public WebElement TF_WithdrawRejectionbtn;
	
	
	
	
	
	
	
	
	

}
