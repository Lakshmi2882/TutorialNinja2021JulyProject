package com.qa.yourLogo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.yourLogo.Utils.ElementUtil;

public class CheckOut {
     private WebDriver driver;
     private ElementUtil elementutil;
     private By BillingContinue=By.xpath("//div[@class='pull-right']");
     private By DeliveryContinue=By.id("button-shipping-address");
     private By DeliveryMethodContinue=By.id("button-shipping-method");
     private By paymentContinue=By.id("button-payment-method");
     private By CheckBox=By.name("agree");
     private By Confirmorderdetails=By.id("button-confirm");
     private By confirmmessage=By.cssSelector("div  #content h1");
     private By confirmcontinue=By.linkText("Continue");
     public CheckOut(WebDriver driver)
     {
    	 this.driver=driver;
    	 elementutil=new ElementUtil(driver);
     }
     public void verifyBillingContinueButton() throws InterruptedException
     {    Thread.sleep(3000); 
    	 driver.getTitle();
    	 elementutil.doClick(BillingContinue);
     }
     public void verifyDeliveryContinue() throws InterruptedException
     { Thread.sleep(5000); 
    	 elementutil.doClick(DeliveryContinue);
     }
     public void verifyDeliveryMethodContinue() throws InterruptedException
     { 
    	 Thread.sleep(3000); 
    	 elementutil.doClick(DeliveryMethodContinue);
     }
	public void verifyPaymentMethodContinue() throws InterruptedException
	{   Thread.sleep(3000); 
		elementutil.doClick(CheckBox);
		elementutil.doClick(paymentContinue);
	}
	public void verifyConfirmorder() throws InterruptedException
	{ Thread.sleep(3000); 
		elementutil.doClick(Confirmorderdetails);
	}
	public String verifyConfirmationMessage()
	{ String confirmsuccessmessage=elementutil.getElement(confirmmessage).getText();

		System.out.println(confirmsuccessmessage);
		return confirmsuccessmessage;
	}
	public void verifyContinueAfterConfirmation() throws InterruptedException
	{ Thread.sleep(3000); 
		elementutil.doClick(confirmcontinue);
	}
	
}
