package com.cheeseSquare.screens;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.cheeseSquare.helpers.CommonActions.driver;

public class HomeScreen {
    public HomeScreen() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//android.widget.TextView[@text='CATEGORY 1']")
    private WebElement category1;

    @FindBy(xpath = "//android.widget.TextView[@text='CATEGORY 2']")
    private WebElement category2;

    @FindBy(xpath = "//android.widget.TextView[@text='CATEGORY 3']")
    private WebElement category3;

    public void checkAllCategoryAreDisplayed(int categorySize){
        Assert.assertTrue(category1.getText().equalsIgnoreCase("category 1"));
        Assert.assertTrue(category2.getText().equalsIgnoreCase("category 2"));
        Assert.assertTrue(category3.getText().equalsIgnoreCase("category 3"));
    }
}
