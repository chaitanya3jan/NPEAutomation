package com.automation.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.automation.utilities.Helper;

public class Dashboard extends Base {
	
	WebDriver driver;
	
	public Dashboard(WebDriver ddriver) {
		
		this.driver= ddriver;
		
	}
	
	@FindBy(xpath="//span[@class='nav-icon-plus-circle']") WebElement quickadd;
	@FindBy(linkText="Add Individual") WebElement addIndividual;
	@FindBy(name="FirstName") WebElement fname;
	@FindBy(name="LastName") WebElement lname;
	@FindBy(xpath="//button[contains(text(),'Save and Close')]") WebElement saveclose;
	@FindBy(css="#quickContactSearch") WebElement quicksearch;
	@FindBy(xpath="//div[@class='list-section']/div[1]/a/span[1]") WebElement firstcontact;
	
	public void addIndividaulBySaveClose(String firstname, String lastname) {
		quickadd.click();
		addIndividual.click();
	
		fname.sendKeys(firstname);
		lname.sendKeys(lastname);
		
		//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", saveclose);
			
		//saveclose.click();
		
		//waitElement(saveclose).click();
		
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
	
	

}
