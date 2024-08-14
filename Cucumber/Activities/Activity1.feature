@activity1
Feature: First Test

  Scenario: Opening a webpage using Selenium
    Given user is on Google Home Page
    When user types in Cheese and hits ENTER
    Then show how many search results were shown
    And close the browser