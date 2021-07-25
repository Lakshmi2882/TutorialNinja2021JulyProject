package com.qa.yourLogo.Test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.yourLogo.Utils.Constants;
import com.qa.yourLogo.base.Basetest;

public class AccountpageTest extends Basetest{
 @BeforeMethod
 public void AccountSetUp()
 {
	Account=login.doLogin(prop.getProperty("username"),prop.getProperty("password"));
	System.out.println("LoginPage is launched for Accountpage");
 }
 @Test(priority=1)
 public void AccountPageTitleTest()
 { 
	Assert.assertEquals(Account.AccountPageTitle(),Constants.AccountPageTitle);
 }
 @Test(priority=2)
 public void AccountPageHeaderTest() 
 {
	 Assert.assertEquals(Account.AccountPageHeader(),Constants.Headertitle);
 }
 @Test(priority=3)
 public void HeaderListTest()
 {
	 Assert.assertEquals(Account.verifyAccountpageHeaders(),Constants.HeaderList());
	 
 }
 @Test(priority=4)
 public void searchTest()
 {   
	 Assert.assertTrue(Account.Dosearch("iMac"));
 }
 
}

 
 
 
 
 
 
 
 
 
 
 
 
 