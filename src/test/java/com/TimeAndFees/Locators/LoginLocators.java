package com.TimeAndFees.Locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class LoginLocators {
	
	@FindBy(xpath = "//input[@id='txtusername']")
	@CacheLookup
	public WebElement inputUsername;

	@FindBy(xpath = "//input[@id='txtpassword']")
	@CacheLookup
	public WebElement inputPassword;

	@FindBy(xpath = "//button[@id='btnLogin']")
	@CacheLookup
	public WebElement btnLogin;

	@FindBy(xpath = "//h1")
	@CacheLookup
	public WebElement Headingtag;
   // C module
	@FindBy(xpath = "//a[@title='Modules']")
	@CacheLookup
	public WebElement C_icon_inside_modules;

	@FindBy(xpath = "//p[normalize-space()='Welcome to your Capium EcoSystem']")
	@CacheLookup
	public WebElement Homepage_Element;

	
	
	
	@FindBy(xpath="//i[@class='icon fa fa-power-off']")
	@CacheLookup
	public WebElement Logout_element;
	
	@FindBy(xpath="//div[@class='profile-logo']//label")
	@CacheLookup
	public WebElement Logo_in_homepage;
	
	@FindBy(xpath="//a[normalize-space()='Logout']")
	@CacheLookup
	public WebElement Logout_inside_logo;
	
	@FindBy(xpath="//img[@title='User Profile']/ancestor::a")
	public WebElement FivePointProfileIcon;
	
	@FindBy(xpath="//a[normalize-space()='Sign Out']")
	public WebElement SignoutFivePointZero;
		
	@FindBy(xpath = "//h6[normalize-space()='Time and Fees']//parent::a")
	@CacheLookup
	public WebElement TimeAndFees_Module;
	
	@FindBy(xpath="//a[normalize-space()='Time and Fees']")
	public WebElement OldEcoTimeAndFees;
	
	@FindBy(xpath="//a[@href='/' and contains(@class,'my')]")
	public WebElement InsideCiconHome;
	
	@FindBy(xpath="//img[@alt='Capium Logo']//parent::div//parent::a")
	public WebElement CiconFivepoint_o;
	
	@FindBy(xpath="(//a[@class='btn btn-outline-primary'])[2]")
	@CacheLookup
	public WebElement loginbutton;
	
	@FindBy(xpath="//input[@type='text']")
	@CacheLookup
	public WebElement emailaddressTF;
}
