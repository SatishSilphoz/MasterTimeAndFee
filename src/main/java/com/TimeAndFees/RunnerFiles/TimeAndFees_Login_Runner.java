package com.TimeAndFees.RunnerFiles;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	    features = "src\\test\\resources\\TimeAndFees_FeatuteFiles\\Login.feature",
	    glue = "com.TimeAndFees.Stepdefinations",
	    tags = "",
	    plugin = {
	        "pretty",
	        "html:target/cucumber-reports/CucumberReport.html",
	        "json:target/cucumber-reports/CucumberReport.json",
	        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
	    },
	    monochrome = true
	)
public class TimeAndFees_Login_Runner extends AbstractTestNGCucumberTests{

}
