@UI
Feature: Login page feature

  Scenario: To test the title of page
    Given user is on login page
    When user gets the title of page
    Then page title should be "Login - My Store"

  Scenario: Forgot password link
    Given user is on login page
    Then forgot your password link should be displayed

  Scenario: Successfull login
    Given user is on login page
    When user enters username "ayush345@gmail.com" and password "12345678"
    And user gets the title of page
    Then page title should be "My account - My Store"