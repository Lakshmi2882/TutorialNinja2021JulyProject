package com.qa.yourLogo.Utils;

import java.util.ArrayList;
import java.util.List;

public class Constants {
 public static final String Loginpagetitle="Account Login";
 public static final String Headertitle="Your Store";
 public static final String PageTitle="Forgot Your Password?";
 public static final String AccountPageTitle="My Account";
 public static List<String> categorylist()
 {
	 List<String> categoryList=new ArrayList<String>();
	 categoryList.add("Desktops");
	 categoryList.add("Laptops&Notebook");
	 categoryList.add("components");
	 categoryList.add("Tablets");
	 categoryList.add("software");
	 categoryList.add("phones&PDA");
	 categoryList.add("cameras");
	 categoryList.add("mp3Player");
	 return categoryList;
 }
 public static ArrayList<String> HeaderList()
 {
	 ArrayList<String>Headers=new ArrayList<String>();
	 Headers.add("My Account");
	 Headers.add("My Orders");
	 Headers.add("My Affiliate Account");
	 Headers.add("Newsletter");
	 return Headers;
 }

public static final String MyaccountTitle="My Account Information";
public static final String changepasswordTitle="Change Password";
public static final String SuccesspasswordTitle="Success: Your password has been successfully updated.";
public static final String ModifyAddressTitle="Address Book";
public static final String EditAddressHeader="Edit Address";
public static final String Deletedetails="Your address has been successfully deleted";
public static final String Successmessage="Success: You have added iMac to your shopping cart!";
public static final String  Confirmationmessage="Your order has been placed!";
}
