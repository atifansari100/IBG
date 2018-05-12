package com.interactivebrokers.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.interactivebrokers.baseclass.BaseClass;

public class AgreementsAndDisclosurePage extends BaseClass {

	@FindBy(xpath = "//table[@class = 'registration']//h3[contains(text(),'General Agreements & Disclosures')]")
	private WebElement pageHeader;

	@FindBy(xpath = "//strong[contains(text(),'Day Trading Risk Disclosure Statement')]")
	WebElement dayTradingRiskDisclosureStatement;

	// All accept buttons
	List<WebElement> allAgreeRadios = driver.findElements(By.xpath("//input[@value = 'accept' and @type = 'radio']"));

	@FindBy(id = "sigName0")
	WebElement signatureName;

	@FindBy(id = "signature0")
	WebElement signatureBox;

	public AgreementsAndDisclosurePage() {

		PageFactory.initElements(driver, this);
	}

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

	public boolean verifyDayTradingRiskDisclosureStatement() {

		try {
			boolean bool = dayTradingRiskDisclosureStatement.isDisplayed();
			return bool;
		} catch (Exception e) {
			return false;
		}
	}

	public void acceptAllDisclosures() {

		for (WebElement list : allAgreeRadios) {
			list.click();
		}

	}

	public void sign() {
		String name = signatureName.getText();
		signatureBox.sendKeys(name);
	}

}
