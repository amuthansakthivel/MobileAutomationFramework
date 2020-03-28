package com.testcases;

import java.io.IOException;
import java.util.Hashtable;

import org.testng.annotations.Test;

import com.driver.Driver;
import com.pages.APIDemoHomePage;
import com.pages.LoginPage;
import com.pages.APIDemoViewsPage;

public class APIDemosTest extends BaseTest{

	//udid for the device can be obtained by adb devices command in the cmd
	//port can 8200 and 8201 if you want to run two tests in parallel
	//device name is mandatory but can be any name ie)My Test Device

	
	APIDemoHomePage hpage;
	APIDemoViewsPage viewpage;
	
	//validateTapAndScrolling
	@Test
	public void testAPIDemo(Hashtable<String,String> data) throws NumberFormatException, IOException {
		Driver.initialize(data.get("nature"),data.get("deviceName"),data.get("udid"),Integer.parseInt(data.get("port")));
		hpage= new APIDemoHomePage();
		viewpage=hpage.clickview();
		viewpage.clickMenu("Expandable Lists");
		

	}

	@Test
	public void testAPIScroll(Hashtable<String,String> data) throws NumberFormatException, IOException {
		Driver.initialize(data.get("nature"),data.get("deviceName"),data.get("udid"),Integer.parseInt(data.get("port")));
		hpage= new APIDemoHomePage();
		viewpage=hpage.clickview();
		viewpage.scrollAndClickMenu("WebView");
		

	}

	
}
