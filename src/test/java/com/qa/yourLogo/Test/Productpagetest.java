package com.qa.yourLogo.Test;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.yourLogo.Utils.Constants;
import com.qa.yourLogo.base.Basetest;

public class Productpagetest extends Basetest{
@BeforeMethod
public void productpageSetUp()
{ String productname="MacBook Pro";
	Account=login.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	product= Account.productsearch(productname);
	
}
@Test

public void headerTest()
{
	Assert.assertTrue(product.getproductHeader());
}


@Test(priority=1,enabled=false)
public void productinfoTest()
{ 
	Assert.assertTrue(Account.Dosearch("iMac"));
	Account.productsearch("iMac");
	
}
@Test(priority=2)

	public void productTest()
	{ String productname="MacBook Pro";
	product= Account.productsearch(productname);
		 
	}
@Test(priority=3)
public void productinformationTest()
{ String productname="MacBook Pro";
product= Account.productsearch(productname);

	product.getProductInformation();
Map <String,String>productInformation=product.getProductInformation();
System.out.println(productInformation);
product.verifyAddQuantity();
	
}

@Test(priority=4)
public void AddQuantityTest()
{
	product.getProductInformation();
	product.verifyAddQuantity();;
	
}
@Test(priority=5)
public void itemCartTest()
{   product.verifyAddQuantity();
shop.verifyShoppingCartTable();
}
@Test(priority=6)

public void DeleteItemsTest()
{  
product.verifyDeleteItems();
}


















}

