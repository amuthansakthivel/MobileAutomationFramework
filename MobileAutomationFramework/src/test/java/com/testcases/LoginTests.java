package com.testcases;

import java.util.Hashtable;

import org.testng.annotations.Test;

import com.driver.Driver;
import com.pages.HamburgerPage;
import com.pages.HomePage;
import com.pages.LoginPage;

public class LoginTests extends BaseTest{
	
	LoginPage loginpage;
	HomePage homepage;
	HamburgerPage hpage;
	
	@Test
	public void loginTest(Hashtable<String,String> data) throws Exception {
		
		
		Driver.initialize(data.get("nature"),data.get("deviceName"),data.get("udid"),Integer.parseInt(data.get("port")));
		
		loginpage= new LoginPage();
		homepage=loginpage.loginToApplication();
		hpage=homepage.clickHamburger();
		hpage.clickLogout();
	}
	
	

}
