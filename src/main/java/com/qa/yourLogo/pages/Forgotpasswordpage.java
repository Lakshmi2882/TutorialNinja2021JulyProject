package com.qa.yourLogo.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.yourLogo.Utils.ElementUtil;
import com.qa.yourLogo.base.Basepage;

public class Forgotpasswordpage extends Basepage{
	private WebDriver driver;
	private By forgotpassword=By.linkText("Forgotten Password");
	private By header=By.tagName("h1");
	private By EmailAddress= By.name("email");
	private By Continue=By.xpath("//input[@value='Continue']");
	private By backbutton=By.linkText("Back");
	public ElementUtil elementutil;
	public Forgotpasswordpage(WebDriver driver)
	{
		this.driver=driver;
		elementutil=new ElementUtil(driver);
	}
	public Forgotpasswordpage setup()
	{   elementutil.doClick(forgotpassword);
		return new Forgotpasswordpage(driver);
	}
	public void doClickForgotPasswordLink()
	{   System.out.println("click on forgotpassword link");
		elementutil.doClick(forgotpassword);
	}
	public String verifyHeaderTitle()
	{  elementutil.doClick(forgotpassword);
		System.out.println(elementutil.getText(header));
		return elementutil.getText(header);
	}
	public String verifyTitleOfThePage()
	{    elementutil.doClick(forgotpassword);
		System.out.println(driver.getTitle());
		return driver.getTitle();
	}
	public loginPage clickEmailAddress()
	{
		 elementutil.doClick(forgotpassword);
		 elementutil.getElement(EmailAddress).sendKeys("eddanapudir@gmail.com");
		 elementutil.doClick(Continue);
	 	return new loginPage(driver);	
	}
	public loginPage clickBackButton()
	{   elementutil.doClick(forgotpassword);
	    elementutil.doClick(backbutton);
		return new loginPage(driver);
	}

}
