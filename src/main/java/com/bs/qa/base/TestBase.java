package com.bs.qa.base;

import com.bs.qa.util.TestUtil;
import com.bs.qa.util.WebEventListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	public TestBase(){
		try {
			prop = new Properties();
			URL resource = Thread.currentThread().getContextClassLoader().getResource("config.properties");
			FileInputStream ip = new FileInputStream(new File(resource.toURI()));
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException | URISyntaxException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void initialization( String browser, String url){
		String browserName = prop.getProperty("browser");
		if (browser != null && !browser.isEmpty()) {
			browserName =browser;
		}
		if(browserName.equals("chrome")){
			driver = new ChromeDriver();
		}
		else if(browserName.equals("firefox")){
				driver = new FirefoxDriver();
		}
		
	//
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		if (url != null && !url.isEmpty()) {
			driver.get(url);
		} else {
			driver.get(prop.getProperty("url"));
		}
		
	}
	
	
	
	
	
	
	
	

}
