package com.imbs.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class mainPage{
	private AndroidDriver driver;
	
		public mainPage(AndroidDriver driver) {
			this.driver = driver;
			//this.driverTwo = driverTwo;
			PageFactory.initElements(new AppiumFieldDecorator((AndroidDriver)driver, 40, TimeUnit.SECONDS), this);
		}
		
		@FindBy(xpath = "//*[contains(@text, 'NEXT')]")
		public AndroidElement nextBtn;
		
		@FindBy(id = "com.samsung.android.messaging:id/ok_button")
		public AndroidElement okBtn;
		
		@FindBy(id = "com.samsung.android.messaging:id/actionbar_arrow")
		public AndroidElement backArrowBth;
		
		@FindBy(id = "android:id/search_src_text")
		public AndroidElement searchFieldMainPage;
		
		
		@FindBy (id = "com.samsung.android.messaging:id/attach_button")
		public AndroidElement attachButton;
		
		public void clickAttachButn() {
			attachButton.click();
		}
		
		public void clickNextStartUsingPage() {
			nextBtn.click();
		}
		
		public void clickOkHowAdvancedMessagesPage() {
			okBtn.click();
		}
		
		public void clickBackArrowNewMessagePage() {
			backArrowBth.click();
		}
		
		public void clickOnSearchField( ) {
			searchFieldMainPage.click();
		}
		
		public void sendTextToSearch(String searchThis) {
			searchFieldMainPage.sendKeys(searchThis);
		}
		
		public void closeApplication() {
			driver.quit();
		}
		
		public void proceedToTheMainMenu() {
			clickNextStartUsingPage();
			System.out.println("Clicked Next");
			clickOkHowAdvancedMessagesPage();
			
			driver.startActivity(new Activity("com.samsung.android.messaging", "com.android.mms.ui.ConversationComposer"));
			
			System.out.println("Clicked OK");
			clickBackArrowNewMessagePage();
			System.out.println("Clicked Back Arrow");
		}

}
