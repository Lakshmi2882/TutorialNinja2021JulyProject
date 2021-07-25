package com.qa.yourLogo.Test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.yourLogo.Utils.Constants;
import com.qa.yourLogo.base.Basetest;

public class ForgotpasswordTest extends Basetest{

	
	@Test(priority=2)
	public void forgotPasswordHeaderTest()
	{
		Assert.assertEquals(fpd.verifyHeaderTitle(),Constants.Headertitle);
	}
	@Test(priority=1)
 public void pageTitleTest()
 {
	Assert.assertEquals( fpd.verifyTitleOfThePage(),Constants.PageTitle);
 }
	@Test(priority=3)
	public void continueButtonTest()
	{
		fpd.clickEmailAddress();
	}
	@Test(priority=4)
	public void backButtonTest()
	{
		fpd.clickBackButton();
	}
}
