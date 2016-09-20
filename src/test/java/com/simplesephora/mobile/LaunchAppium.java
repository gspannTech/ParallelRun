package com.simplesephora.mobile;

import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class LaunchAppium {
	public AppiumDriver driver;
	private  String platformUsed;
	
	Properties prop = new Properties();
	InputStream input = null;

	
	@Test
	public void launchApp() throws Exception{
		

		input = new FileInputStream("config.properties");

		// load a properties file
		prop.load(input);

		// get the property value and print it out
//		System.out.println(prop.getProperty("database"));
//		System.out.println(prop.getProperty("dbuser"));
//		System.out.println(prop.getProperty("dbpassword"));



		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("device", "Android");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "6.0.1");
		capabilities.setCapability("deviceName", "android");
		capabilities.setCapability("browserName", "chrome");
		
		capabilities.setCapability("newCommandTimeout", 5000);

		URL remoteUrl = new URL("http://" + "127.0.0.1:4723" + "/wd/hub");
		System.out.println("Remote URL is " + remoteUrl);
		driver = new AndroidDriver(remoteUrl, capabilities);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://m-qa.sephora.com");
	
	}
	
	@AfterTest(alwaysRun = true)
	public void tearDown() throws Exception {
		driver.quit();
	}
}
