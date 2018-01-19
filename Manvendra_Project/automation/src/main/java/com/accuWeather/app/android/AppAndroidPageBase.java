package com.accuWeather.app.android;

import com.accuWeather.utils.AppiumMapper;
import io.appium.java_client.AppiumDriver;


/**
 * Created by Manvendra Singh
 */
public class AppAndroidPageBase {

    private String fileName;
    private AppiumDriver driver;
    protected AppiumMapper Mapper;

    public AppAndroidPageBase(String fileName, AppiumDriver driver) {
        this.fileName = fileName;
        this.driver = driver;
        Mapper = new AppiumMapper(this.driver);
    }

    /*
        verify if element is present or not
     */
    protected boolean isElementPresent(String element) {
        try {
            if (Mapper.find(fileName, element) == null) {
                return false;
            }
            ;

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * function for sleep
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
