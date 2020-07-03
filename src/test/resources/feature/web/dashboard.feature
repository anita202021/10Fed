Feature: Dashboard Management
  As a client user
  I can land on dashboard

  Background:
    Given User is on work order sign in page
    When User sign in with valid credential of Account Owner

  Scenario: To verify that upon signing in the application user is landed on the dashboard
    Then User successfully logged in and Dashboard page displayed

  Scenario: verify GUI components of Work order dashboard
    Given User is on the "Dashboard" page
    Then User should be able to see the widgets
      | Work Order | Kiosk Health Status | Activity Log | Offline Kiosk Log |
    Then User should be able to see the workorder tiles
      | Not Started | In Progress | On Hold | Closed | Complaints |
    Then User should be able to see the company tiles
      | Administrator | Personnel | Facilities | Vendors |
    Then User should be able to see the components of Kiosk Heath Status
    Then User should be able to see the components of Offline Kiosk Log


  Scenario Outline: To verify that upon tapping the management tile user should be redirected to the respective list
    When User taps on company "<module>" tile
    Then User should be redirected to the "<List>" list screen
    Examples:
      | module     | List           |
      | Admin      | Administrators |
      | Personnel  | Personnel      |
      | Facilities | Facilities     |
      | Vendors    | Vendors        |


  Scenario Outline: To verify that correct count is displayed in the work order tiles
    Given User observes the "<workOrderTile>"count displayed
    When User clicks on the "<workOrderTile>" tile
    Then User verifies the number of work order in the list

    Examples:
      | workOrderTile     |
      | Total Work Orders |
      | Not Started       |
      | In Progress       |
      | On Hold           |
      | Closed            |
      | Complaints        |

  Scenario Outline: To verify that correct count is displayed in the company tiles
    Given User observes the company "<module>"count displayed
    When User taps on company "<module>" tile
    Then User verifies the number displayed in the list
    Examples:
      | module              |
      | Total Administrator |
      | Total Personnel     |
      | Total Facilities    |
      | Total Vendors       |






