@Homepage
Feature: Check cheese square app functionality

  @Category
  Scenario: Check if all the 3 categories of cheese are displayed
    Given I am on cheese square app
    Then I check all the 3 categories of cheese are displayed


  Scenario:  Check if all the 3 sections are displayed for the selected cheese
    Given I am on cheese square app

  Scenario: Change the mode to Night(Always)
    Given I am on cheese square app