Feature: check returned countries by API

  Background:
    * url 'https://simple-grocery-store-api.glitch.me'
    * header Accept = 'application/json'

    Scenario: Get the list of all countries
      Given path '/products'
      When method GET
      Then status 200
