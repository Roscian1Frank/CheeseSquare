package com.cheeseSquare.helpers;

import com.cheeseSquare.steps.AppTestBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommonActions {

    public static AppiumDriver driver;

    public static SoftAssertions softly = new SoftAssertions();

    int count = 0;

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

    public void scroll() {
        new TouchAction(driver).press(PointOption.point(400, 1300)).waitAction()
                .moveTo(PointOption.point(0, 500)).release().perform();
    }

    public boolean isElementDisplay(long timeInSeconds, WebElement display_ele) {
        try {
            Wait<WebDriver> wait1 = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(timeInSeconds))
                    .pollingEvery(Duration.ofSeconds(1))
                    .ignoring(StaleElementReferenceException.class)
                    .ignoring(NoSuchElementException.class);
            WebElement element = wait1.until(ExpectedConditions.visibilityOf(display_ele));
            if (element != null && element.isDisplayed())
                return true;
            else
                return false;
        } catch (Exception e) {
            return false;
        }
    }
}
