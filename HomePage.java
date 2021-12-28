package com.juaracoding.slextendreport.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.juaracoding.slextendreport.driver1.DriverSingleton;

public class HomePage {
	
	private WebDriver driver;
	
	public HomePage() {
		driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	@FindBy(css = "#header > div.nav > div > div > nav > div:nth-child(1) > a > span")
	private WebElement txtUsername;
	
	@FindBy(css = "#header > div.nav > div > div > nav > div.header_user_info > a")
	private WebElement btnLoginPage;
	
	
	public void goToLoginPage() {
	btnLoginPage.click();
	}
	
	public String getUserName() {
		return txtUsername.getText();
	}
}
