Feature: Demo API testing using Karate Framework

  Background:
    *  url 'https://reqres.in/api'
    * header Accept = 'application/json'

  Scenario: Get Api testing
    Given path '/users/2'
    When method  GET
    Then status 200

  Scenario: Get Api testing session#2
    Given path '/users/2'
    When method  GET
    Then status 200



  Scenario: Get Api testing session#3
    Given path '/users/'
    And   params page=2
    When method  GET
    Then status 200
    And print response
    And match response.data[0].first_name == 'George'
    And assert response.data[0].email == 'george.bluth@reqres.in'
