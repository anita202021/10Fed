Feature: Functionality of signage application

  Background:
    Given User is on work order sign in page
    When User sign in with valid credential of Account Owner
    And User click on side menu of "Manage Kiosk" button

  Scenario: To verify user redirects to the kiosk page
    Given user is on the manage kiosk page of workorder application
    Then  user should redirects to the kiosk page

  Scenario: To verify the registration of new kiosk application
    Given user is on the manage kiosk page of workorder application
    And user clicks on register new kiosk button
    And User clicks on Select dropdown and select a facility
    And user enters the registration key and tag field
      | registrationKey | tag          |
      | 485907          | 415485907215 |
    And user clicks on the configure  button
    Then error message should be come " Registration key already used "

  Scenario: To verify the registration of new kiosk application for already used key
    Given user is on the manage kiosk page of workorder application
    And user clicks on register new kiosk button
    And User clicks on Select dropdown and select a facility
    And user enters the registration key and tag field
      | registrationKey | tag    |
      | 415215          | 415215 |
    And user clicks on the configure  button
    Then Success message " Kiosk has been registered successfully. " should be displayed
    And user redirects to the managekioskpage

  Scenario: To verify the validations on the Register kiosk page
    Given user is on the manage kiosk page of workorder application
    And user clicks on register new kiosk button
    And user clicks on the configure  button
    Then Error message should be displayed
      | Facility is required | Registration key is required | Tag is required |

  Scenario: To verify the functionality of show entries dropdown in list view of manage kiosk
    Given user is on the manage kiosk page of workorder application
    And user clicks on the  pagination  from show entries dropdown


  Scenario: To verify the functionality of delete tag
    Given user is on the manage kiosk page of workorder application
    And user delete the tag from the list

  Scenario: To verify the Functionality of each pages
    Given user is on the dashboard page of workorder application
    And User click on side menu of "Manage Kiosk" button
    Then verify the functionality of pagination

  Scenario: To verify user is able to upload the  png type content from signage application
    Given user is on the manage kiosk page of workorder application
    And user selects the tag kiosk page
    And user clicks on the upload content or manage content button
    And  user upload the image type content in the upload content field
      | image    |
      | JEEG.jpg |
    And user fills all the details
      | title   | description | internalDescription |
      | shefali | testing1234 | testing12345        |
    And user clicks  on the submit button
    Then Success message " Signage content has been added successfully. " should be displayed


  Scenario: To verify user is able to upload the  jpeg type content from signage application
    Given user is on the manage kiosk page of workorder application
    And user selects the tag kiosk page
    And user clicks on the upload content or manage content button
    And  user upload the image type content in the upload content field
      | image   |
      | png.png |
    And user fills all the details
      | title   | description | internalDescription |
      | shefali | testing1234 | testing12345        |
    And user clicks  on the submit button
    Then Success message " Signage content has been added successfully. " should be displayed


  Scenario: To verify user is able to upload the  video type content from signage application and upload Jpg file in thumbnail
    Given user is on the manage kiosk page of workorder application
    And user selects the tag kiosk page
    And user clicks on the upload content or manage content button
    And  user upload the content in choose file
      | content   |
      | video.mp4 |
    And  user upload the image type content in thumbnail field
      | image    |
      | JEEG.jpg |
    And user fills all the details
      | title   | description | internalDescription |
      | shefali | testing1234 | testing12345        |
    And user clicks  on the submit button
    Then Success message " Signage content has been added successfully. " should be displayed

  Scenario: To verify user is able to upload the  pdf type  content from signage application
    Given user is on the manage kiosk page of workorder application
    And user selects the tag kiosk page
    And user clicks on the upload content or manage content button
    And  user upload the content in choose file
      | content |
      | pdf.pdf |
    And user fills all the details
      | title   | description | internalDescription |
      | shefali | testing1234 | testing12345        |
    And user clicks  on the submit button
    Then Success message " Signage content has been added successfully. " should be displayed

  Scenario: Verify the functionality of delete file
    Given user is on the manage kiosk page of workorder application
    And user selects the tag kiosk page
    And user clicks on the upload content or manage content button
    And user clicks on the addcontent button
    And  user upload the image type content in the upload content field
      | image    |
      | JEEG.jpg |
    And User clicks on the delete fileicon

  Scenario: To verify when user clicks on the cancel button on add content field
    Given user is on the manage kiosk page of workorder application
    And user selects the tag kiosk page
    And user clicks on the upload content or manage content button
    And user clicks on the  Cancel button
    Then user should redirects to the  Manage Signage page

  Scenario: To verify the Validations  on the Add content page
    Given user is on the manage kiosk page of workorder application
    And user selects the tag kiosk page
    And user clicks on the upload content or manage content button
    And user clicks  on the submit button
    Then Error message should be displayed
      | Content is required | Title is required | Description is required |

  Scenario: To verify user is able to edit the content
    Given user is on the manage kiosk page of workorder application
    And user selects the tag kiosk page
    And user clicks on manage button
    And user clicks on the Edit button
    And user clicks on the Change file  button
    And  user upload the image type content in the upload content field
      | image   |
      | png.png |
    And user Edit the content details
      | title   | description  | internalDescription |
      | shefali | testing12345 | testing12345        |
    And user clicks  on the submit button
    Then Success message " Signage content has been updated successfully. " should be displayed

  Scenario: To verify user is able to delete the content
    Given user is on the manage kiosk page of workorder application
    And user selects the tag kiosk page
    And user clicks on manage button
    And user clicks on the delete button
    Then Success message " Signage content has been deleted successfully. " should be displayed

  Scenario: To verify when user clicks on the cancel button of the delete popup
    Given user is on the manage kiosk page of workorder application
    And user selects the tag kiosk page
    And user clicks on manage button
    And user clicks on the cancel button of delete popup
    Then user should redirects to the  Manage Signage page

  Scenario: To verify the functionality of enablity of  toggle button and apply changes button of signage application
    Given user is on the manage kiosk page of workorder application
    And user selects the tag kiosk page
    And user check the functionality of toggle button
    And user clicks on apply changes button
    Then Success message " Changes has been applied successfully " should be displayed

  Scenario: To verify the that we are able to create a content for the same title in same tag
    Given user is on the manage kiosk page of workorder application
    And user selects the tag kiosk page
    And user clicks on the upload content or manage content button
    And  user upload the image type content in the upload content field
      | image   |
      | png.png |
    Then user enters the title and description
      | title   | description |
      | testing | testing     |
    And user clicks  on the submit button
    And user clicks on the addcontent button
    And  user upload the image type content in the upload content field
      | image   |
      | png.png |
    Then user enters the title and description again
    And user clicks  on the submit button
    Then Verify the error message

  Scenario: Presence of pagination of landing page plan list
    Given user is on the manage kiosk page of workorder application
    Given there are at least 10 existing tags on landing page
    Then I will check for presence of pagination on landing page

    Scenario: Registration key
      When User get the registration key list
      Then User verifies the registration key































