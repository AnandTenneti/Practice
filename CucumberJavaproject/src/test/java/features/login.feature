Feature: Testing Login functionality

#  Background:
#    When User opens "http://admin-demo.nopcommerce.com/login"
#    And   User enters email "admin@yourstore.com" and Password "admin"
#    And click on Login button
#
#  Scenario: Successful Login with Valid Credentials
#    Then  Page title should be "Dashboard / nopCommerce administration"
#    When  User clicks on Logout button
#    Then  Page title should be "Your store. Login"
##    And   Close browser

  Scenario: Successful Login with Valid Credentials (Data Table)
    When User opens URL 'http://admin-demo.nopcommerce.com/login'
    And user enters valid credentials
      | admin@yourstore.com | admin |
    And click on Login


  Scenario Outline: Login Data Driven
#    Given User launch chrome browser
    When  User opens URL 'http://admin-demo.nopcommerce.com/login'
    And   User enters Email as "<email>" and Password as "<password>"
    And   Click on Login
#    Then  Page title should be "Dashboard / nopCommerce administration"
    When  User clicks on Logout button
    Then  Page title should be "Your store. Login"
    And   Close browser

    Examples:
      | email                 | password |
      | admin@yourstore.com   | admin    |
      | admnin1@yourstore.com | admin    |
