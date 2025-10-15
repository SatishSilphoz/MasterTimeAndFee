package com.TimeAndFees.Stepdefinations;

import com.Capium.Utilites.ConfigReader;
import com.Capium.Utilites.HelperClass;
import com.Capium.Utilites.Log;
import com.Capium.Utilites.StepTracker;
import com.TimeAndFees.Actions.LoginActions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefination {

	LoginActions loginpage = new LoginActions();

	@Given("Launch the browser")
	public void launch_the_browser() {
		StepTracker.setCurrentStep("Launch the browser");
		Log.info("Launch browser successfully.", "Browser Launching");

	}

	@Given("User need to enter the Application Url")
	public void user_need_to_enter_the_application_url() {
		String url = ConfigReader.getProperty("app.url");
		HelperClass.openPage(url);
		StepTracker.setCurrentStep("User need to enter the Application Url");
		Log.info("User need to enter the Application Url", "URL entered successfully.");
	}


	@When("User Enter username and password")
	public void user_enter_username() {
		String username = ConfigReader.getProperty("username");
		String password = ConfigReader.getProperty("password");
		loginpage.EnterUsername(username);
		loginpage.EnterPassword(password);
		StepTracker.setCurrentStep("User Enter username and Password");
		Log.info("Username and Password entered successfully.", "Credentials");

	}
	@Then("User Click on login button")
	public void user_click_on_login_button() {
		loginpage.ClickOnLogin();
		StepTracker.setCurrentStep("User Click on login button");
		Log.info("User Click on login button", "Redirection");

	}

	@Then("redirect to Time and Fees module")
	public void NavigateToModule() throws InterruptedException {
		loginpage.NavigateToModule("Time and Fees");
		StepTracker.setCurrentStep("Redirect to home page");
		Log.info("Redirect to home page", "Redirection");
		Hooks.captureScreenshotBase64(HelperClass.getDriver(), Hooks.getScenarioTest(), "Redirect to home page");

	}
}
