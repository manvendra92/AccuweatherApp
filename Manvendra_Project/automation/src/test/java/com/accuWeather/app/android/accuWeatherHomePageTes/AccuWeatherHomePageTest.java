package com.accuWeather.app.android.accuWeatherHomePageTes;

import com.accuWeather.app.android.AppAndroidTestBase;
import com.accuWeather.app.android.accuWeatherHomePage.AccuWeatherHomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Manvendra Singh
 */
public class AccuWeatherHomePageTest extends AppAndroidTestBase {

    @Test
    public void testForAccuWeatherHomePage() {

        AccuWeatherHomePage accuWeatherHomePage = new AccuWeatherHomePage(driver);

        accuWeatherHomePage.clickONIAgreeButton();
        accuWeatherHomePage.clickOnIAgreeButtonOnCurrentLocationPopUp();
        sleep(20000);
        Assert.assertTrue(accuWeatherHomePage.validateCurrentText(),"current text is not present");
        Assert.assertTrue(accuWeatherHomePage.validateCurrentConditionIcon(),"current condition icon is not present");
        Assert.assertTrue(accuWeatherHomePage.validateDegreeCelText(),"temp doesn't in degree celsius");
        String tempOnCurrentBlock = accuWeatherHomePage.getTempFromCurrentBlock();
        accuWeatherHomePage.selectCurrentBlock();
        sleep(2000);
        Assert.assertEquals(tempOnCurrentBlock,accuWeatherHomePage.getTempOnCurrentConditionPage(),"temp is mismatch on current block from current condition page");
    }




}
