package com.qa.yourLogo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.yourLogo.Utils.ElementUtil;
import com.qa.yourLogo.base.Basepage;

public class changePassword  extends Basepage{
private WebDriver driver;
private ElementUtil elementutil;
private By passwordText=By.name("password");
private By changepassword=By.name("confirm");
private By continuebutton=By.xpath("//input[@type='submit']");
private By backbutton=By.linkText("Back");
private By Title=By.xpath("//div[contains(text(),' Success: Your password has been successfully updated.')]");
public changePassword(WebDriver driver)
{
	this.driver=driver;
	elementutil=new ElementUtil(driver);
}
public String verifyTitle()
{
	System.out.println(driver.getTitle());
	return driver.getTitle();
}
public Accountpage verifypassword(String password)
{
	elementutil.doSendKeys(passwordText, "bmw22RIDE*");
	elementutil.doSendKeys(changepassword, "bmw22RIDE*");
	elementutil.doClick(continuebutton);
	return new Accountpage(driver);
}
	
public Accountpage verifypasswordbutton()
{
	elementutil.doSendKeys(passwordText, "bmw22RIDE*");
	elementutil.doSendKeys(changepassword, "bmw22RIDE*");
	elementutil.doClick(backbutton);
	return new Accountpage(driver);
}
public String verifySuccesspageTitle()
{
	String title=elementutil.getElement(Title).getText();
	return title;
	
}
}
