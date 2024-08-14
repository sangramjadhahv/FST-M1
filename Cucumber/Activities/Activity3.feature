@activity3
  Feature: Testing with Tags

    @SimpleAlert, @SmokeTest
    Scenario: Testing with Simple Alert
    Given user is on the page
    When user clicks the Simple Alert button
    Then alert opens
    And read the text from it and print it
    And close the alert
    And close Browser

    @ConfirmAlert
    Scenario: Testing with Confirm Alert
    Given user is on the page
    When user clicks the Confirm Alert button
    Then alert opens
    And read the text from it and print it
    And close the alert with Cancel
    And close Browser

    @PromptAlert
    Scenario: Testing with Prompt Alert
    Given user is on the page
    When user clicks the Prompt Alert button
    Then alert opens
    And read the text from it and print it
    And write a custom message in it
    And close the alert
    And close Browser