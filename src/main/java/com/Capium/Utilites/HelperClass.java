// File: HelperClass.java
package com.Capium.Utilites;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.function.Supplier;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import io.cucumber.java.Scenario;

public class HelperClass {

    // ThreadLocal based WebDriver and WebDriverWait to support parallel execution (one browser per TestNG class/runner)
    private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();
    private static ThreadLocal<WebDriverWait> threadWait = new ThreadLocal<>();
    private static final int TIMEOUT = 10;
    private static String screenshotDirectory = "screenshots/";
    private static ExtentTest scenarioTest;
    public static int rowCountBeforeDelete;

    private HelperClass() {
        // kept private to prevent direct instantiation
    }

    // Returns the WebDriver for current thread. Initializes if absent.
    public static WebDriver getDriver() {
        if (threadDriver.get() == null) {
            setUpDriver();
        }
        return threadDriver.get();
    }

    // Returns the WebDriverWait for current thread. Initializes if absent.
    public static WebDriverWait getWait() {
        if (threadWait.get() == null) {
            setUpDriver();
        }
        return threadWait.get();
    }

    // Initialize ChromeDriver for current thread
    public static void setUpDriver() {
        try {
        	 System.setProperty("webdriver.chrome.driver", "C:\\selenium-drivers\\chromedriver.exe");

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");

            ChromeDriver chrome = new ChromeDriver(options);
            chrome.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));

