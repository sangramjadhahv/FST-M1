@activity4
Feature: Login test

  Scenario: Testing Login without Examples
  Given User is on Login page
  When user enters "admin" and "password"
  Then Read the page title and confirmation message
  And Close the Browser