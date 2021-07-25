package com.qa.yourLogo.Test;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.yourLogo.Utils.Constants;
import com.qa.yourLogo.base.Basetest;

public class loginpageTest extends Basetest{
 @Test(priority=2)
 public void verifyloginpageTitle() {
String Text=	 login.getLoginpageTitle();
Assert.assertEquals(Text, Constants.Loginpagetitle);
	  
 }
 @Test(priority=1)
 public void VerifyHeaderTest()
 {
	 Assert.assertTrue(login.verifyHeaderText());
 }
 @Test(priority=2)
 public void verifyLoginTitleTest()
 {
	Assert.assertTrue( login.verifyLogintext());
 }
 @Test(priority=3)
 public void fogotPasswordLinkTest()
 {
	Assert.assertTrue( login.verifyForgotpasswordLink());
 }
 @Test(priority=4)
 public void categoryListTest()
 { 
	 login.iscategoriesDisplayed();
	 Assert.assertEquals(login.iscategoriesDisplayed(),Constants.categorylist());
 }
}
