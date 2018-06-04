package com.imbs.pages;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Messages {

	@FindBy(id="com.samsung.android.messaging:id/next_button")
	public AndroidElement next_Button;
	
	
	@FindBy(id="com.samsung.android.messaging:id/ok_button")
	public AndroidElement ok_Button;
	
	
	@FindBy(id="com.samsung.android.messaging:id/recipients_editor_to")
	public AndroidElement recipient;
	
	@FindBy(id="com.samsung.android.messaging:editor_body")
	public AndroidElement msg_Body;
	
	@FindBy(id="com.samsung.android.messaging:send_button")
	public AndroidElement send_Button;
	
	@FindBy(id="com.samsung.android.messaging:id/history")
	public AndroidElement send_Number;
	
	public Messages(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator((AndroidDriver<AndroidElement>)driver, 40, TimeUnit.SECONDS), this);
	}
}
