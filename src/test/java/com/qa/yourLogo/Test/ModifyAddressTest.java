package com.qa.yourLogo.Test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.yourLogo.Utils.Constants;
import com.qa.yourLogo.Utils.ExcelUtil;
import com.qa.yourLogo.base.Basetest;

public class ModifyAddressTest extends Basetest {
@BeforeMethod
public void ModifyAddressSetUp()
{ Account=login.doLogin(prop.getProperty("username"),prop.getProperty("password"));
modifyadd=Account.verifymodifyAddressLink();
}
@Test(priority=1)
public void TitleTest()
{ 
Assert.assertEquals(modifyadd.verifyTitle(),Constants.ModifyAddressTitle);
}
@Test(priority=2)
public void MyAddressButton()
{
	Assert.assertTrue(modifyadd.verifyMyaddressButton());
}

@DataProvider
public Object[][] getTestData()
{
	Object data[][]=ExcelUtil.getTestData("AddAddressBook");
	return data;
}
public Object[][] getTestdata1()
{
	Object data[][]=ExcelUtil.getTestData("EditAddressBook");
	return data;
}
@Test(dataProvider="getTestData",priority=3)
 public void AddAddressTest(String FirstName,String Lastname,String company,String Address1,String Address2,String city,String postcode,String country,String Region,String DefaultAddress)
{ 
	modifyadd.AddAddress(FirstName, Lastname, company, Address1, Address2, city, postcode, country, Region, DefaultAddress);
	Assert.assertEquals(modifyadd.DeleteAddress(),Constants.Deletedetails);
}

@Test(dataProvider="getTestdata1",dependsOnMethods= {"AddAddressTest"},priority=4,enabled=false)
public void EditTestData(String FirstName,String Lastname,String company,String Address1,String Address2,String city,String postcode,String country,String Region,String DefaultAddress)
{  Assert.assertEquals(modifyadd.Editdetails(),Constants.EditAddressHeader);
	modifyadd.AddAddress(FirstName, Lastname, company, Address1, Address2, city, postcode, country, Region, DefaultAddress);
	
}
@Test(priority=5,enabled=false)
public void DeleteAddressTest()
{
	Assert.assertEquals(modifyadd.DeleteAddress(),Constants.Deletedetails);
}

@Test(priority=6)

public void BackToAddressBook()
{
	System.out.println("Go back to Add address page");
	Assert.assertEquals(modifyadd.verifyTitle(),Constants.ModifyAddressTitle);
}
}
