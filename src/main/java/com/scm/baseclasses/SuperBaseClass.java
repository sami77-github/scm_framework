package com.scm.baseclasses;

import java.io.IOException;
import java.time.Duration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.xml.XmlTest;

import com.scm.generic_utilities.FileUtility_True;

public class SuperBaseClass {
	public WebDriver driver = null;
	public static String browser = null;
	FileUtility_True pu = new FileUtility_True();

	@BeforeSuite(alwaysRun = true)
	public void beforeSuitConfigMethod() {
		System.out.println("suit level configuration start");
		System.out.println("database connected");
	}

	@BeforeClass(alwaysRun = true)
	public void beforeClassConfigMethod(XmlTest test) throws IOException {
		System.out.println("class level configuration start");

		// getting browser either from cmd(jenkins) or suite file or properties file...
		browser = System.getProperty("browser");
		System.out.println("Browser value from cmd/jenkins: " + browser);
		if (browser == null || browser.trim().isEmpty()) {
			browser = test.getParameter("browser");
			System.out.println("Browser value from xml: " + browser);
			if (browser == null || browser.trim().isEmpty()) {
				browser = pu.getDataFromProperties("browser");
				System.out.println("Browser value from properties: " + browser);
			}
		}
		

		if (browser.equalsIgnoreCase("chrome")) {

		    WebDriverManager.chromedriver().setup();

		    ChromeOptions options = new ChromeOptions();
		    options.addArguments("--headless=new");
		    options.addArguments("--disable-gpu");
		    options.addArguments("--window-size=1920,1080");

		    driver = new ChromeDriver(options);

		} else if (browser.equalsIgnoreCase("edge")) {

		    WebDriverManager.edgedriver().setup();
		    driver = new EdgeDriver();

		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();

			FirefoxOptions options = new FirefoxOptions();
			options.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe"); // 👈 IMPORTANT
			options.addArguments("--headless");

			driver = new FirefoxDriver(options);

		}

		UtilityClassObject.setDriver(driver);
		driver = UtilityClassObject.getDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		// getting url either from cmd(jenkins) or suite file or properties file...
		String url = System.getProperty("url");
		if (url == null || url.trim().isEmpty()) {
			url = test.getParameter("url");
			if (url == null || url.trim().isEmpty()) {
				url = pu.getDataFromProperties("url");
			}
		}
		driver.get(url);
		System.out.println("browser launched and application opened");
	}

	@AfterClass(alwaysRun = true)
	public void afterClassConfigMethod() {
		// driver.manage().window().minimize();
		if (driver != null) {
			driver.quit();
		}
		UtilityClassObject.removerDriver(); // to remove all the local driver instances from thread local...
		System.out.println("browser closed...");
	}

	@AfterSuite(alwaysRun = true)
	public void afterSuiteConfigMethod() {
		System.out.println("databse connection closed...");
	}
}
