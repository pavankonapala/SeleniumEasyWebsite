package com.SeleniumEasy.Tests;

import static org.testng.Assert.assertTrue;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.SeleniumEasy.Pages.AjaxFormSubmit;
import com.SeleniumEasy.Pages.CheckBoxDemo;
import com.SeleniumEasy.Pages.InputFormSubmit;
import com.SeleniumEasy.Pages.JQueryDropDown;
import com.SeleniumEasy.Pages.PageLinks;
import com.SeleniumEasy.Pages.RadioButtonsDemo;
import com.SeleniumEasy.Pages.SelectDropDownList;
import com.SeleniumEasy.Pages.SimpleFormDemo;
import com.utilities.BrowserActivities;
import com.utilities.GetInput;
import com.utilities.HighlightElement;
import com.utilities.ScreenShot;



public class InputForms_TestCases 
{
	
	WebDriver driver;

	GetInput input=new GetInput();
	SimpleFormDemo forms=null;
	CheckBoxDemo checkBox=null;
	RadioButtonsDemo radio=null;
	SelectDropDownList dropDown=null;
	ScreenShot screenShot=new ScreenShot();
	InputFormSubmit inputForm=null;
	AjaxFormSubmit ajaxForm=null;
	JQueryDropDown drop=new JQueryDropDown();

	BrowserActivities ba=new BrowserActivities();
	
	@BeforeTest
	public void init()
	{
		driver=ba.launchURL(input.getFromText("Browser"), input.getFromText("URL"));
		forms=PageFactory.initElements(driver, SimpleFormDemo.class);
		checkBox=PageFactory.initElements(driver, CheckBoxDemo.class);
		radio=PageFactory.initElements(driver, RadioButtonsDemo.class);
		dropDown=PageFactory.initElements(driver, SelectDropDownList.class);
		inputForm=PageFactory.initElements(driver, InputFormSubmit.class);
		ajaxForm=PageFactory.initElements(driver,AjaxFormSubmit.class);
		
		driver.findElement(PageLinks.inputFormsLink).click();
	}
	
	@AfterTest
	public void cleanUp()
	{
		driver.quit();
	}
	
	@Test
	public void testCase_displayMessage()
	{
		String ipMsg=input.getTextFromExcel(1,1);	
		driver.findElement(PageLinks.simpleFormLink).click();
		forms.typeMessageIntoTextBox(ipMsg);
		forms.showMsg_Btn.click();
		String opMsg=forms.message_display.getText();
		assertTrue(ipMsg.equals(opMsg));
		screenShot.takeScreenShot(driver,"TC 01");
	}
	
	@Test 
	public void testCase_sumNumbers()
	{
		int var1=input.getNumberFromExcel(2, 1);
		int var2=input.getNumberFromExcel(2, 2);
		
		driver.findElement(PageLinks.simpleFormLink).click();
		forms.typeVariables(var1, var2);
		forms.getTotal_XPATH.click();
		int total=Integer.parseInt(forms.totalValue_display.getText());
		assertTrue(total==var1+var2);
		screenShot.takeScreenShot(driver,"TC 02");
	}
	
	@Test 
	public void testCase_SingleCheckBox()
	{
		driver.findElement(PageLinks.checkBoxLink).click();
		checkBox.singleCheckBox.click();
		String checkBoxMsg=checkBox.singleCheckBoxMsg.getText();
		assertTrue(checkBoxMsg!="");	
		screenShot.takeScreenShot(driver,"TC 03");
	}
	
