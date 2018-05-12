package com.interactivebrokers.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.interactivebrokers.baseclass.BaseClass;

public class TradingPermissionsPage extends BaseClass {

	@FindBy(xpath = "//table[@class = 'registration']//h3[contains(text(),'Trade Permissions')]")
	private WebElement pageHeader;

	List<WebElement> allNorthAmericaCheckboxes = driver
			.findElements(By.xpath("//tr[@region='North America']//input[@name = 'checkAll']"));

	@FindBy(xpath = "//a[@id= 'continueID']")
	WebElement continueBtn;

	public TradingPermissionsPage() {

		PageFactory.initElements(driver, this);
	}

	public boolean validateTradingPermissionsPage() {
		int maxTries = 3;
		boolean present = false;
		do {

			try {
				if (pageHeader.isDisplayed())
					present = true;
				return true;

			} catch (Exception e) {
				BaseClass.navigateToTradingPermissionsPage();
				System.out.println("Cant find " + maxTries);
				maxTries--;

				if (maxTries == 0) {
					return false;
				}
			}

		} while (present == false && maxTries > 0);

		return true;
	}

	public void checkAllNorthAmerica() {

		for (WebElement list : allNorthAmericaCheckboxes) {
			if (!list.isSelected()) { // check only if the box is unchecked.
				list.click();
			}
		}
	}

	public void continueToNextPage() {
		continueBtn.click();
	}

}
