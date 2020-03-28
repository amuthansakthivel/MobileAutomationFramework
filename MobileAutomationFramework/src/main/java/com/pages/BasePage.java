package com.pages;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.constants.Constants;
import com.driver.DriverManager;
import com.reports.LogStatus;
import com.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;


/*
 * Only refer the BasePage, APIDemoHomePage,APIDemoViewsPage
 */

public class BasePage {

	protected static By btn_hamburger = By.xpath("//android.widget.ImageButton[@content-desc='Open navigation drawer']");
	protected static By btn_backinmenubar = By.xpath("//android.view.ViewGroup[contains(@resource-id,'toolbar')]/ImageButton");
	protected static By btn_dismiss    =By.xpath("//andoird.widget.Button[@text='DISMISS']");
	protected static By btn_retry      =By.xpath("//*[contains(@resource-id,'retry_button')]");

	protected TouchAction ta;

	protected  BasePage() {
		PageFactory.initElements(new AppiumFieldDecorator(DriverManager.getDriver()), this);
	}

	
	
	//click methods overloaded
	protected void click(String locatorname,String androidlocatorvalue,String ioslocatorvalue)  {
		if(locatorname.equalsIgnoreCase("xpath")) {
			click(By.xpath(androidlocatorvalue),By.xpath(ioslocatorvalue));
		}
		else if(locatorname.equalsIgnoreCase("id")) {
			click(By.id(androidlocatorvalue),By.id(ioslocatorvalue));
		}
		else if(locatorname.equalsIgnoreCase("css")) {
			click(By.cssSelector(androidlocatorvalue),By.cssSelector(ioslocatorvalue));
		}

	}
	
	protected void click(By by, By by2) {
		click(DriverManager.getDriver().findElement(by),DriverManager.getDriver().findElement(by2));
	}

	protected void click(By by) {
		click(DriverManager.getDriver().findElement(by));
	}

	protected void click(MobileElement androideleement,MobileElement ioselement)  {
		if(DriverManager.getIsAndroid()) {
			click(androideleement);
		}
		else {
			click(ioselement);
		}
		
	}
	protected void click(MobileElement element) {
		explicitlyWait(element);
		LogStatus.pass("Screenshot below", TestUtils.pullScreenshotPath());
		element.click();
		LogStatus.pass("Clicking is successfull on "+ element);
	}

	

	//sendkeys overlaoded
	protected void sendKeys(String locatorname,String androidlocatorvalue,String ioslocatorvalue,String value)  {
		if(locatorname.equalsIgnoreCase("xpath")) {
			sendKeys(By.xpath(androidlocatorvalue),By.xpath(ioslocatorvalue),value);
		}
		else if(locatorname.equalsIgnoreCase("id")) {
			sendKeys(By.id(androidlocatorvalue),By.id(ioslocatorvalue),value);
		}
		else if(locatorname.equalsIgnoreCase("css")) {
			sendKeys(By.cssSelector(androidlocatorvalue),By.cssSelector(ioslocatorvalue),value);
		}

	}
	
	protected void sendKeys(By by, By by2,String value) {
		sendKeys(DriverManager.getDriver().findElement(by),DriverManager.getDriver().findElement(by2),value);
	}
	
	protected void sendKeys(By by,String value) {
		sendKeys(DriverManager.getDriver().findElement(by),value);
	}

	protected void sendKeys(MobileElement androideleement,MobileElement ioselement,String value)  {
		if(DriverManager.getIsAndroid()) {
			sendKeys(androideleement,value);
		}
		else {
			sendKeys(ioselement,value);
		}
		
	}
	protected void sendKeys(MobileElement element,String value) {
		explicitlyWait(element);
		LogStatus.pass("Screenshot below", TestUtils.pullScreenshotPath());
		element.sendKeys(value);
		LogStatus.pass(value + " is entered in to the "+ element);
	}

	
	

	

