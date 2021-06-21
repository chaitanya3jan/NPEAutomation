package com.automation.pages;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.automation.utilities.BrowserFactory;
import com.automation.utilities.Helper;

public class Mainmenu {

	WebDriver driver;

	public Mainmenu(WebDriver mdriver) {

		this.driver = mdriver;

	}

	@FindBy(id = "contactselector")
	WebElement contactSearch;
	@FindBy(xpath = "//*[@id='topNavigation']/div[1]/span[1]")
	WebElement menu;
	@FindBy(xpath = "//div[@title='Contacts']")
	WebElement contactmenu;
	@FindBy(xpath = "//*[@id='contactNav']/div/ul[1]/li[1]/a")
	WebElement addindividualLink;
	@FindBy(xpath = "//ul/li[1]/a/table/tbody/tr[1]/td[1]/h5/span[2]")
	WebElement primarycontact;
	@FindBy(xpath = "//select[@id='Prefix']")
	WebElement prefixOption;
	@FindBy(xpath = "//input[@name='FirstName']")
	WebElement firstname;
	@FindBy(xpath = "//*[@id='spnAddEditContact']/form/div/div[1]/div[1]/div/div/div[6]/span[2]/input")
	WebElement middlename;
	@FindBy(xpath = "//input[@name='LastName']")
	WebElement lastname;
	@FindBy(xpath = "//select[@id='Suffix']")
	WebElement sfix;
	@FindBy(xpath = "//select[@id='Gender']")
	WebElement gendr;
	@FindBy(xpath = "//*[@id=\"spnAddEditContact\"]/form/div/div[1]/div[1]/div/div/div[11]/span[2]/div/input")
	WebElement datepicker;
	@FindBy(xpath = "//table/thead/tr[1]/th[2]")
	WebElement calendar;
	@FindBy(xpath = "//table/thead/tr[1]/th[1]")
	WebElement prev;
	@FindBy(xpath = "//table/thead/tr[1]/th[4]")
	WebElement next;
	@FindBy(xpath = "//table/tbody/tr/td[contains(text(),'12')]")
	WebElement daytoselect;
	@FindBy(xpath = "//input[@data-ng-model='Individual.NickName']")
	WebElement nickname;
	@FindBy(xpath = "//span/salutation[@salutation='Individual.FormalSalutation']")
	WebElement formalsalutation;
	@FindBy(xpath = "//input[@name='AddressLine1']")
	WebElement add1;
	@FindBy(xpath = "//input[@data-ng-model='Address.AddressLine2']")
	WebElement add2;
	@FindBy(xpath = "//input[@ng-model='Address.PostalCode']")
	WebElement postalcode;
	@FindBy(xpath = "//input[@data-ng-model='Address.SelectedCity']")
	WebElement city;
	@FindBy(xpath = "//div/select[@id='State']")
	WebElement state;
	@FindBy(xpath = "//span/select[@ng-model='Address.AddressCategory']")
	WebElement addressCategory;
	// @FindBy(xpath="//input[@id='r-SameAsBilling']")
	// @FindBy(xpath="//*[contains(text(),'Same as Mailing Address')]")
	@FindBy(how = How.ID, using = "r-SameAsBilling")
	WebElement billingAddrCheckbox;
	@FindBy(xpath = "//input[@name='Email0']")
	WebElement email;
	@FindBy(xpath = "//input[@name='Phone0']")
	WebElement phone;
	@FindBy(xpath = "//*[@id=\"spnAddEditContact\"]/form/div/div[3]/button[2]")
	WebElement saveButton;
	@FindBy(xpath = "//select[@name='PhoneSource']")
	WebElement phonecommunication;
	@FindBy(xpath = "//select[@name='MailSource']")
	WebElement mailsource;
	@FindBy(xpath = "//select[@name='EmailSource']")
	WebElement emailsource;
	@FindBy(xpath ="//div[@class='modal-content']")
	WebElement duplicateContact;
	@FindBy(xpath="//button[contains(text(),'Cancel')] | //button[contains(text(),'Close')]")
	WebElement cancelduplicate;
	@FindBy(xpath="//span[@class='logo-image']")
	WebElement logo;
	@FindBy(xpath="//*[@id=\"spnContactViewLayout\"]/header/div[1]/div[2]/h1")
	WebElement contactinfo;


	public void addIndividualContact(String primaryNPContact, String prefix, String fname, String mname, String lname,
			String suffix, String gender, String dob, String nick, String fsalutation, String contactsource,
			String address1, String address2, String zipCode, String cityName, String stateName, String country, String addrCategory,
			String billingAddres, String emailaddress, String emailType, String phonenumber, String phonecall,
			String sendmail, String sendemail) {

		// String zipvalue = String.valueOf(zipCode);
		
		//data type is changed from String to Integer for Zip code and phone number - 20 June

		String zipvalue = zipCode.toString();

		String phonenumber1 = phonenumber.toString();

		menu.click(); // Main menu click

		Helper.waitElement(driver, contactmenu).click(); // This will click on contact option on main menu

		addindividualLink.click(); // This will click on add individual contact link

		contactSearch.sendKeys(primaryNPContact);

		//dataProviderMethod();
		
		Helper.waitElement(driver, primarycontact).click();

		Helper.selectDropdown(prefixOption, prefix); // This will select value from Prefix

		firstname.sendKeys(fname);

		middlename.sendKeys(mname);

		lastname.sendKeys(lname);

		Helper.selectDropdown(sfix, suffix);

		Helper.selectDropdown(gendr, gender);

		System.out.println(dob);

		// Helper.datePicker(datepicker, calendar, next, prev, daytoselect,dob); //date
		// removed

		datepicker.sendKeys(dob);

		datepicker.sendKeys(Keys.ENTER);

		datepicker.sendKeys(Keys.TAB);

		// System.out.println(calendar.getText());

		// calendar.click();
		nickname.sendKeys(nick);

		// Helper.waitElement(driver, formalsalutation);

		// Helper.waitElementByJavaScriptExecutor(driver,
		// formalsalutation).sendKeys(Keys.BACK_SPACE);
		Helper.selectDropdown(addressCategory, addrCategory);
		add1.sendKeys(address1);
		add2.sendKeys(address2);
		postalcode.sendKeys(zipvalue);
		city.sendKeys(cityName);
		Helper.selectDropdown(state, stateName);
		if (billingAddres.contains("Yes")) {

			JavascriptExecutor js = ((JavascriptExecutor) driver);

			js.executeScript("document.getElementById('r-SameAsBilling').click()");

		}
		email.sendKeys(emailaddress);
		// System.out.println(phonenumber);

		phone.click();
		phone.sendKeys(phonenumber1);
		Helper.selectDropdown(phonecommunication, phonecall);
		Helper.selectDropdown(mailsource, sendmail);
		Helper.selectDropdown(emailsource, sendemail);
		saveButton.click();
		
		


	}
	
	public void duplicateCheck() {
	
		
			if(Helper.isWebElementDisplayed(driver, duplicateContact, 60)) {
				System.out.println("You are adding duplicate contact");
				cancelduplicate.click();
				logo.click();
			}else {
				//assertEquals(contactinfo.getText(), prefix+fname+mname+lname+suffix);
				System.out.println(contactinfo.getText()+" is created");
			}
		
			System.out.println("You are outside");


		
	}

}
