Feature: Testing Swag Labs LogIn Functionality

  Background:
    Given I am on the Sauce Demo Login Page

  Scenario Outline: Successful Login
    When I fill the account information for account StandardUser into the "<Username>" field and the "<Password>" field
    And I click the Login Button
    Then I am redirected to the Sauce Demo Main Page
    And I verify the App Logo exists
    Examples:
      | Username      | Password     |
      | standard_user | secret_sauce |

  Scenario Outline: Failed Login
    When I fill the account information for account LockedOutUser into the "<username>" field and the "<password>" field
    And I click the Login Button
    Then I verify the Error Message contains the text "Sorry, this user has been banned."
    Examples:
      | username        | password     |
      | locked_out_user | secret_sauce |


