Feature: Put API automation

  Scenario: Test PUT service
    Given url 'https://reqres.in/api/users/2'
    Then request {"name":"morpheus", "job":"zion resident"}
    Then method PUT
    Then status 200
    And print response
