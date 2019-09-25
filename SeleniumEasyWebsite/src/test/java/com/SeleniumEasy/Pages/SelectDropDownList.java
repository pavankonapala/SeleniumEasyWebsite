/**
 * 
 */
package com.SeleniumEasy.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * @author KSP
 *
 */
public class SelectDropDownList 
{
	
	public @FindBy(how=How.ID,using="select-demo") WebElement singleDropDown;
	public @FindBy(how=How.XPATH,using="//p[@class='selected-value']") WebElement message;
	
	public @FindBy(how=How.ID,using="multi-select") WebElement multiSelect;
	public @FindBy(how=How.ID,using="printMe") WebElement firstSelectedBtn;
	public @FindBy(how=How.ID,using="printAll") WebElement getAllSelectedBtn;
	public @FindBy(how=How.XPATH,using="//p[@class='getall-selected']") WebElement multiSelectMessage;
	
	
}
