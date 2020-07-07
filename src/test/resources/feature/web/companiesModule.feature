Feature: Company module

  Background:
    Given User is on work order sign in page
    When User sign in with valid credential of Super Admin
    And User tap on the "Companies" link from side navigation

  Scenario: To verify the redirection after clicks on the new company button
    Given user is on the company page of work order application
    When user clicks on the newcompany button
    Then user should redirects to the add company page

  Scenario: To verify the functionality of creating the company and cross verify the details and verify the redirection of each tab that is
  showing on Company deatil page in case when the user is login with admin
    Given user is on the company page of work order application
    When user clicks on the newcompany button
    And user fill the details for creating a new company
      | Name   | Address | Zip Code | Contact Number | Email   | Account Owner Name | Account Owner Email | Account Owner Contact Number |
      | tester | abcdhgg | 76872    | 87868786       | teste45 | test          | accountowner77      | 2874923                      |
    And user clicks on the submit
    Then Success message " Company has been added successfully. " should be displayed
    And cross verify the create details
    And User Clicks on the each tab showing on company detail page

  Scenario: Verify the a notification of Company creation for 10Fed admin
    Given user is on the company page of work order application
    When user clicks on the newcompany button
    And user fill the details for creating a new company
      | Name   | Address | Zip Code | Contact Number | Email   | Account Owner Name | Account Owner Email | Account Owner Contact Number |
      | tester | abcdhgg | 76872    | 878687868876   | teste45 | test7678           | accountowner77      | 2874923                      |
    And user clicks on the submit
    Then Success message " Company has been added successfully. " should be displayed
    Given User logout from work order platform
    When User sign in with valid credential of Ten Fed Admin
    When User tap on the "Companies" link from side navigation
    And User tap on the bell icon
    Then Notification for company creation is displayed

  Scenario:Verify the notification of User deactivation-activation for client admin
    Given user is on the company page of work order application
    When user clicks on the newcompany button
    And user fill the details for creating a new company
      | Name   | Address | Zip Code | Contact Number | Email   | Account Owner Name | Account Owner Email | Account Owner Contact Number |
      | tester | abcdhgg | 76872    | 878687868876   | teste45 | test7678           | accountowner77      | 2874923                      |
    And user clicks on the submit
    Then Success message " Company has been added successfully. " should be displayed
    And User click on side menu of "Companies" button
    And user click on the deactivate button for the company
    Then Success message " Company has been deactivated successfully. " should be displayed
    Given User logout from work order platform
    When User sign in with valid credential of Ten Fed Admin
    When User tap on the "Companies" link from side navigation
    When User tap on the bell icon
    Then Notification for Existing Company is  Deactivated is displayed

  Scenario: To verify the functionality of deleting the company in case when the user is login with admin
    Given user is on the company page of work order application
    When user clicks on the newcompany button
    And user fill the details for creating a new company
      | Name   | Address | Zip Code | Contact Number | Email   | Account Owner Name | Account Owner Email | Account Owner Contact Number |
      | tester | abcdhgg | 76872    | 878687868876   | teste45 | test7678           | accountowner77      | 2874923                      |
    And user clicks on the submit
    Then Success message " Company has been added successfully. " should be displayed
    And User click on side menu of "Companies" button
    And user delete the company
    And user clicks on the OK button for deleting the company
    Then Success message " Company has been deleted successfully. " should be displayed

  Scenario: To verify the functionality for edit the company
    When user clicks on the newcompany button
    And user fill the details for creating a new company
      | Name   | Address | Zip Code | Contact Number | Email   | Account Owner Name | Account Owner Email | Account Owner Contact Number |
      | tester | abcdhgg | 76872    | 878687868876   | teste45 | test7678           | accountowner77      | 2874923                      |
    And user clicks on the submit
    Then Success message " Company has been added successfully. " should be displayed
    And User click on side menu of "Companies" button
    And user clicks on the edit button of the company
    And user edit the Company details details
    And User taps on the Submit button
    Then Success message " Company has been updated successfully. " should be displayed
    Then verify data on company table


  Scenario Outline: To verify the validations for the fields on add company page in case when the user is login with admin
    Given user is on the company page of work order application
    When user clicks on the newcompany button
    And user check the validation on  add company page
      | name   | address   | zipCode   | contactNumber   | email   | accountOwnerName   | accountOwnerEmail   | accountOwnerContactNumber   |
      | <name> | <address> | <zipCode> | <contactNumber> | <email> | <accountOwnerName> | <accountOwnerEmail> | <accountOwnerContactNumber> |
    And user clicks on the submit
    Then The error message is displayed as "<errorMessage>"
    Examples:
      | name      | address | zipCode | contactNumber | email              | accountOwnerName | accountOwnerEmail | accountOwnerContactNumber | errorMessage                                          |
      | test36547 | abcder  | 2637387 | 7367436657    | gfh88@gmail.com    | test7347         | dsdgu8@gmail.com  |                           | Account owner contact number is required              |
      | test36547 | abcder  | 2637387 | 7367436657    | gfh88@gmail.com    | test7347         |                   | 73857845                  | Account owner email is required                       |
      | test36547 | abcder  | 2637387 | 7367436657    | gfh88@gmail.com    |                  | dsdgu8@gmail.com  | 73857845                  | Account owner name is required                        |
      | test36547 | abcder  | 2637387 | 7367436657    |                    | test7347         | dsdgu8@gmail.com  | 73857845                  | Email is required                                     |
      | test36547 | abcder  | 2637387 |               | gfh88@gmail.com    | test7347         | dsdgu8@gmail.com  | 73857845                  | Contact number is required                            |
      | test36547 | abcder  |         | 7367436657    | gfh88@gmail.com    | test7347         | dsdgu8@gmail.com  | 73857845                  | Zip code is required                                  |
      | test36547 |         | 2637387 | 7367436657    | gfh88@gmail.com    | test7347         | dsdgu8@gmail.com  | 73857845                  | Company address is required                           |
      |           | abcder  | 2637387 | 7367436       | gfh88@gmail.com    | test7347         | dsdgu8@gmail.com  | 73857845                  | Company name is required                              |
      | df        | abcder  | 2637387 | 7367436657    | gfh88@gmail.com    | test7347         | dsdgu8@gmail.com  | 45847578                  | Company name must be greater than 4 characters        |
      | df777     | a       | 2637387 | 7367436657    | gfh88@gmail.com    | test7347         | dsdgu8@gmail.com  | 45847578                  | Company address must be greater than 4 characters     |
      | dfyeyy    | abcder  | 26      | 7367436657    | gfh88@gmail.com    | test7347         | dsdgu8@gmail.com  | 45847578                  | Minimum 5 characters are required                     |
      | dfyeyy    | ab8788  | 267744  | 73            | gfh88@gmail.com    | test7347         | dsdgu8@gmail.com  | 894                       | Contact number must be in between 7 to 13 characters  |
      | dfyeyy    | ab78787 | 2637387 | 7367437676    | gfh                | test7347         | dsdgu8@gmail.com  | 894754878                 | Email address must be greater than 4 characters       |
      | dfyeyy    | ab7878  | 2637387 | 7367436657    | gfh88@gmail.com347 | test7347         | dgs               | 894754 7678               | Account owner email must be greater than 4 characters |

  Scenario: To verify the mendatory fields on add company page in case when the user is login with admin
    Given user is on the company page of work order application
    When user clicks on the newcompany button
    And user taps on the submit button
    Then Error message should be displayed
      | Company name is required | Company address is required | Zip code is required | Contact number is required | Email is required | Account owner name is required | Account owner email is required | Account owner contact number is required |

  Scenario: To verify the redirection when user clicks on the cancel button of add company page in case when the user is login with admin
    Given user is on the company page of work order application
    When user clicks on the newcompany button
    And user clicks on the cancel button
    Then user Should redirects to the companypage

  Scenario: To verify the functionality for editing the owner details in case when the user is login with admin
    Given user is on the company page of work order application
    When user clicks on the newcompany button
    And user fill the details for creating a new company
      | Name   | Address | Zip Code | Contact Number | Email   | Account Owner Name | Account Owner Email | Account Owner Contact Number |
      | tester | abcdhgg | 76872    | 878687868876   | teste45 | test               | accountowner77      | 2874923                      |
    And user taps on the submit button
    Then Success message " Company has been added successfully. " should be displayed
    And user clicks on the edit button for account owner details
    And user edit  the details
      | Account Owner Name | Account Owner Email | Account Owner Contact Number |
      | test               | accoun76owner76     | 28749                        |
    And user clicks on the submit
    Then Success message " Company owner has been updated successfully. " should be displayed
    And user clicks on the company
    Then user cross verify the Account owner details

  Scenario: To verify the functionality for deactivate  and activate the the company in case when the user is login with admin
    Given user is on the company page of work order application
    When user clicks on the newcompany button
    And user fill the details for creating a new company
      | Name   | Address | Zip Code | Contact Number | Email   | Account Owner Name | Account Owner Email | Account Owner Contact Number |
      | tester | abcdhgg | 76872    | 878687868876   | teste45 | test7678           | accountowner77      | 2874923                      |
    And user clicks on the submit
    Then Success message " Company has been added successfully. " should be displayed
    And User click on side menu of "Companies" button
    And user click on the deactivate button for the company
    Then Success message " Company has been deactivated successfully. " should be displayed
    When search filter by company
    And User clicks on Filter button
    And user click on the activate button for the company
    Then Success message " Company has been activated successfully. " should be displayed

  Scenario: User should able to search companyName in case when the user is login with admin
    When search filter by company
    And User clicks on Filter button
    And Verify Company on list
    And User clicks on Reset button

  Scenario: User should able to search with inValid company Name in case when the user is login with admin
    Given user is on the company page of work order application
    When search filter by inValid companyName
    And User clicks on Filter button
    Then Verify data on list

  Scenario: To verify when user select the status active than only active status should be displayed in the list in case when
  the user is login with admin
    Given user is on the company page of work order application
    When user select the status active from the dropdown
    And user clicks on the  pagination  from show entries dropdown
    Then All the staus active should be displayed to the user

  Scenario: To verify when user select the status inactive than only active status should be displayed in the list  in case when the
  user is login with admin
    When user select the status inactive from the dropdown
    And user clicks on the  pagination  from show entries dropdown
    Then All the staus inactive should be displayed to the user


  Scenario: To verify that when when user login with client personal than edit button is  visible to the user
    Given User logout from work order platform
    When User sign in with valid credential of Client Admin
    And User tap on the "Company" link from side navigation
    Then Edit button should visible to the  client admin



















