            threadDriver.set(chrome);
            threadWait.set(new WebDriverWait(chrome, Duration.ofSeconds(TIMEOUT)));
        } catch (Exception e) {
            System.out.println("Error initializing ChromeDriver: " + e.getMessage());
            throw e;
        }
    }

    // Tear down driver for current thread
    public static void tearDown() {
        WebDriver drv = threadDriver.get();
        if (drv != null) {
            try {
                drv.quit();
            } catch (Exception e) {
                System.out.println("Error quitting driver: " + e.getMessage());
            } finally {
                threadDriver.remove();
                threadWait.remove();
            }
        }
    }

    public static void openPage(String url) {
        if (getDriver() == null) {
            setUpDriver();
        }
        getDriver().get(url);
    }

    public static void waitUntilPageLoaded() {
        try {
            getWait().until(webDriver -> ((org.openqa.selenium.JavascriptExecutor) webDriver)
                    .executeScript("return document.readyState").equals("complete"));
        } catch (Exception e) {
            System.out.println("Page load wait timeout: " + e.getMessage());
        }
    }
    
    public static WebElement waitForVisibility(WebElement element) {
        return getWait().until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForAngularLoad() {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        getWait().until(driver -> js.executeScript("return document.readyState").equals("complete"));
        getWait().until(driver -> js.executeScript(
                "return !!window.angular && angular.element(document.body).injector().get('$http').pendingRequests.length === 0"));
    }

    public static WebElement waitUntilVisible(By locator) {
        return getWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement waitUntilClickable(By locator) {
        return getWait().until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static WebElement waitUntilClickable(WebElement element) {
        WebDriverWait wait = HelperClass.getWait();
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static boolean safeClick(By locator) {
        int attempts = 0;
        while (attempts < 5) {
            try {
                WebElement element = waitUntilClickable(locator);
                scrollToElement(locator);
                element.click();
                return true;
            } catch (Exception e) {
                attempts++;
                sleep(1000);
            }
        }
        return false;
    }

    public static boolean safeClick(WebElement element) {
        int attempts = 0;
        while (attempts < 5) {
            try {
                waitUntilClickable(element); // Ensure element is clickable
                scrollToElement(element); // Scroll into view
                clickUsingJS(element); // Try clicking
                return true;
            } catch (Exception e) {
                attempts++;
                sleep(1000); // Wait 1 second before retrying
            }
        }
        return false;
    }

    public static boolean safeSendKeys(By locator, String text) {
        int attempts = 0;
        while (attempts < 5) {
            try {
                WebElement element = waitUntilVisible(locator);
                scrollToElement(locator);
                element.clear();
                element.sendKeys(text);
                return true;
            } catch (Exception e) {
                attempts++;
                sleep(1000);
            }
        }
        return false;
    }
    
    public static void safeClick(WebElement element, String logMessage) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(element));
        scrollIntoView(element);
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public static boolean safeSelectByVisibleText(By locator, String visibleText) {
        int attempts = 0;
        while (attempts < 5) {
            try {
                WebElement dropdown = waitUntilVisible(locator);
                scrollToElement(locator);
                new Select(dropdown).selectByVisibleText(visibleText);
                return true;
            } catch (Exception e) {
                attempts++;
                sleep(1000);
            }
        }
        return false;
    }

    public static void scrollToElement(By locator) {
        WebElement element = waitUntilVisible(locator);
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void scrollToElement(WebElement element) {
        try {
            ((JavascriptExecutor) getDriver())
                    .executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'});", element);
            sleep(500);
        } catch (Exception e) {
            System.out.println("Failed to scroll to element: " + e.getMessage());
        }
    }

    public static void highlightElement(WebElement element) {
        WebDriver driver = HelperClass.getDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;

        String originalStyle = element.getAttribute("style");

        js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element,
                "border: 2px solid red; background-color: yellow;");
        sleep1(TIMEOUT);
        js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, originalStyle);
    }

    public static String captureScreenshot(String screenshotName) throws IOException {
        TakesScreenshot screenshot = (TakesScreenshot) getDriver();
        File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
        String screenshotPath = screenshotDirectory + screenshotName + ".png";
        File destinationFile = new File(screenshotPath);
        FileUtils.copyFile(sourceFile, destinationFile);
        return screenshotPath;
    }

    public static String getText(By locator) {
        try {
            return waitUntilVisible(locator).getText().trim();
        } catch (Exception e) {
            return "";
        }
    }

    public static boolean waitForTextPresent(By locator, String expectedText) {
        try {
            return getWait().until(ExpectedConditions.textToBePresentInElementLocated(locator, expectedText));
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isElementPresent(By locator) {
        try {
            return getDriver().findElement(locator).isDisplayed();
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            return false;
        }
    }

    public static boolean isElementPresentAndDisplayed(By locator) {
        List<WebElement> elements = getDriver().findElements(locator);
        return elements.size() > 0 && elements.get(0).isDisplayed();
    }

    public static boolean isElementEnabled(By locator) {
        try {
            return getDriver().findElement(locator).isEnabled();
        } catch (Exception e) {
            return false;
        }
    }

    public static void waitForLoaderToDisappear(By loaderLocator) {
        getWait().until(ExpectedConditions.invisibilityOfElementLocated(loaderLocator));
    }

    public static void clickUsingJS(By locator) {
        WebElement element = waitUntilVisible(locator);
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", element);
    }

    public static void clickUsingJS(WebElement element) {
        getWait().until(ExpectedConditions.visibilityOf(element));
        getWait().until(ExpectedConditions.elementToBeClickable(element));
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", element);
    }

    public static WebElement waitUntilVisible(WebDriverWait wait, WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static WebElement waitUntilVisible(WebDriverWait wait, By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void setValueUsingJS(By locator, String value) {
        WebElement element = waitUntilVisible(locator);
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].value='" + value + "';", element);
        ((JavascriptExecutor) getDriver())
                .executeScript("arguments[0].dispatchEvent(new Event('change', { bubbles: true }));", element);
    }

    private static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void sleep1(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    // dropdown method for 5.0
    public static void selectAllDropdownOptions(By dropdownToggleLocator, By optionLocator, By resultValidationLocator,
            String dropdownLabel) throws IOException {
        HelperClass.safeClick(dropdownToggleLocator);
        HelperClass.sleep1(1000); // Wait for dropdown to appear

        List<WebElement> options = HelperClass.getDriver().findElements(optionLocator);
        int optionCount = options.size();

        for (int i = 0; i < optionCount; i++) {
            HelperClass.safeClick(dropdownToggleLocator);
            HelperClass.sleep1(500);

            List<WebElement> currentOptions = HelperClass.getDriver().findElements(optionLocator);
            if (i >= currentOptions.size())
                break;

            WebElement option = currentOptions.get(i);
            String optionText = option.getText().trim();
            System.out.println("Selecting " + dropdownLabel + " option: " + optionText);

            HelperClass.scrollToElement(option);
            option.click();

            // Wait for result to update
            try {
                WebDriverWait wait = HelperClass.getWait();
                wait.until(ExpectedConditions.or(ExpectedConditions.visibilityOfElementLocated(resultValidationLocator),
                        ExpectedConditions.textToBePresentInElementLocated(resultValidationLocator, optionText)));

                // Validate that selected option is reflected in result
                WebElement resultElement = HelperClass.getDriver().findElement(resultValidationLocator);
                String actualText = resultElement.getText().trim();

                if (actualText.toLowerCase().contains(optionText.toLowerCase())) {
                    System.out.println("Match successful: '" + optionText + "' is correctly reflected.");
                } else {
                    System.out.println("Mismatch: Selected '" + optionText + "' but found '" + actualText + "'");
                }

            } catch (Exception e) {
                System.out.println("Timeout or no matching result found for option: " + optionText);
            }

            // Capture screenshot after selection
            HelperClass
                    .captureScreenshot("Selection_" + dropdownLabel + "_" + optionText.replaceAll("[^a-zA-Z0-9]", "_"));

            HelperClass.sleep1(800);
        }
    }

    public static List<WebElement> retryUntilNotEmpty(Supplier<List<WebElement>> supplier) {
        for (int i = 0; i < 5; i++) {
            try {
                List<WebElement> elements = supplier.get();
                if (!elements.isEmpty())
                    return elements;
            } catch (Exception ignored) {
            }
            sleep1(500);
        }
        return new ArrayList<>();
    }

    public static void clickWithRetry(WebElement element, WebDriver driver, WebDriverWait wait) {
        int attempts = 0;
        while (attempts < 3) {
            try {
                wait.until(ExpectedConditions.elementToBeClickable(element)).click();
                return;
            } catch (ElementClickInterceptedException | StaleElementReferenceException e) {
                System.out.println("Retry click #" + (attempts + 1) + " for: " + element);
                attempts++;
                HelperClass.sleep1(500);
            }
        }

        // Fallback to JavaScript click
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", element);
            System.out.println("Fallback: JavaScript click used.");
        } catch (Exception jsEx) {
            System.out.println("JS click failed: " + jsEx.getMessage());
        }
    }

    public static void validateDropdownWithSummaryCounts(By dropdownLocator, By optionsLocator, By tableRowLocator,
            String dropdownName) throws IOException {
        HelperClass.safeClick(dropdownLocator);
        HelperClass.sleep1(1000); // wait for dropdown options to load

        List<WebElement> options = HelperClass.getDriver().findElements(optionsLocator);

        for (int i = 0; i < options.size(); i++) {
            // Reopen dropdown on each loop
            HelperClass.safeClick(dropdownLocator);
            HelperClass.sleep1(500);

            List<WebElement> currentOptions = HelperClass.getDriver().findElements(optionsLocator);
            if (i >= currentOptions.size())
                break;

            WebElement option = currentOptions.get(i);
            String optionText = option.getText().trim();
            System.out.println("Selecting " + dropdownName + " option: " + optionText);

            HelperClass.scrollToElement(option);
            option.click();

            HelperClass.sleep1(1500); // wait for table to reload

            // Count table rows
            int actualRowCount = HelperClass.getDriver().findElements(tableRowLocator).size();

            // Get expected count from summary
            int expectedCount = 0;
            if (optionText.equalsIgnoreCase("All Status")) {
                expectedCount += getStatusCount("Processing");
                expectedCount += getStatusCount("To Review");
                expectedCount += getStatusCount("Success");
                expectedCount += getStatusCount("Archived");
                expectedCount += getStatusCount("Duplicate");
            } else {
                expectedCount = getStatusCount(optionText);
            }

            // Capture screenshot
            HelperClass.captureScreenshot("Status_" + optionText.replaceAll("\\s+", "_"));

            // Log validation result
            if (expectedCount == actualRowCount) {
                System.out.println("" + optionText + " - Row count matches: " + expectedCount);
            } else {
                System.out.println(
                        "" + optionText + " - Mismatch! Expected: " + expectedCount + ", Actual: " + actualRowCount);
            }

            HelperClass.sleep1(1000);
        }
    }

    public static int getStatusCount(String statusLabel) {
        try {
            WebElement label = HelperClass.getDriver()
                    .findElement(By.xpath("//div[contains(text(),'" + statusLabel + "')]") );
            String text = label.getText(); // e.g. "To Review : 21"
            return Integer.parseInt(text.replaceAll("[^0-9]", ""));
        } catch (Exception e) {
            System.out.println("Count not found for: " + statusLabel);
            return 0;
        }
    }

    public static void selectStatusFromDropdown(By dropdownLocator, By optionsLocator, String statusToSelect) {
        HelperClass.safeClick(dropdownLocator);
        List<WebElement> options = HelperClass.getDriver().findElements(optionsLocator);

        for (WebElement option : options) {
            if (option.getText().trim().equalsIgnoreCase(statusToSelect)) {
                HelperClass.scrollToElement(option);
                option.click();
                break;
            }
        }
        HelperClass.sleep1(1000); // Wait for table to refresh
    }

    public static void selectStatusFromDropdown(WebElement dropdownElement, List<WebElement> optionElements,
            String statusToSelect) {
        // Click the dropdown
        safeClick(dropdownElement);

        // Loop through available options
        for (WebElement option : optionElements) {
            String optionText = option.getText().trim();
            if (optionText.equalsIgnoreCase(statusToSelect)) {
                scrollToElement(option);
                option.click();
                break;
            }
        }

        sleep1(1000);
    }

    public static boolean validateStatusInTable(By tableStatusLocator, String expectedStatus) {
        List<WebElement> statuses = HelperClass.getDriver().findElements(tableStatusLocator);

        for (WebElement status : statuses) {
            if (!status.getText().trim().equalsIgnoreCase(expectedStatus)
                    && !expectedStatus.equalsIgnoreCase("All Status")) {
                System.out.println("Mismatch found: " + status.getText());
                return false;
            }
        }
        return true;
    }

    public static int getSummaryCount(By summaryLocator, String statusText) {
        List<WebElement> summaries = HelperClass.getDriver().findElements(summaryLocator);
        for (WebElement summary : summaries) {
            if (summary.getText().contains(statusText)) {
                String countText = summary.getText().replaceAll("[^0-9]", "");
                return Integer.parseInt(countText);
            }
        }
        return 0;
    }

    public static void waitForTableToLoad() {
        WebDriverWait wait = getWait();

        By loadingIndicator = By.xpath("//div[contains(@class, 'loading') or contains(@class, 'spinner')]");
        By tableRows = By.xpath("//table//tbody//tr[contains(@class,'ng-star-inserted')]");

        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(loadingIndicator));
        } catch (Exception e) {
            System.out.println("Loading indicator not found or already hidden.");
        }
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(tableRows));
    }

    // Verifying the page

    public static boolean isElementVisible(By locator, int timeoutInSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(timeoutInSeconds));
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    // Capture Screenshot in scenario
    public static void captureScreenshot(String screenshotName, Scenario scenario) {
        try {
            TakesScreenshot ts = (TakesScreenshot) getDriver();
            byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", screenshotName);
        } catch (Exception e) {
            System.out.println("Failed to capture screenshot: " + e.getMessage());
        }
    }

    // Dropdown
    public static void selectTimeFilter(WebElement dropdownElement, String filterToSelect) {
        safeClick(dropdownElement); // dropdown open
        sleep1(5000);
        List<WebElement> options = getDriver().findElements(By.xpath("//mat-option//span[@class='mat-option-text']"));

        for (WebElement option : options) {
            if (option.getText().trim().equalsIgnoreCase(filterToSelect)) {
                scrollToElement(option);
                option.click();
                break;
            }
        }
    }

    public static void selectMaterialDropdownValue(String visibleText) {
        WebDriver driver = getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // STEP 1: Click the dropdown trigger once
            WebElement trigger = wait.until(ExpectedConditions
                    .elementToBeClickable(By.xpath("(//div[contains(@class,'mat-select-trigger')])[1]")));
            trigger.click();

            // STEP 2: Wait for dropdown options to appear
            By optionLocator = By.xpath("//mat-option//span[normalize-space(text())='" + visibleText + "']");
            wait.until(ExpectedConditions.presenceOfElementLocated(optionLocator));
            wait.until(ExpectedConditions.visibilityOfElementLocated(optionLocator));
            wait.until(ExpectedConditions.elementToBeClickable(optionLocator));

            // STEP 3: Click on the desired option
            WebElement option = driver.findElement(optionLocator);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", option);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", option);

            sleep1(1000); // Small wait after click to ensure selection registers
        } catch (TimeoutException e) {
            System.out.println("Option '" + visibleText + "' not found.");
        } catch (Exception e) {
            System.out.println("Dropdown selection failed: " + e.getMessage());
        }
    }

    public static void selectMaterialDropdownValue(WebElement dropdownTrigger, String visibleText) {
        WebDriver driver = getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            wait.until(ExpectedConditions.elementToBeClickable(dropdownTrigger)).click();
            By optionLocator = By.xpath("//mat-option//span[normalize-space(text())='" + visibleText + "']");
            WebElement option = wait.until(ExpectedConditions.elementToBeClickable(optionLocator));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", option);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", option);

            sleep1(3000);
        } catch (TimeoutException e) {
            System.out.println("Option '" + visibleText + "' not found.");
        } catch (Exception e) {
            System.out.println("Dropdown selection failed: " + e.getMessage());
        }
    }

    public static void selectDivOptionDropdownValue(WebElement dropdownTrigger, String visibleText) {
        WebDriver driver = getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            wait.until(ExpectedConditions.elementToBeClickable(dropdownTrigger)).click();
            By optionLocator = By.xpath("//div//span[normalize-space(text())='" + visibleText + "']");
            WebElement option = wait.until(ExpectedConditions.elementToBeClickable(optionLocator));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", option);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", option);

            sleep1(3000);
        } catch (TimeoutException e) {
            System.out.println("Option '" + visibleText + "' not found.");
        } catch (Exception e) {
            System.out.println("Dropdown selection failed: " + e.getMessage());
        }
    }

