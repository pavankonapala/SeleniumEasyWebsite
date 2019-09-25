/**
 * 
 */
package com.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author KSP
 *
 */
public class HighlightElement 
{
	
	WebDriver driver;
	public void highlightElement(WebDriver driver,WebElement element) throws InterruptedException
	{
		this.driver=driver;
		WebElement ele=element;
		String originalStyle=ele.getAttribute("style");
		JavascriptExecutor js=(JavascriptExecutor) driver;
		for (int i=0;i<2;i++)
		{
			js.executeScript("arguments[0].setAttribute('style','border: 2px solid yellow; width: 10%');", ele);
			Thread.sleep(500);
			js.executeScript("arguments[0].setAttribute('style','"+originalStyle+"');", ele);
			Thread.sleep(500);		
			
		}
	}
}
