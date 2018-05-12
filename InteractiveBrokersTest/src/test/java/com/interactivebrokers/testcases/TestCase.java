package com.interactivebrokers.testcases;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.interactivebrokers.baseclass.BaseClass;
import com.interactivebrokers.pages.AgreementsAndDisclosurePage;
import com.interactivebrokers.pages.ApplicationStatusPage;
import com.interactivebrokers.pages.ConfigurationReviewPage;
import com.interactivebrokers.pages.LoginPage;
import com.interactivebrokers.pages.MarketDataAgreementsPage;
import com.interactivebrokers.pages.MarketDataSubscriberStatusPage;
import com.interactivebrokers.pages.NasdBtdsSubscriberAgreement;
import com.interactivebrokers.pages.OnlineNasdaqSubscriberAgreementPage;
import com.interactivebrokers.pages.PricingStructurePage;
import com.interactivebrokers.pages.ProfessionalMarketDataSubscriptionsPage;
import com.interactivebrokers.pages.ResearchSubscriptionsPage;
import com.interactivebrokers.pages.SecureLoginSystemPage;
import com.interactivebrokers.pages.TradingPermissionsPage;



public class TestCase extends BaseClass{

	
	LoginPage loginPage;
	TradingPermissionsPage tradingPermissionsPage;
	MarketDataSubscriberStatusPage marketDataSubscriberStatusPage;
	ResearchSubscriptionsPage researchSubscriptionsPage;
	ProfessionalMarketDataSubscriptionsPage professionalmarketDataSubscriptionsPage;
	PricingStructurePage pricingStructurePage;
	ConfigurationReviewPage configurationReviewPage;
	AgreementsAndDisclosurePage agreementsAndDisclosurePage;
	MarketDataAgreementsPage marketDataAgreementsPage;
	OnlineNasdaqSubscriberAgreementPage onlineNasdaqSubscriberAgreementPage;
	NasdBtdsSubscriberAgreement nasdBtdsSubscriberAgreement;
	SecureLoginSystemPage secureLoginSystemPage;
	ApplicationStatusPage applicationStatusPage;

	public TestCase() {
		// call super class constructor
		super();
	}
	
	// Passing parameters from testng.xml file to run on multiple browsers.
	@Parameters("browser")
	@BeforeMethod
	public void setup(String browser) {
		launchBrowser(browser);
		loginPage = new LoginPage();

	}

