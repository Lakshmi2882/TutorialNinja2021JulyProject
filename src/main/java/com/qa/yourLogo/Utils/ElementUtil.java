package com.qa.yourLogo.Utils;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {
private WebDriver driver;
public ElementUtil(WebDriver driver)
{  System.out.println("driver is initialized to constructor variable ");
	this.driver=driver;
}
public WebElement getElement(By locator)
{System.out.println("To get one webelement");
WebElement element=	driver.findElement(locator);
return element;
}
public List<WebElement> getElements(By locator)
{ System.out.println("To get list of webelements");
List<WebElement>Listofelements=driver.findElements(locator);
return Listofelements;
}/* to do action with locator and value*/
public void doSendKeys(By locator,String value)
{ 
	Actions action=new Actions(driver);
	WebElement element=driver.findElement(locator);
	action.sendKeys(element, value).build().perform();
	//In Action class,for every page action need to write build().perform()
}
public void doClick(By locator)
{ System.out.println("To click the element with locator");
	driver.findElement(locator).click();
}
public void doActions(By locator)
{ System.out.println("To click element with action class");
	Actions action=new Actions(driver);
	WebElement element=driver.findElement(locator);
	action.click(element).build().perform();
	//In Action class,for every page action need to write build().perform()
}
public String getText(By locator)
{ System.out.println("To get text");
	WebElement element=driver.findElement(locator);
return	element.getText();
}

public int getSize(By locator)
{System.out.println("To find size");
List<WebElement> list=driver.findElements(locator);
 int elementsize= list.size();
 return elementsize;
	
}
public void getDropDownValues(By locator)
{   WebElement element=   driver.findElement(locator);
	Select select=new Select(element);
List<WebElement>optionsList=select.getOptions();
System.out.println("options list size is:"+optionsList.size());
for(int i=0;i<optionsList.size();i++)
{
	System.out.println(optionsList.get(i).getText());
}
}
public void selectDropDown(By locator,String value)
{System.out.println("select the element by visibleText");
WebElement element=	driver.findElement(locator);
Select select=new Select(element);
select.selectByVisibleText(value);
}
public void selectDropDown(By locator,int value)//method overloading
{ 
System.out.println("select the element by value");
WebElement element=driver.findElement(locator);
Select select=new Select(element);
select.selectByIndex(value);
}
public void selectDropDownValue(String value,By locator)
{
	System.out.println("select element by value");
	WebElement element=driver.findElement(locator);
	Select select=new Select(element);
	List<WebElement>valuesList=select.getOptions();
	for(int i=0;i<valuesList.size();i++)
	{
		if(valuesList.get(i).getText().equals(value))
		{
			valuesList.get(i).click();
			break;
		}
	}
}
public void getDropdownvaluesList(By locator)
{   System.out.println("To select all the values from dropdown");
	ArrayList<String>ar=new ArrayList<String>();
	WebElement element=driver.findElement(locator);
	Select select=new Select(element);
List<WebElement>optionsList=select.getOptions();
		for(int i=0;i<optionsList.size();i++)
		{
			ar.add(optionsList.get(i).getText());
	}
	
}

public void selectValueFromDropDownWithoutSelect(String locator,String locatorvalue,String value)	
{  List<WebElement>valuesList=null;
	
	if(locator.equals("Xpath"))
{
valuesList=driver.findElements(By.xpath(locatorvalue));
}
	else if(locator.equals("css"))
	{
	valuesList=	driver.findElements(By.cssSelector(locatorvalue));
	}
	
}
/* Wait Utils*/
public List<WebElement> visibilityOfAllElements(By locator,int timeout)
{ //To get list of all elements 
	WebDriverWait wait=new WebDriverWait(driver,timeout);
	wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(locator)));
	return driver.findElements(locator);
}
public WebElement waitForElementToBePresent(By locator,int timeout)	
{
	WebDriverWait wait=new WebDriverWait(driver,timeout);
	wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	return driver.findElement(locator);
}
public WebElement waitForElementToBeClickable(By locator,int timeout)	
{
	WebDriverWait wait=new WebDriverWait(driver,timeout);
	wait.until(ExpectedConditions.elementToBeClickable(locator));
	return driver.findElement(locator);
}
	
public WebElement waitForElementToBeVisible(By locator,int timeout)
{ WebElement element=driver.findElement(locator);
	WebDriverWait wait=new WebDriverWait(driver,timeout);
	wait.until(ExpectedConditions.visibilityOf(element));
	return element;
}
public String waitForURL(String url,int timeout)	
{
WebDriverWait wait=new WebDriverWait(driver,timeout);
wait.until(ExpectedConditions.urlContains(url));
return driver.getCurrentUrl();
}
public WebElement waitForElementVisibilityLocated(By locator,int timeout)	
{
	WebDriverWait wait=new WebDriverWait(driver,timeout);
	wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	return driver.findElement(locator);
}
public void clickWhenReady(By locator,int timeout)
{
	WebDriverWait wait=new WebDriverWait(driver,timeout);
	wait.until(ExpectedConditions.elementToBeClickable(locator));
	driver.findElement(locator).click();
}
public String waitForElementToBePresent(String title,int timeout)
{
	WebDriverWait wait=new WebDriverWait(driver,timeout);
	wait.until(ExpectedConditions.titleContains(title));
	return driver.getTitle();
}
public boolean doIsDisplayed(By locator)	
{
	return driver.findElement(locator).isDisplayed();
}

public void clearElement(By locator)
{
	driver.findElement(locator).clear();
}
	
	
public void MoveToElement(By locator)
{ WebElement element=driver.findElement(locator);
	Actions action=new Actions(driver);
	action.moveToElement(element).build().perform();

}








































}
