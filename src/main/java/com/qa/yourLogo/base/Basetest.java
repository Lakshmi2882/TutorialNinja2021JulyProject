package com.qa.yourLogo.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.qa.yourLogo.Utils.ElementUtil;
import com.qa.yourLogo.pages.Accountpage;
import com.qa.yourLogo.pages.CheckOut;
import com.qa.yourLogo.pages.Forgotpasswordpage;
import com.qa.yourLogo.pages.ModifyAddress;
import com.qa.yourLogo.pages.MyAccount;
import com.qa.yourLogo.pages.Productpage;
import com.qa.yourLogo.pages.ShoppingCart;
import com.qa.yourLogo.pages.changePassword;
import com.qa.yourLogo.pages.loginPage;

public class Basetest {
	public Basepage basepage;
	public Properties prop;
	public WebDriver driver;

	public loginPage login;
	public Accountpage Account;
	public Forgotpasswordpage fpd;
	public ElementUtil elementutil;
	public MyAccount myaccount;
	public changePassword changepassword;
	public ModifyAddress modifyadd;
	public Productpage product;
	public ShoppingCart shop;
	public CheckOut check;
public String browser;
@Parameters("browser")
@BeforeMethod
public void SetUp(String browserName)
{

basepage=new Basepage();
	prop=basepage.init_prop();
String browser=	prop.getProperty("browser");
if(browserName!=null)
{
	browser=browserName;
}
driver=	basepage.init_driver(browser);
login=new loginPage(driver);
fpd=new Forgotpasswordpage(driver);
driver.get(prop.getProperty("url"));


}
@AfterMethod
public void tearDown()
{ //driver.quit();
	
}
}
