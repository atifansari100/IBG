package com.interactivebrokers.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.interactivebrokers.baseclass.BaseClass;

public class PricingStructurePage extends BaseClass {

	@FindBy(xpath = "//table[@class = 'registration']//h3[contains(text(),'Pricing Structure for Stocks, Warrants and ETFs')]")
	private WebElement pageHeader;

	List<WebElement> pricingStructureForStocksRadio = driver.findElements(By.name("stk_commission_schedule"));
	List<WebElement> pricingStructureForFuturesRadio = driver.findElements(By.name("com_commission_schedule"));

	public PricingStructurePage() {

		PageFactory.initElements(driver, this);
	}

	public boolean validatePricingStructurePage() {

		try {
			if (pageHeader.isDisplayed()) {
				return true;
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public void selectPriceStructureForStocks(String rateStocks) {

		if (rateStocks == "Fixed") {
			pricingStructureForStocksRadio.get(0).click();
		} else if (rateStocks == "Tiered") {
			pricingStructureForStocksRadio.get(1).click();
		}
	}

	public void selectPriceStructureForFutures(String rateFutures) {

		if (rateFutures == "Fixed") {
			pricingStructureForFuturesRadio.get(0).click();

		} else if (rateFutures == "Tiered") {
			pricingStructureForFuturesRadio.get(1).click();

		}
	}

}
