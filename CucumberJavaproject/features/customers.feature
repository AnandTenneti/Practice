Feature: Customers

  Background: Login with valid user credentials
    Given Launch chrome browser
    When User opens URL 'http://admin-demo.nopcommerce.com/login'
    And User enters email as "admin@yourstore.com" and Password as "admin"
    And click on Login
    Then User can view Dashboard

  Scenario: Add a new customer order
    When User clicks on customers menu
    And click on customers Menu Item
    And click on Add new button
    Then User can view Add new customer page
    When User enter customer info
    And click on Save button
    Then User can view configuration message "The new customer has been added successfully"
    And close browser

  Scenario: Search customer by EmailId
    When User clicks on customers menu
    And click on customers Menu Item
    And Enter customer Email
    When click on Search button
    Then User should find Email in the Search table
    And close browser

  Scenario: Search customer by Name
    When User clicks on customers menu
    And click on customers Menu Item
    And Enter customer Firstname
    And Enter customer LastName
    When click on Search button
    Then User should find Name in the Search table
    And close browser