	@Test 
	public void testCase_multipleCheckBox() throws InterruptedException
	{
		HighlightElement highlight=new HighlightElement();
		WebElement checkAll=checkBox.checkAll_Btn;
		String optionData=input.getTextFromExcel(4,1);
		driver.findElement(PageLinks.checkBoxLink).click();
		assertTrue(checkAll.getAttribute("value").equalsIgnoreCase("Check All"));
		highlight.highlightElement(driver, checkAll);
		checkAll.click();
		assertTrue(checkBox.option1_ChkBox.isSelected());
		assertTrue(checkBox.option2_ChkBox.isSelected());
		assertTrue(checkBox.option3_ChkBox.isSelected());
		assertTrue(checkBox.option4_ChkBox.isSelected());
		assertTrue(checkAll.getAttribute("value").equalsIgnoreCase("Uncheck All"));
		highlight.highlightElement(driver, checkAll);
		
		if(optionData.equals("Option 1"))
		{
			checkBox.option1_ChkBox.click();
		}
		else if(optionData.equals("Option 2"))
		{
			checkBox.option2_ChkBox.click();
		}
		else if(optionData.equals("Option 3"))
		{
			checkBox.option3_ChkBox.click();
		}
		else if(optionData.equals("Option 4"))
		{
			checkBox.option4_ChkBox.click();
		}
		
		assertTrue(checkAll.getAttribute("value").equalsIgnoreCase("Check All"));
		highlight.highlightElement(driver, checkAll);
		screenShot.takeScreenShot(driver,"TC 04");
				
	}
	
	@Test
	public void testcase_singleRadioButton()
	{
		String gender=input.getTextFromExcel(5,1);
		driver.findElement(PageLinks.radioBtnLink).click();
		
		if(gender.equals("Male"))
		{
			radio.maleRadioBtn.click();
		}
		else if (gender.equals("Female"))
		{
			radio.femaleRadioBtn.click();
		}
		
		radio.getChecked_Button.click();
		String output=radio.getCheckedMessage.getText();
		assertTrue(output.equals("Radio button '"+gender+"' is checked"));
		screenShot.takeScreenShot(driver,"TC 05");
	}
	
	@Test
	public void testcase_groupRadioButtons()
	{
		String gender=input.getTextFromExcel(6, 1);
		String age=input.getTextFromExcel(6,2);
		
		driver.findElement(PageLinks.radioBtnLink).click();
		
		if(gender.equals("Male"))
		{
			radio.maleBtnGroup.click();			
		}
		else if (gender.equals("Female"))
		{
			radio.femaleBtnGroup.click();
		}
		
		if(age.equals("0 to 5"))
		{
			radio.age1Btn.click();
		}
		else if (age.equals("5 to 15"))
		{
			radio.age2Btn.click();
		}
		else if (age.equals("15 to 50"))
		{
			radio.age3Btn.click();
		}
		
		radio.getValuesBtn.click();
		String output=radio.getValuesMsg.getText();
		assertTrue(output.equals("Sex : "+gender+"\nAge group: "+age.replace("to", "-")));
		screenShot.takeScreenShot(driver,"TC 06");
	}
	
	@Test
	public void testcase_singleDropDown()
	{
		String day=input.getTextFromExcel(7, 1);
		
		driver.findElement(PageLinks.dropdownLink).click();;
		Select selectDay=new Select(dropDown.singleDropDown);
		selectDay.selectByVisibleText(day);
		String display=dropDown.message.getText();
		
		assertTrue(display.equals("Day selected :- "+day));
		screenShot.takeScreenShot(driver,"TC 07");		
	}
	
	@Test
	public void testcase_multiSelect() throws InterruptedException
	{
		String city1=input.getTextFromExcel(8, 1);
		String city2=input.getTextFromExcel(8, 2);
		String city3=input.getTextFromExcel(8, 3);
		String message;
		
		driver.findElement(PageLinks.dropdownLink).click();
		Select selectCity=new Select(dropDown.multiSelect);
		
		selectCity.selectByVisibleText(city1);
		selectCity.selectByVisibleText(city2);
		selectCity.selectByVisibleText(city3);
		
		Thread.sleep(500);
		dropDown.firstSelectedBtn.click();
		message=dropDown.multiSelectMessage.getText();
		System.out.println(message);
		System.out.println("First selected option is : "+ city1);
		//assertTrue(message.equals("First selected option is : "+ city1));
		screenShot.takeScreenShot(driver,"TC 08_1");
		
		dropDown.getAllSelectedBtn.click();
		message=dropDown.multiSelectMessage.getText();
		System.out.println(message);
		System.out.println("Options selected are : "+city1+","+city2+","+city3);
		//assertTrue(message.equals("Options selected are : "+city1+","+city2+","+city3));
		screenShot.takeScreenShot(driver, "TC 08_2");	
	}
	
