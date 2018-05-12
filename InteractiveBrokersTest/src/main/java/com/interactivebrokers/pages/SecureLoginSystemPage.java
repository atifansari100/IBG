package com.interactivebrokers.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.interactivebrokers.baseclass.BaseClass;

public class SecureLoginSystemPage extends BaseClass {

	@FindBy(xpath = "//table[@class = 'registration']//h3[contains(text(),'Secure Login System')]")
	private WebElement pageHeader;

	@FindBy(id = "activateID")
	WebElement activateOnline;

	@FindBy(id = "activateNID")
	WebElement doNotActivate;

	public SecureLoginSystemPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean validateSecureLoginSystemPage() {

		try {
			if (pageHeader.isDisplayed()) {
				return true;
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public void doNotActivate() {
		doNotActivate.click();
	}

}
