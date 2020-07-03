Feature: Unit Management
  As an Account Owner and a client Admin
  I can land on facility detail page
  So that I can manage units of the facility

  Background:
    Given User is on work order sign in page
    When User sign in with valid credential of Account Owner
    And User tap on the "Facilities" link from side navigation
    Then User is on detail screen

  Scenario: Create a unit and cross verify the detail entered
    Given User is on add unit screen
    When User enters all the field in unit screen
    And User taps on the Submit button
    Then Success message "Unit has been added successfully" should be displayed
    And User verify unit detail screen

  Scenario: To verify validations on add unit screen
    Given User is on add unit screen
    When User taps on the Submit button
    Then Error message should be displayed
      | Unit name is required |
    And User clicks on Cancel button

  Scenario: Edit an existing unit from facility detail screen and cross verify the modification
    Given User navigates to edit page from list screen
    When User enters all the field in unit screen
    And User taps on the Submit button
    Then Success message "Unit has been updated successfully" should be displayed
    And User verify unit detail screen

  Scenario: Edit an existing unit from unit detail screen and cross verify the modification
    Given User is on detail screen
    When User clicks on edit option from action dropdown
    And User enters all the field in unit screen
    And User taps on the Submit button
    Then Success message "Unit has been updated successfully" should be displayed
    And User verify unit detail screen

  Scenario: Deactivate and Activate unit from unit list screen
    When User clicks on "Deactivate" icon on list page
    Then Success message "Unit has been deactivated successfully." should be displayed
    When User clicks on "Activate" icon on list page
    Then Success message "Unit has been activated successfully." should be displayed

  Scenario: Deactivate user from unit detail screen and cross verify the status
    Given User is on detail screen
    When User clicks on the action button
    And User verify status and takes necessary actions to change the status
    Then User verified the changed status
    And User clicks on the action button
    And User verify status and takes necessary actions to change the status
    Then User verified the changed status

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
    When User is on work order sign in page
    And User sign in with valid credential of Super Admin
    And User tap on the "Companies" link from side navigation
    And User tap on the newlane company and taps on the facility tab
    Then User is on detail screen
    Given User is on add unit screen
    When User enters all the field in unit screen
    And User taps on the Submit button
    Then Success message "Unit has been added successfully" should be displayed
