package com.pages;

import com.utils.DynamicXpath;

public class APIDemoViewsPage extends BasePage{
	
	private static String viewpagemenus_a = "//android.widget.TextView[@text='%replaceable%']";
	private static String viewpagemenus_i = "//*[@text='%replaceable%']";
	
	public void clickMenu(String menutext) {
		click("xpath",DynamicXpath.get(viewpagemenus_a, menutext),DynamicXpath.get(viewpagemenus_i, menutext));
	}
	
	public void scrollAndClickMenu(String menutext) {
		scrollToSpecificElementandClick("xpath",DynamicXpath.get(viewpagemenus_a, menutext),DynamicXpath.get(viewpagemenus_i, menutext));
	}

}
