package com.qea.aws.utils;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.apache.xerces.util.URI.MalformedURIException;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.chrome.*;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class InvokeBrowser implements GlobalObjects {
	
	public RemoteWebDriver driver;
	public enum browsers {
		FIRFOX, CHROME, BS_CHROME
	}
	
	//BS details
	public static final String USERNAME = "sumantaroy1";
	public static final String AUTOMATE_KEY = "S5F4z3eKrtbA7GVmtPKp";
	public static final String URL = "https://"+USERNAME+":"+AUTOMATE_KEY+"@hub.browserstack.com/wd/hub";

	@SuppressWarnings({ "unchecked", "rawtypes", "deprecation" })
	public void invokeBrowser(browsers browserName) throws MalformedURIException, MalformedURLException {
		// File app = new File("C:\\Program
		// Files\\Experitest\\SeeTest\\bin\\ipas","eribank.apk");
		//DesiredCapabilities capabilities = new DesiredCapabilities();
		//capabilities.setCapability(CapabilityType.BROWSER_NAME, "CHROME");
		//capabilities.setCapability("deviceName", "ZY2232GXWX");// comment for device farm, needed in local
		//capabilities.setCapability("platformName", "Android");
		//capabilities.setCapability("platformVersion", "6.0.1");
		//capabilities.setBrowserName("chrome");
		// capabilities.setCapability("app", app.getAbsolutePath());
		/*
		 * capabilities.setCapability("app-package",
		 * "com.experitest.ExperiBank");
		 * capabilities.setCapability("app-activity", ".LoginActivity")
		 */;
		 //System.setProperty("webdriver.chrome.driver", "E:\\ChromeDriver\\chromedriver.exe");
		URL url = new URL("http://127.0.0.1:4723/wd/hub");

		switch (browserName) {
		case FIRFOX:
			if (objReadConfigProps.PLATFORM.equals("WEB")) {
				//objGlobal.driver = new FirefoxDriver();
				driver.get(objReadConfigProps.APPURL);
			}

			if (objReadConfigProps.PLATFORM.equals("MOBILE")) {
				/*objGlobal.driver = new AppiumDriver(url, capabilities, null) {
					public MobileElement scrollToExact(String arg0) {
						// TODO Auto-generated method stub
						return null;
					}

					public MobileElement scrollTo(String arg0) {
						// TODO Auto-generated method stub
						return null;
					}

					@Override
					public DeviceRotation rotation() {
						// TODO Auto-generated method stub
						return null;
					}

					@Override
					public void rotate(DeviceRotation arg0) {
						// TODO Auto-generated method stub

					}

					@Override
					public void swipe(int arg0, int arg1, int arg2, int arg3, int arg4) {
						// TODO Auto-generated method stub
						
					}
				};*/
				driver.get(objReadConfigProps.APPURL);
			}
			break;

		case CHROME:
			if (objReadConfigProps.PLATFORM.equals("WEB")) {
				//System.setProperty("webdriver.chrome.driver", "---PATH TO CHROME EXE FILE---");
				//System.setProperty("webdriver.chrome.driver", "E:\\ChromeDriver\\chromedriver.exe");
				//objGlobal.driver = new ChromeDriver();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.get(objReadConfigProps.APPURL);
			}

			if (objReadConfigProps.PLATFORM.equals("MOBILE")) {
				//driver = new RemoteWebDriver(url, capabilities);
				
				//objGlobal.driver = new ChromeDriver();
				//objGlobal.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				//objGlobal.driver.get(objReadConfigProps.URL);
				//driver.get("https://www.netflix.com");
				
				/*objGlobal.driver.navigate();
				objGlobal.driver.get(objReadConfigProps.URL);*/
				
			}
			break;
		
		case BS_CHROME:
			if (objReadConfigProps.PLATFORM.equals("WEB")) {
			//Set capabilities
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability("browser", "Chrome");
			caps.setCapability("browser_version", "hrome");
			caps.setCapability("os", "Windows");
			caps.setCapability("browserstack.local", "true");
			caps.setCapability("browserstack.debug", "true");
			caps.setCapability("acceptSslCerts", "true");
			caps.setCapability("build", "AWS_Sumanta");
			caps.setCapability("project", "AWS_Sumanta_proj");
			
			driver = new RemoteWebDriver(new URL(URL), caps);
			driver.get(objReadConfigProps.APPURL);
			
			break;
			}

		default:
			throw new IllegalArgumentException("Invalid selection method");

		}

	}
}
