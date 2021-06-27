package com.automation.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.automation.utilities.Helper;

public class Dashboard extends Base {

	WebDriver driver;

	public Dashboard(WebDriver ddriver) {

		this.driver = ddriver;

	}

	// xpath for add individual
	@FindBy(xpath = "//span[@class='nav-icon-plus-circle']")
	WebElement quickadd;
	@FindBy(linkText = "Add Individual")
	WebElement addIndividual;
	@FindBy(name = "FirstName")
	WebElement fname;
	@FindBy(name = "LastName")
	WebElement lname;
	@FindBy(xpath = "//button[contains(text(),'Save and Close')]")
	WebElement saveclose;
	@FindBy(css = "#quickContactSearch")
	WebElement quicksearch;
	@FindBy(xpath = "//div[@class='list-section']/div[1]/a/span[1]")
	WebElement firstcontact;
	// xpath for add organization
	@FindBy(xpath = "//*[@id=\"addNewNav\"]/div/ul/li[2]/a")
	WebElement addorganization;
	@FindBy(xpath = "//span/input[@id='organizationselector']")
	WebElement organame;
	@FindBy(xpath = "//input[@data-ng-model='Organization.Emails[0].Name']")
	WebElement orgemailaddress;
	@FindBy(xpath = "//input[@name='cPhone']")
	WebElement orgphone;
	@FindBy(xpath = "//input[@ng-model='Organization.TempEncryptedId']")
	WebElement orgid;
	@FindBy(xpath = "//input[@name='Url']")
	WebElement orgwebsite;
	@FindBy(xpath = "//input[@data-ng-model='Organization.NoOfEmployees']")
	WebElement orgNumberofEmployee;
	@FindBy(xpath = "//input[@name='AddressLine1']")
	WebElement orgAddressL1;
	@FindBy(xpath = "//*[@id=\"spinnerAddressundefined\"]/div[3]/fieldset/div/div/div[3]/span[2]/input")
	WebElement orgAddressL2;
	@FindBy(xpath = "//input[@name='Zip']")
	WebElement orgZip;
	@FindBy(xpath = "//select[@id='City']")
	WebElement orgCity;
	@FindBy(xpath = "//input[@name='County']")
	WebElement orgCounty;
	@FindBy(xpath = "//select[@id='State']")
	WebElement orgState;
	@FindBy(xpath = "//select[@id='Country']")
	WebElement orgCountry;
	@FindBy(xpath = "//button[contains(text(),'Save and Close')]")
	WebElement saveCloseOrg;
	@FindBy(xpath = "//select[@id='City']/option")
	WebElement orgCityOption;
	@FindBy(xpath = "//div[@class='list-section']/div[1]")
	WebElement selectContact;
	@FindBy(xpath = "//button[contains(text(),'Quick Actions')]")
	WebElement quickActions;
	@FindBy(xpath = "//*[@id='spnContactViewLayout']/div[3]/div[1]/div[1]/div[5]/div/div[2]")
	WebElement quickActionPopup;
	@FindBy(xpath = "//label[contains(text(),'Delete Contact')]")
	WebElement deleteContactButton;

	public void addIndividaulBySaveClose(String firstname, String lastname) {
		quickadd.click();
		addIndividual.click();

		fname.sendKeys(firstname);
		lname.sendKeys(lastname);

		// ((JavascriptExecutor)
		// driver).executeScript("arguments[0].scrollIntoView(true);", saveclose);

		// saveclose.click();

		// waitElement(saveclose).click();

		Helper.waitElement(driver, saveclose).click();

		quicksearch.sendKeys(firstname);
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		quicksearch.click();

		Assert.assertSame(false, firstcontact.getText().contains(firstname));

	}

	public void addOrganization(String orgname, String orgemail, String phone, String taxid, String url,
			String numberofemployee, String addressline1, String addressline2, String zip, String city, String county,
			String state, String country) throws InterruptedException {
		// TODO Auto-generated method stub
		System.out.println("Add Organization");
		quickadd.click();
		addorganization.click();
		organame.sendKeys(orgname);
		orgemailaddress.sendKeys(orgemail);
		orgphone.click();
		orgphone.sendKeys(phone);
		orgid.sendKeys(taxid);
		orgwebsite.sendKeys(url);
		orgNumberofEmployee.sendKeys(numberofemployee);
		orgAddressL1.sendKeys(addressline1);
		orgAddressL2.sendKeys(addressline2);
		orgZip.sendKeys(zip);
		// Thread.sleep(30000);
		// Helper.waitElementByJavaScriptExecutor(driver, orgCity);
		// Helper.waitElement(driver, orgCity);
		orgCity.click();
		Helper.selectDropdown(orgCity, city);
		orgCounty.sendKeys(county);
		saveCloseOrg.click();

	}

	public void deleteIndividaul(String deleteContact, String stringData2) {

		quicksearch.sendKeys(deleteContact);
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		quicksearch.click();
		selectContact.click();
		quickActions.click();
		if (Helper.isWebElementDisplayed(driver, quickActionPopup, 30)) {
			deleteContactButton.click();
			driver.switchTo().alert().accept();
		}

	}

