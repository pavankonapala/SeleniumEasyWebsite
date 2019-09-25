package com.utilities;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenShot 
{

	WebDriver driver;
	String name;
	public void takeScreenShot(WebDriver driver,String name)
	{
		this.driver=driver;
		this.name=name;
		
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest=new File(FolderPaths.screensPath+"//"+name+"_"+".png");
		try 
		{
			FileHandler.copy(src, dest);
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}
