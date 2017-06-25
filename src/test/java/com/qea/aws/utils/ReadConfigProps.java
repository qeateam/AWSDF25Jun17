package com.qea.aws.utils;

import java.util.ResourceBundle;

public class ReadConfigProps {
	
	//Public global values
	public static String APPURL, DBUSERNAME, DBPASSWORD, PLATFORM, BROWSER;
	public void retrieve_configProperties() {

		ResourceBundle objResBundle = ResourceBundle.getBundle("properties.config");
		APPURL = (String) objResBundle.getObject("URL");
		System.out.println("URL>>"+APPURL);
		DBUSERNAME = (String) objResBundle.getObject("DBUSERNAME");
		System.out.println("DBUSERNAME>>"+DBUSERNAME);
		DBPASSWORD = (String) objResBundle.getObject("DBPASSWORD");
		System.out.println("DBPASSWORD>>"+DBPASSWORD);
		PLATFORM = (String) objResBundle.getObject("PLATFORM");
		System.out.println("PLATFORM>>"+PLATFORM);
		BROWSER = (String) objResBundle.getObject("BROWSER");
		System.out.println("BROWSER>>"+BROWSER);
		
		

	}
}