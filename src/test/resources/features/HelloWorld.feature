Feature: Hello World
  As an user, I want to receive a greeting

  Scenario: Invoke hello world API
    Given the pepper app is runninga
    When I invoke the hello world API
    Then I get a successful HTTP status response
