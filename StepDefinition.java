package com.juaracoding.slextendreport.glue;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.juaracoding.slextendreport.config.AutomationFrameworkConfiguration;
import com.juaracoding.slextendreport.driver1.DriverSingleton;
import com.juaracoding.slextendreport.page.HomePage;
import com.juaracoding.slextendreport.page.LoginPage;
import com.juaracoding.slextendreport.utils.ConfigurationProperties;
import com.juaracoding.slextendreport.utils.Constants;


import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.spring.CucumberContextConfiguration;


@CucumberContextConfiguration
@ContextConfiguration(classes = AutomationFrameworkConfiguration.class)

public class StepDefinition {
	
	private WebDriver driver;
	private HomePage homePage;
	private LoginPage loginPage;
	
	@Autowired
	ConfigurationProperties configurationProperties;
	
	@Before
	public void initializeObjects() {
		DriverSingleton.getInstance(configurationProperties.getBrowser());
		homePage = new HomePage();
		loginPage = new LoginPage();
		
	}
	
	@Given("^User go to the Website")
	public void user_go_to_the_Website() {
		driver = DriverSingleton.getDriver();
		driver.get(Constants.URL);
	}
	
	@When("^User click Login Page")
	public void user_click_login_page() {
		homePage.goToLoginPage();
	}
	
	@When("^User input username password and click Signin")
	public void user_input_username_password_and_click_Signin() {
		loginPage.goToSignin(configurationProperties.getEmail(),configurationProperties.getPassword());
	}
	
	@Then("^User can login to the Website")
	public void user_can_login_to_the_Website() {
		assertEquals(configurationProperties.getUsername(), homePage.getUserName());
	}
}
