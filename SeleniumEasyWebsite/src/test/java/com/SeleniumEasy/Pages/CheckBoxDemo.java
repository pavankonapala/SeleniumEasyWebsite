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
public class CheckBoxDemo 
{	
	
	public @FindBy(how=How.ID,using="isAgeSelected") WebElement singleCheckBox;
	public @FindBy(how=How.ID,using="txtAge") WebElement singleCheckBoxMsg;
	
	public @FindBy(how=How.XPATH,using="//label[text()='Option 1']//input[@class='cb1-element']") WebElement option1_ChkBox;
	public @FindBy(how=How.XPATH,using="//label[text()='Option 2']//input[@class='cb1-element']") WebElement option2_ChkBox;
	public @FindBy(how=How.XPATH,using="//label[text()='Option 3']//input[@class='cb1-element']") WebElement option3_ChkBox;
	public @FindBy(how=How.XPATH,using="//label[text()='Option 4']//input[@class='cb1-element']") WebElement option4_ChkBox;
	public @FindBy(how=How.ID,using="check1") WebElement checkAll_Btn;
	
	
}
