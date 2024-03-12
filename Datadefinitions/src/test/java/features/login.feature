@Multiple_InValidCredentials
Feature: Invalid Login

  Scenario: Login with invalid credentials - Data Table with Header and Multiple Rows

    Given User is on HRMLogin page
    Then User enters invalid credentials and Login will be unsuccessful with custom error messages
      | Username | Password  | ErrorMessage        |
      | Admin1   | admin123! | Invalid credentials |
      | Admina   | admin123a | Invalid credentials |