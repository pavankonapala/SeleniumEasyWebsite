package com.SeleniumEasy.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SimpleFormDemo 
{
	WebDriver driver;
	
	public SimpleFormDemo(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	@FindBy(how=How.ID,using="user-message") WebElement enterMsg_TextBox;
	public @FindBy(how=How.XPATH,using="//button[@onclick='showInput();']") WebElement showMsg_Btn;
	public @FindBy(how=How.ID,using="display") WebElement message_display;
	
	@FindBy(how=How.ID,using="sum1") WebElement enterA_TextBox;
	@FindBy(how=How.ID,using="sum2") WebElement enterB_TextBox;
	public @FindBy(how=How.XPATH,using="//button[text()='Get Total']") WebElement getTotal_XPATH;
	public @FindBy(how=How.ID,using="displayvalue") WebElement totalValue_display;
	
	
	public void typeMessageIntoTextBox(String msg)
	{
		String message=msg;		
		enterMsg_TextBox.sendKeys(message);
	}
	
	public void typeVariables(int var1,int var2)
	{
		int variable1=var1;
		int variable2=var2;
		
		enterA_TextBox.sendKeys(Integer.toString(variable1));
		enterB_TextBox.sendKeys(Integer.toString(variable2));
		
	}
}