	private void explicitWait(By by) {
		explicitlyWait(DriverManager.getDriver().findElement(by));
	}


	private void explicitlyWait(MobileElement textview_views) {
		WebDriverWait wait=new WebDriverWait(DriverManager.getDriver(),Constants.EXPLICITWAIT);
		wait.until(ExpectedConditions.visibilityOf(textview_views));
	}

	protected void clickIfExists(By by) {

		if(DriverManager.getDriver().findElements(by).size()>0) {
			click(DriverManager.getDriver().findElement(by));
		}
	}
	

	protected String getText(By by) {
		return getText(DriverManager.getDriver().findElement(by));

	}

	protected String getText(MobileElement element) {
		explicitlyWait(element);
		String temp=element.getAttribute("text");
		LogStatus.info("Text retrieved :"+temp);
		return temp;

	}


	protected void tap(WebElement webelement) {
		ta=new TouchAction(DriverManager.getDriver());
		ta.tap(tapOptions().withElement(element(webelement))).perform();
	}
	protected void longPress(WebElement webelement) {
		ta=new TouchAction(DriverManager.getDriver());
		ta.longPress(longPressOptions().withElement(element(webelement)).withDuration(ofSeconds(4))).release().perform();
	}

	protected void swipe(WebElement source,WebElement target) {
		ta=new TouchAction(DriverManager.getDriver());
		ta.longPress(longPressOptions().withElement(element(source)).withDuration(ofSeconds(3)))
		.moveTo(element(target)).release().perform();
	}
	/*protected void scollToSpecificElement(String text) {
		//driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"))"); ---->hardcoding
		//---->Below one is dynamic
		DriverManager.getDriver().findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+text+"\").instance(0))");

	}*/
	

	
	public  void scrollToSpecificElementandClick(By by)
	{

		while(DriverManager.getDriver().findElements(by).size()==0)
		{
			Dimension dimensions = DriverManager.getDriver().manage().window().getSize();
			Double screenHeightStart = dimensions.getHeight() * 0.5;
			int scrollStart = screenHeightStart.intValue();
			Double screenHeightEnd = dimensions.getHeight() * 0.2;
			int scrollEnd = screenHeightEnd.intValue();
			int center = (int) (dimensions.width*0.5);
			ta=new TouchAction(DriverManager.getDriver());
			ta.press(PointOption.point(center,scrollStart)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500))).
			moveTo(PointOption.point(center,scrollEnd)).release().perform();
		}

		if(DriverManager.getDriver().findElements(by).size()>0)
		{
			click(by);	
		}
	}

	public  void scrollToSpecificElementandClick(String locatorname,String androidlocatorvalue,String ioslocatorvalue)
	{
		if(DriverManager.getIsAndroid()) {
			if(locatorname.equalsIgnoreCase("xpath")) {
				scrollToSpecificElementandClick(By.xpath(androidlocatorvalue));
			}
		}
		else {
			if(locatorname.equalsIgnoreCase("xpath")) {
				scrollToSpecificElementandClick(By.xpath(ioslocatorvalue));
			}
		}

	}

	protected void dragAndDrop(WebElement source, WebElement target) {
		ta=new TouchAction(DriverManager.getDriver());
		ta.longPress(longPressOptions().withElement(element(source))).moveTo(element(target)).release().perform();

	}
	protected void clickElementOneUntilElementTwoAppears(By by1, By by2) {
		while(!DriverManager.getDriver().findElement(by2).isDisplayed()) {
			click(by1);
		}
	}

	protected void clickElementUntilElementDisAppears(By by) {
		boolean isElementPresent=false;
		int count=3;
		while((!isElementPresent) &&(count>0)) {

			try {
				click(by);
				count--;
				isElementPresent=!(DriverManager.getDriver().findElement(by).isDisplayed());
			}
			catch(Exception e) {
				isElementPresent=true;
			}
		}
	}

}
