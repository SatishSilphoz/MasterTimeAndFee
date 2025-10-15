package com.TimeAndFees.Actions;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Capium.Utilites.HelperClass;
import com.Capium.Utilites.Log;
import com.TimeAndFees.Locators.LoginLocators;



public class LoginActions {

	LoginLocators loginLocators = null;
	WebDriverWait wait = HelperClass.getWait();
	WebDriver driver = HelperClass.getDriver();
	
	@FindBy(xpath="//div[contains(@class,'outer-circle')]")
	private WebElement OldEcoCircleContainer;
	
	@FindBy(xpath="//a[@href='/accounts/']/div[contains(text(),'Accounts Production')]")
	private WebElement AccountsProduction_Module;
	
	@FindBy(xpath="//a[@href='/selfassessment/']/div[contains(text(),'Self Assessment')]")
	private WebElement SelfAssessment_Module;
	
	@FindBy(xpath="//a[@href='/corporationtax/']/div[contains(text(),'Corporation Tax')]")
	private WebElement CorporationTax_Module;
	
	@FindBy(xpath="//a[@href='/bookkeeping/']/div[contains(text(),'Bookkeeping')]")
	private WebElement Bookkeeping_Module;
	

	public LoginActions() {
		this.loginLocators = new LoginLocators();
		PageFactory.initElements(HelperClass.getDriver(), loginLocators);
	}

	public void EnterUsername(String username) {
		loginLocators.inputUsername.clear();
		loginLocators.inputUsername.sendKeys(username);

	}
	
	public void EnterPassword(String password) {
		loginLocators.inputPassword.sendKeys(password);
	}
	
