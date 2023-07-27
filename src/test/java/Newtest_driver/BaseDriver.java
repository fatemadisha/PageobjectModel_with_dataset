package Newtest_driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseDriver {
	
    public static String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	WebDriver driver = null;

	@BeforeSuite
	public void start() {
		String browser = System.getProperty("browser", "firefox");

//		if (browser.contains("chrome")) {
//			WebDriverManager.chromedriver().setup();
//			//ChromeOptions options = new ChromeOptions();
//			//options.setAcceptInsecureCerts(true);
//			//options.addArguments("--remote-allow-origins=*");
//			driver = new ChromeDriver();
//
//		}

		 if (browser.contains("firefox")) {
			WebDriverManager.firefoxdriver().setup();

			driver = new FirefoxDriver();
		} else {

			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();

		}
		
		PageDriver.getInstance().setDriver(driver);
	}

	@AfterSuite
// this method will closed by this annotation
	public void close() {
		PageDriver.getCurrentDriver().quit();
	}

}
