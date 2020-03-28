package com.testcases;

import java.util.Hashtable;

import org.testng.annotations.Test;

import com.driver.Driver;
import com.pages.HamburgerPage;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.ReceiveHBPage;
import com.pages.ReceivePage;

public class ReceivePageTests extends BaseTest{

	
	LoginPage loginpage;
	HomePage homepage;
	HamburgerPage hpage;
	ReceiveHBPage rhbpage;
	
	@Test
	public void receiveFSIHBTest(Hashtable<String,String> data) throws Exception {
		Driver.initialize(data.get("nature"),data.get("deviceName"),data.get("udid"),Integer.parseInt(data.get("port")));
		
		loginpage= new LoginPage();
		homepage=loginpage.loginToApplication();
		rhbpage=homepage.clickReceive().clickReceiveFSIHB().clickExportHB();
		rhbpage.receiveHB();
	}
}
