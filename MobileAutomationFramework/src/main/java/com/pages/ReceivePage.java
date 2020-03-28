package com.pages;

import org.openqa.selenium.By;

public class ReceivePage extends BasePage {

	private static By btn_receivefsihb				=By.xpath("//*[contains(@resource-id,'receive_fsi_hb_button')]");
	private static By btn_receiveonhand				=By.xpath("//*[contains(@resource-id,'receive_onhand_button')]");
	private static By btn_receivelairtruck			=By.xpath("//*[contains(@resource-id,'receive_lair_truck_button')]");

	private static By btn_export					=By.xpath("//*[contains(@resource-id,'receive_menu_export')]");
	private static By btn_import					=By.xpath("//*[contains(@resource-id,'receive_menu_tms_booking')]");
	private static By btn_unknown					=By.xpath("//*[contains(@resource-id,'receive_menu_import')]");
	private static By btn_afrexportedibooking		=By.xpath("//*[contains(@resource-id,'receive_menu_unknown')]");
	private static By btn_close						=By.xpath("//*[contains(@resource-id,'receive_menu_cancel')]");
	
	
	protected static By piecesrow					=By.xpath("//*[contains(@resource-id,'receive_info_dimensions_table')]");
	protected static By btn_send					=By.xpath("//*[contains(@resource-id,'receive_floating_menu')]/android.widget.ImageButton");

	public ReceivePage clickReceiveFSIHB() {
		click(btn_receivefsihb);
		return this;
	}

	public ReceivePage clickReceiveOnhand() {
		click(btn_receiveonhand);
		return this;
	}

	public ReceivePage clickReceiveLAIRTruck() {
		click(btn_receivelairtruck);
		return this;
	}

	public ReceiveHBPage clickExportHB() {
		click(btn_export);
		return new ReceiveHBPage();
	}
	public ReceiveHBPage clickImportHB() {
		click(btn_import);
		return new ReceiveHBPage();
	}
	public ReceiveHBPage clickUnknownHB() {
		click(btn_unknown);
		return new ReceiveHBPage();
	}
	public ReceiveHBPage clickAFRexportHB() {
		click(btn_afrexportedibooking);
		return new ReceiveHBPage();
	}

	public ReceiveONHPage clickExportONH() {
		click(btn_export);
		return new ReceiveONHPage();
	}
	public ReceiveONHPage clickImportONH() {
		click(btn_import);
		return new ReceiveONHPage();
	}
	public ReceiveONHPage clickUnknownONH() {
		click(btn_unknown);
		return new ReceiveONHPage();
	}
	


}
