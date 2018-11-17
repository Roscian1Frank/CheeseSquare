package com.cheeseSquare.steps;

import com.cheeseSquare.helpers.CommonActions;
import com.cheeseSquare.screens.HomeScreen;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HomepageSteps extends CommonActions {

    HomeScreen homeScreen = new HomeScreen();

    @Given("^I am on cheese square app$")
    public void iAmOnCheeseSquareApp() throws Throwable {
        waitForAppToLoad();
        homeScreen.isAppLoaded();
    }

    @Then("^I check all the (\\d+) categories of cheese are displayed$")
    public void iCheckAllTheCategoriesOfCheeseAreDisplayed(int categoryValue) throws Throwable {
        homeScreen.checkAllCategoryAreDisplayed(categoryValue);
    }

    @And("^I check each category have a list of cheese$")
    public void iCheckEachCategoryHaveAListOfCheese() throws Throwable {
        homeScreen.isCategoryListLoaded();
    }

    @When("^I click on cheese$")
    public void iClickOnCheese() throws Throwable {
        homeScreen.selectCheese();
    }

    @Then("^I check all sections are displayed$")
    public void iCheckAllSectionsAreDisplayed() throws Throwable {
        homeScreen.checkSections();
    }

    @When("^I click on mode option menu$")
    public void iClickOnModeOptionMenu() throws Throwable {
        homeScreen.clickOnNightModeOption();
    }

    @Then("^I check night mode is enable$")
    public void iCheckNightModeIsEnable() throws Throwable {
        homeScreen.isNightModeSelected();
    }
}
