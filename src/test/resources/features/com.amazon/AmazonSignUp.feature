@amazon
Feature: Testing Amazon SignUp Functionality

  Background: navigate

  Scenario: Amazon SignUP with DataBase
    When the user clicks the sign in and create your amazon account button
    Then the user validate the header
      | Create account |
    And the user provides the information:
      | ahmet           |
      | ahmet@gmail.com |
      | ahmet123        |
      | ahmet123        |
