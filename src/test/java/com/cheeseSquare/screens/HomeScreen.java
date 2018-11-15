package com.cheeseSquare.screens;

import com.cheeseSquare.helpers.CommonActions;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

import static com.cheeseSquare.helpers.CommonActions.driver;
import static com.cheeseSquare.helpers.CommonActions.softly;

public class HomeScreen extends CommonActions {
    public HomeScreen() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//android.widget.TextView[@text='CATEGORY 1']")
    private WebElement category1;

    @FindBy(xpath = "//android.widget.TextView[@text='CATEGORY 2']")
    private WebElement category2;

    @FindBy(xpath = "//android.widget.TextView[@text='CATEGORY 3']")
    private WebElement category3;

    @FindBy(className = "android.support.v7.app.ActionBar$Tab")
    private List<WebElement> allCategory;

    @FindBy(xpath = "//android.widget.LinearLayout[@index=0]")
    private WebElement selectCheese;

    @FindBy(xpath = "//android.widget.TextView[@text='Info']")
    private WebElement infoSection;

    @FindBy(xpath = "//android.widget.TextView[@text='Friends']")
    private WebElement friendsSection;

    @FindBy(xpath = "//android.widget.TextView[@text='Related']")
    private WebElement relatedSection;

    @FindBy(xpath = "//android.widget.ImageView[@index=0]")
    private WebElement modeOptions;

    @FindBy(id = "submenuarrow")
    private WebElement subMenuButton;

    @FindBy(xpath = "//android.widget.TextView[@text='Night (always)']")
    private WebElement nightMode;

    @FindBy(xpath = "(//android.widget.RadioButton)[3]")
    private WebElement nightModeRadioButton;

    public void checkAllCategoryAreDisplayed(int categorySize){
        softly.assertThat(category1.getText().equalsIgnoreCase("category 1")).isTrue();
        softly.assertThat(category2.getText().equalsIgnoreCase("category 2")).isTrue();
        softly.assertThat(category3.getText().equalsIgnoreCase("category 3")).isTrue();
        softly.assertThat(categorySize).isEqualTo(allCategory.size());
        softly.assertAll();
    }

    public void selectCheese(){
        Assert.assertTrue(isElementDisplay(10,selectCheese));
        selectCheese.click();
    }

    public void checkSections(){
        softly.assertThat(isElementDisplay(10,infoSection)).isTrue();
        softly.assertThat(isElementDisplay(10,friendsSection)).isTrue();
        scroll();
        softly.assertThat(isElementDisplay(10,relatedSection)).isTrue();
        softly.assertAll();
    }

    private void goToModeOptions(){
        Assert.assertTrue(isElementDisplay(10,modeOptions));
        modeOptions.click();
        Assert.assertTrue(isElementDisplay(10,subMenuButton));
        subMenuButton.click();
        Assert.assertTrue(isElementDisplay(10,nightMode));
    }

    public void clickOnNightModeOption(){
        goToModeOptions();
        nightMode.click();
    }

    public void isNightModeSelected(){
        goToModeOptions();
        boolean isNightModeSelected = Boolean.parseBoolean(nightModeRadioButton.getAttribute("checked"));
        Assert.assertTrue(isNightModeSelected);
    }
}
