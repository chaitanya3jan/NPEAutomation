package com.aautomation.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automation.pages.Base;
import com.automation.pages.Mainmenu;
import com.automation.utilities.ExcelDataProvider;

//import dataprovider.TestDataProvider;

public class MainmenuScenarios2 extends Base {

	ExcelDataProvider xl;

	@DataProvider(name = "getContactData")
	public Object[][] getContactData() {
		
		try {
			xl = new ExcelDataProvider("./TestData/Data.xlsx");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Object data[][] = xl.getContactData("AddIndividualFullDetails");
		
		return data;
	}

	@Test(dataProvider = "getContactData")
	public void addIndividualFromMainmenu(String primaryNPContact, String prefix, String fname, String mname,
			String lname, String suffix, String gender, String dob, String nick, String fsalutation,
			String contactsource, String address1, String address2, String zipCode, String cityName, String stateName, String country,
			String addrCategory, String billingAddres, String emailaddress, String emailType, String phonenumber,
			String phonecall, String sendmail, String sendemail) {

		logger = report.createTest("Mainmenu");

		Mainmenu mainmenu = PageFactory.initElements(driver, Mainmenu.class);

		mainmenu.addIndividualContact(primaryNPContact, prefix, fname, mname, lname, suffix, gender, dob, nick,
				fsalutation, contactsource, address1, address2, zipCode, cityName, stateName, country, addrCategory,
				billingAddres, emailaddress, emailType, phonenumber, phonecall, sendmail, sendemail);

		mainmenu.duplicateCheck();
		
		/*
		 * mainmenu.addIndividualContact(excel.getStringData("AddIndividualFullDetails",
		 * 1, 0), excel.getStringData("AddIndividualFullDetails", 1, 1),
		 * excel.getStringData("AddIndividualFullDetails", 1, 2),
		 * excel.getStringData("AddIndividualFullDetails", 1, 3),
		 * excel.getStringData("AddIndividualFullDetails", 1, 4),
		 * excel.getStringData("AddIndividualFullDetails", 1, 5),
		 * excel.getStringData("AddIndividualFullDetails", 1, 6),
		 * excel.getStringData("AddIndividualFullDetails", 1, 7),
		 * excel.getStringData("AddIndividualFullDetails", 1, 8),
		 * excel.getStringData("AddIndividualFullDetails", 1, 9),
		 * excel.getStringData("AddIndividualFullDetails", 1, 10),
		 * excel.getStringData("AddIndividualFullDetails", 1, 11),
		 * excel.getStringData("AddIndividualFullDetails", 1, 12),
		 * excel.getNumericDatatoString("AddIndividualFullDetails", 1, 13),
		 * excel.getStringData("AddIndividualFullDetails", 1, 14),
		 * excel.getStringData("AddIndividualFullDetails", 1, 15),
		 * excel.getStringData("AddIndividualFullDetails", 1, 17),
		 * excel.getStringData("AddIndividualFullDetails", 1, 18),
		 * excel.getStringData("AddIndividualFullDetails", 1, 19),
		 * excel.getNumericDatatoString("AddIndividualFullDetails", 1, 21),
		 * excel.getStringData("AddIndividualFullDetails", 1, 22),
		 * excel.getStringData("AddIndividualFullDetails", 1, 23),
		 * excel.getStringData("AddIndividualFullDetails", 1, 24) );
		 */

	}

}
