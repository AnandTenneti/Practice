Feature: Login to HRM Application

  Background:

  @ValidCredentials
  Scenario: Login with valid credentials - Data Table without Header

    Given User is on HRMLogin page
    When User enters valid credentials
      | Admin | admin123 |
    Then User should be able to login successfully and new page open

  @InValidCredential
  Scenario: Login with invalid credential - Header with Single Row

    Given User is in HRMLogin page
    Then User enters invalid credentials and Login will be unsuccessful with error message
      | Username  | Password   | ErrorMessage        |
      | Admin1    | admin123!$ | Invalid credentials |