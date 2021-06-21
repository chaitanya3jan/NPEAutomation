package com.automation.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {
	
	Properties pro;
	
	public ConfigDataProvider() {
		
		File src = new File("./Config/Config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			
			pro = new Properties();
			
			pro.load(fis);
			
			//System.out.println(pro.get("browser"));
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Unable to load config file"+e.getMessage());
		}
	
		
	}
	
	
	public String getBrowser() {
		
		String browser = pro.getProperty("Browser");
		
		System.out.println("get Browser"+browser);
		
		return browser;
	}
	
	public String getTestURL() {
		
		String url = pro.getProperty("TestURL");
			
		return url;
	}

}
