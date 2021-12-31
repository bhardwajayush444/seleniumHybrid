@UI
Feature: To test the Account page
  Background:
    Given user is on login page
    When user enters username "ayush345@gmail.com" and password "12345678"
    And user gets the title of page
    Then page title should be "My account - My Store"

  Scenario: To test the section on my account page
    Given user is on Account page
    Then user gets the account sections
    |ORDER HISTORY AND DETAILS|
    |MY CREDIT SLIPS|
    |MY ADDRESSES|
    |MY PERSONAL INFORMATION|
    |MY WISHLISTS|
    |Home|