// Click Dropbownn
    public static void clickDropdown(WebElement dropdownElement) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(dropdownElement)).click();
    }

// Store All dropdown values
    public static List<String> getDropdownOptions(List<WebElement> optionElements) {
        List<String> optionsText = new ArrayList<>();
        for (WebElement option : optionElements) {
            optionsText.add(option.getText().trim());
        }
        return optionsText;
    }

    public static void scrollIntoView(WebElement element) {
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
        ((JavascriptExecutor) getDriver()).executeScript(
                "arguments[0].style.border='3px solid red'; arguments[0].style.background='lightyellow';", element);
    }

    // For global legends across the page
    public static List<String> getAllApexChartLegendValues() {
        List<String> legendValues = new ArrayList<>();
        List<WebElement> legendElements = getDriver()
                .findElements(By.xpath("//div[contains(@class,'apexcharts-legend-series')]"));
        for (WebElement element : legendElements) {
            String text = element.getText().trim();
            if (!text.isEmpty()) {
                legendValues.add(text);
            }
        }
        return legendValues;
    }

    // For a specific chart container only
    public static List<String> getApexChartLegendValues(WebElement chartContainer) {
        List<String> values = new ArrayList<>();
        List<WebElement> legends = chartContainer
                .findElements(By.xpath(".//div[contains(@class,'apexcharts-legend-series')]"));
        for (WebElement legend : legends) {
            String text = legend.getText().trim();
            if (!text.isEmpty()) {
                values.add(text);
            }
        }
        return values;
    }

    public static void sleep2(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Supplier Helper class
    public static void searchByIdAndClickEdit(String supplierId) {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));

            // Clear and enter search term
            WebElement searchInput = wait
                    .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Search']")));
            searchInput.clear();
            searchInput.sendKeys(supplierId);
            Thread.sleep(2000); // or wait for table to load (better: wait for table row)

            // Wait for row to appear (or update the XPath to suit your structure)
            By rowLocator = By
                    .xpath("//table//tr[td//a[text()='" + supplierId + "'] or td[text()='" + supplierId + "']]");
            wait.until(ExpectedConditions.visibilityOfElementLocated(rowLocator));

            // Re-fetch the row and find Edit button within it (avoid stale element)
            WebElement row = getDriver().findElement(rowLocator);
            WebElement editButton = row.findElement(By.xpath("//button[@title='Edit']"));

            // Hover if needed (optional)
            Actions actions = new Actions(getDriver());
            actions.moveToElement(row).perform();

            wait.until(ExpectedConditions.elementToBeClickable(editButton));
            editButton.click();

        } catch (StaleElementReferenceException e) {
            System.out.println("Retrying due to stale element...");
            searchByIdAndClickEdit(supplierId);
        } catch (Exception e) {
            throw new RuntimeException("Failed to click Edit for ID: " + supplierId, e);
        }
    }

