package tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import utilities.Helper;

public class TestBase extends AbstractTestNGCucumberTests {
	public static WebDriver driver;
	public static String downloadPath = System.getProperty("user.dir")+"\\downloads";
	public static FirefoxOptions firefoxoption() {
		FirefoxOptions option = new FirefoxOptions();
		option.addPreference("browser.download.folderList",2);
		option.addPreference("browser.download.dir", downloadPath);
		option.addPreference("browser.helperApps.neverAsk.saveToDisk", "application/octet-stream");
		option.addPreference("browser.download.manager.showWhenStarting", false);
		return option;
	}
	 public static ChromeOptions chromeoption() {
	    	ChromeOptions option = new ChromeOptions();
	    	HashMap<String, Object> chromeprefs = new HashMap<>();
	    	chromeprefs.put("profile.default.content_settings.popups", 0);
	    	chromeprefs.put("download.default_directory", downloadPath);
	    	option.setExperimentalOption("prefs", chromeprefs);
	    	option.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
	    	return option;
	    }
	@BeforeSuite
	@Parameters({"browser"})
	public void startDriver(@Optional("chrome")  String browserName) {
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "\\drivers\\chromedriver.exe");
			driver = new ChromeDriver(chromeoption());
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+ "\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver(firefoxoption());
		}
		else if(browserName.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+ "\\drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		// testing on headless browser 
		else if (browserName.equalsIgnoreCase("headless")) {
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setJavascriptEnabled(true);
			caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,  System.getProperty("user.dir")+ "\\drivers\\phantomjs.exe");
			String [] phantomJsArguments = {"--web-security=no","--ignore-ssl-errors =yes"};
			caps.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, phantomJsArguments);
			driver = new PhantomJSDriver(caps);
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
	}

	@AfterSuite
	public void stopDriver() {
		driver.quit();
	}
	// Take screenshot when test case fail and add it in screenshots folder
	@AfterMethod
	public void screenShotOnFailure(ITestResult result) throws IOException {
		if(result.getStatus() == ITestResult.FAILURE) {
			System.out.println("failed");
			System.out.println("Taking ScreenShoot ........");
			Helper.captureSreenShot(driver, result.getName());
			
		}
	}
}
