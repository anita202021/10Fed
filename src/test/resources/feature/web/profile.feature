Feature: Functionality of profile

  Background:
    Given User is on work order sign in page
    When User sign in with valid credential of Account Owner
    Then User tap on the "My Profile" link from side navigation

  Scenario:Verify the details showings in my profile
    Given user is on the profile page
    Then verify the profile details
      | First Name: | Last Name: | Email: | Phone: | Role: | Status: | Created On: | Company Account ID: | Facility Assigned: |

  Scenario:Edit the profile and verify that profile haas been updated and cross verify the Edit profile details
    Given user is on the profile page
    And  user click on the action button
    When I  clicking  on the "Edit" button
    Then user should to redirects to the edit page
    And Edit the profile details
      | First Name | Email                      | Phone       |
      | payal      | payal.gaur@successive.tech | 98475937456 |
    And  User taps on the Submit button
    Then Success message " Your profile has been updated successfully. " should be displayed
    Then user verify the Edit profile

  Scenario:User is on edit profile page and clicking on the cancel button
    Given user is on the profile page
    And  user click on the action button
    When I  clicking  on the "Edit" button
    And  User click on "Cancel" button
    Then user redirects to the profile page

  Scenario:To verify the validation on Edit profile page
    Given  user click on the action button
    When I  clicking  on the "Edit" button
    Then user should to redirects to the edit page
    And   user erase all the data from all the input box
    And  User clicks on submit button
    Then Error message should be displayed
      | First name is required | Email is required | Phone is required |

  Scenario:To verify when user enters wrong password in old password and enters same password in new password and confirm password
    Given user is on the profile page
    And  user click on the action button
    When I  clicking  on the " Change Password " button
    When  User user enter incorrect password in the old password and enter same password in the new password and confirm passwordfield
      | currentPassword | newPassword | confirmPassword |
      | 123456789       | 12345678    | 12345678        |
    And user taps on the submit button
    Then Error message should come "Please enter correct old password"

  Scenario: To verify the functionality of cancel button of change password field
    Given  user click on the action button
    When I  clicking  on the " Change Password " button
    And user tap on the cancel button
    Then user should redirects to the profile page

  Scenario: To verify the validations on the change password field
    When  user click on the action button
    And I  clicking  on the " Change Password " button
    And user taps on the submit button
    Then Error message should be displayed
      | Please enter old password | Please enter new password | Please enter new password |

  Scenario Outline: Change Password with invalid credentials
    When  user click on the action button
    And I  clicking  on the " Change Password " button
    When User enter change password details
      | currentPassword   | newPassword   | confirmPassword   |
      | <currentPassword> | <newPassword> | <confirmPassword> |
    Then The error message is displayed as "<errorMessage>"
    Examples:
      | currentPassword | newPassword | confirmPassword | errorMessage                                     |
      | 12345678        |             |                 | Please enter new password                        |
      | 12345678        | 98765432    |                 | Please enter password again                      |
      | 1234            | 1234        | 1234            | Minimum 8 characters are required                |
      | 12345678        | 98765432    | 12444444        | New password and confirm password does not match |
      | 1234            | 1456        | 2354            | Minimum 8 characters are required                |

  Scenario: To verify the upload, remove and change functionality of profile picture
    Given user is on the profile page
    Then User upload new profile picture
    Then user change the profile picture
    Then user  remove the profile picture