//	public static void navigateUntilEnd(WebDriver driver, String buttonXpath, String disabledClass,
//			String directionLabel) {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//
//		while (true) {
//			WebElement button = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(buttonXpath)));
//
//			String script = "return arguments[0].classList.contains('" + disabledClass + "');";
//			boolean isDisabled = (Boolean) js.executeScript(script, button);
//
//			System.out.println("Clicking " + directionLabel + "...");
//			System.out.println("classList.contains('" + disabledClass + "') = " + isDisabled);
//
//			if (isDisabled) {
//				System.out.println("Reached the end. '" + directionLabel + "' button is disabled.");
//				break;
//			}
//
//			button.click();
//
//			try {
//				Thread.sleep(1000); 
//			} catch (InterruptedException e) {
//				Thread.currentThread().interrupt();
//			}
//		}
//
//	}

    public static void navigateUntilEnd(WebDriver driver, String buttonXpath, String disabledClass,
            String directionLabel) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        try {
            List<WebElement> buttons = driver.findElements(By.xpath(buttonXpath));
            if (buttons.isEmpty()) {
                System.out.println(directionLabel + " button not found on the page.");
                return;
            }

            WebElement button = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(buttonXpath)));

            boolean isDisabled = (Boolean) js
                    .executeScript("return arguments[0].classList.contains('" + disabledClass + "');", button);

            if (isDisabled) {
                System.out.println(directionLabel + " button is disabled. Cannot click.");
            } else {
                button.click();
                System.out.println("Clicked " + directionLabel + " button.");
            }

        } catch (Exception e) {
            System.out.println("Error while checking/clicking " + directionLabel + " button: " + e.getMessage());
        }
    }

    public static void selectFromStatusDropdown(WebDriver driver, String dropdownXpath, String optionText)
            throws TimeoutException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(dropdownXpath)));
        dropdown.click();

        // A single valid XPath that matches options anywhere inside overlays
        String optionXpath = "//div[contains(@class,'cdk-overlay')]//span[normalize-space(text())='" + optionText + "']"
                + " | //div[contains(@class,'ng-dropdown-panel')]//span[normalize-space(text())='" + optionText + "']";

        WebElement optionToSelect = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(optionXpath)));

        optionToSelect.click();
    }

    public static void hoverAndClickActionOnRow(int rowIndex, String actionType) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
        Actions actions = new Actions(getDriver());
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ngx-spinner-overlay")));
        } catch (Exception e) {
            System.out.println("No spinner overlay found or disappeared quickly.");
        }

        WebElement table = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@aria-describedby='Purchase Table']")));

        List<WebElement> rows = table.findElements(By.tagName("tr"));

        if (rows.isEmpty()) {
            throw new IllegalStateException("Purchase Table has no rows. Cannot perform action.");
        }

        if (rowIndex >= rows.size()) {
            throw new IllegalArgumentException("Row index out of range. Requested: " + rowIndex
                    + ", but table has only: " + rows.size() + " rows.");
        }

        boolean success = false;
        int retries = 0;

        while (!success && retries < 3) {
            try {

                rows = table.findElements(By.tagName("tr"));
                WebElement targetRow = rows.get(rowIndex);

                actions.moveToElement(targetRow).perform();

                By buttonLocator;

                switch (actionType.toLowerCase()) {
                case "edit":
                    buttonLocator = By.xpath("//button[@title='Edit']");
                    break;
                case "delete":
                    buttonLocator = By.xpath("//button[@title='Delete']");
                    break;
                case "archive":
                    buttonLocator = By.xpath("(//button[@title='Archive'])[1]");
                    break;
                case "restore":
                    buttonLocator = By.xpath("//button[@title='unarchive']");
                    break;
                case "menu":
                    buttonLocator = By.xpath("(//button[@aria-haspopup='menu'])[2]");
                    break;
                default:
                    throw new IllegalArgumentException("Unsupported action: " + actionType);
                }

                List<WebElement> buttons = targetRow.findElements(buttonLocator);

                if (buttons.isEmpty()) {
                    System.out.println("Action '" + actionType + "' is not visible for row index " + rowIndex + ".");
                    return;
                }

                WebElement actionButton = wait.until(ExpectedConditions.elementToBeClickable(buttons.get(0)));
                actionButton.click();

                success = true;

            } catch (StaleElementReferenceException e) {
                System.out.println("Stale element detected. Retrying...");
                retries++;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ie) {
                    // ignore
                }
            } catch (TimeoutException e) {
                System.out.println("Timed out waiting for button to be clickable. Retrying...");
                retries++;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ie) {
                    // ignore
                }
            }
        }

        if (!success) {
            throw new RuntimeException(
                    "Failed to click action button '" + actionType + "' on row index " + rowIndex + " after retries.");
        }
    }

    public static void waitForSpinnerToDisappear(WebDriver driver) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

            // Adjust the XPath or CSS Selector below to match your spinner
            By spinnerLocator = By.xpath(
                    "//mat-spinner | //div[contains(@class,'spinner') or contains(@class,'loading') or contains(@class,'overlay')]");

            // Wait until spinner is either invisible or not present
            wait.until(ExpectedConditions.invisibilityOfElementLocated(spinnerLocator));

            System.out.println("Spinner disappeared successfully.");
        } catch (TimeoutException e) {
            System.out.println("Spinner did not disappear within timeout. Proceeding anyway.");
        } catch (Exception e) {
            System.out.println("Error while waiting for spinner to disappear: " + e.getMessage());
        }
    }

