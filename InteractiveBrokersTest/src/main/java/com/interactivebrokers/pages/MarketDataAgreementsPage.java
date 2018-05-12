package com.interactivebrokers.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.interactivebrokers.baseclass.BaseClass;

public class MarketDataAgreementsPage extends BaseClass {

	public static String name;

	@FindBy(xpath = "//table[@class = 'registration']//h3[contains(text(),'Market Data Agreements')]")
	private WebElement pageHeader;

	@FindBy(id = "agree1")
	WebElement section2AgreementCheckbox;

	@FindBy(id = "agree3")
	WebElement section11AgreementCheckbox;

	@FindBy(id = "agree2")
	WebElement marketDataSubscriberAgreementCheckbox;

	@FindBy(xpath = "//input[@name = 'PRO' and @value = 'F']")
	WebElement noProfessionalSubscriberAgreementRadio;

	@FindBy(xpath = "//input[@name = 'NON-PRO' and @value = 'T']")
	WebElement yesNonProfessionalSubscriberAgreementRadio;

	@FindBy(id = "sigName0")
	WebElement signatureName;

	@FindBy(id = "signature0")
	WebElement signatureBox;

	public boolean validateAgreementsAndDisclosurePage() {

		try {
			if (pageHeader.isDisplayed()) {
				return true;
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public MarketDataAgreementsPage() {

		PageFactory.initElements(driver, this);
	}

	public void agreeToMarketDataAgreements() {
		if (!section2AgreementCheckbox.isSelected()) {
			section2AgreementCheckbox.click();
		}

		if (!section11AgreementCheckbox.isSelected()) {
			section11AgreementCheckbox.click();
		}

		if (!marketDataSubscriberAgreementCheckbox.isSelected()) {
			marketDataSubscriberAgreementCheckbox.click();
		}

		// Assuming this account is a "Non - Professional Subscriber" account.
		yesNonProfessionalSubscriberAgreementRadio.click();
		noProfessionalSubscriberAgreementRadio.click();

	}

	public void sign() {
		name = signatureName.getText();
		signatureBox.sendKeys(name);
	}

}
