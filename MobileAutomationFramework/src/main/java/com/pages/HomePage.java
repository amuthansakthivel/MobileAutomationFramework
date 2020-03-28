package com.pages;

import org.openqa.selenium.By;

public class HomePage extends BasePage {
	

	private static By btn_receive = By.xpath("//*[contains(@resource-id,'home_button_receive')]");
	private static By btn_process = By.xpath("//*[contains(@resource-id,'home_button_process')]");
	private static By btn_release = By.xpath("//*[contains(@resource-id,'home_button_release')]");
	private static By btn_return = By.xpath("//*[contains(@resource-id,'home_button_return')]");
	
	
	
	
	public HamburgerPage clickHamburger() {
		click(btn_hamburger);
		return new HamburgerPage();
	}
	
	public ReceivePage clickReceive() {
		click(btn_receive);
		return new ReceivePage();
	}

}
