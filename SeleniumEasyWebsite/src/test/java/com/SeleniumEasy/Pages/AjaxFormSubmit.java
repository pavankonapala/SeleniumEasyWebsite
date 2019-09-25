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
public class AjaxFormSubmit 
{
	
	public @FindBy(how=How.ID,using="title") WebElement name;
	public @FindBy(how=How.ID,using="description") WebElement description;
	public @FindBy(how=How.ID,using="btn-submit") WebElement submit;
	
	public @FindBy(how=How.ID,using="submit-control") WebElement submissionMessage;
	
}
