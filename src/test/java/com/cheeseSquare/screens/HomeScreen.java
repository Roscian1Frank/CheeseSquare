package com.cheeseSquare.screens;

import com.cheeseSquare.helpers.CommonActions;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.junit.Assert;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class HomeScreen extends CommonActions {
    public HomeScreen() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @FindBy(xpath = "//android.widget.TextView[@text='CATEGORY 1']")
    private AndroidElement category1;

    @FindBy(xpath = "//android.widget.TextView[@text='CATEGORY 2']")
    private AndroidElement category2;

    @FindBy(xpath = "//android.widget.TextView[@text='CATEGORY 3']")
    private AndroidElement category3;

    @FindBy(className = "android.support.v7.app.ActionBar$Tab")
    private List<AndroidElement> allCategory;

    @FindBy(xpath = "//android.widget.TextView[@index=1]")
    private List<AndroidElement> categoryList;

    @FindBy(xpath = "//android.widget.LinearLayout[@index=0]")
    private AndroidElement selectCheese;

    @FindBy(xpath = "//android.widget.TextView[@text='Info']")
    private AndroidElement infoSection;

    @FindBy(xpath = "//android.widget.TextView[@text='Friends']")
    private AndroidElement friendsSection;

    @FindBy(xpath = "//android.widget.TextView[@text='Related']")
    private AndroidElement relatedSection;

    @FindBy(xpath = "//android.widget.ImageView[@index=0]")
    private AndroidElement modeOptions;

    @FindBy(id = "submenuarrow")
    private AndroidElement subMenuButton;

    @FindBy(xpath = "//android.widget.TextView[@text='Night (always)']")
    private AndroidElement nightMode;

    @FindBy(xpath = "(//android.widget.RadioButton)[3]")
    private AndroidElement nightModeRadioButton;

    //checking category names are correct and they are visible on app
    public void checkAllCategoryAreDisplayed(int categorySize){
        softly.assertThat(category1.getText().equalsIgnoreCase("category 1")).isTrue();
        softly.assertThat(category2.getText().equalsIgnoreCase("category 2")).isTrue();
        softly.assertThat(category3.getText().equalsIgnoreCase("category 3")).isTrue();
        softly.assertThat(categorySize).isEqualTo(allCategory.size());
        softly.assertAll();
    }

    public void isCategoryListLoaded(){

        //Taping on each category and checking each category list is loaded
        for (AndroidElement element :allCategory) {
            Assert.assertTrue(isElementDisplay(5,element));
            element.click();

            //Getting cheese name and storing them in a list
            List<String>categoryNames =categoryList.stream().map(AndroidElement::getText).collect(Collectors.toList());

            //Checking category list is not empty
            Assert.assertTrue("category list is not loaded",categoryNames.size()>5);
        }
    }

    //Select a first cheese from category 1
    public void selectCheese(){
        Assert.assertTrue(isElementDisplay(10,selectCheese));
        selectCheese.click();
    }

    //soft assert will check all scenario and then create a list of failed ones
    public void checkSections(){
        softly.assertThat(isElementDisplay(10,infoSection)).isTrue();
        softly.assertThat(isElementDisplay(10,friendsSection)).isTrue();
        scroll();
        softly.assertThat(isElementDisplay(10,relatedSection)).isTrue();
        softly.assertAll();
    }

    //Open a mode option
    private void goToModeOptions(){
        Assert.assertTrue(isElementDisplay(10,modeOptions));
        modeOptions.click();
        Assert.assertTrue(isElementDisplay(10,subMenuButton));
        subMenuButton.click();
        Assert.assertTrue(isElementDisplay(10,nightMode));
    }

    //Click on night mode
    public void clickOnNightModeOption(){
        goToModeOptions();
        nightMode.click();
    }

    //Check night mode is selected
    public void isNightModeSelected(){
        goToModeOptions();
        boolean isNightModeSelected = Boolean.parseBoolean(nightModeRadioButton.getAttribute("checked"));
        Assert.assertTrue(isNightModeSelected);
    }
}
