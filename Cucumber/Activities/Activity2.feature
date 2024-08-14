@activity2
  Feature: Login Test

    Scenario: Testing Login
    Given user is on Login page
    When user enters username and password
    Then read the page title and confirmation message
    And close the Browser