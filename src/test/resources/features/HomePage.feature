@Homepage
Feature: Check cheese square app functionality

  @Category
  Scenario: Check if all the 3 categories of cheese are displayed
    Given I am on cheese square app
    Then I check all the 3 categories of cheese are displayed
    And I check each category have a list of cheese

  @Sections
  Scenario:  Check if all the 3 sections are displayed for the selected cheese
    Given I am on cheese square app
    When I click on cheese
    Then I check all sections are displayed

  @ModeOptions
  Scenario: Change the mode to Night(Always)
    Given I am on cheese square app
    When I click on mode option menu
    Then I check night mode is enable