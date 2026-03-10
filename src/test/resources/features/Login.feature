Feature: Login Functionality
  As a user
  I want to be able to login to the application
  So that I can access secure features

  Scenario: Successful login with valid credentials
    Given the user is on the login page
    When the user enters valid credentials and submits
    Then the user should be logged in successfully