	@Test
	public void testcase_inputFormSubmit()
	{
		String firstName=input.getTextFromExcel(9, 1);
		String lastName=input.getTextFromExcel(9, 2);
		String email=input.getTextFromExcel(9, 3);
		String phone=Integer.toString(input.getNumberFromExcel(9, 4));
		String address=input.getTextFromExcel(9, 5);
		String city=input.getTextFromExcel(9, 6);
		String state=input.getTextFromExcel(9, 7);
		String zip=Integer.toString(input.getNumberFromExcel(9, 8));
		String website=input.getTextFromExcel(9, 9);
		String hosting=input.getTextFromExcel(9, 10);
		String projdesc=input.getTextFromExcel(9, 11);
		
		driver.findElement(PageLinks.inputFormSubmitLink).click();
		inputForm.firstName.sendKeys(firstName);
		inputForm.lastName.sendKeys(lastName);
		inputForm.email.sendKeys(email);
		inputForm.phone.sendKeys(phone);
		inputForm.address.sendKeys(address);
		inputForm.city.sendKeys(city);
		Select stateList=new Select(inputForm.state);
		stateList.selectByVisibleText(state);
		inputForm.zip.sendKeys(zip);
		inputForm.website.sendKeys(website);
		if(hosting.equals("Yes"))
		{
			inputForm.hostingYes.click();
		}
		else if(hosting.equals("No"))
		{
			inputForm.hostingNo.click();
		}
		inputForm.projectDesc.sendKeys(projdesc);
		inputForm.submitBtn.submit();				
	}
	
	@Test
	public void testcase_ajaxFormSubmit() throws InterruptedException
	{
		String name=input.getTextFromExcel(10, 1);
		String desc=input.getTextFromExcel(10, 2);
		
		driver.findElement(PageLinks.ajaxFormSubmitLink).click();
		ajaxForm.name.sendKeys(name);
		ajaxForm.description.sendKeys(desc);
		ajaxForm.submit.submit();

		screenShot.takeScreenShot(driver, "TC 10");		
	}
	
	@Test
	public void testcase_JQueryDropDown()
	{

		String ipCountry=input.getTextFromExcel(11, 1);
		driver.findElement(PageLinks.jQueryDropDownLink).click();
		driver.findElement(By.xpath("//span[@aria-labelledby='select2-country-container']")).click();
		drop.getList(driver, ipCountry).click();
		screenShot.takeScreenShot(driver, "TC 11");		
	}
	
	@Test
	public void testcase_JQueryDropDownMultiple()
	{
		String state1=input.getTextFromExcel(12, 1);
		String state2=input.getTextFromExcel(12, 2);
		
		driver.findElement(PageLinks.jQueryDropDownLink).click();
		driver.findElement(By.xpath("//input[@class='select2-search__field']")).click();
		drop.getList(driver, state1).click();
		driver.findElement(By.xpath("//input[@class='select2-search__field']")).click();
		drop.getList(driver, state2).click();
		screenShot.takeScreenShot(driver, "TC 12");
	}
	
	@Test
	public void testCase_JQueryDropDownWithDisabled()
	{
		
		String ip1=input.getTextFromExcel(13, 1);
		String ip2=input.getTextFromExcel(13, 2);
		
		driver.findElement(PageLinks.jQueryDropDownLink).click();
		driver.findElement(By.xpath("//span[@class='select2-selection__rendered'][text()='American Samoa']")).click();
		if(drop.getList(driver, ip1).isEnabled())
		{
			drop.getList(driver, ip1).click();
		}
		driver.findElement(By.xpath("//span[@class='select2-selection__rendered'][text()='American Samoa']")).click();
		if(drop.getList(driver, ip2).isEnabled())
		{
			drop.getList(driver, ip2).click();
		}
		screenShot.takeScreenShot(driver, "TC 13");
	}
	
	@Test
	public void testCase_JQueryDropDownCategory()
	{
		String file=input.getTextFromExcel(14, 1);
		driver.findElement(PageLinks.jQueryDropDownLink).click();
		Select select=new Select(driver.findElement(drop.selectFile));
		select.selectByVisibleText(file);
		screenShot.takeScreenShot(driver, "TC 14");
	}
}
