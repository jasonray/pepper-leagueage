Feature: Hello World
  As an user, I want to receive a greeting

  Scenario: Invoke hello world API
    Given the pepper app is running
    When I invoke the hello world API
    Then I get a successful HTTP status response
    And I receive a response of "hello world!"

  Scenario Outline: Invoke hello world API
    Given the pepper app is running
    When I invoke the hello world API with name of "<name>"
    Then I get a successful HTTP status response
    And I receive a response of "<expectedResponse>"

    Examples:
    | name | expectedResponse |
    | grasshopper | hello grasshopper! |