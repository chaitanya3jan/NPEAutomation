package com.aautomation.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.automation.pages.Base;
import com.automation.pages.Dashboard;
import com.automation.pages.LoginPage;

public class DashboardQuick extends Base {

	// logger = report.createTest("Dashboard");

	@Test(enabled = false)
	public void quickIndividual() {

		logger = report.createTest("DashboardQuick-AddIndividual");

		Dashboard dashboard = PageFactory.initElements(driver, Dashboard.class);

		dashboard.addIndividaulBySaveClose(excel.getStringData("Individual", 1, 0),
				excel.getStringData("Individual", 1, 1));

	}

	@Test(enabled = false)
	public void quickOrganization() throws InterruptedException {

		logger = report.createTest("DashboardQuick-AddOrganization");

		Dashboard dashboard = PageFactory.initElements(driver, Dashboard.class);

		dashboard.addOrganization(excel.getStringData("Organization", 1, 0), excel.getStringData("Organization", 1, 1),
				excel.getNumericDatatoString("Organization", 1, 2), excel.getNumericDatatoString("Organization", 1, 3),
				excel.getStringData("Organization", 1, 4), excel.getNumericDatatoString("Organization", 1, 5),
				excel.getStringData("Organization", 1, 6), excel.getStringData("Organization", 1, 7),
				excel.getNumericDatatoString("Organization", 1, 8), excel.getStringData("Organization", 1, 9),
				excel.getStringData("Organization", 1, 10), excel.getStringData("Organization", 1, 11),
				excel.getStringData("Organization", 1, 12));

	}

	@Test(enabled = false)
	public void deleteIndividual() {

		logger = report.createTest("DashboardQuick-AddIndividual-Delete");

		Dashboard dashboard = PageFactory.initElements(driver, Dashboard.class);

		dashboard.deleteIndividaul(excel.getStringData("DeleteContact", 1, 0),
				excel.getStringData("DeleteContact", 1, 1));

	}

	@Test(enabled = false)
	public void AddInKindFund() {

		logger = report.createTest("DashboardQuick-Add-InKind-Fund");

		Dashboard dashboard = PageFactory.initElements(driver, Dashboard.class);

		dashboard.AddInKindFund(excel.getStringData("AddInKindGift", 1, 0), excel.getStringData("AddInKindGift", 1, 1),
				excel.getStringData("AddInKindGift", 1, 2), excel.getNumericData("AddInKindGift", 1, 3),
				excel.getStringData("AddInKindGift", 1, 4), excel.getStringData("AddInKindGift", 1, 5));

	}

	@Test(enabled = false)
	public void AddFund() {

		logger = report.createTest("DashboardQuick-Add-Fund");

		Dashboard dashboard = PageFactory.initElements(driver, Dashboard.class);

		dashboard.AddFund(excel.getStringData("AddGift", 1, 0), excel.getStringData("AddGift", 1, 1),
				excel.getStringData("AddGift", 1, 2), excel.getStringData("AddGift", 1, 3),
				excel.getNumericDatatoString("AddGift", 1, 4), excel.getStringData("AddGift", 1, 5),
				excel.getStringData("AddGift", 1, 6), excel.getStringData("AddGift", 1, 7),
				excel.getStringData("AddGift", 1, 8));

	}
	
	@Test
	public void AddGiftforAppealFund() {

		logger = report.createTest("DashboardQuick-Add-Fund for Appeal");

		Dashboard dashboard = PageFactory.initElements(driver, Dashboard.class);

		dashboard.AddFundforAppeal(excel.getStringData("Appeal", 1, 0), excel.getStringData("Appeal", 1, 1),excel.getStringData("Appeal", 1, 2));

	}

}
