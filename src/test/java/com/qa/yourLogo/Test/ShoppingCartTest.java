package com.qa.yourLogo.Test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.yourLogo.base.Basetest;

public class ShoppingCartTest extends Basetest {
   
	@BeforeMethod
	public void ShoppingcartSetUp()
	{ String productname="MacBook Pro";
	Account=login.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		product= Account.productsearch(productname);
		shop= product.verifyAddQuantity();
		
		
	}
	@Test(priority=1,enabled=false)
	public void TitleTest()
	{
		shop.ShoppingCartTitle();
	}
	
	@Test
	public void ShoppingCartTableTest()
	{   System.out.println("Delete previous items");
		//product.verifyDeleteItems();
		System.out.println("Do shopping info");
		shop.verifyShoppingCartTable();
		
		
	}
}
