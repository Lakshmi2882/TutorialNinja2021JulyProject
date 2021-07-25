package com.qa.yourLogo.pages;

import java.util.List;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.yourLogo.Utils.ElementUtil;
import com.qa.yourLogo.base.Basepage;

public class ShoppingCart extends Basepage{
     private WebDriver driver;
     private ElementUtil elementutil;
     private By column=By.xpath("//*[@id=\"content\"]/form/div/table/thead/tr/td");
     private By row=By.xpath("//*[@id=\"content\"]/form/div/table/tbody/tr/td");
     private By Checkout=By.linkText("Checkout");
    
	public ShoppingCart(WebDriver driver)
	{
		this.driver=driver;
		elementutil=new ElementUtil(driver);
	}
	public void ShoppingCartTitle()
	{
	System.out.println( driver.getTitle());
	}
 
public CheckOut verifyShoppingCartTable()
{     List<WebElement> columnlist= elementutil.getElements(column);
	int coloumncount=elementutil.getSize(column);
	List<WebElement>rowlist=elementutil.getElements(row);
	int rowcount=elementutil.getSize(row);
	
	for(int i=1;i<rowcount;i++)
	{
		System.out.print(rowlist.get(i).getText());
		System.out.println();
		
	}
	elementutil.doClick(Checkout);
	return new CheckOut(driver);
}
	
	
	
	
	
	
	
}

