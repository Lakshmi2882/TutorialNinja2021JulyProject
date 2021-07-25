package com.qa.yourLogo.Test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.yourLogo.Utils.Constants;
import com.qa.yourLogo.base.Basetest;

public class changePasswordTest extends Basetest{

	@BeforeMethod
	public void chagePasswordSetUp()
	{
		Account=login.doLogin(prop.getProperty("username"),prop.getProperty("password"));
		changepassword=Account.verifyChangePasswordLink();
	}
	@Test(priority=1)
	public void TitleTest()
	{
	Assert.assertEquals(changepassword.verifyTitle(),Constants.changepasswordTitle);
	}
	@Test(priority=2)
	public void SuccessfulpageTest()
	{
		changepassword.verifypassword("bmw22RIDE*");
	Assert.assertEquals(changepassword.verifySuccesspageTitle(),Constants.SuccesspasswordTitle);
	}
	
}
