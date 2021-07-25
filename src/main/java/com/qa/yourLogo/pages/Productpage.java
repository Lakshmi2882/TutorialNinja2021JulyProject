package com.qa.yourLogo.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.qa.yourLogo.Utils.ElementUtil;
import com.qa.yourLogo.base.Basepage;

import io.qameta.allure.model.Link;

public class Productpage extends Basepage{
private WebDriver driver;
private ElementUtil elementutil;
private By productmetadata=By.cssSelector("#content .list-unstyled:nth-of-type(1) li");
private By productprice=By.cssSelector(" #content .list-unstyled:nth-of-type(2) li");
private By Quantity=By.name("quantity");
private By AddToCartButton=By.id("button-cart");
private By Successmessage=By.cssSelector("div .alert");
private By productHeader=By.linkText("Your Store");
//private By CartItems=By.xpath("//span[@id='cart-total']");
private By CartItems= By.id("cart");
private By ViewCart=By.xpath("//*[@id='cart']/ul/li[2]/div/p/a[1]/strong");
private By deletecart=By.xpath("//span[@id='cart-total']");
private By clickeletebutton=By.xpath("//button[@class='btn btn-danger btn-xs']");

public Productpage(WebDriver driver)
{
	this.driver=driver;
	elementutil=new ElementUtil(driver);
}
public boolean getproductHeader()
{
	return elementutil.doIsDisplayed(productHeader);
}
public Map<String, String> getProductInformation()
{  System.out.println(driver.getTitle());
	HashMap <String,String>productinfo= new HashMap<String,String>();
List<WebElement>productmetadetalist=elementutil.getElements(productmetadata);
for(WebElement e:productmetadetalist)
{
	productinfo.put(e.getText().split(":")[0].trim(),e.getText().split(":")[1]);
}
List<WebElement>productpricelist=elementutil.getElements(productprice);
productinfo.put("price",productpricelist.get(0).getText());
productinfo.put("Ex Tax",productpricelist.get(1).getText());
return productinfo;
}
public ShoppingCart  verifyAddQuantity()
{
elementutil.clearElement(Quantity);	
elementutil.doSendKeys(Quantity,"2");
elementutil.doClick(AddToCartButton);
elementutil.doClick(CartItems);
elementutil.doClick(ViewCart);
return new ShoppingCart(driver);
}
public void verifyDeleteItems()
{   System.out.println("check cart Items");
	elementutil.doClick(CartItems);
	System.out.println("delete cart Items");
	//elementutil.doClick(deletecart);
	elementutil.doClick(clickeletebutton);
	
}











}