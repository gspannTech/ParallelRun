package com.simplesephora.mobile;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URISyntaxException;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.appium.manager.AppiumParallelTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class UserBaseTest extends AppiumParallelTest {



    @BeforeMethod() public void startApp(Method name) throws Exception {
        driver = startAppiumServerInParallel(name.getName());
        startLogResults(name.getName());
    }

    @AfterMethod() public void killServer(ITestResult result)
        throws InterruptedException, IOException {
        endLogTestResults(result);
        getDriver().quit();
        //deleteAppIOS("com.tesco.sample");
    }

    public AppiumDriver<MobileElement> getDriver() {
        return driver;
    }

    @BeforeClass() public void beforeClass() throws Exception {
        System.out.println("Before Class called" + Thread.currentThread().getId());
        System.out.println(getClass().getName());
        startAppiumServer(getClass().getSimpleName());
    }

    @AfterClass() public void afterClass() throws InterruptedException, IOException {
        System.out.println("After Class" + Thread.currentThread().getId());
        killAppiumServer();
    }

}
