package com.qa.yourLogo.base;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.qa.yourLogo.Utils.OptionsManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Basepage {
 public WebDriver driver;
 public Properties prop;
 public OptionsManager options;
 public static ThreadLocal<WebDriver>tlDriver=new ThreadLocal<WebDriver>();
 /* this method is to initialise webdriver
  *
  */
 public WebDriver init_driver(String browser) {
	 System.out.println("Browser name is :"+ browser);
	String highlight=prop.getProperty("Highlight");
	options=new OptionsManager(prop);
	 if(browser.equalsIgnoreCase("chrome"))
	 { 
		 System.out.println("Chrome Browser is opening");
		 WebDriverManager.chromedriver().setup();
		  if(Boolean.parseBoolean(prop.getProperty("remote")))
		  {
			  init_remoteDriver("chrome");
		  }
		  else
		  {
		  tlDriver.set(new ChromeDriver(options.getChromeOptions()));
		  }
	 }
		 
	 else if(browser.equalsIgnoreCase("firefox"))
	 {  System.out.println("firefox is opening");
		 WebDriverManager.firefoxdriver().setup();
		//  driver=new FirefoxDriver();
		 if(Boolean.parseBoolean(prop.getProperty("remote")))
		 {
			 init_remoteDriver("firefox");
		 }
		 else
		 {
		 tlDriver.set(new FirefoxDriver(options.getFirefoxOptions()));
		 }
	 }
	 else if(browser.equals("safari"))
	 { System.out.println("Safari is opening");
		  //driver=new SafariDriver();
	 tlDriver.set(new SafariDriver());
	 }
	 else
	 {
		 System.out.println("Enter the correct browser:"+browser);
	 }
	 return getDriver();
	 
 }
 /* for remote webdriver*/
 private void init_remoteDriver(String browser) {
	if(browser.equals("chrome"))
	{  
		System.out.println("running testcases remotely");
		DesiredCapabilities cap=DesiredCapabilities.chrome();
		System.out.println("set desired capabilities");
		cap.setCapability(ChromeOptions.CAPABILITY,options.getChromeOptions());
	try {
		tlDriver.set(new RemoteWebDriver(new URL(prop.getProperty("huburl")),cap));
	} catch (MalformedURLException e) {
		e.printStackTrace();
	}
	}
	else if(browser.equalsIgnoreCase("firefox"))
	{
		DesiredCapabilities cap =DesiredCapabilities.firefox();
		cap.setCapability(FirefoxOptions.FIREFOX_OPTIONS,options.getFirefoxOptions());
		try {
			tlDriver.set(new RemoteWebDriver(new URL(prop.getProperty("huburl")),cap));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
/* this method is to load properties from config.properties
  * it will return properties prop reference
  */
 public static synchronized WebDriver getDriver()
 {
	 return tlDriver.get();
 }
 public Properties init_prop() {
	  prop=new Properties();
	
	try {
	FileInputStream	ip = new FileInputStream("C:\\Users\\eddan\\.dotnet\\yourLogo\\src\\main\\java\\com\\qa\\yourLogo\\configpage\\config.properties");
		prop.load(ip);
	} catch (FileNotFoundException e) {
		
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 return prop;
	 
 }
 //This method is to take Screenshot
 //It will return screenshot
 public String getScreenshot()
 {
	File source=   ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	String path= System.getProperty("user.dir")+"/ScreenShots/"+System.currentTimeMillis()+".png";
	File destination=new File(path);
	try {
		FileUtils.copyDirectory(source, destination);
	} catch (IOException e) {
		e.printStackTrace();
	}
	return path;
 }
 
}
