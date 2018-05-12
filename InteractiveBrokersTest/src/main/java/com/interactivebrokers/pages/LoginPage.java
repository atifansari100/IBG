package com.interactivebrokers.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.interactivebrokers.baseclass.BaseClass;

public class LoginPage extends BaseClass {

	@FindBy(xpath = "//div[@id = 'contents']//h2[contains(text(),'Account Management Login')]")
	private WebElement pageHeader;
	
	@FindBy(id = "user_name")
	WebElement username;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(id = "loginType")
	WebElement accounttype;

	@FindBy(id = "forwardTo")
	WebElement gotopage;

	@FindBy(xpath = "//a[contains(text(),'Forgot Password?')]")
	WebElement forgotpassword;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement loginBtn;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean validateLoginPage() {

		try {
			if (pageHeader.isDisplayed()) {
				return true;
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public void login(String uname, String pwd, String actype, String navigatetopage) {

		username.sendKeys(uname);
		password.sendKeys(pwd);

		Select accountDropdown = new Select(accounttype);
		accountDropdown.selectByVisibleText(actype);

		Select gotoDropdown = new Select(gotopage);
		gotoDropdown.selectByVisibleText(navigatetopage);

		loginBtn.click();
	}

	public void clickForgotPassword() {

		forgotpassword.click();
	}

}
