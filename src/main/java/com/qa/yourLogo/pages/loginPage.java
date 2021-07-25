package com.qa.yourLogo.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.yourLogo.Utils.Constants;
import com.qa.yourLogo.Utils.ElementUtil;
import com.qa.yourLogo.base.Basepage;

public class loginPage extends Basepage{
	private WebDriver driver;
	public ElementUtil elementutil;
	//By locators
 private By emailid=By.name("email");
 private By password=By.id("input-password");
 private By Submit=By.xpath("//input[@value='Login']");
 private By header=By.linkText("Your Store");
 private By logintext=By.xpath("//h2");
 private By categories=By.xpath("//div//li[@class='dropdown']");
 private By forgotpassword=By.linkText("Forgotten Password");

 //constructors
 public loginPage(WebDriver driver)
 { //driver is initialized
	this.driver=driver; 
	elementutil=new ElementUtil(driver);
 }
 public String getLoginpageTitle()
 { 
	 String Title=driver.getTitle();
	 System.out.println("Title is :"+Title);
 return Title;
	 	 
 }
public boolean verifyHeaderText()
{ return elementutil.doIsDisplayed(header);
	
}
public ArrayList<String> iscategoriesDisplayed()
{  
	ArrayList<String>list=new ArrayList<String>();
	List<WebElement> element=elementutil.getElements(categories);
	for(int i=0;i<element.size();i++)
	{
		list.add(element.get(i).getText());
	
	}
	return list;
}
public boolean verifyLogintext()
{  
	List<WebElement> texts=elementutil.getElements(logintext);
	System.out.println("Texts size is:"+texts.size());
	boolean verified=false;
	for(int i=0;i<texts.size();i++)
	{  
	String Title=	texts.get(i).getText();
	    System.out.println("The Logintext on the top is:"+Title);
		if(Title.equals("Returning Customer"))
		{
			System.out.println(Title);
			verified =true;
			break;
		}
	}
	return verified;
}
public Accountpage doLogin(String un,String pwd)
{ 
	System.out.println("Enter username and password"+ un +" and"+pwd);
	elementutil.getElement(emailid).sendKeys(un);
	elementutil.getElement(password).sendKeys(pwd);
	System.out.println("click submit button");
	elementutil.getElement(Submit).click();
	System.out.println("Landing on Accountpage");
	return new Accountpage(driver);
}
public boolean verifyForgotpasswordLink()
{ System.out.println("checking forgot password link");
 return elementutil.doIsDisplayed(forgotpassword);
}
}
