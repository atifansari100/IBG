package com.interactivebrokers.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.interactivebrokers.baseclass.BaseClass;

public class NasdBtdsSubscriberAgreement extends BaseClass {

	@FindBy(xpath = "//table[@class = 'registration']//h3[contains(text(),'NASD BTDS Subscriber Agreement')]")
	private WebElement pageHeader;

	@FindBy(id = "signatures0")
	WebElement signature;

	@FindBy(id = "bysignatures0")
	WebElement bySignature;

	public NasdBtdsSubscriberAgreement() {

		PageFactory.initElements(driver, this);

	}

	public boolean validateNasdBtdsSubscriberAgreement() {

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
		bySignature.sendKeys(MarketDataAgreementsPage.name);
	}

}
