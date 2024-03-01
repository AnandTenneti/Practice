Feature: check products list by API

  Background:
    * url 'https://api.trello.com'
    * header Accept = 'application/json'

  Scenario: Get the status of the URL
    Given path '/1/members/me/boards'
    And param key = '3334fd229d5a4a6848f8f698ec05c474'
    And param token = 'ATTA94b809cbce9648a047ce0fbf8a343b924d924bc6218c37930b0b44bc5cd8e470DDB45E2F'
    When method GET
    Then status 200
    #And match response contains {"status" :"UP"}

#  Scenario: Get the list of all products
#    Given path '/products'
#    When method GET
#    Then status 200
#    And match response contains {"id":4643,"category":"coffee","name":"Starbucks Coffee Variety Pack, 100% Arabica","inStock":true},