Feature: Calculate League Age
  As an user, I want to calculate league age

  Scenario Outline: Calculate league age for a player
    Given the pepper app is running
    When I invoke the league age API, on "<referenceDate>", for a player with "<dob>"
    Then I get a successful HTTP status response
    And I receive a response that the player's league age is <expectedLeagueAge>

    Examples:
      | referenceDate | dob        | expectedLeagueAge |
      | 1/1/2021      | 10/30/2006 | 14                |
      | 1/1/2021      | 04/16/2009 | 12                |
