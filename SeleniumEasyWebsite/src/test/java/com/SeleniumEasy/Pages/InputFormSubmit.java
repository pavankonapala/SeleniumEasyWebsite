package com.SeleniumEasy.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class InputFormSubmit 
{

	public @FindBy(how=How.NAME,using="first_name") WebElement firstName;
	public @FindBy(how=How.NAME,using="last_name") WebElement lastName;
	public @FindBy(how=How.NAME,using="email") WebElement email;
	public @FindBy(how=How.NAME,using="phone") WebElement phone;
	public @FindBy(how=How.NAME,using="address") WebElement address;
	public @FindBy(how=How.NAME,using="city") WebElement city;
	public @FindBy(how=How.NAME,using="state") WebElement state;
	public @FindBy(how=How.NAME,using="zip") WebElement zip;
	public @FindBy(how=How.NAME,using="website") WebElement website;
	public @FindBy(how=How.XPATH,using="//input[@name='hosting'][@value='yes']") WebElement hostingYes;
	public @FindBy(how=How.XPATH,using="//input[@name='hosting'][@value='no']") WebElement hostingNo;
	public @FindBy(how=How.NAME,using="comment") WebElement projectDesc;
	public @FindBy(how=How.XPATH,using="//button[@type='submit']") WebElement submitBtn;
}
