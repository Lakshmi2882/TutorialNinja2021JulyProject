package com.qa.yourLogo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.yourLogo.Utils.ElementUtil;
import com.qa.yourLogo.base.Basepage;

public class MyAccount extends Basepage {
	private WebDriver driver;
	private ElementUtil elementutil;
	private By FirstName=By.name("firstname");
	private By LastName=By.name("lastname");
	private By EmailId=By.name("email");
	private By Telephone=By.name("telephone");
	private By continueb=By.xpath("//input[@type='submit']");
	private By backb=By.linkText("Back");
	public MyAccount(WebDriver driver)
	{
		this.driver=driver;
		elementutil=new ElementUtil(driver);
	}
	public String verifyTitle()
	{ System.out.println("Title is :" + driver.getTitle());
	return driver.getTitle();
	}
 public Accountpage editInfoForm(String FirstName,String LastName,String Email,String Telephone)
 { elementutil.clearElement(this.FirstName);
	elementutil.doSendKeys(this.FirstName,FirstName); 
	elementutil.clearElement(this.LastName);
	elementutil.doSendKeys(this.LastName,LastName);
	elementutil.clearElement(EmailId);
	elementutil.doSendKeys(EmailId,Email);
	elementutil.clearElement(this.Telephone);
	elementutil.doSendKeys(this.Telephone, Telephone);
	elementutil.doClick(continueb);
	return new Accountpage(driver);
 }
	
	
 public Accountpage editInfoFormB(String FirstName,String LastName,String Email,String Telephone)
 { elementutil.clearElement(this.FirstName);
	elementutil.doSendKeys(this.FirstName,FirstName);
	elementutil.clearElement(this.LastName);
	elementutil.doSendKeys(this.LastName,LastName);
	elementutil.clearElement(EmailId);
	elementutil.doSendKeys(EmailId,Email);
	elementutil.clearElement(this.Telephone);
	elementutil.doSendKeys(this.Telephone, Telephone);
	elementutil.doClick(backb);
	return new Accountpage(driver);
 }
	
	
	
	
	
	
	
	
}
