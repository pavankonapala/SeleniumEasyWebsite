package com.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserActivities 
{
	WebDriver driver;
	
	public WebDriver launchURL(String browser,String url)
	{
		String browser1=browser;
		String url1=url;

		if(browser1.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", FolderPaths.driverPath+"chromedriver.exe");
			driver=new ChromeDriver();			
		}
		
		driver.get(url1);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		return driver;

	}
	
	
}
