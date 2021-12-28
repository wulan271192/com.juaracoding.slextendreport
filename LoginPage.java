package com.juaracoding.slextendreport.page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.juaracoding.slextendreport.driver1.DriverSingleton;

public class LoginPage {
	
	private WebDriver driver;
	
	public LoginPage() {
		driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "email")
	private WebElement txtEmail;
	
	@FindBy(id = "passwd")
	private WebElement txtPassword;
	
	@FindBy(id = "SubmitLogin")
	private WebElement btnSignin;
	
	public void goToSignin(String email, String password) {
		JavascriptExecutor js = (JavascriptExecutor)driver;	
		js.executeScript("window.scrollBy(0,500)");
		txtEmail.sendKeys(email);
		txtPassword.sendKeys(password);
		btnSignin.click();
	}

}
