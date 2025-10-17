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
 * Parallel-ready Hooks class.
 * Each thread keeps its own ExtentTest and WebDriver instance.
 * Browser quits once per Runner (AfterAll).
 */
public class Hooks {

    // Thread-safe reporting objects
    private static ExtentReports extent = ExtentService.getInstance();
    private static ThreadLocal<ExtentTest> scenarioTest = new ThreadLocal<>();

    // Scenario-level context
    private static ThreadLocal<Map<String, Object>> scenarioContext = ThreadLocal.withInitial(HashMap::new);

    /* =========================================================
       One-time driver setup before any scenarios start (per suite)
       ========================================================= */
    @BeforeAll
    public static void globalSetup() {
        Log.info("Global driver setup initialized (parallel-ready).");
        System.out.println("Starting the Test Execution...");
    }

    /* =========================================================
       Before each scenario (per thread)
       ========================================================= */
    @Before
    public void beforeScenario(Scenario scenario) {
        // Only create browser if not already present for this thread/runner
        HelperClass.getDriver(); // This will only create browser if threadDriver.get() == null

        ExtentTest test = extent.createTest("Scenario: " + scenario.getName());
        scenarioTest.set(test);

        Log.info("Starting Scenario: " + scenario.getName());
        System.out.println("Starting Scenario: " + scenario.getName());
    }

    /* =========================================================
       Capture screenshot after each step (thread-safe)
       ========================================================= */
    @AfterStep
    public void afterStep(Scenario scenario) {
        WebDriver driver = HelperClass.getDriver();
        ExtentTest test = scenarioTest.get();

        String stepName = StepTracker.getCurrentStep();
        if (stepName == null || stepName.isEmpty()) {
            stepName = "Unnamed Step";
        }

        try {
            String base64Screenshot = ((TakesScreenshot) HelperClass.getDriver()).getScreenshotAs(OutputType.BASE64);

            if (scenario.isFailed()) {
                scenario.attach(Base64.getDecoder().decode(base64Screenshot), "image/png", stepName);
                test.log(Status.FAIL, stepName,
                        MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
                Log.info("Captured screenshot for failed step: " + stepName);
            } else {
                test.log(Status.PASS, stepName);
                Log.info("Captured screenshot for passed step: " + stepName);
            }

        } catch (Exception e) {
            Log.error("Failed to capture screenshot for step: " + stepName + " | Error: " + e.getMessage());
        }
    }

    /* =========================================================
       After each scenario (logout but keep driver until runner ends)
       ========================================================= */
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

            // Only logout, do NOT close browser here
            try {
                LoginActions loginPage = PageFactory.initElements(HelperClass.getDriver(), LoginActions.class);
                loginPage.Logout();
                Log.info("Successfully logged out after scenario.");
            } catch (Exception e) {
                Log.warn("Logout not required or failed: " + e.getMessage());
            }

        } catch (Exception e) {
            Log.error("Error in afterScenario: " + e.getMessage());
        } finally {
            // clear scenario context for this thread
            scenarioContext.get().clear();
        }
    }

    /* =========================================================
       After all scenarios of the Runner (quit browser per runner)
       ========================================================= */
    @AfterAll
    public static void afterAllScenarios() {
        System.out.println("Ending Test Execution for Runner...");
        try {
            HelperClass.tearDown();  // closes only current thread's driver
            Log.info("Browser closed successfully for this runner.");
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

    /* =========================================================
       Extra Utilities (same as before)
       ========================================================= */

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

    public static void captureScreenshot(String screenshotName, Scenario scenario, ExtentTest test) {
        try {
            WebDriver driver = HelperClass.getDriver();
            TakesScreenshot ts = (TakesScreenshot) HelperClass.getDriver();

            byte[] screenshotBytes = ts.getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshotBytes, "image/png", screenshotName);

            String base64Screenshot = ts.getScreenshotAs(OutputType.BASE64);
            test.log(Status.INFO, "Screenshot: " + screenshotName,
                    MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());

            File screenshotFile = ts.getScreenshotAs(OutputType.FILE);
            String filePath = System.getProperty("user.dir") + "/screenshots/" +
                    screenshotName + "_" + System.currentTimeMillis() + ".png";
            FileUtils.copyFile(screenshotFile, new File(filePath));

            Log.info("Saved screenshot: " + filePath);
        } catch (Exception e) {
            Log.error("Failed to capture screenshot: " + e.getMessage());
        }
    }

    public static void setScenarioContext(String key, Object value) {
        scenarioContext.get().put(key, value);
    }

    public static Object getScenarioContext(String key) {
        return scenarioContext.get().get(key);
    }

    public static void clearScenarioContext() {
        scenarioContext.get().clear();
    }

    public static ExtentTest getScenarioTest() {
        return scenarioTest.get();
    }

    public static void DetailsInfo(String message) {
        ExtentTest test = scenarioTest.get();
        test.log(Status.INFO, message);
        Log.info(message);
    }
}