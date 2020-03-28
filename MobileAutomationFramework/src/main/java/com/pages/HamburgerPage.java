package com.pages;

import org.openqa.selenium.By;

public class HamburgerPage extends BasePage {
	
	public static By btn_logout=By.xpath("//*[contains(@resource-id,'drawer_logout_button_inner')]");
	
	public void clickLogout() {
		click(btn_logout);
	}
	

}
