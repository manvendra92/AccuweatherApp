package com.accuWeather.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static com.accuWeather.utils.PropertyReader.getProperties;

/**
 * Created by Manvendra Singh
 */

public class InitiateDriver
{
    private AppiumDriver appiumDriver;
    private Proxy proxy;

    /**
     * initiate driver depend upon BROWSER and URL value in config.properties file
     */
    public InitiateDriver()
    {
        try
        {
            String runOn = System.getProperty("runOn") == null ? getProperties().get("RUN_ON") : System.getProperty("runOn");
            String platform = System.getProperty("platform") == null ? getProperties().get("PLATFORM") : System.getProperty("platform");
            String browser = null;
            String appUrl=System.getProperty("androidAppUrl") == null ? getProperties().get("AndroidAppURL") : System.getProperty("androidAppUrl");

            if(platform.equalsIgnoreCase("ANDROID"))
            {

                if (runOn.equalsIgnoreCase("ANDROID_APP")) {
                    appiumDriver = new AndroidDriver(new URL(appUrl), getBrowserCapabilities( runOn));
                    appiumDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
                }

            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }


    /**
     * get appium driver
     * @return
     */
    public AppiumDriver getAppiumDriver()
    {
        if (appiumDriver == null)
            throw new RuntimeException("We have not instantiated the driver.");
        return appiumDriver;
    }

    /**
     * get desired capabilities of browser
     * @param runOn
     * @return DesiredCapabilities
     */
    private DesiredCapabilities getBrowserCapabilities( String runOn)
    {
        DesiredCapabilities capabilities = null;
        String androidAppName = System.getProperty("androidAppName") == null ? getProperties().get("androidAppName") : System.getProperty("AndroidAppName");
        String androidAppPath =System.getProperty("androidAppPath") == null ? getProperties().get("androidAppPath") : System.getProperty("AndroidAppPath");
        try
        {

            if (runOn.equalsIgnoreCase("ANDROID_APP"))
            {

                File appDir = new File(androidAppPath);
                File app = new File(appDir, androidAppName);
                capabilities=new DesiredCapabilities();
                capabilities.setCapability("deviceName", "Moto G4 Plus");
                capabilities.setCapability("platformName", "Android");
                capabilities.setCapability("autoGrantPermissions", "true");
                capabilities.setCapability("app", app.getAbsolutePath());
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return capabilities;
    }

}