// Mouse hover 

    public static void hoverOverElement(WebElement element) {
        Actions actions = new Actions(HelperClass.getDriver());
        actions.moveToElement(element).perform();
        Log.info("Hovered over element: " + element);
    }

    public static void hoverOverElement(By locator) {
        WebDriver driver = HelperClass.getDriver();
        WebElement element = driver.findElement(locator);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        Log.info("Hovered over element located by: " + locator);
    }

    public static void clearField(WebDriver driver, By locator) throws InterruptedException {
        WebElement element = driver.findElement(locator);
        element.click();
        Thread.sleep(2000);
        element.clear();
    }

    public static void clearField(WebDriver driver, WebElement element) throws InterruptedException {
        element.click();
        Thread.sleep(2000);
        element.clear();
    }

    public static void selectFromCustomDropdown(WebDriver driver, String dropdownXpath, String optionText)
            throws TimeoutException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(dropdownXpath)));
        dropdown.click();

        List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(
                "//div[contains(@class, 'option') or contains(@class, 'mat-option') or contains(@class, 'cdk-overlay')]//span[normalize-space(text())='"
                        + optionText + "']")));

        for (WebElement option : options) {
            if (option.getText().trim().equals(optionText)) {
                option.click();
                return;
            }
        }

        throw new NoSuchElementException("Option '" + optionText + "' not found.");
    }

    public static void verifyClientTypes(WebDriver driver, String columnXpath, String expectedType) {
        List<WebElement> clientTypeElements = driver.findElements(By.xpath(columnXpath));

        if (clientTypeElements.isEmpty()) {
            System.out.println("No client records found with the given XPath: " + columnXpath);
            return;
        }

        boolean allMatch = true;

        for (int i = 0; i < clientTypeElements.size(); i++) {
            String actualType = clientTypeElements.get(i).getText().trim();

            if (!actualType.equalsIgnoreCase(expectedType)) {
                System.out.println(
                        "Mismatch at row " + (i + 1) + ": Expected = " + expectedType + ", Found = " + actualType);
                allMatch = false;
            } else {
                System.out.println("Match at row " + (i + 1) + ": Client Type = " + actualType);
            }
        }
    }

    public static void selectFirstSuggestedCustomer(String customerName) {
        List<WebElement> suggestions = getDriver().findElements(By.cssSelector("div[role='option'], mat-option"));

        if (!suggestions.isEmpty()) {
            suggestions.get(0).click();
        } else {
            System.out.println("No suggestions appeared for input: " + customerName);
        }
    }

    public static void verifyStatusTypes(WebDriver driver, String columnXpath, String expectedType) {
        List<WebElement> StatusTypeElements = driver.findElements(By.xpath(columnXpath));

        if (StatusTypeElements.isEmpty()) {
            System.out.println("No client records found with the given XPath: " + columnXpath);
            return;
        }

        boolean allMatch = true;

        for (int i = 0; i < StatusTypeElements.size(); i++) {
            String actualType = StatusTypeElements.get(i).getText().trim();

            if (!actualType.equalsIgnoreCase(expectedType)) {
                System.out.println(
                        "Mismatch at row " + (i + 1) + ": Expected = " + expectedType + ", Found = " + actualType);
                allMatch = false;
            } else {
                System.out.println("Match at row " + (i + 1) + ": Client Type = " + actualType);
            }
        }
    }

    public static void SearchAndSelectClient(WebDriver driver, WebDriverWait wait, By searchFieldLocator,
            String searchText, By suggestionLocator) {

        WebElement searchField = wait.until(ExpectedConditions.visibilityOfElementLocated(searchFieldLocator));
        searchField.click();
        searchField.sendKeys(searchText);
        wait.until(ExpectedConditions.visibilityOfElementLocated(suggestionLocator));
        WebElement firstSuggestion = driver.findElement(suggestionLocator);
        firstSuggestion.click();
    }

    public static void scrollUntilElementVisible(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void SearchAndSelectClientclear(WebDriver driver, WebDriverWait wait, By searchFieldLocator,
            String searchText, By suggestionLocator) {

        WebElement searchField = wait.until(ExpectedConditions.visibilityOfElementLocated(searchFieldLocator));
        searchField.clear();
        searchField.click();
        searchField.sendKeys(searchText);
        wait.until(ExpectedConditions.visibilityOfElementLocated(suggestionLocator));
        WebElement firstSuggestion = driver.findElement(suggestionLocator);
        firstSuggestion.click();
    }

    public static void mouseHoverAndPerformActionn(String tableAriaLabel, int rowIndex, String actionType) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
        Actions actions = new Actions(getDriver());

        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ngx-spinner-overlay")));
        } catch (Exception e) {
            System.out.println("Spinner not present or already disappeared.");
        }

        By tableLocator = By.xpath("//table[@aria-describedby='" + tableAriaLabel + "']");
        WebElement table = wait.until(ExpectedConditions.visibilityOfElementLocated(tableLocator));

        List<WebElement> rows = table.findElements(By.tagName("tr"));

        if (rows.isEmpty()) {
            throw new IllegalStateException("Table '" + tableAriaLabel + "' has no rows.");
        }

        if (rowIndex >= rows.size()) {
            throw new IllegalArgumentException("Row index " + rowIndex + " out of bounds. Total rows: " + rows.size());
        }

        boolean success = false;
        int retries = 0;

        while (!success && retries < 3) {
            try {

                rows = table.findElements(By.tagName("tr"));
                WebElement targetRow = rows.get(rowIndex);
                actions.moveToElement(targetRow).perform();

                By buttonLocator;
                switch (actionType.toLowerCase()) {
                case "edit":
                    buttonLocator = By.xpath(".//button[@title='Edit']");
                    break;
                case "delete":
                    buttonLocator = By.xpath(".//button[@title='Delete']");
                    break;
                case "archive":
                    buttonLocator = By.xpath(".//button[@title='Archive']");
                    break;
                case "unarchive":
                    buttonLocator = By.xpath(".//button[normalize-space()='unarchive']");
                    break;
                case "menu":
                    buttonLocator = By.xpath("(//button[@aria-haspopup='menu'])[2]");
                    break;
                default:
                    throw new IllegalArgumentException("Unsupported action type: " + actionType);
                }

                List<WebElement> buttons = targetRow.findElements(buttonLocator);

                if (buttons.isEmpty()) {
                    throw new NoSuchElementException(
                            "No action button '" + actionType + "' found in row index " + rowIndex);
                }

                WebElement actionButton = wait.until(ExpectedConditions.elementToBeClickable(buttons.get(0)));
                actionButton.click();

                success = true;

            } catch (StaleElementReferenceException | TimeoutException e) {
                System.out.println("Retrying due to: " + e.getClass().getSimpleName());
                retries++;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ignored) {
                }
            }
        }

        if (!success) {
            throw new RuntimeException("Failed to perform action '" + actionType + "' on row index " + rowIndex);
        }
    }

    // Time and Fees Helper Methods
    public static void waitForLoaderToDisappear(int seconds) {

        List<WebElement> loaders = getDriver().findElements(By.xpath("//div[contains(@class, 'ngx-spinner-overlay')]"));
        if (!loaders.isEmpty()) {
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(seconds));
            wait.until(ExpectedConditions.invisibilityOf(loaders.get(0)));
        }
    }

    public static void validatepageloaded(By locator, String screenshotName) throws InterruptedException {
        Thread.sleep(2000);
        WebElement pageElement = new WebDriverWait(getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));

        if (!pageElement.isDisplayed()) {
            	throw new AssertionError("Expected element was not visible: " + locator.toString());
        }

        System.out.println("Element found: " + locator);
        HelperClass.captureAndAttachScreenshot(HelperClass.getScenarioTest(), screenshotName);
    }

    public static ExtentTest getScenarioTest() {
        return scenarioTest;
    }

    public static void captureAndAttachScreenshot(ExtentTest scenarioTest, String message) {
        try {
            WebDriver driver = getDriver();

            // Use StepTracker if message is empty
            if (message == null || message.trim().isEmpty()) {
                message = StepTracker.getCurrentStep();
            }
            if (message == null || message.trim().isEmpty()) {
                message = "Unnamed Step";
            }

            // Save screenshot
            String fileName = "screenshots/" + message + "_" + System.currentTimeMillis() + ".png";
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshot, new File(fileName));
            System.out.println("Screenshot saved: " + fileName);

            // Attach to report
            String base64 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
            scenarioTest.log(Status.INFO, message,
                    MediaEntityBuilder.createScreenCaptureFromBase64String(base64).build());

        } catch (Exception e) {
            System.out.println("Failed to capture screenshot: " + e.getMessage());
        }
    }

    public static Map<String, String> validateEachDropdownOptionAndCaptureScreenshot(WebElement dropdownElement,
            List<WebElement> dropdownOptions, String screenshotPrefix, String screenshotFolderPath)
            throws InterruptedException {

        Thread.sleep(2000);
        waitForLoaderToDisappear(10);

        dropdownElement.click();

        List<String> optionTexts = new ArrayList<>();
        for (WebElement option : dropdownOptions) {
            String text = option.getText().trim();
            if (!text.isEmpty()) {
                optionTexts.add(text);
            }
        }

        // Store label and base64 image for report
        Map<String, String> reportData = new LinkedHashMap<>();

        for (String optionText : optionTexts) {
            dropdownElement.click();

            for (WebElement opt : dropdownOptions) {
                if (opt.getText().trim().equals(optionText)) {
                    opt.click();
                    System.out.println("✅ Selected: " + optionText);

                    Thread.sleep(4000);

                    String fileName = screenshotFolderPath + "/" + screenshotPrefix + "_"
                            + optionText.replaceAll("[^a-zA-Z0-9]", "_") + ".png";

                    File screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
                    try {
                        FileUtils.copyFile(screenshot, new File(fileName));
                        System.out.println(" Screenshot saved: " + fileName);
                    } catch (IOException e) {
                        System.out.println("Error saving screenshot: " + e.getMessage());
                    }

                    // Also prepare base64 string for report return
                    String base64 = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BASE64);
                    reportData.put(optionText, base64);

                    break;
                }
            }
        }

        return reportData;
    }

    public static void sendKeys(WebElement element, String text) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(TIMEOUT));
        wait.until(ExpectedConditions.visibilityOf(element));

        try {
            element.clear();
            element.sendKeys(text);

            // 🔁 Fire input event (useful for Angular/react bindings)
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            js.executeScript("arguments[0].dispatchEvent(new Event('input', { bubbles: true }))", element);

            // ⏎ Press Enter to submit search
            element.sendKeys(Keys.ENTER);

        } catch (Exception e) {
            System.out.println("Failed to send keys: " + e.getMessage());
        }
    }

    public static void ClickUsingJS(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

    public static void ClickUsingJS(WebDriver driver, By locator) {
        WebElement element = driver.findElement(locator);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        js.executeScript("arguments[0].click();", element);
    }

    public static void sendKeysAndPressEnter(By locator, String text) {
        WebElement element = getDriver().findElement(locator);
        element.clear();
        element.sendKeys(text);
    }
    
    public static WebDriverWait getWait1() {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(10));
    }

    public static void selectNgDropdownByTyping(By dropdownLocator, String value) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(dropdownLocator));
        dropdown.click();

        WebElement input = dropdown.findElement(By.xpath(".//input"));
        input.clear();
        input.sendKeys(value);

        By optionsLocator = By.xpath("//div[contains(@class,'ng-dropdown-panel-items')]//div[contains(@class,'ng-option')]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(optionsLocator));

        List<WebElement> options = getDriver().findElements(optionsLocator);

        for (WebElement option : options) {
            String optionText = option.getText().trim();
            if (optionText.equalsIgnoreCase(value.trim())) {
                option.click();
                break;
            }
        }

        // Optionally, wait for the dropdown to close
        wait.until(ExpectedConditions.invisibilityOfElementLocated(
            By.xpath("//div[contains(@class,'ng-dropdown-panel-items')]")
        ));
    }
    
    public static void waitForElementToDisappear(By locator, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }
    
    public static WebElement waitUntilClickable(WebDriverWait wait, By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    public static WebElement waitUntilClickable(WebDriverWait wait, WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    

    public static void forceHover(WebElement element) {
        WebDriver driver = getDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", element);

        Actions actions = new Actions(driver);
        actions.moveToElement(element).pause(Duration.ofMillis(300)).perform();

        js.executeScript("let ev = new MouseEvent('mouseover', { bubbles: true }); arguments[0].dispatchEvent(ev);", element);

        System.out.println("Hovered on element to reveal buttons.");
    }

    public static String getFirstRowStatusText() {
        WebElement statusCell = getDriver().findElement(By.xpath("//table//tbody//tr[1]/td[last()]"));
        return statusCell.getText().trim();
    }
    
    public static void scrolling1() {

        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0,2000)");

    }
    
    public static void scrollToTop() {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollTo(0, 0);");
    }
    
    public static boolean selectDropdownOption(List<WebElement> dropdownOptions, String optionText) {
        try {
            WebDriverWait wait = getWait1();
            JavascriptExecutor js = (JavascriptExecutor) getDriver();

            for (WebElement option : dropdownOptions) {
                wait.until(ExpectedConditions.visibilityOf(option));
                String text = option.getText().trim();

                if (text.equalsIgnoreCase(optionText)) {
                    js.executeScript("arguments[0].click();", option);
                    System.out.println("Dropdown option selected: " + optionText);
                    return true;
                }
            }

            System.out.println("Option '" + optionText + "' not found in dropdown.");
            return false;

        } catch (Exception e) {
            System.out.println("Error while selecting dropdown option: " + e.getMessage());
            return false;
        }
    }
    
    public static void waitForPageToLoad(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        try {
            wait.until(webDriver -> (Boolean) js.executeScript("return (window.angular !== undefined) && "
                    + "(angular.element(document).injector() !== undefined) && "
                    + "(angular.element(document).injector().get('$http').pendingRequests.length === 0);"));
        } catch (Exception e) {
            //Log.warn("Angular wait skipped: " + e.getMessage());
        }
     
        wait.until(webDriver -> js.executeScript("return document.readyState").toString().equals("complete"));
    }
    
}