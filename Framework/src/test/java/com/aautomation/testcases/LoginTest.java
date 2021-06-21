package com.aautomation.testcases;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.automation.pages.Base;
import com.automation.pages.LoginPage;
import com.automation.utilities.Helper;

public class LoginTest extends Base {
	

	


	@Test
	public void loginApp() throws IOException {
		
		logger = report.createTest("LoginToFundly"); //This is added to create report 
			
		
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		
		logger.info("Starting Applicaton");
		
		loginpage.loginToCRM(excel.getStringData("Login", 0, 0), excel.getStringData("Login", 0, 1));
		
		System.out.println(driver.getTitle());
		
		logger.pass("Login completed");
		
		//Helper.captureScreenshot(driver);
		
		
	}

}
