package com.interactivebrokers.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.interactivebrokers.baseclass.BaseClass;

public class MarketDataSubscriberStatusPage extends BaseClass {

	@FindBy(xpath = "//table[@class = 'registration']//h3[contains(text(),'Market Data Subscriber Status')]")
	private WebElement pageHeader;

	@FindBy(xpath = "//input[@name = 'agrees' and @value = 'F']")
	WebElement professionalBox;

	public MarketDataSubscriberStatusPage() {

		PageFactory.initElements(driver, this);
	}

	public boolean validateMarketDataSubscriberStatusPage() {

		try {
			if (pageHeader.isDisplayed()) {
				return true;
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public void selectProfessional() {

		professionalBox.click();

	}

}
