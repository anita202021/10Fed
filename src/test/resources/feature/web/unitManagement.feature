Feature: Unit Management
  As a user I can land on the unit list page
  So that I can manage units of the facility

  Background:
    Given User is on work order sign in page
    When User sign in with valid credential of Account Owner
    And User tap on the "Facilities" link from side navigation
    Then User is on detail screen

  Scenario: Create a unit and cross verify the detail entered and activity log
    Given User is on add unit screen
    When User enters all the field in unit screen
    And User taps on the Submit button
    Then Success message "Unit has been added successfully" should be displayed
    And User verify unit detail screen
    When User tap on the "Dashboard" link from side navigation
    Then Activity log for unit creation is displayed


  Scenario: To verify validations on add unit screen
    Given User is on add unit screen
    When User taps on the Submit button
    Then Error message should be displayed
      | Unit name is required |
    And User clicks on Cancel button

  Scenario: Edit an existing unit from facility detail screen and cross verify the modification
    Given User navigates to edit page from list screen for unit
    When User enters all the field in unit screen
    And User taps on the Submit button
    Then Success message "Unit has been updated successfully" should be displayed
    And User verify unit detail screen

  Scenario: Edit an existing unit from unit detail screen and cross verify the modification, activity log and notification
    Given User is on detail screen
    When User clicks on edit option from action dropdown
    And User enters all the field in unit screen
    And User taps on the Submit button
    Then Success message "Unit has been updated successfully" should be displayed
    And User verify unit detail screen
    When User tap on the "Dashboard" link from side navigation
    Then Activity log for existing unit edited is displayed
    And User sign in with valid credential of Client Admin
    And User tap on the bell icon
    Then Notification for Existing Unit Edited is displayed

  Scenario: Deactivate and Activate unit from unit list screen
    When User clicks on "Deactivate" icon on list page
    Then Success message "Unit has been deactivated successfully." should be displayed
    When User clicks on "Activate" icon on list page
    Then Success message "Unit has been activated successfully." should be displayed

  Scenario: Deactivate user from unit detail screen and cross verify the status, activity log and notification
    When User fetches facility and unit name
    And User verify status and takes necessary actions to change the status
    Then User verified the changed status
    When User verify status and takes necessary actions to change the status
    Then User verified the changed status
    When User tap on the "Dashboard" link from side navigation
    Then Activity log for existing unit activated and deactivated is displayed
    And User tap on the bell icon
    Then Notification for Existing Unit deactivated is displayed

  Scenario Outline: Filter the unit list upon selecting status
    When User clicks on Select status dropdown
    And  User select "<status>" status
    Then List displayed is according to the selected "<status>" status
    And User clicks on Reset button
    Examples:
      | status   |
      | Active   |
      | Inactive |

  Scenario: User should be able to search when he enters the keyword and clicks on 'Filter' button
    When User enters a keyword "Unit" in the search field
    And User clicks on Filter button
    Then List displayed is according to the entered keyword
    And User clicks on Reset button

  Scenario: User should be able to search when he enters the keyword and hits ‘Enter’ button on keyboard
    When User enters a keyword "Unit" in the search field
    And User hits 'Enter' button on keyboard
    Then List displayed is according to the entered keyword
    And User clicks on Reset button

  Scenario: Create a unit by 10Fed user
    Given User logout from work order platform
    And User sign in with valid credential of Super Admin
    And User tap on the "Companies" link from side navigation
    And User tap on a company and taps on the facility tab
    When User add a new unit
    Then Success message "Unit has been added successfully" should be displayed
    And User logout from work order platform

  Scenario: Delete a unit by 10Fed user and verify the notification for existing user deleted
    Given User logout from work order platform
    And User sign in with valid credential of Super Admin
    Given User tap on the "Companies" link from side navigation
    And User tap on a company and taps on the facility tab
    When User is on detail screen
    And User fetches facility and unit name
    And User clicks on delete button
    And User clicks on 'OK' option in the confirmation popup
    Then Success message "Unit has been deleted successfully." should be displayed
    And User logout from work order platform
    When User sign in with valid credential of Account Owner
    And User tap on the bell icon
    Then Notification for Existing unit Deleted is displayed

