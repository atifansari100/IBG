package com.interactivebrokers.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.interactivebrokers.baseclass.BaseClass;

public class ProfessionalMarketDataSubscriptionsPage extends BaseClass {

	@FindBy(xpath = "//table[@class = 'registration']//h3[contains(text(),'Professional Market Data Subscriptions')]")
	private WebElement pageHeader;

	@FindBy(xpath = "//a[contains(text(), 'North America')]")
	WebElement northAmericaTab;

	@FindBy(xpath = "//a[contains(text(), 'Europe')]")
	WebElement europeTab;

	// All check boxes under the North America Tab
	List<WebElement> allMarketDataNorthAmericaCheckboxes = driver
			.findElements(By.xpath("//div[@id = 'tabs-1']//input[@type='checkbox']"));

	public ProfessionalMarketDataSubscriptionsPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean validateProfessionalMarketDataSubscriptionsPage() {

		try {
			if (pageHeader.isDisplayed()) {
				return true;
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public String getTitleOfPage() {
		
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(pageHeader));
		
		String pageTitle = driver.getTitle();
		return pageTitle;
	}
	
	public void checkAllMarketDataNorthAmerica() {
		northAmericaTab.click();
		
		
		
		for (WebElement list : allMarketDataNorthAmericaCheckboxes) {			
			if (!list.isSelected()) { // check the box only if it is not selected.
				list.click();
			}
		}
	}

}
