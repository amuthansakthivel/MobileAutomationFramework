package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class APIDemoHomePage extends BasePage{

	
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Views']")
	@iOSXCUITFindBy(xpath="//*[@text='Views']")
	private MobileElement textview_views;

	public APIDemoViewsPage clickview() {
		click(textview_views);
		return new APIDemoViewsPage();
	}

}