	@FindBy(xpath = "//a[contains(text(),'Add In-Kind Gift')]")
	WebElement addInKindGift;
	@FindBy(xpath = "//input[@id='contactselectorContact']")
	WebElement inKinddonorName;
	@FindBy(xpath = "//select[@name='Fund']")
	WebElement Fund;
	@FindBy(xpath = "//*[@id=\"spnGift\"]/div[3]/div[1]/div/div/div[1]/span[2]/contactselector/div/ng-form/span/ul/li[1]/a")
	WebElement selectDonor;
	@FindBy(xpath = "//select[@name='Source']")
	WebElement sourceName;
	@FindBy(xpath = "//Input[@name='Amount']")
	WebElement inKindvalue;
	@FindBy(xpath = "//Input[@name='Description']")
	WebElement inKindDescription;
	@FindBy(xpath = "//*[@id='GiftMemo']")
	WebElement giftMemo;

	@FindBy(xpath = "//div[@class='modal-footer']/button[3]")
	WebElement save;

	public void AddInKindFund(String contactName, String fundname, String source, double value, String itemDescription,
			String giftMessage) {

		quickadd.click();
		addInKindGift.click();
		inKinddonorName.sendKeys(contactName);
		// Helper.selectDropdown(, optiontoselect)
		selectDonor.click();
		Fund.sendKeys(fundname);
		Helper.selectDropdown(sourceName, source);
		inKindvalue.clear();
		inKindvalue.sendKeys(Keys.ENTER);
		System.out.println(value);
		String s = String.valueOf(value);
		inKindvalue.sendKeys(s);
		inKindDescription.sendKeys(itemDescription);
		giftMemo.sendKeys(giftMessage);
		save.click();

	}

	@FindBy(xpath = "//*[@id=\"addNewNav\"]/div/ul/li[5]/a")
	WebElement addGift;
	@FindBy(xpath = "//*[@id=\"contactselectorContact\"]")
	WebElement donorName;
	@FindBy(xpath = "//*[@id=\"spnGift\"]/div[4]/div[1]/div/div/div[1]/span[2]/contactselector/div/ng-form/span/ul/li[1]/a")
	WebElement donorSelect;
	@FindBy(xpath = "//*[@id='spnGift']/div[4]/div[1]/div/div/div[3]/span[2]/select")
	WebElement fundNameDropdown;
/*	@FindBy(xpath = "//*[@id=\"spnGift\"]/div[4]/div[1]/div/div/div[3]/span[2]/select/option")
	WebElement fundList;*/
	@FindBy(xpath = "//select[@name='Source']")
	WebElement donorSourceName;
	@FindBy(xpath = "*[@id=\"spnGift\"]/div[4]/div[1]/div/div/div[5]/span[2]/select-program/select")
	WebElement programName;
	@FindBy(xpath = "//div/span/select-campaign")
	WebElement campaignName;
	@FindBy(xpath = "//select[@name='PaymentMethod']")
	WebElement paymentMethod;
	@FindBy(xpath = "//select[@name='PaymentDate']")
	WebElement paymentDate;
	@FindBy(xpath = "//input[@name='ReceiptNo']")
	WebElement receiptNo;
	@FindBy(xpath = "//input[@name='Amount']")
	WebElement donationAmount;
	@FindBy(xpath = "//div[@class='modal-footer']/button[1]")
	WebElement saveFund;
	@FindBy(xpath = "//*[@id=\"spnGift\"]/div[5]/div[1]/div")
	WebElement paymentHistory;
	
	@FindBy(xpath="//*[@id=\"mainContainer\"]/div[2]/div/div/div/ul/li/text()")
	WebElement messageContainer;

	public void AddFund(String contact, String fund, String source, String program, String campaign, String paymenttype,
			String date, String reference, String amount) {
		System.out.println("Welcome for gift");
		// TODO Auto-generated method stub
		quickadd.click();
		addGift.click();
		donorName.sendKeys(contact);
		donorSelect.click();
		
		
		System.out.println("Visible");
		
		fundNameDropdown.click();
		
		Helper.waitElement(driver, fundNameDropdown);
		
		Helper.selectDropdown(fundNameDropdown, fund);
		
		
		Helper.selectDropdown(sourceName, source); 
		
		driver.findElement(By.xpath(amount)).click();
		
	
		Helper.selectDropdown(paymentMethod, paymenttype);
		
		//paymentDate.sendKeys(date);
		
		receiptNo.sendKeys(reference); 
		

		saveFund.click();
		
		if(paymentHistory.isDisplayed()) {
			System.out.println("Gift recorded");
		}else {
			
			System.out.println(messageContainer.getText());
		}
		
		
	}
	
	@FindBy(xpath="//*[@id=\"addNewNav\"]/div/ul/li[6]/a")
	WebElement AddGiftforAppeal;
	
	

	public void AddFundforAppeal(String donor, String fund, String source) {
		// TODO Auto-generated method stub
		System.out.println("Appeal for Donation");
		quickadd.click();
		AddGiftforAppeal.click();
		donorName.sendKeys(donor);
		donorSelect.click();
		fundNameDropdown.click();		
		Helper.waitElement(driver, fundNameDropdown);		
		Helper.selectDropdown(fundNameDropdown, fund);
		Helper.selectDropdown(sourceName, source); 
		
		
		
		
	}

}
