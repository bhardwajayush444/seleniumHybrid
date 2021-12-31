Feature: To test the jdbc connection using spring

  Scenario: To check if user is able to get student details from user
    Given when user tries to get data for student id 109
    Then user should be present in the database