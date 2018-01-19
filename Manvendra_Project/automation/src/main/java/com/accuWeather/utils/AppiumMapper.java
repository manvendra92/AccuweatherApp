package com.accuWeather.utils;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.HashMap;


/**
 * Created by Manvendra Singh
 */
public class AppiumMapper {
    private HashMap<String, String> map;
    private AppiumDriver driver;
    private XMLReader xmlReader;

    public AppiumMapper(AppiumDriver driver) {
        this.driver = driver;
        xmlReader = new XMLReader();
    }

    /**
     * find and return WebElement corresponding to element
     *
     * @param fileName
     * @param element
     * @return WebElement
     */
    public WebElement find(String fileName, String element) {
        WebElement webElement = null;
        map = xmlReader.getDOMElements(fileName, element);

        while (!map.isEmpty()) {
            try {
                webElement = driver.findElement(getBy());
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }
        }

        return webElement;
    }

    /**
     * get By
     *
     * @return By
     */
    private By getBy() {
        By by = null;

        if (map.containsKey("id")) {
            by = By.id(map.get("id"));
            map.remove("id");
        }
        else if (map.containsKey("name")) {
            by = By.name(map.get("name"));
            map.remove("name");
        }
        return by;
    }

}
