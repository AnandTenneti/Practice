Feature: Customers

  Background: Login with valid user credentials
    When User opens URL 'http://admin-demo.nopcommerce.com/login'
    And User enters email as "admin@yourstore.com" and Password as "admin"
    And click on Login
    Then User can view Dashboard

  @End2End
  Scenario: Add a new customer order
    When User clicks on customers menu
    And click on customers Menu Item
    And click on Add new button
    Then User can view Add new customer page
    When User enter customer info
    And click on Save button
    Then User can view configuration message "The new customer has been added successfully"

  @Validation
  Scenario: Validate invalid email address
    When User clicks on customers menu
    And click on customers Menu Item
    And click on Add new button
    Then User can view Add new customer page
    When user enters invalid email address
    And click on Save button
    Then User can view validation message "Please enter a valid email address"

  @End2End
  Scenario: Delete an existing customer
    When User clicks on customers menu
    And click on customers Menu Item
    And Enter customer Email
    When click on Search button
    Then User should find Email in the Search table
    When select the result and click on Delete button
    Then User can view configuration message "The customer has been deleted successfully"


  Scenario: Search customer by EmailId
    When User clicks on customers menu
    And click on customers Menu Item
    And Enter customer Email
    When click on Search button
    Then User should find Email in the Search table

  Scenario: Search customer by Name
    When User clicks on customers menu
    And click on customers Menu Item
    And Enter customer Firstname
    And Enter customer LastName
    When click on Search button
    Then User should find Name in the Search table

  @Regression
  Scenario:  Add new product
    When user clicks on Catalog menu
    And user clicks on Products menu item
    And user clicks on Add new button
    Then user can view Add new product page
    When user enter product info
    And click on Product Save button
    Then User can view product configuration message "The new product has been added successfully"

  @Regression
  Scenario:  Search new product by Product Name
    When user clicks on Catalog menu
    And user clicks on Products menu item
    And Enter Product Name
    When click on Search button in Products

  Scenario: Import Products
    When user clicks on Catalog menu
    And user clicks on Products menu item
    And click on Import button

  @Products
  Scenario: Export Products
    When user clicks on Catalog menu
    And user clicks on Products menu item
    And click on Export button with selected products option
    Then User can view 'No products selected' message is displayed




