Feature: Login Tests
  I want to have all login related scenarios in this feature file

	@smoke
  Scenario: Happy Path Login
    Given User landed on the homepage of AUT
    When User enters the credentials "sampletest@test.com" and "Test123"
    Then User should be logged in successfully

	@regression
  Scenario: Unhappy Path Login
    Given User landed on the homepage of AUT
    When User enters the credentials "sampletest@test.com" and "test123"
    Then User should see the error message
    
	@regression
  Scenario Outline: Multiple Logins
    Given User landed on the homepage of AUT
    When User enters the credentials "<Email>" and "<Password>"
    Then User should be logged in successfully

    Examples: 
      | Email                  | Password |
      | sampletest@test.com    | Test123  |
      | sampletest774@test.com | Test123  |
      | sampletest388@test.com | Test123  |
