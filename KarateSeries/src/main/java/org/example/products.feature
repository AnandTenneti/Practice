Feature: check products returned by API

  Background:
    * url 'https://simple-grocery-store-api.glitch.me'
    * header Accept = 'application/json'

  Scenario: Get the list of all products
    Given path '/products'
    When method GET
    Then status 200
    And match response == "#notnull"
    * print response[0].id

    Scenario: Get the product details
      Given path

  Scenario: Get the categories list

    * def jsonBody =
 """
{
 "category": {
    "id": 1,
    "name": "cats"
 },
 "name": "kitty",
 "photoUrls": [
   "www.kitty.com"
  ],
 "tags": [
   {
     "id": 0,
     "name": "sweet"
   }
  ],
 "status": "available"
}
 """
    Given url 'https://petstore.swagger.io/v2'
    And path 'pet'
    And request jsonBody
    When method POST
    Then status 200
    And match response.category == jsonBody.category
    And match response.id == '#present'
    And match response.name == jsonBody.name
    And match responseHeaders['Date'] == '#notnull'