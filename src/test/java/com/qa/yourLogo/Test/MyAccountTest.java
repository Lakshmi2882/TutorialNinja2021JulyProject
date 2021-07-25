package com.qa.yourLogo.Test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.yourLogo.Utils.Constants;
import com.qa.yourLogo.Utils.ExcelUtil;
import com.qa.yourLogo.base.Basetest;

public class MyAccountTest extends Basetest{
	@BeforeMethod
 public void MyAccountSetUp()
 {
	 Account=login.doLogin(prop.getProperty("username"),prop.getProperty("password"));
	 myaccount=Account.verifyEdityouraccountinformation();
 }
	@Test(priority=1)
	public void TitleTest()
	{
		Assert.assertEquals(myaccount.verifyTitle(),Constants.MyaccountTitle);
		
	}
	@DataProvider
	public Object[][] getTestData()
	{
	Object data[][]=	ExcelUtil.getTestData("EditAccountdetails");
	return data;
	}
	
	
	@Test(dataProvider="getTestData",priority=2)
	
	public void EditAccountinfoTest(String FirstName,String LastName,String Email,String Telephone)
	{
		myaccount.editInfoForm(FirstName, LastName, Email, Telephone);
	}
	@Test(dataProvider="getTestData",priority=3)
	public void EditAccountinfowithBackbutton(String FirstName,String LastName,String Email,String Telephone)
	{
		myaccount.editInfoFormB(FirstName, LastName, Email, Telephone);
	}
}
