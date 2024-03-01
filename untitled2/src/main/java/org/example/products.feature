Feature: check products list by API

  Background:
    * url 'https://simple-grocery-store-api.glitch.me'
    * header Accept = 'application/json'

  Scenario: Get the status of the URL
    Given path '/status'
    When method GET
    Then status 200
    And match response contains {"status" :"UP"}

  Scenario: Get the list of all products
    Given path '/products'
    When method GET
    Then status 200
    And match response contains {"id":4643,"category":"coffee","name":"Starbucks Coffee Variety Pack, 100% Arabica","inStock":true},