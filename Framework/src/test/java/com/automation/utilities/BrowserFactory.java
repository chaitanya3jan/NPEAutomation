package com.automation.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class BrowserFactory {
	
	//public WebDriver driver;
	
	public static WebDriver startApp(WebDriver driver, String browserName, String url) {
		
		System.out.println("==="+browserName);
	
		if(browserName.equalsIgnoreCase("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
						
			driver = new ChromeDriver();
			
			
		}else if(browserName.equals("Firefox")) {
			
			System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
			
			driver = new FirefoxDriver();
			
		}else if(browserName.equals("IE")) {
			
			
			
		}else {
			System.out.println("Sorry, we are not supporting this browser");
		}
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
		driver.get(url);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		return driver;
		
	}
	
	public static void quitBrowser(WebDriver driver) {
		
		driver.quit();
		
	}

}
