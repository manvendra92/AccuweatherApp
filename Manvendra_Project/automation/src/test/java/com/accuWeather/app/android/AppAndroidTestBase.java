package com.accuWeather.app.android;

import com.accuWeather.utils.InitiateDriver;
import io.appium.java_client.AppiumDriver;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


/**
 * Created by Manvendra Singh
 */

public class AppAndroidTestBase {

    protected AppiumDriver driver;
    protected Log logger;


    @BeforeMethod
    public void setUp() throws InterruptedException {

        try
        {
            logger = LogFactory.getLog(this.getClass().getName());
            InitiateDriver initiateDriver = new InitiateDriver();
            driver = initiateDriver.getAppiumDriver();

        }

        catch (Exception e)
        {
            System.out.println("In catch Block Before Method");
            e.printStackTrace();
        }

    }


    @AfterMethod
    public void tearDown(ITestResult result)
    {
        try
        {
            driver.closeApp();
            driver.quit();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    /**
     * function for sleep time
     * @param timeout
     */
    public void sleep(int timeout){
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}


