package com.qa.yourLogo.Test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.yourLogo.Utils.Constants;
import com.qa.yourLogo.base.Basetest;

public class CheckOutTest extends Basetest{

	@BeforeMethod
	public void checkoutSetUp()
	{
		String productname="MacBook Pro";
		Account=login.doLogin(prop.getProperty("username"), prop.getProperty("password"));
			product= Account.productsearch(productname);
			shop= product.verifyAddQuantity();
			check=	shop.verifyShoppingCartTable();
	}
	
	@Test(priority=1)
	public void ContinueBillingButtonTest() throws InterruptedException
	{
	//check=	shop.verifyShoppingCartTable();
		check.verifyBillingContinueButton();
		check.verifyDeliveryContinue();
		check.verifyDeliveryMethodContinue();
		check.verifyPaymentMethodContinue();
		check.verifyConfirmorder();
	Assert.assertEquals(check.verifyConfirmationMessage(),"Checkout");
	check.verifyContinueAfterConfirmation();
	}
	

}
