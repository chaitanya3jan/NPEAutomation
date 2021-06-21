package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver ldriver) {
		
		this.driver = ldriver;
		
	}
	
	@FindBy(name="username") WebElement uname;
	
	@FindBy(name="password") WebElement pwd;
	
	@FindBy(xpath="//button[contains(text(),'Login')]") WebElement loginbtton;
	
	public void loginToCRM(String username, String password) {
		uname.sendKeys(username);
		pwd.sendKeys(password);
		loginbtton.click();
	}

}
