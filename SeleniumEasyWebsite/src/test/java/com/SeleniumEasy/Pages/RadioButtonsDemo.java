package com.SeleniumEasy.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RadioButtonsDemo 
{

	
	public @FindBy(how=How.XPATH,using="//input[@name='optradio' and @value='Male']") WebElement maleRadioBtn;
	public @FindBy(how=How.XPATH,using="//input[@name='optradio' and @value='Female']") WebElement femaleRadioBtn;
	public @FindBy(how=How.ID,using="buttoncheck") WebElement getChecked_Button;
	public @FindBy(how=How.XPATH,using="//button[@id='buttoncheck']//following::p[1]") WebElement getCheckedMessage;
	
	public @FindBy(how=How.XPATH,using="//input[@name='gender' and @value='Male']") WebElement maleBtnGroup;
	public @FindBy(how=How.XPATH,using="//input[@name='gender' and @value='Female']") WebElement femaleBtnGroup;
	public @FindBy(how=How.XPATH,using="//input[@name='ageGroup' and @value='0 - 5']") WebElement age1Btn;
	public @FindBy(how=How.XPATH,using="//input[@name='ageGroup' and @value='5 - 15']") WebElement age2Btn;
	public @FindBy(how=How.XPATH,using="//input[@name='ageGroup' and @value='15 - 50']") WebElement age3Btn;
	public @FindBy(how=How.XPATH,using="//button[text()='Get values']") WebElement getValuesBtn;
	public @FindBy(how=How.XPATH,using="//button[text()='Get values']//following::p") WebElement getValuesMsg;

}