	public void ClickOnLogin() {
		loginLocators.btnLogin.click();
	}

	
	public boolean isHomePage() {
		try {
			return loginLocators.Homepage_Element.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

//	public void navigateToTimeAndFeesModule() {
//	    WebDriverWait wait = new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(2));
//
//	    try {
//	        if (isElementVisible(loginLocators.TimeAndFees_Module, wait)) {
//	            loginLocators.TimeAndFees_Module.click();
//	            System.out.println("Navigated to TimeAndFees module from Homepage.");
//	            return;
//	        }
//
//	        if (isElementVisible(loginLocators.C_icon_inside_modules, wait)) {
//	            loginLocators.C_icon_inside_modules.click();
//	            wait.until(ExpectedConditions.visibilityOf(loginLocators.InsideCiconHome));
//
//	            if (isElementVisible(loginLocators.InsideCiconHome, wait)) {
//	                loginLocators.InsideCiconHome.click();
//	                System.out.println("Navigated to TimeAndFees module from inside 5.0 module.");
//	                wait.until(ExpectedConditions.visibilityOf(loginLocators.TimeAndFees_Module));
//	            }
//
//	            if (isElementVisible(loginLocators.TimeAndFees_Module, wait)) {
//	                loginLocators.TimeAndFees_Module.click();
//	                System.out.println("Navigated to TimeAndFees module from Homepage after C icon.");
//	                return;
//	            }
//	        }
//
//	        if (isElementVisible(loginLocators.OldEcoTimeAndFees, wait)) {
//	            loginLocators.OldEcoTimeAndFees.click();
//	            System.out.println("Navigated to TimeAndFees module via Old EcoSpace.");
//	            return;
//	        }
//
//	        System.out.println("CorporationTax module could not be found in any known location.");
//
//	    } catch (Exception e) {
//	        System.out.println("Error while navigating to CorporationTax module: " + e.getMessage());
//	        Log.info("Error while navigating to CorporationTax module.", "Anwar", "Redirection To CorporationTax Module");
//	    }
//	}	
//	public void navigateToTimeAndFeesModule() {
//	    WebDriverWait wait = new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(3));
//
//	    try {
//	        if (isElementVisible(loginLocators.TimeAndFees_Module, wait)) {
//	            loginLocators.TimeAndFees_Module.click();
//	            System.out.println("Navigated to TimeAndFees module from Homepage.");
//	            return;
//	        }
//	        List<WebElement> oldEcoModules = HelperClass.getDriver().findElements(
//	            By.xpath("//a/div[contains(@class,'circle') and " +
//	                     "(normalize-space()='Accounts Production' " +
//	                     "or normalize-space()='Self Assessment' " +
//	                     "or normalize-space()='Corporation Tax' " +
//	                     "or normalize-space()='Bookkeeping')]")
//	        );
//
//	        if (!oldEcoModules.isEmpty()) {
//	            System.out.println("Old Eco space detected. Found " + oldEcoModules.size() + " modules.");
//
//	            boolean clickedModule = false;
//
//	            for (WebElement module : oldEcoModules) {
//	                String classAttr = module.getAttribute("class");
//	                if (classAttr != null && (classAttr.contains("disabled") || classAttr.contains("lock"))) {
//	                    System.out.println("Skipping locked module: " + module.getText());
//	                    continue;
//	                }
//
//	                if (module.isDisplayed() && module.isEnabled()) {
//	                    System.out.println("Clicking Old Eco module: " + module.getText());
//	                    module.click();
//	                    clickedModule = true;
//	                    break;
//	                }
//	            }
//
//	            if (clickedModule) {
//	                if (isElementVisible(loginLocators.C_icon_inside_modules, wait)) {
//	                    loginLocators.C_icon_inside_modules.click();
//	                    wait.until(ExpectedConditions.visibilityOf(loginLocators.InsideCiconHome));
//
//	                    if (isElementVisible(loginLocators.InsideCiconHome, wait)) {
//	                        loginLocators.InsideCiconHome.click();
//	                        System.out.println("Navigated to Home from C icon after Old Eco.");
//	                    }
//
//	                    if (isElementVisible(loginLocators.TimeAndFees_Module, wait)) {
//	                        loginLocators.TimeAndFees_Module.click();
//	                        System.out.println("Navigated to TimeAndFees module after Old Eco redirection.");
//	                        return;
//	                    }
//	                }
//	            }
//	        }
//
//	        if (isElementVisible(loginLocators.C_icon_inside_modules, wait)) {
//	            loginLocators.C_icon_inside_modules.click();
//	            wait.until(ExpectedConditions.visibilityOf(loginLocators.InsideCiconHome));
//
//	            if (isElementVisible(loginLocators.InsideCiconHome, wait)) {
//	                loginLocators.InsideCiconHome.click();
//	                System.out.println("Navigated to TimeAndFees module from inside 5.0 module.");
//	                wait.until(ExpectedConditions.visibilityOf(loginLocators.TimeAndFees_Module));
//	            }
//
//	            if (isElementVisible(loginLocators.TimeAndFees_Module, wait)) {
//	                loginLocators.TimeAndFees_Module.click();
//	                System.out.println("Navigated to TimeAndFees module from Homepage after C icon.");
//	                return;
//	            }
//	        }
//
//	        if (isElementVisible(loginLocators.OldEcoTimeAndFees, wait)) {
//	            loginLocators.OldEcoTimeAndFees.click();
//	            System.out.println("Navigated to TimeAndFees module via Old EcoSpace direct link.");
//	            return;
//	        }
//
//	        System.out.println("TimeAndFees module could not be found in any known location.");
//
//	    } catch (Exception e) {
//	        System.out.println("Error while navigating to TimeAndFees module: " + e.getMessage());
//	        Log.info("Error while navigating to TimeAndFees module.", "Anwar", "Redirection To TimeAndFees Module");
//	    }
//	}
	public void NavigateToModule(String Module) throws InterruptedException {

		// Wait for URL to stabilize
		wait.until(d -> d.getCurrentUrl() != null && !d.getCurrentUrl().isEmpty());
		Thread.sleep(4000);
		String currentUrl = driver.getCurrentUrl();
		System.out.println("Current URL: <<" + currentUrl + ">>");
		// Case 1: Already in New Eco Home
		if (currentUrl.contains("account.beta.capium.co.uk/home")) {
			String moduleXpath = "//h6[normalize-space()='" + Module + "']/ancestor::div[@class='card']";
			WebElement targetModule = HelperClass.waitForVisibility(driver.findElement(By.xpath(moduleXpath)));
			HelperClass.scrollIntoView(targetModule);
			HelperClass.safeClick(targetModule, Module + " Module");
			return;
		}
		// Case 2: Old Eco Homepage (Circle Page)
		if (currentUrl.equals("https://app.beta.capium.co.uk/") || currentUrl.equals("https://app.beta.capium.co.uk")) {
			boolean navigated = false;
			int retries = 3;
			while (!navigated && retries > 0) {
				try {
					WebElement OldEcoCT = wait.until(ExpectedConditions
							.visibilityOf(driver.findElement(By.xpath("//div[contains(text(),'Corporation Tax')]"))));
					HelperClass.safeClick(OldEcoCT, "CT Module in Old Eco");
					
					HelperClass.waitForPageToLoad(driver);

					WebElement C_icon = wait.until(
							ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[@title='Modules']"))));
					HelperClass.safeClick(C_icon, "Modules Icon");
					WebElement C_home = wait.until(ExpectedConditions
							.visibilityOf(driver.findElement(By.xpath("//a[@href='/' and contains(@class,'my')]"))));
					HelperClass.safeClick(C_home, "Home inside Modules");
					String newUrl = driver.getCurrentUrl();
					if (newUrl.contains("account.beta.capium.co.uk/home")) {
						navigated = true;
					} else {
						retries--;
						System.out.println("Navigation did not reach New Eco, retries left: " + retries);
					}
				} catch (Exception e) {
					retries--;
					System.out.println(
							"Exception during Old Eco navigation, retries left: " + retries + " -> " + e.getMessage());
				}
			}
			if (!navigated) {
				throw new RuntimeException("Failed to navigate to New Eco after retries");
			}

			// Click target module after navigation
			
			String moduleXpath = "//h6[normalize-space()='" + Module + "']/ancestor::div[@class='card']";
			WebElement targetModule = HelperClass.waitForVisibility(driver.findElement(By.xpath(moduleXpath)));
			HelperClass.scrollIntoView(targetModule);
			HelperClass.safeClick(targetModule, Module + " Module");
			return;
		}
		// Case 3: Already inside another module (Accounts/Payroll/etc.)
		if (currentUrl.startsWith("https://app.beta.capium.co.uk/")
				&& !currentUrl.equals("https://app.beta.capium.co.uk/")) {

			boolean navigated = false;
			int retries = 3;

			while (!navigated && retries > 0) {
				
				try {
					HelperClass.waitForPageToLoad(driver);
					// Step 1: Click Modules icon
					WebElement C_icon = wait.until(
							ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[@title='Modules']"))));
					HelperClass.safeClick(C_icon, "Modules Icon");

					// Step 2: Click Home inside Modules
					WebElement C_home = wait.until(ExpectedConditions
							.visibilityOf(driver.findElement(By.xpath("//a[@href='/' and contains(@class,'my')]"))));
					HelperClass.safeClick(C_home, "Home inside Modules");

					// Step 3: Check if landed in New Eco or Old Eco
					String newUrl = driver.getCurrentUrl();

					if (newUrl.contains("account.beta.capium.co.uk/home")) {
						navigated = true; //Success → already in New Eco home
						break;
					} else if (newUrl.equals("https://app.beta.capium.co.uk/")
							|| newUrl.equals("https://app.beta.capium.co.uk")) {
						//Got redirected to Old Eco home → Use OldEco CT path to jump to NewEco
						try {
							WebElement OldEcoCT = wait.until(ExpectedConditions.visibilityOf(
									driver.findElement(By.xpath("//div[contains(text(),'Corporation Tax')]"))));
							HelperClass.safeClick(OldEcoCT, "CT Module in Old Eco");
							// Retry going back via Modules → Home
							WebElement inner_C_icon = wait.until(ExpectedConditions
									.visibilityOf(driver.findElement(By.xpath("//a[@title='Modules']"))));
							HelperClass.safeClick(inner_C_icon, "Modules Icon Inside OldEco CT");
							WebElement inner_C_home = wait.until(ExpectedConditions.visibilityOf(
									driver.findElement(By.xpath("//a[@href='/' and contains(@class,'my')]"))));
							HelperClass.safeClick(inner_C_home, "Home inside Modules after OldEco");
							String finalUrl = driver.getCurrentUrl();
							if (finalUrl.contains("account.beta.capium.co.uk/home")) {
								navigated = true;
								break;
							}
						} catch (Exception oe) {
							System.out.println("Retry OldEco→NewEco failed: " + oe.getMessage());
						}
					}
					retries--;
					System.out.println("Retrying Case 3 navigation, attempts left: " + retries);

				} catch (Exception e) {
					retries--;
					System.out.println(
							"Exception in Case 3 navigation, retries left: " + retries + " -> " + e.getMessage());
				}
			}
			if (!navigated) {
				throw new RuntimeException("Failed to navigate to New Eco home after retries (Case 3).");
			}
			String moduleXpath = "//h6[normalize-space()='" + Module + "']/ancestor::div[@class='card']";
			WebElement targetModule = HelperClass.waitForVisibility(driver.findElement(By.xpath(moduleXpath)));
			HelperClass.scrollIntoView(targetModule);
			HelperClass.safeClick(targetModule, Module + " Module");
			return;
		}

		throw new RuntimeException("Unknown page state → Cannot navigate to module: " + Module);
	}



	public void Logout() throws IOException {
		WebDriver driver = HelperClass.getDriver();
		WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(2));
		shortWait.pollingEvery(Duration.ofMillis(250));

		try {
			boolean logoutClicked = false;

			if (isElementVisible(loginLocators.FivePointProfileIcon, shortWait)) {
				HelperClass.clickWithRetry(loginLocators.FivePointProfileIcon, driver, shortWait);
				Log.info("Clicked 5.0 Profile Icon.");

				if (isElementVisible(loginLocators.SignoutFivePointZero, shortWait)) {
					HelperClass.clickWithRetry(loginLocators.SignoutFivePointZero, driver, shortWait);
					Log.info("Clicked 5.0 Sign Out.");
					logoutClicked = true;
				}
			}
			else if (isElementVisible(loginLocators.Logo_in_homepage, shortWait)) {
				HelperClass.clickWithRetry(loginLocators.Logo_in_homepage, driver, shortWait);
				Log.info("Clicked homepage logo.");

				if (isElementVisible(loginLocators.Logout_inside_logo, shortWait)) {
					HelperClass.clickWithRetry(loginLocators.Logout_inside_logo, driver, shortWait);
					Log.info("Clicked logout inside logo.");
					logoutClicked = true;
				}
			}

			else if (isElementVisible(loginLocators.Logout_element, shortWait)) {
				HelperClass.clickWithRetry(loginLocators.Logout_element, driver, shortWait);
				Log.info("Clicked direct logout element.");
				logoutClicked = true;
			}

			if (logoutClicked) {
				WebDriverWait loginWait = new WebDriverWait(driver, Duration.ofSeconds(8));
				loginWait.pollingEvery(Duration.ofMillis(200));
				loginWait.until(ExpectedConditions.or(
						ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[normalize-space()='365']")),
						ExpectedConditions.visibilityOfElementLocated(
								By.xpath("//p[normalize-space()='Receipts, Invoices & Bankfeeds']"))));
				Log.info("Successfully redirected to login page after logout.");
			} else {
				Log.warn("No logout element was clicked.");

			}

		} catch (TimeoutException e) {
			Log.error("Timeout: Login page not detected after logout.");

			e.printStackTrace();
			HelperClass.captureScreenshot("LogoutTimeout");
		} catch (Exception e) {
			Log.error("Logout failed: " + e.getMessage());

			e.printStackTrace();
			HelperClass.captureScreenshot("LogoutFailure");
		}
	}

	public boolean isElementVisible(WebElement element, WebDriverWait wait) {
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			return element.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
}
