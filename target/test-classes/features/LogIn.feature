@Regression
  Feature: This Feature is to test the Log In functionality of the application

    @LoginFunction
    Scenario: Verify that user is able to log in with valid credentials
      Given User is on the Log In page
      When User enters valid username and password
      And User clicks on the Log In button
      Then User should be logged in successfully