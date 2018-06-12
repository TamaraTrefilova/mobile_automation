package com.techmahindra.automation.IMBS;



import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.imbs.base.SetUpDevices;
import com.imbs.pages.Messages;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Test_Msg extends SetUpDevices {
	AndroidDriver<AndroidElement> driver;
	Messages msg;
	
	@Parameters({ "device_id", "device_name"})
	@BeforeClass
	public void beforeClass(String device_id, String device_name) {
		 driver = setUpConnection(device_id, device_name);
		 msg = new Messages(driver);
	}
	
	
	
	@Test
	public void test_Open_Messages() {
		
		try {
			Thread.sleep(1000);
			msg.next_Button.click();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		msg.ok_Button.click();
		msg.recipient.sendKeys("4253295854");
//		msg.recipient.submit();
//		try {
//			driver.wait(1000);
//			TouchAction touch = new TouchAction(driver);
//		    driver.performTouchAction(touch).tap(msg.msg_Body);
		msg.msg_Body.click();
		msg.msg_Body.sendKeys("Hello world");
		msg.msg_Body.submit();
		msg.send_Button.click();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		msg.msg_Body.click();
//		msg.msg_Body.sendKeys("Hello world");
//		msg.msg_Body.submit();
//		msg.send_Button.click();		
	}
	
	
	
	
	@AfterClass
	public void afterClass() {
		driver.quit();		
	}

}
