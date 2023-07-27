package Newtest_pages;

import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import junit.framework.Assert;

import org.openqa.selenium.support.FindBys;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import Newtest_driver.PageDriver;
import Newtest_utilities.Commonmethods;
import Newtest_utilities.GetScreenshot;

public class Loginpage extends Commonmethods{
	
	ExtentTest test;
	public Loginpage(ExtentTest test) {

		// 1. pagefactory init
		// 2. locators
		//3. function
		
		PageFactory.initElements(PageDriver.getCurrentDriver(), this);
		this.test = test;
	}

	@FindBys({

			// can use multiple xpath for same place in page object model
			//@FindBy(xpath = "//input[@name = 'username']"),
			//@FindBy(xpath = "//input[@placeholder='Username'])"),
			@FindBy(xpath = "//body/div[@id='app']/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[1]/div[1]/div[2]/input[1]")

	})
	WebElement userName;

	@FindBys({ 
		@FindBy(xpath = "//input[@name = 'password']"), 
		@FindBy(xpath = "//input[@placeholder = 'Password']"),
		@FindBy(xpath = "//body/div[@id='app']/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[2]/div[1]/div[2]/input[1]") })

	WebElement Password;

	@FindBys({ @FindBy(xpath = "//body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[3]/button[1]") })

	WebElement Button;

	public void login(String username, String pass) throws InterruptedException, IOException {
		timeout(10000);
	  
	  //username
	  try {
		  if(userName.isDisplayed()) {
			  userName.sendKeys(username);
			  timeout();
	  }
	  }
	  catch(Exception e){
		  test.fail("<p style=\"color:#FF5353; font-size:13px\"><b>Username is not locateable.Please check the error message.</b></p>");
			Throwable t = new InterruptedException("Exception");
			test.fail(t);
			@SuppressWarnings("unused")
			String screenShotPath = GetScreenshot.capture(PageDriver.getCurrentDriver(), "userLocator");
			String dest = System.getProperty("user.dir") + "\\screenshots\\" + "usernameLocator.png";
			test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
			Assert.assertTrue(userName.isDisplayed());
			PageDriver.getCurrentDriver().quit();
	  }

	// password
	try

	{
		if (Password.isDisplayed()) {
			Password.sendKeys(pass);
			timeout();
		}
	}
	catch(Exception e){
		test.fail("<p style=\"color:#FF5353; font-size:13px\"><b>Password is not locateable.Please check the error message.</b></p>");
		Throwable t = new InterruptedException("Exception");
		test.fail(t);
		@SuppressWarnings("unused")
		String screenShotPath = GetScreenshot.capture(PageDriver.getCurrentDriver(), "passwordLocator");
		String dest = System.getProperty("user.dir") + "\\screenshots\\" + "passwordLocator.png";
		test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
		Assert.assertTrue(Password.isDisplayed());
		PageDriver.getCurrentDriver().quit();
	}

	// Login button
	try{
		if(Button.isDisplayed()){
			Button.click();
			timeout(5000);
			test.pass("<p style=\"color:#85BC63; font-size:13px\"><b>You have successfully logged in.</b></p>");
			String screenShotPath = GetScreenshot.capture(PageDriver.getCurrentDriver(), "loginPass");
			String dest = System.getProperty("user.dir") + "\\screenshots\\" + "loginPass.png";
			test.pass(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
			}
		}
	catch(Exception e)
	{
		test.fail("<p style=\"color:#FF5353; font-size:13px\"><b>Login Button is not locateable.Please check the error message.</b></p>");
		Throwable t = new InterruptedException("Exception");
		test.fail(t);
		@SuppressWarnings("unused")
		String screenShotPath = GetScreenshot.capture(PageDriver.getCurrentDriver(), "ButtonLocator");
		String dest = System.getProperty("user.dir") + "\\screenshots\\" + "ButtonLocator.png";
		test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
		Assert.assertTrue(Button.isDisplayed());
		PageDriver.getCurrentDriver().quit();
	}
	}
}
	
  

