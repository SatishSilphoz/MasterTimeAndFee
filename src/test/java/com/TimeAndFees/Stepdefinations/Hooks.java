package com.TimeAndFees.Stepdefinations;

import java.io.File;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.Capium.Utilites.HelperClass;
import com.Capium.Utilites.Log;
import com.Capium.Utilites.StepTracker;
import com.TimeAndFees.Actions.LoginActions;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.service.ExtentService;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;

/**
 * Hooks class for Time and Fees module.
 * 
 * ✅ Supports ThreadLocal parallel execution
 * ✅ Groups reports Feature → Scenario (same as older modules)
 * ✅ Avoids duplicate feature nodes
 * ✅ Saves screenshots (Base64 + file)
 * ✅ Compatible with Capium365 Extent Report style
 */
public class Hooks {

    private static ExtentReports extent = ExtentService.getInstance();

    // Thread-safe feature/scenario storage
    private static ThreadLocal<ExtentTest> featureTest = new ThreadLocal<>();
    private static ThreadLocal<ExtentTest> scenarioTest = new ThreadLocal<>();

    // Shared map to store created features
    private static Map<String, ExtentTest> featureMap = new HashMap<>();

    @BeforeAll
    public static void setup() {
        HelperClass.setUpDriver();
        Log.info("Driver setup successfully");
        System.out.println("Starting the Test Execution...");
    }

    @Before
    public void beforeScenario(Scenario scenario) {
        // Extract feature name from URI
        String rawFeatureName = scenario.getUri().toString();
        rawFeatureName = rawFeatureName.substring(rawFeatureName.lastIndexOf("/") + 1)
                .replace(".feature", "").trim();

        // Normalize name (avoid duplicates caused by case or whitespace)
        String normalizedFeatureName = rawFeatureName.replaceAll("\\s+", "_").toLowerCase();

        ExtentTest feature;

        synchronized (featureMap) {
            if (featureMap.containsKey(normalizedFeatureName)) {
                feature = featureMap.get(normalizedFeatureName);
            } else {
                // Display name for report (keep clean)
                feature = extent.createTest("Feature: " + rawFeatureName);
                featureMap.put(normalizedFeatureName, feature);
            }
        }

        featureTest.set(feature);

        // Create Scenario Node under this feature
        ExtentTest scenarioNode = feature.createNode("Scenario: " + scenario.getName());
        scenarioTest.set(scenarioNode);

        System.out.println("Starting Scenario: " + scenario.getName());
        Log.info("Scenario: " + scenario.getName());
    }

    @AfterStep
    public void afterStep(Scenario scenario) {
        WebDriver driver = HelperClass.getDriver();
        ExtentTest test = scenarioTest.get();
        String stepName = StepTracker.getCurrentStep();

        if (stepName == null || stepName.isEmpty()) {
            stepName = "Unnamed Step";
        }

        try {
            String base64Screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);

            if (scenario.isFailed()) {
                scenario.attach(Base64.getDecoder().decode(base64Screenshot), "image/png", stepName);
                test.log(Status.FAIL, stepName,
                        MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
                Log.info("Captured screenshot for failed step: " + stepName);
            } else {
                test.log(Status.PASS, stepName);
                Log.info("Step passed: " + stepName);
            }

        } catch (Exception e) {
            Log.error("Failed to capture screenshot for step: " + stepName + " | Error: " + e.getMessage());
        }
    }

    @After
    public void afterScenario(Scenario scenario) {
        WebDriver driver = HelperClass.getDriver();
        ExtentTest test = scenarioTest.get();

        try {
            if (scenario.isFailed()) {
                test.log(Status.FAIL, "Scenario Failed: " + scenario.getName());
                Log.info("Scenario Failed: " + scenario.getName());
            } else {
                test.log(Status.PASS, "Scenario Passed: " + scenario.getName());
                Log.info("Scenario Passed: " + scenario.getName());
            }

            // Logout after each scenario
            try {
                LoginActions loginPage = PageFactory.initElements(driver, LoginActions.class);
                loginPage.Logout();
                Log.info("Successfully logged out after scenario.");
            } catch (Exception e) {
                Log.error("Logout failed after scenario: " + e.getMessage());
            }

        } catch (Exception e) {
            Log.error("Error in afterScenario: " + e.getMessage());
        }
    }

    @AfterAll
    public static void tearDown() {
        System.out.println("Ending Test Execution...");

        try {
            HelperClass.tearDown();
            Log.info("Browser closed successfully.");
        } catch (Exception e) {
            Log.error("Error during browser teardown: " + e.getMessage());
        }

        try {
            extent.flush();
            System.out.println("Extent report flushed successfully.");
        } catch (Exception e) {
            System.out.println("Error flushing extent report: " + e.getMessage());
        }
    }

    // Get current scenario ExtentTest (thread-safe)
    public static ExtentTest getScenarioTest() {
        return scenarioTest.get();
    }

    public static ExtentTest getFeatureTest() {
        return featureTest.get();
    }
    
    
    
    public static void captureScreenshotBase64(WebDriver driver, ExtentTest test, String message) {
        try {
            String base64Screenshot = ((TakesScreenshot) HelperClass.getDriver()).getScreenshotAs(OutputType.BASE64);
            test.log(Status.INFO, message,
                    MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
            Log.info("Screenshot captured: " + message);
        } catch (Exception e) {
            Log.error("Failed to capture screenshot: " + message + " | Error: " + e.getMessage());
        }
    }

    // Utility for screenshot
    public static void captureScreenshot(String screenshotName, Scenario scenario, ExtentTest scenarioTest) {
        try {
            WebDriver driver = HelperClass.getDriver();
            TakesScreenshot ts = (TakesScreenshot) driver;

            // Attach PNG to Cucumber
            byte[] screenshotBytes = ts.getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshotBytes, "image/png", screenshotName);

            // Attach Base64 to Extent
            String base64Screenshot = ts.getScreenshotAs(OutputType.BASE64);
            scenarioTest.log(Status.INFO, "Screenshot: " + screenshotName,
                    MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());

            // Save locally
            File screenshotFile = ts.getScreenshotAs(OutputType.FILE);
            String filePath = System.getProperty("user.dir") + "/screenshots/"
                    + screenshotName + "_" + System.currentTimeMillis() + ".png";
            FileUtils.copyFile(screenshotFile, new File(filePath));

            Log.info("Saved screenshot: " + filePath);

        } catch (Exception e) {
            Log.error("Failed to capture screenshot: " + e.getMessage());
            System.out.println("Screenshot error: " + e.getMessage());
        }
    }

    // Thread-safe context map per scenario
    private static ThreadLocal<Map<String, Object>> scenarioContext = ThreadLocal.withInitial(HashMap::new);

    public static void setScenarioContext(String key, Object value) {
        scenarioContext.get().put(key, value);
    }

    public static Object getScenarioContext(String key) {
        return scenarioContext.get().get(key);
    }

    public static void clearScenarioContext() {
        scenarioContext.get().clear();
    }
}
