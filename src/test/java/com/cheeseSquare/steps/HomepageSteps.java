package com.cheeseSquare.steps;

import com.cheeseSquare.helpers.CommonActions;
import com.cheeseSquare.screens.HomeScreen;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class HomepageSteps extends CommonActions {

    HomeScreen homeScreen = new HomeScreen();

    @Given("^I am on cheese square app$")
    public void iAmOnCheeseSquareApp() throws Throwable {
        waitForAppToLoad();

    }

    @Then("^I check all the (\\d+) categories of cheese are displayed$")
    public void iCheckAllTheCategoriesOfCheeseAreDisplayed(int categoryValue) throws Throwable {
        homeScreen.checkAllCategoryAreDisplayed(categoryValue);
    }
}
