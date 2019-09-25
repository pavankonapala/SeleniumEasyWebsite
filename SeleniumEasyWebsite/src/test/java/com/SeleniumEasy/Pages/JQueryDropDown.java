/**
 * 
 */
package com.SeleniumEasy.Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author KSP
 *
 */
public class JQueryDropDown 
{
	String var;
	WebDriver driver;
	WebElement ele;
	
	public WebElement getList(WebDriver driver,String country)
	{
		this.driver=driver;
		var=country;
		
		ele= driver.findElement(By.xpath("//li[@class='select2-results__option'][text()='"+var+"']"));
		return ele;
	}
	
	public By selectFile =By.id("files");
	
}
