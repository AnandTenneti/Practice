Feature: Demo Post API


  Background:
    * url 'https://reqres.in/api'
    * def requestBody = read('request_data.json')
    * def expectedResult = read('response.json')


  Scenario: Test Post API

    Given path '/users'
    Then request requestBody
    When method POST
    Then status 201
    And print response
    Then match $ contains {id:"#notnull"}
    Then match $ contains {id:"#string"}
#    Then match response contains {"name":"morpheus"}
    Then match response == {"name": "Anand","job": "manager","id": "#string","createdAt": "#ignore"}

  Scenario: Test Post API#2
    Given path '/users'
    Then request requestBody
    And set requestBody.job = "Developer"
    When method POST
    Then status 201
    And print response
    Then match $ contains {id:"#notnull"}
  Then match response == expectedResult


#  Scenario: Test set job to automation developer
#    Given  path '/users'
#    Then request = {"name":"Anand","position":"Automation"}
#    And set requestBody.name = "Test Automation"
#    When method POST
#    Then status 201
##    And print response
##    Then match $ contains {id:"#notnull"}