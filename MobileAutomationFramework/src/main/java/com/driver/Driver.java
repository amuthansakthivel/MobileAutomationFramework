package com.driver;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.constants.Constants;
import com.reports.LogStatus;
import com.utils.JsonParser;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;



/*
 * SingleTon Pattern
 * Make sure to update the test name in the excel
 */
public class Driver {

	public static AppiumDriver<MobileElement> driver;
	public DesiredCapabilities capability;

	/*
	 * nature can be android,ios,webandroid and webios.
	 * Need to set this for each test case in the excel sheet (sheetname = TestData)
	 */
	private Driver(String nature,String devicename,String udid,int port) throws IOException {

		if(nature.equalsIgnoreCase("android")){
			capability = new DesiredCapabilities();
			capability.setCapability(MobileCapabilityType.UDID, udid);
			capability.setCapability(MobileCapabilityType.DEVICE_NAME, devicename);
			capability.setCapability(AndroidMobileCapabilityType.SYSTEM_PORT, port);
			capability.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
			capability.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir")+"\\ApiDemos-debug.apk");
			//capability.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, JsonParser.getValue("config.global.apppackage"));
			//capability.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,JsonParser.getValue("config.global.appactivity"));
			driver= new AndroidDriver<MobileElement>(new URL(JsonParser.getValue("config.global.appiumurl")),capability);
			DriverManager.setIsAndroid(true);
		}
		else if(nature.equalsIgnoreCase("webandroid")) {
			capability = new DesiredCapabilities();
			capability.setCapability(MobileCapabilityType.UDID, udid);
			capability.setCapability(MobileCapabilityType.DEVICE_NAME, devicename);
			capability.setCapability(AndroidMobileCapabilityType.SYSTEM_PORT, port);
			capability.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
			capability.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
			capability.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID );
			capability.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE, Constants.CHROMEDRIVERPATH);
			driver= new AndroidDriver<MobileElement>(new URL(JsonParser.getValue("config.global.appiumurl")),capability);
			DriverManager.setIsAndroid(true);
		}
		else if(nature.equalsIgnoreCase("ios")) {

			capability.setCapability("platformName", "ios");
			capability.setCapability("deviceName", devicename);
			capability.setCapability("bundleId",JsonParser.getValue("config.global.bundleid"));
			driver= new IOSDriver<MobileElement>(new URL(JsonParser.getValue("config.global.appiumurl")),capability);
			DriverManager.setIsAndroid(false);
		}
		else if(nature.equalsIgnoreCase("webios")) {
			capability.setCapability("platformName", "ios");
			capability.setCapability("deviceName", devicename);
			capability.setCapability("automationName", "Appium");
			capability.setCapability("browserName", "Safari");
			capability.setCapability(MobileCapabilityType.UDID, udid);
			driver= new IOSDriver<MobileElement>(new URL(JsonParser.getValue("config.global.appiumurl")),capability);
			DriverManager.setIsAndroid(false);
		}
		else {
			LogStatus.fatal(("Please check your capabilities"));
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		DriverManager.setAppiumDriver(driver);

	}



	public static void initialize(String nature,String devicename,String udid, int port) throws IOException {
		if(DriverManager.getDriver()==null)
			new Driver(nature,devicename,udid,port);
	}

}
