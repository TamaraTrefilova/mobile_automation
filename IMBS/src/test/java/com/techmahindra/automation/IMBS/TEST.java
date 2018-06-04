package com.techmahindra.automation.IMBS;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.tools.ant.taskdefs.Retry;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.imbs.base.SetUpDevices;
import com.imbs.pages.mainPage;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.Test;

public class TEST extends SetUpDevices{
	public mainPage mainPage = null;
	
	
	public List<mainPage> getListOfPages(){
		List<String> listOfUDIDs = new ArrayList<String>();
//		listOfUDIDs.add("9887a847373847314c");
		listOfUDIDs.add("98895a43474d414537");
//		listOfUDIDs.add("90389062");
//		listOfUDIDs.add("95fe6aa2");
//		listOfUDIDs.add("902c90c2");
//		listOfUDIDs.add("903e9090");
//		
		List<mainPage> listOfNewPages = new ArrayList<mainPage>();
		
		for(int i = 0; i < listOfUDIDs.size(); i++) {
			AndroidDriver driver = setUpConnection(listOfUDIDs.get(i), "Device " + Integer.toString(i));
			System.out.println("UDID RUNNING " + listOfUDIDs.get(i));
			listOfNewPages.add(new mainPage(driver));
			listOfNewPages.get(i).proceedToTheMainMenu();
		}
		
		return listOfNewPages;
	}
	
//	AndroidDriver driver = setUpConnection("98895a43474d414537", "Device ");
	
	public void closeAppOnAllDevices(int countOfDevices, List<mainPage> listOfNewPages) {
		for(int driverCount = 0; driverCount < countOfDevices; driverCount++) {
			listOfNewPages.get(driverCount).closeApplication();
		}
	}

	@Test(priority = 11, alwaysRun = true, enabled = true) //false true
	public void typeIntoSearchBar() {
		List<mainPage> listOfNewPages = getListOfPages();
		System.out.println("TEST STARTED");
		listOfNewPages.get(0).clickOnSearchField();
		listOfNewPages.get(0).sendTextToSearch("DEVICE 1");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//listOfNewPages.get(1).sendTextToSearch("DEVICE 2");
		
		closeAppOnAllDevices(listOfNewPages.size(), listOfNewPages);
	}
}
