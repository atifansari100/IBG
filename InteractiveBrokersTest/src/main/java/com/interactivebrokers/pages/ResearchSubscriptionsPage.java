package com.interactivebrokers.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.interactivebrokers.baseclass.BaseClass;

public class ResearchSubscriptionsPage extends BaseClass {

	@FindBy(xpath = "//td[@align = 'center']//strong[contains(text(),'Research Subscriptions')]")
	private WebElement pageHeader;

	public ResearchSubscriptionsPage() {

		PageFactory.initElements(driver, this);
	}

	public boolean validateResearchSubscriptionsPage() {

		try {
			if (pageHeader.isDisplayed()) {
				return true;
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}
