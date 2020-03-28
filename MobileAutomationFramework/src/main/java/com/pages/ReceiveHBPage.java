package com.pages;

import java.util.Hashtable;

import org.aspectj.weaver.bcel.BcelGenericSignatureToTypeXConverter.GenericSignatureFormatException;
import org.openqa.selenium.By;
import org.testng.Assert;

import com.driver.DriverManager;
import com.utils.TestUtils;

public class ReceiveHBPage extends ReceivePage{

	protected static By txtbox_pieces					=By.xpath("//*[contains(@resource-id,'receive_info_dimensions_pieces_layout')]//android.widget.EditText");
	protected static By txtbox_length					=By.xpath("//*[contains(@resource-id,'receive_info_dimensions_length_layout')]//android.widget.EditText");

	protected static By txtbox_width					=By.xpath("//*[contains(@resource-id,'receive_info_dimensions_width_layout')]//android.widget.EditText");
	protected static By txtbox_height					=By.xpath("//*[contains(@resource-id,'receive_info_dimensions_height_layout')]//android.widget.EditText");
	protected static By txtbox_weight					=By.xpath("//*[contains(@resource-id,'receive_info_dimensions_weight_line_layout')]//android.widget.EditText");
	protected static By btn_set							=By.xpath("//*[@text='SET']");
	protected static By txtbox_hbnumber					=By.xpath("//android.widget.EditText[contains(@resource-id,'receive_housebill_number')]");
	protected static By btn_createonly					=By.xpath("//*[@text='Create only']");
	protected static By txtbox_consigneename			=By.xpath("//*[contains(@resource-id,'receive_info_consignee')]");
	protected static By errormsgwhenpiecesnotgiven      =By.xpath("android.widget.TextView//[@text='Please provide piece count and packing type']");
	protected static By successmsgforhbreceive		     =By.xpath("android.widget.TextView//[contains(@text,'FSI Housebill has been received.')]");
			
			
	
	public void receiveHB() {
		
		sendKeys(txtbox_hbnumber, TestUtils.generateRandomHBnumber());
		DriverManager.getDriver().hideKeyboard();
	
		scrollToSpecificElementandClick(piecesrow);
		sendKeys(txtbox_pieces,  TestUtils.generateRandomNumericString(2));
		sendKeys(txtbox_length,  TestUtils.generateRandomNumericString(2));
		sendKeys(txtbox_width,   TestUtils.generateRandomNumericString(2));
		sendKeys(txtbox_height,  TestUtils.generateRandomNumericString(2));
		sendKeys(txtbox_weight,  TestUtils.generateRandomNumericString(2));
		click(btn_set);
		click(btn_send);
		click(btn_createonly);
		Assert.assertEquals(getText(successmsgforhbreceive), "FSI Housebill has been received");
	}



	

}
