@Phase1
Feature: Login functionality for Work Order Web

  Background:
    Given User is on work order sign in page

  Scenario Outline: User valid Login with all user roles
    When User enter credentials and tap on the sign in button
      | userEmail   | password   |
      | <userEmail> | <password> |
    Then User successfully logged in and Dashboard page displayed
    And User logout from work order platform

    Examples:
      | userEmail                      | password     |
      | admin                          | Password@123 |
      | abhishek.tyagi@mailinator.com  | 1234567890   |
      | shefali@mailinator.com         | 1234567890   |
      | payalgaurche@gmail.com         | 1234567890   |
      | arpittyagi@mailinator.com      | 1234567890   |
      | anubhutipurohit@mailinator.com | 1234567890   |


  Scenario: Invalid User Login
    When User enter credentials and tap on the sign in button
      | userEmail        | password |
      | sachin@gmail.com | 1234567  |
    Then Error message "Invalid credential." is displayed

  Scenario Outline: User Login with invalid credentials
    When User enter credentials and tap on the sign in button
      | userEmail   | password   |
      | <userEmail> | <password> |
    Then the error message is displayed "<errorMessage>"

    Examples:
      | userEmail                  | password   | errorMessage         |
      | payal.gaur@successive.tech |            | Password is required |
      |                            | 1234567890 | Username is required |




