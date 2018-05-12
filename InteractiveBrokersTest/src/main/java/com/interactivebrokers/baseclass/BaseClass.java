package com.interactivebrokers.baseclass;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BaseClass {

	public static WebDriver driver;
	public static Properties configProp;

	@FindBy(xpath = "//a[@href='javascript:doSubmit();']")
	static WebElement saveAndContinueBtn;

	@FindBy(xpath = "//a[@href='javascript:doBack();']")
	WebElement backBtn;

	@FindBy(xpath = "//a[@href = '#' and contains(text(),'Configure')]")
	static WebElement configureBtn;

	@FindBy(xpath = "//a[@href = 'Registration_v2.formProgress?s=1009']")
	static WebElement tradePermissionsLink;

	public BaseClass() {
		try {
			configProp = new Properties();
			FileInputStream configFile = new FileInputStream(
					"src/main/java/com/interactivebrokers/config/config.properties");
			configProp.load(configFile);
		} catch (IOException e) {
			e.printStackTrace();
		}

		PageFactory.initElements(driver, this);
		java.util.logging.Logger.getLogger("com.gargoylesoftware").setLevel(Level.OFF);
	}

	public void launchBrowser(String browser) {

		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"src/main/java/com/interactivebrokers/utilties/chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"src/main/java/com/interactivebrokers/utilties/geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("headless")) {
			driver = new HtmlUnitDriver(true);
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(configProp.getProperty("url"));
	}

	public void saveAndContinue() {

		saveAndContinueBtn.click();
	}

	public void navigateBack() {

		backBtn.click();

	}

	public static void navigateToTradingPermissionsPage() {

		configureBtn.click();
		tradePermissionsLink.click();
		driver.navigate().refresh();
	}

}
