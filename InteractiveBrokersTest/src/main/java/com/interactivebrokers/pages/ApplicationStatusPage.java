package com.interactivebrokers.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.interactivebrokers.baseclass.BaseClass;

public class ApplicationStatusPage extends BaseClass {

	@FindBy(xpath = "//div[@class = 'app_status_box_title' and contains(text(),'Application Status')]")
	private WebElement pageHeader;

	@FindBy(xpath = "//div[@class = 'app_status_box_title']//span[contains(text(),'Pending Review')]")
	WebElement applicationPendingReview;

	@FindBy(xpath = "//a[@href = '#' and contains(text(),'Configure')]")
	WebElement configureBtn;

	public ApplicationStatusPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean validateApplicationStatusPage() {

		try {
			if (pageHeader.isDisplayed()) {
				return true;
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public boolean confirmApplicationPendingReview() {

		try {
			if (applicationPendingReview.isDisplayed()) {
				return true;
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}
