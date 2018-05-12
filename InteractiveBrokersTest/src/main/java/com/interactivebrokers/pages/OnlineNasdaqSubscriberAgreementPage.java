package com.interactivebrokers.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.interactivebrokers.baseclass.BaseClass;

public class OnlineNasdaqSubscriberAgreementPage extends BaseClass {

	@FindBy(xpath = "//table[@class = 'registration']//h3[contains(text(),'On-Line Nasdaq Subscriber Agreement')]")
	private WebElement pageHeader;

	@FindBy(name = "signatures")
	WebElement signature;

	@FindBy(xpath = "//a[@href='javascript:doBack();']")
	WebElement backBtn;

	@FindBy(xpath = "//a[@href='javascript:doSubmit();']")
	WebElement saveAndContinue;

	public OnlineNasdaqSubscriberAgreementPage() {

		PageFactory.initElements(driver, this);
	}

	public boolean validateOnlineNasdaqSubscriberAgreementPage() {

		try {
			if (pageHeader.isDisplayed()) {
				return true;
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public void sign() {
		signature.sendKeys(MarketDataAgreementsPage.name);
	}

}