	@Test(priority=1)
	public void IBGTest() {
		
		
		boolean isLoginPage = loginPage.validateLoginPage();
		Assert.assertTrue(isLoginPage, "--We are not on Login Page--");
		
		loginPage.login(configProp.getProperty("username"), configProp.getProperty("password"), "Live Account", "Home");
		
		// Image 1
		tradingPermissionsPage = new TradingPermissionsPage();
		
		// validating to verify if we are on TradingPermissionsPage. Doing similar validation on every page.
		boolean isTradingPermissionPage = tradingPermissionsPage.validateTradingPermissionsPage();
		Assert.assertTrue(isTradingPermissionPage, "--We are not on Trading Permissions Page--");
		
		tradingPermissionsPage.checkAllNorthAmerica();
		tradingPermissionsPage.continueToNextPage();
		
		// Image 2
		marketDataSubscriberStatusPage =new MarketDataSubscriberStatusPage();
		boolean isMarketDataSubscriberStatusPage = marketDataSubscriberStatusPage.validateMarketDataSubscriberStatusPage();
		Assert.assertTrue(isMarketDataSubscriberStatusPage, "--We are not on Market Data Subscriber Status Page--");
		
		marketDataSubscriberStatusPage.selectProfessional();
		marketDataSubscriberStatusPage.saveAndContinue();
		
		// Image 3		
		researchSubscriptionsPage = new ResearchSubscriptionsPage();
		boolean isResearchSubscriptionsPage = researchSubscriptionsPage.validateResearchSubscriptionsPage();
		Assert.assertTrue(isResearchSubscriptionsPage, "--We are not on Research Subscription Page--");
		
		researchSubscriptionsPage.saveAndContinue();

		// Image 4		
		professionalmarketDataSubscriptionsPage = new ProfessionalMarketDataSubscriptionsPage();
		boolean isProfessionalMarketDataSubscriptionsPage = professionalmarketDataSubscriptionsPage.validateProfessionalMarketDataSubscriptionsPage();
		Assert.assertTrue(isProfessionalMarketDataSubscriptionsPage, "--We are not on Professional Market Data Subscriptions Page--");
		
		String titleMarketDataSubscriptionsPage = professionalmarketDataSubscriptionsPage.getTitleOfPage();
		System.out.println(titleMarketDataSubscriptionsPage);
		professionalmarketDataSubscriptionsPage.checkAllMarketDataNorthAmerica();
		professionalmarketDataSubscriptionsPage.saveAndContinue();
		
		// Image 5		
		pricingStructurePage = new PricingStructurePage();
		boolean isPricingStructurePage = pricingStructurePage.validatePricingStructurePage();
		Assert.assertTrue(isPricingStructurePage, "--We are not on Pricing Structure Page--");
		
		pricingStructurePage.selectPriceStructureForStocks("Fixed");
		pricingStructurePage.selectPriceStructureForFutures("Fixed");
		pricingStructurePage.saveAndContinue();
		
		// Image 6
		configurationReviewPage = new ConfigurationReviewPage();
		boolean isConfigurationReviewPage = configurationReviewPage.validateConfigurationReviewPage();
		Assert.assertTrue(isConfigurationReviewPage, "--We are not on Configuration Review Page--");
		
		configurationReviewPage.saveAndContinue();
		
		// Image 7
		
		agreementsAndDisclosurePage =  new AgreementsAndDisclosurePage();
		boolean isAgreementsAndDisclosurePage = agreementsAndDisclosurePage.validateAgreementsAndDisclosurePage();
		Assert.assertTrue(isAgreementsAndDisclosurePage, "--We are not on Agreements and Disclosure Page--");
		
		boolean isDayTradingDisclosurePresent = agreementsAndDisclosurePage.verifyDayTradingRiskDisclosureStatement();
		Assert.assertTrue(isDayTradingDisclosurePresent, "--Day Trading Risk Disclosure Statement is not present--");
		agreementsAndDisclosurePage.acceptAllDisclosures();
		agreementsAndDisclosurePage.sign();
		agreementsAndDisclosurePage.saveAndContinue();
		
		// Image 8		
		marketDataAgreementsPage = new MarketDataAgreementsPage();
		boolean isMarketDataAgreementsPage = marketDataAgreementsPage.validateAgreementsAndDisclosurePage();
		Assert.assertTrue(isMarketDataAgreementsPage, "--We are not on Market Data Agreements Page--");
		
		marketDataAgreementsPage.agreeToMarketDataAgreements();
		marketDataAgreementsPage.sign();
		marketDataAgreementsPage.saveAndContinue();
		
		// We don't have pages shown in Image 9 and Image 10 in the application. Moving forward.
		onlineNasdaqSubscriberAgreementPage = new OnlineNasdaqSubscriberAgreementPage();
		boolean isOnlineNasdaqSubscriberAgreementPage = onlineNasdaqSubscriberAgreementPage.validateOnlineNasdaqSubscriberAgreementPage();
		Assert.assertTrue(isOnlineNasdaqSubscriberAgreementPage, "--We are not on On-Line Nasdaq Subscriber Agreement Page--");
		
		onlineNasdaqSubscriberAgreementPage.sign();
		onlineNasdaqSubscriberAgreementPage.saveAndContinue();
		
		// Image 11
		nasdBtdsSubscriberAgreement = new NasdBtdsSubscriberAgreement();
		boolean isNasdBtdsSubscriberAgreement = nasdBtdsSubscriberAgreement.validateNasdBtdsSubscriberAgreement();
		Assert.assertTrue(isNasdBtdsSubscriberAgreement, "--We are not on NASD BTDS Subscriber Agreement Page--");
		
		nasdBtdsSubscriberAgreement.sign();
		nasdBtdsSubscriberAgreement.saveAndContinue();
		
		// Image 12
		secureLoginSystemPage = new SecureLoginSystemPage();
		boolean isSecureLoginSystemPage = secureLoginSystemPage.validateSecureLoginSystemPage();
		Assert.assertTrue(isSecureLoginSystemPage, "--We are not on Secure Login System Page--");
		
		secureLoginSystemPage.doNotActivate();
		
		// Image 13
		applicationStatusPage = new ApplicationStatusPage();
		boolean isApplicationStatusPage = applicationStatusPage.validateApplicationStatusPage();
		Assert.assertTrue(isApplicationStatusPage, "--We are not on Application Status Page--");
		boolean isPendingReviewStatusPresent = applicationStatusPage.confirmApplicationPendingReview();
		Assert.assertTrue(isPendingReviewStatusPresent, "--Pending Review status is not present--");

	}
	
	@AfterMethod
	public void quitBrower() {
		
		// Navigating back to Trading Permissions Page so that we can go to start page for next run 
		// Otherwise next login will take you to the Application Status Page
		BaseClass.navigateToTradingPermissionsPage();
		driver.quit();
	}
	
}
