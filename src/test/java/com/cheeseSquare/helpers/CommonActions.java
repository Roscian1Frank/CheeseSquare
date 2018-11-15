package com.cheeseSquare.helpers;

import com.cheeseSquare.steps.AppTestBase;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonActions {

    public static AppiumDriver driver;

    public CommonActions() {
        driver = AppTestBase.driver;
    }
    public void waitForAppToLoad(){
        try{
            WebDriverWait wait = new WebDriverWait(driver, 10);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
