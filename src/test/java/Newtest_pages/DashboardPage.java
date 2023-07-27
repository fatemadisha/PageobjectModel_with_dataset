package Newtest_pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import Newtest_driver.PageDriver;
import Newtest_utilities.Commonmethods;
import Newtest_utilities.GetScreenshot;
import junit.framework.Assert;

public class DashboardPage extends Commonmethods{
	
	ExtentTest test;
	
	public DashboardPage(ExtentTest test) {
		PageFactory.initElements(PageDriver.getCurrentDriver(), this);
		this.test = test;
	}
	
	@FindBys({
		@FindBy(xpath = "//body/div[@id='app']/div[1]/div[1]/aside[1]/nav[1]/div[2]/ul[1]/li[1]/a[1]")
	})
	WebElement adminOption;
	
	@FindBys({
		@FindBy(xpath = "//header/div[1]/div[1]/span[1]/h6[1]")
	})
	WebElement dashboardText;
	
	
	public void checkDashboard() throws IOException {
//		String expectedText = "Dashboard";
//		String actualText = dashboardText.getText();
//		Assert.assertEquals(actualText, expectedText);
		try {
			if(dashboardText.isDisplayed()) {
				Assert.assertEquals(dashboardText.getText(), "Dashboard");
			}
		} catch (Exception e) {
			test.fail("<p style=\"color:#FF5353; font-size:13px\"><b>Dash Board Text is not locateable.Please check the error message.</b></p>");
			Throwable t = new InterruptedException("Exception");
			test.fail(t);
			@SuppressWarnings("unused")
			String screenShotPath = GetScreenshot.capture(PageDriver.getCurrentDriver(), "DashBoardText");
			String dest = System.getProperty("user.dir") + "\\screenshots\\" + "DashboardText.png";
			test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
			Assert.assertTrue(dashboardText.isDisplayed());
			PageDriver.getCurrentDriver().quit();
		}
		
	}
	
	public void clickAdmin() throws IOException {
		try {
			if(adminOption.isDisplayed()) {
				adminOption.click();
				timeout(5000);
				test.pass("<p style=\"color:#85BC63; font-size:13px\"><b>You have successfully Clicked.</b></p>");
				String screenShotPath = GetScreenshot.capture(PageDriver.getCurrentDriver(), "adminOption_ok");
				String dest = System.getProperty("user.dir") + "\\screenshots\\" + "adminOption_ok.png";
				test.pass(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
			}
		} catch (Exception e) {
			test.fail("<p style=\"color:#FF5353; font-size:13px\"><b>Admin Option is not Clickable.Please check the error message.</b></p>");
			Throwable t = new InterruptedException("Exception");
			test.fail(t);
			@SuppressWarnings("unused")
			String screenShotPath = GetScreenshot.capture(PageDriver.getCurrentDriver(), "adminOption");
			String dest = System.getProperty("user.dir") + "\\screenshots\\" + "adminOption.png";
			test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
			Assert.assertTrue(adminOption.isDisplayed());
			PageDriver.getCurrentDriver().quit();
		}
	}
	

}