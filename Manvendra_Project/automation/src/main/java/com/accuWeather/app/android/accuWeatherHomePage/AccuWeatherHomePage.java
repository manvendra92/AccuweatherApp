package com.accuWeather.app.android.accuWeatherHomePage;

import com.accuWeather.app.android.AppAndroidPageBase;
import io.appium.java_client.AppiumDriver;

import static com.accuWeather.utils.PropertyReader.getProperties;

/**
 * Created by Manvendra Singh
 */
public class AccuWeatherHomePage extends AppAndroidPageBase {

    private static final String domFile = getProperties().get("ACCUWEATHER_DOM_FILE");
    public AccuWeatherHomePage(AppiumDriver driver) {
        super(domFile, driver);
    }


    /**
     * function to click on agree button
     */

    public void clickONIAgreeButton(){
        Mapper.find(domFile,"agreeButton").click();
    }

    /**
     * function to click on I agree button on current location popup
     */
    public void clickOnIAgreeButtonOnCurrentLocationPopUp(){
        Mapper.find(domFile,"agreeButtonOnCurrentLocationPopup").click();
    }

    /**
     * function to validate current text
     */
    public boolean validateCurrentText(){

        return isElementPresent("currentText") ;
    }

    /**
     * function to validate current condition icon
     */
    public boolean validateCurrentConditionIcon(){

        sleep(1000);
        return isElementPresent("currentConditionIcon");
    }

    /**
     * function to validate temp in degree celsius
     */
    public boolean validateDegreeCelText(){
        return isElementPresent("celsiusText");
    }

    /**
     * function to get temp of current block
     */
    public   String getTempFromCurrentBlock(){
        String temp = Mapper.find(domFile,"tempText").getText();
        return  temp ;
    }

    /**
     * function to click on current block
     */
    public void selectCurrentBlock(){
        Mapper.find(domFile,"currentBlock").click();
    }

    /**
     * function to get  temp on current condition page
     */
    public String getTempOnCurrentConditionPage(){

        String tempOnCurrentConditionPage = Mapper.find(domFile,"tempOnCurrentConditionPage").getText();
        return tempOnCurrentConditionPage ;

    }




}
