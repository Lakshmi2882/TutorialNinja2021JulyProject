package com.qa.yourLogo.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.yourLogo.Utils.ElementUtil;
import com.qa.yourLogo.base.Basepage;

public class Accountpage extends Basepage{
	private WebDriver driver;
	public ElementUtil elementutil;
	private By header=By.cssSelector("div #logo");
	private By AccountpageHeaders=By.cssSelector("div #content h2");
	private By search=By.name("search");
	private By clickIcon=By.xpath("//span[@class='input-group-btn']");
	private By products=By.cssSelector(".product-layout .product-thumb");
	private By Editaccountinfo=By.linkText("Edit your account information");
	private By changepassword=By.linkText("Change your password");
	private By modifyaddresslink=By.linkText("Modify your address book entries");
	private By vieworderhistory=By.linkText("View your order history");
	private By downloads=By.linkText("Downloads");
	private By reward=By.linkText("Your Reward Points");
	private By returnrequest=By.linkText("View your return requests");
	private By Transcation=By.linkText("Your Transactions");
	private By recurringpay=By.linkText("Recurring payments");
	private By Registeraffiliate=By.linkText("Register for an affiliate account");
	private By subscribeLink=By.linkText("Subscribe / unsubscribe to newsletter");
	private By productsList=By.cssSelector("div#content h4 a");
	
	public Accountpage(WebDriver driver)
	{ //constructor is created to initialise driver
		this.driver=driver;
		elementutil=new ElementUtil(driver);
	}
 public String AccountPageTitle()
 { String AccountPageTitle=driver.getTitle(); 
 System.out.println(AccountPageTitle);
 return AccountPageTitle;
 }
 public String AccountPageHeader()
 {
	String HeaderTitle=driver.findElement(header).getText();
	System.out.println(HeaderTitle);
	return HeaderTitle;
 }
 public ArrayList<String> verifyAccountpageHeaders()
 { ArrayList<String>ar=new ArrayList<String>();
	List<WebElement>HeaderList= elementutil.getElements(AccountpageHeaders);
	System.out.println(HeaderList.size());
	for(WebElement e:HeaderList)
	{
		System.out.println(ar.add(e.getText()));
	}
	 return ar;
 }
 public boolean Dosearch(String productname)
 {  System.out.println("enter productname");
 elementutil.clearElement(search);
	 elementutil.doSendKeys(search,productname);
		 elementutil.doClick(clickIcon);
		 if(elementutil.getElements(products).size()>0)
		 {
			 return true;
		 }
		 else
			 return false;
 }
 public Productpage productsearch(String productname)
 {   elementutil.clearElement(search);
	 System.out.println("Enter productname:" + productname);
	 elementutil.doSendKeys(search,productname);
	 System.out.println("Clicking the icon");
	 elementutil.doClick(clickIcon);
	 
	List<WebElement>productList=elementutil.getElements(productsList);
	for(WebElement e:productList)
	{System.out.println("get the productlist:" +e.getText());
	if(e.getText().equalsIgnoreCase(productname))
	{
		e.click();
		break;
	}
	}
	 return new Productpage(driver);//this is integration
 }

public MyAccount verifyEdityouraccountinformation()
{
elementutil.doClick(Editaccountinfo);
return new MyAccount(driver);
}

public changePassword verifyChangePasswordLink()
{  
	elementutil.doClick(changepassword);
	return new changePassword(driver);
	
}
public ModifyAddress verifymodifyAddressLink()
{
	elementutil.doClick(modifyaddresslink);
	return new ModifyAddress(driver);
}

public void verifyViewyourorderhistory()
{
	elementutil.doClick(vieworderhistory);
}
public void verifyDownloads()
{
	elementutil.doClick(downloads);
}
public void verifyrewards()
{
	elementutil.doClick(reward);
}
public void verifyReturnRequest()
{
	elementutil.doClick(returnrequest);
}

public void verifyrTranscationLink()
{
	elementutil.doClick(Transcation);
}
public void verifyRecurringPaymentLink()
{
	elementutil.doClick(recurringpay);
}
public void verifyRegisterafflicate()
{
	elementutil.doClick(Registeraffiliate);
}
public void verifySubscribeLink()
{ 
	elementutil.doClick(subscribeLink);
}




}
