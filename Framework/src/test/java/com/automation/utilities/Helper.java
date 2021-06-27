package com.automation.utilities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.logging.FileHandler;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Helper {
	
	
	//public static WebDriver driver;
	
	
	public static String captureScreenshot(WebDriver driver) {
		
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		String screenshotpath = System.getProperty("user.dir")+"./Screenshots/"+ getCurrentDateTime()+".png"; //This variable is created to attach screenshot to report
		
		try {
			//org.openqa.selenium.io.FileHandler.copy(src, new File("./Screenshots/"+ getCurrentDateTime()+".png"));
			org.openqa.selenium.io.FileHandler.copy(src, new File(screenshotpath));
		} catch (IOException e) {
			System.out.println("Unable to capture screenshot"+e.getMessage());
		}
		
		return screenshotpath;
	}
	
	public void handleFrames() {
		
	}
	
	public void handleAlert() {
		
	}
	
	public static String getCurrentDateTime() {
		DateFormat customformate = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		
		Date currentDate = new Date();
		
		return customformate.format(currentDate);
		
	}
	
	public static WebElement waitElement(WebDriver driver, WebElement element) {
		
		//This method should be used for explicit wait
		
		System.out.println(element);
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
	
		wait.until(ExpectedConditions.visibilityOf(element));
		
		//wait.until(ExpectedConditions.
		
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
		
		return element;
	}
	
	public static WebElement selectByActionClass(WebDriver driver, WebElement element) {
		
		//This method should be used to select option using action class.
		
		Actions action = new Actions(driver);
		
		action.moveToElement(element).click().build().perform();
		
		return element;
	}
	
	public static WebElement waitElementByJavaScriptExecutor(WebDriver driver, WebElement element) {
		
		//This method should be used for javascript executor
		
		System.out.println("Welcome to javascript executor");
		
		System.out.println(element);
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		
		wait.until(ExpectedConditions.visibilityOf(element)); 
		
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
		js.executeScript("arguments[0].click();", element);
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath(billingAddrCheckbox)));
		
		return element;
	}
	
	public static WebElement waitElementByJavaScriptExecutorScroll(WebDriver driver, WebElement element) {
		
		//This method should be used for javascript executor
		
		System.out.println("scroll Test");
		
		System.out.println(element);
		
		WebDriverWait wait = new WebDriverWait(driver, 3);
		
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		
		js.executeScript("arguments[0].scrollIntoView()", element);
		
		wait.until(ExpectedConditions.visibilityOf(element));
		
		//wait.until(ExpectedConditions.elementToBeClickable(By.))
		
		return element;
	}
	
	public static Object selectDropdown(WebElement element, String optiontoselect) {
		
		System.out.println(optiontoselect);
		
		Select dropdown = new Select(element);
		
		dropdown.selectByVisibleText(optiontoselect);
		
		return null;
	}
	
	public static Object selectByOption(WebElement element, String optiontoselect) {
		
		System.out.println(optiontoselect);
		
		Select dropdown = new Select(element);
		
		dropdown.selectByValue(optiontoselect);
		
		return null;
	}
	public static Object selectByIndex(WebElement element, String optiontoselect) {
		
		System.out.println(optiontoselect);
		
		Select dropdown = new Select(element);
		
		dropdown.selectByIndex(7);
		
		return null;
	}
	
		public static boolean isWebElementDisplayed(WebDriver driver,WebElement element, int iTimeOutInSec) {
		
		FluentWait<WebDriver> waitDriver = new FluentWait<WebDriver>(driver);
		try {
		waitDriver.withMessage("Finding Element").pollingEvery(Duration.ofMillis(500))
		.withTimeout(Duration.ofSeconds(iTimeOutInSec)).ignoring(NoSuchElementException.class)
		.until(ExpectedConditions.visibilityOf(element));
	

		waitDriver.withTimeout(Duration.ofSeconds(30));
		return true;
		}catch(Exception e) {
		

		waitDriver.withTimeout(Duration.ofSeconds(30));
		return false;
		}
		}
		
		
		
	public static void datePicker(WebElement element, WebElement currentmonthyear, WebElement next, WebElement prev, WebElement daytoselect, String dob) {
		
		//element.click();
		
		//String datetosel =dob.replaceFirst(""dd-MM-yyyy"", "dd-MM-yyyy");
		
		
		String date = "01-12-2018";
		
		Date d = new Date();
		
		SimpleDateFormat sd = new SimpleDateFormat("dd-MM-yyyy");
		
		try {
			Date dateToSelected = sd.parse(date);
			System.out.println(d.compareTo(dateToSelected)); //This will determine date is smaller than current date
			String day = new SimpleDateFormat("dd").format(dateToSelected);
		    System.out.println(day);
			String month = new SimpleDateFormat("MMMM").format(dateToSelected);
			System.out.println(month);
			String year = new SimpleDateFormat("yyyy").format(dateToSelected);
			System.out.println(year);
			String monthYearToBeSelected = year+" "+month;
			System.out.println("month-year-to-be-selected");
			System.out.println(monthYearToBeSelected);
			System.out.println("current month and year");
			System.out.println(currentmonthyear.getText());
			String currentmonth = currentmonthyear.getText();
			/*while(!monthYearToBeSelected.equals(currentmonth)) {
	if(d.compareTo(dateToSelected) == 1) {
		//This clause will be used for future date - We have to click on the next arrow
		prev.click();
		currentmonth = currentmonthyear.getText();
	}else if(d.compareTo(dateToSelected) ==-1) {
		//This clause will be used for past date - We have to click on the previous arrow
		//waitElement(driver, prev);
		try {
			Thread.sleep(30000);
			System.out.println("Click on previous");
			prev.click();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		}*/
			//daytoselect.click();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	}
		

}
