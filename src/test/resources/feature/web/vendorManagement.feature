@Phase1
Feature: Vendor Management
  As a client user I can land on Vendor page
  So that I can manage Vendors of the Company

  Background:
    Given User is on work order sign in page
    When User sign in with valid credential of Account Owner
    Then User tap on the "Vendors" link from side navigation

  Scenario: Create a vendor and cross verify the detail entered, notification and activity log
    Given User is on add vendor screen
    When User enters all the field
    And User taps on the Submit button
    Then Success message "Vendor has been added successfully" should be displayed
    And User verify vendor detail screen
    When User tap on the "Dashboard" link from side navigation
    Then Activity log for vendor creation is displayed
    When User logout from work order platform
    When User sign in with valid credential of Client Admin
    When User tap on the bell icon
    Then Notification for vendor creation is displayed

  Scenario: To verify validations on add vendor screen
    Given User logout from work order platform
    When User sign in with valid credential of Account Owner
    And User tap on the "Vendors" link from side navigation
    Given User is on add vendor screen
    When User taps on the Submit button
    Then Error message should be displayed
      | Vendor name is required | Vendor type is required | Contact number is required | Location is required | Account Number is required |
    And User clicks on Cancel button

  Scenario: Edit an existing vendor from vendor detail screen and cross verify the modification
    Given User has created a new vendor and reaches to the detail screen
    When User clicks on edit option from action dropdown
    And User updates all the field of vendor form
    And User taps on the Submit button
    Then Success message "Vendor has been updated successfully" should be displayed
    And User verify vendor detail screen
    When User tap on the "Dashboard" link from side navigation
    Then Activity log for existing vendor update creation is displayed
    When User sign in with valid credential of Client Admin
    And User tap on the bell icon
    Then Notification for existing vendor edited is displayed

  Scenario: Adding and editing a note to the Vendor
    Given User is on detail screen
    When User clicks on Notes option from action dropdown
    And User enter a note
    Then Success message "Note has been added successfully" should be displayed
    When User clicks on edit note icon
    And User enter a note
    Then Success message "Note has been edit successfully" should be displayed

  Scenario: Notes count associated with a vendor
    Given User is on detail screen
    When User reaches to notes screen
    Then Notes count is same as the number of notes listed below

  Scenario: To verify the functionality of "Delete" button on the detailed view page and verify notification and activity log
    Given User has created a new vendor and reaches to the detail screen
    When User clicks on delete button
    And User clicks on 'OK' option in the confirmation popup
    Then Success message "Vendor has been deleted successfully" should be displayed
    When User tap on the "Dashboard" link from side navigation
    Then Activity log for existing vendor deleted is displayed
    When User sign in with valid credential of Client Admin
    And User tap on the bell icon
    Then Notification for existing vendor deleted is displayed

  Scenario: To verify the change and remove functionality of vendor profile picture
    Given User is on add vendor screen
    When User enters all the field
    And User taps on the Submit button
    And User verify vendor detail screen
    Then user change the profile picture
    Then user  remove the profile picture

  Scenario: Edit an existing vendor from vendor list screen and cross verify the modification
    Given User navigates to edit page from list screen
    When User updates all the field of vendor form
    And User taps on the Submit button
    Then Success message "Vendor has been updated successfully" should be displayed
    And User verify vendor detail screen

  Scenario Outline: To verify pagination on vendor list screen
    Given User gets the total count from the list
    Then  User verify pagination with "<countPerPage>" per page
    Examples:
      | countPerPage |
      | 10           |
      | 15           |
      | 25           |
      | 50           |
      | 100          |

  Scenario: To verify the functionality of "Delete" icon on the list view page
    When User clicks on delete icon
    And User clicks on 'OK' option in the confirmation popup
    Then Success message "Vendor has been deleted successfully" should be displayed

  Scenario: Filter the vendor list upon selecting vendor type
    When User clicks on Select dropdown and select a vendor type
    Then Vendor list is filtered out
    When User clicks on Reset button

  Scenario: User should be able to search when he enters the keyword and clicks on 'Filter' button
    When User enters a keyword "Vendor" in the search field
    And User clicks on Filter button
    Then Vendor list displayed is according to the entered keyword
    And User clicks on Reset button

  Scenario: User should be able to search when he enters the keyword and hits ‘Enter’ button on keyboard
    When User enters a keyword "Vendor" in the search field
    And User hits 'Enter' button on keyboard
    Then Vendor list displayed is according to the entered keyword
    And User clicks on Reset button

  Scenario: To verify that client personnel is not able to access add, edit and delete feature
    Given User logout from work order platform
    When User sign in with valid credential of Client Personnel
    And User tap on the "Vendors" link from side navigation
    Then Add Vendor button should not be visible to client personnel
    Then Action column should not be visible to client personnel