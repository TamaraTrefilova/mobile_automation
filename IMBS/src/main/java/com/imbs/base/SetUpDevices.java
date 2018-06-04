package com.imbs.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class SetUpDevices {

	public Properties configProp = null;
	public DesiredCapabilities capabilities = null;
	public static AndroidDriver driver;
		public static AppiumDriverLocalService service = null;
	private String localURL = "http://0.0.0.0:4723/wd/hub";
	private String headspinURL = "https://us-pnw.headspin.io:7016/v0/d7bcdd0374fb44ed8e85533ffe8f38b1/wd/hub";

	public AndroidDriver setUpConnection(String udid, String deviceName) {
		capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", deviceName);
		capabilities.setCapability("appPackage", "com.samsung.android.messaging");
		capabilities.setCapability("appActivity", "com.android.mms.ui.ConversationComposer");
		capabilities.setCapability("platformVersion", "android");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("noReset", false);
		capabilities.setCapability("autoGrantPermissions", true);
		capabilities.setCapability("udid", udid);
		capabilities.setCapability("newCommandTimeout", 10);

		try {
			driver = new AndroidDriver(new URL(localURL), capabilities);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
	}
	
	/*
	public void permissionsInitialization() throws MalformedURLException {
		capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", configProp.getProperty("device.name"));
		capabilities.setCapability("appPackage", configProp.getProperty("app.package"));
		capabilities.setCapability("appActivity", configProp.getProperty("app.activity"));
		capabilities.setCapability("platformVersion", configProp.getProperty("os.version"));
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("noReset", false);
		capabilities.setCapability("autoDenyPermissions", false);

		driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}
	*/
	public static void stopAppium() {
		service.stop();
	}
	
	
}