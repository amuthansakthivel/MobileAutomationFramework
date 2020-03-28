package com.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.utils.JsonParser;


public class LoginPage extends BasePage{




	private static By lnk_allow=By.xpath("//*[@text='ALLOW']");
	private static By txtbox_username=By.xpath("//*[contains(@resource-id,'login_username')]");
	private static By txtbox_password=By.xpath("//*[contains(@resource-id,'login_password')]");
	private static By btn_login=By.xpath("//*[contains(@resource-id,'login_button')]");

	public HomePage loginToApplication() throws Exception {
		try {
			logoutIfNeeded();
		}
		catch(Exception e) {

		}
		clickIfExists(lnk_allow);
		clickElementUntilElementDisAppears(btn_retry);
		sendKeys(txtbox_username, JsonParser.getValue("config.global.username"));
		sendKeys(txtbox_password,JsonParser.getValue("config.global.password"));
		click(btn_login);
		return new HomePage();
	}

	

	private void logoutIfNeeded() {
		clickElementOneUntilElementTwoAppears(btn_backinmenubar, btn_hamburger);
		click(btn_hamburger);
		click(HamburgerPage.btn_logout);
	}

}
