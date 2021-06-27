package com.aautomation.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.automation.pages.Base;
import com.automation.pages.Mainmenu;

//import dataprovider.TestDataProvider;

public class MainmenuScenarios extends Base {
	
	
	

	@Test(enabled=false)
	public void addIndividualFromMainmenu() {

		logger = report.createTest("Mainmenu");

		Mainmenu mainmenu = PageFactory.initElements(driver, Mainmenu.class);

		mainmenu.addIndividualContact(excel.getStringData("AddIndividualFullDetails", 1, 0),
				excel.getStringData("AddIndividualFullDetails", 1, 1),
				excel.getStringData("AddIndividualFullDetails", 1, 2),
				excel.getStringData("AddIndividualFullDetails", 1, 3),
				excel.getStringData("AddIndividualFullDetails", 1, 4),
				excel.getStringData("AddIndividualFullDetails", 1, 5),
				excel.getStringData("AddIndividualFullDetails", 1, 6),
				excel.getStringData("AddIndividualFullDetails", 1, 7),
				excel.getStringData("AddIndividualFullDetails", 1, 8),
				excel.getStringData("AddIndividualFullDetails", 1, 9),
				excel.getStringData("AddIndividualFullDetails", 1, 10),
				excel.getStringData("AddIndividualFullDetails", 1, 11),
				excel.getStringData("AddIndividualFullDetails", 1, 12),
				excel.getNumericDatatoString("AddIndividualFullDetails", 1, 13),
				excel.getStringData("AddIndividualFullDetails", 1, 14),
				excel.getStringData("AddIndividualFullDetails", 1, 15),
				excel.getStringData("AddIndividualFullDetails", 1, 16),
				excel.getStringData("AddIndividualFullDetails", 1, 17),
				excel.getStringData("AddIndividualFullDetails", 1, 18),
				excel.getStringData("AddIndividualFullDetails", 1, 19),
				excel.getStringData("AddIndividualFullDetails", 1, 20),
				excel.getNumericDatatoString("AddIndividualFullDetails", 1, 21),
				excel.getStringData("AddIndividualFullDetails", 1, 22),
				excel.getStringData("AddIndividualFullDetails", 1, 23),
				excel.getStringData("AddIndividualFullDetails", 1, 24)
				);
				
				mainmenu.duplicateCheck();

	}
	@Test
	public void addOrgFromMainmenu() {

		logger = report.createTest("MainmenuAddOrg");

		Mainmenu mainmenu = PageFactory.initElements(driver, Mainmenu.class);

		mainmenu.addOrgContact(excel.getStringData("OrganizationFullDetails", 1, 0),
				excel.getStringData("OrganizationFullDetails", 1, 1),
				excel.getNumericDatatoString("OrganizationFullDetails", 1, 2),
				excel.getStringData("OrganizationFullDetails", 1, 3),
				excel.getNumericDatatoString("OrganizationFullDetails", 1, 4),
				excel.getNumericDatatoString("OrganizationFullDetails", 1, 5),
				excel.getStringData("OrganizationFullDetails", 1, 6),
				excel.getStringData("OrganizationFullDetails", 1, 7),
				excel.getStringData("OrganizationFullDetails", 1, 8),
				excel.getStringData("OrganizationFullDetails", 1, 9),
				excel.getStringData("OrganizationFullDetails", 1, 10),
				excel.getStringData("OrganizationFullDetails", 1, 11),
				excel.getNumericDatatoString("OrganizationFullDetails", 1, 12),
				excel.getNumericDatatoString("OrganizationFullDetails", 1, 13),
				excel.getStringData("OrganizationFullDetails", 1, 14),
				excel.getNumericDatatoString("OrganizationFullDetails", 1, 15),
				excel.getStringData("OrganizationFullDetails", 1, 16),
				excel.getStringData("OrganizationFullDetails", 1, 17),
				excel.getStringData("OrganizationFullDetails", 1, 18),
				excel.getStringData("OrganizationFullDetails", 1, 19)
				);
				
				//mainmenu.duplicateCheck();

	}

}
