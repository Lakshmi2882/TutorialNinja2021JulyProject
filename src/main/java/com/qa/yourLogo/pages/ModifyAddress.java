package com.qa.yourLogo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.yourLogo.Utils.ElementUtil;
import com.qa.yourLogo.base.Basepage;

public class ModifyAddress extends Basepage {
	
	private WebDriver driver;
	private ElementUtil elementutil;
	private By MyaccountButton=By.linkText("New Address");
	private By firstname1=By.id("input-firstname");
	private By lastname=By.name("lastname");
	private By company1=By.name("company");
	private By Address1=By.name("address_1");
	private By Address2=By.name("address_2");
	private By city1=By.name("city");
	private By postcode1=By.name("postcode");
	private By Country=By.xpath("//select[@name='country_id']");
	private By Region=By.id("input-zone");
	private By DefaultAddressyes=By.xpath("//input[@type='radio' and @value='1']");
	private By DefaultAddressno=By.xpath("//input[@type='radio' and @value='0']");
	private By continueButton=By.xpath("//input[@value='Continue']");
	private By EditAddress=By.linkText("Edit");
	private By DeleteAddress=By.linkText("Delete");
	private By messageinEditAddresspage=By.xpath("//div //h2");
	private By message=By.xpath("//div[contains(text(),'Your address has been successfully deleted')]");
	private By newAddress=By.linkText("New Address");
	
 public ModifyAddress(WebDriver driver)
 {
	 this.driver=driver;
	 elementutil=new ElementUtil(driver);	 
 }
 public String verifyTitle()
 {
	System.out.println("ModifyAddress Title is:" + driver.getTitle());
	return driver.getTitle();
 }
 public boolean verifyMyaddressButton()
 {
	return  elementutil.doIsDisplayed(MyaccountButton);
 }
 public  void AddAddress(String FirstName,String LastName,String company,String Address1,String Address2,String City,String Postcode,String Country1,String Region1,String DefaultAddress)
 { elementutil.doClick(MyaccountButton);
	 elementutil.doSendKeys(firstname1, FirstName);
	 elementutil.doSendKeys(lastname, LastName);
	 elementutil.doSendKeys(company1, company);
	 elementutil.doSendKeys(this.Address1,Address1);
	 elementutil.doSendKeys(this.Address2,Address2);
	 elementutil.doSendKeys(city1,City);
	 elementutil.doSendKeys(postcode1, Postcode);
     elementutil.selectDropDown(Country, Country1);
	elementutil.selectDropDown(Region, Region1);
	if(DefaultAddress.equals("yes"))
	{
		elementutil.doClick(DefaultAddressyes);
	}
	else
	{
		elementutil.doClick(DefaultAddressno);
	}
 elementutil.doClick(continueButton);
 }
 public String Editdetails()
 {
	 elementutil.doClick(EditAddress);
String text= elementutil.getText(messageinEditAddresspage);
System.out.println(text);
	 return text;
 }
 public String DeleteAddress()
 {
	 elementutil.doClick(DeleteAddress);
	 String Text=elementutil.getText(message);
	 System.out.println(Text);
	 return Text;
	 
 }
 public ModifyAddress Doclick()
 {
	 elementutil.doClick(newAddress);
	 return new ModifyAddress(driver);
	 
 }
 
}
