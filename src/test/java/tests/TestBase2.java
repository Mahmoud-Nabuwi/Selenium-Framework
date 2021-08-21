package tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import data.ReadProperties;

public class TestBase2 {
	//saucelab configration

	public static final String  username = ReadProperties.saucelabData.getProperty("username");
	public static final String accessKey = ReadProperties.saucelabData.getProperty("accesskey");
	public static final String saucelabURL = ReadProperties.saucelabData.getProperty("saucelabURL");
	
public static String baseUrl = "http://demo.nopcommerce.com";
protected ThreadLocal<RemoteWebDriver> driver= null;
@Parameters(value = {"browser"})
@BeforeClass
public void setup(@Optional("chrome") String browser) throws MalformedURLException {
	driver = new ThreadLocal<>();
	DesiredCapabilities caps = new DesiredCapabilities();
	caps.setCapability("browserName" , browser);
	//selenium grid locally
	//driver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), caps));
	//rub on sauclelab on cloud
	driver.set(new RemoteWebDriver(new URL(saucelabURL), caps));

	
	getDriver().navigate().to(baseUrl);
}
public WebDriver getDriver() {
	return driver.get();
}
@AfterClass
public void stopDriver() {
	getDriver().quit();
	driver.remove();
}
}
