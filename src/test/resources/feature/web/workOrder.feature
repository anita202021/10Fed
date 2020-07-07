Feature: Work Order

  Background:
    Given User is on work order sign in page
    When User sign in with valid credential of Account Owner
    Then User tap on the "Work Orders" link from side navigation

  Scenario: Create a work order and cross verify the detail entered
    Given User is on add work order screen
    When User enters the mandatory fields in work order screen
    And User taps on the Submit button
    Then Success message "Work Order has been added successfully" should be displayed
    And User verify work order detail screen

  Scenario: Verify the validation on add work order screen and functionality of cancel button
    Given User is on add work order screen
    When User taps on the Submit button
    Then Error message should be displayed
      | Title is required | Description is required | Priority is required | Facility name is required | The unit name is required |
    And User clicks on Cancel button

  Scenario: Verify that client user is receiving notification and activity log on creating a WO
    Given A work order is created
    And User verify work order detail screen
    When User tap on the "Dashboard" link from side navigation
    Then Activity log for work order added is displayed
    When User logout from work order platform
    And User sign in with valid credential of Client Admin
    And User tap on the bell icon
    Then Notification for work order added is displayed

  Scenario: Edit a work order and cross verify the detail entered
    Given User is on the work order detail screen
    When User clicks on edit option from action dropdown
    When User enters all the field in work order screen
    And User taps on the Submit button
    Then Success message "Work Order has been updated successfully" should be displayed
    And User verify work order detail screen

  Scenario: Verify that client user is receiving notification and activity log on updating a WO

  Scenario: Verify the functionality of Cancel button of edit WO screen

  Scenario: Verify the functionality of add remove photo
    Given User is on add work order screen
    When User uploads an image to a work order
    Then Uploaded image is getting displayed on the screen
    And User removes the uploaded image

  Scenario: Verify that user can upload not more than 5 images to a work order
    Given User is on add work order screen
    When User uploads more than five images to a work order
    Then Success message "Maximum 5 photos can be uploaded" should be displayed

  Scenario: Verify that user is able to add and edit due date field

  Scenario: Verify that user is able to add and edit Watchers

  Scenario: Verify that client user is receiving notification and activity log on adding/removing assignee
  and category from a WO
    Given User is on the work order detail screen
    When User clicks on edit option from action dropdown
    And User selects an assignee to the work order
    And User clicks on edit option from action dropdown
    And User removes the assignee

  Scenario: Verify that user is able to update the status and priority of a WO from detail view screen
    Given User is on the work order detail screen
    When User updates the work order status and priority
    And User tap on the "Dashboard" link from side navigation
    Then Activity log for status update is displayed
    Then Activity log for priority update is displayed

    Scenario: Verify that user is not able to edit details of a closed WO
      Given User is on the work order detail screen
      And User updates the work order status to closed


