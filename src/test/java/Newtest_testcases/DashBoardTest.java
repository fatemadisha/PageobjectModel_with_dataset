package Newtest_testcases;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import Newtest_driver.BaseDriver;
import Newtest_pages.DashboardPage;
import Newtest_utilities.ExtentFactory;


public class DashBoardTest extends BaseDriver {
	
	ExtentReports report;
	ExtentTest parentTest;
	ExtentTest childTest;
		
		@Test(priority = 0)
		public void dashBoardTest() throws InterruptedException, IOException {
			report = ExtentFactory.getInstance();
			parentTest = report.createTest("<p style=\"color:#FF6000; font-size:20px\"><b>DashBoard Module</b></p>").assignAuthor("QA TEAM").assignDevice("Windows");
			childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>LOGIN TEST</b></p>");
			DashboardPage dashboardPage = new DashboardPage(childTest);
			dashboardPage.checkDashboard();
     		dashboardPage.clickAdmin();
		}
		
		@AfterClass
		public void afterClass() {
			report.flush();
		}
		
}
