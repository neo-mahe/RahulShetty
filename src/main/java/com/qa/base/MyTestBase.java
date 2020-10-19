package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class MyTestBase {
	public static AndroidDriver<AndroidElement> driver;
	public static String USRDIR = System.getProperty("user.dir");
	public static Properties prop;
    public static Logger log =	Logger.getLogger(MyTestBase.class); 
	public MyTestBase(){
		try {
			prop = new Properties();
//			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/com/appium"
//					+ "/qa/config/config.properties");
			
			FileInputStream ip = new FileInputStream(USRDIR + "/src/main/java/com/qa/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
//	public static AndroidDriver<AndroidElement> launchApp() throws MalformedURLException{
//	
//	DesiredCapabilities cap = new DesiredCapabilities();
//	cap.setCapability(MobileCapabilityType.APP, USRDIR + prop.getProperty("appPath"));
//	cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, prop.getProperty("automationName"));
//	cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, prop.getProperty("appActivity"));
//	cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, prop.getProperty("appPackage"));
//	cap.setCapability(AndroidMobileCapabilityType.AVD_LAUNCH_TIMEOUT, prop.getProperty("avdLaunchTimeOut"));
//	cap.setCapability(AndroidMobileCapabilityType.AVD_READY_TIMEOUT, prop.getProperty("avdReadyTimeout"));
//	cap.setCapability(AndroidMobileCapabilityType.AVD, prop.getProperty("avdName"));
//	AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
//	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//	return driver;
//
//}

	public static void main(String[] args) throws MalformedURLException {
		

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(AndroidMobileCapabilityType.AVD, "Pixel2");
		cap.setCapability(MobileCapabilityType.APP, "D:/AutomationProjects/eclipse-workspace/RahulShetty/src/main/resources/apps/FEApp.apk");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.colt.coltengineering.screen.SplashActivity");
		cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.colt.coltengineering");
		cap.setCapability(AndroidMobileCapabilityType.AVD_LAUNCH_TIMEOUT, 240000);
		cap.setCapability(AndroidMobileCapabilityType.AVD_READY_TIMEOUT, 240000);
		driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    	log.info("The appium server has made connection to the webdriver hub");
    	driver.findElementByAndroidUIAutomator("text(\"User ID\")").getText();
    	log.info("the text for userid is "+driver.findElementByAndroidUIAutomator("text(\"User ID\")").getText() );
		log.info("the terms are "+driver.findElementsByClassName("android.view.View").get(2).getText());
    	

	}


}
