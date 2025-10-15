package com.TimeAndFees.Locators;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountMenuLocators {
	
	@FindBy(xpath = "//mat-icon[normalize-space()='add_circle_outline']//parent::a")
	public  WebElement TF_quick_add;
	
	@FindBy(xpath = "//mat-icon[contains(text(),'campaign')]")
	public  WebElement TF_Announcment;
	
	@FindBy(xpath = "//mat-icon[normalize-space()='confirmation_number']//parent::a")
	public  WebElement TF_Ticket;
	
	@FindBy(xpath = "//img[normalize-space(@title)='User Profile']")
	public  WebElement TF_profile;
	
	@FindBy(xpath = "//span[contains(text(),'Add Support Ticket')]")
	public  WebElement TF_AddTicket;
	
	@FindBy(xpath = "//a[contains(text(),'View All Activity')]")
	public  WebElement TF_AllActivityText;
	
	@FindBy(xpath = "//mat-icon[contains(text(),'history')]")
	public  WebElement TF_History;
	
	@FindBy(xpath = "//button[contains(text(),'Expenses')]")
	public  WebElement TF_Expesne;
	
	@FindBy(xpath = "//button[contains(text(),'Invoice')]")
	public  WebElement TF_Invoice;
	
	@FindBy(xpath = "//button[contains(text(),'Estimates')]")
	public  WebElement TF_Estimates;
	
	@FindBy(xpath = "//button[contains(text(),'Tasks')]")
	public  WebElement TF_Tasks;
	
	@FindBy(xpath = "//button[contains(text(),'Expense Types')]")
	public  WebElement TF_ExpenseTypes;
	
	@FindBy(xpath = "//button[contains(text(),'Timelog')]")
	public  WebElement TF_Timelog;
	
	@FindBy(xpath = "//button[contains(text(),'Recurring')]")
	public  WebElement TF_Recurring;
	
	@FindBy(xpath = "//button[contains(text(),'Clients')]")
	public  WebElement TF_Clients;
	
	@FindBy(xpath = "//button[contains(text(),'Users')]")
	public  WebElement TF_Users;
	
	@FindBy(xpath = "(//ng-select[contains(@class,'ng-select-single')]//div[@role='combobox'])[1]")
	public  WebElement TF_AllDropdown;
	
	@FindBy(xpath = "//div[@role='option']")
	public List<WebElement> TF_Options;
	
	@FindBy(xpath = "(//ng-select[contains(@class, '')]//div[contains(@class, 'ng-select-container')])[2]")
	public WebElement TF_TimeFilterDropdown;

	@FindBy(xpath = "//input[@formcontrolname='phone']")
	public WebElement PhoneNO;
	
	@FindBy(xpath = "//input[@formcontrolname='subject']")
	public WebElement Subject;
	
	@FindBy(xpath = "//textarea[@formcontrolname='message']")
	public WebElement Message;
	
	@FindBy(xpath = "//ng-select")
	public  WebElement TF_TicketDropdown;

}
