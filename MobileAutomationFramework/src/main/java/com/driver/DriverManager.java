package com.driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class DriverManager {

	public static ThreadLocal<AppiumDriver<MobileElement>> dr = new ThreadLocal<AppiumDriver<MobileElement>>();
	public static ThreadLocal<Boolean> isAndroid = new ThreadLocal<Boolean>();

	public static AppiumDriver<MobileElement> getDriver() {

		return dr.get();

	}

	public static void setAppiumDriver(AppiumDriver<MobileElement> driver) {

		dr.set(driver);
	}
	
	public static Boolean getIsAndroid() {

		return isAndroid.get();

	}

	public static void setIsAndroid(Boolean value) {

		isAndroid.set(value);
	}


}
