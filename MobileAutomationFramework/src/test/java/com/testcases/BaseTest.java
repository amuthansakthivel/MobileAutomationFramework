package com.testcases;

import java.awt.Desktop;
import java.io.File;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.constants.Constants;
import com.driver.Driver;
import com.driver.DriverManager;
import com.reports.ExtentReport;
import com.utils.TestUtils;


/*
 * 
 * Only APIDemosTest is valid for API demo app. Other tests are invalid
 * All test classes needs to extend BaseTest
 * 
 */
public class BaseTest {
	
	
	@BeforeSuite
	public void beforeSuite() throws Exception {
		ExtentReport.initialize();
		TestUtils.deleteFolder(new File(System.getProperty("user.dir")+"\\Screenshots"));
		
	}
	

	
	
	@AfterMethod
	public static void wrapUp() throws InterruptedException {
		Thread.sleep(10000);
		DriverManager.setAppiumDriver(null);
		
	}



	@AfterSuite
	public void afterSuite() throws Exception {

		ExtentReport.report.flush();
		File htmlFile = new File(Constants.EXTENTREPORTPATH);
		Desktop.getDesktop().browse(htmlFile.toURI());
		
	}

}
