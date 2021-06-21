package com.aautomation.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.automation.pages.Base;
import com.automation.pages.Dashboard;
import com.automation.pages.LoginPage;

public class DashboardQuick extends Base {
	
	//logger = report.createTest("Dashboard");
	
	@Test
	public void quickIndividual() {
		
		logger = report.createTest("DashboardQuick");
		
		Dashboard dashboard = PageFactory.initElements(driver, Dashboard.class);
		
		dashboard.addIndividaulBySaveClose(excel.getStringData("Individual", 1, 0), excel.getStringData("Individual", 1, 1));
		
		
		
	}

}
